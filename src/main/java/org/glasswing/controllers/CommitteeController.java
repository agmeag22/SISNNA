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
import org.glasswing.service.CommitteeService;
import org.glasswing.service.CountryService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class CommitteeController {
	
    @Autowired
	private CommitteeService committeeServ;
    @Autowired
	private CountryService countryServ;
    static Logger log = Logger.getLogger(CommitteeController.class.getName());
	
	
	
	@RequestMapping("/comites/inicio_comites")
	public ModelAndView initMain() {
		List<Committee> lista = committeeServ.getAll();
		ModelAndView mav = new ModelAndView();
                mav.addObject("list" , lista);
		mav.setViewName("committee/committee_list");
		return mav;
	}
	 @RequestMapping("/comites/nuevo_comite")
	public ModelAndView new_committee() {
		ModelAndView mav = new ModelAndView();
                List<Committee> lista = committeeServ.getAll();
                mav.addObject("list" , lista);
		mav.setViewName("committee/new_committee");
		return mav;
	}
        
        @RequestMapping("/comites/store")
	public ModelAndView store_committee() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("committee/new_committee");
		return mav;
	}
}