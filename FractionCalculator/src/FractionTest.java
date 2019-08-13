import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    Fraction myfrac1 = new Fraction(4/1);
    Fraction myfrac2 = new Fraction(3/1);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void ADD() {
        Fraction result = new Fraction(7);
        assertEquals(result,myfrac1.ADD(myfrac2));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
    }

    @org.junit.jupiter.api.Test
    void divide() {
    }

    @org.junit.jupiter.api.Test
    void multiply() {
    }
}