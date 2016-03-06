package net.redirectme.per.calificador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class genXLS {
	private static final String[] titles = { "Fecha", "Excelente", "Bueno", "Regular", "Malo" };
	private Workbook wb;

	public void getData(String[][] data) throws IOException {

        wb = new HSSFWorkbook();
        
        Map<String, CellStyle> styles = createStyles(wb);

        Sheet sheet = wb.createSheet("Business Plan");

        //turn off gridlines
        sheet.setDisplayGridlines(false);
        sheet.setPrintGridlines(false);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);

        //the following three statements are required only for HSSF
        sheet.setAutobreaks(true);
        printSetup.setFitHeight((short)1);
        printSetup.setFitWidth((short)1);

        //the header row: centered text in 48pt font
        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < titles.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(styles.get("header"));
        }
        sheet.createFreezePane(0, 1);

        Row row;
        Cell cell;
        int rownum = 1;
        for (int i = 0; i < data.length; i++, rownum++) {
            row = sheet.createRow(rownum);
            if(data[i] == null) continue;

            for (int j = 0; j < data[i].length; j++) {
                cell = row.createCell(j);
                String styleName;
                boolean isHeader = i == 0 || data[i-1] == null;
                switch(j){
                    case 0:
                        if(isHeader) {
                            styleName = "cell_b";
                            cell.setCellValue(Double.parseDouble(data[i][j]));
                        } else {
                            styleName = "cell_normal";
                            cell.setCellValue(data[i][j]);
                        }
                        break;
                    case 1:
                        if(isHeader) {
                            styleName = i == 0 ? "cell_h" : "cell_bb";
                        } else {
                            styleName = "cell_indented";
                        }
                        cell.setCellValue(data[i][j]);
                        break;
                    case 2:
                        styleName = isHeader ? "cell_b" : "cell_normal";
                        cell.setCellValue(data[i][j]);
                        break;
                    case 3:
                        styleName = isHeader ? "cell_b_centered" : "cell_normal_centered";
                        cell.setCellValue(Integer.parseInt(data[i][j]));
                        break;
                    case 4: {
                    	styleName = isHeader ? "cell_b_centered" : "cell_normal_centered";
                        cell.setCellValue(Integer.parseInt(data[i][j]));
                        break;
                    }
                    case 5: {
                        int r = rownum + 1;
                        String fmla = "IF(AND(D"+r+",E"+r+"),E"+r+"+D"+r+",\"\")";
                        cell.setCellFormula(fmla);
                        styleName = isHeader ? "cell_bg" : "cell_g";
                        break;
                    }
                    default:
                        styleName = data[i][j] != null ? "cell_blue" : "cell_normal";
                }

                cell.setCellStyle(styles.get(styleName));
            }
        }

        //group rows for each phase, row numbers are 0-based
        sheet.groupRow(4, 6);
        sheet.groupRow(9, 13);
        sheet.groupRow(16, 18);

        //set column widths, the width is measured in units of 1/256th of a character width
        sheet.setColumnWidth(0, 256*6);
        sheet.setColumnWidth(1, 256*33);
        sheet.setColumnWidth(2, 256*20);
        sheet.setZoom(75,0); //75% scale

        // Write the output to a file
        String file = "businessplan.xls";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
    }

	/**
	 * create a library of cell styles
	 */
	private static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		DataFormat df = wb.createDataFormat();

		CellStyle style;
		Font headerFont = wb.createFont();
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("header", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(headerFont);
		style.setDataFormat(df.getFormat("d-mmm"));
		styles.put("header_date", style);

		Font font1 = wb.createFont();
		font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setFont(font1);
		styles.put("cell_b", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font1);
		styles.put("cell_b_centered", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		style.setFont(font1);
		style.setDataFormat(df.getFormat("d-mmm"));
		styles.put("cell_b_date", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		style.setFont(font1);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setDataFormat(df.getFormat("d-mmm"));
		styles.put("cell_g", style);

		Font font2 = wb.createFont();
		font2.setColor(IndexedColors.BLUE.getIndex());
		font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setFont(font2);
		styles.put("cell_bb", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		style.setFont(font1);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setDataFormat(df.getFormat("d-mmm"));
		styles.put("cell_bg", style);

		Font font3 = wb.createFont();
		font3.setFontHeightInPoints((short) 14);
		font3.setColor(IndexedColors.DARK_BLUE.getIndex());
		font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setFont(font3);
		style.setWrapText(true);
		styles.put("cell_h", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setWrapText(true);
		styles.put("cell_normal", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		styles.put("cell_normal_centered", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		style.setWrapText(true);
		style.setDataFormat(df.getFormat("d-mmm"));
		styles.put("cell_normal_date", style);

		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setIndention((short) 1);
		style.setWrapText(true);
		styles.put("cell_indented", style);

		style = createBorderedStyle(wb);
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styles.put("cell_blue", style);

		return styles;
	}

	private static CellStyle createBorderedStyle(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return style;
	}
}
