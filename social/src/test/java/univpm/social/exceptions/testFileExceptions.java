package univpm.social.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import univpm.social.utility.FileExtern;


class testFileExceptions {

    
	
	/*
	     Test nel caso del file WRITE_ME , NOTARE IL PARAMETRO TRUE 
	     NEL .ReadFromFile(... , true)
	 */
	
	// TODO LUCA : RIVEDERE QUESTA PARTE 
	@Test
	void  testUncorrectLine() throws IOException 
	{
		FileWriter file = new FileWriter("src\\test\\java\\com\\example\\demo\\WRITE_ME_TEST.txt");
		PrintWriter printFile = new PrintWriter(file);
		
		printFile.println("01246789");
		printFile.println("ashbahja5345");
		printFile.println(" ");
		printFile.println("dfanfkak456");
		printFile.close();
		
		String path = "src\\test\\java\\com\\example\\demo\\WRITE_ME_TEST.txt";
		FileException thrown = Assertions.assertThrows(FileException.class, () -> {
			FileExtern.readFromFile(path,true);
		});
		
		Assertions.assertEquals("SBAGLIATO ! DEVI INSERIRE IL TOKEN NELLA SECONDA E TERZA RIGA", thrown.getMessage());
	}
	

}
