package univpm.social;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import univpm.social.portscanning.PortScanning;



@SpringBootApplication
@ComponentScan({"univpm.social.service","univpm.social.controller","univpm.social.exceptions"})
public class FacebookProjectApplication {

	public static void main(String[] args) {
		
		
		/*
		    Richiama il metodo statico della classe Final PortScanning
		    successivamente prende la porta libera e avvia l'applicazione
		    springboot.
    	*/
		
		String port = Integer.toString(PortScanning.getPort().getLocalPort());
		
		SpringApplication app = new SpringApplication(FacebookProjectApplication.class);
	        app.setDefaultProperties(Collections
	          .singletonMap("server.port", port));
	        app.run(args);
	}

}
