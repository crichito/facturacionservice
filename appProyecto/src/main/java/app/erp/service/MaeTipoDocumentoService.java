package app.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.erp.dao.espec.MaeTipoDocumentoEspec;
import app.erp.domain.MaeTipoDocumento;

@Service
public class MaeTipoDocumentoService {
	@Autowired
	MaeTipoDocumentoEspec maeTipoDocumentoEspec;
	
	public List<MaeTipoDocumento> All(String keyAuth){
		return maeTipoDocumentoEspec.listAll(keyAuth);
	}
}
