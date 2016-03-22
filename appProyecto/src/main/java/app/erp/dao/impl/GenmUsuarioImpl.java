package app.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.erp.dao.espec.GenmUsuarioEspec;
import app.erp.domain.GenmPersonaNatural;
import app.erp.domain.GenmUsuario;
import app.erp.util.CryptoLibrary;
import app.erp.util.DataUtil;

/*
 * @Autor: Cristhian Huangal
 * @Fecha: 06/02/2016
 * @Motivo: Clase creada para la obtencion de registros desde la base de datos para los usuarios del sistema
 */

@Repository
public class GenmUsuarioImpl extends AbstractDao implements GenmUsuarioEspec {

	@Override
	public List<GenmUsuario> listAll(String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenmUsuario getById(String key, String keyAuth) {
		GenmUsuario genmUsuario = new GenmUsuario();
		
		genmUsuario = jdbcTemplate.queryForObject("select * from seguridad.fn_get_usuariobyid(?)",
				new Object[] { DataUtil.ObjectToInt(CryptoLibrary.decrypt(key, keyAuth)) },
				new RowMapper<GenmUsuario>() {
					public GenmUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmUsuario obj = new GenmUsuario();
						
						obj.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_usuario")), keyAuth));
						obj.setLogin(rs.getString("login").trim());
						obj.setContrasena(rs.getString("contrasena").trim());
						obj.setFlg_estado(rs.getBoolean("flg_estado"));
												
						GenmPersonaNatural genmPersonaNatural = new GenmPersonaNatural();
						genmPersonaNatural.setKeyTipoDocumento(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_tipo_documento_mae_tipo_documento")), keyAuth));
						genmPersonaNatural.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_persona_natural")), keyAuth));
						genmPersonaNatural.setNombre(rs.getString("nombre").trim());
						genmPersonaNatural.setApellido_paterno(rs.getString("apellido_paterno"));
						genmPersonaNatural.setApellido_materno(rs.getString("apellido_materno"));
						genmPersonaNatural.setNumero_documento(rs.getString("numero_documento"));
						
						obj.setGenmPersonaNatural(genmPersonaNatural);
						return obj;
					}
				});

		return genmUsuario;
	}

	@Override
	public void delete(String key, String keyAuth) {
		// TODO Auto-generated method stub

	}

	@Override
	public GenmUsuario LoginUsuario(GenmUsuario o_genm_usuario) {

		o_genm_usuario = jdbcTemplate.queryForObject("select * from seguridad.fn_login_usuario(?,?)",
				new Object[] { o_genm_usuario.getLogin(), o_genm_usuario.getContrasena() },
				new RowMapper<GenmUsuario>() {
					public GenmUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmUsuario obj = new GenmUsuario();
						obj.setId_usuario(rs.getInt("id_usuario"));
						obj.setContrasena("");
						obj.setLogin(rs.getString("login"));
						obj.setFlg_estado(rs.getBoolean("flg_estado"));
						obj.setId_persona_natural_genm_persona_natural(
								rs.getInt("id_persona_natural_genm_persona_natural"));
						return obj;
					}
				});

		return o_genm_usuario;
	}

	@Override
	public GenmUsuario UsuarioByLogin(GenmUsuario o_genm_usuario, String keyAuth) {
		o_genm_usuario = jdbcTemplate.queryForObject("select * from seguridad.fn_get_usuariobyusername(?)",
				new Object[] { o_genm_usuario.getLogin() }, new RowMapper<GenmUsuario>() {
					public GenmUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmUsuario obj = new GenmUsuario();

						Integer id_usuario = rs.getInt("id_usuario");
						Integer id_persona_natural_genm_persona_natural = rs
								.getInt("id_persona_natural_genm_persona_natural");
						
						obj.setKey(CryptoLibrary.encrypt(id_usuario.toString(), keyAuth));
						obj.setKey_id_persona_natural_genm_persona_natural(
								CryptoLibrary.encrypt(id_persona_natural_genm_persona_natural.toString(), keyAuth));
						obj.setContrasena("");
						obj.setLogin(rs.getString("login").trim());
						obj.setFlg_estado(rs.getBoolean("flg_estado"));
						obj.setId_persona_natural_genm_persona_natural(
								rs.getInt("id_persona_natural_genm_persona_natural"));

						return obj;
					}
				});

