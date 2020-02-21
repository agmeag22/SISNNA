/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.glasswing.domain.Country;
import org.glasswing.domain.Department;
import org.glasswing.domain.Gender;
import org.glasswing.domain.Position;
import org.glasswing.domain.Role;
import org.glasswing.domain.User;
import org.glasswing.service.CountryDepartmentService;
import org.glasswing.service.CountryService;
import org.glasswing.service.DepartmentService;
import org.glasswing.service.GenderService;
import org.glasswing.service.MunicipalityService;
import org.glasswing.service.PositionService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class SignUpController {
 
	static Logger log = Logger.getLogger(MainController.class.getName());
            
	@Autowired
	private UserService userService;
        
        @Autowired
	private CountryDepartmentService cdServ;
        
        @Autowired
	private MunicipalityService mService;
        
        @Autowired
	private GenderService genderService;
        
        @Autowired
	private DepartmentService departmentService;
        
        @Autowired
	private PositionService positionService;
        
        @Autowired
	private CountryService countryService;
      	
        public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@RequestMapping(value="/registrar")
	public ModelAndView signUp() {
		ModelAndView mav = new ModelAndView();
                List<Gender> gen = genderService.getAll();
                List<Department> dept = departmentService.getAll();
                List<Position> pos = positionService.getAll();
                List<Country> co = countryService.getAll();

                mav.addObject("genders" , gen);
                mav.addObject("departments" , dept);
                mav.addObject("positions" , pos);
                mav.addObject("country_list" , co);
                
		mav.setViewName("sign_up");
		return mav;
	}
        
        @RequestMapping(value="/sign-in")
	public ModelAndView signUser(@ModelAttribute User u) {
		ModelAndView mav = new ModelAndView();  
                String pass = u.getPassword();
                u.setPassword(bCryptPasswordEncoder().encode(pass));
                Role role = new Role();
                role.setIdRole(1);
                role.setName("USUARIO");
                u.setRole(role);
                u.setActiveState(0);
                u.setCreatedDate(new Date());
                u.setUpdatedDate(new Date());
                mav.addObject("respuesta","Usuario Registrado");                    
                userService.save(u);
                List<Gender> gen = genderService.getAll();
                List<Department> dept = departmentService.getAll();
                List<Country> co = countryService.getAll();
                List<Position> pos = positionService.getAll();
                mav.addObject("positions" , pos);
                mav.addObject("genders" , gen);
                mav.addObject("departments" , dept);
                mav.addObject("country_list" , co);
		mav.setViewName("sign_up");
		return mav;
	}
}   
