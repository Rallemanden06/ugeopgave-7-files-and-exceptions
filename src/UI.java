import java.util.Scanner;

//Opgave 1

public class UI {
    static Scanner scan = new Scanner(System.in);

    public static int promptNumber(String msg){
        System.out.println(msg);
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Prøv igen");
            return promptNumber(msg);
        }
    }

}
