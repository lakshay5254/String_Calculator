import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    public void setup(){
        stringCalculator=new StringCalculator();
    }

    @Test
    @DisplayName("Addition Tests")
    void addTest() {
        assertEquals(0,stringCalculator.add(""),"“” == 0");
        assertEquals(1,stringCalculator.add("1"),"“1” == 1");
        assertEquals(8,stringCalculator.add("1,2,5"),"“1,2” == 3");

    }


    @Test
    @DisplayName("Add using new line")
    void addUsingNewLineTest() {
        assertEquals(4,stringCalculator.add("1\n1,2"));
        assertThrows(InvalidParameterException.class,()->stringCalculator.add("5\n,5"));
        assertThrows(InvalidParameterException.class,()->stringCalculator.add("5,\n5"));
        assertEquals(5,stringCalculator.add("//;\n1;4"));
    }

}