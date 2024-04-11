package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Aluno;
import com.example.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> getAllAluno() {
		return alunoRepository.findAll();
	}
	//Query Method
		public List<Aluno> buscarAlunosPorRenda(Double renda){
			return alunoRepository.findByRenda(renda);
		}
	//Query Method
		public List<Aluno> buscarAlunosPorRa(String ra){
			return alunoRepository.findByRa(ra);
		}
	//Query Method
		public List<Aluno> buscarCidadeERenda(String cidade, Double renda){
			return alunoRepository.findByCidadeAndRenda(cidade, renda);
		}

	public Aluno getAlunoById(Long id) {
		Optional<Aluno> Aluno = alunoRepository.findById(id);
		return Aluno.orElse(null);
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno updateAluno(Long id, Aluno updatedAluno) {
		Optional<Aluno> existingAluno = alunoRepository.findById(id);
		if (existingAluno.isPresent()) {
			updatedAluno.setId(id);
			return alunoRepository.save(updatedAluno);
		}
		return null;
	}

	public boolean deleteAluno(Long id) {
		Optional<Aluno> existingAluno = alunoRepository.findById(id);
		if (existingAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
