import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
       
        String query;
        System.out.println("Please input your query : ");
       
        Scanner scanner = new Scanner(System.in);
        query = scanner.nextLine();
        
        //space seperated values
        String[] query_broken = query.split(" ");
      
        //matching with pattern for .csv       
        Pattern p = Pattern.compile("[a-zA-Z0-9]+\\.csv");
        Matcher m = p.matcher(query);
        //all csv files
        ArrayList<String> csv_files = new ArrayList<String>();
        while(m.find()) {
            csv_files.add(m.group());
        }
       
        //split_where[0] gives before where and split_where[1] gives after where
        String[] split_where = query.split(" where ");
        /*split_where[1] gives the part after where
        extra spaces before and after and so it doesnt split at bangalore/england*/
        String[] conditions = split_where[1].split("( and | or )");
       
        //look up and look ahead so it doesnt return select and from
        Pattern p1 = Pattern.compile("(?<=select)(.*)(?=from)");
        Matcher m1 = p1.matcher(query);
        String fields = null;
        while(m1.find()){
        	fields = m1.group();
        }
        //stores the fields to be displayed
        String selected_fields[] = fields.split(",");
        
        Pattern p2 = Pattern.compile("(?<=order by)(.*)");
        Matcher m2 = p2.matcher(query);
        
        
        scanner.close();
        
        
    }
}