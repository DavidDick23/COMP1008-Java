package practice;

import java.util.Scanner;

public class Section10
{
    private final Scanner userInput = new Scanner(System.in);

    public static void main()
    {
        Section10 instance = new Section10();
        instance.run();
    }

    private void run()
    {
        //arrayTest();
        //outOfBoundsTest();
        divideByZero();
    }

    private void arrayTest()
    {
        // Create an array of 5 integers
        int[] numbers = {10, 20, 30, 40, 50};
        Scanner scanner = new Scanner(System.in);

        // Prompt user for an index number
        System.out.print("Enter an index number (0 to 4): ");
        int index = scanner.nextInt();

        try {
            // Attempt to access the array at the user-provided index
            System.out.println("The value at index " + index + " is: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid index
            System.out.println("Invalid index!");
        }
    }

    private void outOfBoundsTest ()
    {
        int[] numbers = {10, 20, 30, 40, 50};

        // Ask the user to enter an index number
        System.out.print("Enter an index number (0 to 4): ");
        int index = userInput.nextInt();

        try
        {
            // Attempt to access and print the value at the specified index
            System.out.println("The value at index " + index + " is: " + numbers[index]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            // Handle the case of an invalid index
            System.out.println("Invalid index!");
        }
    }

    private void divideByZero()
    {
        // Ask the user to enter two integers
        System.out.print("Enter the first integer: ");
        int num1 = userInput.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = userInput.nextInt();

        try
        {
            // Attempt to divide the first number by the second
            int result = num1 / num2;
            System.out.println("The result of " + num1 + " divided by " + num2 + " is: " + result);
        }
        catch (ArithmeticException e)
        {
            // Handle division by zero
            System.err.println("Cannot divide by zero!");
        }
    }

    //region Exceptions List
    /*
    ArithmeticException - Thrown when an exceptional arithmetic condition occurs, such as division by zero.
    ArrayIndexOutOfBoundsException - Thrown to indicate that an array has been accessed with an illegal index.
    NullPointerException - Thrown when an application attempts to use null in a case where an object is required.
    ClassCastException - Thrown when trying to cast an object to a subclass of which it is not an instance.
    IllegalArgumentException - Indicates that a method has been passed an illegal or inappropriate argument.
    NumberFormatException - Thrown when an attempt to convert a string to a numeric type fails.
    IOException	Thrown - when an I/O operation fails or is interrupted.
    FileNotFoundException -	A subclass of IOException thrown when a file with the specified pathname does not exist.
    SQLException - Indicates a database access error or other errors related to a database operation.
    InterruptedException - Thrown when a thread is interrupted while it's waiting, sleeping, or otherwise occupied.
    StackOverflowError - A common error indicating that the stack size has exceeded its limit, often due to excessive recursion.
    OutOfMemoryError - Thrown when the Java Virtual Machine cannot allocate an object because it is out of memory.
    UnsupportedOperationException -	Indicates that the requested operation is not supported.
    IndexOutOfBoundsException -	A superclass of both
        --ArrayIndexOutOfBoundsException and StringIndexOutOfBoundsException, thrown when an index is out of range.
     */
    //endregion
}
