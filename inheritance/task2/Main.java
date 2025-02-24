public class Main
{
    public static void main(String[] args)
    {
        Employee employee = new Employee("Emily", "Programmer");
        Manager manager = new Manager("Alice", "Project manager", 5);

        employee.displayInfo();
        System.out.println();
        manager.displayInfo();
    }
}
