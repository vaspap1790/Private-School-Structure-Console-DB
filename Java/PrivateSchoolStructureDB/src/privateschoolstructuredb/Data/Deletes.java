package privateschoolstructuredb.Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static privateschoolstructuredb.Checker.notEmpty;
import static privateschoolstructuredb.Data.Datasource.conn;
import static privateschoolstructuredb.Data.Printers.*;
import static privateschoolstructuredb.Data.Selects.*;
import privateschoolstructuredb.Entities.*;

public class Deletes {

    public static void deleteAStudent() {

        if (notEmpty(selectAllS())) {

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            if (notEmpty(selectAllCoursesOfAStudent(student_id))) {
                for (int i = 0; i < selectAllCoursesOfAStudent(student_id).size(); i++) {
                    removeStudentFromCourse(student_id, selectAllCoursesOfAStudent(student_id).get(i));
                }
            }

            if (notEmpty(selectAllAssignmentsOfAStudent(student_id))) {

                for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                    removeAssignmentFromStudent(student_id, selectAllAssignmentsOfAStudent(student_id).get(i));
                }

                for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                    for (int j = 0; j < selectAllA().size(); j++) {
                        if (selectAllAssignmentsOfAStudent(student_id).get(i) == selectAllA().get(j).getAssignment_id()) {
                            deleteAnAssignment(selectAllA().get(j).getAssignment_id());
                        }
                    }
                }
            }

            String q = "DELETE FROM students\n"
                    + "WHERE student_id =?";
            PreparedStatement pstm = null;
            ResultSet rs = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setInt(1, student_id);

