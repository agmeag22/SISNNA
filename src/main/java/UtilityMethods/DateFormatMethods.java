package UtilityMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class DateFormatMethods {
	// Crea el estilo de formateo de la fecha.
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	// Metodo para formatear la fecha como se es deseado.
	protected Date formatDate(String dateinput) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formated_date = null;
		try {
			formated_date = sdf.parse(dateinput);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return formated_date;
	}

	// Metodo que permite obtener la fecha actual.
	protected String obtainActualDate() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return date;
	}

}
