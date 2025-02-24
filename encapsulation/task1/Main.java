public class Main
{
    public static void main(String[] args) {
        Book book = new Book("Romeo and Juliet", "William Shakespeare", 1597);
        book.displayInfo();

        book.setYear(-1);
        System.out.println("Updated year: " + book.getYear());
    }
}
