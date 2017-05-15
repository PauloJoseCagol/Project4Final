package com.javaweb.model.service;

import java.util.List;

import com.javaweb.model.model.ProfessorModel;

public interface ProfessorServiceInterface {
	
	ProfessorModel salvarProfessor(ProfessorModel professorModel);

	void alterar(ProfessorModel professorModel);

	void excluir(ProfessorModel professorModel);

	List<ProfessorModel> getProfessores();
}
