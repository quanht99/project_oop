import controller.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập từ bạn muốn tra:");
            String test = sc.nextLine();
            String detail = controller.findWord(test);
            //String[] detail = controller.suggestionWord(test);
            //String[] result = detail.split(";");
//            for(int i=0 ; i<detail.length; i++){
//                System.out.println(detail[i]);
//            }

            if(detail!=null && !detail.equals("")){
                String[] result = detail.split(";");
                System.out.println(test + ":");
                for (String aResult : result) {
                    System.out.println("          +" + aResult);
                }
            }
            else{
                System.out.println("Từ bạn nhập không có trong từ điển");
            }
        }
    }
}