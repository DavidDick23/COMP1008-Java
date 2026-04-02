package practice;

import java.util.Scanner;

//ENUM EXAMPLE
public class Section6
{
    public enum Day
    {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    private final Scanner userInput = new Scanner(System.in);
    private Day currentDay;
    public static void main(String[] args)
    {

        Section6 instance = new Section6();
        instance.run();
    }

    private void run()
    {
//        currentDay = Day.SATURDAY; //dont run from static
//        if (currentDay == Day.SATURDAY)
//        {
//            doSomething();
//        }

        countToTwenty();
    }

    private void doSomething()
    {
        System.out.print("Enter the day: ");
        currentDay = Day.valueOf(userInput.next());
    }

    private void countToTwenty()
    {
        int count = 0;
        for (int i = 0; i < 20; i++)
        {
            count++;
            System.out.println(count);
        }
    }

    //region Question**
    //some instruction here
    private void Question()
    {

    }
    //endregion Question**
}
