package com.javaweb.model.rest.facade;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.javaweb.model.model.CursoModel;
import com.javaweb.model.service.CursoServiceInterface;

@Path("/cursos")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class CursoRestFacade {

	/*
	 * @Inject Está sendo utilizado direto na classe "CursoDaoImplem" Que já
	 * tem o método getCursoes() implementado.
	 *
	 *
	 * Direto sem uso de serviços//////////////////
	 * 
	 * @Inject // Injetando direto na classe DAO. private CursoDaoImplem
	 * cursoDaoImplem;
	 * 
	 * @GET public List<CursoModel> getCursos(){ return
	 * cursoDaoImplem.getCursoes(); }
	 *///////////////////////////////////////////////

	@Inject
	private CursoServiceInterface cursoServiceInterface; 
	
	@GET
	public List<CursoModel> getCursos() {
		return cursoServiceInterface.getCursos();
	}
	
	@POST
	public CursoModel salvarCurso(CursoModel cursoModel) {
		return cursoServiceInterface.salvarCurso(cursoModel);
	}
	
	@PUT
	public void atualizar(CursoModel cursoModel) {
		cursoServiceInterface.alterar(cursoModel);
	}
	
	@DELETE
	@Path("/{codigoCurso}")
	public void excluir(@PathParam("codigoCurso") Integer codigoCurso) {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setCodigo(codigoCurso);
		cursoServiceInterface.excluir(cursoModel);
		
	}
}
