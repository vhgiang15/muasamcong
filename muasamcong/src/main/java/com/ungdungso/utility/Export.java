package com.ungdungso.utility;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.ungdungso.dto.BidsNoticeDTO;

public class Export {
	public static void writeExcel(List<BidsNoticeDTO> listDataDTO)
	{
		
		System.out.println("Create file excel");
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Customer_Info");
	    int rowNum = 0;
	    Row row = sheet.createRow(rowNum++);
	    Cell cell = row.createCell(0);
        cell.setCellValue("Số TBMT");
        cell = row.createCell(1);
        cell.setCellValue("Chủ đầu tư");
 
        cell = row.createCell(2);
        cell.setCellValue("Đơn vị mời thầu");
        
        cell = row.createCell(3);
        cell.setCellValue("Tên gói thầu");
 
        cell = row.createCell(4);
        cell.setCellValue("Ngày đăng TBMT");
 
        cell = row.createCell(5);
        cell.setCellValue("Ngày đóng TBMT");
        
        cell = row.createCell(6);
        cell.setCellValue("Trạng thái");
        
        cell = row.createCell(7);
        cell.setCellValue("Lĩnh vực");
        
        cell = row.createCell(8);
        cell.setCellValue("Hình thức");
        
        cell = row.createCell(9);
        cell.setCellValue("Giá gói thầu");
        cell = row.createCell(10);
        cell.setCellValue("Giá gói trúng thầu");
        cell = row.createCell(11);
        cell.setCellValue("Đơn vị trúng thầu");
  
	    for (BidsNoticeDTO bidsNoticeDTO : listDataDTO) {
	      row = sheet.createRow(rowNum++);
	      Cell cell0 = row.createCell(0);
	      cell0.setCellValue(bidsNoticeDTO.getNotifyNo());
	      Cell cell1 = row.createCell(1);
	      cell1.setCellValue(bidsNoticeDTO.getInvestorName());
	      Cell cell2 = row.createCell(2);
	      cell2.setCellValue(bidsNoticeDTO.getProcuringEntityName());
	      Cell cell3 = row.createCell(3);
	      cell3.setCellValue(bidsNoticeDTO.getBidName());
	      Cell cell4 = row.createCell(4);
	      cell4.setCellValue(bidsNoticeDTO.getPublicDate());
	      Cell cell5 = row.createCell(5);
	      cell5.setCellValue(bidsNoticeDTO.getBidCloseDate());
	      Cell cell6 = row.createCell(6);
	      cell6.setCellValue(bidsNoticeDTO.getStatus());
	      Cell cell7 = row.createCell(7);
	      cell7.setCellValue(bidsNoticeDTO.getInvestField());
	      Cell cell8 = row.createCell(8);
	      cell8.setCellValue(bidsNoticeDTO.getBidForm());
	      Cell cell9 = row.createCell(9);
	      cell9.setCellValue(bidsNoticeDTO.getBidPrice());
	      Cell cell10 = row.createCell(10);
	      cell10.setCellValue(bidsNoticeDTO.getBidWinningPrice());
	      Cell cell11 = row.createCell(11);
	      cell11.setCellValue(bidsNoticeDTO.getContractorName());

	    }
	    try {
	      FileOutputStream outputStream = new FileOutputStream("C:/demo/books.xlsx");
	      workbook.write(outputStream);
	      workbook.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Done");
	  }
		
		
		
		

	
	

}
