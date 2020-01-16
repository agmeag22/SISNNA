/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import org.glasswing.domain.Committee;
import org.glasswing.domain.Country;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Department;
import org.glasswing.domain.Gender;
import org.glasswing.domain.Members;
import org.glasswing.domain.Municipality;
import org.glasswing.domain.PersonalInfo;
import org.glasswing.domain.Role;
import org.glasswing.domain.User;
import org.glasswing.service.CountryDepartmentService;
import org.glasswing.service.CountryService;
import org.glasswing.service.DepartmentService;
import org.glasswing.service.GenderService;
import org.glasswing.service.MunicipalityService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	
            
	@Autowired
	private UserService userServ;
        
        @Autowired
	private CountryDepartmentService countryDepartmentServ;
        
        @Autowired
	private MunicipalityService munServ;
        
        @Autowired
	private GenderService genServ;
        
        @Autowired
	private DepartmentService deptServ;
	@RequestMapping("/")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username") String username,@RequestParam(value="password") String password,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
                //if(username.equals("usuario") && password.equals("glasswing")){
		if(userServ.findOneUser(username, password)) {
			log.info("Entrando a funcion init-min" + log.getName());    
			mav= new ModelAndView("redirect:/dashboard");
		}else {
			mav = new ModelAndView("redirect:" + request.getHeader("Referer"));
                        mav.addObject("error", "Las credenciales son invalidas");
		}
			log.info("No se pudo realizar" + log.getName() +"u:::::::"+ username+ "p::::::"+password);
		return mav; 
	}
	
	
	@RequestMapping(value="/registrar")
	public ModelAndView signUp() {
		
		ModelAndView mav = new ModelAndView();
                
                
                List<CountryDepartment> cdepts = countryDepartmentServ.getAll();
                List<Municipality> mun = munServ.getAll();
                List<Gender> gen = genServ.getAll();
                List<Department> dept = deptServ.getAll();
                mav.addObject("countryDepartments" , cdepts);
                mav.addObject("municipalities" , mun);
                mav.addObject("genders" , gen);
                mav.addObject("departments" , dept);
                                
		mav.setViewName("sign_up");
		return mav;
	}
        
        @RequestMapping(value="/signUser")
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ModelAndView signUser(@ModelAttribute User u) {
		//(@RequestParam(value="username") String username,@RequestParam(value="password") String password,HttpServletRequest request)
		ModelAndView mav = new ModelAndView();
                
                userServ.save(u);
	
		mav.setViewName("sign_up");
		return mav;
	}
        
        
        @RequestMapping(value="/contrasena_olvidada")
	public ModelAndView forgottenPassword() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forgotten_password");
		return mav;
	}
        
	
	
	
	
	
}