                pstm.executeUpdate();
                System.out.println("\n" + "You successfully deleted the student." + "\n");

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
            System.out.println("\n" + "No students registered." + "\n");
        }
    }

    public static void deleteAStudent(int student_id) {

        if (notEmpty(selectAllS())) {

            if (notEmpty(selectAllCoursesOfAStudent(student_id))) {
                for (int i = 0; i < selectAllCoursesOfAStudent(student_id).size(); i++) {
                    removeStudentFromCourse(student_id, selectAllCoursesOfAStudent(student_id).get(i));
                }
            }

            if (notEmpty(selectAllAssignmentsOfAStudent(student_id))) {

                for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                    removeAssignmentFromStudent(student_id, selectAllAssignmentsOfAStudent(student_id).get(i));
                }

                for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                    for (int j = 0; j < selectAllA().size(); j++) {
                        if (selectAllAssignmentsOfAStudent(student_id).get(i) == selectAllA().get(j).getAssignment_id()) {
                            deleteAnAssignment(selectAllA().get(j).getAssignment_id());
                        }
                    }
                }
            }

            String q = "DELETE FROM students\n"
                    + "WHERE student_id =?";
            PreparedStatement pstm = null;
            ResultSet rs = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setInt(1, student_id);

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
        } else {
            System.out.println("\n" + "No students registered." + "\n");
        }
    }

    public static void deleteAllStudents() {

        if (notEmpty(selectAllS())) {

            String q = "DELETE FROM students";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
            System.out.println("\n" + "You successfully deleted all the students." + "\n");
        } else {
            System.out.println("\n" + "No students registered." + "\n");
        }
    }

    public static void deleteAllTrainers() {

        if (notEmpty(selectAllT())) {

            String q = "DELETE FROM trainers";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
            System.out.println("\n" + "You successfully deleted all the trainers." + "\n");
        } else {
            System.out.println("\n" + "No trainers registered." + "\n");
        }
    }

    public static void deleteAllCourses() {

        if (notEmpty(selectAllC())) {

            String q = "DELETE FROM courses";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
            System.out.println("\n" + "You successfully deleted all the courses." + "\n");
        } else {
            System.out.println("\n" + "No courses registered." + "\n");
        }
    }

    public static void deleteAllAssignmentsModels() {

        if (notEmpty(selectAllAM())) {

            String q = "DELETE FROM assignmentsmodels";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
            System.out.println("\n" + "You successfully deleted all the assignmnent models." + "\n");
        } else {
            System.out.println("\n" + "No assigment models registered." + "\n");
        }
    }

    public static void deleteAllAssignments() {

        if (notEmpty(selectAllA())) {

            String q = "DELETE FROM assignments";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
            System.out.println("\n" + "You successfully deleted all the assignmnents." + "\n");
        } else {
            System.out.println("\n" + "No assigments registered." + "\n");
        }
    }

    public static void deleteAllAssignmentsInStudents() {

        if (notEmpty(selectAllAssignmentsInStudents())) {

            String q = "DELETE FROM assignmentsinstudents";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
        } else {
            System.out.println("\n" + "No assigments in students registered." + "\n");
        }
    }

    public static void deleteAllStudentsInCourses() {

        if (notEmpty(selectAllStudentsInCourses())) {

            String q = "DELETE FROM studentsincourses";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
        } else {
            System.out.println("\n" + "No students in courses registered." + "\n");
        }
    }

    public static void deleteAllTrainersInCourses() {

        if (notEmpty(selectAllTrainersInCourses())) {

            String q = "DELETE FROM trainersincourses";
            PreparedStatement pstm = null;

            try {
                pstm = conn.prepareStatement(q);

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
        } else {
            System.out.println("\n" + "No trainers in courses registered." + "\n");
        }
    }

    public static void deleteATrainer() {

        if (notEmpty(selectAllT())) {

            System.out.println("\n" + "Select the Trainer.");
            Trainer t = printAndPick(selectAllT());
            Integer trainer_id = t.getTrainer_id();

            if (notEmpty(selectAllCoursesOfATrainer(trainer_id))) {
                for (int i = 0; i < selectAllCoursesOfATrainer(trainer_id).size(); i++) {
                    removeTrainerFromCourse(trainer_id, selectAllCoursesOfATrainer(trainer_id).get(i));
                }
            }

            String q = "DELETE FROM trainers\n"
                    + "WHERE trainer_id =?";
            PreparedStatement pstm = null;
            ResultSet rs = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setInt(1, trainer_id);

                pstm.executeUpdate();
                System.out.println("\n" + "You succesfully deleted the trainer." + "\n");

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
            System.out.println("\n" + "No trainers registered" + "\n");
        }
    }

    public static void deleteATrainer(int trainer_id) {

        if (notEmpty(selectAllT())) {

            if (notEmpty(selectAllCoursesOfATrainer(trainer_id))) {
                for (int i = 0; i < selectAllCoursesOfATrainer(trainer_id).size(); i++) {
                    removeTrainerFromCourse(trainer_id, selectAllCoursesOfATrainer(trainer_id).get(i));
                }
            }

            String q = "DELETE FROM trainers\n"
                    + "WHERE trainer_id =?";
            PreparedStatement pstm = null;
            ResultSet rs = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setInt(1, trainer_id);

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
        } else {
            System.out.println("\n" + "No trainers registered" + "\n");
        }
    }

    public static void removeStudentFromCourse() {

        if (notEmpty(selectAllS()) && notEmpty(selectAllC()) && notEmpty(selectAllStudentsInCourses())) {

            System.out.println("\n" + "Overview students to courses distribution." + "\n");

            for (int i = 0; i < selectAllC().size(); i++) {
                printStudentsOfACourse(selectAllC().get(i).getCourse_id());
            }

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            System.out.println("\n" + "Select the Course.");
            ArrayList<Course> arC = new ArrayList<>();
            for (int i = 0; i < selectAllCoursesOfAStudent(student_id).size(); i++) {
                for (int j = 0; j < selectAllC().size(); j++) {
                    if (selectAllCoursesOfAStudent(student_id).get(i).byteValue() == selectAllC().get(j).getCourse_id().byteValue()) {
                        arC.add(selectAllC().get(j));
                    }
                }
            }
            Course c = printAndPick(arC);
            Integer course_id = c.getCourse_id();

            StudentsInCourses sic = new StudentsInCourses(student_id, course_id);

            boolean found = false;
            for (int i = 0; i < selectAllStudentsInCourses().size(); i++) {
                if (selectAllStudentsInCourses().get(i).equals(sic)) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM studentsincourses\n"
                        + "WHERE student_id =? \n"
                        + "AND course_id = ?";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, student_id);
                    pstm.setInt(2, course_id);

                    pstm.executeUpdate();
                    System.out.println("\n" + "The student has successfully been unregistered from this course." + "\n");

                } catch (SQLException e) {
                    System.out.println("Query failed:" + e.getMessage());
                } finally {
                    try {
                        pstm.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Selects.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                ArrayList<Assignment> arS = new ArrayList<>();
                ArrayList<Assignment> arS2 = new ArrayList<>();

                if (notEmpty(selectAllAssignmentsOfAStudent(student_id))) {
                    for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                        for (int j = 0; j < selectAllA().size(); j++) {
                            if (selectAllAssignmentsOfAStudent(student_id).get(i).byteValue() == selectAllA().get(j).getAssignment_id().byteValue()) {
                                arS.add(selectAllA().get(j));
                            }
                        }
                    }
                }
                if (notEmpty(arS)) {
                    for (int i = 0; i < arS.size(); i++) {
                        if (arS.get(i).getCourse_id().byteValue() == course_id) {
                            arS2.add(arS.get(i));
                        }
                    }
                }
                if (notEmpty(arS2)) {
                    for (int i = 0; i < arS2.size(); i++) {
                        removeAssignmentFromStudent(student_id, arS2.get(i).getAssignment_id());
                    }
                    for (int i = 0; i < arS2.size(); i++) {
                        deleteAnAssignment(arS2.get(i).getAssignment_id());
                    }
                }

            } else {
                System.out.println("\n" + "This student is not registered in this course." + "\n");
            }
        } else {
            System.out.println("\n" + "No students registered to courses." + "\n");
        }
    }

    public static void removeStudentFromCourse(int student_id, int course_id) {

        if (notEmpty(selectAllS()) && notEmpty(selectAllC()) && notEmpty(selectAllStudentsInCourses())) {

            StudentsInCourses sic = new StudentsInCourses(student_id, course_id);

            boolean found = false;
            for (int i = 0; i < selectAllStudentsInCourses().size(); i++) {
                if (selectAllStudentsInCourses().get(i).equals(sic)) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM studentsincourses\n"
                        + "WHERE student_id =? \n"
                        + "AND course_id = ?";
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
                ArrayList<Assignment> arS = new ArrayList<>();
                ArrayList<Assignment> arS2 = new ArrayList<>();

                if (notEmpty(selectAllAssignmentsOfAStudent(student_id))) {
                    for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                        for (int j = 0; j < selectAllA().size(); j++) {
                            if (selectAllAssignmentsOfAStudent(student_id).get(i).byteValue() == selectAllA().get(j).getAssignment_id().byteValue()) {
                                arS.add(selectAllA().get(j));
                            }
                        }
                    }
                }
                if (notEmpty(arS)) {
                    for (int i = 0; i < arS.size(); i++) {
                        if (arS.get(i).getCourse_id().byteValue() == course_id) {
                            arS2.add(arS.get(i));
                        }
                    }
                }
                if (notEmpty(arS2)) {
                    for (int i = 0; i < arS2.size(); i++) {
                        removeAssignmentFromStudent(student_id, arS2.get(i).getAssignment_id());
                    }
                    for (int i = 0; i < arS2.size(); i++) {
                        deleteAnAssignment(arS2.get(i).getAssignment_id());
                    }
                }
            } else {
                System.out.println("\n" + "This student is not registered in this course." + "\n");
            }
        } else {
            System.out.println("\n" + "No students registered to courses." + "\n");
        }
    }

    public static void removeAssignmentFromStudent() {

        if (notEmpty(selectAllS()) && notEmpty(selectAllA()) && notEmpty(selectAllAssignmentsInStudents())) {

            System.out.println("Overview students' assignments.");
            for (int i = 0; i < selectAllS().size(); i++) {
                printAssignmentsOfAStudent(selectAllS().get(i).getStudent_id());
            }

            System.out.println("\n" + "Select the Student.");
            Student s = printAndPick(selectAllS());
            Integer student_id = s.getStudent_id();

            System.out.println("\n" + "Select the Assignment.");
            ArrayList<Assignment> arA = new ArrayList<>();
            for (int i = 0; i < selectAllAssignmentsOfAStudent(student_id).size(); i++) {
                for (int j = 0; j < selectAllA().size(); j++) {
                    if (selectAllAssignmentsOfAStudent(student_id).get(i).byteValue() == selectAllA().get(j).getAssignment_id().byteValue()) {
                        arA.add(selectAllA().get(j));
                    }
                }
            }
            Assignment a = printAndPick(arA);
            Integer assignment_id = a.getAssignment_id();

            AssignmentsInStudents ais = new AssignmentsInStudents(student_id, assignment_id);

            boolean found = false;
            for (int i = 0; i < selectAllAssignmentsInStudents().size(); i++) {
                if (selectAllAssignmentsInStudents().get(i).equals(ais)) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM assignmentsinstudents\n"
                        + "WHERE student_id =? \n"
                        + "AND assignment_id = ?";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, student_id);
                    pstm.setInt(2, assignment_id);

                    pstm.executeUpdate();
                    System.out.println("\n" + "You successfully removed the assignment from this student." + "\n");

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
                System.out.println("\n" + "This student is not registered in this assignment." + "\n");
            }
        } else {
            System.out.println("\n" + "No assignments to students registered." + "\n");
        }
    }

    public static void removeAssignmentFromStudent(int student_id, int assignment_id) {

        if (notEmpty(selectAllS()) && notEmpty(selectAllA()) && notEmpty(selectAllAssignmentsInStudents())) {

            AssignmentsInStudents ais = new AssignmentsInStudents(student_id, assignment_id);

            boolean found = false;
            for (int i = 0; i < selectAllAssignmentsInStudents().size(); i++) {
                if (selectAllAssignmentsInStudents().get(i).equals(ais)) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM assignmentsinstudents\n"
                        + "WHERE student_id =? \n"
                        + "AND assignment_id = ?";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, student_id);
                    pstm.setInt(2, assignment_id);

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
            } else {
                System.out.println("\n" + "This student is not registered in this assignment." + "\n");
            }
        } else {
            System.out.println("\n" + "No assignments to students registered." + "\n");
        }
    }

    public static void removeAssignmentFromStudents(int assignment_id) {

        if (notEmpty(selectAllS()) && notEmpty(selectAllA()) && notEmpty(selectAllAssignmentsInStudents())) {

            ArrayList<Integer> ids = new ArrayList<>();
            for (int i = 0; i < selectAllAssignmentsInStudents().size(); i++) {
                ids.add(selectAllAssignmentsInStudents().get(i).getAssignment_id());
            }

            boolean found = false;
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i).byteValue() == assignment_id) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM assignmentsinstudents\n"
                        + "assignment_id = ? ";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, assignment_id);

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
        } else {
            System.out.println("\n" + "No assignments to students registered." + "\n");
        }
    }

    public static void removeTrainerFromCourse() {

        if (notEmpty(selectAllT()) && notEmpty(selectAllC()) && notEmpty(selectAllTrainersInCourses())) {

            System.out.println("\n" + "Overview current teaching stuff distribution." + "\n");
            for (int i = 0; i < selectAllC().size(); i++) {
                printTrainersOfACourse(selectAllC().get(i).getCourse_id());
            }

            System.out.println("\n" + "Select the Trainer.");
            Trainer t = printAndPick(selectAllT());
            Integer trainer_id = t.getTrainer_id();

            System.out.println("\n" + "Select the Course.");
            ArrayList<Course> arC = new ArrayList<>();
            for (int i = 0; i < selectAllCoursesOfATrainer(trainer_id).size(); i++) {
                for (int j = 0; j < selectAllC().size(); j++) {
                    if (selectAllCoursesOfATrainer(trainer_id).get(i).byteValue() == selectAllC().get(j).getCourse_id().byteValue()) {
                        arC.add(selectAllC().get(j));
                    }
                }
            }
            Course c = printAndPick(arC);
            Integer course_id = c.getCourse_id();

            TrainersInCourses tic = new TrainersInCourses(trainer_id, course_id);

            boolean found = false;
            for (int i = 0; i < selectAllTrainersInCourses().size(); i++) {
                if (selectAllTrainersInCourses().get(i).equals(tic)) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM trainersincourses\n"
                        + "WHERE trainer_id =? \n"
                        + "AND course_id = ?";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, trainer_id);
                    pstm.setInt(2, course_id);

                    pstm.executeUpdate();
                    System.out.println("\n" + "You successfully removed the trainer from this course." + "\n");

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
                System.out.println("\n" + "This trainer is not involved in this course." + "\n");
            }
        } else {
            System.out.println("\n" + "No trainers to courses registered." + "\n");
        }
    }

    public static void removeTrainerFromCourse(int trainer_id, int course_id) {

        if (notEmpty(selectAllT()) && notEmpty(selectAllC()) && notEmpty(selectAllTrainersInCourses())) {

            TrainersInCourses tic = new TrainersInCourses(trainer_id, course_id);

            boolean found = false;
            for (int i = 0; i < selectAllTrainersInCourses().size(); i++) {
                if (selectAllTrainersInCourses().get(i).equals(tic)) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM trainersincourses\n"
                        + "WHERE trainer_id =? \n"
                        + "AND course_id = ?";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, trainer_id);
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
            } else {
                System.out.println("\n" + "This trainer is not involved in this course." + "\n");
            }
        } else {
            System.out.println("\n" + "No trainers to courses registered." + "\n");
        }
    }

    public static void deleteAnAssignment(int assignment_id) {

        if (notEmpty(selectAllA())) {

            removeAssignmentFromStudents(assignment_id);

            ArrayList<Integer> ids = new ArrayList<>();
            for (int i = 0; i < selectAllA().size(); i++) {
                ids.add(selectAllA().get(i).getAssignment_id());
            }

            boolean found = false;
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i).byteValue() == assignment_id) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM assignments\n"
                        + "WHERE assignment_id =?";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, assignment_id);

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
        } else {
            System.out.println("\n" + "No assignments registered." + "\n");
        }
    }

    public static void deleteAnAssignmentsModels(int assignment_id) {

        if (notEmpty(selectAllAM())) {

            ArrayList<Integer> ids = new ArrayList<>();
            for (int i = 0; i < selectAllAM().size(); i++) {
                ids.add(selectAllAM().get(i).getAssignment_id());
            }

            boolean found = false;
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i).byteValue() == assignment_id) {
                    found = true;
                }
            }
            if (found == true) {

                String q = "DELETE FROM assignmentsmodels\n"
                        + "WHERE assignment_id =?";
                PreparedStatement pstm = null;
                ResultSet rs = null;

                try {
                    pstm = conn.prepareStatement(q);
                    pstm.setInt(1, assignment_id);

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
        } else {
            System.out.println("\n" + "No assignments registered." + "\n");
        }
    }

   

    public static void deleteACourse(int course_id) {

        if (notEmpty(selectAllC())) {

            if (notEmpty(selectAllAssignmentsOfACourse(course_id))) {

                for (int i = 0; i < selectAllAssignmentsOfACourse(course_id).size(); i++) {
                    removeAssignmentFromStudents(selectAllAssignmentsOfACourse(course_id).get(i));
                }

                for (int i = 0; i < selectAllAssignmentsOfACourse(course_id).size(); i++) {
                    deleteAnAssignment(selectAllAssignmentsOfACourse(course_id).get(i));
                }
            }

            if (notEmpty(selectAllAssignmentsModelsOfACourse(course_id))) {

                for (int i = 0; i < selectAllAssignmentsModelsOfACourse(course_id).size(); i++) {
                    deleteAnAssignmentsModels(selectAllAssignmentsModelsOfACourse(course_id).get(i));
                }
            }

            if (notEmpty(selectAllStudentsOfACourse(course_id))) {

                for (int i = 0; i < selectAllStudentsOfACourse(course_id).size(); i++) {
                    removeStudentFromCourse(selectAllStudentsOfACourse(course_id).get(i), course_id);
                }
            }

            if (notEmpty(selectAllTrainersOfACourse(course_id))) {

                for (int i = 0; i < selectAllTrainersOfACourse(course_id).size(); i++) {
                    removeTrainerFromCourse(selectAllTrainersOfACourse(course_id).get(i), course_id);
                }
            }

            String q = "DELETE FROM courses\n"
                    + "WHERE course_id =?";
            PreparedStatement pstm = null;
            ResultSet rs = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setInt(1, course_id);

                pstm.executeUpdate();
                System.out.println("You successfully deleted the course.");

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
            System.out.println("\n" + "No courses registered." + "\n");
        }
    }
    
    
    public static void deleteACourse() {

        if (notEmpty(selectAllC())) {

            System.out.println("\n" + "Select the Course.");
            Course c = printAndPick(selectAllC());
            int course_id = c.getCourse_id().byteValue();
            
            if (notEmpty(selectAllAssignmentsOfACourse(course_id))) {

                for (int i = 0; i < selectAllAssignmentsOfACourse(course_id).size(); i++) {
                    removeAssignmentFromStudents(selectAllAssignmentsOfACourse(course_id).get(i));
                }

                for (int i = 0; i < selectAllAssignmentsOfACourse(course_id).size(); i++) {
                    deleteAnAssignment(selectAllAssignmentsOfACourse(course_id).get(i));
                }
            }

            if (notEmpty(selectAllAssignmentsModelsOfACourse(course_id))) {

                for (int i = 0; i < selectAllAssignmentsModelsOfACourse(course_id).size(); i++) {
                    deleteAnAssignmentsModels(selectAllAssignmentsModelsOfACourse(course_id).get(i));
                }
            }

            if (notEmpty(selectAllStudentsOfACourse(course_id))) {

                for (int i = 0; i < selectAllStudentsOfACourse(course_id).size(); i++) {
                    removeStudentFromCourse(selectAllStudentsOfACourse(course_id).get(i), course_id);
                }
            }

            if (notEmpty(selectAllTrainersOfACourse(course_id))) {

                for (int i = 0; i < selectAllTrainersOfACourse(course_id).size(); i++) {
                    removeTrainerFromCourse(selectAllTrainersOfACourse(course_id).get(i), course_id);
                }
            }

            String q = "DELETE FROM courses\n"
                    + "WHERE course_id =?";
            PreparedStatement pstm = null;
            ResultSet rs = null;

            try {
                pstm = conn.prepareStatement(q);
                pstm.setInt(1, course_id);

                pstm.executeUpdate();
                System.out.println("You successfully deleted the course.");

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
            System.out.println("\n" + "No courses registered." + "\n");
        }
    }

    public static void deleteAllData() {

        deleteAllAssignmentsInStudents();
        deleteAllStudentsInCourses();
        deleteAllTrainersInCourses();
        deleteAllAssignments();
        deleteAllAssignmentsModels();
        deleteAllStudents();
        deleteAllTrainers();
        deleteAllCourses();
    }
}
