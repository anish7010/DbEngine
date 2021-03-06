import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCheck {

	public ArrayList<String[]> allData() {
		BufferedReader br = null;
        //list of string arrays
        ArrayList<String[]> rowList = new ArrayList<String[]>();
        try {
			br = new BufferedReader(new FileReader("/home/anish7010/Documents/workspace-sts-3.9.2.RELEASE/CsvFileReader/csv/ipl.csv"));
			String line;
			String[] arr;
	        //got the column names
			while ((line = br.readLine()) != null) {
				arr = line.split(",");
		        //everything stored in this list
				rowList.add(arr);
			}
			
									
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return rowList;
	}
	
	public ArrayList<String> getDatatype(ArrayList<String[]> rowList) {
		//contains the first row
		String[] columns = rowList.get(1);
		//for integers and date
		Pattern number = Pattern.compile("[0-9]+");
		Pattern date = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
		Matcher m;
				
		ArrayList<String> datatype = new ArrayList<>();
		for(String s : columns) {
			m = date.matcher(s);
			if(m.find()) {
				datatype.add("Date");
			}
			else {
				m = number.matcher(s);
				if(m.find())
					datatype.add("Integer");
				else
					datatype.add("String");
			}
		}
		return datatype;

	}
	
}