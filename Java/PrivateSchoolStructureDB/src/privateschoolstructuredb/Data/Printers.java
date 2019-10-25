package privateschoolstructuredb.Data;

import java.sql.*;
import java.util.ArrayList;
import privateschoolstructuredb.Checker;
import static privateschoolstructuredb.Checker.notEmpty;
import static privateschoolstructuredb.Data.Datasource.conn;
import static privateschoolstructuredb.Data.Selects.*;
import privateschoolstructuredb.Entities.*;

public class Printers {

    public static <X> void printArrayList(ArrayList<X> arX) {

        if (notEmpty(arX)) {
            for (int i = 0; i < arX.size(); i++) {
                System.out.println((i + 1) + ". " + arX.get(i));
            }
        } else {
            System.out.println("No registries.");
        }
    }

    public static <X> X printAndPick(ArrayList<X> arX) {

        printArrayList(arX);
        boolean found = false;
        int index;

        do {
            index = Checker.intCheck();
            if ((index > 0) && (index <= arX.size())) {
                found = true;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        } while (found == false);

        return arX.get((index - 1));
    }

    public static void printStudentsOfACourse(int course_id) {

        String course_title = null;
        ArrayList<Student> arS = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s.student_id,s.firstName,s.secondName,c.title\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN StudentsInCourses sic ON c.course_id = sic.course_id\n"
                        + "INNER JOIN Students s ON sic.student_id = s.student_id\n"
                        + "WHERE c.course_id=" + course_id)) {
            while (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
                arS.add(s);
                course_title = rs.getString(4);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }

        if (notEmpty(arS)) {
            System.out.println("\n" + course_title + "\n");
            printArrayList(arS);
        } else {
            Course c = new Course();
            for (int i = 0; i < selectAllC().size(); i++) {
                if (selectAllC().get(i).getCourse_id().byteValue() == course_id) {
                    c = selectAllC().get(i);
                }
            }
            System.out.println("\n" + c.getTitle() + " has no students registered yet." + "\n");
        }
    }

