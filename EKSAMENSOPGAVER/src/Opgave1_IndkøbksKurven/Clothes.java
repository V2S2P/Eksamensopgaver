package Opgave1_IndkøbksKurven;

public class Clothes extends Product{
   private int size;
   private String color;

   public Clothes(int size, String color, String name, double price){
       super(name, price);
       this.size = size;
       this.color = color;
   }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString(){
       return getName() + ", " + getColor() + ", " + "size " + getSize() + ": " + getPrice() + " euro";
    }
}
