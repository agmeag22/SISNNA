/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.util.List;
import java.util.logging.Logger;
import org.glasswing.service.CommitteeService;
import org.glasswing.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class ComplaintController {

    static Logger log = Logger.getLogger(ComplaintController.class.getName());
    @Autowired
    ComplaintService complaintService;

    @RequestMapping("/denuncias/denuncias_pendientes")
    public ModelAndView pending_complaint() {
        ModelAndView mav = new ModelAndView();
        List complaint_list = null;
        try {
            complaint_list = complaintService.getAll();
        } catch (Exception e) {
        }
        mav.addObject("list", complaint_list);
        mav.setViewName("complaint/pending_complaints");
        return mav;
    }

    @RequestMapping("/denuncias/denuncias_procesadas")
    public ModelAndView processed_complaint() {
        ModelAndView mav = new ModelAndView(); 
        List complaint_list = null;
        try {
            complaint_list = complaintService.getAll();
        } catch (Exception e) {
        }
        mav.addObject("list", complaint_list);
        
        mav.setViewName("complaint/processed_complaints");
        return mav;
    }

    @RequestMapping("/denuncias/nueva_denuncia")
    public ModelAndView new_complaint() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("complaint/new_complaint");
        return mav;
    }

}
