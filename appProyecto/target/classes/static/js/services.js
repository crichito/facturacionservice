angular
		.module('Services', [])
		.factory(
				'MainService',
				[
						'$http',
						'$q',
						'$filter',
						'$window',
						'$log',
						function($http, $q, $filter, $window, $log) {

							var localStorage = $window.localStorage;

							function userData() {
								var deferred = $q.defer();
								if (localStorage.getItem('userData') == null) {
									$http.post('/userData').success(
											function(data, status, headers,
													config) {

												localStorage.setItem(
														'userData',
														JSON.stringify(data));
												deferred.resolve(JSON
														.parse(data));
											}).error(
											function(data, status, headers,
													config) {
												$log.error(JSON.stringify({
													data : data
												}));
												deferred.reject();
											});
								} else {
									deferred.resolve(JSON.parse(localStorage
											.getItem('userData')));
								}

								return deferred.promise;
							}

							function getUser() {
								var deferred = $q.defer();
								userData().then(function(data) {

									if (data != null) {
										deferred.resolve(data.login);
									} else {
										deferred.reject();
									}
								});

								return deferred.promise;
							}

							function getUserPersona() {
								var deferred = $q.defer();
								userData()
										.then(
												function(data) {

													if (data != null) {
														deferred
																.resolve(data.genmPersonaNatural);
													} else {
														deferred.reject();
													}
												});

								return deferred.promise;
							}

							function getUserAccesosOrigen() {
								var deferred = $q.defer();
								userData()
										.then(
												function(data) {
													var acceso = [];

													for ( var i in data.listaMaeAccesoMenu) {
														if (data.listaMaeAccesoMenu[i].id_acceso_menu_ref === 0) {
															acceso
																	.push(data.listaMaeAccesoMenu[i]);
														}
													}
													if (acceso.length > 0) {
														deferred
																.resolve(acceso);
													} else {
														deferred.reject();
													}
												});

								return deferred.promise;
							}

							function getUserAccesosDetalle(id) {
								var deferred = $q.defer();
								userData()
										.then(
												function(data) {

													var acceso = [];

													for ( var i in data.listaMaeAccesoMenu) {
														if (data.listaMaeAccesoMenu[i].id_acceso_menu_ref == id) {
															acceso
																	.push(data.listaMaeAccesoMenu[i]);
														}
													}

													if (acceso.length > 0) {
														deferred
																.resolve(acceso);
													} else {
														deferred.reject();
													}
												});

								return deferred.promise;
							}
							return {
								userData : userData,
								getUser : getUser,
								getUserPersona : getUserPersona,
								getUserAccesosOrigen : getUserAccesosOrigen,
								getUserAccesosDetalle : getUserAccesosDetalle
							};

						} ])
		// Usuario Service
		.factory(
				'UsuarioService',
				[
						'$http',
						'$q',
						'$filter',
						'$window',
						'$log',
						function($http, $q, $filter, $window, $log) {
							var localStorage = $window.localStorage;

							function getAll(login, numeroDocumento, numPagina,
									cantPagina) {
								var deferred = $q.defer();
								var transform = function(data) {
									return $.param(data);
								}
								var data = {
									'login' : login,
									'numeroDocumento' : numeroDocumento,
									'numPagina' : numPagina,
									'cantPagina' : cantPagina
								};
								$http
										.post(
												'/Usuario/All',
												data,
												{
													headers : {
														'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
													},
													transformRequest : transform
												}).success(
												function(data, status, headers,
														config) {
													if (data.length > 0) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}
							function getUserByKey(key) {
								var deferred = $q.defer();
								$http.get('/Usuario/' + key)
										.success(
												function(data, status, headers,
														config) {

													if (data != null) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}
							function saveUsuario(genmUsuario) {
								var deferred = $q.defer();
								var transform = function(data) {
									return $.param(data);
								}

								usuarioData = JSON.parse(localStorage
										.getItem('userData'));
								genmUsuario.keyUser = usuarioData.key;

								$http.post('/Usuario/Save', genmUsuario)
										.success(
												function(data, status, headers,
														config) {
													if (data) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}
							return {
								getAll : getAll,
								getUserByKey : getUserByKey,
								saveUsuario : saveUsuario
							};
						} ])
		// Tipo Documento Service
		.factory(
				'TipoDocumentoService',
				[
						'$http',
						'$q',
						'$filter',
						'$window',
						'$log',
						function($http, $q, $filter, $window, $log) {

							function getAll() {
								var deferred = $q.defer();

								$http.get('/TipoDocumento/All')
										.success(
												function(data, status, headers,
														config) {

													if (data.length > 0) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}

							return {
								getAll : getAll
							};
						} ])
		// Perfil Service
		.factory(
				'PerfilService',
				[
						'$http',
						'$q',
						'$filter',
						'$window',
						'$log',
						function($http, $q, $filter, $window, $log) {

							function getAll() {
								var deferred = $q.defer();

								$http.get('/Perfil/All')
										.success(
												function(data, status, headers,
														config) {
													if (data.length > 0) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}

							return {
								getAll : getAll
							};
						} ])
		// Persona Natural
		.factory(
				'PersonaNaturalService',
				[
						'$http',
						'$q',
						'$filter',
						'$window',
						'$log',
						function($http, $q, $filter, $window, $log) {

							function getByTipoDocumento(keyTipoDocumento,
									numeroDocumento) {
								var deferred = $q.defer();

								$http.get(
										'/PersonaNatural/getByTipoDocumento/'
												+ keyTipoDocumento + '/'
												+ numeroDocumento)
										.success(
												function(data, status, headers,
														config) {
													if (data != null) {
														deferred.resolve(data);
													}

												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});
								return deferred.promise;
							}
							function getAll(numPagina, cantPagina) {
								var deferred = $q.defer();
								var transform = function(data) {
									return $.param(data);
								}
								var data = {
									'numPagina' : numPagina,
									'cantPagina' : cantPagina
								};
								$http
										.post(
												'/PersonaNatural/All',
												data,
												{
													headers : {
														'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
													},
													transformRequest : transform
												}).success(
												function(data, status, headers,
														config) {
													if (data.length > 0) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}
							function savePersonaNatural(genmPersonaNatural) {
								var deferred = $q.defer();
								var transform = function(data) {
									return $.param(data);
								}

								usuarioData = JSON.parse(localStorage
										.getItem('userData'));
								genmPersonaNatural.keyUser = usuarioData.key;

								$http.post('/PersonaNatural/Save', genmPersonaNatural)
										.success(
												function(data, status, headers,
														config) {
													if (data) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}
							function getPersonaNaturalByKey(key) {
								var deferred = $q.defer();
								$http.get('/PersonaNatural/' + key)
										.success(
												function(data, status, headers,
														config) {

													if (data != null) {
														deferred.resolve(data);
													}
												}).error(
												function(data, status, headers,
														config) {
													$log.error(JSON.stringify({
														data : data
													}));
													deferred.reject();
												});

								return deferred.promise;
							}
							return {
								getByTipoDocumento : getByTipoDocumento,
								getAll : getAll,
								savePersonaNatural: savePersonaNatural,
								getPersonaNaturalByKey: getPersonaNaturalByKey
							};
						} ]);
