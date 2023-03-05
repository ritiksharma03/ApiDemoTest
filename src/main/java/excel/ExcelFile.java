package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	private String filePath;
	private String sheetName;

	public ExcelFile(String filePath, String sheetName) {
		this.filePath = filePath;
		this.sheetName = sheetName;
	}

	public String getConfigurationValue(String configName) {
		try (FileInputStream inputStream = new FileInputStream(filePath)) {
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			for (Row row : sheet) {
				Cell configCell = row.getCell(0);
				if (configCell != null && configCell.getStringCellValue().equalsIgnoreCase(configName)) {
					Cell valueCell = row.getCell(1);
					if (valueCell != null) {
						return valueCell.getStringCellValue();
					}
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
