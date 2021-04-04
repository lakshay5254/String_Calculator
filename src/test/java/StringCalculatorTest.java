import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}