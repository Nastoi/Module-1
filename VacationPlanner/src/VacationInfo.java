/**
 * This code is for getting info from user and return the appropriate details to user
 *
 * Author: Nasrullah
 * person: 01
 * since: 14/11/2018
 */
import java.util.Scanner;

public class VacationInfo
{
    public static void main(String[] args)
        {

        //details of name and place
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String Name = input.nextLine();
        System.out.print("Nice to meet you " + Name + ", " + "where are you travelling to? ");
        String Location = input.nextLine();
        System.out.println("Great! " + Location + " sounds like a great trip");
        System.out.print("***********\n\n");


        //details of money
        System.out.print("How many days are you going to spend travelling? ");
        double Day = input.nextDouble();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double Spend = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String CurrencyLetter = input.next();
        System.out.print("How many " + CurrencyLetter + " are there in 1 USD? ");
        double ExchangeRate = input.nextDouble();
        System.out.print("***********\n\n");


        //calculation of hours and minutes
        double Hours = Day*24;
        double Minutes = Hours*60;
        double PerDayExpenses = Spend/Day;
        double ForeignAmount = Spend*ExchangeRate;
        double NewPerDayExpenses = ForeignAmount/Day;


        //return info to user
        System.out.println("If you are travelling for " + Day + " days that is the same as " + Hours + " hours or " + Minutes + " minutes.");
        System.out.println("If you are going to spend $" + Spend + " USD that means per day you can spend up to $ " + PerDayExpenses + " USD.");
        System.out.println("Your total budget in " + CurrencyLetter + " is " + ForeignAmount + " " + CurrencyLetter + ", Which per day is " + NewPerDayExpenses + " " + CurrencyLetter);
        System.out.println("***********\n\n");


        //details of time differences
        System.out.print("What is the time difference, in hours between your home and your destination? ");
        double TimeDiff = input.nextDouble();
        double DestTimeAtMidnight = (24+ TimeDiff)%24;//calculation of time differences
        double NewDestAtMidnight = Math.abs(DestTimeAtMidnight);
        double DestTimeAtNoon = (12%24+ TimeDiff)%24;
        double NewDestAtnoon = Math.abs(DestTimeAtNoon);


        //convert double to int to get hour
        int MidnightHour = (int)NewDestAtMidnight;
        int NoonHour = (int)NewDestAtnoon;


        //hours in double - hours in int to get minutes
        double MidMinutes = (NewDestAtMidnight - MidnightHour)*60;
        double NoonMinutes = (NewDestAtnoon - NoonHour)*60;
        int NewMidMinutes = (int)MidMinutes;//convert minutes back to int
        int NewNoonMinutes = (int)NoonMinutes;


        System.out.println("This means that when it is midnight at home it will be " + MidnightHour + ":" + NewMidMinutes + " hours" + " in your travel destination ");
        System.out.println("and when it is noon at home it will be " + NoonHour + ":" + NewNoonMinutes + " hours");
        System.out.print("***********\n\n");


        //details of destination area
        System.out.print("What is the square area of your destination country in km2? ");
        double SquareKm = input.nextDouble();
        double SquareMile = (SquareKm*0.386102);//calculation to miles
        System.out.println("In miles2 that is " + (int)SquareMile/100);//converting it to int
        System.out.print("***********\n\n");


    }
}
