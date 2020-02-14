/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.util.List;
import org.glasswing.domain.Country;
import org.glasswing.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DMNGZ
 */

@Controller
public class CountryController {
    
    @Autowired
    private CountryService countryService;
      	
    
    @RequestMapping("/paises/nuevo")
    public ModelAndView new_country() {
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("country/new_country");
        return mav;
    }
    
    @RequestMapping("/paises/guardar")
    public ModelAndView save_country(@ModelAttribute Country c) {
        ModelAndView mav = new ModelAndView();
        
        
        mav.addObject("respuesta","País ingresado");                    

        try {

            countryService.save(c);

        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("respuesta", "Error de conexión. No se pudo añadir país");
            mav.setViewName("redirect:/country/new_country");
            return mav;
        }
                
        
        mav.setViewName("country/new_country");
        return mav;
    }
    
            
    @RequestMapping("/paises/listado_paises")
        public ModelAndView country_list() {
        ModelAndView mav = new ModelAndView();
        
        List<Country> country_list = null;
        try {
            if (countryService.getAll() != null) {
                country_list = countryService.getAll();
            }
        } catch (Exception e) {
            return new ModelAndView("redirect:/usuarios/inicio_usuarios");
        }
        mav.addObject("list", country_list);
        
        mav.setViewName("country/country_list");
        return mav;
    }
    
        
    @RequestMapping("/paises/modificar_paises/{id}")
    public ModelAndView updateCountry(@PathVariable("id") int id) {
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
        mav.setViewName("country/update_country");
        return mav;
    }
    
    @RequestMapping(value="/paises/guardar_modificacion_pais/{id_country}",method = RequestMethod.POST)
    public ModelAndView modify_Country(@PathVariable("id_country") int id_country,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "code") String code,
            @RequestParam(value = "iso3166a1") String iso3166a1,
            @RequestParam(value = "iso3166a2") String iso3166a2) {
        
        ModelAndView mav = new ModelAndView();
        Country c = countryService.findOne(id_country);
        c.setName(name);
        c.setIso3166a1(iso3166a1);
        c.setIso3166a2(iso3166a2);
        c.setCode(code);
                
        try {
            
            countryService.save(c);

        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("respuesta", "Error de conexión. No se pudo guardar pais");
            mav.setViewName("redirect:/paises/listado_paises");
            return mav;
        }
        mav.addObject("respuesta", "Pais modificado con éxito");
        mav.setViewName("redirect:/paises/listado_paises");
        return mav;
    }
    
    
    
    
}
