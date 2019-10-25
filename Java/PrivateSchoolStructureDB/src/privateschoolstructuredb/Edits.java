package privateschoolstructuredb;

import privateschoolstructuredb.Data.*;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static privateschoolstructuredb.Checker.*;
import static privateschoolstructuredb.Data.Datasource.conn;
import static privateschoolstructuredb.Data.Printers.printAndPick;
import static privateschoolstructuredb.Data.Selects.*;
import static privateschoolstructuredb.PrivateSchoolStructureDB.scanner;
import privateschoolstructuredb.Entities.*;

public class Edits {

    public static void editStudentOMark() {

        if (notEmpty(selectAllS())) {

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            if (notEmpty(selectAllAssignmentsOfAStudent(student_id))) {

                ArrayList<Assignment> arA = new ArrayList<>();

                for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                    for (int j = 0; j < selectAllA().size(); j++) {
                        if (selectAllAssignmentsOfAStudent(student_id).get(i).byteValue() == selectAllA().get(j).getAssignment_id().byteValue()) {
                            arA.add(selectAllA().get(j));
                        }
                    }
                }
                System.out.println("\n" + "Select the Assignment.");
                int assignment_id = printAndPick(arA).getAssignment_id();

                String omark;
                boolean done = false;
                do {
                    System.out.println("\n" + "Type 'A' for Excellent"
                            + "\n" + "     'B' for Good"
                            + "\n" + "     'C' for Pass"
                            + "\n" + "     'D' for No Pass"
                            + "\n" + "     '0' for cancel.");

                    omark = scanner.nextLine();
                    switch (omark) {
                        case "A":
                            omark = "A";
                            done = true;
                            break;
                        case "B":
                            omark = "B";
                            done = true;
                            break;
                        case "C":
                            omark = "C";
                            done = true;
                            break;
                        case "D":
                            omark = "D";
                            done = true;
                            break;
                        case "0":
                            System.out.println("\n" + "Action cancelled." + "\n");
                            break;
                        default:
                            System.out.println("\n" + "Invalid input. Try again." + "\n");
                            break;
                    }
                } while ((!omark.equals("0")) && (done == false));

                if (!omark.equals("0")) {
                    String q = "UPDATE assignments\n"
                            + "SET oralMark = ?"
                            + "WHERE assignment_id =? \n";
                    PreparedStatement pstm = null;
                    ResultSet rs = null;

                    try {
                        pstm = conn.prepareStatement(q);
                        pstm.setString(1, omark);
                        pstm.setInt(2, assignment_id);

                        pstm.executeUpdate();
                        System.out.println("You successfully edited student's mark.");

                    } catch (SQLException e) {
                        System.out.println("Query failed:" + e.getMessage());
                    } finally {
                        try {
                            pstm.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                System.out.println("No assignments to this student registered.");
            }
        } else {
            System.out.println("No students registered.");
        }
    }

    public static void editStudentTMark() {

        if (notEmpty(selectAllS())) {

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            if (notEmpty(selectAllAssignmentsOfAStudent(student_id))) {

                ArrayList<Assignment> arA = new ArrayList<>();

                for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                    for (int j = 0; j < selectAllA().size(); j++) {
                        if (selectAllAssignmentsOfAStudent(student_id).get(i).byteValue() == selectAllA().get(j).getAssignment_id().byteValue()) {
                            arA.add(selectAllA().get(j));
                        }
                    }
                }
                System.out.println("\n" + "Select the Assignment.");
                int assignment_id = printAndPick(arA).getAssignment_id();

                String tmark;
                boolean done = false;
                do {
                    System.out.println("\n" + "Type 'A' for Excellent"
                            + "\n" + "     'B' for Good"
                            + "\n" + "     'C' for Pass"
                            + "\n" + "     'D' for No Pass"
                            + "\n" + "     '0' for cancel.");

                    tmark = scanner.nextLine();
                    switch (tmark) {
                        case "A":
                            tmark = "A";
                            done = true;
                            break;
                        case "B":
                            tmark = "B";
                            done = true;
                            break;
                        case "C":
                            tmark = "C";
                            done = true;
                            break;
                        case "D":
                            tmark = "D";
                            done = true;
                            break;
                        case "0":
                            System.out.println("\n" + "Action cancelled." + "\n");
                            break;
                        default:
                            System.out.println("\n" + "Invalid input. Try again." + "\n");
                            break;
                    }
                } while ((!tmark.equals("0")) && (done == false));

                if (!tmark.equals("0")) {
                    String q = "UPDATE assignments\n"
                            + "SET totalMark = ?"
                            + "WHERE assignment_id =? \n";
                    PreparedStatement pstm = null;
                    ResultSet rs = null;

                    try {
                        pstm = conn.prepareStatement(q);
                        pstm.setString(1, tmark);
                        pstm.setInt(2, assignment_id);

                        pstm.executeUpdate();
                        System.out.println("You successfully edited student's mark.");

                    } catch (SQLException e) {
                        System.out.println("Query failed:" + e.getMessage());
                    } finally {
                        try {
                            pstm.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                System.out.println("No assignments to this student registered.");
            }
        } else {
            System.out.println("No students registered.");
        }
    }

    public static void editStudentTuition() {

        if (notEmpty(selectAllS())) {
            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            double tuition = doubleCheck();

            String q = "UPDATE students\n"
                    + "SET tuition = ?"
                    + "WHERE student_id =? \n";
            PreparedStatement pstm = null;
            ResultSet rs = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setDouble(1, tuition);
                pstm.setInt(2, student_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited student's tuition.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No students registered.");
        }
    }

    public static void editStudentAssignmentSubDateTime() throws ParseException {

        if (notEmpty(selectAllS())) {

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            if (notEmpty(selectAllAssignmentsOfAStudent(student_id))) {

                ArrayList<Assignment> arA = new ArrayList<>();

                for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                    for (int j = 0; j < selectAllA().size(); j++) {
                        if (selectAllAssignmentsOfAStudent(student_id).get(i).byteValue() == selectAllA().get(j).getAssignment_id().byteValue()) {
                            arA.add(selectAllA().get(j));
                        }
                    }

                    System.out.println("\n" + "Select the Assignment.");
                    int assignment_id = printAndPick(arA).getAssignment_id();

                    java.util.Date utilStartDate = dateCheckandgetInput();
                    java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

                    String q = "UPDATE assignments\n"
                            + "SET SubDateTime = ?"
                            + "WHERE assignment_id =? \n";
                    PreparedStatement pstm = null;

                    try {
                        pstm = conn.prepareStatement(q);
                        pstm.setDate(1, sqlStartDate, java.util.Calendar.getInstance());
                        pstm.setInt(2, assignment_id);

                        pstm.executeUpdate();
                        System.out.println("You successfully edited student's assignment deadline.");

                    } catch (SQLException e) {
                        System.out.println("Query failed:" + e.getMessage());
                    } finally {
                        try {
                            pstm.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                System.out.println("No assignments to this student registered.");
            }
        } else {
            System.out.println("No students registered.");
        }
    }

    public static void editAssignmentsModelsSubDateTime() throws ParseException {

        if (notEmpty(selectAllAM())) {

            System.out.println("\n" + "Select the Assignment.");
            int assignment_id = printAndPick(selectAllAM()).getAssignment_id();

            java.util.Date utilStartDate = dateCheckandgetInput();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

            String q = "UPDATE assignments\n"
                    + "SET SubDateTime = ?"
                    + "WHERE assignment_id =? \n";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setDate(1, sqlStartDate, java.util.Calendar.getInstance());
                pstm.setInt(2, assignment_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited student's assignment deadline.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No assignment models registered.");
        }
    }

    public static void editStudentBirthDate() throws ParseException {

        if (notEmpty(selectAllS())) {

            System.out.println("\n" + "Select the Student.");
            int student_id = printAndPick(selectAllS()).getStudent_id();

            java.util.Date utilStartDate = dateCheckandgetInput();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

            String q = "UPDATE students\n"
                    + "SET birthDate = ?"
                    + "WHERE student_id =? \n";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setDate(1, sqlStartDate, java.util.Calendar.getInstance());
                pstm.setInt(2, student_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited student's birth date.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No students registered.");
        }
    }

    public static void editStudentFName() throws ParseException {

        if (notEmpty(selectAllS())) {

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

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

            String q = "UPDATE students\n"
                    + "SET firstName= ?"
                    + "WHERE student_id =? \n";
            PreparedStatement pstm = null;
            try {
                pstm = conn.prepareStatement(q);
                pstm.setString(1, fname);
                pstm.setInt(2, student_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited student's first name.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No students registered.");
        }
    }

    public static void editStudentSName() throws ParseException {

        if (notEmpty(selectAllS())) {

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            boolean correct_form = false;
            String sname;
            do {
                System.out.println("\n" + "Enter student's second name" + "\n"
                        + "*** Up to 50 characters ***" + "\n");
                sname = scanner.nextLine();
                if (stringChecker(sname, 49) == true) {
                    correct_form = true;
                } else {
                    System.out.println("Invalid Format. Try again.");
                }
            } while (correct_form == false);

            String q = "UPDATE students\n"
                    + "SET secondName= ?"
                    + "WHERE student_id =? \n";
            PreparedStatement pstm = null;
            try {
                pstm = conn.prepareStatement(q);
                pstm.setString(1, sname);
                pstm.setInt(2, student_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited student's second name.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No students registered.");
        }
    }

    public static void editTrainerFName() throws ParseException {

        if (notEmpty(selectAllT())) {

            System.out.println("\n" + "Select the Trainer.");
            Trainer t = printAndPick(selectAllT());
            Integer trainer_id = t.getTrainer_id();

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

            String q = "UPDATE trainers\n"
                    + "SET firstName= ?"
                    + "WHERE trainer_id =? \n";
            PreparedStatement pstm = null;
            try {
                pstm = conn.prepareStatement(q);
                pstm.setString(1, fname);
                pstm.setInt(2, trainer_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited trainer's first name.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No trainers registered.");
        }
    }

    public static void editTrainerSName() throws ParseException {

        if (notEmpty(selectAllT())) {

            System.out.println("\n" + "Select the Trainer.");
            Trainer t = printAndPick(selectAllT());
            Integer trainer_id = t.getTrainer_id();

            boolean correct_form = false;
            String sname;
            do {
                System.out.println("\n" + "Enter trainer's second name" + "\n"
                        + "*** Up to 50 characters ***" + "\n");
                sname = scanner.nextLine();
                if (stringChecker(sname, 49) == true) {
                    correct_form = true;
                } else {
                    System.out.println("Invalid Format. Try again.");
                }
            } while (correct_form == false);

            String q = "UPDATE trainers\n"
                    + "SET secondName= ?"
                    + "WHERE trainer_id =? \n";
            PreparedStatement pstm = null;
            try {
                pstm = conn.prepareStatement(q);
                pstm.setString(1, sname);
                pstm.setInt(2, trainer_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited trainer's second name.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No trainers registered.");
        }
    }

    public static void editTrainerSubject() throws ParseException {

        if (notEmpty(selectAllT())) {

            System.out.println("\n" + "Select the Trainer.");
            Trainer t = printAndPick(selectAllT());
            Integer trainer_id = t.getTrainer_id();

            boolean correct_form = false;
            String subject;
            do {
                System.out.println("\n" + "Enter trainer's subject" + "\n"
                        + "*** Up to 50 characters ***" + "\n");
                subject = scanner.nextLine();
                if (stringChecker(subject, 49) == true) {
                    correct_form = true;
                } else {
                    System.out.println("Invalid Format. Try again.");
                }
            } while (correct_form == false);

            String q = "UPDATE trainers\n"
                    + "SET trainerSubject= ?"
                    + "WHERE trainer_id =? \n";
            PreparedStatement pstm = null;
            try {
                pstm = conn.prepareStatement(q);
                pstm.setString(1, subject);
                pstm.setInt(2, trainer_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited trainer's subject.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No trainers registered.");
        }
    }

    public static void editCourseTitle() throws ParseException {

        if (notEmpty(selectAllC())) {

            System.out.println("\n" + "Select the Course.");
            Course c = printAndPick(selectAllC());
            Integer course_id = c.getCourse_id();

            boolean correct_form = false;
            String title;
            do {
                System.out.println("\n" + "Enter course's title." + "\n"
                        + "*** Up to 50 characters ***" + "\n");
                title = scanner.nextLine();
                if (stringChecker(title, 49) == true) {
                    correct_form = true;
                } else {
                    System.out.println("Invalid Format. Try again.");
                }
            } while (correct_form == false);

            String q = "UPDATE courses\n"
                    + "SET title= ?"
                    + "WHERE course_id =? \n";
            PreparedStatement pstm = null;
            try {
                pstm = conn.prepareStatement(q);
                pstm.setString(1, title);
                pstm.setInt(2, course_id);

                pstm.executeUpdate();
                System.out.println("You successfully edited course's title.");

            } catch (SQLException e) {
                System.out.println("Query failed:" + e.getMessage());
            } finally {
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No courses registered.");
        }
    }

}
