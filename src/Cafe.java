import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {

    // Opgave 6

    ArrayList<Drink> coffeeMenu = new ArrayList<>();

    public void loadData(){

        File file = new File("data/menu.csv");
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while(scan.hasNextLine()){
                String s = scan.nextLine();
                String[] data = s.split(",");

                String name = data[0];
                int price = Integer.parseInt(data[1].trim());
                int soldnumber = Integer.parseInt(data[2].trim());

                Drink d = new Drink(name,price,soldnumber);
                coffeeMenu.add(d);
            }
            scan.close();
        } catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }

    }

    public void saveData(){
        try {
            FileWriter writer = new FileWriter("data/menu.csv");

            writer.write("Name,Price,SoldNumber\n");

            for (Drink d : coffeeMenu) {
                writer.write(d.toString()+ "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== CAFE MENU ===");

            for (int i = 0; i < coffeeMenu.size(); i++) {
                Drink drink = coffeeMenu.get(i);
                System.out.println((i + 1) + ". " + drink.getName() + " - " + drink.getPrice() + " kr."
                        + " (Solgt: " + drink.getSoldNumber() + ")");
            }

            System.out.println("0. Afslut");
            System.out.print("Vælg en kaffe: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Indtast et tal.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                running = false;
                saveData();
                System.out.println("Data er gemt!");
            } else if (choice >= 1 && choice <= coffeeMenu.size()) {
                Drink drinkChoice = coffeeMenu.get(choice - 1);
                drinkChoice.setSoldNumber(drinkChoice.getSoldNumber() + 1);
                System.out.println(drinkChoice.getName() + " er blevet solgt!");
                saveData();
            } else {
                System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
}





