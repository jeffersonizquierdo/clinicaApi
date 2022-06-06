package com.jeffer.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.jeffer.ws.vo.PersonaVo;

public class PersonasUtilidades {
	
	public final static int TIPO_ADMIN=1;
	public final static int TIPO_EMPLEADO=2;
	static int bandera=0;
	
	public static List<PersonaVo>ListaPersonas=new ArrayList<PersonaVo>();
	public static void iniciarlista(){
	    if(bandera ==0){
	    	ListaPersonas.add(new PersonaVo("admin","Administrador","NA",0,"NA","admin",1));
			ListaPersonas.add(new PersonaVo("111","Jefferson Izquierdo","74532442",33,"Ingeniero","111",TIPO_ADMIN));
			ListaPersonas.add(new PersonaVo("222","Juan Martin Orozco","3234234",21,"Estudiante","222",TIPO_EMPLEADO));
			ListaPersonas.add(new PersonaVo("333","Maria Andrea perez","23423423",22,"Estudiante","333",TIPO_EMPLEADO));
			bandera=1;
	    }	
	}
	
	

}
