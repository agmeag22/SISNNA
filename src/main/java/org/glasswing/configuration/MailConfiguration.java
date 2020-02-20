package org.glasswing.configuration;

import UtilityMethods.CrunchifyGetPropertyValues;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MailConfiguration {

    @Bean
    public JavaMailSender getJavaMailSender() {
        CrunchifyGetPropertyValues getproperties = new CrunchifyGetPropertyValues();
        String[] properties = null;
        try {
            properties = getproperties.getPropValues();
        } catch (IOException ex) {
            Logger.getLogger(MailConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(properties[4]);
        mailSender.setPort(Integer.parseInt(properties[7]));

        mailSender.setUsername(properties[5]);
        mailSender.setPassword(properties[6]); // KP9KWw\X+Km2am-J

        Properties props = mailSender.getJavaMailProperties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.socketFactory.class",javax.net.ssl.SSLSocketFactory);
        props.put("mail.smtp.socketFactory.port", 425);
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
