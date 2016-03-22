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

import app.erp.dao.espec.GenmPersonaNaturalEspec;
import app.erp.domain.GenmPersonaNatural;
import app.erp.domain.GenmUsuario;
import app.erp.service.GenmPersonaNaturalService;

@Controller
@RequestMapping({ "/PersonaNatural" })
public class PersonaNaturalController {
	@Autowired
	public GenmPersonaNaturalService genmPersonaNaturalService;

	@RequestMapping(value = "/All", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<GenmPersonaNatural> getAll(
												  @RequestParam("numPagina") Integer numPagina,
												  @RequestParam("cantPagina") Integer cantPagina,
												  HttpSession session
													){
		List<GenmPersonaNatural> listaGenmPersonaNatural = new ArrayList<GenmPersonaNatural>();
		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		
		listaGenmPersonaNatural = genmPersonaNaturalService.SelectPaginacion(numPagina, cantPagina, keyAuth);
		
		return listaGenmPersonaNatural;
	}
	
	@RequestMapping(value = "/getByTipoDocumento/{keyTipoDocumento}/{numeroDocumento}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody GenmPersonaNatural getByTipoDocumento(@PathVariable String keyTipoDocumento,
			@PathVariable String numeroDocumento, HttpSession session) {
		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		GenmPersonaNatural genmPersonaNatural = new GenmPersonaNatural();

		genmPersonaNatural = genmPersonaNaturalService.getByTipoDocumento(keyAuth, keyTipoDocumento, numeroDocumento);
		return genmPersonaNatural;
	}
	
	@RequestMapping(value = "/Save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody GenmPersonaNatural SavePersonaNatural(@RequestBody GenmPersonaNatural genmPersonaNatural ,HttpSession session){
		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		
		genmPersonaNatural = genmPersonaNaturalService.SaveOrUpdate(genmPersonaNatural, keyAuth);
		
		return genmPersonaNatural;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody GenmPersonaNatural getPersonaNaturalByKey(@PathVariable String id,HttpSession session){
		String keyAuth = session.getAttribute("keyAuth").toString().trim();
		GenmPersonaNatural genmPersonaNatural = new GenmPersonaNatural();
		genmPersonaNatural = genmPersonaNaturalService.getById(id, keyAuth);
		
		return genmPersonaNatural;
	}

}
