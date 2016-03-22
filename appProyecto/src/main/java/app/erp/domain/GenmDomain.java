package app.erp.domain;

public class GenmDomain {
	private Boolean flg_result;
	private String message;
	private String key;
	private Integer numPagina;
	private Integer cantPagina;
	private Integer total;
	private String keyUser;
	
	public Boolean getFlg_result() {
		return flg_result;
	}
	public void setFlg_result(Boolean flg_result) {
		this.flg_result = flg_result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getNumPagina() {
		return numPagina;
	}
	public void setNumPagina(Integer numPagina) {
		this.numPagina = numPagina;
	}
	public Integer getCantPagina() {
		return cantPagina;
	}
	public void setCantPagina(Integer cantPagina) {
		this.cantPagina = cantPagina;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	/**
	 * @return the keyUser
	 */
	public String getKeyUser() {
		return keyUser;
	}
	/**
	 * @param keyUser the keyUser to set
	 */
	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}
	
	
}
