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
import dev.fujioka.java.avancado.web.domain.Curso;
import dev.fujioka.java.avancado.web.service.CursoService;

@RestController
@RequestMapping("/api")
public class CursoResource {
	
    @Autowired
    private CursoService cursoService;


    
    @GetMapping("/curso")
    public List<Curso> getCursos() {
        return cursoService.findAll();
    }

    @PostMapping("/curso")
    public ResponseEntity<Curso>
    save(@Valid @RequestBody Curso curso) {
    	cursoService.save(curso);
        return ResponseEntity.ok(curso);
    }


    @PutMapping("/curso")
    public ResponseEntity update(@Valid @RequestBody Curso curso) {
    	cursoService.save(curso);
        return ResponseEntity.ok().body(curso);
    }


    @DeleteMapping("/curso")
    public ResponseEntity<String> delete(@Valid @RequestBody Curso curso) {
    	cursoService.delete(curso);
       return  ResponseEntity.ok().body("curso excluded ID: " + curso.getId());
    }

    @DeleteMapping("/curso/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
    	cursoService.deleteById(id);
        return ResponseEntity.ok().body("curso excluded ID: " + id);
    }

}
