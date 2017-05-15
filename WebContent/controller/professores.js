var professorModulo = angular.module('professorModulo',[]);

professorModulo.controller("professoresController", function($scope, $http) {
	
	urlProfessor = 'http://localhost:8080/Project4Final/rest/professores';
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessor).success(function (professores) {
			$scope.professores = professores;	
		}).error (function (erro) {
			alert(erro+"AQUI");
		});	
	}
	
	$scope.selecionaprofessor = function(professorSelecionado) {
		$scope.professor = professorSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.professor = "";
	}
	
	$scope.salvar = function() {
		//alert($scope.professor.codigo);
		console.log($scope.professor.codigo);
		if ($scope.professor.codigo == undefined) {
			//alert("POST - codigo vazuio = novo registro");
			//console.log("POST - codigo vazio = novo registro");
		   $http.post(urlProfessor,$scope.professor).success(function(professor) {
		        $scope.professores.push($scope.professor);
		        $scope.limparCampos();
		        $scope.listarProfessores();
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			//alert("PUT - codigo nao vazio = altera registro");
			//console.log("PUT - codigo nao vazio = altera registro");
			  $http.put(urlProfessor,$scope.professor).success(function(professor) {
				  $scope.listarProfessores();
			      $scope.limparCampos();
			   }).error (function (erro) {
					alert(erro);
				});	
		}
		

	}
	
	$scope.excluir = function() {
		if ($scope.professor.codigo == undefined) {
			alert("Favor selecionar um registro para poder excluir");
			console.log("Favor selecionar um registro para poder excluir");
		} else {
			$http.delete(urlProfessor+'/'+$scope.professor.codigo).success(function () {
				 $scope.listarProfessores();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listarProfessores();
	
	
});





