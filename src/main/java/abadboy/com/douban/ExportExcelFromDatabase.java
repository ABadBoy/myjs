package abadboy.com.douban;

import abadboy.com.util.DatabaseUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ExportExcelFromDatabase {

	public static void main(String[] args) {

		try {

			Workbook wb = new XSSFWorkbook();
			CreationHelper createHelper = wb.getCreationHelper();
			CellStyle hlink_style = wb.createCellStyle();
			Font hlink_font = wb.createFont();
			hlink_font.setUnderline(Font.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);

			Sheet sheet = wb.createSheet("houseList");
			Row headRow = sheet.createRow(0);
			headRow.createCell(0).setCellValue("HOUSELINK");
			headRow.createCell(1).setCellValue("HOUSEMESSAGE");
		    headRow.createCell(2).setCellValue("USERLINK");
			headRow.createCell(3).setCellValue("USERMESSAGE");
			headRow.createCell(4).setCellValue("RESPONSE");
			headRow.createCell(5).setCellValue("TIME");

			PreparedStatement statement = DatabaseUtil.getConnection().prepareStatement("SELECT * FROM douban");
			ResultSet resultSet = statement.executeQuery();

			int row = 1;
			while (resultSet.next()) {
				Row dataRow = sheet.createRow(row);

				Cell houseLinkCell = dataRow.createCell(0);
				Hyperlink link1 = createHelper.createHyperlink(Hyperlink.LINK_URL);
				link1.setAddress(resultSet.getString(2));
				houseLinkCell.setCellValue(resultSet.getString(2));
				houseLinkCell.setHyperlink(link1);
				houseLinkCell.setCellStyle(hlink_style);

				dataRow.createCell(1).setCellValue(resultSet.getString(3));

				Cell userLinkCell = dataRow.createCell(2);
				Hyperlink link2 = createHelper.createHyperlink(Hyperlink.LINK_URL);
				link2.setAddress(resultSet.getString(4));
				userLinkCell.setCellValue(resultSet.getString(4));
				userLinkCell.setHyperlink(link2);
				userLinkCell.setCellStyle(hlink_style);

				dataRow.createCell(3).setCellValue(resultSet.getString(5));
				dataRow.createCell(4).setCellValue(resultSet.getString(6));
				dataRow.createCell(5).setCellValue(resultSet.getString(7));
				row++;
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			FileOutputStream fileOut = new FileOutputStream("E:/workbook.xlsx");
			wb.write(fileOut);
			fileOut.close();


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
