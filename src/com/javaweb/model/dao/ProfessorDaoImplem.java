package com.javaweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.javaweb.model.model.ProfessorModel;

public class ProfessorDaoImplem implements ProfessorDaoInterface{
	
	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit")
	
	private EntityManager entityManager;
	
	
	@Override
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		// TODO Auto-generated method stub
		entityManager.persist(professorModel);
		return professorModel;
	}

	@Override
	public void alterar(ProfessorModel professorModel) {
		// TODO Auto-generated method stub
		ProfessorModel professorModelMerge = entityManager.merge(professorModel);
		entityManager.persist(professorModelMerge);
	}

	@Override
	public void excluir(ProfessorModel professorModel) {
		// TODO Auto-generated method stub
		ProfessorModel professorModelMerge = entityManager.merge(professorModel);
		entityManager.remove(professorModelMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProfessorModel> getProfessores() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from ProfessorModel");
		return query.getResultList();
	}
	
}
