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

import dev.fujioka.java.avancado.web.domain.Disciplina;
import dev.fujioka.java.avancado.web.service.DisciplinaService;

@RestController
@RequestMapping("/api")
public class DisciplinaResource {
	
    @Autowired
    private DisciplinaService disciplinaService;


    
    @GetMapping("/disciplina")
    public List<Disciplina> getDisciplina() {
        return disciplinaService.findAll();
    }

    @PostMapping("/disciplina")
    public ResponseEntity<Disciplina>
    save(@Valid @RequestBody Disciplina disciplina) {
    	disciplinaService.save(disciplina);
        return ResponseEntity.ok(disciplina);
    }


    @PutMapping("/disciplina")
    public ResponseEntity update(@Valid @RequestBody Disciplina disciplina) {
    	disciplinaService.save(disciplina);
        return ResponseEntity.ok().body(disciplina);
    }


    @DeleteMapping("/disciplina")
    public ResponseEntity<String> delete(@Valid @RequestBody Disciplina disciplina) {
    	disciplinaService.delete(disciplina);
       return  ResponseEntity.ok().body("curso excluded ID: " + disciplina.getId());
    }

    @DeleteMapping("/disciplina/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
    	disciplinaService.deleteById(id);
        return ResponseEntity.ok().body("disciplina excluded ID: " + id);
    }

}
