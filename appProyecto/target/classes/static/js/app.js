/**
 * @Autor: Cristhian Huangal
 * @Correo: cristhianhuangal@gmail.com
 * @Fecha: 04/02/2016
 * @Contenido: Archivo de aplicacion inicial para AngularJS
 */


    angular.module('appErp', ['Controller','Filters','Directives','Services','ngAnimate','ngRoute','ngTouch', 'ui.grid','ngSanitize', 'ui.select','toaster'])   
    .config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) {
    	
        $routeProvider
          .when('/', {
            templateUrl: 'views/mainView.html'
          })
          //Usuarios
          .when('/Usuarios', {
            templateUrl: 'views/usuario/index.html'
          })
          .when('/Usuarios/editar/:key', {
            templateUrl: 'views/usuario/edit.html'
          })
          .when('/Usuarios/nuevo', {
            templateUrl: 'views/usuario/edit.html'
          })
          //Persona Natural
          .when('/PersonaNatural', {
            templateUrl: 'views/personaNatural/index.html'
          })
          .when('/PersonaNatural/editar/:key', {
            templateUrl: 'views/personaNatural/edit.html'
          })
          .when('/PersonaNatural/nuevo', {
            templateUrl: 'views/personaNatural/edit.html'
          })
          .otherwise({
            redirectTo: '/'
          });
        

      }]);
   
