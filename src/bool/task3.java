package bool;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите нулевую остаточную: ");
        String zeroRemainder = scanner.nextLine();
        System.out.print("Введите единичную остаточную: ");
        String oneRemainder = scanner.nextLine();
        System.out.print("Введите номер аргумента: ");
        int argument = scanner.nextInt();
        String result = buildVectorFunction(zeroRemainder, oneRemainder, argument);
        System.out.println("Функция: " + result);
    }

    public static String buildVectorFunction(String zeroRemainder, String oneRemainder, int argument) {
        if (argument == 1) {
            return zeroRemainder + oneRemainder;
        }
        else if (argument == 2) {
            int halfLength = zeroRemainder.length() / 2;
            int half2Length = oneRemainder.length() / 2;
            return zeroRemainder.substring(0, halfLength) + oneRemainder.substring(0, half2Length)
                    + zeroRemainder.substring(halfLength) + oneRemainder.substring(half2Length);
        }
        else {
            return mergeStrings(zeroRemainder, oneRemainder);
        }
    }
    
    public static String mergeStrings(String first, String second) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            result.append(first.charAt(i++));
            result.append(second.charAt(j++));
        }
        while (i < first.length()) {
            result.append(first.charAt(i++));
        }
        while (j < second.length()) {
            result.append(second.charAt(j++));
        }
        return result.toString();
    }
    
}