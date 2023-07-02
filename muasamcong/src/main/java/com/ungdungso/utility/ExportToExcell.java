package com.ungdungso.utility;

import java.io.IOException;
import java.util.List;
import com.ungdungso.dto.BidsNoticeDTO;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExportToExcell {
	public static final int COLUMN_INDEX_NOTIFYNO        	= 0;
    public static final int COLUMN_INDEX_BIDNAME      		= 1;
    public static final int COLUMN_INDEX_PUBLICDATE      	= 2;
    public static final int COLUMN_INDEX_STATUS   			= 3;
    public static final int COLUMN_INDEX_CONTRACTOR      	= 4;
    private static CellStyle cellStyleFormatNumber = null;
    
    public static void writeExcel(List<BidsNoticeDTO> listDataDTO, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
 
        // Create sheet
        Sheet sheet = workbook.createSheet("Books"); // Create sheet with sheet name
 
        int rowIndex = 0;
         
        // Write header
        writeHeader(sheet, rowIndex);
 
        // Write data
        rowIndex++;
        for (BidsNoticeDTO dataNoticeDTO : listDataDTO) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(dataNoticeDTO, row);
            rowIndex++;
        }
         
         
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
 

    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_NOTIFYNO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số TBMT");
 
        cell = row.createCell(COLUMN_INDEX_BIDNAME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên gói thầu");
 
        cell = row.createCell(COLUMN_INDEX_PUBLICDATE );
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày đăng TBMT");
 
        cell = row.createCell(COLUMN_INDEX_STATUS);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Trạng thái gói thầu");
 
        cell = row.createCell(COLUMN_INDEX_CONTRACTOR);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đơn vị trúng thầu");
    }
    
    // Write data
    private static void writeBook(BidsNoticeDTO dataNoticeDTO, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
             
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            //cellStyleFormatNumber = workbook.createCellStyle();
            //cellStyleFormatNumber.setDataFormat(format);
        }
         
        Cell cell = row.createCell(COLUMN_INDEX_NOTIFYNO);
        cell.setCellValue(dataNoticeDTO.getNotifyNo());
 
        cell = row.createCell(COLUMN_INDEX_BIDNAME);
        cell.setCellValue(dataNoticeDTO.getBidName());
 
        cell = row.createCell(COLUMN_INDEX_PUBLICDATE);
        cell.setCellValue(dataNoticeDTO.getPublicDate());
       // cell.setCellStyle(cellStyleFormatNumber);
 
        cell = row.createCell(COLUMN_INDEX_STATUS);
        cell.setCellValue(dataNoticeDTO.getStatus());
        
        cell = row.createCell(COLUMN_INDEX_CONTRACTOR);
        cell.setCellValue(dataNoticeDTO.getContractorName());
        //cell.setCellStyle(cellStyleFormatNumber);
        
         
        // Create cell formula
        // totalMoney = price * quantity
        //cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
       // cell.setCellStyle(cellStyleFormatNumber);
        //int currentRow = row.getRowNum() + 1;
       // String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_PRICE);
       // String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_QUANTITY);
        //cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
    }
 
    // Create CellStyle for header
    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     
         
    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
 
}


