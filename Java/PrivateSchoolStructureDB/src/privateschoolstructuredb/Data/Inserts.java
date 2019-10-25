package privateschoolstructuredb.Data;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static privateschoolstructuredb.Checker.notEmpty;
import static privateschoolstructuredb.Data.Datasource.conn;
import static privateschoolstructuredb.Data.Printers.*;
import static privateschoolstructuredb.Data.Selects.*;
import privateschoolstructuredb.Entities.*;
import static privateschoolstructuredb.Inputs.*;

public class Inserts {

    public static void studentToBase() {

        Student s = new Student();
        try {
            s = inputStudent();
        } catch (ParseException ex) {
            Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.util.Date utilStartDate = s.getDateOfBirth();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

        String q = "INSERT INTO Students (firstName,secondName,birthDate,stream,tuition) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(q);
            pstm.setString(1, s.getFirstName());
            pstm.setString(2, s.getLastName());
            pstm.setDate(3, sqlStartDate, java.util.Calendar.getInstance());
            pstm.setString(4, s.getStream());
            pstm.setDouble(5, s.getTuitionFees());
            pstm.executeUpdate();
            System.out.println("You successfully added the student.");

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

    public static void trainerToBase() {

        Trainer t = inputTrainer();

        String q = "INSERT INTO Trainers (firstName,secondName,trainerSubject) VALUES (?,?,?)";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(q);
            pstm.setString(1, t.getFirstName());
            pstm.setString(2, t.getLastName());
            pstm.setString(3, t.getSubject());

            pstm.executeUpdate();

            System.out.println("\n" + "You successfully registered a new trainer! What would you like to do next?" + "\n");

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

    public static void courseToBase() {

        Course c = new Course();

        try {
            c = inputCourse();
        } catch (ParseException ex) {
            Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.util.Date utilStartDate = c.getStart_date();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        java.util.Date utilEndDate = c.getEnd_date();
        java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

        Integer course_id = null;
        String q = "INSERT INTO Courses (title,stream,courseType,startDate,endDate) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(q, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, c.getTitle());
            pstm.setString(2, c.getStream());
            pstm.setString(3, c.getType());
            pstm.setDate(4, sqlStartDate, java.util.Calendar.getInstance());
            pstm.setDate(5, sqlEndDate, java.util.Calendar.getInstance());

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs != null && rs.next()) {
                course_id = rs.getInt(1);
            }
            System.out.println("You successfully added the course.");

        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        AssignmentsModels a1 = new AssignmentsModels("Individual Project", "Part A", course_id);
        assignmentsModelsToBase(a1);
        AssignmentsModels a2 = new AssignmentsModels("Individual Project", "Part B", course_id);
        assignmentsModelsToBase(a2);
        AssignmentsModels a3 = new AssignmentsModels("Group Project", "Part A", course_id);
        assignmentsModelsToBase(a3);
        AssignmentsModels a4 = new AssignmentsModels("Group Project", "Part B", course_id);
        assignmentsModelsToBase(a4);

    }

    public static void assignmentsModelsToBase(AssignmentsModels a) {

        String q = "INSERT INTO AssignmentsModels (title,assignDescription,subDateTime,course_id) VALUES (?,?,curdate(),?)";
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(q);
            pstm.setString(1, a.getTitle());
            pstm.setString(2, a.getDescription());
            pstm.setInt(3, a.getCourse_id());

            pstm.executeUpdate();

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

    public static void assignmentToBase() {

        AssignmentsModels a = new AssignmentsModels();
        try {
            a = inputAssignment();
        } catch (ParseException ex) {
            Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.util.Date utilStartDate = a.getSubDateTime();
        java.sql.Date sqlDate = new java.sql.Date(utilStartDate.getTime());

        String q = "INSERT INTO AssignmentsModels (title,assignDescription,subDateTime,course_id) VALUES (?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(q);
            pstm.setString(1, a.getTitle());
            pstm.setString(2, a.getDescription());
            pstm.setDate(3, sqlDate, java.util.Calendar.getInstance());
            pstm.setInt(4, a.getCourse_id());

            pstm.executeUpdate();
            System.out.println("You successfully added the assignment.");

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

    public static void trainersInCourses() {

        System.out.println("Overview current teaching stuff distribution.");
        for (int i = 0; i < selectAllC().size(); i++) {
            printTrainersOfACourse(selectAllC().get(i).getCourse_id());
        }

        System.out.println("\n" + "Select the Trainer.");
        Trainer t = printAndPick(selectAllT());
        Integer trainer_id = t.getTrainer_id();

        System.out.println("\n" + "Select the Course.");
        Course c = printAndPick(selectAllC());
        Integer course_id = c.getCourse_id();

        String q = "INSERT INTO TrainersInCourses (trainer_id,course_id) VALUES (?,?)";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(q);
            pstm.setInt(1, trainer_id);
            pstm.setInt(2, course_id);

            pstm.executeUpdate();
            System.out.println("You successfully registered the trainer in the course.");

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

    public static void studentsInCourses() {

        System.out.println("Overview students to courses distribution.");
        for (int i = 0; i < selectAllC().size(); i++) {
            printStudentsOfACourse(selectAllC().get(i).getCourse_id());
        }

        System.out.println("\n" + "Select the Student.");
        Student s = printAndPick(selectAllS());
        Integer student_id = s.getStudent_id();

        System.out.println("\n" + "Select the Course.");
        Course c = printAndPick(selectAllC());
        Integer course_id = c.getCourse_id();

        String q = "INSERT INTO StudentsInCourses (student_id,course_id) VALUES (?,?)";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(q);
            pstm.setInt(1, student_id);
            pstm.setInt(2, course_id);

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ArrayList<AssignmentsModels> assmods = new ArrayList<>();
        for (int i = 0; i < selectAllAM().size(); i++) {
            if (selectAllAM().get(i).getCourse_id().byteValue() == course_id) {
                assmods.add(selectAllAM().get(i));
            }
        }

        if (notEmpty(assmods)) {
            for (int i = 0; i < assmods.size(); i++) {
                assignmentsInStudents(student_id, assmods.get(i));
            }
        }
        System.out.println("You successfully registered the student in the course.");
    }

    public static void assignmentsInStudents() {

        System.out.println("Overview assignments to students distribution.");
        for (int i = 0; i < selectAllS().size(); i++) {
            printAssignmentsOfAStudent(selectAllS().get(i).getStudent_id());
        }

        System.out.println("\n" + "Select the Student.");
        Student s = printAndPick(selectAllS());
        Integer student_id = s.getStudent_id();

        System.out.println("\n" + "Select the Assignment.");
        AssignmentsModels am = printAndPick(selectAllAM());
        Assignment a = new Assignment(am);
        Integer a_id = null;
        java.util.Date utilStartDate = a.getSubDateTime();
        java.sql.Date sqlDate = new java.sql.Date(utilStartDate.getTime());

        String query = "INSERT INTO Assignments (title,assignDescription,subDatetime,course_id) VALUES (?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, a.getTitle());
            pstm.setString(2, a.getDescription());
            pstm.setDate(3, sqlDate, java.util.Calendar.getInstance());
            pstm.setInt(4, a.getCourse_id());

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs != null && rs.next()) {
                a_id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Query insert AssignmentsInStudents failed:" + e.getMessage());
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        PreparedStatement pstm1 = null;
        String query1 = "INSERT INTO AssignmentsInStudents VALUES (?,?)";

        try {
            pstm1 = conn.prepareStatement(query1);
            pstm1.setInt(1, student_id);
            pstm1.setInt(2, a_id);

            pstm1.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Query insert AssignmentsInStudents failed:" + e.getMessage());
        } finally {
            try {
                pstm1.close();
            } catch (SQLException ex) {
                Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void assignmentsInStudents(int student_id, AssignmentsModels am) {

        Assignment a = new Assignment(am);
        Integer a_id = null;
        java.util.Date utilStartDate = a.getSubDateTime();
        java.sql.Date sqlDate = new java.sql.Date(utilStartDate.getTime());

        String query = "INSERT INTO Assignments (title,assignDescription,subDatetime,course_id) VALUES (?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, a.getTitle());
            pstm.setString(2, a.getDescription());
            pstm.setDate(3, sqlDate, java.util.Calendar.getInstance());
            pstm.setInt(4, a.getCourse_id());

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs != null && rs.next()) {
                a_id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Query insert AssignmentsInStudents failed:" + e.getMessage());
        } finally {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        PreparedStatement pstm1 = null;
        String query1 = "INSERT INTO AssignmentsInStudents VALUES (?,?)";

        try {
            pstm1 = conn.prepareStatement(query1);
            pstm1.setInt(1, student_id);
            pstm1.setInt(2, a_id);

            pstm1.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Query insert AssignmentsInStudents failed:" + e.getMessage());
        } finally {
            try {
                pstm1.close();
            } catch (SQLException ex) {
                Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
