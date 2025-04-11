package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\LoginData.xlsx";
		ExcelUtility xlUtil = new ExcelUtility(path);

		int totalRowCount = xlUtil.getRowCount("Sheet1");
		int totalCellCount = xlUtil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalRowCount][totalCellCount];

		for (int i = 1; i <= totalRowCount; i++) {
			for (int j = 0; j < totalCellCount; j++) {
				loginData[i - 1][j] = xlUtil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}
}
