package kalkulatorStringow;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Methods implements Compute {

    @Override
    public String deleteWhiteSigns(String operation) {
        if(operation == null){
            return "";
        }
        return operation.replaceAll(" ", "");

    }

    @Override
    public boolean checkingEmptyString(String operation) {
        return operation.length() == 0;
    }

    @Override
    public int emptyString(String operation) {
        return 0;
    }

    @Override
    public boolean checkingDoesDigitIsSmallerThan10(String operation) {
        return operation.length() == 1;
    }

    @Override
    public int digitIsSmallerThan10(String operation) {
        return Integer.parseInt(operation);
    }

    @Override
    public boolean checkingDoesSingularNumberIsNegativeOrBiggerThan10(String operation) {
        char[] chars = operation.toCharArray();
        int counter = 0;
        for(char sign:chars){
            if(sign == '+' || sign == '-'){
                counter++;
            }
        }
        return counter == 0 || counter == 1 && chars[0] == '-';
    }

    @Override
    public int singularNumberIsNegativeOrBiggerThan10(String operation){
        char[] chars = operation.toCharArray();
        String temporary = "";
        for(int i = 0; i < chars.length; i++){
            temporary += chars[i];
        }
        return Integer.parseInt(temporary);
    }

    @Override
    public boolean checkingUndesirableSigns(String operation) {
        char[] charsArguments = operation.toCharArray();
        String desirableSigns = "0123456789+-";
        char[] charsDesirable = desirableSigns.toCharArray();
        for(int i = 0; i < charsArguments.length; i++){
            int counter = 0;
            for(int j = 0; j < charsDesirable.length; j++){
                if(charsArguments[i] == charsDesirable[j]){
                    counter++;
                }
            }
            if(counter == 0){
                throw new InputMismatchException("Write correct signs in String :)");
            }
        }
        return true;
    }


    @Override
    public Character[] boardOfPlusAndMinus(String operation) {
        List<Character> list = new ArrayList<>();
        char[] chars = operation.toCharArray();
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == '+' || chars[i] == '-'){
                list.add(chars[i]);
            }
        }
        Character[] board = new Character[list.size()];
        for(int i = 0; i < list.size(); i++){
            board[i] = list.get(i);
        }
        return board;
    }

    @Override
    public int[] boardOfNumbers(String operation) {
        int counter = 0;
        char[] chars = operation.toCharArray();
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == '+' || chars[i] == '-'){
                counter++;
            }
        }
        int[] board = new int[counter+1]; //bo liczb jest o 1 wiecej niz znaków +/-, pomijając ten jeżeli pierwsza liczba jest ujemna
        //123+15-5
        int j = 0;
        String temporary = "";
        for(int i = 0; i < chars.length; i++){
            if(i == 0 && chars[i] == '-'){
                temporary += chars[i];
            }
            else if(chars[i] != '+' && chars[i] != '-'){
                temporary += chars[i];
                if(i == chars.length - 1){ // ta instrukcja jest dla ostatniego znaku w przeslanym stringu
                    board[j] = Integer.parseInt(temporary);
                }
            }
            else if(chars[i] == '+' || chars[i] == '-'){
                board[j] = Integer.parseInt(temporary);
                j++;
                temporary = "";
            }
        }
        return board;
    }

    @Override
    public int computingString(Character[] plusAndMinus, int[] numbers) {
        //"-15+20-5-5+75-100+200";
        int result = numbers[0];
        for(int i = 0; i < plusAndMinus.length; i++){
            if(plusAndMinus[i] == '+'){
                result += numbers[i+1];
            }
            else{
                result -= numbers[i+1];
            }
        }
        return result;
    }
}
