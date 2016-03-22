package app.erp.util;

import java.sql.Timestamp;
import java.util.Date;

public final class DataUtil {
	
	public static Integer ObjectToInt(Object Valor){
		Integer val = 0;
		try{
			val = Valor == null ? 0 : Integer.valueOf(Valor.toString());
		}
		catch (Exception e) { val = 0; }
		return val;
	}
	
	public static String ObjectToString(Object Valor){
		String val = "";
		try{
			val = Valor == null ? "" : String.valueOf(Valor);
		}
		catch (Exception e) { val = ""; }
		return val;
	}
	
	public static Boolean ObjectToBoolean(Object Valor){
		Boolean val = false;
		try{
			val = Valor == null ? false : Boolean.valueOf(String.valueOf(Valor));
		}
		catch (Exception e) { val = false; }
		return val;
	}
	
	
}
