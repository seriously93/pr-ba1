package kalkulatorStringow;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class testMethods {
    Methods methods = new Methods();
    Main main = new Main();

    @Test
    public void testDeleteWhiteSigns(){
        //given
        String example = "1  +   5  - 100";
        String actual = "1+5-100";

        //when
        String result = methods.deleteWhiteSigns(example);

        //then
        assertEquals(actual,result);
    }

    @Test
    public void testDeleteWhiteSignsWithNull(){
        //given
        String example = null;
        String actual = "";

        //when
        String result = methods.deleteWhiteSigns(example);

        //then
        assertEquals(actual,result);
    }

    @Test
    public void testCheckingEmptyString(){
        //given
        String example = "";

        //when
        boolean result = methods.checkingEmptyString(example);

        //then
        assertTrue(result);
    }

    @Test
    public void testCheckingNotEmptyString(){
        //given
        String example = "1234";

        //when
        boolean result = methods.checkingEmptyString(example);

        //then
        assertFalse(result);
    }

    @Test
    public void testEmptyString(){
        //given
        String example = "";
        int actual = 0;

        //when
        int result = methods.emptyString(example);

        //then
        assertEquals(actual,result);
    }

    @Test
    public void testCheckingDoesDigitIsSmallerThan10(){
        //given
        String example = "5";

        //when
        boolean result = methods.checkingDoesDigitIsSmallerThan10(example);

        //then
        assertTrue(result);
    }

    @Test
    public void testCheckingDoesDigitIsBiggerThan10(){
        //given
        String example = "16";

        //when
        boolean result = methods.checkingDoesDigitIsSmallerThan10(example);

        //then
        assertFalse(result);
    }

    @Test
    public void testDigitIsSmallerThan10(){
        //given
        String example = "4";
        int actual = 4;

        //when
        int result = methods.digitIsSmallerThan10(example);

        //then
        assertEquals(actual,result);
    }

    @Test
    public void testCheckingDoesSingularNumberIsNegativeOrBiggerThan10(){
        //given
        String example = "-125";

        //when
        boolean result = methods.checkingDoesSingularNumberIsNegativeOrBiggerThan10(example);

        //then
        assertTrue(result);
    }

    @Test
    public void testCheckingSeveralNumbers(){
        //given
        String example = "12+1-5";

        //when
        boolean result = methods.checkingDoesSingularNumberIsNegativeOrBiggerThan10(example);

        //then
        assertFalse(result);
    }

    @Test
    public void testSingularNumberIsNegativeOrBiggerThan10(){
        //given
        String example = "-12";
        int actual = -12;

        //when
        int result = methods.singularNumberIsNegativeOrBiggerThan10(example);

        //then
        assertEquals(actual,result);
    }

    @Test
    public void testCheckingUndesirableSigns(){
        //given
        String example = "173-1+241-12";

        //when
        boolean result = methods.checkingUndesirableSigns(example);

        //then
        assertTrue(result);
    }

    @Test(expected = InputMismatchException.class)
    public void testException(){
        //given
        String example = "1d+!231-52+11";
        Exception actual = new InputMismatchException("Write correct signs in String :)");
        //when
        boolean result = methods.checkingUndesirableSigns(example);

        //then
        assertEquals(actual, result);
    }

    @Test
    public void testBoardOfPlusAndMinus(){
        //given
        String example = "15-2+21+17-1";
        Character[] actual = {'-', '+', '+', '-'};

        //when
        Character[] result = methods.boardOfPlusAndMinus(example);

        //then
        assertArrayEquals(actual,result);
    }

    @Test
    public void testBoardOfNumbers(){
        //given
        String example = "15+23-11+512";
        int[] actual = {15,23,11,512};

        //when
        int[] result = methods.boardOfNumbers(example);

        //then
        assertArrayEquals(actual,result);
    }

    @Test
    public void testComputingString(){
        //given
        Character[] exampleSigns = {'+','-','+'};
        int[] exampleNumbers = {-15,15,11,50};
        int actual = 39;

        //when
        int result = methods.computingString(exampleSigns,exampleNumbers);

        //then
        assertEquals(actual,result);
    }

    @Test
    public void testComputing(){
        //given
        String example = "-     1+61-    20  +12+48";
        int actual = 100;

        //when
        int result = main.computing(example);

        //then
        assertEquals(actual,result);
    }
}
