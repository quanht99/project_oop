import java.util.Scanner;

public class DictionaryManagement{
    public void insertFromCommandline(Word newWord){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu: ");
        String Target = sc.nextLine();
        newWord.setWordTarget(Target);
        System.out.println("Nghia: ");
        String Explain = sc.nextLine();
        newWord.setWordExplain(Explain);
        sc.close();
    }
}