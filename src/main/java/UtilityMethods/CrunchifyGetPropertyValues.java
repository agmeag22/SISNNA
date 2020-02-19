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
import java.util.Date;
import java.util.Properties;

 
public class CrunchifyGetPropertyValues {
	String result = "";
	InputStream inputStream;
 
	public String getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			String userDB = prop.getProperty("usuarioBD");
			String passwordDB = prop.getProperty("contrasenaBD");
			String urlDB = prop.getProperty("urlBD");
			String nameDB = prop.getProperty("nombreBD");
                        String mailRepo = prop.getProperty("correoRecuperacion");
                        String mailRepoUser = prop.getProperty("mailRecuperacion");
                        String passwordRepoUser = prop.getProperty("contrasenaRecuperacion");
                        
 
			result = userDB + ", " + passwordDB + ", " + urlDB + ", " + nameDB + ", " + mailRepo + ", " + mailRepoUser + ", "+ passwordRepoUser;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}