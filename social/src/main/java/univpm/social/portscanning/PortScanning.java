package univpm.social.portscanning;

import java.io.IOException;
import java.net.ServerSocket;

public final class PortScanning {
	
	/*
	    Questo metodo statico della classe final ritorna un oggetto
	    ServerSocket oppure null. Il funzionamento è semplice , tenta di
	    generare/aprire porte a partire dalla 8080 , se ci riesce ritorna 
	    il serversocket altrimenti cattura un eccezione e continua con la prossima
	    porta, fino a trovare una porta libera.
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
