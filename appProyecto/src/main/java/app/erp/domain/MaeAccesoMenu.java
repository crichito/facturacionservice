package app.erp.domain;

import java.sql.Date;

public class MaeAccesoMenu extends GenmDomain {
	private Integer id_acceso_menu;
	private String descripcion;
	private String ruta;
	private Boolean flg_estado;
	private Date fec_reg;
	private Date fec_act;
	private Integer id_usu_act;
	private Integer id_usu_reg;
	private Integer id_acceso_menu_ref;
	private MaePerfil maePerfil;
	private String icono;
	private Integer orden;
	private String keyref;
	
	public Integer getId_acceso_menu() {
		return id_acceso_menu;
	}
	public void setId_acceso_menu(Integer id_acceso_menu) {
		this.id_acceso_menu = id_acceso_menu;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
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
	public Integer getId_usu_reg() {
		return id_usu_reg;
	}
	public void setId_usu_reg(Integer id_usu_reg) {
		this.id_usu_reg = id_usu_reg;
	}
	public MaePerfil getMaePerfil() {
		return maePerfil;
	}
	public void setMaePerfil(MaePerfil maePerfil) {
		this.maePerfil = maePerfil;
	}
	public Integer getId_acceso_menu_ref() {
		return id_acceso_menu_ref;
	}
	public void setId_acceso_menu_ref(Integer id_acceso_menu_ref) {
		this.id_acceso_menu_ref = id_acceso_menu_ref;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getKeyref() {
		return keyref;
	}
	public void setKeyref(String keyref) {
		this.keyref = keyref;
	}
	
	
	
}
