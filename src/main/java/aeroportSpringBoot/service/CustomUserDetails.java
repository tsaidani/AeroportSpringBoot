package aeroportSpringBoot.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import aeroportSpringBoot.model.Login;

public class CustomUserDetails implements UserDetails {

	private Login login;

	public CustomUserDetails(Login login) {
		this.login = login;
	}

	// methode qui renvoie les roles (sous forme de GrantedAuthority)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils
				.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(login.getRoles()));
	}

	@Override
	public String getPassword() {
		return login.getMotDePasse();
	}

	@Override
	public String getUsername() {
		return login.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return login.getAdmin_id();
	}

}
