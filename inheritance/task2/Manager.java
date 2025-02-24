public class Manager extends Employee
{
    public int teamSize;

    public Manager(String name, String position, int teamSize)
    {
        super(name, position);
        this.teamSize = teamSize;
    }

    @Override public void displayInfo()
    {
        System.out.println("Name: " + name + "\nPosition: " + position + "\nTeam size: " + teamSize);
    }           
}
