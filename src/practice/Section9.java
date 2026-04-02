package practice;

//Imports
import java.util.Scanner;
import java.util.regex.Pattern;

//***REGEXP***
public class Section9
{
    private final Scanner userInput = new Scanner(System.in);

    public static void main()
    {
        Section9 instance = new Section9();
        instance.run();
    }

    private void run()
    {
        //studentId();
        //checkDate();
        //checkLetterLength();
    }

    //region StudentID
    private void studentId()
    {
        // Ask the user to enter a student number
        System.out.print("Enter the student number: ");
        String studentNumber = userInput.nextLine();

        // Check if the student number is valid
        if (isValidStudentNumber(studentNumber))
        {
            System.out.println("Valid student number.");
        }
        else
        {
            System.out.println("Invalid student number.");
        }
    }

    private boolean isValidStudentNumber(String studentNumber)
    {
        // Regex to check the pattern: starts with "ST" followed by exactly 4 digits
        return Pattern.matches("^ST\\d{4}$", studentNumber);
    }
    //endregion StudentID

    //region Date
    private void checkDate()
    {
        // Ask the user to enter a date
        System.out.print("Enter a date (DD/MM/YYYY): ");
        String date = userInput.nextLine();

        // Check if the date is in the valid format
        if (isValidDateFormat(date)) {
            System.out.println("Valid date format.");
        } else {
            System.out.println("Invalid date format.");
        }
    }

    private boolean isValidDateFormat(String date)
    {
        // Regex to match the format DD/MM/YYYY
        return Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", date);
    }
    //endregion Date

    //region Letter Length (UserName)
    private void checkLetterLength()
    {
        // Ask the user to enter a username
        System.out.print("Enter a username: ");
        String username = userInput.nextLine();

        // Check if the username is valid
        if (isValidUsername(username))
        {
            System.out.println("Valid username.");
        }
        else
        {
            System.out.println("Invalid username.");
        }
    }

    private boolean isValidUsername(String username)
    {
        // Check length
        if (username.length() < 5 || username.length() > 10)
        {
            return false;
        }

        // Regex to match allowed characters: letters, numbers, and underscores
        return Pattern.matches("^[a-zA-Z0-9_]*$", username);
    }
    //endregion Letter Length (UserName)

    //region Regex Characters
    /*
    .	Matches any single character except newline
    ^	Matches the start of a string
    $	Matches the end of a string
    *	Matches 0 or more occurrences of the preceding element
    +	Matches 1 or more occurrences of the preceding element
    ?	Matches 0 or 1 occurrence of the preceding element
    {n}	Matches exactly n occurrences of the preceding element
    {n,}	Matches n or more occurrences of the preceding element
    {n,m}	Matches between n and m occurrences of the preceding element
    []	Matches any single character within the brackets
    `	`
    ()	Groups expressions and captures matching text
    \	Escapes a special character to treat it as a normal character
    \d	Matches any digit (equivalent to [0-9])
    \D	Matches any non-digit character
    \w	Matches any word character (alphanumeric plus underscore, equivalent to [a-zA-Z0-9_])
    \W	Matches any non-word character
    \s	Matches any whitespace character (space, tab, newline)
    \S	Matches any non-whitespace character
    (?=...)	Positive lookahead: asserts that what follows must match the pattern in the parentheses
    (?!...)	Negative lookahead: asserts that what follows must not match the pattern
    (?<=...)	Positive lookbehind: asserts that what precedes must match the pattern in the parentheses
    (?<!...)	Negative lookbehind: asserts that what precedes must not match the pattern
    \b	Matches a word boundary
    \B	Matches a non-word boundary
     */
    //endregion Regex Characters
}