    public static void printTrainersOfACourse(int course_id) {

        String course_title = null;
        ArrayList<Trainer> arT = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT t.trainer_id,t.firstName,t.secondName,c.title\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN TrainersInCourses tic ON c.course_id = tic.course_id\n"
                        + "INNER JOIN Trainers t ON tic.trainer_id = t.trainer_id\n"
                        + "WHERE c.course_id =" + course_id)) {

            while (rs.next()) {
                Trainer t = new Trainer(rs.getInt(1), rs.getString(2), rs.getString(3));
                arT.add(t);
                course_title = rs.getString(4);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }

        if (notEmpty(arT)) {
            System.out.println("\n" + course_title + "\n");
            printArrayList(arT);
        } else {
            Course c = new Course();
            for (int i = 0; i < selectAllC().size(); i++) {
                if (selectAllC().get(i).getCourse_id().byteValue() == course_id) {
                    c = selectAllC().get(i);
                }
            }
            System.out.println("\n" + c.getTitle() + " has no trainers registered yet." + "\n");
        }
    }

    public static void printAssignmentsOfACourse(Course c) {

        ArrayList<AssignmentsModels> arAM = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT a.assignment_id,a.title as Assignment_title,a.assignDescription,a.subDatetime,c.title\n"
                        + "FROM Courses c\n"
                        + "INNER JOIN AssignmentsModels a ON c.course_id = a.course_id\n"
                        + "WHERE c.course_id=" + c.getCourse_id())) {
            while (rs.next()) {
                AssignmentsModels a = new AssignmentsModels(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                arAM.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }

        if (notEmpty(arAM)) {
            System.out.println("\n" + c.getTitle() + "\n");
            for (int i = 0; i < arAM.size(); i++) {
                System.out.println("Assignment Id: " + arAM.get(i).getAssignment_id() + " "
                        + ",Assignment Title: " + arAM.get(i).getTitle() + " "
                        + ",Description: " + arAM.get(i).getDescription() + " "
                        + ",SubDateTime: " + arAM.get(i).getSubDateTime());
            }
        } else {
            System.out.println("\n" + c.getTitle() + " has no assignments registered yet." + "\n");
        }
    }

    public static void printAssignmentsOfAStudent(Integer student_id) {

        String student_firstName = null;
        String student_secondName = null;
        ArrayList<Assignment> arA = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s.student_id,s.firstName,s.secondName,c.course_id,c.title as Course_title ,a.assignment_id,a.title as Assignment_title,a.assignDescription,a.subDateTime,a.oralMark,a.totalMark\n"
                        + "FROM Students s\n"
                        + "INNER JOIN AssignmentsINStudents ais ON ais.student_id = s.student_id\n"
                        + "INNER JOIN Assignments a ON ais.assignment_id = a.assignment_id\n"
                        + "INNER JOIN Courses c ON a.course_id = c.course_id\n"
                        + "where s.student_id =" + student_id + "\n"
                        + "ORDER BY s.student_id,Course_title;")) {
            while (rs.next()) {
                Assignment a = new Assignment(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11), rs.getString(5));
                arA.add(a);
                student_firstName = rs.getString(2);
                student_secondName = rs.getString(3);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }

        if (notEmpty(arA)) {
            System.out.println("\n" + "Student_id: " + student_id + " Student name: " + student_firstName + " " + student_secondName + "\n");
            for (int i = 0; i < arA.size(); i++) {
                System.out.println(arA.get(i).getCourse_title()
                        + ", Assignment_id: " + arA.get(i).getAssignment_id()
                        + ", Assignment_title: " + arA.get(i).getTitle()
                        + ", description: " + arA.get(i).getDescription()
                        + ", subDateTime: " + arA.get(i).getSubDateTime()
                        + ", oralMark: " + arA.get(i).getOralMark()
                        + ", totalMark: " + arA.get(i).getTotalMark());
            }
        } else {
            Student s = new Student();
            for (int i = 0; i < selectAllS().size(); i++) {
                if (selectAllS().get(i).getStudent_id().byteValue() == student_id) {
                    s = selectAllS().get(i);
                }
            }
            System.out.println("\n" + s.getFirstName() + " " + s.getLastName() + " has no assignments registered yet." + "\n");
        }
    }

    public static void printCoursesOfAStudent(Integer student_id) {

        String student_firstName = null;
        String student_secondName = null;
        ArrayList<Course> arC = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s.student_id,s.firstName,s.secondName,c.course_id,c.title,c.stream,c.courseType,c.startDate,c.endDate\n"
                        + "FROM StudentsInCourses sc\n"
                        + "INNER JOIN Students s ON s.student_id = sc.student_id\n"
                        + "INNER JOIN Courses c ON sc.course_id = c.course_id\n"
                        + "WHERE s.student_id =" + student_id)) {
            while (rs.next()) {
                Course c = new Course(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getDate(9));
                arC.add(c);
                student_firstName = rs.getString(2);
                student_secondName = rs.getString(3);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }
        if (notEmpty(arC)) {
            System.out.println("\n" + "Student_id: " + student_id + " Student name: " + student_firstName + " " + student_secondName + "\n");
            printArrayList(arC);
        } else {
            Student s = new Student();
            for (int i = 0; i < selectAllS().size(); i++) {
                if (selectAllS().get(i).getStudent_id().byteValue() == student_id) {
                    s = selectAllS().get(i);
                }
            }
            System.out.println("\n" + s.getFirstName() + " " + s.getLastName() + " is not registered in a course." + "\n");
        }
    }

    public static void printCoursesOfATrainer(Integer trainer_id) {

        String trainer_firstName = null;
        String trainer_secondName = null;
        ArrayList<Course> arC = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT t.trainer_id,t.firstName,t.secondName,c.course_id,c.title,c.stream,c.courseType,c.startDate,c.endDate\n"
                        + "FROM TrainersInCourses tc\n"
                        + "INNER JOIN Trainers t ON t.trainer_id = tc.trainer_id\n"
                        + "INNER JOIN Courses c ON tc.course_id = c.course_id\n"
                        + "WHERE t.trainer_id =" + trainer_id)) {
            while (rs.next()) {
                Course c = new Course(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getDate(9));
                arC.add(c);
                trainer_firstName = rs.getString(2);
                trainer_secondName = rs.getString(3);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }
        if (notEmpty(arC)) {
            System.out.println("\n" + "Trainer_id: " + trainer_id + " Trainer name: " + trainer_firstName + " " + trainer_secondName + "\n");
            printArrayList(arC);
        } else {
            Trainer t = new Trainer();
            for (int i = 0; i < selectAllT().size(); i++) {
                if (selectAllT().get(i).getTrainer_id().byteValue() == trainer_id) {
                    t = selectAllT().get(i);
                }
            }
            System.out.println("\n" + t.getFirstName() + " " + t.getLastName() + " is not registered in a course." + "\n");
        }
    }

    public static void printStudentsThatBelongToMoreThanOneCourse() {

        ArrayList<Student> arS = new ArrayList<>();

        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT c.course_id,c.title,s.student_id,s.firstName,s.secondName\n"
                        + "FROM StudentsInCourses sc\n"
                        + "INNER JOIN Students s ON s.student_id = sc.student_id\n"
                        + "INNER JOIN Courses c ON sc.course_id = c.course_id\n"
                        + "GROUP BY s.student_id \n"
                        + "HAVING COUNT(sc.student_id)>1;")) {
            while (rs.next()) {
                Student s = new Student(rs.getInt(3), rs.getString(4), rs.getString(5));
                arS.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }

        if (notEmpty(arS)) {
            for (int i = 0; i < arS.size(); i++) {
                printCoursesOfAStudent(arS.get(i).getStudent_id());
            }
        } else {
            System.out.println("\n" + "There is no student that belongs to more than one courses." + "\n");
        }
    }

    public static void printAssignment(Integer assignment_id) {

        String student_firstName = null;
        String student_secondName = null;
        ArrayList<Assignment> arA = new ArrayList<>();
        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT s.student_id,s.firstName,s.secondName,c.course_id,c.title as Course_title ,a.assignment_id,a.title as Assignment_title,a.assignDescription,a.subDateTime,a.oralMark,a.totalMark\n"
                        + "FROM Students s\n"
                        + "INNER JOIN AssignmentsINStudents ais ON ais.student_id = s.student_id\n"
                        + "INNER JOIN Assignments a ON ais.assignment_id = a.assignment_id\n"
                        + "INNER JOIN Courses c ON a.course_id = c.course_id\n"
                        + "where a.assignment_id =" + assignment_id + "\n"
                        + "ORDER BY s.student_id,Course_title;")) {
            while (rs.next()) {
                Assignment a = new Assignment(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11), rs.getString(5));
                arA.add(a);
                student_firstName = rs.getString(2);
                student_secondName = rs.getString(3);
            }
        } catch (SQLException e) {
            System.out.println("Query failed1:" + e.getMessage());
        }
        System.out.println("\n" + "***Student name: " + student_firstName + " " + student_secondName + "***" + "\n");
        for (int i = 0; i < arA.size(); i++) {
            System.out.println(arA.get(i).getCourse_title()
                    + ", Assignment_id: " + arA.get(i).getAssignment_id()
                    + ", Assignment_title: " + arA.get(i).getTitle()
                    + ", description: " + arA.get(i).getDescription()
                    + ", subDateTime: " + arA.get(i).getSubDateTime()
                    + ", oralMark: " + arA.get(i).getOralMark()
                    + ", totalMark: " + arA.get(i).getTotalMark());
        }
    }
}
