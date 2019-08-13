import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type 'Q' to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers");
        GetFraction();



    }


  /* public static Fraction ValidFraction(String Result)
   {
       Fraction Number = null;
       if (Result.contains("/"))
       {
           int Numerator = 0;
           int Denominator = 0;
           int number = Result.indexOf("/");
           String Num = Result.substring(0, number);
           Numerator = Integer.parseInt(Num);
           String Denom = Result.substring(number + 1);
           Denominator = Integer.parseInt(Denom);

           while (Numerator != 0 || Denominator != 0) {
               int Remainder = Numerator % Denominator;
               if(Remainder==0)
               {
                   Number = new Fraction(Numerator, Denominator);
                   return Number;
               }
               else {
                   int NewNume = (Numerator / Remainder);
                   int NewDeno = (Denominator / Remainder);
                   Fraction top = new Fraction(NewNume);
                   Fraction bot = new Fraction(NewDeno);
                   Number = top.Divide(bot);

               }
               return Number;
           }
       }
       else
           {

               int Nnum = Integer.parseInt(Result);
               Number = new Fraction(Nnum);
       }

       return Number;
   }*/


    public static  void GetFraction() {
        Scanner input = new Scanner(System.in);
        int x = 0;
        String Operators = " ";
        while (x == 0) {

            Operators = GetOperation();

            //user input
            System.out.print("Please enter your fractions in the form (a/b), where (a) and (b) are integers: ");
            String Number = input.nextLine();
            String denom = "0";
            while (Number.matches(".*[a-zA-Z]+.*") || Number.contains(".") || Number.contains(" ") || Number.equals("")) {
                System.out.print("Invalid Fraction. Please enter your fractions in the form (a/b), where (a) and (b) are integers and b is not zero: ");
                Number = input.nextLine();
            }

            Fraction firstno= ValidFraction(Number);

            //Fraction firstno;
            //firstno = new Fraction( Integer.parseInt(Number));

            System.out.print("Please enter your fractions in the form (a/b), where (a) and (b) are integers: ");
            String Nnumber = input.nextLine();
            while (Nnumber.matches(".*[a-zA-Z]+.*") || Nnumber.contains(".") || Nnumber.contains(" ") || Nnumber.equals("0") || Nnumber.equals("")) {
                System.out.print("Invalid Fraction. Please enter your fractions in the form (a/b), where (a) and (b) are integers and b is not zero: ");
                Nnumber = input.nextLine();
            }

            Fraction secno= ValidFraction(Nnumber);




            //secno = new Fraction( Integer.parseInt( Nnumber));

            Fraction Result = null;
            //System.out.println(firstno.getNumerator() + " / " + firstno.getDenominator());
            //System.out.println(secno.getNumerator() + " / " + secno.getDenominator());
            ;
            //calculations and output to user
            if (Operators.equals("+")) {
                Result = firstno.ADD(secno);
            }
            else if (Operators.equals("-")) {
                Result = firstno.Subtract(secno);
            }

            else if (Operators.equals("/")) {
                Result = firstno.Divide(secno);


            }
            else if (Operators.equals("*")) {
                Result = firstno.Multiply(secno);
            }

            if (Operators.equals("/") && firstno.getNumerator() == 0 || secno.getNumerator() == 0 ) {
                System.out.println(firstno.getNumerator() + "/" + firstno.getDenominator() + " " + Operators + " " +
                        secno.getNumerator() + "/" + secno.getDenominator() + " = Undefined");
            }
            else if (Result.getNumerator() == 0) {

                System.out.println(firstno.getNumerator() + "/" + firstno.getDenominator() + " " + Operators + " " +
                        secno.getNumerator() + "/" + secno.getDenominator() + " = 0");
            } else {
                int result= Result.getNumerator()/Result.getDenominator();
                Fraction Lowesterm = new Fraction(result);
                System.out.println(firstno.getNumerator() + "/" + firstno.getDenominator() + " " + Operators + " " +
                        secno.getNumerator() + "/" + secno.getDenominator() + " = " +
                        Lowesterm.getNumerator() + "/" + Lowesterm.getDenominator());
            }
        }
    }



    public static void Quit()
    {
        System.exit(0);

    }

    public static Fraction ValidFraction(String num)
    {
        //check for input is in fraction or whole number
        Fraction MyFraction=null;
        if (num.contains("/")) {
            int Numerator = 0;
            int Denominator = 0;
            int FirstNo = num.indexOf("/");
            String Num = num.substring(0, FirstNo);
            Numerator = Integer.parseInt(Num);
            String Denom = num.substring(FirstNo + 1);
            Denominator = Integer.parseInt(Denom);
            MyFraction = new Fraction(Numerator, Denominator);

        }
        else {
            int Nnum = Integer.parseInt(num);
            MyFraction = new Fraction(Nnum);
        }

        return MyFraction;
    }




    public static String GetOperation()
    {
        //getting user preference of calculation
        String Operators;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an operation (+, -, /, *, = or 'Q') to quit: ");
        Operators = input.nextLine();
        while (Operators.equals("Q") || Operators.equals("q") || !Operators.equals("+") || !Operators.equals("-") || !Operators.equals("/") || !Operators.equals("*"))
        {
            if (Operators.equals("Q") || Operators.equals("q")) {
                Quit();
            } else if (Operators.equals("+") || Operators.equals("-") || Operators.equals("/") || Operators.equals("*")) {
                break;
            }
            System.out.print("Invalid input (+, -, /, *, = or 'Q') to quit: ");
            Operators = input.nextLine();
        }

        return Operators;
    }



}