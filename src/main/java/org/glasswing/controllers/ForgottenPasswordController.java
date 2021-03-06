/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import UtilityMethods.GetPropertyValues;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.glasswing.domain.User;
import org.glasswing.service.EmailService;
import org.glasswing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller //manda a llamar a los metodos
public class ForgottenPasswordController {
//    
     GetPropertyValues getproperties = new GetPropertyValues();
    Properties prop;

    public ForgottenPasswordController() throws IOException {
        this.prop = getproperties.getPropValues();
    }
    static String emailToRecipient, emailSubject, emailMessage;
    static final String emailFromRecipient = "erkexami@gmail.com";
    static final String server = ":8084/SIS_NNA";

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender mailSenderObj;

    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(value = "/contrasena_olvidada")
    public ModelAndView forgottenPassword() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("forgotten_password");
        return mav;
    }
    // Process form submission from forgotPassword page
    @RequestMapping(value = "/pedir_contrasena", method = RequestMethod.POST)
    public ModelAndView processForgotPasswordForm(@RequestParam("email") String userEmail, HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();

        User u = userService.findByEmail(userEmail);

        if (u == null) {
            mav.addObject("respuesta", "Ese correo no existe");
        } else {

            // Generate random 36-character string token for reset password 
            u.setResetToken(UUID.randomUUID().toString());

            // Save token to database
            userService.save(u);
            String appUrl = prop.getProperty("WebPageURL");

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("emailFromRecipient");
            passwordResetEmail.setTo(u.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
                    + "/reset?token=" + u.getResetToken());

            emailService.sendEmail(passwordResetEmail);

            // Add success message to view
            mav.addObject("respuesta", "Se envio correo a " + userEmail);
        }

        mav.setViewName("forgotten_password");
        return mav;

    }

    // Display form to reset password
    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        Optional<User> user = userService.findUserByResetToken(token);

        if (user.isPresent()) { // Token found in DB
            modelAndView.addObject("resetToken", token);
        } else { // Token not found in DB
            modelAndView.addObject("respuesta", "Link de contraseña inválido.");
        }

        modelAndView.setViewName("resetPassword");
        return modelAndView;
    }

    // Process reset password form
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ModelAndView setNewPassword(@RequestParam(value = "passwordNew") String pass1, @RequestParam(value = "passwordConfirm") String pass2, @RequestParam(value = "tokenId") String token) {
        //public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        ModelAndView modelAndView = new ModelAndView();
        // Find the user associated with the reset token
        Optional<User> user = userService.findUserByResetToken(token);

        // This should always be non-null but we check just in case
        if (user.isPresent()) {

            User resetUser = user.get();

            // Set new password    
            //resetUser.setPassword(pass1);
            resetUser.setPassword(bCryptPasswordEncoder().encode(pass1));

            // Set the reset token to null so it cannot be used again
            resetUser.setResetToken(null);

            // Save user
            userService.save(resetUser);

            // In order to set a model attribute on a redirect, we must use
            // RedirectAttributes
            //redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");
            modelAndView.setViewName("login");
            return modelAndView;

        } else {
            modelAndView.addObject("respuesta", "Link de contraseña inválido.");
            modelAndView.setViewName("resetPassword");
        }

        return modelAndView;
    }

    // Going to reset page without a token redirects to login page
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
