package app.erp.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.erp.domain.GenmPersonaNatural;
import app.erp.domain.GenmUsuario;
import app.erp.domain.MaeAccesoMenu;
import app.erp.domain.MaePerfil;
import app.erp.service.GenmPersonaNaturalService;
import app.erp.service.GenmUsuarioService;
import app.erp.service.MaeAccesoMenuService;
import app.erp.service.MaePerfilService;

@Controller
public class IndexController {

	@Autowired
	private GenmUsuarioService genmUsuarioService;
	@Autowired
	private GenmPersonaNaturalService genmPersonaNaturalService;
	@Autowired
	private MaePerfilService maePerfilService;
	@Autowired
	private MaeAccesoMenuService maeAccesoMenuService;

	@RequestMapping({ "/", "" })
	public String index() {

		return "Index";
	}

	@RequestMapping({ "/Main", "" })
	public String main(Model model, HttpSession session) {

		if (session.getAttribute("keyAuth") == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			model.addAttribute("username", auth.getName());
			session.setAttribute("keyAuth", "Bar12345Bar12345");
			System.out.println(session.getAttribute("keyAuth").toString());
		}
		return "main";
	}

	@RequestMapping("/access_denied")
	public String notAuth() {
		return "access_denied";
	}

	@RequestMapping("login")
	public String loginForm() {
		return "login";
	}

	@RequestMapping(value = "/userData", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody GenmUsuario getEmployeeInXML(HttpSession session) {

		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		GenmUsuario genmUsuario = new GenmUsuario();
				
		genmUsuario.setLogin(SecurityContextHolder.getContext().getAuthentication().getName());
		genmUsuario = genmUsuarioService.UsuarioByLogin(genmUsuario, keyAuth);

		GenmPersonaNatural genmPersonaNatural = new GenmPersonaNatural();
		genmPersonaNatural = genmPersonaNaturalService
				.getById(genmUsuario.getKey_id_persona_natural_genm_persona_natural(), keyAuth);

		List<MaePerfil> listaMaePerfil = maePerfilService.PerfilByUser(genmUsuario.getKey(), keyAuth);

		List<MaeAccesoMenu> listaMaeAccesoMenu = new ArrayList<MaeAccesoMenu>();

		listaMaePerfil.forEach(perfil -> {
			List<MaeAccesoMenu> oMaeAccesoMenu = new ArrayList<MaeAccesoMenu>();
			oMaeAccesoMenu = maeAccesoMenuService.AccesoByPerfil(perfil.getKey(), keyAuth);
			oMaeAccesoMenu.forEach(acceso -> {
				if (!listaMaeAccesoMenu.stream()
						.anyMatch(lista -> lista.getKey() == acceso.getKey())) {
					listaMaeAccesoMenu.add(acceso);
				}
			});
		});

		genmUsuario.setGenmPersonaNatural(genmPersonaNatural);
		genmUsuario.setListaMaePerfil(listaMaePerfil);
		genmUsuario.setListaMaeAccesoMenu(listaMaeAccesoMenu);
		return genmUsuario;

	}
}
