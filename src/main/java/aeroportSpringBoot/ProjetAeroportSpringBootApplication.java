package aeroportSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjetAeroportSpringBootApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetAeroportSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(passwordEncoder.encode("root"));
	}
}
