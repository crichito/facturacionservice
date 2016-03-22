package app.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.erp.dao.espec.GenmPersonaNaturalEspec;
import app.erp.domain.GenmPersonaNatural;
import app.erp.domain.GenmUsuario;
import app.erp.domain.MaeTipoDocumento;
import app.erp.util.CryptoLibrary;
import app.erp.util.DataUtil;

@Repository
public class GenmPersonaNaturalImpl extends AbstractDao implements GenmPersonaNaturalEspec {

	@Override
	public List<GenmPersonaNatural> listAll(String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenmPersonaNatural getById(String key, String keyAuth) {
		GenmPersonaNatural genmPersonaNatural = new GenmPersonaNatural();
		genmPersonaNatural = jdbcTemplate.queryForObject("select * from general.fn_lista_persona_natural(?)",
 				new Object[] { Integer.valueOf(CryptoLibrary.decrypt(key, keyAuth)) }, new RowMapper<GenmPersonaNatural>() {
					public GenmPersonaNatural mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmPersonaNatural obj = new GenmPersonaNatural();
						MaeTipoDocumento objTipoDocumento = new MaeTipoDocumento();
						
						obj.setId_persona_natural(rs.getInt("id_persona_natural"));
						obj.setApellido_paterno(rs.getString("apellido_paterno"));
						obj.setApellido_materno(rs.getString("apellido_materno"));
						obj.setNumero_documento(rs.getString("numero_documento"));
						obj.setNombre(rs.getString("nombre"));
						obj.setCorreo_electronico(rs.getString("correo_electronico"));
						obj.setFlg_estado(rs.getBoolean("flg_estado"));
						obj.setKey(CryptoLibrary.encrypt( DataUtil.ObjectToString(rs.getInt("id_persona_natural")), keyAuth));
						objTipoDocumento.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_tipo_documento_mae_tipo_documento")), keyAuth));
						
						obj.setMaeTipoDocumento(objTipoDocumento);
						return obj;
					}
				});
		return genmPersonaNatural;
	}

