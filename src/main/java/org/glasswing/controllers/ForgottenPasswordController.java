/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.glasswing.domain.Country;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Department;
import org.glasswing.domain.Gender;
import org.glasswing.domain.Members;
import org.glasswing.domain.Municipality;
import org.glasswing.domain.PersonalInfo;
import org.glasswing.domain.Role;
import org.glasswing.domain.User;
import org.glasswing.service.CountryDepartmentService;
import org.glasswing.service.CountryService;
import org.glasswing.service.DepartmentService;
import org.glasswing.service.GenderService;
import org.glasswing.service.MunicipalityService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class ForgottenPasswordController {
//    
        static String emailToRecipient, emailSubject, emailMessage;
        static final String emailFromRecipient = "erkexami@gmail.com";
    
    	@Autowired
	private UserService userService;
        
        @Autowired
        private JavaMailSender mailSenderObj;

        @RequestMapping(value="/contrasena_olvidada")
           public ModelAndView forgottenPassword() {

                   ModelAndView mav = new ModelAndView();
                   mav.setViewName("forgotten_password");
                   return mav;
           }
//           
//           
//
           @RequestMapping(value="/pedir_contrasena", method = RequestMethod.POST)
           public ModelAndView recuperatePassword(@RequestParam(value="email") String email) {

                   ModelAndView mav = new ModelAndView();

                   User u= userService.findByEmail(email);

                   if(!(u==null)){
                       

                        
                       //What happens when you ask for password?
                       //Generate recuperation code
                       //Give it to the user
                       //He uses it to get his password back, modify the user
                       
                       

                    // Reading Email Form Input Parameters      
                    emailSubject = "Recuperacion contraseña Glasswings";
                    emailMessage = "Este mensaje es para recuperar la contraseña del correo " + email;
                    emailToRecipient = email;

                    // Logging The Email Form Parameters For Debugging Purpose
                    System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");   


                    mailSenderObj.send(new MimeMessagePreparator() {
                        public void prepare(MimeMessage mimeMessage) throws Exception {

                            MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");             
                            mimeMsgHelperObj.setTo(emailToRecipient);
                            mimeMsgHelperObj.setFrom(emailFromRecipient);               
                            mimeMsgHelperObj.setText(emailMessage);
                            mimeMsgHelperObj.setSubject(emailSubject);


                        }
                    });

                    //enviar codigo de recuperacion


                    System.out.println("\nMessage Send Successfully.... Hurrey!\n");




                        mav.addObject("respuesta","Se ha enviado un codigo de recuperacion al correo " + email);                    
                    }else {
                        mav.addObject("respuesta","Ese correo no existe");                    
                    }

                    mav.setViewName("forgotten_password");
                    return mav;
           }
//           
//           /*
//            // This Method Is Used To Prepare The Email Message And Send It To The Client
//            @RequestMapping(value = "sendEmail", method = RequestMethod.POST)
//            public ModelAndView sendEmailToClient(HttpServletRequest request, final @RequestParam CommonsMultipartFile attachFileObj) {
//
//                // Reading Email Form Input Parameters      
//                
//                mailSenderObj.send(new MimeMessagePreparator() {
//                    public void prepare(MimeMessage mimeMessage) throws Exception {
//
//                        MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");             
//                        mimeMsgHelperObj.setTo(emailToRecipient);
//                        mimeMsgHelperObj.setFrom(emailFromRecipient);               
//                        mimeMsgHelperObj.setText(emailMessage);
//                        mimeMsgHelperObj.setSubject(emailSubject);
//
//                        // Determine If There Is An File Upload. If Yes, Attach It To The Client Email              
//                        if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
//                            System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
//                            mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {                   
//                                public InputStream getInputStream() throws IOException {
//                                    return attachFileObj.getInputStream();
//                                }
//                            });
//                        } else {
//                            System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
//                        }
//                    }
//                });
//                System.out.println("\nMessage Send Successfully.... Hurrey!\n");
//
//                
//                ModelAndView mav = new ModelAndView();
//                mav.setViewName("forgotten_password");
//                return mav;
//                //modelViewObj = new ModelAndView("success","messageObj","Thank You! Your Email Has Been Sent!");
//                //return  modelViewObj;   
//            }
//*/
}