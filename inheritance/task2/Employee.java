public class Employee
{
    public String name;
    public String position;

    public Employee(String name, String position)
    {
        this.name = name;
        this.position = position;
    }

    public void displayInfo()
    {
        System.out.println("Name :" + name + "\nPosition: " + position);
    }
}
