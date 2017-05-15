package com.javaweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.javaweb.model.model.CursoModel;

public class CursoDaoImplem implements CursoDaoInterface{
	
	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit")
	
	private EntityManager entityManager;
	
	
	@Override
	public CursoModel salvarCurso(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		entityManager.persist(cursoModel);
		return cursoModel;
	}

	@Override
	public void alterar(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		CursoModel cursoModelMerge = entityManager.merge(cursoModel);
		entityManager.persist(cursoModelMerge);
	}

	@Override
	public void excluir(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		CursoModel cursoModelMerge = entityManager.merge(cursoModel);
		entityManager.remove(cursoModelMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CursoModel> getCursos() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from CursoModel");
		return query.getResultList();
	}
	
}
