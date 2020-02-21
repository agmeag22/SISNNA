package org.glasswing.configuration;

import UtilityMethods.GetPropertyValues;
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
    public JavaMailSender getJavaMailSender() throws IOException {
        GetPropertyValues getproperties = new GetPropertyValues();
        Properties properties = null;
        properties = getproperties.getPropValues();
       
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(properties.getProperty("mailServerUrl"));
        mailSender.setPort(Integer.parseInt(properties.getProperty("mailServerPort")));

        mailSender.setUsername(properties.getProperty("mailServerUsername"));
        mailSender.setPassword(properties.getProperty("mailServerPassword")); // KP9KWw\X+Km2am-J

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
