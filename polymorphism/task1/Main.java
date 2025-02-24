public class Main
{
    public static void main(String[] args) {
        Shape triangle = new Triangle(10, 5);
        Shape square = new Square(4);

        triangle.displayArea();
        square.displayArea();
    }
}
