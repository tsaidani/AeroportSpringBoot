<<<<<<< Updated upstream
package aeroportSpringBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aeroportSpringBoot.model.Login;
import aeroportSpringBoot.repositories.LoginRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> opt = loginRepository.findByIdWithRoles(username);

		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get());
		} else {
			throw new UsernameNotFoundException("utilisateur inconnu");
		}
	}

}
=======
package aeroportSpringBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aeroportSpringBoot.model.Login;
import aeroportSpringBoot.repositories.LoginRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> opt = loginRepository.findByIdWithRoles(username);

		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get());
		} else {
			throw new UsernameNotFoundException("utilisateur inconnu");
		}
	}

}
>>>>>>> Stashed changes
