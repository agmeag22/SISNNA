/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package org.glasswing.controllers;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;
import org.glasswing.domain.Abuse;
import org.glasswing.domain.AccusedType;
import org.glasswing.domain.Committee;
import org.glasswing.domain.Complaint;
import org.glasswing.domain.ComplaintAbuses;
import org.glasswing.domain.ComplaintModifications;
import org.glasswing.domain.ComplaintPrograms;
import org.glasswing.domain.Country;
import org.glasswing.domain.Gender;
import org.glasswing.domain.Members;
import org.glasswing.domain.Priority;
import org.glasswing.domain.Program;
import org.glasswing.domain.State;
import org.glasswing.domain.User;
import org.glasswing.service.AbuseService;
import org.glasswing.service.AccusedTypeService;
import org.glasswing.service.ComplaintService;
import org.glasswing.service.CountryService;
import org.glasswing.service.GenderService;
import org.glasswing.service.ProgramService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    UserService userService;

    @RequestMapping("/denuncias/denuncias_pendientes")
    public ModelAndView pending_complaint(Principal principal) {
        ModelAndView mav = new ModelAndView();
        List complaint_list = null;
        try {
            User ux = userService.findByEmail(principal.getName());
            List<Members> members = ux.getMembersList();
            Members member = members.get(0);
            Committee comite = member.getCommittee();
            Country country = comite.getCountry();
            complaint_list = complaintService.findByStateNotAndCountry(new State(3), country);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        mav.addObject("title", "Denuncias Pendientes");
        mav.addObject("marked", "denuncias-pendientes");
        mav.addObject("lista", complaint_list);
        mav.setViewName("complaint/list_complaints");
        return mav;
    }

    @RequestMapping("/denuncias/denuncias_procesadas")
    public ModelAndView processed_complaint(Principal principal) {
        ModelAndView mav = new ModelAndView();
        List complaint_list2 = null;
        try {
                 User ux = userService.findByEmail(principal.getName());
            List<Members> members = ux.getMembersList();
            Members member = members.get(0);
            Committee comite = member.getCommittee();
            Country country = comite.getCountry();
            complaint_list2 = complaintService.findByStateAndCountry(new State(3),country);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        mav.addObject("title", "Denuncias Procesadas");
        mav.addObject("lista", complaint_list2);
        mav.addObject("marked", "denuncias-procesadas");

        mav.setViewName("complaint/list_complaints");
        return mav;
    }

    @RequestMapping("/denuncias/ver_denuncia/{id}")
    public ModelAndView view_complaint(@PathVariable("id") int id, Principal principal) {
        ModelAndView mav = new ModelAndView();
        Complaint complaint = complaintService.findOne(id);
        List<ComplaintAbuses> complaintAbuses = complaint.getComplaintAbusesList();
        List<ComplaintPrograms> complaintPrograms = complaint.getComplaintProgramsList();
        User ux = userService.findByEmail(principal.getName());
        mav.addObject("complaintAbuses", complaintAbuses);
        mav.addObject("complaintPrograms", complaintPrograms);
        mav.addObject("complaint", complaint);
        mav.addObject("user", ux);
        mav.setViewName("complaint/view_complaint");
        return mav;
    }

    @RequestMapping("/setear_resolucion/{id}")
    public ModelAndView view_complaint(Principal principal, @PathVariable("id") int id, @RequestParam String resolution) {
        ModelAndView mav = new ModelAndView();
        Complaint complaint = complaintService.findOne(id);
        complaint.setResolution(resolution);
        complaint.setState(new State(3));
        ComplaintModifications mod = new ComplaintModifications();
        mod.setComplaint(complaint);
        User ux = userService.findByEmail(principal.getName());
        mod.setUser(ux);
        List<ComplaintModifications> list = complaint.getComplaintModificationsList();
        list.add(mod);
        complaint.setComplaintModificationsList(list);
        try {
            complaintService.save(complaint);
            mav.addObject("success", "Se ha guardado correctamente ");
            mav.setViewName("redirect:/denuncias/denuncias_procesadas");
        } catch (Error e) {
            mav.addObject("error", "No se ha podido guardar");
        }
        return mav;
    }

    @RequestMapping("/cambiar_clasificacion/{id}")
    public ModelAndView view_complaint(Principal principal, @PathVariable("id") int id, @RequestParam String clasificationComment, @RequestParam int priority) {
        ModelAndView mav = new ModelAndView();
        Complaint complaint = complaintService.findOne(id);
        complaint.setClasificationComment(clasificationComment);
        complaint.setState(new State(2));
        complaint.setPriority(new Priority(priority));
        ComplaintModifications mod = new ComplaintModifications();
        mod.setComplaint(complaint);
        User ux = userService.findByEmail(principal.getName());
        mod.setUser(ux);
        List<ComplaintModifications> list = complaint.getComplaintModificationsList();
        list.add(mod);
        complaint.setComplaintModificationsList(list);
        try {
            complaintService.save(complaint);
            mav.addObject("success", "Se ha guardado correctamente ");
            mav.setViewName("redirect:/denuncias/denuncias_pendientes");
        } catch (Error e) {
            mav.addObject("error", "No se ha podido guardar");
        }

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
    public ModelAndView store_complaint(Principal principal, @ModelAttribute Complaint c) {
        if (c.getComplaintAbusesList() != null) {
            List<ComplaintAbuses> x = c.getComplaintAbusesList();
            for (ComplaintAbuses m : x) {
                m.setComplaint(c);
            }
            c.setComplaintAbusesList(x);
        }
        if (c.getComplaintProgramsList() != null) {
            List<ComplaintPrograms> y = c.getComplaintProgramsList();
            for (ComplaintPrograms m : y) {
                m.setComplaint(c);
            }
            c.setComplaintProgramsList(y);
        }
        c.setState(new State(1));
        User ux = userService.findByEmail(principal.getName());
        c.setUser(ux);
        complaintService.save(c);
        ModelAndView mav = new ModelAndView();

        if (ux.getRole().getIdRole() > 1) {
            mav.setViewName("redirect:/denuncias/denuncias_pendientes");
        } else {
            mav.setViewName("complaint/send_success");
        }
        return mav;
    }

    @RequestMapping("/denuncias/denuncia_enviada")
    public ModelAndView store_complaint(Principal principal) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("complaint/send_success");
        return mav;
    }

}
