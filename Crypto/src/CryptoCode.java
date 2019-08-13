import java.util.Scanner;

public class CryptoCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please input your word : ");
        String Word = input.nextLine(); //"ILIKEZOOS";
        String Normal = NormalizeText(Word);


        System.out.print("Please input your number : ");
        int CaesarInput = input.nextInt();
        String Caeser = Normal;
        String NewAlpha = Caeser.replace(Caeser,Caesarify(Normal,CaesarInput));
        int OptionLength2 = NewAlpha.length();


        System.out.print("How many spaces : ");
        int GroupInput2 = input.nextInt();
        String Group2 = Groupify(NewAlpha, GroupInput2, OptionLength2);
        System.out.println(Group2);
        return;
    }





    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }





    public static String NormalizeText(String Word) {
        //Taking out the spaces and symbols in sentence and uppercasing it
        String EditText = Word.replaceAll("[^a-zA-Z]", "");
        String Capstext = EditText.toUpperCase();
        System.out.println(Capstext);
        return Capstext;
    }




    public static String Caesarify(String Normal, int InputNo) {
        //get input from user
        Scanner input = new Scanner(System.in);
        int TotalChar = Normal.length(); //total length
        String NewNormal = Normal;
        String Empty ="";
        //calculation to get the letters after shift
        StringBuffer rtnString = new StringBuffer();

        for (int n = 0; n < TotalChar; n++) {
            /*while (InputNo >=27) {
                System.out.println("Please input your number");
                InputNo = input.nextInt();
            }*/
            String fixChar = Normal.substring(n, n + 1);
            int AlphaNo = shiftAlphabet(0).indexOf(fixChar);
            String AlphaChar = shiftAlphabet(InputNo).substring(AlphaNo, AlphaNo + 1);
            //rtnString.append(AlphaChar);
            for(int j=0;j<AlphaChar.length();j++) {
                char vowel = (AlphaChar).charAt(j);
                if (vowel == 'A' || vowel == 'E' || vowel == 'I' || vowel == 'O' || vowel == 'U' || vowel == 'Y') {
                    rtnString.append("OB");
                }
                rtnString.append(AlphaChar.charAt(j));
            }
        }
        System.out.println(rtnString);
        return String.valueOf(rtnString);
    }





    public static String Groupify(String Caeser, int Option, int OptionChar) {
        //get user input
        Scanner input = new Scanner(System.in);

        for (int n = 0; n < OptionChar + 1; n += Option) {
            while (Option > OptionChar || Option <= 0) //to avoid user input more than the length of the word they type in earlier
            {
                System.out.print("How many spaces ");
                Option = input.nextInt();
            }

            String empty = "";

            //find first letter and print
            String FirstLetter = Caeser.substring(n, n + Option);
            System.out.print(FirstLetter);
            int NewN = n + Option;
            //calculation to get next letter and add space in between

            while (NewN < OptionChar) {

                if (NewN + Option > OptionChar) {

                    String LastLetter = Caeser.substring(NewN, OptionChar);
                    String LastSpace = " ";
                    String EndAfterSpace = LastSpace + LastLetter;
                    System.out.print(EndAfterSpace);
                    System.out.print("x");
                    return "";

                } else {

                    String NextLetter = Caeser.substring(NewN, NewN + Option);
                    String Space = " ";
                    String AfterSpace = Space + NextLetter;
                    int NNew = NewN + Option;
                    System.out.print(AfterSpace);
                    while (NNew >= OptionChar) {
                        System.out.print("x");
                        break;
                    }
                    NewN = (NewN + Option);
                }

            }
            return empty;
        }
        return Caeser;
    }
}










