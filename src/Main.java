import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String isUserWantToRetry = "Y";
        Scanner scanner = new Scanner(System.in);
        int numberInputThatWantToPrint = 0;
        int numberInputSpace = 0;

        boolean isFirstNumberValid = false, isSecondNumberValid = false;

        while (isUserWantToRetry.equals("Y")) {
            do {
                System.out.print("\nMasukkan banyak angka yang mau di cetak [2...10] : ");
                int tempNumberInputThatWantToPrint = scanner.nextInt();

                if (validateLengthNumberFirstInput(tempNumberInputThatWantToPrint)) {
                    isFirstNumberValid = true;
                    numberInputThatWantToPrint = tempNumberInputThatWantToPrint;
                }
            } while (!isFirstNumberValid);

            do {
                System.out.print("\nMasukkan beda masing-masing angka [2...9] : ");
                int tempNumberInputSpace = scanner.nextInt();

                if (validateLengthNumberSecondInput(tempNumberInputSpace)) {
                    isSecondNumberValid = true;
                    numberInputSpace = tempNumberInputSpace;
                }
            } while (!isSecondNumberValid);

            showAritmatikaNumber(numberInputThatWantToPrint, numberInputSpace);
            showGeometriNumber(numberInputThatWantToPrint, numberInputSpace);
            showFactorialNumber(numberInputThatWantToPrint);

            System.out.print("Anda ingin mengulang [y/t] ");
            Scanner wantToRetryScanner = new Scanner(System.in);
            isUserWantToRetry = wantToRetryScanner.nextLine().toUpperCase(Locale.ROOT);
        }
    }

    private static void showAritmatikaNumber(int n, int range) {
        String listOutput = "";
        for (int i = 1; i <= n; i++) {
            int output = 1 + ((i - 1) * range);
            listOutput += output + " ";
        }
        System.out.print("Deret Aritmatika : \n");
        System.out.println(listOutput);
    }

    private static void showGeometriNumber(int n, int range) {
        String listOutput = "1 ";
        int rasio = 1;
        for (int i = 1; i < n; i++) {
            rasio *= range;
            listOutput += rasio + " ";
        }
        System.out.print("Deret Geomteri : \n");
        System.out.println(listOutput);
    }

    private static void showFactorialNumber(int number) {
        ArrayList<String> listOutput = new ArrayList<>();
        int sumOutput = 1;
        for (int i = number; i > 0; i--) {
            listOutput.add(Integer.toString(i));
            sumOutput *= i;
        }
        String r = String.join(" * ", listOutput);
        System.out.printf("Faktorial dari %d : \n", number);
        System.out.println(r + " = " + sumOutput);
    }

    private static boolean validateLengthNumberFirstInput(int number) {
        return number <= 10 && number >= 2;
    }

    private static boolean validateLengthNumberSecondInput(int number) {
        return number <= 9 && number >= 2;
    }
}