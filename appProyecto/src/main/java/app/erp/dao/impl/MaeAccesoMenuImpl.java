package app.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.erp.dao.espec.MaeAccesoMenuEspec;
import app.erp.domain.MaeAccesoMenu;
import app.erp.util.CryptoLibrary;

@Repository
public class MaeAccesoMenuImpl extends AbstractDao implements MaeAccesoMenuEspec {

	@Override
	public List<MaeAccesoMenu> listAll(String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaeAccesoMenu Save(MaeAccesoMenu domainObject, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaeAccesoMenu Update(MaeAccesoMenu domainObject, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaeAccesoMenu> AccesoByPerfil(String key, String keyAuth) {

		List<MaeAccesoMenu> listaMaeAccesoMenu = new ArrayList<MaeAccesoMenu>();

		listaMaeAccesoMenu = jdbcTemplate.query("select * from seguridad.fn_get_menubyperfil(?)",
				new Object[] { Integer.parseInt(CryptoLibrary.decrypt(key, keyAuth)) }, new RowMapper<MaeAccesoMenu>() {
					public MaeAccesoMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
						MaeAccesoMenu obj = new MaeAccesoMenu();
						obj.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_acceso_menu")), keyAuth));
						
						if(rs.getInt("id_acceso_menu_ref") == 0){
							obj.setKeyref("0");
						}
						else{
							obj.setKeyref(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_acceso_menu_ref")), keyAuth));
						}
						
						
						obj.setDescripcion(rs.getString("descripcion").trim());
						obj.setRuta(rs.getString("ruta").trim());
						obj.setId_acceso_menu_ref(rs.getInt("id_acceso_menu_ref"));
						obj.setId_acceso_menu(rs.getInt("id_acceso_menu"));
						obj.setIcono(rs.getString("icono").trim());
						obj.setOrden(rs.getInt("orden"));
						return obj;
					}
				});

		return listaMaeAccesoMenu;

	}

	@Override
	public MaeAccesoMenu getById(String key, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key, String keyAuth) {
		// TODO Auto-generated method stub
		
	}
}
