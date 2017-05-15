package com.javaweb.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.javaweb.model.dao.ProfessorDaoInterface;
import com.javaweb.model.model.ProfessorModel;

public class ProfessorServiceImplem implements ProfessorServiceInterface{

	/*
	 * @Inject
	 * Tem a função de realizar um instancia de uma classe.
	 * A diferença é que ele vão buscar todas as dependencias dos métodos utilizados.
	 * 
	 * Esta injetando direto na interface. Não tem implementação do método getProfessores().
	 * Mas com o inject irá buscar a dependencia do método na classe "ProfessorDaoImplem".
	 * Pois lá está a implementação dele.
	 * 
	 */
	
	//Usando serviços, utilizando a classe interfaceDao.
	@Inject // Injetando direto na interface
	private ProfessorDaoInterface professorDaoInterface; // Interface
	@Override
	public List<ProfessorModel> getProfessores() {
		return professorDaoInterface.getProfessores();
	}
	//////////////////////////////////////////////////////////////////////////////
	
	@Override
	@Transactional
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		// TODO Auto-generated method stub
		/*
		 * Note que ele sempre está pegando os métodos da classe ProfessorDaoInterface.
		 * Que estão sendo implementados na classe ProfessorDaoImplem.
		 */
		return professorDaoInterface.salvarProfessor(professorModel); 
	}

	@Override
	@Transactional
	public void alterar(ProfessorModel professorModel) {
		// TODO Auto-generated method stub
		professorDaoInterface.alterar(professorModel);
	}

	@Override
	@Transactional
	public void excluir(ProfessorModel professorModel) {
		// TODO Auto-generated method stub
		professorDaoInterface.excluir(professorModel);
	} 
}
