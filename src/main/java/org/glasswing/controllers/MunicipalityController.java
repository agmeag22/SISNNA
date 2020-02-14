
package org.glasswing.controllers;

import java.util.List;
import org.glasswing.domain.Country;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Municipality;
import org.glasswing.service.CountryDepartmentService;
import org.glasswing.service.CountryService;
import org.glasswing.service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MunicipalityController {
    
    @Autowired
    private CountryService countryService;
     
    @Autowired
    private CountryDepartmentService countryDepartmentService;
    
    @Autowired
    private MunicipalityService municipalityService;
       
    @RequestMapping("/paises/nuevo_municipio")
    public ModelAndView new_municipality() {
        ModelAndView mav = new ModelAndView();

        List<Country> country_list = null;
        country_list = countryService.getAll();
        mav.addObject("country_list", country_list);
        
        mav.setViewName("country/new_municipality");
        return mav;
    }
    
    
    @RequestMapping("/muni/guardar")
    public ModelAndView save_municipality(@RequestParam(value = "id_country") int id_country,
            @RequestParam(value = "id_country_department") int id_country_department,
            @RequestParam(value = "name") String munName) {
        ModelAndView mav = new ModelAndView();
        
        Country c = new Country();
        c.setIdCountry(id_country);
        
        CountryDepartment cd = new CountryDepartment();  
        cd.setCountry(c);
        cd.setIdCountryDepartment(id_country_department);
        
        
        Municipality mun = new Municipality();
        mun.setCountryDepartment(cd);
        mun.setName(munName);
        
        
        //mav.adObject("respuesta","País ingresado");                    

        try {

            municipalityService.save(mun);

        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("respuesta", "Error de conexión. No se pudo añadir municipio");
            mav.setViewName("redirect:/country/new_municipality");
            return mav;
        }
        
        
        List<Country> country_list = null;
        country_list = countryService.getAll();
        mav.addObject("country_list", country_list);
                
        mav.addObject("respuesta","Muncipio ingresado");                    
        mav.setViewName("country/new_municipality");
        return mav;
    }
    
    @RequestMapping("/municipios/modificar_municipios/{id}")
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
        mav.setViewName("country/update_municipality");
        return mav;
    }
    
    @RequestMapping(value="/muni/guardar_modificacion_muni/{id_country}",method = RequestMethod.POST)
    public ModelAndView modify_Country_Department(@PathVariable("id_country") int id_country,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "id_municipality") int id_municipality,
            @RequestParam(value = "id_country_department") int id_country_department) {
        
        ModelAndView mav = new ModelAndView();
        Country c = countryService.findOne(id_country);
        
        CountryDepartment cd = countryDepartmentService.findOne(id_country_department);
        //cd.setName(name);
        //cd.setCountry(c);
        
        Municipality mun = municipalityService.findOne(id_municipality);
        mun.setName(name);
        mun.setCountryDepartment(cd);
        
        
        try {
            
            municipalityService.save(mun);

        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("respuesta", "Error de conexión. No se pudo modificar muncipio");
            mav.setViewName("country/update_municipality");
            return mav;
        }
        mav.addObject("respuesta", "Municipio " + name + " del estado " + cd.getName() + " modificado con éxito");
        mav.addObject("country",c);
        mav.setViewName("country/update_municipality");
        return mav;
    }
    
}
