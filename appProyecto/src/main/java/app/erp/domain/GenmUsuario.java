package app.erp.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
 * @Autor: Cristhian Huangal
 * @Fecha: 06/02/2016
 * @Motivo: Entidad definida para los usuarios del sistema
 */

public class GenmUsuario extends GenmDomain {
	
	private Integer id_usuario;
	private String login;
	private String contrasena;
	private Boolean flg_estado;
	private Date fec_reg;
	private Date fec_act;
	private Integer id_usu_act;
	private Integer id_persona_natural_genm_persona_natural;
	public String key_id_persona_natural_genm_persona_natural;
	private Integer id_usu_reg;
	
	private String encryptedPassword;
	private List<MaePerfil> listaMaePerfil = new ArrayList<MaePerfil>();
    private Integer failedLoginAttempts = 0;
    private Integer id_tipo_documento_mae_tipo_documento;
    private GenmPersonaNatural genmPersonaNatural;
    private List<MaeAccesoMenu> listaMaeAccesoMenu = new ArrayList<MaeAccesoMenu>();    

	public GenmPersonaNatural getGenmPersonaNatural() {
		return genmPersonaNatural;
	}



	public void setGenmPersonaNatural(GenmPersonaNatural genmPersonaNatural) {
		this.genmPersonaNatural = genmPersonaNatural;
	}



	public String getEncryptedPassword() {
		return encryptedPassword;
	}



	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public Integer getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(Integer failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

		
	public GenmUsuario() {
	}
	
	

	public GenmUsuario(Integer id_usuario, String login, String contrasena, Boolean flg_estado, Date fec_reg,
			Date fec_act, Integer id_usu_act, Integer id_persona_natural_genm_persona_natural, Integer id_usu_reg) {
		super();
		this.id_usuario = id_usuario;
		this.login = login;
		this.contrasena = contrasena;
		this.flg_estado = flg_estado;
		this.fec_reg = fec_reg;
		this.fec_act = fec_act;
		this.id_usu_act = id_usu_act;
		this.id_persona_natural_genm_persona_natural = id_persona_natural_genm_persona_natural;
		this.id_usu_reg = id_usu_reg;
	}



	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Boolean getFlg_estado() {
		return flg_estado;
	}

	public void setFlg_estado(Boolean flg_estado) {
		this.flg_estado = flg_estado;
	}

	public Date getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(Date fec_reg) {
		this.fec_reg = fec_reg;
	}

	public Date getFec_act() {
		return fec_act;
	}

	public void setFec_act(Date fec_act) {
		this.fec_act = fec_act;
	}

	public Integer getId_usu_act() {
		return id_usu_act;
	}

	public void setId_usu_act(Integer id_usu_act) {
		this.id_usu_act = id_usu_act;
	}

	public Integer getId_persona_natural_genm_persona_natural() {
		return id_persona_natural_genm_persona_natural;
	}

	public void setId_persona_natural_genm_persona_natural(Integer id_persona_natural_genm_persona_natural) {
		this.id_persona_natural_genm_persona_natural = id_persona_natural_genm_persona_natural;
	}

	public Integer getId_usu_reg() {
		return id_usu_reg;
	}

	public void setId_usu_reg(Integer id_usu_reg) {
		this.id_usu_reg = id_usu_reg;
	}



	public Integer getId_tipo_documento_mae_tipo_documento() {
		return id_tipo_documento_mae_tipo_documento;
	}



	public void setId_tipo_documento_mae_tipo_documento(Integer id_tipo_documento_mae_tipo_documento) {
		this.id_tipo_documento_mae_tipo_documento = id_tipo_documento_mae_tipo_documento;
	}



	public List<MaePerfil> getListaMaePerfil() {
		return listaMaePerfil;
	}



	public void setListaMaePerfil(List<MaePerfil> listaMaePerfil) {
		this.listaMaePerfil = listaMaePerfil;
	}



	public List<MaeAccesoMenu> getListaMaeAccesoMenu() {
		return listaMaeAccesoMenu;
	}



	public void setListaMaeAccesoMenu(List<MaeAccesoMenu> listaMaeAccesoMenu) {
		this.listaMaeAccesoMenu = listaMaeAccesoMenu;
	}



	public String getKey_id_persona_natural_genm_persona_natural() {
		return key_id_persona_natural_genm_persona_natural;
	}



	public void setKey_id_persona_natural_genm_persona_natural(String key_id_persona_natural_genm_persona_natural) {
		this.key_id_persona_natural_genm_persona_natural = key_id_persona_natural_genm_persona_natural;
	}
	
	
	
}
