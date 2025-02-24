public class Main
{
    public static void main(String[] args) {
        Appliance washing_machine = new WashingMachine();
        Appliance microwave = new Microwave();

        washing_machine.turnOn();
        microwave.turnOn();
    }
}
