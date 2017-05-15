var cursosModulo = angular.module("cursoModulo",[]);

cursosModulo.controller("cursoController", function ($scope, $http) {
	urlProfessor = 'http://localhost:8080/Project4Final/rest/professores';
	urlCurso = 'http://localhost:8080/Project4Final/rest/cursos';
	
	$scope.listarCursos = function(){
		$http.get(urlCurso).success(function (cursos){
			$scope.cursos = cursos;
		}).error (function (erro){
			alert(erro+" Listar Cursos");
		});
	}
	
	$scope.listarProfessores = function(){
		$http.get(urlProfessor).success(function (professores){
			$scope.professores = professores;
		}).error (function (erro){
			alert(erro+" Listar Professores");
		});
	} 
	
	$scope.selecionaCurso = function (cursoSelecionado) {
		$scope.curso = cursoSelecionado;
	}
	
	$scope.limpar = function () {
		$scope.curso = "";
	}
	
	$scope.salvar = function (){
		//alert($scope.curso.codigo)
		if ($scope.curso.codigo == undefined){
			//alert('EXECUTOU UM POST')
			console.log('Executou um post, novo registro!')
			$http.post(urlCurso, $scope.curso).success(function (curso){
				//$scope.curso.push($scope.curso);
				$scope.listarCursos();
				$scope.limpar();
			}).error (function (erro){
				alert(erro+" Salvar curso");
			});
		}else{
			//alert('EXECUTOU UM PUT')
			console.log('Executou um put, alterando um registro!')
			$http.put(urlCurso, $scope.curso).success(function (curso){
				$scope.listarCursos();
				$scope.limpar();
			}).error (function (erro){
				alert(erro+" Editar Curso");
			});
		}
	}
	
	$scope.excluir =  function(){
		if ($scope.curso.codigo == undefined){
			//alert('Selecione um curso!')
		}else{
			$http.delete(urlCurso+'/'+$scope.curso.codigo).success( function(){
				$scope.listarCursos();
				$scope.limpar();
			}).error (function (erro){
				alert(erro+" Excluir Curso");
			});
		}
	}
	
	//EXECUTA
	$scope.listarCursos();
	$scope.listarProfessores();
	
});