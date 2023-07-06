package com.ungdungso.utility;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import com.ungdungso.dto.BidsNoticeDTO;

public class UserExcelExporter {
	
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<BidsNoticeDTO> lisBidsDTO;
     
    public UserExcelExporter(List<BidsNoticeDTO> lisBidsDTO) {
        this.lisBidsDTO = lisBidsDTO;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Report");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Số TBMT", style);      
        createCell(row, 1, "Chủ đầu tư", style);       
        createCell(row, 2, "Đơn vị mời thầu", style);    
        createCell(row, 3, "Tên gói thầu", style);
        createCell(row, 4, "Ngày đăng TBMT", style);
        createCell(row, 5, "Ngày đóng TBMT", style);
        createCell(row, 6, "Trạng thái", style);
        createCell(row, 7, "Lĩnh vực", style);
        createCell(row, 8, "Hình thức", style);
        createCell(row, 9, "Giá gói thầu", style);
        createCell(row, 10, "Giá gói trúng thầu", style);
        createCell(row, 11, "Đơn vị trúng thầu", style);
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (BidsNoticeDTO bidsNoticeDTO : lisBidsDTO) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, bidsNoticeDTO.getNotifyNo(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getInvestorName(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getProcuringEntityName(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getBidName(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getPublicDate(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getBidCloseDate(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getStatus(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getInvestField(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getBidForm(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getBidPrice(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getBidWinningPrice(), style);
            createCell(row, columnCount++, bidsNoticeDTO.getContractorName(), style);
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();        
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();        
        outputStream.close();
         
    }

}
