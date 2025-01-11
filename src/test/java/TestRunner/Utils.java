package TestRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getCurrentTimestamp(){
       LocalDateTime now= LocalDateTime.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
       return now.format(formatter);
    }

    public static void main(String args[]){
        System.out.println(getCurrentTimestamp());
    }
}
