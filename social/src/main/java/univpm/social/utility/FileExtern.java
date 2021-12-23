package univpm.social.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import univpm.social.exceptions.FileException;

/**
 * Questa classe si occupa della lettura del file di testo
 * WRITE_ME.txt per il giusto inserimento dell'id e
 * dell'access token per avviare il programma
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public class FileExtern {
	


	/*
	   Questa funzione ritorna il contenuto di un file , in questo caso i parametri
	   sono due. Il primo , ovvero path , identifica il percorso del file  
	   che coinciderà con il nome del file per come è stato posizionato il file 
	   mentre il secondo è un valore booleano. Se il valore booleano è settato
	   su true , esegue un controllo per verificare se la seconda riga è alfanumerica
	   oppure no ed altri controlli; se false lancia un eccezione.
	   Questo è utile perchè mi consente di generalizzare il mio metodo ovvero di 
	   utilizzarlo sia per la lettura del WRITE_ME.txt che per la lettura
	   del file GOOD_REQUEST.txt
	 */
	
	/**
	 * Questo metodo ritorna il contenuto di un file 
	 * 
	 * @param path identifica il percorso del file che coinciderà con il nome del file per come è stato posizionato il file
	 * @param check valore booleano
	 * @return se check è true , esegue un controllo per verificare se la seconda riga è alfanumerica e altri controlli; se false lancia un eccezione
	 * @throws FileException se ciò che è stato inserito nel file di testo è incorretto
	 * @throws IOException se il nome del file di testo è errato
	 */
	
	public static ArrayList<String> readFromFile(String path , boolean check) throws FileException, IOException 
	{
		
		ArrayList<String> toGive = new ArrayList() ;
	// throw new IOException("FILE NON ESISTENTE !");
	try {	
	       FileInputStream fstream = new FileInputStream(path);	
	       BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	       String strLine;	  
;       
            String line = br.readLine();
			while (line != null) 
			    {
				   toGive.add(line);
				   line = br.readLine();
       			}
          
           // Se sono arrivato a questo punto vuol dire che il file è stato letto
           // ora devo capire se i parametri sono ammisibili , ad esempio se il
           // token di accesso è alfanumerico oppure no
          
		  if(toGive.isEmpty())
			  throw new NullPointerException("ATTENZIONE IL FILE "+path+" E' VUOTO !"); 
		  
          if(check && !toGive.isEmpty()) 
          {

            if(toGive.size()==1)
          	  throw new FileException("ATTENZIONE ! TUTTE LE INFO SONO SU UN UNICA RIGA");
      	  
      	  if(toGive.size()>2)
      	    {   
      	      if(toGive.get(2).isBlank() || toGive.get(1).isBlank())
      		     throw new FileException("SBAGLIATO ! DEVI INSERIRE IL TOKEN SPLITTATO NELLA SECONDA E TERZA RIGA");
      	    }
      		else if(toGive.size()==2)
      			    throw new FileException("ATTENZIONE ! SPLITTA LO USER TOKEN NELLA SECONDA E TERZA RIGA");
      	      
      		
      		String verify = toGive.get(1) + toGive.get(2); // lo user token sarà sulla prima e seconda riga
            	  if(!verify.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")) 
          	      throw new FileException("ATTENTO , PROBABILMENTE NON HAI INSERITO CORRETAMENTE LO USER TOKEN");
          }
              
           
           fstream.close();
         
	    } catch(IOException e) 
	        {
		       throw new IOException("ATTENZIONE IL FILE "+path+" NON ESISTE !");
	        }
 
	
	
	 return toGive;
    }

}