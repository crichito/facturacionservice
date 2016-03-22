package app.erp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.erp.domain.MaePerfil;
import app.erp.service.MaePerfilService;

@Controller
@RequestMapping({ "/Perfil" })
public class PerfilController {

	@Autowired
	private MaePerfilService maePerfilService;
	
	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MaePerfil> getAll(HttpSession session) {
		List<MaePerfil> listaMaePerfil = new ArrayList<MaePerfil>();
		String keyAuth = session.getAttribute("keyAuth").toString().trim();

		listaMaePerfil = maePerfilService.listAll(keyAuth);

		return listaMaePerfil;
	}
}
