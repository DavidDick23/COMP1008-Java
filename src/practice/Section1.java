package practice;

import java.util.Scanner;

public class Section1
{
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        Section1 instance = new Section1();
        instance.run();
    }

    private void run()
    {
        //Question1_1();
        //Question1_2();
        //Question1_3();
        //Question1_4();
        Question1_5();
    }

    //region Question**
    //some instruction here
    private void Question()
    {

    }
    //endregion Question**

    //region Question 1.1
    //Write a program that asks the user to enter their full name and prints it back.
    private void Question1_1()
    {
        System.out.println("Please enter your name: ");
        String name = userInput.nextLine();

        System.out.println("Thanks for entering your name: " + name + "!");
    }
    //endregion Question 1.1

    //region Question 1.2
    //Write a program that asks the user to enter two integers and prints their product.
    private void Question1_2()
    {
        // Ask the user to enter two integers
        System.out.print("Enter the first integer: ");
        int firstInteger = userInput.nextInt();

        System.out.print("Enter the second integer: ");
        int secondInteger = userInput.nextInt();

        // Calculate the product
        int product = firstInteger * secondInteger;

        // Print the result
        System.out.println("The product of " + firstInteger + " and " + secondInteger + " is: " + product);
    }
    //endregion Question 1.2

    //region Question1.3
    //Write a program that asks the user to enter a decimal number and prints its square.
    private void Question1_3()
    {
        // Ask the user to enter a decimal number
        System.out.print("Enter a decimal number: ");
        double decimalNumber = userInput.nextDouble();

        // Calculate the square
        double square = decimalNumber * decimalNumber;

        // Print the result
        System.out.printf("The square of %.2f is: %.2f%n", decimalNumber, square);
    }
    //endregion Question1.3

    //region Question1.4
    //Write a program that asks the user to enter 3 words separately and prints them on one line separated by commas.
    private void Question1_4()
    {
        // Ask the user to enter three words
        System.out.print("Enter the first word: ");
        String firstWord = userInput.nextLine();

        System.out.print("Enter the second word: ");
        String secondWord = userInput.nextLine();

        System.out.print("Enter the third word: ");
        String thirdWord = userInput.nextLine();

        // Print the words separated by commas
        System.out.println("You entered: " + firstWord + ", " + secondWord + ", " + thirdWord);
    }
    //endregion Question1.4

    //region Question1.5
    //Write a program that asks the user for: Name, Age, Height
    //Then display all the information neatly formatted.
    private void Question1_5()
    {
        // Ask the user for their name, age, and height
        System.out.print("Enter your name: ");
        String name = userInput.nextLine();

        System.out.print("Enter your age: ");
        int age = userInput.nextInt();

        System.out.print("Enter your height in centimeters: ");
        double height = userInput.nextDouble();

        // Display the information neatly formatted
        System.out.printf("User Information:%n");
        System.out.printf("Name: %s%n", name);
        System.out.printf("Age: %d years%n", age);
        System.out.printf("Height: %.2f cm%n", height);
    }
    //endregion Question1.5
}
