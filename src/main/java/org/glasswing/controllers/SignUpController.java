/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.glasswing.domain.Country;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Department;
import org.glasswing.domain.Gender;
import org.glasswing.domain.Municipality;
import org.glasswing.domain.PersonalInfo;
import org.glasswing.domain.Position;
import org.glasswing.domain.Role;
import org.glasswing.domain.User;
import org.glasswing.service.CountryDepartmentService;
import org.glasswing.service.CountryService;
import org.glasswing.service.DepartmentService;
import org.glasswing.service.GenderService;
import org.glasswing.service.MunicipalityService;
import org.glasswing.service.PersonalInfoService;
import org.glasswing.service.PositionService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        
        @Autowired
	private PositionService positionService;
        
        @Autowired
	private PersonalInfoService personalInfoServ;
      	
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
	
	@RequestMapping(value="/registrar")
	public ModelAndView signUp() {
		
		ModelAndView mav = new ModelAndView();
                
                List<CountryDepartment> cdepts = cdServ.getAll();
                List<Municipality> mun = mService.getAll();
                List<Gender> gen = genderService.getAll();
                List<Department> dept = departmentService.getAll();
                List<Country> co = countryService.getAll();
                List<Position> po = positionService.getAll();
                //mav.addObject("country_list_department_id" , cdepts);
                //mav.addObject("country_list_department_municipality_id" , mun);
                mav.addObject("genders" , gen);
                mav.addObject("departments" , dept);
                mav.addObject("country_list" , co);
                mav.addObject("positions" , po);
                
		mav.setViewName("sign_up");
		return mav;
	}
        
        @RequestMapping(value="/signUser")
	public ModelAndView signUser(@ModelAttribute User u) {
		//(@RequestParam(value="username") String username,@RequestParam(value="password") String password,HttpServletRequest request)
		ModelAndView mav = new ModelAndView();
                
                Role role = new Role();
                role.setIdRole(1);
                role.setName("USUARIO");
                u.setRole(role);
                u.setActiveState(0);
                
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
                
                
                try {

                    userService.save(u);

                } catch (Exception e) {
                    e.printStackTrace();
                    mav.addObject("respuesta", "Error de conexión. No se pudo añadir usuario");
                    mav.setViewName("redirect:/usuarios/inicio_usuarios");
                    return mav;
                }
                mav.addObject("respuesta","Usuario Registrado");  
                
        List<CountryDepartment> cdepts = cdServ.getAll();
        List<Municipality> mun = mService.getAll();
        List<Gender> gen = genderService.getAll();
        List<Department> dept = departmentService.getAll();
        List<Country> co = countryService.getAll();
        List<Position> po = positionService.getAll();
        mav.addObject("positions" , po);
        mav.addObject("countryDepartments" , cdepts);
        mav.addObject("municipalities" , mun);
        mav.addObject("genders" , gen);
        mav.addObject("departments" , dept);
        mav.addObject("country_list" , co);

        mav.setViewName("sign_up");
        return mav;
	}
        
        @RequestMapping("/country_reg/{id}")
    public @ResponseBody
    HashMap<Integer, String> getDepartmentsOfCountryByIDReg(@PathVariable("id") int id) {
        Country c = countryService.findOne(id);
        List<CountryDepartment> list = cdServ.findByCountry(c);
        HashMap<Integer, String> hm = new HashMap();
        for (CountryDepartment item : list) {
            hm.put(item.getIdCountryDepartment(), item.getName());
        }
        return hm;
    }

    @RequestMapping("/department_reg/{id}")
    public @ResponseBody
    HashMap<Integer, String> getMunicipalityOfDepartmentsByIDReg(@PathVariable("id") int id) {
        CountryDepartment c = cdServ.findOne(id);
        List<Municipality> list = mService.findByCountryDepartment(c);
        HashMap<Integer, String> hm = new HashMap();
        for (Municipality item : list) {
            hm.put(item.getIdMunicipality(), item.getName());
        }
        return hm;

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

