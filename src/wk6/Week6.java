package wk6;

import java.beans.ExceptionListener;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week6 {

    public static void main(String[] args) {

        //System.out.println(-9 % 2);
            example9();
    }

    static void example2(){
        /*
            exception
         */

//        int num = Integer.parseInt("abc");
        int num = Integer.parseInt("1");


    }
    static void example3(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num1 = sc.nextInt();
        System.out.println("Enter another integer: ");
        int num2 = sc.nextInt();

        System.out.println(num1 / num2);


    }

    static void example4(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        try {
            int num1 = sc.nextInt();
            System.out.println("Enter another integer: ");
            int num2 = sc.nextInt();

            System.out.println(num1 / num2);
        }
        catch (InputMismatchException e) {
            System.err.println("Invalid int number inputted");
        }
        catch (ArithmeticException e){
            System.err.println("Cannot divide by zero");
        }
        catch (Exception e) {
            //serr+tab
            System.err.println("Error!");
        }

    }

    static void example5(){

            int num;
            try {
                //ask user to input an even number
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter an even number");
                num = sc.nextInt();
                if (num % 2 == 1) {
                    throw new IllegalArgumentException("odd number inputted!");
                } else if (num == 0) {
                    throw new ArithmeticException("Cannot get the remainder of value of number is zero");
                } else if (num < 0) {
                    throw new IllegalArgumentException("negative number inputted!");
                }

                System.out.println("You've inputted an even number");

            } catch (Exception e) {
                num = 0;
                System.err.println(e.getClass().getName());
                System.err.println(e.getMessage());
            } finally {
             System.out.println("Thank you for using our program");
            }



    }
    static void example6(){

        int num = 0;
        while(num == 0) {
            try {
                //ask user to input an even number
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter an even number");
                num = sc.nextInt();
                if (num % 2 == 1) {
                    throw new IllegalArgumentException("odd number inputted!");
                } else if (num == 0) {
                    throw new ArithmeticException("Cannot get the remainder of value of number is zero");
                } else if (num < 0) {
                    throw new IllegalArgumentException("negative number inputted!");
                }

                System.out.println("You've inputted an even number");

            } catch (Exception e) {
                num = 0;
                System.err.println(e.getClass().getName());
                System.err.println(e.getMessage());
            }
        }


    }

    /*
            {N}         exact N times
            {N,}        at least N times
            {N,M}       between N and M times )includsively)


     */


    static void example7(){
        String text = "My number is 416-123-4567";

        Pattern pattern = Pattern.compile("[0-9]{2,}");
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

    static void example8(){
        //write a regex that will validate a name in format "Firstname Lastname"
        //no middle names allowed
        String regex = "[A-Za-z]{2,}\s[a-zA-Z]{3,}";
        String text = "Be Ben";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());

        //"\d{1,}\.[0-9]{2}"    //

    }
    static void example9(){
        //write a regex that will validate a name in format "Firstname Lastname"
        //no middle names allowed
        String regex = "[a-zA-Z]\\d[a-zA-Z]\\s?\\d[a-zA-Z]\\d";
        String text = "L4M 3X9";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());

        //"\d{1,}\.[0-9]{2}"    //

    }

    static void example1(){
        /*
            method is an action
                sleeping(where, duration)


                method overload
                    allowing the user to use the method in various ways

         */

        Calculator c1 = new Calculator();
        int r1 = c1.add();
        int r2 = c1.add(1, 2);
        double r3 = c1.add(3.3, 4.4);

        System.out.println(c1.getClass().getName());

        System.out.println(c1);


        /*
                Override
                    throw out the default method behaviour and implement a new method behaviour


         */

        Car car1 = new Car("Honda", "Accord", 2025);
        Car car2 = new Car("Toyota", "Prius", 2024);

        System.out.println(car1);
        System.out.println(car2);


    }
}
