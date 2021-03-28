package NewTest1.NewTest1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(new File("W:\\CSVDemo.csv"));  
		sc.useDelimiter(",");     
		while (sc.hasNext())    
		{  
		System.out.print(sc.next());    
		}   
		sc.close();    

	}

}
