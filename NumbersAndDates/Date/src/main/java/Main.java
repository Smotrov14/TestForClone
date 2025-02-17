import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        Birthday birthday = new Birthday(year, month, day);
        if ( birthday.getBirthday() == null || birthday.getToday() == null) {
            return "";
        }
        LocalDate dateCounter = birthday.getBirthday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Period period = Period.between(birthday.getBirthday(), birthday.getToday());

         if (period.getYears() >= 0) {
            String result = "";
            int yearCounter = 0;
            while (dateCounter.isBefore(birthday.getToday()) || dateCounter.isEqual(birthday.getToday())) {
                String result1 = String.valueOf(yearCounter) + " - " + dateCounter.format(formatter) + " - " + dateCounter.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + System.lineSeparator();
                dateCounter = dateCounter.plusYears(1);
                yearCounter++;
                result = result + result1;
            }
            return result;
        }
        else if(birthday.getBirthday().isAfter(birthday.getToday())) {
               return "";
             }
        else{
            return "0 - "+ dateCounter.format(formatter) + " - " + dateCounter.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        }
    }
}