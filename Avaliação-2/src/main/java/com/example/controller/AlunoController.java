package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Aluno;
import com.example.service.AlunoService;



@RestController
@RequestMapping("/aluno")
public class AlunoController {
	private final AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	//Query Method
		@GetMapping("/renda/{renda}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorRenda(@PathVariable  Double renda){
			List<Aluno> alunos = alunoService.buscarAlunosPorRenda(renda);
			return ResponseEntity.ok(alunos);
		}
		//Query Method
		@GetMapping("/ra/{ra}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorRa(@PathVariable  String ra){
			List<Aluno> alunos = alunoService.buscarAlunosPorRa(ra);
			return ResponseEntity.ok(alunos);
		}
		//Query Method
		@GetMapping("/cidade/{cidade}/renda/{renda}")
		public ResponseEntity<List<Aluno>> buscarCidadeERenda(@PathVariable  String cidade, @PathVariable  Double renda){
			List<Aluno> alunos = alunoService.buscarCidadeERenda(cidade, renda);
			return ResponseEntity.ok(alunos);
		}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
		Aluno Aluno = alunoService.getAlunoById(id);
		if (Aluno != null) {
			return ResponseEntity.ok(Aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aluno>> getAllAluno() {
		List<Aluno> Aluno = alunoService.getAllAluno();
		return ResponseEntity.ok(Aluno);
	}

	@PostMapping("/")
	public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno Aluno) {
		Aluno criarAluno = alunoService.salvarAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno Aluno) {
		Aluno updatedAluno = alunoService.updateAluno(id, Aluno);
		if (updatedAluno != null) {
			return ResponseEntity.ok(updatedAluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
		boolean deleted = alunoService.deleteAluno(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Aluno foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
