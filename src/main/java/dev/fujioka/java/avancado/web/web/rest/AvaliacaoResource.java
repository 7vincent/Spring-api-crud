package dev.fujioka.java.avancado.web.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import dev.fujioka.java.avancado.web.domain.Avaliacao;
import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.service.AvaliacaoService;

@RestController
@RequestMapping("/api")
public class AvaliacaoResource {
	//www.rodrigofujioka.com/papw
	@Autowired
	private AvaliacaoService avaliacaoService;

	@GetMapping("/avaliacao")
	public List<Avaliacao> getAvaliacao(){
		return 	avaliacaoService.findAll();	
	}
	
	@GetMapping("/avaliacao/{professor}/{disciplina}")
	public List<Avaliacao> getAvaliacaoPD(@PathVariable String professor, 
			                          @PathVariable String disciplina){
		return avaliacaoService.findByPD(professor, disciplina);
	}
	
	@GetMapping("/avaliacao/{id}")
	public ResponseEntity<Avaliacao> getAvaliacaoById(@PathVariable Long id , 
			      @RequestParam(name = "disciplina", 
			                    defaultValue = "java", 
			                    required = false) String disciplina){
		Optional<Avaliacao> retorno = avaliacaoService.findById(id);	

		if(retorno.isPresent()) {
			return ResponseEntity.of(retorno);
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	
	@PostMapping("/avaliacao")
	public Avaliacao save(@RequestBody @Valid 
			                    Avaliacao avaliacao){
		return 	avaliacaoService.save(avaliacao).get();	
	}
	
    @PutMapping("/avaliacao")
    public ResponseEntity update(@Valid @RequestBody Avaliacao avaliacao) {
        avaliacaoService.save(avaliacao);
        return ResponseEntity.ok().body(avaliacao);
    }
    
    @DeleteMapping("/avaliacao/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        avaliacaoService.deleteById(id);
        return ResponseEntity.ok().body("Avaliação excluded ID: " + id);
    }

    @DeleteMapping("/avaliacao")
    public ResponseEntity<String> delete(@Valid @RequestBody Avaliacao avaliacao) {
    	avaliacaoService.delete(avaliacao);
       return  ResponseEntity.ok().body("Avaliação excluded ID: " + avaliacao.getId());
    }
}




