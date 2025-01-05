package Opgave1_IndkøbksKurven;

public class Food extends Product{
    private String expireDate;

    public Food(String expireDate, String name, double price){
        super(name, price);
        this.expireDate = expireDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    @Override
    public String toString(){
        return getName() + ", " + expireDate + ": " + getPrice();
    }
}
