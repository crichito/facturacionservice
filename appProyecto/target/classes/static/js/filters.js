/**
 * 
 */
angular.module('Filters', []).
filter('filterListaUsuario', [ '$filter', function($filter) {
	return function(lista) {
		var listaTable = [];
		
		for ( var i in lista) {
			if (lista.length > 0) {
				listaTable.push({
					key : lista[i].key,
					login: lista[i].login,
					nombreCompleto: lista[i].genmPersonaNatural.nombre 
									+ " " + lista[i].genmPersonaNatural.apellido_paterno 
									+ " "+ lista[i].genmPersonaNatural.apellido_materno,
					estado: (lista[i].flg_estado) ? "ACTIVO" : "INACTIVO"
				});
			}
		}

		return listaTable;
	};
} ]).
filter('filterNombreUsuario', [ '$filter', function($filter) {
	return function(genmPersonaNatural) {
		genmPersonaNatural.nombreCompleto = genmPersonaNatural.nombre 
		+ " " + genmPersonaNatural.apellido_paterno 
		+ " "+ genmPersonaNatural.apellido_materno;
		
		return genmPersonaNatural;
	};
}])
.filter('filterGridEstado', [ '$filter', function($filter) {
	return function(obj) {
		obj.estado = (obj.flg_estado) ? "ACTIVO" : "INACTIVO";
		return obj;
	};
}])
.filter('propsFilter', function() {
  return function(items, props) {
    var out = [];

    if (angular.isArray(items)) {
      items.forEach(function(item) {
        var itemMatches = false;

        var keys = Object.keys(props);
        for (var i = 0; i < keys.length; i++) {
          var prop = keys[i];
          var text = props[prop].toLowerCase();
          if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
            itemMatches = true;
            break;
          }
        }

        if (itemMatches) {
          out.push(item);
        }
      });
    } else {
      // Let the output be the input untouched
      out = items;
    }

    return out;
  }
});