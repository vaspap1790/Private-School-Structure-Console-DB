package privateschoolstructuredb;

import java.text.ParseException;
import java.util.Date;
import static privateschoolstructuredb.Checker.*;
import static privateschoolstructuredb.Data.Printers.printAndPick;
import static privateschoolstructuredb.Data.Selects.selectAllC;
import privateschoolstructuredb.Entities.*;
import static privateschoolstructuredb.PrivateSchoolStructureDB.scanner;

public class Inputs {

    public static Trainer inputTrainer() {

        boolean correct_form = false;
        String fname;
        do {
            System.out.println("\n" + "Enter trainer's first name" + "\n"
                    + "*** Up to 20 characters ***" + "\n");
            fname = scanner.nextLine();
            if (stringChecker(fname, 19) == true) {
                correct_form = true;
            } else {
                System.out.println("Invalid Format. Try again.");
            }
        } while (correct_form == false);

        boolean correct_form2 = false;
        String sname;
        do {
            System.out.println("\n" + "Enter trainer's second name" + "\n"
                    + "*** Up to 50 characters ***" + "\n");
            sname = scanner.nextLine();
            if (stringChecker(sname, 49) == true) {
                correct_form2 = true;
            } else {
                System.out.println("Invalid Format. Try again.");
            }
        } while (correct_form2 == false);

        boolean correct_form3 = false;
        String subject;
        do {
            System.out.println("\n" + "Enter trainer's subject" + "\n"
                    + "*** Up to 50 characters ***" + "\n");
            subject = scanner.nextLine();
            if (stringChecker(subject, 49) == true) {
                correct_form3 = true;
            } else {
                System.out.println("Invalid Format. Try again.");
            }
        } while (correct_form3 == false);

        Trainer t = new Trainer(null, fname, sname, subject);

        return t;
    }

    public static Student inputStudent() throws ParseException {

        boolean correct_form = false;
        String fname;
        do {
            System.out.println("\n" + "Enter student's first name" + "\n"
                    + "*** Up to 20 characters ***" + "\n");
            fname = scanner.nextLine();
            if (stringChecker(fname, 19) == true) {
                correct_form = true;
            } else {
                System.out.println("Invalid Format. Try again.");
            }
        } while (correct_form == false);

        boolean correct_form2 = false;
        String sname;
        do {
            System.out.println("\n" + "Enter student's second name" + "\n"
                    + "*** Up to 50 characters ***" + "\n");
            sname = scanner.nextLine();
            if (stringChecker(sname, 49) == true) {
                correct_form2 = true;
            } else {
                System.out.println("Invalid Format. Try again.");
            }
        } while (correct_form2 == false);

        System.out.println("\n" + "Enter student's birth date");
        Date birth_date = Checker.dateCheckandgetInput();

        String stream = "default";
        String ask;
        do {
            System.out.println("\n" + "Enter students's stream");
            System.out.println("*** '1' for Java / '2' for C# ***" + "\n");
            ask = scanner.nextLine();
            switch (ask) {
                case "1":
                    stream = "Java";
                    break;
                case "2":
                    stream = "C#";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask.equals("1")) && (!ask.equals("2")));

        System.out.println("\n" + "Enter student's tuition" + "\n");
        Double tuition = doubleCheck();

        Student s = new Student(null, fname, sname, birth_date, stream, tuition);

        return s;
    }

    public static Course inputCourse() throws ParseException {

        boolean correct_form = false;
        String title;
        do {
            System.out.println("\n" + "Enter course's title." + "\n"
                    + "*** Up to 20 characters ***" + "\n");
            title = scanner.nextLine();
            if (stringChecker(title, 19) == true) {
                correct_form = true;
            } else {
                System.out.println("Invalid Format. Try again.");
            }
        } while (correct_form == false);

        String stream = "default";
        String ask;
        do {
            System.out.println("\n" + "Enter courses's stream");
            System.out.println("*** '1' for Java / '2' for C# ***" + "\n");
            ask = scanner.nextLine();
            switch (ask) {
                case "1":
                    stream = "Java";
                    break;
                case "2":
                    stream = "C#";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask.equals("1")) && (!ask.equals("2")));

        String type = "default";
        String ask1;
        do {
            System.out.println("\n" + "Enter course's type");
            System.out.println("*** '1' for Full Time / '2' for Part Time ***" + "\n");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "1":
                    type = "Full Time";
                    break;
                case "2":
                    type = "Part Time";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask1.equals("1")) && (!ask1.equals("2")));

        System.out.println("Course's start date:");
        Date start_date = dateCheckandgetInput();

        boolean afterStartDate = false;
        Date end_date = null;
        do {
            System.out.println("Course's end date:");
            end_date = dateCheckandgetInput();
            if (dateIsAfter(end_date, start_date)) {
                afterStartDate = true;
            } else {
                System.out.println("\n" + "End date can't be before start date." + "\n");
            }
        } while (afterStartDate == false);

        Course c = new Course(null, title, stream, type, start_date, end_date);

        return c;
    }

    public static AssignmentsModels inputAssignment() throws ParseException {

        String title = "default";
        String ask;
        do {
            System.out.println("\n" + "Enter assignment's title" + "\n");
            System.out.println("*** '1' for Individual Project / '2' for Group Project ***" + "\n");
            ask = scanner.nextLine();
            switch (ask) {
                case "1":
                    title = "Individual Project";
                    break;
                case "2":
                    title = "Group Project";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask.equals("1")) && (!ask.equals("2")));

        String description = "default";
        String ask1;
        do {
            System.out.println("\n" + "Enter assignment's description");
            System.out.println("*** '1' for Part A / '2' for Part B ***" + "\n");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "1":
                    description = "Part A";
                    break;
                case "2":
                    description = "Part B";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask1.equals("1")) && (!ask1.equals("2")));

        System.out.println("\n" + "Insert assignment's deadline.");
        Date d1 = Checker.dateCheckandgetInput();

        System.out.println("\n" + "Relate assignment to a course.");
        Course c = printAndPick(selectAllC());
        Integer course_id = c.getCourse_id();
        String course_title = c.getTitle();

        AssignmentsModels a = new AssignmentsModels(null, title, description, d1, course_id, course_title);

        return a;
    }
}
