package univpm.social.portscanning;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Questa final class serve per aprire le porte
 * per il funzionamento del programma tramite Tomcat 
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public final class PortScanning {
	
	
	
	/**
	 * Questo metodo statico della classe final tenta di 
	 * generare/aprire porte a partire dalla 8080, se ci riesce ritorna 
	 * il serversocket altrimenti cattura un eccezione e continua
	 * con la prossima porta, fino a trovare una porta libera
	 * 
	 * @return un oggetto ServerSocket oppure null
	 */
	
    public static ServerSocket getPort() 
    {

       	ServerSocket serverSocket = null;
    		for (int port = 8080 ; port < 65535 ; port++) {
    	        try {
    	               serverSocket = new ServerSocket(port);
    	               return serverSocket;
    	        } catch (IOException ex) {
    	            continue; 
    	        }
    	       
    }
    		return null;
    		}

}
