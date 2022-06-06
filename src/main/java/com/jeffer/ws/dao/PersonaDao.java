package com.jeffer.ws.dao;

import java.security.PublicKey; 
import java.util.List;

import org.springframework.stereotype.Service;

import com.jeffer.ws.utilidades.PersonasUtilidades;
import com.jeffer.ws.vo.PersonaVo;

@Service
public class PersonaDao {
	
	
	//////////////////////////////
	public PersonaDao () {
		PersonasUtilidades.iniciarlista();
	}

	//////////////////////////////
	public PersonaVo consultarPersonaIndividual(String documento) {
		
		PersonaVo personaVo=null;
		for(PersonaVo p:PersonasUtilidades.ListaPersonas){
			if(p.getDocumento().equals(documento)){
				personaVo=new PersonaVo();
				personaVo.setDocumento(p.getDocumento());
				personaVo.setNombre(p.getNombre());
				personaVo.setTelefono(p.getTelefono());
				personaVo.setEdad(p.getEdad());
				personaVo.setProfesion(p.getProfesion());
				personaVo.setPassword(p.getPassword());
				personaVo.setTipo(p.getTipo());
			}
		}
		return personaVo;
	}

	//////////////////////////////////////////////
	public PersonaVo consultarPersonaIdProfesion(String documento, String profesion) {

		PersonaVo personaVo = null;
		
		for (PersonaVo per : PersonasUtilidades.ListaPersonas) {
			
			if(per.getDocumento().equals(documento) && per.getProfesion().equals(profesion)) {
				personaVo = new PersonaVo();
				personaVo.setDocumento(per.getDocumento());
				personaVo.setEdad(per.getEdad());
				personaVo.setNombre(per.getNombre());
				personaVo.setPassword(per.getPassword());
				personaVo.setProfesion(per.getProfesion());
				personaVo.setTelefono(per.getTelefono());
				personaVo.setTipo(per.getTipo());
				
			}
		}
		
		return personaVo;
	}
	
	//////////////////////////////
	
	public List<PersonaVo> obtenerListaPersonas(){
		
		return PersonasUtilidades.ListaPersonas;
		
	}

	//////////////////////////////////////////////////////////
	public PersonaVo registrarPersona(PersonaVo persona) {

		boolean existe = false;
		
		for (PersonaVo per : PersonasUtilidades.ListaPersonas) {
			if(per.getDocumento().equals(persona.getDocumento())) {
				
				existe = true;
				break;
			}
		}
		
		if (existe==false) {
			
			persona.setPassword(persona.getDocumento());
			PersonasUtilidades.ListaPersonas.add(persona);
			return persona;
		
		} else {
			return null;
		}
	}
	
	//////////////////////////////////////////////////////////////
	public PersonaVo ConsultarLogin (String documento, String pass) {
		
		PersonaVo personaVo = null;
		
		for(PersonaVo persona : PersonasUtilidades.ListaPersonas) {
			
			if(persona.getDocumento().equals(documento) && persona.getPassword().equals(pass)) {
				
				personaVo = persona;
				break;
			}	
		}
		return personaVo;
	}

	
	////////////////////////////////////////////////////////
	public PersonaVo actualizarPersona (PersonaVo persona) {
		
		PersonaVo miPersona = null;
		
		for (PersonaVo per : PersonasUtilidades.ListaPersonas) {
			
			if(per.getDocumento().equals(persona.getDocumento())) {
				miPersona = per;
				miPersona.setDocumento(persona.getDocumento());
				miPersona.setEdad(persona.getEdad());
				miPersona.setNombre(persona.getNombre());
				miPersona.setPassword(persona.getPassword());
				miPersona.setProfesion(persona.getProfesion());
				miPersona.setTelefono(persona.getTelefono());
				miPersona.setTipo(persona.getTipo());
				break;
			}
		}
		return miPersona;
	}

	public void eliminarPersona(PersonaVo miPersona) {

		for (PersonaVo obj : PersonasUtilidades.ListaPersonas) {
			if(obj.getDocumento().equals(miPersona.getDocumento())) {
				PersonasUtilidades.ListaPersonas.remove(obj);
				break;
			}
		}
	}		
}
