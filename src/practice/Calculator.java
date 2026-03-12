package practice;

public class Calculator
{
    public double divide(int a, int b)
    {
        if (b == 0)
        {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }
}
