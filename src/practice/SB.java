package practice;

import java.util.Scanner;

public class SB
{
    private final Scanner input = new Scanner(System.in);
    public static void main()

    {
        SB instance = new SB();
        instance.run();
    }

    private void run()
    {
        // Create a StringBuilder instance
        StringBuilder sb = new StringBuilder();

        // Append strings
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");

        // Insert a string at a specific index
        sb.insert(5, ", Java");

        // Convert StringBuilder to String
        String result = sb.toString();

        // Output the final string
        System.out.println(result);  // Output: Hello, Java World
    }
}

/*
public class CharArrayToString {
    public static void main(String[] args) {
        // Create an array of characters
        char[] charArray = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};

        // Method 1: Using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }
        String stringFromBuilder = sb.toString();
        System.out.println("Using StringBuilder: " + stringFromBuilder);

        // Method 2: Using String constructor
        String stringFromArray = new String(charArray);
        System.out.println("Using String constructor: " + stringFromArray);
    }
}

 */
