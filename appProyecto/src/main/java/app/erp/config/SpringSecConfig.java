package app.erp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
			
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT login as username, contrasena as password, flg_estado as enabled "
						+ " FROM seguridad.genm_usuario where login=?")
				.authoritiesByUsernameQuery(
						"SELECT u.login as username, p.descripcion as role " + "FROM seguridad.gend_perfil_usuario a "
								+ "INNER JOIN seguridad.mae_perfil p on a.id_perfil_mae_perfil = p.id_perfil "
								+ "INNER JOIN seguridad.genm_usuario u on a.id_usuario_genm_usuario = u.id_usuario "
								+ " where u.login=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/h2-console").disable()
		
        .authorizeRequests().antMatchers("/**/favicon.ico") .permitAll()
        .and().authorizeRequests().antMatchers("/product/**").permitAll()
        .and().authorizeRequests().antMatchers("/webjars/**").permitAll()
        .and().authorizeRequests().antMatchers("/static/css").permitAll()
        .and().authorizeRequests().antMatchers("/js").permitAll()
        .and().formLogin().loginPage("/login").permitAll()
        .defaultSuccessUrl("/Main")
        .and().exceptionHandling().accessDeniedPage("/access_denied")
        .and().authorizeRequests().antMatchers("/Main").authenticated()
        .and().authorizeRequests().antMatchers("/").authenticated()
        .and().authorizeRequests().antMatchers("/userData").authenticated()
        //Usuarios
        .and().authorizeRequests().antMatchers("/Usuario/**").authenticated()
		//PersonaNatural
		.and().authorizeRequests().antMatchers("/PersonaNatural/***").authenticated();
		
	}

}