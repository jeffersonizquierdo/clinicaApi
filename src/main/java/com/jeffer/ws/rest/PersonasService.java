package com.jeffer.ws.rest;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeffer.ws.dao.PersonaDao;

import com.jeffer.ws.vo.PersonaVo;

@RestController
@RequestMapping("/servicio")
public class PersonasService{
		
		
	@Autowired(required=true)
	private PersonaDao personaDao;
    
    
   @GetMapping("hola")
    public String saludo(){
        return"Este es el saludo de clinica web";
   }
	   
	   
	   //////////////////////////////////
	@GetMapping("personas")
	public ResponseEntity <PersonaVo>getPersona(
	@RequestParam(value="id",defaultValue = "0")String documento){
		PersonaVo persona = personaDao.consultarPersonaIndividual(documento);
	    if(persona != null){
	    	return ResponseEntity.ok(persona);
	   }
	    return ResponseEntity.notFound().build();
	    
	}   	
	   	
   	//////////////////////////////////////
	
   	@GetMapping("profesion")
   	public ResponseEntity<PersonaVo>  getPersonaIdProfesion2 (
        @RequestParam(value="id",defaultValue="0")String documento,
        @RequestParam(value="profesion",defaultValue="0")String profesion){
   		
   		
   	    PersonaVo persona=personaDao.consultarPersonaIdProfesion(documento,profesion);
   	    if(persona != null){
   	     return ResponseEntity.ok(persona);
   	   }
   	    return ResponseEntity.notFound().build();
   	  
   	}
   	
   	////////////////////////////////////////////////////
   	@GetMapping("personas/{id}")
   	public ResponseEntity<PersonaVo> getPersonaId(@PathVariable("id") String documento){
   		
   		PersonaVo persona = personaDao.consultarPersonaIndividual(documento);
   		
   		if(persona != null) {
   			return ResponseEntity.ok(persona);
   		}
   		return ResponseEntity.notFound().build();
   		
   	}
   	
   	///////////////////////////////////////////////////
   	@GetMapping("personas/{id}/{profesion}")
   	public ResponseEntity<PersonaVo> getPersonaIdProfesion (@PathVariable("id") String documento,
   			@PathVariable("profesion") String profesion){
   		
   		PersonaVo personaVo = personaDao.consultarPersonaIdProfesion(documento, profesion);
   		
   		if(personaVo != null) {
   			
   			return ResponseEntity.ok(personaVo);
   		}
   		return ResponseEntity.notFound().build();
   	}
   	
   	/////////////////////////////////////////
   	@GetMapping("personas-list")
   	public ResponseEntity<List<PersonaVo>> getPersonas(){
   		
   		List<PersonaVo> personas = personaDao.obtenerListaPersonas();
   		
   		return ResponseEntity.ok(personas);
   	}
   	
   	//////////////////////////////////////////
   	@PostMapping("guardar")
   	public ResponseEntity<PersonaVo> registrarPersona (@RequestBody PersonaVo persona){
   		
   		PersonaVo miPersona = personaDao.registrarPersona(persona);
   		if(miPersona!=null) {
   			return ResponseEntity.ok(miPersona);
   		} else {
   			return ResponseEntity.notFound().build();
   		}
   	}
   	
   	
   	/////////////////////////////////////////////////////////////
   	@PostMapping("login")
   	public ResponseEntity<PersonaVo> login (@RequestBody PersonaVo persona){
   		
   		PersonaVo miPersona= personaDao.ConsultarLogin(persona.getDocumento(), persona.getPassword());
   		if(miPersona!= null) {
   			
   			return ResponseEntity.ok(miPersona);
   		
   		} else {
   			
   			return ResponseEntity.notFound().build(); 
   		}
   	}
   	
   	//////////////////////////////////////////////////////
   	@PutMapping("actualizar")
   	public ResponseEntity<PersonaVo> actualizarUsuario (@RequestBody PersonaVo persona){
   		
   		PersonaVo miPersona = null;
   		if (personaDao.consultarPersonaIndividual(persona.getDocumento())!= null) {
   			miPersona = personaDao.actualizarPersona(persona);
   			if( miPersona!= null) {
   				return ResponseEntity.ok(miPersona);
   			} else {
   				return ResponseEntity.notFound().build();
   			}
   		
   		} else {
   			return ResponseEntity.notFound().build();
   		}
   	}
   	
   	/////////////////////////////////////////////////
   	@DeleteMapping("eliminar/{id}")
   	public ResponseEntity<Void> eliminarUsuario(@PathVariable String id){
   		PersonaVo miPersona = personaDao.consultarPersonaIndividual(id);
   		
   		if(miPersona!= null) {
   			
   			personaDao.eliminarPersona(miPersona);
   			return ResponseEntity.ok(null);
   		}
   		return ResponseEntity.notFound().build(); 		
   	}    
              
}