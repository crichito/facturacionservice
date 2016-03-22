package app.erp.dao.espec;

import java.util.List;
import app.erp.domain.MaeAccesoMenu;

public interface MaeAccesoMenuEspec extends CRUDService<MaeAccesoMenu> {
	List<MaeAccesoMenu> AccesoByPerfil(String key, String keyAuth);
}
