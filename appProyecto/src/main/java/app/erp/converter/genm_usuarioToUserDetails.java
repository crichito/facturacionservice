package app.erp.converter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import app.erp.domain.GenmUsuario;

@Component
public class genm_usuarioToUserDetails implements Converter<GenmUsuario, UserDetails>  {

	@Override
	public UserDetails convert(GenmUsuario user) {
		/*UserDetailsImpl userDetails = new UserDetailsImpl();

        if (user != null) {
            userDetails.setUsername(user.getLogin());
            userDetails.setPassword(user.getContrasena());
            userDetails.setEnabled(user.getFlg_estado());

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getDescripcion()));
            });

            userDetails.setAuthorities(authorities);
        }

        return userDetails;*/
		return null;
	}

}
