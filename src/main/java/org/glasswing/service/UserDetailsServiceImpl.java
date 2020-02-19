/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.glasswing.domain.User;
import org.glasswing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usuarios;

    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {

        User usr = usuarios.findByEmail(string);
        
        List<SimpleGrantedAuthority> auths = new ArrayList();
        String rol = usr.getRole().getName();
        auths.add(new SimpleGrantedAuthority(rol));
        return new org.springframework.security.core.userdetails.User(usr.getEmail(), usr.getPassword(), auths);
    }
    
    
}

