package app.erp.domain;

import java.sql.Date;

public class GenmPersonaNatural extends GenmDomain {
	private Integer id_persona_natural;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String numero_documento;
	private String correo_electronico;
	private Boolean flg_estado;
	private Date fec_reg;
	private Date fec_act;
	private Integer id_usu_act;
	private Integer id_usu_reg;
	private GenmUsuario genmUsuario;
	private MaeTipoDocumento maeTipoDocumento;
	private Integer id_tipo_documento_mae_tipo_documento;
	private String keyTipoDocumento;
		
	public MaeTipoDocumento getMaeTipoDocumento() {
		return maeTipoDocumento;
	}
	public void setMaeTipoDocumento(MaeTipoDocumento maeTipoDocumento) {
		this.maeTipoDocumento = maeTipoDocumento;
	}
	public Integer getId_persona_natural() {
		return id_persona_natural;
	}
	public void setId_persona_natural(Integer id_persona_natural) {
		this.id_persona_natural = id_persona_natural;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
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
	public GenmUsuario getGenmUsuario() {
		return genmUsuario;
	}
	public void setGenmUsuario(GenmUsuario genmUsuario) {
		this.genmUsuario = genmUsuario;
	}
	public Integer getId_tipo_documento_mae_tipo_documento() {
		return id_tipo_documento_mae_tipo_documento;
	}
	public void setId_tipo_documento_mae_tipo_documento(Integer id_tipo_documento_mae_tipo_documento) {
		this.id_tipo_documento_mae_tipo_documento = id_tipo_documento_mae_tipo_documento;
	}
	public String getKeyTipoDocumento() {
		return keyTipoDocumento;
	}
	public void setKeyTipoDocumento(String keyTipoDocumento) {
		this.keyTipoDocumento = keyTipoDocumento;
	}
	
	
}
