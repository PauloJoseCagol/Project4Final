package com.javaweb.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.javaweb.model.dao.CursoDaoInterface;
import com.javaweb.model.model.CursoModel;

public class CursoServiceImplem implements CursoServiceInterface{

	/*
	 * @Inject
	 * Tem a função de realizar um instancia de uma classe.
	 * A diferença é que ele vão buscar todas as dependencias dos métodos utilizados.
	 * 
	 * Esta injetando direto na interface. Não tem implementação do método getCursoes().
	 * Mas com o inject irá buscar a dependencia do método na classe "CursoDaoImplem".
	 * Pois lá está a implementação dele.
	 * 
	 */
	
	//Usando serviços, utilizando a classe interfaceDao.
	@Inject // Injetando direto na interface
	private CursoDaoInterface cursoDaoInterface; // Interface
	@Override
	public List<CursoModel> getCursos() {
		return cursoDaoInterface.getCursos();
	}
	//////////////////////////////////////////////////////////////////////////////
	
	@Override
	@Transactional
	public CursoModel salvarCurso(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		/*
		 * Note que ele sempre está pegando os métodos da classe CursoDaoInterface.
		 * Que estão sendo implementados na classe CursoDaoImplem.
		 */
		return cursoDaoInterface.salvarCurso(cursoModel); 
	}

	@Override
	@Transactional
	public void alterar(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		cursoDaoInterface.alterar(cursoModel);
	}

	@Override
	@Transactional
	public void excluir(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		cursoDaoInterface.excluir(cursoModel);
	} 
}
