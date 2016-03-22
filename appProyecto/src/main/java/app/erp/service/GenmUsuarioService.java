package app.erp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.erp.dao.espec.GenmUsuarioEspec;
import app.erp.dao.espec.MaePerfilEspec;
import app.erp.domain.GenmUsuario;
import app.erp.domain.MaePerfil;
import app.erp.util.DataUtil;

@Service
public class GenmUsuarioService {
	@Autowired
	private GenmUsuarioEspec genmUsuarioEspec;
	@Autowired
	private MaePerfilEspec maePerfilEspec;
	
	public GenmUsuario LoginUsuario(GenmUsuario obj_genm_usuario) {
		return genmUsuarioEspec.LoginUsuario(obj_genm_usuario);
	}
	
	public GenmUsuario UsuarioByLogin(GenmUsuario obj_genm_usuario, String keyAuth ){
		return genmUsuarioEspec.UsuarioByLogin(obj_genm_usuario, keyAuth);
	}
	
	public GenmUsuario SaveOrUpdate(GenmUsuario obj_genm_usuario,  String keyAuth){
		if(!DataUtil.ObjectToString(obj_genm_usuario.getKey()).trim().equals("") ){
			
			MaePerfil maePerfil =  new MaePerfil();
			maePerfil.setFlg_estado(false);
			maePerfilEspec.ActualizaEstadoPerfilByUser(maePerfil, obj_genm_usuario.getKey(), keyAuth);
			obj_genm_usuario.getListaMaePerfil().forEach(perfil -> {
				maePerfilEspec.ActualizaEstadoPerfilByUser(perfil, obj_genm_usuario.getKey(), keyAuth);
			});
			
			return genmUsuarioEspec.Update(obj_genm_usuario, keyAuth);
		}
		else{
			return genmUsuarioEspec.Save(obj_genm_usuario, keyAuth);
		}
	}
	
	public List<GenmUsuario> SelectPaginacion(String login, String numeroDocumento, Integer numPagina,
			Integer cantPagina, String keyAuth){
		return genmUsuarioEspec.SelectPaginacion(login, numeroDocumento, numPagina, cantPagina, keyAuth);
	}
	
	public GenmUsuario getUsuarioById(String key, String keyAuth){
		GenmUsuario genmUsuario = new GenmUsuario();
		List<MaePerfil> listaMaePerfil = new ArrayList<MaePerfil>();
		
		genmUsuario = genmUsuarioEspec.getById(key, keyAuth);
		listaMaePerfil = maePerfilEspec.PerfilByUser(genmUsuario.getKey(), keyAuth);
		genmUsuario.setListaMaePerfil(listaMaePerfil);
		return genmUsuario;
	}
	
}
