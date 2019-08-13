import java.util.Scanner;
import java.util.Random;

public class BattleShip
{

    public static Scanner input = new Scanner(System.in);

    public static String[][] OceanArray = new String[10][10];


    public static void main(String[] args) {

        Ocean();
        Input();
        Game();

    }
    public static void Grid()
    {
        System.out.println("  0123456789");
        for (int row = 0; row < OceanArray.length; row++) {
            System.out.print(row + "|");

            for (int col = 0; col < OceanArray[row].length; col++) {

                if (OceanArray[row][col] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(OceanArray[row][col]);
                }
            }
            System.out.println("|" + row);

        }
        System.out.println("  0123456789  \n");
    }

    public static void Ocean() {

        System.out.println("***Welcome to Battle Ships game***\n");
        System.out.println("Right now the sea is empty\n");

        Grid();
    }

    public static void Input() {

        int n = 1;
        while (n < 6)
        {
            //Player input coordinates to deploy ships
            System.out.println("Enter x coordinate for your ship no " + n + " :");
            int x = input.nextInt();
            while(x>=10|| x<0)
            {
                System.out.println("Enter only unoccupied x coordinate for your ship no " + n + " :");
                x = input.nextInt();
            }

            System.out.println("Enter y coordinate for your ship no " + n + " :");
            int y = input.nextInt();
            while(y>=10 || y<0)
            {
                System.out.println("Enter only unoccupied y coordinate for your ship no " + n + " :");
                y = input.nextInt();
            }

            while (OceanArray[x][y] == "@") {
                System.out.println("Enter only unoccupied x coordinate for your ship no " + n + " :");
                x = input.nextInt();
                System.out.println("Enter only unoccupied y coordinate for your ship no " + n + " :");
                y = input.nextInt();
            }
            OceanArray[x][y] = "@";
            n++;

        }

        //Computer random number to deploy ships
        Random rand = new Random();
        int C1;
        int C2;
        int C = 1;
        System.out.println("Computer is deploying Ships");
        while (C < 6) {
            C1 = rand.nextInt(10);
            C2 = rand.nextInt(10);

            while (OceanArray[C1][C2] == "@" || OceanArray[C1][C2] == " ") {
                C1 = rand.nextInt(10);
                C2 = rand.nextInt(10);
            }
            OceanArray[C1][C2] = " ";
            if (OceanArray[C1][C2] == " " && C < 6) {
                System.out.println(C + ". Ship DEPLPOYED");
            }
            C++;

        }
        System.out.println("-----------------");
    }
    public static void Game()
    {

        int Myship = 5;
        int Comship = 5;

        while (Myship > 0)
        {
            while (Comship > 0) {

                //PLayer input coordinates to attack opp ship and result of the attack
                System.out.println("\nPlease input your target location");
                System.out.println("Enter X Coordinate");
                int x = input.nextInt();
                System.out.println("Enter Y Coordinate");
                int y = input.nextInt();

                while (x >= 10 || y >= 10 || x<0 || y<0) {
                    System.out.println("Enter only no 0-9 : ");
                    x = input.nextInt();
                    System.out.println("Enter only  no 0-9 : ");
                    y = input.nextInt();
                }
                while(OceanArray[x][y] == "!" || OceanArray[x][y] == "-" || OceanArray[x][y] == "X")
                {
                    System.out.println("This location have been use.");
                    System.out.println("Please pick another target location");
                    System.out.println("Enter X Coordinate");
                    x = input.nextInt();
                    System.out.println("Enter Y Coordinate");
                    y = input.nextInt();
                }

                if (OceanArray[x][y] == " ") {
                    OceanArray[x][y] = "!";
                    System.out.println("BOOM! You sunk the opponent ship");
                    Comship--;
                } else if (OceanArray[x][y] != " " && OceanArray[x][y] != "@") {
                    OceanArray[x][y] = "-";
                    System.out.println("Sorry, you missed");
                } else if (OceanArray[x][y] == "@") {
                    OceanArray[x][y] = "X";
                    System.out.println("Oh no, you sunk one of your own ship");
                    Myship--;
                }

                //Computer random number for attack target and result of the attack on the location
                Random Rand = new Random();
                int Com1 = Rand.nextInt(10);
                int Com2 = Rand.nextInt(10);

                while(OceanArray[Com1][Com2] == "X" || OceanArray[Com1][Com2] == "-" || OceanArray[Com1][Com2] == "!")
                {
                    Com1 = Rand.nextInt(10);
                    Com2 = Rand.nextInt(10);
                }

                if (OceanArray[Com1][Com2] == "@") {
                    OceanArray[Com1][Com2] = "X";
                    System.out.println("BOOM! Computer sunk your ship \n");
                    Myship--;
                } else if (OceanArray[Com1][Com2] != "@" && OceanArray[x][y] != " ") {
                    OceanArray[Com1][Com2] = "-";
                    System.out.println("Computer missed \n");
                } else if (OceanArray[x][y] == " ") {
                    OceanArray[Com1][Com2] = "!";
                    System.out.println("Computer sunk one of its own ship \n");
                    Comship--;
                }

                //Game areana printing and result of the attacks
                Grid();

                System.out.println("Your ship : " +  Myship + " | Computer ship : " +  Comship);
                System.out.println("------------------------------");

                if (Comship == 0) {
                    System.out.println("You WIN!");
                    Myship=0;


                } else if (Myship == 0) {
                    System.out.println("Computer WIN!");
                    Comship = 0;

                }

            }break;
        }

    }
}













