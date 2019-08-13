import java.util.*;

public class Gameplay
{
    public static void main(String[] args)
    {
        //Player 1 details

        Scanner input = new Scanner(System.in);
        System.out.println("Let’s play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String Name1 = input.nextLine();
        System.out.print("Welcome " + Name1 + ", please choose (O)dds or (E)vens : ");
        String Player1 = input.next();

        //Player 1 choose side
        while(!(Player1.equals("O")||Player1.equals("E")))
        {
            System.out.print("Enter (O)dds or (E)vens only ");
            Player1 = input.next();
        }
        if (Player1.equals("O"))
        {
            System.out.println(Name1 + " has picked odds! The computer will be evens");
            System.out.println("-------------------------\n");
        }
        else if(Player1.equals("E"))
        {
            System.out.println(Name1 + " has picked evens! The computer will be odds");
            System.out.println("-------------------------\n");
        }

        //PLayer 1 finger option
        System.out.print("How many \"fingers\" do you put out? ");
        int P1Fingers = input.nextInt();
        Random rand = new Random();//computer random pick fingers
        int computer = rand.nextInt(6);//computer random pick fingers
        System.out.println("The computer plays " + computer + " \"fingers\" ");
        System.out.println("-------------------------\n");

        //Calculation sum of Player 1 and Computer
        int SumOfFinger= P1Fingers + computer;
        System.out.println(P1Fingers + " + " + computer + " = " + SumOfFinger);

        //Deciding the winner of this game using the sum
        if(SumOfFinger%2==0)
        {
            System.out.println(SumOfFinger + " is even!");
            if(Player1.equals("E"))
            {
                System.out.println("You wins!");
            }
            else
            {
                System.out.println("Computer wins!");
            }
        }
        else
        {
            System.out.println(SumOfFinger + " is odd!");
            if(Player1.equals("0"))
            {
                System.out.println("You win!");
                System.out.println("-------------------------\n");
            }
            else
            {
                System.out.println("Computer win!");
                System.out.println("-------------------------\n");
            }
        }
    }
}
