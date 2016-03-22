package app.erp.dao.espec;

import java.util.List;

import app.erp.domain.GenmPersonaNatural;

public interface GenmPersonaNaturalEspec extends CRUDService<GenmPersonaNatural>  {
	GenmPersonaNatural getByKey(String key, String keyAuth);
	
	GenmPersonaNatural getByTipoDocumento(String key, String keyTipoDocumento, String numero_documento);
	
	List<GenmPersonaNatural> SelectPaginacion(Integer numPagina, Integer cantPagina , String keyAuth);
	
}
