package dev.fujioka.java.avancado.web.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin")
public class AdminResource {
	


	@GetMapping("/oi")
	public String getAvaliacao(){
		return "Ok Admin!";
	}

}
