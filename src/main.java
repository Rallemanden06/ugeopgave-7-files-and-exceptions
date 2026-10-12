import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        // Opgave 1
        UI ui = new UI();
        ui.promptNumber("Skriv et tal:");

        // Opgave 2.a

        DrinkOP2 drink1 = new DrinkOP2(0);

        try{
            drink1.setPrice(50);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        try{
            drink1.setPrice(-50);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        // Opgave 2.b
        ArrayList<String> items = new ArrayList<>();

        items.add("1");
        items.add("2");

        try{
            getItem(items,1);
            } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
        try{
            getItem(items,2);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        //Opgave 3.a
        /*
        try{
            ArrayList<String> lines = readLines("blabla/something.csv");
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
         */

        // Opgave 3.b
        try{
            ArrayList<String> lines = readLines("blabla/something.csv");
            for (String line : lines){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
           System.out.println("Filen blev ikke fundet");
        }

        // Opgave 4 og 5
        ArrayList<String> data = new ArrayList<>();
        data.add("Espresso, En kraftfuld og koncentreret kaffe, 25.0");
        data.add("Latte, Espresso med dampet mælk, 45.0");
        data.add("Cola, Kold og brusende, 30.0");
        data.add("Vand, Stille kildevand, gratis");

        double total = 0;
        for (String da : data) {
            String[] values = da.split(",");
            String name = values[0].trim();
            String description = values[1].trim();
            try {
                double price = Double.parseDouble(values[2].trim());
                total += price;
                System.out.println(name + " - " + description + "(" + price + " kr)");
            } catch (NumberFormatException nfe) {
                System.out.println("price kan kun være tal");
            }
        }
        System.out.println("Total price: " + total + " kr");

        //Opgave 6

        Cafe cafe = new Cafe();

        cafe.loadData();
        cafe.showMenu();

    }


    // Opgave 2.b
    public static String getItem(ArrayList<String> items, int index){
        if (index < 0 || index > items.size()-1) {
            throw new IllegalArgumentException("Indeks " + index + " er uden for range 0 - " + (items.size() - 1));
        }
        return items.get(index);
    }

    // Opgave 3.a
    /*
    public static ArrayList<String> readLines(String path) throws FileNotFoundException{
        ArrayList<String> lines = new ArrayList<>();
        Scanner scan = new Scanner(new File(path));
        scan.nextLine();
        while(scan.hasNextLine()){
            lines.add(scan.nextLine());
        }
        scan.close();
        return lines;
    }
     */

    // Opgave 3.b
    public static ArrayList readLines(String path) throws FileNotFoundException {
        ArrayList lines = new ArrayList<>();
        Scanner scan = new Scanner(new File(path));
        while (scan.hasNextLine()) {
            lines.add(scan.nextLine());
        }
        scan.close();
        return lines;
    }




}
