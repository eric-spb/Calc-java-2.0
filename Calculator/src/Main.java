import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите операнд 1, оператор и операнд 2 разделенные пробелом:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] tokens = input.trim().split(" ");
        if (tokens.length != 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            System.out.println(calc(input));
            scanner.close();
        }
    }

    public static String calc(String input) {
        System.out.println("=");

        String result = "";

        String[] args = input.split(" ");

        String op1 = args[0];
        String operator = args[1];
        String op2 = args[2];
        int tempResult = 0;
        int op1Int = 0;
        int op2Int = 0;

        if (Validate.validateInput(op1, op2, operator) == "roman") {
            op1Int = RomanConversionUtils.romanToInt(op1);
            op2Int = RomanConversionUtils.romanToInt(op2);
            tempResult = makeTheCalculation(operator, op1Int, op2Int);
            result = RomanConversionUtils.IntegerToRomanNumeral(tempResult);
        }
        else {
            op1Int = Integer.valueOf(op1);
            op2Int = Integer.valueOf(op2);
            tempResult = makeTheCalculation(operator, op1Int, op2Int);
            result = Integer.toString(tempResult);
        }
        return result;
    }

    private static int makeTheCalculation(String operator, int op1Int, int op2Int) {
        int res = 0;
        switch (operator) {
            case "+": res = op1Int + op2Int;
                break;
            case "-": res = op1Int - op2Int;
                break;
            case "/": res = op1Int / op2Int;
                break;
            case "*": res = op1Int * op2Int;
                break;
        }
        return res;
    }


}