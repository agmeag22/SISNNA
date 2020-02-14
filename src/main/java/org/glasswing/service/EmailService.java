/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;
import org.springframework.mail.SimpleMailMessage;


public interface EmailService {
	public void sendEmail(SimpleMailMessage email);
}