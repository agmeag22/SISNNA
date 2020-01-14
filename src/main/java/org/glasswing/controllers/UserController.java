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
import org.glasswing.domain.Role;
import org.glasswing.domain.User;
import org.glasswing.service.CountryDepartmentService;
import org.glasswing.service.CountryService;
import org.glasswing.service.DepartmentService;
import org.glasswing.service.GenderService;
import org.glasswing.service.MunicipalityService;
import org.glasswing.service.RoleService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class UserController {

    static Logger log = Logger.getLogger(UserController.class.getName());
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CountryService countryService;
    @Autowired
    CountryDepartmentService cdServ;
    @Autowired
    MunicipalityService mService;
    @Autowired
    GenderService genderService;
    @Autowired
    RoleService roleService;

// static List<InfoUsuario> list = new ArrayList<InfoUsuario>();
    @RequestMapping("/usuarios/inicio_usuarios")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<User> user_list = null;
        try {
            if (userService.getAll() != null) {
                user_list = userService.getAll();
            }
        } catch (Exception e) {
            return new ModelAndView("redirect:/usuarios/inicio_usuarios");
        }
        mav.addObject("list", user_list);
        mav.setViewName("user/user_list");
        return mav;
    }

    @RequestMapping(value = "/usuarios/nuevo")
    public ModelAndView newUserView() {
        ModelAndView mav = new ModelAndView();
        List<Role> role_list = null;
        List<Gender> gender_list = null;
        List<Country> country_list = null;
        List<Department> department_list = null;
        role_list = roleService.getAll();
        gender_list = genderService.getAll();
        country_list = countryService.getAll();
        mav.addObject("role_list", role_list);
        mav.addObject("gender_list", gender_list);
        mav.addObject("country_list", country_list);
        mav.setViewName("user/new_user");
        return mav;
    }

    @RequestMapping("/usuarios/modificar_usuario")
    public ModelAndView updateUser(@RequestParam(value = "userNumber") int number) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/update_user");
        return mav;
    }

    @RequestMapping(value = "/usuarios/guardar", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastname,
            @RequestParam(value = "birthDate") String birthDate,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "guardian_name") String guardianName,
            @RequestParam(value = "guardian_contact") String guardianContact,
            @RequestParam(value = "idGender") int idGender,
            @RequestParam(value = "id_country") int id_country,
            @RequestParam(value = "id_country_department") int id_country_department,
            @RequestParam(value = "id_municipality") int id_municipality,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "role") int role
//            @RequestParam(value = "department") int department,
//            @RequestParam(value = "committee") String committee
    ) {
        ModelAndView mav = new ModelAndView();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String date = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date());
      
        Date birthdate = null;
        try {
            birthdate = sdf.parse(birthDate);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        CountryDepartment department1 = new CountryDepartment();
        department1.setIdCountryDepartment(id_country_department);
        Municipality municipality = new Municipality();
        municipality.setIdMunicipality(id_municipality);
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName(name + " " + lastname);
        personalInfo.setGuardianName(guardianName);
        personalInfo.setGuardianContact(guardianContact);
        Gender g = new Gender();
        g.setIdGender(idGender);
        personalInfo.setGender(g);
        personalInfo.setBirthDate(birthdate);
        Country c = new Country(id_country);
        personalInfo.setCountry(c);
        personalInfo.setCountryDepartment(department1);
        personalInfo.setMunicipality(municipality);
        User user = new User();
//        Department d = new Department();
//        d.setIdDepartment(department);
//        user.setDepartment(d);
        user.setEmail(email);
        user.setPassword(password);
        Role r = new Role();
        r.setIdRole(role);
        user.setRole(r);
        user.setPersonalInfo(personalInfo);
//        try {
            userService.save(user);
//        } catch (Exception e) {
//            mav.addObject("respuesta", "Error de conexión. No se pudo añadir usuario");
//        }

        mav.addObject("respuesta", "Usuario añadido con éxito");
        mav.setViewName("user/user_list");
        return mav;
    }

    @RequestMapping("/usuarios/modificados")
    public ModelAndView modify(@RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastname,
            @RequestParam(value = "birthDate") Date birthDate,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "guardianName") String guardianName,
            @RequestParam(value = "guardianContact") String guardianContact,
            @RequestParam(value = "idGender") String idGender,
            @RequestParam(value = "id_country") String id_country,
            @RequestParam(value = "id_country_department") String id_country_department,
            @RequestParam(value = "id_municipality") String id_municipality,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "role") String role,
            @RequestParam(value = "department") String department,
            @RequestParam(value = "committee") String committee) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("usuarios/modificar");
        return mav;
    }

    @RequestMapping("/usuarios/eliminar") //Borrar usuario.
    public ModelAndView eliminarUsuario(@RequestParam(value = "userNumber") int number) {

        ModelAndView mav = new ModelAndView();

        mav.setViewName("user/user_list");
        return mav;
    }
    
    @RequestMapping("/country/{id}") 
    public @ResponseBody HashMap<Integer,String> getDepartmentsOfCountryByID(@PathVariable("id") int id) {
            Country c = countryService.findOne(id);
            List<CountryDepartment> list =  cdServ.findByCountry(c);
            HashMap<Integer,String> hm = new HashMap();
            for(CountryDepartment item:list){
                hm.put(item.getIdCountryDepartment(),item.getName());
            }
            return hm;
    }
    @RequestMapping("/department/{id}") 
    public @ResponseBody HashMap<Integer,String> getMunicipalityOfDepartmentsByID(@PathVariable("id") int id) {
            CountryDepartment c = cdServ.findOne(id);
            List<Municipality> list = mService.findByCountryDepartment(c);
             HashMap<Integer,String> hm = new HashMap();
            for(Municipality item:list){
                hm.put(item.getIdMunicipality(),item.getName());
            }
            return hm;
            
    }

}
