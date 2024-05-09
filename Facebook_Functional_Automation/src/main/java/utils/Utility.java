package utils;

public class Utility {

	//public static 
	//Repeted code
	
	// 1. to get data from exel sheet
	// 2. to take the screenshot
	
	public static String getDataExcelSheet(String sheetName,int rowNo, int cellNo) {
		
		
		
		String data = ""; 
//		
//		// start- file open
//		String path = "path"
//		
//				FlileInputStream file = new FileInputStream(path)
//		
//				Worbookfactory -----------
//				
//				try {
//						data = cell.getStringCellValue();	
//				}
//				catch(ExceptionName e)
//				{
//						double value = cell.getNumerticCellValue();
//						// how convert double/int to string convert 
//						data = double to string conversion ;
//				}
//		//End - file closed
		return data ;				
	}
	
	public static String getDateFromExcelSheet(String sheetName,int rowNo, int cellNo) {
		
		String text = "";
		// Code 
		
//		Date date = cell.GetDateCellValue();
		//text = // Convert Date into String
		return text ; // or retrun date ;
	}
	
	public static void captureScreenshot(String testID ) {
		
		// screenshot code 
		
		//Image name -  Test-testID-DateAndTime.jpg
		//      eg -    Test-T122 04-05-2023 08 12 34.jpg

	}
}
