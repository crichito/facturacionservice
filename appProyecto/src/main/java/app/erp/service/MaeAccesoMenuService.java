package app.erp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.erp.dao.espec.MaeAccesoMenuEspec;
import app.erp.domain.MaeAccesoMenu;

@Service
public class MaeAccesoMenuService {
	@Autowired
	MaeAccesoMenuEspec maeAccesoMenuEspec;
	
	public List<MaeAccesoMenu> AccesoByPerfil(String key, String keyAuth) {
		return maeAccesoMenuEspec.AccesoByPerfil(key, keyAuth);
	}

}
