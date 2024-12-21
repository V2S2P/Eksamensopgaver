package Opgave1_IndkøbksKurven;

public class Electronics extends Product{
    private int warranty;

    public Electronics(int warranty, String name, float price){
        super(name, price);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
    @Override
    public String toString(){
        return getName() + ", " + getWarranty() + " months warranty: " + getPrice() + " euro";
    }
}
