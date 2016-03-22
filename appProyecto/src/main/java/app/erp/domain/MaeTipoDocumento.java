package app.erp.domain;

import java.sql.Date;

public class MaeTipoDocumento extends GenmDomain {
	private Integer id_tipo_documento;
	private String descripcion_tipo_documento;
	private Boolean flg_estado;
	private Date fec_reg;
	private Date fec_act;
	private Integer id_usu_act;
	private Integer id_usu_reg;
	
	public Integer getId_tipo_documento() {
		return id_tipo_documento;
	}
	public void setId_tipo_documento(Integer id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}
	public String getDescripcion_tipo_documento() {
		return descripcion_tipo_documento;
	}
	public void setDescripcion_tipo_documento(String descripcion_tipo_documento) {
		this.descripcion_tipo_documento = descripcion_tipo_documento;
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
	
	
}
