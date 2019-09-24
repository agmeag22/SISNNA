/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class Dashboard {
	
	static Logger log = Logger.getLogger(Dashboard.class.getName());
	
	@RequestMapping("/dashboard")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dashboard");
		return mav;
	}
}