public class Motorcycle extends Vehicle 
{
    public int engineCapacity;

    public Motorcycle(String make, String model, int engineCapacity)
    {
        super(make, model);
        this.engineCapacity = engineCapacity;
    }
    
    @Override public void displayInfo()
    {
        System.out.println("Make: " + make + "\nModel: " + model + "\nEngine capacity: " + engineCapacity);
    }
}
