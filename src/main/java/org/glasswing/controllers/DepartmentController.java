/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.glasswing.domain.Department;
import org.glasswing.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class DepartmentController {

    static Logger log = Logger.getLogger(DepartmentController.class.getName());
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/ajustes/departamento")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<Department> department_list=departmentService.getAll();
        mav.addObject("department_list", department_list);
        mav.setViewName("/settings/departments/department_view");
        return mav;
    }
    @RequestMapping(value="/ajustes/departamento/nuevo", method = RequestMethod.POST)
    public ModelAndView department_save(@RequestParam(value="name") String name) {
        ModelAndView mav = new ModelAndView();
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsed_date = null;
        try {
            parsed_date = sdf2.parse(date);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Department department=new Department();
        department.setName(name);
        department.setCreatedDate(parsed_date);
        department.setUpdatedDate(parsed_date);
        departmentService.save(department);
        mav.setViewName("redirect:/ajustes/departamento");
        return mav;
    }
    @RequestMapping(value="/ajustes/departamento/modificar", method = RequestMethod.POST)
    public ModelAndView department_update(@RequestParam(value="name") String name,@RequestParam(value="id-department") int id) {
        ModelAndView mav = new ModelAndView();
        if(departmentService.findOneBoolean(id)){
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsed_date = null;
        
        try {
            parsed_date = sdf2.parse(date);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Department department=departmentService.findOne(id);
        department.setName(name);
        department.setUpdatedDate(parsed_date);
        departmentService.save(department);
        }
        mav.setViewName("redirect:/ajustes/departamento");
        return mav;
    }
}
