package univpm.social.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import univpm.social.filters.FilterImpl;





class testBadParameterException {

	FilterImpl filterImpl = new FilterImpl();

	/*
	   Testo l'errore nel caso di una data con anno sbagliato ma mese e giorno
	   accettabili
	 */
    
	
	@Test
	void testYear() {
         
		// Testo il funzionamento della classe di errori personalizzata, al variare dei
		// parametri, ossia anno , mese e giorno
		
		// Anno sbagliato , mese e giorno ok
		BadParameterException thrownYear = Assertions.assertThrows(BadParameterException.class, () -> {
			filterImpl.filter("3050", "12", "12");
		});
		
		Assertions.assertEquals("ANNO NON VALIDO ! VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE ", thrownYear.getMessage());
		
		
	}
}
