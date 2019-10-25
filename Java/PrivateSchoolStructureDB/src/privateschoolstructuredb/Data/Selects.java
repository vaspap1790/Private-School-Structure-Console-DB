package privateschoolstructuredb.Data;

import java.sql.*;
import java.util.*;
import static privateschoolstructuredb.Data.Datasource.conn;
import privateschoolstructuredb.Entities.*;

public class Selects {

    public static ArrayList<Student> selectAllS() {

        ArrayList<Student> students = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM Students;")) {
            while (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDouble(6));
                students.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return students;
    }

    public static ArrayList<Trainer> selectAllT() {

        ArrayList<Trainer> trainers = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM Trainers;")) {
            while (rs.next()) {
                Trainer t = new Trainer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                trainers.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return trainers;
    }

    public static ArrayList<Course> selectAllC() {

        ArrayList<Course> courses = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM Courses;")) {
            while (rs.next()) {
                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6));
                courses.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return courses;
    }

    public static ArrayList<AssignmentsModels> selectAllAM() {

        ArrayList<AssignmentsModels> assignments = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c.course_id,c.title as Course_title,a.assignment_id,a.title as Assignment_title,a.assignDescription,a.subDatetime\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN AssignmentsModels a ON c.course_id = a.course_id\n"
                        + "ORDER BY c.title;")) {
            while (rs.next()) {
                AssignmentsModels a = new AssignmentsModels(rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(1), rs.getString(2));
                assignments.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return assignments;
    }

    public static ArrayList<Assignment> selectAllA() {

        ArrayList<Assignment> assignments = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM Assignments;")) {
            while (rs.next()) {
                Assignment a = new Assignment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                assignments.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return assignments;
    }

    public static ArrayList<StudentsInCourses> selectAllStudentsInCourses() {

        ArrayList<StudentsInCourses> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM StudentsInCourses;")) {
            while (rs.next()) {
                StudentsInCourses sic = new StudentsInCourses(rs.getInt(1), rs.getInt(2));
                ids.add(sic);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return ids;
    }

    public static ArrayList<TrainersInCourses> selectAllTrainersInCourses() {

        ArrayList<TrainersInCourses> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM TrainersInCourses;")) {
            while (rs.next()) {
                TrainersInCourses tic = new TrainersInCourses(rs.getInt(1), rs.getInt(2));
                ids.add(tic);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return ids;
    }

    public static ArrayList<AssignmentsInStudents> selectAllAssignmentsInStudents() {

        ArrayList<AssignmentsInStudents> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM AssignmentsInStudents;")) {
            while (rs.next()) {
                AssignmentsInStudents ais = new AssignmentsInStudents(rs.getInt(1), rs.getInt(2));
                ids.add(ais);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return ids;
    }

    public static ArrayList<Integer> selectAllCoursesOfAStudent(int student_id) {

        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < selectAllStudentsInCourses().size(); i++) {
            if (selectAllStudentsInCourses().get(i).getStudent_id() == student_id) {
                ids.add(selectAllStudentsInCourses().get(i).getCourse_id());
            }
        }
        return ids;
    }

    public static ArrayList<Integer> selectAllCoursesOfATrainer(int trainer_id) {

        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < selectAllTrainersInCourses().size(); i++) {
            if (selectAllTrainersInCourses().get(i).getTrainer_id() == trainer_id) {
                ids.add(selectAllTrainersInCourses().get(i).getCourse_id());
            }
        }
        return ids;
    }

    public static ArrayList<Integer> selectAllAssignmentsModelsOfACourse(int course_id) {

        ArrayList<Integer> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT a.assignment_id,a.title as Assignment_title,a.assignDescription,a.subDatetime\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN AssignmentsModels a ON c.course_id = a.course_id\n"
                        + "WHERE c.course_id =" + course_id)) {
            while (rs.next()) {
                Integer i = rs.getInt(1);
                ids.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }
        return ids;
    }

    public static ArrayList<Integer> selectAllAssignmentsOfACourse(int course_id) {

        ArrayList<Integer> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT a.assignment_id,a.title as Assignment_title,a.assignDescription,a.subDatetime\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN Assignments a ON c.course_id = a.course_id\n"
                        + "WHERE c.course_id =" + course_id)) {
            while (rs.next()) {
                Integer i = rs.getInt(1);
                ids.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }
        return ids;
    }

    public static ArrayList<Integer> selectAllStudentsOfACourse(int course_id) {

        ArrayList<Integer> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s.student_id,s.firstName,s.secondName,c.title\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN StudentsInCourses sic ON c.course_id = sic.course_id\n"
                        + "INNER JOIN Students s ON sic.student_id = s.student_id\n"
                        + "WHERE c.course_id=" + course_id)) {
            while (rs.next()) {
                Integer i = rs.getInt(1);
                ids.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return ids;
    }

    public static ArrayList<Integer> selectAllTrainersOfACourse(int course_id) {

        ArrayList<Integer> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT t.trainer_id,t.firstName,t.secondName,c.title\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN TrainersInCourses tic ON c.course_id = tic.course_id\n"
                        + "INNER JOIN Trainers t ON tic.trainer_id = t.trainer_id\n"
                        + "WHERE c.course_id=" + course_id)) {
            while (rs.next()) {
                Integer i = rs.getInt(1);
                ids.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return ids;
    }

    public static ArrayList<Integer> selectAllAssignmentsOfAStudent(int student_id) {

        ArrayList<Integer> ids = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n"
                        + "FROM assignmentsinstudents WHERE student_id =" + student_id)) {
            while (rs.next()) {
                Integer i = rs.getInt(2);
                ids.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        return ids;
    }
}
