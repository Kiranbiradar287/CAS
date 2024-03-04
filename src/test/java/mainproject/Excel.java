package mainproject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static FileOutputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	 public static void writeToExcel(List<String> headingText, List<String> subText, List<String>tooltipText) throws IOException {
	        Workbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = (XSSFSheet) workbook.createSheet("Output");
	 
	        // Write headings
	        Row headingRow = sheet.createRow(0);
	        for (int i = 0; i < headingText.size(); i++) {
	            XSSFCell cell = (XSSFCell) headingRow.createCell(i);
	            cell.setCellValue(headingText.get(i));
	        }
	 
	        // Write subnames
	        for (int i = 0; i < subText.size(); i++) {
	            Row row = sheet.createRow(i + 1);
	            XSSFCell subnameCell = (XSSFCell) row.createCell(0);
	            subnameCell.setCellValue(subText.get(i));
	        }
	 
	        // Write tool names
	        for (int i = 0; i < tooltipText.size(); i++) {
	            Row row = sheet.getRow(i + 1);
	            XSSFCell toolCell = (XSSFCell) row.createCell(1);
	            toolCell.setCellValue(tooltipText.get(i));
	        }
	 
	        // Auto size columns
	        for (int i = 0; i < headingText.size(); i++) {
	            sheet.autoSizeColumn(i);
	        }
	        // Write workbook to file
	        try {
	            FileOutputStream fileOutputStream = new FileOutputStream("output.xlsx");
	            workbook.write(fileOutputStream);
	            workbook.close();
	            fileOutputStream.close();
	            System.out.println("Excel file created successfully.");
	        } catch (Exception e) {
	            System.out.println("Error creating Excel file: " + e.getMessage());
}
}
	 }