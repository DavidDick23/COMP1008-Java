package wk8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileManipulation
{
    //=======================================================================
    // region Core
    //-----------------------------------------------------------------------
    //Global Variables
    //private Scanner userInput = new Scanner(System.in);
    private final String fileName = "output.txt";

    //Entry Point
    static void main()
    {
        //create new instance of this class
        FileManipulation instance =  new FileManipulation();

        //Invoke Methods
        instance.WriteToFile();
        instance.ReadFromFile();
    }
    //-----------------------------------------------------------------------
    // endregion Core
    //=======================================================================

    //=======================================================================
    // region 1. Write to a File
    // Write a Java program that creates a text file named output.txt and writes the line "Hello, Java File Handling!" into it.
    //-----------------------------------------------------------------------
    private void WriteToFile()
    {
        //Look For Target File (NIO Example)
        String dir = "./"; //set relative directory
        File file = new File(dir + fileName); //create file
        System.out.println("FilePath: " + file.getAbsolutePath()); //print the full path

        //Try Writing To The File
        try
        {
            if (file.createNewFile())
            {
                //if the file isn't found, create the file
                System.out.println("File created: " + file.getName());
            }
            else
            {
                //otherwise, print out message it exists
                System.out.println("File Already Exists");
            }

            //Write to the file and close
            FileWriter writer = new FileWriter(file, true);
            writer.write("Hello, Java File Handling!");
            writer.close();
            System.out.println("File written!");
        }
        catch (IOException e)
        {
            //error handling, display errors if caught
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    //-----------------------------------------------------------------------
    // endregion
    //=======================================================================

    //=======================================================================
    // region 2. Read from a File
    // Write a Java program that reads the contents of a text file named input.txt and prints it to the console.
    //-----------------------------------------------------------------------
    private void ReadFromFile()
    {
        //Look For Target File (NIO Example)
        String dir = "./";
        Path file = Paths.get(dir + fileName);
        System.out.println("FilePath: " + file.toAbsolutePath());

        //Try to read the file
        try
        {
            if(Files.exists(file))
            {
                //read all lines from the file and store in a list
                List<String> lines = Files.readAllLines(file);

                //iterate through the list and print all the lines to the console
                for(String line : lines)
                {
                    System.out.println(line);
                }
            }
            else
            {
                //otherwise, print out message it does NOT exist
                System.out.println("File Not Found");
            }
        }
        catch (IOException e)
        {
            //error handling, display errors if caught
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    //-----------------------------------------------------------------------
    // endregion
    //=======================================================================

    /* SKIPPING #3 SINCE FUNCTIONALITY ALREADY EXISTS IN #2
    * Write a Java program that checks whether a file named data.txt exists in the current directory. If it exists, print "File exists", otherwise print "File not found".*/

    //=======================================================================
    // region 4. Count Lines in a File
    // Write a Java program that counts and prints the number of lines in a text file named notes.txt.
    //-----------------------------------------------------------------------
    private void CountLines()
    {
        //Look For Target File (NIO Example)
        String dir = "./";
        Path file = Paths.get(dir + "notes.txt");
        System.out.println("FilePath: " + file.toAbsolutePath());

        //Try to read the file
        try
        {
            //empty list to store lines in file
            List<String> lines;

            if(Files.exists(file))
            {
                //read all lines from the file and store in a list
                lines = Files.readAllLines(file);
                //print the number of lines
                System.out.println("Number of lines in " + file.getFileName() + ": " + lines.size());
            }
            else
            {
                System.out.println("File Not Found");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    //-----------------------------------------------------------------------
    // endregion
    //=======================================================================

    //=======================================================================
    // region 5. Copy Contents from One File to Another
    // Write a Java program that copies all the contents from a file named source.txt into another file named destination.txt.
    //-----------------------------------------------------------------------

    //-----------------------------------------------------------------------
    // endregion
    //=======================================================================
}
