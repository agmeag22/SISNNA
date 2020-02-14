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
import org.glasswing.domain.Position;
import org.glasswing.service.DepartmentService;
import org.glasswing.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class PositionController {

    static Logger log = Logger.getLogger(PositionController.class.getName());
    @Autowired
    PositionService positionService;
    DepartmentService departmentService;

    @RequestMapping("/ajustes/cargo")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<Position> position_list=positionService.getAll();
        mav.addObject("position_list", position_list);
        mav.setViewName("/settings/positions/position_view");
        return mav;
    }
    @RequestMapping(value="/ajustes/cargo/nuevo", method = RequestMethod.POST)
    public ModelAndView position_save(@RequestParam(value="name") String name) {
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
        Position position=new Position();
        position.setName(name);
        position.setCreatedDate(parsed_date);
        position.setUpdatedDate(parsed_date);
        positionService.save(position);
        mav.setViewName("redirect:/ajustes/cargo");
        return mav;
    }
    @RequestMapping(value="/ajustes/cargo/modificar", method = RequestMethod.POST)
    public ModelAndView position_update(@RequestParam(value="name") String name,@RequestParam(value="id-position") int id) {
        ModelAndView mav = new ModelAndView();
        if(positionService.findOneBoolean(id)){
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsed_date = null;
        try {
            parsed_date = sdf2.parse(date);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Position position=positionService.findOne(id);
        position.setName(name);
        position.setUpdatedDate(parsed_date);
        positionService.save(position);
        }
        mav.setViewName("redirect:/ajustes/cargo");
        return mav;
    }
}
