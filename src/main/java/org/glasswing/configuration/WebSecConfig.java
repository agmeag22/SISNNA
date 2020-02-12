/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.glasswing.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService userDetails;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }
    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/contrasena_olvidada**").permitAll()
                .antMatchers("/pedir_contrasena**").permitAll()
                .antMatchers("/denuncias/denuncias_pendientes").hasAnyAuthority("ADMINISTRADOR", "PUNTO DE CONTROL","MIEMBRO DE COMITE")
                .antMatchers("/denuncias/denuncias_procesadas").hasAnyAuthority("ADMINISTRADOR", "PUNTO DE CONTROL","MIEMBRO DE COMITE")
                .antMatchers("/denuncias/ver_denuncia/**").hasAnyAuthority("ADMINISTRADOR", "PUNTO DE CONTROL","MIEMBRO DE COMITE")    
                .antMatchers("/denuncias/store/**").permitAll()
                .antMatchers("/denuncias/nueva_denuncia").permitAll()                        
                .antMatchers("/dashboard/**").hasAnyAuthority("ADMINISTRADOR", "PUNTO DE CONTROL","MIEMBRO DE COMITE")
                .antMatchers("/usuarios/**").hasAuthority("ADMINISTRADOR")
                .antMatchers("/comites/**").hasAuthority("ADMINISTRADOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();
        
    }
}

