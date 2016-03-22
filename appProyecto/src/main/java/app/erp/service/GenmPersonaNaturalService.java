package app.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.erp.dao.espec.GenmPersonaNaturalEspec;
import app.erp.domain.GenmPersonaNatural;
import app.erp.domain.GenmUsuario;
import app.erp.domain.MaePerfil;
import app.erp.util.DataUtil;

@Service
public class GenmPersonaNaturalService  {
	@Autowired
	private GenmPersonaNaturalEspec genmPersonaNaturalEspec;
	
	public GenmPersonaNatural getById(String key, String keyAuth){
		return genmPersonaNaturalEspec.getById(key, keyAuth);
	}
	public GenmPersonaNatural getByKey(String key, String keyAuth) {
		return genmPersonaNaturalEspec.getByKey(key, keyAuth);
	}
	public GenmPersonaNatural getByTipoDocumento(String keyAuth, String keyTipoDocumento, String numero_documento) {
		return genmPersonaNaturalEspec.getByTipoDocumento(keyAuth, keyTipoDocumento, numero_documento);
	}
	public List<GenmPersonaNatural> SelectPaginacion(Integer numPagina, Integer cantPagina, String keyAuth) {
		return genmPersonaNaturalEspec.SelectPaginacion(numPagina, cantPagina, keyAuth);
	}
	public GenmPersonaNatural SaveOrUpdate(GenmPersonaNatural genmPersonaNatural,  String keyAuth){
		if(!DataUtil.ObjectToString(genmPersonaNatural.getKey()).trim().equals("") ){			
			return genmPersonaNaturalEspec.Update(genmPersonaNatural, keyAuth);
		}
		else{
			return genmPersonaNaturalEspec.Save(genmPersonaNatural, keyAuth);
		}
	}	
}
