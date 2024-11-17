package com.sierramaestra.util;

import java.util.Date;

public class FechaUtil {
public static boolean comparacionFechaCreacionYFechaMadurador(Date fechaCreacion,Date fechaMaduracion) {
		
		if (fechaCreacion.after(fechaMaduracion) && !fechaCreacion.equals(fechaMaduracion))
			return true;
		return false;
	}

}
