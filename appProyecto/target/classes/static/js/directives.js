/**
 * 
 */
angular.module('Directives', []).
directive('accesoUsuario', [ 'MainService', function(mainService) {
	return {
		restrict : 'E',
		templateUrl : 'directive/accesoUsuario.html',
		replace : true,
		controller : function($scope) {
			var accesoOrigen = mainService.userData().$$state.value.listaMaeAccesoMenu;
			
			$scope.login = "";
			$scope.nombreUsuario = "";
			mainService.getUser().then(function (data) {
		          $scope.login = data;
		    });
			
			mainService.getUserPersona().then(function (data) {
				
		          $scope.nombreUsuario = data.nombre 
		          						+ " " + data.apellido_paterno
		          						+ " "+ data.apellido_materno;
	        });
			
			$scope.fnAccesoOrigen = function(){
				var acceso = [];
				for (var i in accesoOrigen)
				{
				  if(accesoOrigen[i].id_acceso_menu_ref == '0'){
					  acceso.push(accesoOrigen[i]);
				  }
				}
				
				return acceso;
			};

			$scope.fnAccesoDetalle = function(id){
				var acceso = [];
				for (var i in accesoOrigen)
				{
				  if(accesoOrigen[i].id_acceso_menu_ref == id){
					  acceso.push(accesoOrigen[i]);
				  }
				}
				
				return acceso;
			};
			
		}
	};
} ])
.directive('registroUsuario', ['$location','toaster', '$log','$http','UsuarioService','TipoDocumentoService','PerfilService','PersonaNaturalService','$filter', 
                                function($location,toaster,$log,$http,usuarioService,tipoDocumentoService,perfilService,personaNaturalService,$filter) {
	return {
		restrict : 'E',
		templateUrl : 'directive/usuario/registro.html',
		replace : true,
		scope:{
			userKey : "@"
		},
		controller : function($scope) {
		 var filterNombre = $filter('filterNombreUsuario');
		 var key = $scope.userKey || "";
		 $scope.usuarioData = {};
		 
		 $scope.listaTipoDocumento = [];
		 $scope.listaPerfil = [];
		 $scope.usuarioPerfil = [];
		 		 
		 usuarioService.getUserByKey(key).then(function(data) {
			 $scope.usuarioData = data;
			 $scope.usuarioData.genmPersonaNatural = filterNombre($scope.usuarioData.genmPersonaNatural);
		 });
		 
		 tipoDocumentoService.getAll().then(function(data) {
			 $scope.listaTipoDocumento = data;
		 });
		 
		 perfilService.getAll().then(function(data) {
			 $scope.listaPerfil = data;
		 });
		 
		 //Submit Method
		 $scope.submitForm = function(isValid) {
			 if (isValid) {
				 usuarioService.saveUsuario($scope.usuarioData)
				 .then(
						 function(data) {
							 if(data.flg_result){
								 $location.path('Usuarios');
								 toaster.pop('succes', "Aviso", data.message, 5000, 'trustedHtml');
							 }
							 else{
								 toaster.pop('error', "Error", data.message, 5000, 'trustedHtml');
							 }
						  },
						  function(error) {
							 console.log(error);			
						  });
			 }
		 };
		 
		 $scope.cambioPersonaNatural = function(){
			 $scope.usuarioData.genmPersonaNatural=null;	
		 };
		 
		 $scope.getPersonaNaturalByDocumento = function(tipoDoc,numeroDoc){
			 if($.trim(numeroDoc).length > 0 && $.trim(tipoDoc).length>0){
				 
				 personaNaturalService.getByTipoDocumento(tipoDoc,numeroDoc)
				 .then(
						 function(data) {
							 if (data != null) {
									$scope.usuarioData.genmPersonaNatural = filterNombre(data);
								}
						  },
						  function(error) {
							  $scope.usuarioData.genmPersonaNatural=null;			
						  },
						  function(progress) {
						
				});
			 }
			 else{
				toaster.pop('error', "Error", 'Debe seleccionar un tipo de documento y un número', 5000, 'trustedHtml');
			 }
			
		 };
		 
		} 
	};
} ])
.directive('registroPersonaNatural', ['$location','toaster', '$log','$http','UsuarioService','TipoDocumentoService','PerfilService','PersonaNaturalService','$filter', 
                                function($location,toaster,$log,$http,usuarioService,tipoDocumentoService,perfilService,personaNaturalService,$filter) {
	return {
		restrict : 'E',
		templateUrl : 'directive/personaNatural/registro.html',
		replace : true,
		scope:{
			key : "@"
		},
		controller : function($scope) {
			var key = $scope.key || "";
			$scope.personaNaturalData = {};
			$scope.listaTipoDocumento = [];
			
			personaNaturalService.getPersonaNaturalByKey(key).then(function(data) {
				 $scope.personaNaturalData = data;
			 });
			
			tipoDocumentoService.getAll().then(function(data) {
				 $scope.listaTipoDocumento = data;
			 });
			
			$scope.submitForm = function(isValid) {
				 if (isValid) {
					 personaNaturalService.savePersonaNatural($scope.personaNaturalData)
					 .then(
							 function(data) {
								 if(data.flg_result){
									 $location.path('PersonaNatural');
									 toaster.pop('succes', "Aviso", data.message, 5000, 'trustedHtml');
								 }
								 else{
									 toaster.pop('error', "Error", data.message, 5000, 'trustedHtml');
								 }
							  },
							  function(error) {
								 console.log(error);			
							  });
				 }
			 };
			 
		}
	};
} ])		
;