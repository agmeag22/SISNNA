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
        public ModelAndView signUser(@RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastname,
            @RequestParam(value = "birthDate") String birthDate,
            @RequestParam(value = "idGender") int idGender,
            @RequestParam(value = "id_country") int id_country,
            @RequestParam(value = "id_country_department") int id_country_department,
            @RequestParam(value = "id_municipality") int id_municipality,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "department") int idDepartment,
            @RequestParam(value = "id_position") int idPosition) {
	//public ModelAndView signUser(@ModelAttribute User u) {
		//(@RequestParam(value="username") String username,@RequestParam(value="password") String password,HttpServletRequest request)
        ModelAndView mav = new ModelAndView();
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date birthdate = null;
        Date parsed_date = null;
        try {
            birthdate = sdf.parse(birthDate);
            parsed_date = sdf2.parse(date);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Country c = new Country();
        c.setIdCountry(id_country);
        CountryDepartment countryDepartment = new CountryDepartment();
        countryDepartment.setIdCountryDepartment(id_country_department);
        Municipality municipality = new Municipality();
        municipality.setIdMunicipality(id_municipality);
        Role r = new Role();
        r.setIdRole(1);
        Gender g = new Gender();
        g.setIdGender(idGender);
        Department department = new Department();
        department.setIdDepartment(idDepartment);

        Position p = new Position();
        p.setIdPosition(idPosition);
        
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName(name + " " + lastname);

        personalInfo.setGender(g);
        personalInfo.setBirthDate(birthdate);
        personalInfo.setCreatedDate(parsed_date);
        personalInfo.setUpdatedDate(parsed_date);
        personalInfo.setCountry(c);
        personalInfo.setCountryDepartment(countryDepartment);
        personalInfo.setMunicipality(municipality);

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder().encode(password));
        user.setDepartment(department);
        user.setRole(r);
        user.setPersonalInfo(personalInfo);
        user.setCreatedDate(parsed_date);
        user.setUpdatedDate(parsed_date);
        user.setActiveState(0);
        user.setPosition(p);
        
                
        try {
            personalInfoServ.save(personalInfo);
            userService.save(user);

        } catch (Exception e) {
            mav.addObject("respuesta", "Error de conexión. No se pudo añadir usuario");
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
        
        
        
}   

