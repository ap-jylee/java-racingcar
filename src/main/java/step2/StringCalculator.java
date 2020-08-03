package step2;

import java.util.Objects;

public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private static final String SPLIT_REGEX = " ";

    public int calculate(String input) {
        validateInputString(input);
        String[] splited = split(input);
        int calculationResult = Integer.valueOf(splited[0]);
        for (int i = 1; i < splited.length; i = i + 2) {
            calculationResult = calculateWithOperation(calculationResult, Integer.valueOf(splited[i + 1]), splited[i]);
        }
        return calculationResult;
    }

    private String[] split(String input) {
        return input.split(SPLIT_REGEX);
    }

    private void validateInputString(String input) {
        if (Objects.isNull(input) || input.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateWithOperation(int leftOperand, int rightOperand, String operation) {
        return OperatorType.findBySymbol(operation).operate(leftOperand, rightOperand);
    }

}
