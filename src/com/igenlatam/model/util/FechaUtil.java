package com.igenlatam.model.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilidades para Fecha
 * @author Vanesa Velasquez
 *
 */
public  final class FechaUtil {
	/**
	 * Devuelve la fecha recibida, en formato string dd/MM/yyyy
	 * @param fecha
	 * @return
	 */
	public static String getFechaDDMMYYYY(Date fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
	}

	/**
	 * Convierte una String a Date
	 * @param fecha
	 * @return
	 */
	public static Date getDate(String fecha){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");		  
        try {
            return df.parse(fecha);           

        } catch (ParseException e) {
            e.printStackTrace();
        }		
		return null;
		
	}
	
}
