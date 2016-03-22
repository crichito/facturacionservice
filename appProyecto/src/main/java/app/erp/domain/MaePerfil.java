package app.erp.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MaePerfil extends GenmDomain  {
	private Integer id_perfil;
	private String descripcion;
	private Boolean flg_estado;
	private Date fec_reg;
	private Integer id_usu_reg;
	private Date fec_act;
	private Integer id_usu_act;
	private List<GenmUsuario> users = new ArrayList<>();
	public Integer getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public Integer getId_usu_reg() {
		return id_usu_reg;
	}
	public void setId_usu_reg(Integer id_usu_reg) {
		this.id_usu_reg = id_usu_reg;
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
	public List<GenmUsuario> getUsers() {
		return users;
	}
	public void setUsers(List<GenmUsuario> users) {
		this.users = users;
	}
	
}