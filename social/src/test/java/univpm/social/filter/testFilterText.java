package univpm.social.filter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;
import univpm.social.filters.FilterName;

class testFilterText {

    
	/*
	     Testo che se passo un nome non presente negli albums , in questo caso "pasquale"
	     il metodo della sottoclasse FilterName mi stampa un jsonobject di 
	     avvertimento/errore
	 */
	
	
	@Test
	void test() throws IOException, FileException {
        
		FilterName filter = new FilterName();
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("ERROR", "NESSUN ALBUM TROVATO CON IL NOME pasquale");
		Assertions.assertEquals(jsonobject,filter.filterForName("pasquale"));
	}

}
