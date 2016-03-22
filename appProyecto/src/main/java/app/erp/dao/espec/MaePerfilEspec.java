package app.erp.dao.espec;

import java.util.List;
import java.util.Map;

import app.erp.domain.MaePerfil;

public interface MaePerfilEspec  extends CRUDService<MaePerfil>  {
	
	List<MaePerfil> PerfilByUser(String key, String keyAuth);

	Map<String, Object> ActualizaEstadoPerfilByUser(MaePerfil domainObject, String keyUser, String keyAuth);
	
	Map<String, Object> InsertaPerfilDetalleByUser(MaePerfil maePerfil, String keyUser, String keyAuth);
}
