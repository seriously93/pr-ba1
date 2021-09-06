package kalkulatorStringow;

public class Main {
    Methods methods = new Methods();
/*
    String deleteWhiteSigns(String operation);

    boolean checkingDoesStringIsSingularOrEmpty(String operation);

    boolean checkingUndesirableSigns(String operation);

    Character[] boardOfPlusAndMinus(String operation);

    int[] boardOfNumbers(String operation);

    int computingString(String[] plusAndMinus, int[] numbers);
 */
     int computing(String operation){

        String withoutWhiteSigns = methods.deleteWhiteSigns(operation);
        /*if(methods.checkingDoesStringIsSingularOrEmpty(withoutWhiteSigns)){
            return methods.solveOfSingularNumber(withoutWhiteSigns);
        }
         */
        if(methods.checkingEmptyString(withoutWhiteSigns)){
            return methods.emptyString(withoutWhiteSigns);
        }
        else if(methods.checkingDoesDigitIsSmallerThan10(withoutWhiteSigns)){
            return methods.digitIsSmallerThan10(withoutWhiteSigns);
        }
        else if(methods.checkingDoesSingularNumberIsNegativeOrBiggerThan10(withoutWhiteSigns)){
            return methods.singularNumberIsNegativeOrBiggerThan10(withoutWhiteSigns);
        }

        methods.checkingUndesirableSigns(withoutWhiteSigns);

        Character[] signs = methods.boardOfPlusAndMinus(withoutWhiteSigns);
        int[] numbers = methods.boardOfNumbers(withoutWhiteSigns);
        return methods.computingString(signs,numbers);
    }

    public static void main(String[] args) {

        Main main = new Main();
        String example = "-17+512+0-123-4421";
        System.out.println(main.computing(example));

    }
}
