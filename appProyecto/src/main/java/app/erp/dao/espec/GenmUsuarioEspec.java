package app.erp.dao.espec;

import java.util.List;

import app.erp.domain.GenmUsuario;

/*
 * @Autor: Cristhian Huangal
 * @Fecha: 06/02/2016
 * @Motivo: Interfaz definida para la entidad Usuarios del sistema
 */

public interface GenmUsuarioEspec extends CRUDService<GenmUsuario>  {
	GenmUsuario LoginUsuario(GenmUsuario o_genm_usuario);
	
	GenmUsuario UsuarioByLogin(GenmUsuario o_genm_usuario, String keyAuth);
	
	List<GenmUsuario> SelectPaginacion(String login, String numeroDocumento, Integer numPagina, Integer cantPagina , String keyAuth);

}
