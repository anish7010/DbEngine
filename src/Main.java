import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    	//to be input by the user
        String user_query;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your query : ");
        user_query = scanner.nextLine();
        
        //object of QueryParameter class
        QueryParamteter qp = new QueryParamteter();
        qp.setQuery(user_query);
        
        //to make sure it is the query of this particular object
        String query = qp.getQuery();
        
        //reading a csv file
        BufferedReader br = null;
        try {
			br = new BufferedReader(new FileReader("/home/anish7010/Documents/workspace-sts-3.9.2.RELEASE/CsvFileReader/csv/ipl.csv"));
	        //got the column names
			String line = br.readLine();
	        line = br.readLine();
	        String[] arr = line.split(",");
	        
	        
	        
	        
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
    }
}