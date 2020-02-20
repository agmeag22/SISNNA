/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityMethods;

/**
 *
 * @author MiguelAviles
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

public class GetPropertyValues {
    String[] properties;
    InputStream inputStream;

    public Properties getPropValues() throws IOException {
         Properties prop = new Properties();
        try {
           
            String propFileName = "config.properties";
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + propFileName;
            inputStream = new FileInputStream(appConfigPath);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            
//            Date time = new Date(System.currentTimeMillis());
//            // get the property value and print it out
//            String userDB = prop.getProperty("usuarioBD");
//            String passwordDB = prop.getProperty("contrasenaBD");
//            String urlDB = prop.getProperty("urlBD");
//            String nameDB = prop.getProperty("nombreBD");
//            String mailHost = prop.getProperty("correoRecuperacion");
//            String mailRepoUser = prop.getProperty("mailRecuperacion");
//            String passwordRepoUser = prop.getProperty("contrasenaRecuperacion");
//            String mailPort = prop.getProperty("puertodeMailRecuperacion");
//            properties[0]=userDB;
//            properties[1]=passwordDB;
//            properties[2]=urlDB;
//            properties[3]=nameDB;
//            properties[4]=mailHost;
//            properties[5]=mailRepoUser;
//            properties[6]=passwordRepoUser;
//            properties[7]=mailPort;
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        
        return prop;
    }
}
