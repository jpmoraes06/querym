package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Turma;
import com.example.repository.TurmaRepository;

@Service
public class TurmaService {
	private final TurmaRepository turmaRepository;

	@Autowired
	public TurmaService(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}

	public List<Turma> getAllTurma() {
		return turmaRepository.findAll();
	}
	//Query Method
			public List<Turma> buscarTurmaPorNome(String nome){
				return turmaRepository.findByNome(nome);
			}
		//Query Method
			public List<Turma> buscarTurmaPorDescricao(String descricao){
				return turmaRepository.findByDescricao(descricao);
			}
		//Query Method
			public List<Turma> buscarNomeEDescricao(String nome, String descricao){
				return turmaRepository.findByNomeAndDescricao(nome, descricao);
			}

	public Turma getTurmaById(Long id) {
		Optional<Turma> Turma = turmaRepository.findById(id);
		return Turma.orElse(null);
	}

	public Turma salvarTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public Turma updateTurma(Long id, Turma updatedTurma) {
		Optional<Turma> existingTurma = turmaRepository.findById(id);
		if (existingTurma.isPresent()) {
			updatedTurma.setId(id);
			return turmaRepository.save(updatedTurma);
		}
		return null;
	}

	public boolean deleteTurma(Long id) {
		Optional<Turma> existingTurma = turmaRepository.findById(id);
		if (existingTurma.isPresent()) {
			turmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	

}
