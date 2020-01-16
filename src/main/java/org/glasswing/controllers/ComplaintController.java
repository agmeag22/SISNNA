/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.glasswing.controllers;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.glasswing.domain.Abuse;
import org.glasswing.domain.AccusedType;
import org.glasswing.domain.Complaint;
import org.glasswing.domain.ComplaintAbuses;
import org.glasswing.domain.ComplaintPrograms;
import org.glasswing.domain.Country;
import org.glasswing.domain.Gender;
import org.glasswing.domain.Members;
import org.glasswing.domain.Program;
import org.glasswing.domain.User;
import org.glasswing.service.AbuseService;
import org.glasswing.service.AccusedTypeService;
import org.glasswing.service.ComplaintService;
import org.glasswing.service.CountryService;
import org.glasswing.service.GenderService;
import org.glasswing.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class ComplaintController {
    
    static Logger log = Logger.getLogger(ComplaintController.class.getName());
    @Autowired
            ComplaintService complaintService;
    @Autowired
            AbuseService abuseService;
    @Autowired
            AccusedTypeService accusedTypeService;
    @Autowired
            CountryService countryService;
    @Autowired
            ProgramService programService;
    @Autowired
            GenderService genderService;
    
    
    @RequestMapping("/denuncias/denuncias_pendientes")
    public ModelAndView pending_complaint() {
        ModelAndView mav = new ModelAndView();
        List complaint_list = null;
        try {
            complaint_list = complaintService.getAll();
        } catch (Exception e) {
        }
        mav.addObject("lista", complaint_list);
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
        List<Abuse> abuseList = abuseService.getAll();
        List<AccusedType> accusedList = accusedTypeService.getAll();
        List<Country> countryList = countryService.getAll();
        List<Program> programList = programService.getAll();
        List<Gender> genderList = genderService.getAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("abuseList", abuseList);
        mav.addObject("accusedList", accusedList);
        mav.addObject("countryList", countryList);
        mav.addObject("programList", programList);
        mav.addObject("genderList", genderList);
        mav.setViewName("complaint/new_complaint");
        return mav;
    }
    
    @RequestMapping("/denuncias/store")
    public ModelAndView store_complaint(@ModelAttribute Complaint c) {
        
        
        List<ComplaintAbuses> x =c.getComplaintAbusesList();
        for (ComplaintAbuses m:x) {
            m.setComplaint(c);
        }
        c.setComplaintAbusesList(x);
        
        List<ComplaintPrograms> y =c.getComplaintProgramsList();
        for (ComplaintPrograms m:y) {
            m.setComplaint(c);
        }
        c.setComplaintProgramsList(y);
        c.setUpdatedDate(new Date());
        c.setCreatedDate(new Date());
        User u = new User(1);
        c.setUser(u);
        c.setIsRecurrence(true);
        complaintService.save(c);
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("redirect:/denuncias/denuncias_pendientes");
        return mav;
    }
    
}
