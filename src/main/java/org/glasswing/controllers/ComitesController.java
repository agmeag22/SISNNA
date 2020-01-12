/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.glasswing.domain.Committee;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class ComitesController {
	
	static Logger log = Logger.getLogger(ComitesController.class.getName());
	
	
	
	@RequestMapping("/comites")
	public ModelAndView initMain() {
		List<Committee> lista = new ArrayList();
                Committee item;
                for(int i=0;i<10;i++){
                    item = new Committee();
                    item.setName("Comite #"+i);
                    
                    item.setIdCommittee(i);
                    item.setCreatedDate(new Date());
                    item.setUpdatedDate(new Date());
                    lista.add(item);
                    
                }
		ModelAndView mav = new ModelAndView();
                mav.addObject("lista" , lista);
		mav.setViewName("comites/index");
		return mav;
	}
	 @RequestMapping("/comites/nuevo")
	public ModelAndView crearUsuario() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("comites/nuevo");
		return mav;
	}
}