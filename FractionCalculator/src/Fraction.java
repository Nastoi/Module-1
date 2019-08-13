
public class Fraction {
    private int Numerator;
    private int Denominator;

    public Fraction(int Num, int Denom) {

        //checking if user have input any illegal input and changing the negative input to positive
        if (Denom == 0) {
            throw new IllegalArgumentException("Division by zero");
        } else if (Denom < 0) {
            Num = -Num;
            String NumRe = Integer.toString(Num);

        } else if (Denom < 0 && Num < 0) {
            Denom = +Denom;
            Num = +Num;
            String NumRe = Integer.toString(Num);
            String NumDe = Integer.toString(Denom);
        }
        this.Numerator = Num;
        this.Denominator = Denom;

    }

    public Fraction(int Num) {
        if (Denominator == 0) {
            //setting denominator as 1
            this.Numerator=Num;
            this.Denominator=1;
        } else {
            return;
        }
    }

    //Calculations
    int num;
    int denom;

    public Fraction ADD(Fraction others) {

        num = (this.Numerator * others.Denominator) + (others.Numerator * this.Denominator);
        denom = (this.Denominator * others.Denominator);
        Fraction AfterAdd = new Fraction(num, denom);
        return AfterAdd;
    }

    public Fraction Subtract(Fraction others) {
        num = (this.Numerator * others.Denominator) - (others.Numerator * this.Denominator);
        denom = (this.Denominator * others.Denominator);
        Fraction AfterSub = new Fraction(num, denom);
        return AfterSub;
    }

    public Fraction Divide(Fraction others) {
        Fraction AfterDivide;
        if (others.Numerator == 0) {
           throw new IllegalArgumentException();
        } else {
            AfterDivide = new Fraction((this.Numerator * others.Denominator),(this.Denominator * others.Numerator));
            return AfterDivide;
        }
    }


    public Fraction Multiply(Fraction others) {

        Fraction AfterMultiply= new Fraction((this.Numerator * others.Numerator) / (this.Denominator * others.Denominator));
        return AfterMultiply;
    }


    public int getNumerator() {
        return Numerator;
    }

    public void setNumerator(int numerator) {
        Numerator = numerator;
    }

    public int getDenominator() {
        return Denominator;
    }

    public void setDenominator(int denominator) {
        Denominator = denominator;
    }

    @Override
    public String toString() {return Numerator + " / " + Denominator;}
}

