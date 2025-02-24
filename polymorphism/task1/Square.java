class Square extends Shape
{
    public double side;

    public Square(double side)
    {
        this.side = side;
    }

    @Override public double calculateArea()
    {
        return side * side;
    }
}
