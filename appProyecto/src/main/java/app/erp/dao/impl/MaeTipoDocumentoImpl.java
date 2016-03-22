package app.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.erp.dao.espec.MaeTipoDocumentoEspec;
import app.erp.domain.MaeTipoDocumento;
import app.erp.util.CryptoLibrary;

@Repository
public class MaeTipoDocumentoImpl extends AbstractDao implements MaeTipoDocumentoEspec {

	@Override
	public List<MaeTipoDocumento> listAll(String keyAuth) {
		List<MaeTipoDocumento> listMaeTipoDocumento = new ArrayList<MaeTipoDocumento>();
		listMaeTipoDocumento = jdbcTemplate.query("select * from contenedor.fn_lista_tipo_documento()",
				new Object[] {  }, new RowMapper<MaeTipoDocumento>() {
					public MaeTipoDocumento mapRow(ResultSet rs, int rowNum) throws SQLException {
						MaeTipoDocumento obj = new MaeTipoDocumento();

						obj.setKey(CryptoLibrary.encrypt(String.valueOf(rs.getInt("id_tipo_documento")), keyAuth));
						obj.setDescripcion_tipo_documento(rs.getString("descripcion_tipo_documento"));

						return obj;
					}
				});

		return listMaeTipoDocumento;
	}

	@Override
	public MaeTipoDocumento getById(String key, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaeTipoDocumento Save(MaeTipoDocumento domainObject, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaeTipoDocumento Update(MaeTipoDocumento domainObject, String keyAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key, String keyAuth) {
		// TODO Auto-generated method stub
		
	}

}
