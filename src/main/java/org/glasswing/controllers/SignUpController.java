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
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Department;
import org.glasswing.domain.Gender;
import org.glasswing.domain.Municipality;
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
	private CountryService countryService;
      	
	
	@RequestMapping(value="/registrar")
	public ModelAndView signUp() {
		
		ModelAndView mav = new ModelAndView();
                
//                List<CountryDepartment> cdepts = cdServ.getAll();
//                List<Municipality> mun = mService.getAll();
                List<Gender> gen = genderService.getAll();
                List<Department> dept = departmentService.getAll();
                List<Country> co = countryService.getAll();
                //mav.addObject("country_list_department_id" , cdepts);
                //mav.addObject("country_list_department_municipality_id" , mun);
                mav.addObject("genders" , gen);
                mav.addObject("departments" , dept);
                mav.addObject("country_list" , co);
                
		mav.setViewName("sign_up");
		return mav;
	}
        
        @RequestMapping(value="/sign-in")
	public ModelAndView signUser(@ModelAttribute User u) {
		//(@RequestParam(value="username") String username,@RequestParam(value="password") String password,HttpServletRequest request)
		ModelAndView mav = new ModelAndView();
                
                Role role = new Role();
                role.setIdRole(1);
                role.setName("USUARIO");
                u.setRole(role);
                u.setActiveState(0);
                u.setCreatedDate(new Date());
                u.setUpdatedDate(new Date());
                /*
                Country c = new Country();
                c.setCode("222");
                c.setIdCountry(68);
                c.setIso3166a1("SV");
                c.setIso3166a2("SLV");
                c.setName("El Salvador");
                
                PersonalInfo pf = new PersonalInfo();
                pf.setCountry(c);
                
                u.setPersonalInfo(pf);
                */
                mav.addObject("respuesta","Usuario Registrado");                    
                
             
                    userService.save(u);

                
               
//                List<CountryDepartment> cdepts = cdServ.getAll();
//                List<Municipality> mun = mService.getAll();
                List<Gender> gen = genderService.getAll();
                List<Department> dept = departmentService.getAll();
                List<Country> co = countryService.getAll();
//                mav.addObject("countryDepartments" , cdepts);
//                mav.addObject("municipalities" , mun);
                mav.addObject("genders" , gen);
                mav.addObject("departments" , dept);
                mav.addObject("country_list" , co);
                
		mav.setViewName("sign_up");
		return mav;
	}
        
        //Selectionbox control in UserController
        
        /*
        @RequestMapping(value="/contrasena_olvidada")
	public ModelAndView forgottenPassword() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forgotten_password");
		return mav;
	}
        
        @RequestMapping(value="/pedir_contrasena")
	public ModelAndView recuperatePassword(@RequestParam(value="email") String email) {
		
		ModelAndView mav = new ModelAndView();
                
                User u= userService.findByEmail(email);
                
                if(!(u==null)){
                    
                    //enviar codigo de recuperacion
                    mav.addObject("respuesta","Se ha enviado un codigo de recuperacion al correo " + email);                    
                }else {
                    mav.addObject("respuesta","Ese correo no existe");                    
                }
                
		mav.setViewName("forgotten_password");
		return mav;
	}*/
}   

