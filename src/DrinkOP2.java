public class DrinkOP2 {

    // Opgave 2

    private double price;

    public DrinkOP2(double price){
        this.price = price;
    }

    public void setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException("Dette er ikke en valid pris: " + price);
        }
        this.price = price;
    }


}
