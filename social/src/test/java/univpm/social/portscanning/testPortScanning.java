package univpm.social.portscanning;

import static org.junit.jupiter.api.Assertions.*;

import java.net.ServerSocket;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testPortScanning {

	 /*
	     Test sul funzionamento del metodo statico della classe PortScanning
	     Occupo cento porte e poi vedo se il mio algoritmo funziona 
	 */
	
	
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<ServerSocket> port = new ArrayList();
	   
	   int numberPort = 8080;
	   for(int i=0 ; i<100 ; i++) 
	     {
		   ServerSocket singlePort = new ServerSocket(numberPort);
		   port.add(singlePort);
		   numberPort++;
	     }
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
