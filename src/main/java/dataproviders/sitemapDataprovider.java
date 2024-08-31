package dataproviders;

import org.testng.annotations.DataProvider;

import generic.getExcelData;

public class sitemapDataprovider {

	@DataProvider
	public Object[][] devicesAndResolutions() throws Throwable {

		int rowCount = getExcelData.getRowCount("./data/DevicesAndResolutions.xlsx", "DevicesResolutions");
		int colsCount = getExcelData.getColsCount("./data/DevicesAndResolutions.xlsx", "DevicesResolutions", 1);

		Object[][] data = new Object[rowCount][colsCount];
		
		for (int i = 1; i <= rowCount; i++) {
	        data[i - 1][0] = getExcelData.getData("./data/DevicesAndResolutions.xlsx", "DevicesResolutions", i, 0); // Device as String
	        data[i - 1][1] = Integer.parseInt(getExcelData.getData("./data/DevicesAndResolutions.xlsx", "DevicesResolutions", i, 1)); // Width as int
	        data[i - 1][2] = Integer.parseInt(getExcelData.getData("./data/DevicesAndResolutions.xlsx", "DevicesResolutions", i, 2)); // Height as int
	    }
		return data;
	}
}
