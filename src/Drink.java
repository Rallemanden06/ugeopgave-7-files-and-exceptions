public class Drink {

    //Opgave 6

    private String name;
    private int price;
    private int soldNumber;

    public Drink(String name, int price, int soldnumber) {
        this.name = name;
        this.price = price;
        this.soldNumber = soldnumber;
    }


    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

    public String getName() {
        return name;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return name + "," + price + "," + soldNumber;
    }
}
