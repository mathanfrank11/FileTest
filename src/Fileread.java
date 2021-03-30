import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Fileread {
	
	public static void csvToXLSX() {
	    try {
	        String csvFileAddress = "W:\\CSVDemo.csv"; //csv file address
	        String xlsxFileAddress = "W:\\test.xlsx"; //xlsx file address
	        XSSFWorkbook workBook = new XSSFWorkbook();
	        XSSFSheet sheet = workBook.createSheet("sheet1");
	        String currentLine=null;
	        int RowNum=0;
	        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
	        while ((currentLine = br.readLine()) != null) {
	            String str[] = currentLine.split(",");
	            RowNum++;
	            XSSFRow currentRow=sheet.createRow(RowNum);
	            for(int i=0;i<str.length;i++){
	                currentRow.createCell(i).setCellValue(str[i]);
	            }
	        }

	        FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
	        workBook.write(fileOutputStream);
	        fileOutputStream.close();
	        System.out.println("Done");
	    } catch (Exception ex) {
	        System.out.println(ex.getMessage()+"Exception in try");
	    }
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		/*Scanner sc = new Scanner(new File("W:\\CSVDemo.csv"));  
		sc.useDelimiter(",");   //sets the delimiter pattern  
		while (sc.hasNext())  //returns a boolean value  
		{  
		System.out.print(sc.next());  //find and returns the next complete token from this scanner  
		}   
		sc.close();  //closes the scanner  
*/		csvToXLSX();
	}

}
