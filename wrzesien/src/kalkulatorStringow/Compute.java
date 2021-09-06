package kalkulatorStringow;

public interface Compute {

    String deleteWhiteSigns(String operation);

    boolean checkingEmptyString(String operation);

    int emptyString(String operation);

    boolean checkingDoesDigitIsSmallerThan10(String operation);

    int digitIsSmallerThan10(String operation);

    boolean checkingDoesSingularNumberIsNegativeOrBiggerThan10(String operation);

    int singularNumberIsNegativeOrBiggerThan10(String operation);

    boolean checkingUndesirableSigns(String operation);

    Character[] boardOfPlusAndMinus(String operation);

    int[] boardOfNumbers(String operation);

    int computingString(Character[] plusAndMinus, int[] numbers);




}
