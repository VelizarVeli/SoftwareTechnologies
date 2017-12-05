package ObjectsAndClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CountWorkingDays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Date> holidays = holidays();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(scan.nextLine(), dtf);
        LocalDate endDate = LocalDate.parse(scan.nextLine(), dtf);

        int workdaysCount = 0;
        while (date.compareTo(endDate) <= 0) {
            Date currentDate = new Date(date.getDayOfMonth(), date.getMonth().getValue());
            boolean isAHoliday = checkIfHoliday(holidays, currentDate);
            if (date.getDayOfWeek().getValue() < 6 && !isAHoliday) {
                workdaysCount++;
            }
            date = date.plusDays(1);
        }
        System.out.println(workdaysCount);
    }

    private static boolean checkIfHoliday(ArrayList<Date> holidays, Date currentDate) {
        boolean isAHoliday = false;
        for (int i = 0; i < holidays.size(); i++) {
            if (currentDate.equals(holidays.get(i))) {
                isAHoliday = true;
            }
        }
        return isAHoliday;
    }

    private static ArrayList<Date> holidays() {
        Date[] holidays = new Date[]{new Date(1, 1), new Date(3, 3), new Date(1, 5), new Date(6, 5),
                new Date(24, 5), new Date(6, 9), new Date(22, 9), new Date(1, 11),
                new Date(24, 12), new Date(25, 12), new Date(26, 12)};
        return new ArrayList<>(Arrays.asList(holidays));
    }
}

class Date {
    private int day;
    private int month;

    public Date(int day, int month) {
        this.day = day;
        this.month = month;
    }

    public boolean equals(Date date) {
        if (this.day == date.day && this.month == date.month) {
            return true;
        } else {
            return false;
        }
    }
}