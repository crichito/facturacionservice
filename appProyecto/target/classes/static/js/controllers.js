/**
 * 
 */
angular.module('Controller', []) 
.controller('MainController', [ '$scope', '$routeParams', 'MainService',
		function($scope, $routeParams, MainService) {

		} ])
// Usuario
.controller('UsuarioController', [ '$scope', '$routeParams', '$filter', '$location',
		'UsuarioService',
		function($scope, $routeParams, $filter, $location, usuarioService) {
			var normalize = $filter('filterListaUsuario');
			$scope.dataUsuarios = {
				columnDefs : [ {
					field : 'key',
					displayName : 'key',
					visible : false
				}, {
					field : 'login',
					width: "250" ,
					resizable: true,
					displayName : 'Login'
				}, {
					field : 'nombreCompleto',
					displayName : 'Nombre'
				}, {
					field : 'estado',
					width: "150" ,
					resizable: false,
					displayName : 'Estado'
				},{ name: ' ', 
					width: "100" ,
					resizable: false,
					cellTemplate: '<button  ng-click="grid.appScope.showMe(grid, row)" class="btn btn-info " type="button"><i class="fa fa-paste"></i> Editar</button>' 
				     } ]
			};
			usuarioService.getAll('', '', 1, 10).then(function(data) {
				$scope.dataUsuarios.data = normalize(data);

			});
			
			$scope.showMe = function(grid, row){
				$location.path('Usuarios/editar/'+ row.entity.key);
             };
             
             $scope.newUsuario = function(){
            	 $location.path('Usuarios/nuevo');
             };
         
             $scope.keyUser = $routeParams.key || '';
             

		} ])
//Persona Natural
.controller('PersonaNaturalController', [ '$scope', '$routeParams', '$filter', '$location',
		'PersonaNaturalService',
		function($scope, $routeParams, $filter, $location, personaNaturalService) {		
	var normalize = $filter('filterNombreUsuario');
	var normalizeEstado = $filter('filterGridEstado');
	$scope.dataPersonaNatural = {
		columnDefs : [ {
			field : 'key',
			displayName : 'key',
			visible : false
		}, {
			field : 'nombreCompleto',
			displayName : 'Nombre'
		}, {
			field : 'maeTipoDocumento.descripcion_tipo_documento',
			displayName : 'Tipo Doc.'
		}, {
			field : 'numero_documento',
			displayName : 'Documento'
		}, {
			field : 'estado',
			width: "150" ,
			resizable: false,
			displayName : 'Estado'
		},{ name: ' ', 
			width: "100" ,
			resizable: false,
			cellTemplate: '<button  ng-click="grid.appScope.showMe(grid, row)" class="btn btn-info " type="button"><i class="fa fa-paste"></i> Editar</button>' 
		     } ]
	};

	personaNaturalService.getAll(1, 10).then(function(data) {
		data.forEach(function(part, index, objArray) {
			objArray[index] = normalizeEstado(normalize(objArray[index]));
		});
		$scope.dataPersonaNatural.data = data;
	});
	
	$scope.showMe = function(grid, row){
		$location.path('PersonaNatural/editar/'+ row.entity.key);
     };
     
     $scope.newPersonaNatural = function(){
    	 $location.path('PersonaNatural/nuevo');
     };
 
     $scope.key = $routeParams.key || '';
}])