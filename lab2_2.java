import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String password;
        int Zaglav = 0, Stroch = 0, Dig = 0;

        while (true) {
            System.out.print("Введите пароль, используя цифры, английские буквы и символ подчеркивания: ");
            try {
                password = sc.nextLine();
                if (!password.matches("^[a-zA-Z0-9_]+$")) {
                    System.out.println("Использованы не правильные символы. Повторите ввод. ");
                } else {
                    if (password.length() >= 8) {
                        for (int i = 0; i < password.length(); i++) {
                            char[] chars = password.toCharArray();
                            for (char c : chars) {
                                String x = String.valueOf(c);
                                if (x.matches("[A-Z]")) {
                                    Zaglav = Zaglav + 1;
                                } else if (x.matches("[a-z]")) {
                                    Stroch = Stroch + 1;
                                } else if (x.matches("[0-9]")) {
                                    Dig = Dig + 1;
                                }
                            }
                        }
                        if (Dig > 0 & Zaglav > 0 & Stroch > 0) {
                            System.out.println("Пароль надежен. Ваш пароль: " + password);
                            break;
                        } else {
                            System.out.println("Пароль ненадежен. Повторите ввод. ");
                        }
                    } else {
                        System.out.println("Короткий пароль. Повторите ввод. ");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Повторите ввод. ");
            }
        }
        sc.close();
    }
}