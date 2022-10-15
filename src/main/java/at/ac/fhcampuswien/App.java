package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {

    Scanner scan;

    public App()    {
        scan = new Scanner(System.in);
    }

    //todo Task 1
    public void largestNumber(){
        double number = 0;
        double largestNumber = 0;
        int row = 0;

        do {
            row++;
            System.out.print("Number " + row + ": ");
            number = scan.nextDouble();


            if(largestNumber < number)  {
                largestNumber = number;
            }
        } while (number > 0);

        if(row == 1 && number <= 0) {
            System.out.println("No number entered.");
        } else {
            System.out.printf(Locale.US, "The largest number is %.2f%n", largestNumber);
        }
    }

    //todo Task 2
    public void stairs(){
        int starNum = scan.nextInt();
        int count = 1;
        System.out.print("n: ");

        if(starNum <= 0)    {
            System.out.println("Invalid number!");
            return;
        }

        for(int i = 0; i < starNum; i++)    {
            for(int j = 0; j <= i; j++)  {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    //todo Task 3
    public void printPyramid(){
        final int LENGTH = 6;

        for(int i = 0; i < LENGTH; i++)  {
            for(int j = i; j < LENGTH-1; j++)    {
                System.out.print(" ");
            }
            for(int k = 0; k <= (i*2); k++)   {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){
        System.out.print("h: ");
        int length = scan.nextInt();
        System.out.print("c: ");
        char c = scan.next().charAt(0);

        if(length % 2 == 0)  {
            System.out.println("Invalid number!");
            return;
        }

        for(int i = 0; i < (length+1)/2; i++)  {
            for(int j = i; j < (length)/2; j++)    {
                System.out.print(" ");
            }
            for(int k = 0; k <= (i*2); k++)   {
                System.out.print(c);
                if (k < i)
                {
                    c++;
                } else
                {
                    c--;
                }
            }
            System.out.println();
        }
        c++;
        for(int i = (length/2); i > 0; i--)  {
            for(int j = i; j < (length)/2; j++)    {
                System.out.print(" ");
            }
            for(int k = 0; k <= (i*2); k++)   {
                System.out.print(c);
                if (k < i)
                {
                    c++;
                } else
                {
                    c--;
                }
            }
            System.out.println();
        }

    }

    //todo Task 5
    public void marks(){
        int number = 0;
        int rows = 1;
        int sum = 0;
        int nMarks = 0;

        do {
            System.out.print("Mark " + rows + ": ");
            number = scan.nextInt();

            if(number >= 1 && number <= 5) {
                sum += number;
                rows++;
                if(number == 5) {
                    nMarks++;
                }
            } else if(number != 0){
                System.out.println("Invalid mark!");
            }
        } while (number != 0);
        rows--;

        if(sum == 0 || rows == 0)    {
            System.out.println("Average: 0.00");
        } else {
            float avg = (float) sum/rows;
            System.out.printf(Locale.US, "Average: %.2f%n", avg);
        }
        System.out.println("Negative marks: " + nMarks);
    }

    //todo Task 6
    public void happyNumbers(){
        System.out.print("n: ");
        int n = scan.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();
        while(n != 1) {
            numbers.clear();
            while(n > 0){
                numbers.add(n % 10);
                n /= 10;
            }
            n += numbers.stream().mapToInt(number -> (int) Math.pow(number, 2)).sum();
            if(n == 4)  {
                System.out.println("Sad number!");
                return;
            }
        }
        System.out.println("Happy number!");
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}