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
import org.glasswing.domain.Country;
import org.glasswing.domain.Members;
import org.glasswing.domain.Role;
import org.glasswing.domain.User;
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
    @Autowired
	private UserService userServ;
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
                List<Country> paises = countryServ.findNotUsedCountries();
                Role admin = new Role();
                admin.setIdRole(4);
                List<User> usuarios = userServ.findByIdRoleNot(admin);
                mav.addObject("countries" , paises);
                mav.addObject("usuarios" , usuarios);
		mav.setViewName("committee/new_committee");
		return mav;
	}
        
        @RequestMapping("/comites/store")
	public ModelAndView store_committee(@RequestParam String name,@RequestParam int idCountry,@RequestParam String miembros,@RequestParam Integer puntoC) {
                Committee c = new Committee();
                Country co = new Country();
                Date now = new Date();
                co.setIdCountry(idCountry);
                c.setCountry(co);
                c.setName(name);
                c.setUpdatedDate(now);
                c.setCreatedDate(now);
                List<Members> membersList = new ArrayList<Members>();
                
                miembros = miembros.replace("[", "");
                miembros = miembros.replace("]", "");
                String[] mList = miembros.split(",");
                for (String mList1 : mList) {
                    Integer id = Integer.parseInt(mList1);
                    User u = new User();
                    u.setIdUser(id);
                    Members m = new Members();
                    m.setUser(u);
                    m.setCommittee(c);
                    Role role = new Role();
                    role.setIdRole(3);
                    m.setRole(role);
                    membersList.add(m);
                }
                User u = new User();
                u.setIdUser(puntoC);
                Members m = new Members();
                m.setUser(u);
                m.setCommittee(c);
                Role role = new Role();
                role.setIdRole(2);
                m.setRole(role);
                membersList.add(m);
                c.setMembersList(membersList);
                committeeServ.save(c);
		ModelAndView mav = new ModelAndView("redirect:/comites/inicio_comites");
		return mav;
	}
}