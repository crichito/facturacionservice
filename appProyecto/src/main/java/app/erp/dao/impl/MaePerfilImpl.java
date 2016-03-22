package app.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import app.erp.dao.espec.MaePerfilEspec;
import app.erp.domain.GenmUsuario;
import app.erp.domain.MaePerfil;
import app.erp.domain.MaeTipoDocumento;
import app.erp.util.CryptoLibrary;
import app.erp.util.DataUtil;

@Repository
public class MaePerfilImpl extends AbstractDao implements MaePerfilEspec {

	@Override
	public List<MaePerfil> listAll(String keyAuth) {
		List<MaePerfil> listMaePerfil = new ArrayList<MaePerfil>();
		listMaePerfil = jdbcTemplate.query("select * from seguridad.fn_lista_perfil()", new Object[] {},
				new RowMapper<MaePerfil>() {
					public MaePerfil mapRow(ResultSet rs, int rowNum) throws SQLException {
						MaePerfil obj = new MaePerfil();
						obj.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_perfil")), keyAuth));
						obj.setDescripcion(rs.getString("descripcion"));
						return obj;
					}
				});

		return listMaePerfil;
	}

	@Override
	public MaePerfil Save(MaePerfil domainObject, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaePerfil Update(MaePerfil domainObject, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaePerfil> PerfilByUser(String key, String keyAuth) {
		List<MaePerfil> listMaePerfil = new ArrayList<MaePerfil>();

		listMaePerfil = jdbcTemplate.query("select * from seguridad.fn_lista_perfil_usuario(?)",
				new Object[] { Integer.parseInt(CryptoLibrary.decrypt(key, keyAuth)) }, new RowMapper<MaePerfil>() {
					public MaePerfil mapRow(ResultSet rs, int rowNum) throws SQLException {
						MaePerfil obj = new MaePerfil();

						Integer id_perfil = rs.getInt("id_perfil");
						obj.setKey(CryptoLibrary.encrypt(id_perfil.toString(), keyAuth));
						obj.setDescripcion(rs.getString("descripcion"));

						return obj;
					}
				});

		return listMaePerfil;
	}

	@Override
	public MaePerfil getById(String key, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key, String keyAuth) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Object> ActualizaEstadoPerfilByUser(MaePerfil domainObject, String keyUser, String keyAuth) {
		Map<String, Object> objEstado = new HashMap<String, Object>();
		domainObject = new MaePerfil();

		String Query = "select * from seguridad.fn_actualiza_estado_perfil_by_usuario(?,?,?,?)";

		domainObject = jdbcTemplate.queryForObject(Query,
				new Object[] { DataUtil.ObjectToInt(CryptoLibrary.decrypt(keyUser, keyAuth)),
						DataUtil.ObjectToBoolean(domainObject.getFlg_estado()), new Date(),
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getKeyUser(), keyAuth)) },
				new RowMapper<MaePerfil>() {
					public MaePerfil mapRow(ResultSet rs, int rowNum) throws SQLException {
						MaePerfil obj = new MaePerfil();

						objEstado.put("estado", rs.getBoolean("out_result"));
						objEstado.put("message", rs.getString("out_message"));

						return obj;
					}
				});

		return objEstado;
	}

	@Override
	public Map<String, Object> InsertaPerfilDetalleByUser(MaePerfil maePerfil, String keyUser, String keyAuth) {
		Map<String, Object> objEstado = new HashMap<String, Object>();
		maePerfil = new MaePerfil();

		String Query = "select * from seguridad.fn_inserta_detalle_perfil_by_usuario(?,?,?,?,?)";

		maePerfil = jdbcTemplate.queryForObject(Query,
				new Object[] { DataUtil.ObjectToInt(CryptoLibrary.decrypt(keyUser, keyAuth)),
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(maePerfil.getKey(), keyAuth)),
						DataUtil.ObjectToBoolean(maePerfil.getFlg_estado()), 
						new Date(),
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(maePerfil.getKeyUser(), keyAuth)) },
				new RowMapper<MaePerfil>() {
					public MaePerfil mapRow(ResultSet rs, int rowNum) throws SQLException {
						MaePerfil obj = new MaePerfil();

						objEstado.put("estado", rs.getBoolean("out_result"));
						objEstado.put("message", rs.getString("out_message"));

						return obj;
					}
				});

		return objEstado;
	}

}
