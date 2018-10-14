import java.sql.SQLException;
import java.util.Scanner;

import static controller.controller.findWord;

public class main {
    public static void main(String args[]) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Seach: ");
            String text = sc.nextLine();
            String detail = findWord(text);
            if (!detail.equals("")) {
                System.out.println(text + ": " + detail);
            } else {
                System.out.println("Not found");
            }
            int check = 0;
            Scanner scc;
            do {
                scc = new Scanner(System.in);
                System.out.println("Continue (y || n) ?");
                String yOrn = scc.nextLine();
                yOrn = yOrn.toLowerCase();
                if (yOrn.equals("y")) {
                    check = 1;
                } else if (yOrn.equals("n")) {
                    check = 2;
                } else {
                    check = 0;
                }
            } while (check == 0);
            if (check == 2) {
                break;
            }
        }
    }
}