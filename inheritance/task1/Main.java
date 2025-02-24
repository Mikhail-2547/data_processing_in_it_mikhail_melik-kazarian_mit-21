public class Main
{
    public static void main(String[] args) {
        Vehicle car = new Vehicle("McLaren", "600LT");
        Motorcycle motorcycle = new Motorcycle("Yamaha", "TZR250", 259);
        car.displayInfo();
        System.out.println();
        motorcycle.displayInfo();
    }
}
