package com.horses.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horses.dao.IHorseDao;
import com.horses.domain.Horse;

@RestController
@RequestMapping("/horses")
public class HorseControllerApi {

	@Autowired
	IHorseDao hdao;
	
	@GetMapping({"/",""})
	public ResponseEntity<List<Horse>>getAll(){
		List<Horse> horses = (List<Horse>)hdao.findAll();
		return new ResponseEntity<List<Horse>>(horses, HttpStatus.OK);
	}
	
	@PostMapping({"/",""})
	public ResponseEntity<Horse> create(@RequestBody Horse h){
		Horse hdb = hdao.save(h);
		return new ResponseEntity<Horse>(hdb , HttpStatus.CREATED);
	}
	
	@GetMapping({"/{id}"})
	public ResponseEntity<Horse>getOne(@PathVariable("id") int id){
		Horse hdb = hdao.findById(id).orElse(null);
		if(hdb!=null) 
		{
		 return new ResponseEntity<Horse>(hdb , HttpStatus.FOUND);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Horse hdb = hdao.findById(id).get();
		if(hdb!=null) 
		{
			hdao.deleteById(id);
			return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		}
		else 
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
	
	@PutMapping({"/{id}"})
	public ResponseEntity<Horse> editget( @PathVariable(value="id") int id, @RequestBody Horse mh) {
		mh.setId(id);
		hdao.save(mh);
		return new ResponseEntity<Horse>(mh, HttpStatus.OK);
	}
	
}
