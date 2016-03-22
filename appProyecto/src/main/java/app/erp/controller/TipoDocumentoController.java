package app.erp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.erp.domain.MaeTipoDocumento;
import app.erp.service.MaeTipoDocumentoService;

@Controller
@RequestMapping({ "/TipoDocumento" })
public class TipoDocumentoController {

	@Autowired
	private MaeTipoDocumentoService maeTipoDocumentoService;

	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MaeTipoDocumento> getAll(HttpSession session) {
		List<MaeTipoDocumento> listaMaeTipoDocumento = new ArrayList<MaeTipoDocumento>();
		String keyAuth = session.getAttribute("keyAuth").toString().trim();

		listaMaeTipoDocumento = maeTipoDocumentoService.All(keyAuth);

		return listaMaeTipoDocumento;
	}

}