		return o_genm_usuario;
	}

	@Override
	public GenmUsuario Save(GenmUsuario domainObject, String keyAuth) {
		String Query = "select * from seguridad.fn_inserta_usuario(?,?,?,?,?,?)";

		domainObject = jdbcTemplate.queryForObject(Query,
				new Object[] { DataUtil.ObjectToString(domainObject.getLogin().trim()), 
						DataUtil.ObjectToString(domainObject.getContrasena()).trim(),
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getGenmPersonaNatural().getKey(),keyAuth)), 
						DataUtil.ObjectToBoolean(domainObject.getFlg_estado()),
						new Date(), 
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getKeyUser(),keyAuth)) },
				new RowMapper<GenmUsuario>() {
					public GenmUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmUsuario obj = new GenmUsuario();

						obj.setFlg_result(rs.getBoolean("out_result"));
						obj.setMessage(rs.getString("out_message"));

						return obj;
					}
				});

		return domainObject;
	}

	@Override
	public GenmUsuario Update(GenmUsuario domainObject ,String keyAuth) {
		String Query = "select * from seguridad.fn_actualiza_usuario(?,?,?,?,?,?,?)";
		
		domainObject = jdbcTemplate.queryForObject(Query,
				new Object[] { 
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getKey(),keyAuth)), 
						DataUtil.ObjectToString(domainObject.getLogin()).trim(), 
						DataUtil.ObjectToString(domainObject.getContrasena()).trim(),
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getGenmPersonaNatural().getKey(),keyAuth)), 
						DataUtil.ObjectToBoolean(domainObject.getFlg_estado()),
						new Date(), 
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getKeyUser(),keyAuth)) },
				new RowMapper<GenmUsuario>() {
					public GenmUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmUsuario obj = new GenmUsuario();

						obj.setFlg_result(rs.getBoolean("out_result"));
						obj.setMessage(rs.getString("out_message"));

						return obj;
					}
				});

		return domainObject;
	}

	@Override
	public List<GenmUsuario> SelectPaginacion(String login, String numeroDocumento, Integer numPagina,
			Integer cantPagina, String keyAuth) {
		List<GenmUsuario> listaGenmUsuario = new ArrayList<GenmUsuario>();

		listaGenmUsuario = jdbcTemplate.query("select * from seguridad.fn_pag_usuario_t(?,?,?,?)",
				new Object[] { DataUtil.ObjectToString(login)	, 
							   DataUtil.ObjectToString(numeroDocumento), 
							   DataUtil.ObjectToInt(numPagina), 
							   DataUtil.ObjectToInt(cantPagina) }, new RowMapper<GenmUsuario>() {
					public GenmUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmUsuario obj = new GenmUsuario();
						GenmPersonaNatural objPersonaNatural =  new GenmPersonaNatural();
						obj.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("rnum")), keyAuth));
						obj.setLogin(rs.getString("login").trim());
						obj.setFlg_estado(rs.getBoolean("flg_estado"));
						obj.setTotal(rs.getInt("out_var_total"));
						objPersonaNatural.setNumero_documento(rs.getString("numero_documento").trim());
						objPersonaNatural.setNombre(rs.getString("nombre").trim());
						objPersonaNatural.setApellido_paterno(rs.getString("apellido_paterno").trim());
						objPersonaNatural.setApellido_materno(rs.getString("apellido_materno").trim());
						obj.setGenmPersonaNatural(objPersonaNatural);
						
						return obj;
					}
				});

		return listaGenmUsuario;
	}


}
