package app.erp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * @Autor: Cristhian Huangal
 * @Fecha: 06/02/2016
 * @Motivo: Clase abstracta para inicializar la conexion a base de datos
 */

public abstract class AbstractDao {
	 protected JdbcTemplate jdbcTemplate;
	 protected Connection conn;
	  
	  @Autowired
	  public void setDataSource(DataSource dataSource){
	    jdbcTemplate = new JdbcTemplate(dataSource);
	  }
	  
	  @Autowired
	  public void setConn(DataSource dataSource) throws SQLException {
		  conn = dataSource.getConnection();

	  }
	  
}
