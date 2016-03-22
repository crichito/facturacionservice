package app.erp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.erp.domain.GenmUsuario;
import app.erp.service.GenmUsuarioService;

@Controller
@RequestMapping({ "/Usuario" })
public class UsuarioController {
	@Autowired
	private GenmUsuarioService genmUsuarioService;
	
	@RequestMapping(value = "/All", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<GenmUsuario> getAll(@RequestParam("login") String login,
												  @RequestParam("numeroDocumento") String numeroDocumento,
												  @RequestParam("numPagina") Integer numPagina,
												  @RequestParam("cantPagina") Integer cantPagina,
												  HttpSession session
													){
		List<GenmUsuario> listaGenmUsuario = new ArrayList<GenmUsuario>();
		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		
		listaGenmUsuario = genmUsuarioService.SelectPaginacion(login, numeroDocumento, numPagina, cantPagina, keyAuth);
		
		return listaGenmUsuario;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody GenmUsuario getUsuarioByKey(@PathVariable String id,HttpSession session){
		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		GenmUsuario genmUsuario = new GenmUsuario();
		genmUsuario = genmUsuarioService.getUsuarioById(id, keyAuth);
		
		return genmUsuario;
	}
	
	@RequestMapping(value = "/Save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody GenmUsuario SaveUsuario(@RequestBody GenmUsuario genmUsuario ,HttpSession session){
		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		
		genmUsuario = genmUsuarioService.SaveOrUpdate(genmUsuario, keyAuth);
		
		return genmUsuario;
	}
	
	
}
