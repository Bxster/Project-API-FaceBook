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
		FileWriter file = new FileWriter("src\\test\\java\\univpm\\social\\exceptions\\WRITE_ME_TEST.txt");
		PrintWriter printFile = new PrintWriter(file);
		
		printFile.println("01246789");
		printFile.println("ashbahja5345");
		printFile.println(" ");
		printFile.println("dfanfkak456");
		printFile.close();
		
		String path = "src\\test\\java\\univpm\\social\\exceptions\\WRITE_ME_TEST.txt";
		FileException thrown = Assertions.assertThrows(FileException.class, () -> {
			FileExtern.readFromFile(path,true);
		});
		
		Assertions.assertEquals("SBAGLIATO ! DEVI INSERIRE IL TOKEN NELLA SECONDA E TERZA RIGA", thrown.getMessage());
	}
	
	
	
	
	/*
	    Ora testo il file nel caso in cui non si il file GOOD_REQUEST e sia vuoto , 
	    tanto lo stesso discorso vale per il resto del file VOLGAR_NAME.txt;
	 */
	

	
	@Test
	void testEmptyFileException() throws NullPointerException, IOException 
	{
		FileWriter file = new FileWriter("src\\test\\java\\univpm\\social\\exceptions\\VOLGAR_NAME_TEST.txt");
		PrintWriter printFile = new PrintWriter(file);
		
		printFile.print("");
		printFile.close();
		
		String path = "src\\test\\java\\univpm\\social\\exceptions\\VOLGAR_NAME_TEST.txt";
		NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
			FileExtern.readFromFile(path,false);
		});
		
		Assertions.assertEquals("ATTENZIONE IL FILE "+path+" E' VUOTO !", thrown.getMessage());
	}
	
	
	/*
	        Questo test serve per verificare il corretto funzionamento del eccezione 
	        che viene lanciata nel caso in cui lo user token inserito non è corretto,
	        ovvero non sia una stringa alfanumerica. 
	 */
	
	@Test
	void testUncorrectUserTokenException() throws IOException {
		
		FileWriter file = new FileWriter("src\\test\\java\\univpm\\social\\exceptions\\WRITE_ME_TEST.txt");
		PrintWriter printFile = new PrintWriter(file);
		
		printFile.println("0123456789");
		printFile.println("abcdefghijk");
		printFile.println("zZv");
		printFile.close();
		
		FileException thrown = Assertions.assertThrows(FileException.class, () -> {
			FileExtern.readFromFile("src\\test\\java\\univpm\\social\\exceptions\\WRITE_ME_TEST.txt",true);
		});
		
		Assertions.assertEquals("ATTENTO , PROBABILMENTE NON HAI INSERITO CORRETAMENTE LO USER TOKEN", thrown.getMessage());
		
             
	}
	

}
