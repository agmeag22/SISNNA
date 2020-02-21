/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.glasswing.controllers;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.glasswing.domain.User;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
@SessionAttributes({"userId","userFullName","userEmail"})
public class MainController {
    
    static Logger log = Logger.getLogger(MainController.class.getName());
    
    @Resource(name="authenticationManager")
    private AuthenticationManager authManager;
    
    @Autowired
    private UserService userServ;
    
    @RequestMapping("/")
    public ModelAndView initMain() {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login(@RequestParam(value="username") String username,@RequestParam(value="password") String password,HttpServletRequest request,Model model) {
     User ux = userServ.findByEmail(username);
        String password2 = passwordEncoder().encode(password);
        ModelAndView mav = new ModelAndView();
        //if(username.equals("usuario") && password.equals("glasswing")){
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authManager.authenticate(authReq);
        
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
       
        if(auth.isAuthenticated()){
//            auth.getDetails()
            log.info("Entrando a funcion init-min" + log.getName());
             User u = userServ.findByEmail(username);
        session.setAttribute("userId", u.getIdUser());
        session.setAttribute("userFullName", u.getPersonalInfo().getName());
        session.setAttribute("userEmail", u.getEmail());
        if(u.getRole().getName().equals("USUARIO")) mav= new ModelAndView("redirect:/denuncias/nueva_denuncia");
        else mav= new ModelAndView("redirect:/dashboard");
            
            
            
            
        }else {
            mav = new ModelAndView("redirect:" + request.getHeader("Referer"));
            mav.addObject("error", "Las credenciales son invalidas");
        }
        log.info("No se pudo realizar" + log.getName() +"u:::::::"+ username+ "p::::::"+password);
        return mav;
    }
    
    
}