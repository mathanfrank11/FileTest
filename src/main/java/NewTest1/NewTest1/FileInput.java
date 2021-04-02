package NewTest1.NewTest1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class FileInput {
	
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
		// TODO Auto-generated method stub
		
		csvToXLSX();
		
	/*	Scanner sc = new Scanner(new File("W:\\CSVDemo.csv"));  
		sc.useDelimiter(",");     
		while (sc.hasNext())    
		{  
		System.out.print(sc.next());    
		}   
		sc.close();*/    

	}

}
