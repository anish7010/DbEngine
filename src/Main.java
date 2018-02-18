import java.util.ArrayList;
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
        
        
        //to make sure it is the query of this particular object
        String query = qp.getQuery();
        //object for performing methods on file
        FileCheck fc = new FileCheck();
        ArrayList<String[]> al = new ArrayList<>();
        //contains all the data from the csv file in a 2d array format
        al = fc.allData();
        //contains the datatype of each column
        ArrayList<String> data = fc.getDatatype(al);
        
        
        		
        scanner.close();
    }
}