package com.javaweb.model.dao;

import java.util.List;

import com.javaweb.model.model.CursoModel;

public interface CursoDaoInterface {
	CursoModel salvarCurso(CursoModel cursoModel);
	
	void alterar(CursoModel cursoModel);
	
	void excluir(CursoModel cursoModel);
	
	List<CursoModel> getCursos();
}
