package org.glasswing.controllers;

import java.util.List;
import org.glasswing.domain.Country;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.service.CountryDepartmentService;
import org.glasswing.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CountryDepartmentController {
    
    @Autowired
    private CountryService countryService;
     
    
    @Autowired
    private CountryDepartmentService countryDepartmentService;
    
    @RequestMapping("/paises/nueva_region")
    public ModelAndView new_country_department() {
        ModelAndView mav = new ModelAndView();

        List<Country> country_list = null;
        country_list = countryService.getAll();
        mav.addObject("country_list", country_list);
        
        mav.setViewName("country/new_country_department");
        return mav;
    }
    
    
    @RequestMapping("/deptos/guardar")
    public ModelAndView save_country_department(@RequestParam(value = "id_country") int id_country,
            @RequestParam(value = "name") String cdName) {
        ModelAndView mav = new ModelAndView();
        
        Country c = new Country();
        c.setIdCountry(id_country);
        
        CountryDepartment cd = new CountryDepartment();  
        cd.setCountry(c);
        cd.setName(cdName);
        
        
        //mav.adObject("respuesta","País ingresado");                    

        try {

            countryDepartmentService.save(cd);

        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("respuesta", "Error de conexión. No se pudo añadir departamento");
            mav.setViewName("redirect:/country/new_country_department");
            return mav;
        }
        
        
        List<Country> country_list = null;
        country_list = countryService.getAll();
        mav.addObject("country_list", country_list);
          
        mav.addObject("respuesta","Estado ingresado");                    
        mav.setViewName("country/new_country_department");
        return mav;
    }
    
    @RequestMapping("/deptos/modificar_departamentos/{id}")
    public ModelAndView updateCountryDepartment(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView();
        
//        List<Role> role_list = null;
//        List<Gender> gender_list = null;
//        List<Country> country_list = null;
//        List<Department> department_list = null;
//        role_list = roleService.getAll();
//        gender_list = genderService.getAll();
//        country_list = countryService.getAll();
//        department_list = departmentService.getAll();
//        User u = userService.findOne(id);
        
        Country c = countryService.findOne(id);
        
//        mav.addObject("department_list", department_list);
//        mav.addObject("role_list", role_list);
//        mav.addObject("gender_list", gender_list);
//        mav.addObject("country_list", country_list);
//        mav.addObject("user", u);
          mav.addObject("country",c);
        mav.setViewName("country/update_country_department");
        return mav;
    }
    
    @RequestMapping(value="/deptos/guardar_modificacion_depto/{id_country}",method = RequestMethod.POST)
    public ModelAndView modify_Country_Department(@PathVariable("id_country") int id_country,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "id_country_department") int id_country_department) {
        
        ModelAndView mav = new ModelAndView();
        Country c = countryService.findOne(id_country);
        
        CountryDepartment cd = countryDepartmentService.findOne(id_country_department);
        cd.setName(name);
        cd.setCountry(c);
        
        
        try {
            
            countryDepartmentService.save(cd);

        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("respuesta", "Error de conexión. No se pudo modificar el estado");
            mav.setViewName("country/update_country_department");
            return mav;
        }
        mav.addObject("respuesta", "Estado " + name +  " modificado con éxito");
        mav.addObject("country",c);
        mav.setViewName("country/update_country_department");
        return mav;
    }
    
}
