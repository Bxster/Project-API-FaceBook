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
   
   
	/*
	    Test sul mese: anno e giorno OK , mese non corretto .
	 */
   
	
	@Test
	void testMonth() {
		
		BadParameterException thrownMonth = Assertions.assertThrows(BadParameterException.class, () -> {
			filterImpl.filter("2010", "20", "12");
		});
		
		Assertions.assertEquals("MESE NON VALIDO ! VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE ", thrownMonth.getMessage());
	}
	
	
	
	/*
        Testo il funzionamento del eccezione nel caso del solo giorno 
        sbagliato mentre il mese e l'anno sono corretti 
    */	
	
	@Test
	void testDay() {
		
		BadParameterException thrownDay = Assertions.assertThrows(BadParameterException.class, () -> {
			filterImpl.filter("2010", "12", "50");
		});
		
		Assertions.assertEquals("GIORNO NON VALIDO ! VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE ", thrownDay.getMessage());
		
	}
	
	
	
	/*
         Caso limite : anno sbagliato , mese e giorno sbagliati
   */



    @Test
    void testNoZeroAllWrongs() {
	
	BadParameterException thrown = Assertions.assertThrows(BadParameterException.class, () -> {
		filterImpl.filter("2059", "19", "500");
	});
	
	Assertions.assertEquals("ANNO NON VALIDO ! VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE ", thrown.getMessage());
	
    }
    
    
    /*
       Ulteriore caso limite anno = 0 , mese e giorno non passati
     */
    
    
	@Test
	void allWrongsZero() 
	{
		BadParameterException thrown = Assertions.assertThrows(BadParameterException.class, () -> {
			filterImpl.filter("0","0","0");
		});
		
		Assertions.assertEquals("NON POSSO FILTRARE SE TUTTI I PARAMETRI SONO NULLI", thrown.getMessage());
	}
		
		
	}

