package wk8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileManipulation
{
    //=======================================================================
    // region Core
    //-----------------------------------------------------------------------
    //Global Variables
    //private Scanner userInput = new Scanner(System.in);
    private final String fileSeparator = System.getProperty("file.separator");

    //Entry Point
    static void main()
    {
        //Create a new instance of this class
        FileManipulation instance =  new FileManipulation();

        //Invoke Methods
       // instance.WriteToFile();
       // instance.ReadFromFile();
       // instance.CountLines();
        instance.CopyConents();
    }
    //-----------------------------------------------------------------------
    // endregion Core
    //=======================================================================

    //=======================================================================
    // region 1. Write to a File
    // Write a Java program that creates a text file named output.txt and
    // writes the line "Hello, Java File Handling!" into it.
    //-----------------------------------------------------------------------
    private void WriteToFile()
    {
        //target file name (kind of redundant but earier to read)
        String fileName = "output.txt";

        //set the relative path to write and print out the absolute path
        Path filePath = Paths.get(".", "src", "wk8", fileName);
        System.out.println("Writing To File: " + filePath.toAbsolutePath());

        //try to write to the file
        try
        {
            //desired text to be writting to a new line (option if appending)
            String writeText = "Hello, Java File Handling!\n";

            //used to create the pathway if it doesn't exist (redundant in this scenario)
            //Files.createDirectories(filePath.getParent());

            //this option will simply creat or overwrite the existing file
            Files.write(filePath, writeText.getBytes(), StandardOpenOption.CREATE);

            //this will create append new text to the existing file
            //Files.write(filePath, writeText.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            System.out.println("Successfully wrote to: " + fileName);
        }
        catch (IOException error)
        {
            System.err.println("Error: " + error.getMessage());
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
        //target filePath name
        String fileName = "output.txt";

        //get the relative path to read and print the absolute path
        Path filePath = Paths.get(".", "src", "wk8", fileName);
        System.out.println("Reading File: " + filePath.toAbsolutePath());

        //try to read the filePath
        try
        {
            //read all lines from the filePath and store in a list
            List<String> lines = Files.readAllLines(filePath);

            System.out.println("Text From " + fileName + ": ");

            //iterate through the list and print all the lines to the console
            for(String line : lines)
            {
                //print each line on a new line
                System.out.println(line + "\n");
            }

            System.out.println("Successfully read all lines from: " + fileName);
        }
        catch (FileNotFoundException error) // <- this catch block isn't working
        {
            System.out.println("Cannot Read: File Not Found!");
        }
        catch (IOException error)
        {
            //error handling, display errors if caught
            System.err.println("Error: " + error.getMessage());
        }
    }
    //-----------------------------------------------------------------------
    // endregion
    //=======================================================================

    /* SKIPPING #3 SINCE FUNCTIONALITY ALREADY EXISTS IN #2
    * Write a Java program that checks whether a file named data.txt exists in the current directory.
    * If it exists, print "File exists", otherwise print "File not found".*/

    //=======================================================================
    // region 4. Count Lines in a File
    // Write a Java program that counts and prints the number of lines in a text file named notes.txt.
    //-----------------------------------------------------------------------
    private void WriteLineCount(int lineCount)
    {
        //target file name
        String fileName = "notes.txt";

        //get the relative path to read and print the absolute path
        Path filePath = Paths.get(".", "src", "wk8", fileName);
        System.out.println("Writing To File: " + filePath.toAbsolutePath());

        try
        {
            //convert the int to a string and write to the file
            String writeText = String.valueOf(lineCount);
            Files.write(filePath, writeText.getBytes());
        }
        catch (IOException error)
        {
            //display error
            System.err.println("Error: " + error.getMessage());
        }
    }

    private void CountLines()
    {
        //target filePath name
        String fileName = "output.txt";

        //get the relative path to read and print the absolute path
        Path filePath = Paths.get(".", "src", "wk8", fileName);
        System.out.println("Reading Number Of Lines From: " + filePath.toAbsolutePath());

        //try to read the file
        try
        {
            //empty list to store lines in file
            List<String> lines;

            //read all lines from the file and store in a list
            lines = Files.readAllLines(filePath);
            //print the number of lines
            System.out.println("Number Of Lines = " + lines.size());

            //pass the count to the write method
            WriteLineCount(lines.size());
        }
        catch (IOException error)
        {
            System.err.println("Error: " + error.getMessage());
        }
    }
    //-----------------------------------------------------------------------
    // endregion
    //=======================================================================

    //=======================================================================
    // region 5. Copy Contents from One File to Another
    // Write a Java program that copies all the contents from a file named
    // source.txt into another file named destination.txt.
    //-----------------------------------------------------------------------
    private Path LocateSourceFile(String targetFileName)
    {
        //start from current working directory (project root)
        Path rootDir = Paths.get(".");

        //display the searching message
        System.out.println("Searching for '" + targetFileName + "' recursively in: " + rootDir.toAbsolutePath());

        //walk the entire folder tree
        try (var walk = Files.walk(rootDir))
        {
            return walk
                    // keep only real files (skip folders)
                    .filter(Files::isRegularFile)
                    //match the filename
                    .filter(path -> path.getFileName().toString().equalsIgnoreCase(targetFileName))
                    //stop at the very first match
                    .findFirst()
                    //return null if nothing found
                    .orElse(null);

        }
        catch (IOException error)
        {
            //display error message and return null
            System.err.println("Error: " + error.getMessage());
            return null;
        }
    }

    private void CopyConents()
    {
        //target file names
        String sourceFileName = "source.txt";
        String destinationFileName = "destination.txt";

        //try to locate the file
        Path sourcePath = LocateSourceFile(sourceFileName);

        //return if file not found
        if(sourcePath == null)
        {
            System.out.println("File Not Found: " + sourceFileName);
            return;
        }
        else
        {
            //display file was found
            System.out.println("Found: " + sourcePath);
        }

        //try to copy the file
        try
        {
            //path to destination file
            Path destinationPath = Paths.get(".", "src", "wk8", destinationFileName);

            //copy all contents from source to destination (create destination file if not exists)
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            //display file was copied
            System.out.println("Copied " + sourceFileName + " to " + destinationFileName);
        }
        catch (IOException error)
        {
            System.err.println("Error: " + error.getMessage());
        }
    }
    //-----------------------------------------------------------------------
    // endregion
    //=======================================================================
}
