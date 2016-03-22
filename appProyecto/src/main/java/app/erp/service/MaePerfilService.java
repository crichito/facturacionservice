package app.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.erp.dao.espec.MaePerfilEspec;
import app.erp.domain.MaePerfil;

@Service
public class MaePerfilService {
	@Autowired
	MaePerfilEspec maePerfilEspec;
	
	public List<MaePerfil> listAll(String keyAuth) {
		return maePerfilEspec.listAll(keyAuth);
	}
	public List<MaePerfil> PerfilByUser(String key, String keyAuth){
		return maePerfilEspec.PerfilByUser(key, keyAuth);
	}
	public Map<String, Object> ActualizaEstadoPerfilByUser(MaePerfil domainObject, String keyUser, String keyAuth) {
		return maePerfilEspec.ActualizaEstadoPerfilByUser(domainObject, keyUser, keyAuth);
	}
	public Map<String, Object> InsertaPerfilDetalleByUser(MaePerfil maePerfil, String keyUser, String keyAuth) {
		return maePerfilEspec.InsertaPerfilDetalleByUser(maePerfil, keyUser, keyAuth);
	}
}
