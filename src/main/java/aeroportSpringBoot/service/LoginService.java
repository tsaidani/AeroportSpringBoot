package aeroportSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Login;
import repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	
	public void CreateLogin(Login login) {
		loginRepository.save(login);
	}
	
	public void changeLogin(String oldLogin,String newLogin) {
		
		Optional<Login> opt=loginRepository.findWithName(oldLogin);
		if( opt.isPresent()){
			Login login=opt.get();
			login.setLogin(newLogin);
			loginRepository.save(login);
		}
		}
		
		
	public String showMdp(String login) {
		Optional<Login> opt=loginRepository.findWithName(login);
		if( opt.isPresent()){
			Login log=opt.get();
			 return log.getMotDePasse();
		}else {
			return "y a rien";
		}
	}
		
	public String showLogin(Login login) {
		Optional<Login> opt=loginRepository.findById(login.getId());
		if( opt.isPresent()){
			Login log=opt.get();
			return log.getLogin();
	}else {
		return "y a rien";
	}
	}
	
	public void EraseLogin(Login login) {
		loginRepository.delete(login);
	}
	
	public List<Login> showAllLogin(){
		return loginRepository.findAll();
		
	}
}
