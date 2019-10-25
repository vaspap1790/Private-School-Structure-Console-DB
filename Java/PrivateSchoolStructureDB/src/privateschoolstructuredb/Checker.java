package privateschoolstructuredb;

import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import static privateschoolstructuredb.Data.Printers.printAssignment;
import static privateschoolstructuredb.Data.Selects.*;
import privateschoolstructuredb.Entities.*;
import static privateschoolstructuredb.PrivateSchoolStructureDB.scanner;

public class Checker {

    public static Date dateCheckandget(String date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        date2 = formatter.parse(date);

        try {
            date2 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date2;
    }

    public static Date dateCheckandgetInput() throws ParseException {

        Date date2 = null;

        boolean correctFormat1 = false;
        boolean correctFormat2 = false;
        do {
            System.out.println("\n" + "Enter Date.***Format YYYY-MM-DD***" + "\n");
            String date = scanner.nextLine();

            correctFormat1 = isValidDate(date);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            try {
                date2 = formatter.parse(date);
                correctFormat2 = true;
            } catch (ParseException e) {
                correctFormat2 = false;
            }
            if ((correctFormat1 == false) || (correctFormat2 == false)) {
                System.out.println("Invalid input. Try again.");
            }
        } while ((correctFormat1 == false) || (correctFormat2 == false));
        return date2;
    }

    static boolean dateIsWithinRange(Date testDate, Date startDate, Date endDate) {
        return !(testDate.before(startDate) || testDate.after(endDate));
    }

    static boolean dateIsAfter(Date testDate, Date startDate) {
        return (testDate.after(startDate));
    }

    public static double doubleCheck() {

        double tuition = 0;
        boolean correct_form = false;

        while (correct_form == false) {

            System.out.println("\n" + "Enter tuition." + "\n");
            String s = scanner.nextLine();

            if (s.matches("^\\d+(\\.\\d+)?$")) {
                tuition = Double.parseDouble(s);
                correct_form = true;
            } else {
                System.out.println("\n" + "Invalid input. Try again.");
            }
        }

        return tuition;
    }

    public static int intCheck() {

        boolean correct_form = false;
        int index = 0;

        while (correct_form == false) {
            System.out.println("\n" + "Type the number." + "\n");
            String input = scanner.nextLine();

            try {
                index = Integer.parseInt(input);
                correct_form = true;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return index;
    }

    public static boolean isValidDate(String date) {

        boolean check;
        String date1 = "^((?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:(?:0[13578]|1[02])(-)31)|((0[1,3-9]|1[0-2])(-)(29|30))))$|^(?:(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(-)02(-)29)$|^(?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:0[1-9])|(?:1[0-2]))(-)(?:0[1-9]|1\\d|2[0-8])$";
        check = date.matches(date1);

        return check;
    }

    public static boolean notEmpty(ArrayList ar) {

        return !ar.isEmpty();
    }

    public static boolean stringChecker(String tocheck, int length) {

        boolean check;

        String re = "^[a-zA-Z][a-zA-Z\\s]{1," + length + "}$";
        check = tocheck.matches(re);

        return check;
    }

    public static void studentsToSubmit() throws ParseException {

        ArrayList<Student> arS = selectAllS();
        ArrayList<Student> arS2 = new ArrayList<>();
        ArrayList<Assignment> arA = selectAllA();
        ArrayList<Assignment> arA2 = new ArrayList<>();

        Date d1 = Checker.dateCheckandgetInput();
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        int dayOfWeek = (c.get(Calendar.DAY_OF_WEEK));

        Calendar first_Day_this_week = Calendar.getInstance();
        Calendar last_Day_this_week = Calendar.getInstance();
        first_Day_this_week.setTime(d1);
        int week_num = first_Day_this_week.get(Calendar.WEEK_OF_YEAR);
        first_Day_this_week.set(Calendar.WEEK_OF_YEAR, week_num);
        first_Day_this_week.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        last_Day_this_week.setTime(d1);
        last_Day_this_week.set(Calendar.WEEK_OF_YEAR, week_num);
        last_Day_this_week.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        Calendar first_Day_prev_week = Calendar.getInstance();
        Calendar last_Day_prev_week = Calendar.getInstance();
        first_Day_prev_week.setTime(d1);
        int week_num1 = ((first_Day_this_week.get(Calendar.WEEK_OF_YEAR)) - 1);
        first_Day_prev_week.set(Calendar.WEEK_OF_YEAR, (week_num1));
        first_Day_prev_week.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        last_Day_prev_week.setTime(d1);
        last_Day_prev_week.set(Calendar.WEEK_OF_YEAR, (week_num1));
        last_Day_prev_week.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        boolean found = false;

        if (dayOfWeek < 2) {
            for (Assignment a : arA) {
                if (dateIsWithinRange(a.getSubDateTime(), first_Day_prev_week.getTime(), last_Day_prev_week.getTime()) == true) {
                    arA2.add(a);
                    found = true;
                }
            }
        } else {
            for (Assignment a : arA) {
                if (dateIsWithinRange(a.getSubDateTime(), (first_Day_this_week.getTime()), (last_Day_this_week.getTime())) == true) {
                    arA2.add(a);
                    found = true;
                }
            }
        }

        if (found == true) {
            ArrayList<Integer> as_ids = new ArrayList<>();
            for (int i = 0; i < arA2.size(); i++) {
                as_ids.add(arA2.get(i).getAssignment_id());
            }

            System.out.println("\n" + "************************** Students who have to submit this week ******************************" + "\n");

            for (int i = 0; i < as_ids.size(); i++) {
                printAssignment(as_ids.get(i));
            }

        } else {
            System.out.println("\n" + "No student has to submit this week." + "\n");
        }
    }
}
