import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String date;
        int monthNumber, dayNumber, yearNumber;

        while (true) {
            System.out.print("Введите дату в формате dd/mm/yyyy: ");
            try {
                date = sc.nextLine();
                System.out.print("Вы ввели: " + date + "\n");

                Pattern p = Pattern.compile("\\d{2}[/]\\d{2}[/]\\d{4}");
                Matcher m = p.matcher(date);
                boolean b = m.matches();

                String day = date.substring(0, 2);
                String month = date.substring(3, 5);
                String year = date.substring(6, 10);
                yearNumber = Integer.parseInt(year);
                monthNumber = Integer.parseInt(month);
                dayNumber = Integer.parseInt(day);

                if (b & dayNumber > 0 & dayNumber < 32 & monthNumber > 0 & monthNumber < 13 & monthNumber != 2 & yearNumber > 1899 & yearNumber < 10000) {
                    System.out.print("Введеное выражение является датой. Ваша дата: " + date);
                    break;
                } else if (b & dayNumber >= 0 & dayNumber < 30 & monthNumber == 2 & yearNumber > 1899 & yearNumber < 10000) {
                    System.out.print("Введеное выражение является датой. Ваша дата: " + date);
                    break;
                } else if (b & monthNumber == 2 & dayNumber > 29 & yearNumber > 1899 & yearNumber < 10000) {
                    System.out.println("Введеное выражение не является датой. В феврале максимум 29 дней. Попробуйте снова.");
                }else if (!b) {
                    System.out.println("Введеное выражение не соответствует заданному формату dd/mm/yyyy. Попробуйте снова.");
                } else if (monthNumber <= 0 | monthNumber > 12 | dayNumber <= 0 | dayNumber > 31 | yearNumber < 1900 | yearNumber > 9999) {
                    System.out.println("Введеное выражение не является датой. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введеное выражение не является датой. Попробуйте снова.");
            } catch (StringIndexOutOfBoundsException siobe) {
                System.out.println("Введеное выражение не соответствует заданному формату dd/mm/yyyy. Попробуйте снова.");
            }
        }
        sc.close();
    }
}