	@Override
	public GenmPersonaNatural Save(GenmPersonaNatural domainObject, String keyAuth) {
		String Query = "select * from general.fn_inserta_persona_natural(?,?,?,?,?,?,?,?,?)";

		domainObject = jdbcTemplate.queryForObject(Query,
				new Object[] { DataUtil.ObjectToString(domainObject.getNombre().trim()), 
						DataUtil.ObjectToString(domainObject.getApellido_paterno()).trim(),
						DataUtil.ObjectToString(domainObject.getApellido_materno()).trim(),
						DataUtil.ObjectToString(domainObject.getNumero_documento()).trim(),
						DataUtil.ObjectToString(domainObject.getCorreo_electronico()).trim(),
						DataUtil.ObjectToBoolean(domainObject.getFlg_estado()),
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getMaeTipoDocumento().getKey(),keyAuth)), 
						new Date(), 
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getKeyUser(),keyAuth)) },
				new RowMapper<GenmPersonaNatural>() {
					public GenmPersonaNatural mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmPersonaNatural obj = new GenmPersonaNatural();

						obj.setFlg_result(rs.getBoolean("out_result"));
						obj.setMessage(rs.getString("out_message"));

						return obj;
					}
				});

		return domainObject;
	}

	@Override
	public GenmPersonaNatural Update(GenmPersonaNatural domainObject, String keyAuth) {
		String Query = "select * from general.fn_actualiza_persona_natural(?,?,?,?,?,?,?,?,?,?)";

		domainObject = jdbcTemplate.queryForObject(Query,
				new Object[] {	DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getKey(),keyAuth)), 
						DataUtil.ObjectToString(domainObject.getNombre().trim()), 
						DataUtil.ObjectToString(domainObject.getApellido_paterno()).trim(),
						DataUtil.ObjectToString(domainObject.getApellido_materno()).trim(),
						DataUtil.ObjectToString(domainObject.getNumero_documento()).trim(),
						DataUtil.ObjectToString(domainObject.getCorreo_electronico()).trim(),
						DataUtil.ObjectToBoolean(domainObject.getFlg_estado()),
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getMaeTipoDocumento().getKey(),keyAuth)), 
						new Date(), 
						DataUtil.ObjectToInt(CryptoLibrary.decrypt(domainObject.getKeyUser(),keyAuth)) },
				new RowMapper<GenmPersonaNatural>() {
					public GenmPersonaNatural mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmPersonaNatural obj = new GenmPersonaNatural();

						obj.setFlg_result(rs.getBoolean("out_result"));
						obj.setMessage(rs.getString("out_message"));

						return obj;
					}
				});

		return domainObject;
	}

	@Override
	public void delete(String key, String keyAuth) {
		// TODO Auto-generated method stub

	}

	@Override
	public GenmPersonaNatural getByKey(String key, String keyAuth) {
		GenmPersonaNatural genmPersonaNatural = new GenmPersonaNatural();

		genmPersonaNatural = jdbcTemplate.queryForObject("select * from general.fn_lista_persona_natural(?)",
				new Object[] { Integer.parseInt(CryptoLibrary.decrypt(key, keyAuth)) },
				new RowMapper<GenmPersonaNatural>() {
					public GenmPersonaNatural mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmPersonaNatural obj = new GenmPersonaNatural();

						Integer id_persona_natural = rs.getInt("id_persona_natural");

						obj.setKey(CryptoLibrary.encrypt(id_persona_natural.toString(), keyAuth));
						obj.setApellido_paterno(rs.getString("apellido_paterno"));
						obj.setApellido_materno(rs.getString("apellido_materno"));
						obj.setNumero_documento(rs.getString("numero_documento"));
						obj.setNombre(rs.getString("nombre"));
						obj.setCorreo_electronico(rs.getString("correo_electronico"));

						return obj;
					}
				});

		return genmPersonaNatural;
	}

	@Override
	public GenmPersonaNatural getByTipoDocumento(String keyAuth, String keyTipoDocumento, String numero_documento) {
		GenmPersonaNatural genmPersonaNatural = new GenmPersonaNatural();

		genmPersonaNatural = jdbcTemplate.queryForObject("select * from general.fn_get_persona_tipo_documento(?,?)",
				new Object[] { DataUtil.ObjectToInt(CryptoLibrary.decrypt(keyTipoDocumento,keyAuth)),
								DataUtil.ObjectToString(numero_documento)
								},
				new RowMapper<GenmPersonaNatural>() {
					public GenmPersonaNatural mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmPersonaNatural obj = new GenmPersonaNatural();
						
						obj.setKey(CryptoLibrary.encrypt( DataUtil.ObjectToString(rs.getInt("id_persona_natural")), keyAuth));
						obj.setApellido_paterno(rs.getString("apellido_paterno"));
						obj.setApellido_materno(rs.getString("apellido_materno"));
						obj.setNumero_documento(rs.getString("numero_documento"));
						obj.setNombre(rs.getString("nombre"));
						obj.setKeyTipoDocumento(CryptoLibrary.encrypt( DataUtil.ObjectToString(rs.getInt("id_tipo_documento_mae_tipo_documento")), keyAuth));

						return obj;
					}
				});

		return genmPersonaNatural;
	}

	@Override
	public List<GenmPersonaNatural> SelectPaginacion(Integer numPagina, Integer cantPagina, String keyAuth) {
		List<GenmPersonaNatural> listaGenmPersonaNatural = new ArrayList<GenmPersonaNatural>();

		listaGenmPersonaNatural = jdbcTemplate.query("select * from  general.fn_pag_persona_natural(?,?)",
				new Object[] { DataUtil.ObjectToInt(numPagina), 
							   DataUtil.ObjectToInt(cantPagina) }, new RowMapper<GenmPersonaNatural>() {
					public GenmPersonaNatural mapRow(ResultSet rs, int rowNum) throws SQLException {
						GenmPersonaNatural obj = new GenmPersonaNatural();
						MaeTipoDocumento objTipoDocumento = new MaeTipoDocumento();
						
						obj.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_persona_natural")), keyAuth));
						obj.setFlg_estado(rs.getBoolean("flg_estado"));
						obj.setTotal(rs.getInt("out_var_total"));
						obj.setNumero_documento(rs.getString("numero_documento").trim());
						obj.setNombre(rs.getString("nombre").trim());
						obj.setApellido_paterno(rs.getString("apellido_paterno").trim());
						obj.setApellido_materno(rs.getString("apellido_materno").trim());
						objTipoDocumento.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_tipo_documento_mae_tipo_documento")), keyAuth));
						objTipoDocumento.setDescripcion_tipo_documento(rs.getString("descripcion_tipo_documento"));
						
						obj.setMaeTipoDocumento(objTipoDocumento);
						
						return obj;
					}
				});

		return listaGenmPersonaNatural;
	}

}
