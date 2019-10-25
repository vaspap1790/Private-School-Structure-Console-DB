package privateschoolstructuredb;

import java.text.ParseException;
import static privateschoolstructuredb.Checker.notEmpty;
import static privateschoolstructuredb.Checker.studentsToSubmit;
import static privateschoolstructuredb.Data.Deletes.*;
import static privateschoolstructuredb.Data.Inserts.*;
import static privateschoolstructuredb.Data.Printers.*;
import static privateschoolstructuredb.Data.Selects.*;
import static privateschoolstructuredb.Edits.*;
import privateschoolstructuredb.Entities.Course;
import static privateschoolstructuredb.Inputs.inputAssignment;
import static privateschoolstructuredb.PrivateSchoolStructureDB.scanner;

public class MenuMethods {

    public static void mainMenu() throws ParseException {

        String x;
        do {
            System.out.println("\n");
            System.out.println("*******************************************************************************************");
            System.out.println(">                                       Main Menu                                         <");
            System.out.println("*******************************************************************************************");
            System.out.println("\n"
                    + "-If you want to enter Trainers Menu, type..............................................'1'-");
            System.out.println("\n"
                    + "-If you want to enter Courses Menu, type...............................................'2'-");
            System.out.println("\n"
                    + "-If you want to enter Students Menu, type..............................................'3'-");
            System.out.println("\n"
                    + "-If you want to enter assignments Menu, type...........................................'4'-");
            System.out.println("\n"
                    + "-If you want skip editing and explore our current structure, type......................'5'-");
            System.out.println("\n"
                    + "-If you want to delete all data in the data base, type ................................'6'-");
            System.out.println("\n"
                    + "-If you want to end the application, type .............................................'0'-");
            System.out.println("\n"
                    + "                                                        ***The console is case sensitive***" + "\n");
            System.out.println("*******************************************************************************************" + "\n");

            x = scanner.nextLine();

            switch (x) {
                case "1":
                    TrainersMenu();
                    break;
                case "2":
                    CoursesMenu();
                    break;
                case "3":
                    StudentsMenu();
                    break;
                case "4":
                    AssignmentsMenu();
                    break;
                case "5":
                    userAction();
                    break;
                case "6":
                    boolean exit = false;
                    String ask;
                    do {
                        System.out.println("\n" + "Are you sure you want to delete all data ? (Yes/No)" + "\n");
                        ask = scanner.nextLine();
                        switch (ask) {
                            case "Yes":
                                deleteAllData();
                                exit = true;
                                break;
                            case "No":
                                System.out.println("\n" + "Action cancelled." + "\n");
                                exit = true;
                                break;
                            default:
                                System.out.println("\n" + "Invalid input. Try again." + "\n");
                                break;
                        }
                    } while (exit == false);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!"0".equals(x));

        System.out.println("\n" + "******************************* You ended the application *********************************");
    }

    public static void userAction() throws ParseException {

        String input;
        do {
            System.out.println("\n");
            System.out.println("*************************************************************************************************");
            System.out.println("**                           Exploring Fantastic School Structure                              **");
            System.out.println("*************************************************************************************************");
            System.out.println("\n");
            System.out.println("-For printing a list of all the students, type...............................................'1'-"
                    + "\n" + "-For printing a list of all the trainers, type...............................................'2'-"
                    + "\n" + "-For printing a list of all the assignments, type............................................'3'-"
                    + "\n" + "-For printing a list of all the courses, type ...............................................'4'-"
                    + "\n" + "-For printing all the students per course, type..............................................'5'-"
                    + "\n" + "-For printing all the trainers per course, type..............................................'6'-"
                    + "\n" + "-For printing all the assignments per course, type...........................................'7'-"
                    + "\n" + "-For printing all the assignments per student per course, type...............................'8'-"
                    + "\n" + "-For printing the list of students that belong to more than one courses, type................'9'-"
                    + "\n" + "-For printing the list of students who need to submit one or more assignments on the same"
                    + "\n" + "calendar week as the date that you give, type...............................................'10'-"
                    + "\n" + "-To return to Main Menu, type...............................................................'0'-"
                    + "\n" + "\n" + "*************************************************************************************************" + "\n");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\n" + "**************************** Students of 'Fantastic Private School' *****************************" + "\n");
                    printArrayList(selectAllS());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    System.out.println("\n" + "**************************** Trainers of 'Fantastic Private School' *****************************" + "\n");
                    printArrayList(selectAllT());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "3":
                    System.out.println("\n" + "************************** Assignments of 'Fantastic Private School' ****************************" + "\n");
                    printArrayList(selectAllAM());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "4":
                    System.out.println("\n" + "**************************** Courses of 'Fantastic Private School' ******************************" + "\n");
                    printArrayList(selectAllC());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    for (int i = 0; i < selectAllC().size(); i++) {
                        printStudentsOfACourse(selectAllC().get(i).getCourse_id());
                    }
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "6":
                    for (int i = 0; i < selectAllC().size(); i++) {
                        printTrainersOfACourse(selectAllC().get(i).getCourse_id());
                    }
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "7":
                    for (int i = 0; i < selectAllC().size(); i++) {
                        printAssignmentsOfACourse(selectAllC().get(i));
                    }
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "8":
                    for (int i = 0; i < selectAllS().size(); i++) {
                        printAssignmentsOfAStudent(selectAllS().get(i).getStudent_id());
                    }
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "9":
                    printStudentsThatBelongToMoreThanOneCourse();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "10":
                    studentsToSubmit();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!"0".equals(input));
    }

    public static void StudentsMenu() throws ParseException {

        String ask;
        do {
            System.out.println("\n" + "************************************* Students Menu ***************************************");
            System.out.println("\n" + "To see the list of the students, type...................................................'1'"
                    + "\n" + "To input a student, type................................................................'2'"
                    + "\n" + "To see the courses of a student, type...................................................'3'"
                    + "\n" + "To see the assignments of a student, type...............................................'4'"
                    + "\n" + "To delete a student, type...............................................................'5'"
                    + "\n" + "To edit student's elements (marks/tuition/courses/assignments/deadlines),type...........'6'"
                    + "\n" + "To delete all students type.............................................................'7'"
                    + "\n" + "To return to Main Menu, type............................................................'0'"
                    + "\n" + "*******************************************************************************************" + "\n");

            ask = scanner.nextLine();

            switch (ask) {
                case "1":
                    System.out.println("\n" + "*********************** Students of 'Fantastic Private School' *************************" + "\n");
                    printArrayList(selectAllS());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    studentToBase();
                    break;
                case "3":
                    printCoursesOfAStudent(printAndPick(selectAllS()).getStudent_id());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "4":
                    printAssignmentsOfAStudent(printAndPick(selectAllS()).getStudent_id());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    deleteAStudent();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "6":
                    System.out.println("\n"
                            + "To set oral mark to a student's assignment type....'1'"
                            + "\n" + "To set total mark to a student's assignment type...'2'"
                            + "\n" + "To edit student's tuition, type....................'3'"
                            + "\n" + "To edit assignment deadline, type..................'4'"
                            + "\n" + "To edit student's first name, type.................'5'"
                            + "\n" + "To edit student's second name, type................'6'"
                            + "\n" + "To edit student's birth date, type.................'7'"
                            + "\n" + "To register a student to a course, type............'8'"
                            + "\n" + "To register a student to an assignment, type.......'9'"
                            + "\n" + "To remove a student from an assignment, type......'10'"
                            + "\n" + "To remove a student from a course, type...........'11'"
                            + "\n" + "If you want to cancel type.........................'0'");

                    String ask2 = scanner.nextLine();

                    switch (ask2) {
                        case "1":
                            editStudentOMark();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "2":
                            editStudentTMark();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "3":
                            editStudentTuition();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "4":
                            editStudentAssignmentSubDateTime();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "5":
                            editStudentFName();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "6":
                            editStudentSName();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "7":
                            editStudentBirthDate();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "8":
                            studentsInCourses();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "9":
                            assignmentsInStudents();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "10":
                            removeAssignmentFromStudent();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "11":
                            removeStudentFromCourse();
                            System.out.println("\n" + "*************************************************************************************************" + "\n");
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "0":
                            break;
                        default:
                            System.out.println("\n" + "Invalid input.Try again." + "\n");
                            break;
                    }
                    break;
                case "7":
                    boolean exit = false;
                    String ask1;
                    do {
                        System.out.println("\n" + "Are you sure you want to delete all students ? (Yes/No)" + "\n");
                        ask1 = scanner.nextLine();
                        switch (ask1) {
                            case "Yes":
                                deleteAllAssignmentsInStudents();
                                deleteAllStudentsInCourses();
                                deleteAllAssignments();
                                deleteAllStudents();
                                exit = true;
                                break;
                            case "No":
                                System.out.println("\n" + "Action cancelled." + "\n");
                                exit = true;
                                break;
                            default:
                                System.out.println("\n" + "Invalid input. Try again." + "\n");
                                break;
                        }
                    } while (exit == false);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("0"));

    }

    public static void TrainersMenu() throws ParseException {

        String ask;
        do {
            System.out.println("\n" + "************************************* Trainers Menu ***************************************");
            System.out.println("\n" + "To see the list of the trainers, type...................................................'1'"
                    + "\n" + "To input a trainer, type................................................................'2'"
                    + "\n" + "To see the courses that a trainer is involved, type.....................................'3'"
                    + "\n" + "To edit a trainer's first name, type....................................................'4'"
                    + "\n" + "To edit a trainer's second name, type...................................................'5'"
                    + "\n" + "To edit a trainer's subject, type.......................................................'6'"
                    + "\n" + "To delete a trainer, type...............................................................'7'"
                    + "\n" + "To add a course to a trainer, type......................................................'8'"
                    + "\n" + "To remove a course from a trainer, type.................................................'9'"
                    + "\n" + "To delete all trainers, type............................................................'10'"
                    + "\n" + "To return to Main Menu, type............................................................'0'"
                    + "\n" + "*******************************************************************************************" + "\n");

            ask = scanner.nextLine();

            switch (ask) {
                case "1":
                    System.out.println("\n" + "*********************** Trainers of 'Fantastic Private School' *************************" + "\n");
                    printArrayList(selectAllT());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    trainerToBase();
                    break;
                case "3":
                    printCoursesOfATrainer(printAndPick(selectAllT()).getTrainer_id());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "4":
                    editTrainerFName();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    editTrainerSName();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "6":
                    editTrainerSubject();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "7":
                    deleteATrainer();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "8":
                    trainersInCourses();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "9":
                    removeTrainerFromCourse();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "10":
                    boolean exit = false;
                    String ask1;
                    do {
                        System.out.println("\n" + "Are you sure you want to delete all trainers ? (Yes/No)" + "\n");
                        ask1 = scanner.nextLine();
                        switch (ask1) {
                            case "Yes":
                                deleteAllTrainersInCourses();
                                deleteAllTrainers();
                                exit = true;
                                break;
                            case "No":
                                System.out.println("\n" + "Action cancelled." + "\n");
                                exit = true;
                                break;
                            default:
                                System.out.println("\n" + "Invalid input. Try again." + "\n");
                                break;
                        }
                    } while (exit == false);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("0"));
    }

    public static void CoursesMenu() throws ParseException {

        String ask;
        do {
            System.out.println("\n" + "************************************** Courses Menu ***************************************");
            System.out.println("\n" + "To see the list of the courses, type....................................................'1'"
                    + "\n" + "To input a course, type.................................................................'2'"
                    + "\n" + "To see the students of a course, type...................................................'3'"
                    + "\n" + "To see the trainers of a course, type...................................................'4'"
                    + "\n" + "To see the assignments of a course, type................................................'5'"
                    + "\n" + "To delete a course, type................................................................'6'(Not available yet)"
                    + "\n" + "To edit course title, type..............................................................'7'"
                    + "\n" + "To delete all courses, type.............................................................'8'"
                    + "\n" + "To return to Main Menu, type............................................................'0'"
                    + "\n" + "*******************************************************************************************" + "\n");

            ask = scanner.nextLine();

            switch (ask) {
                case "1":
                    printArrayList(selectAllC());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "3":
                    printStudentsOfACourse(printAndPick(selectAllC()).getCourse_id());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "4":
                    printTrainersOfACourse(printAndPick(selectAllC()).getCourse_id());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    courseToBase();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    printAssignmentsOfACourse(printAndPick(selectAllC()));
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "6":
                    deleteACourse();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "7":
                    editCourseTitle();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "8":
                    boolean exit = false;
                    String ask1;
                    do {
                        System.out.println("\n" + "Are you sure you want to delete all courses ? (Yes/No)" + "\n");
                        ask1 = scanner.nextLine();
                        switch (ask1) {
                            case "Yes":
                                deleteAllTrainersInCourses();
                                deleteAllStudentsInCourses();
                                deleteAllAssignments();
                                deleteAllAssignmentsModels();
                                deleteAllCourses();
                                exit = true;
                                break;
                            case "No":
                                System.out.println("\n" + "Action cancelled." + "\n");
                                exit = true;
                                break;
                            default:
                                System.out.println("\n" + "Invalid input. Try again." + "\n");
                                break;
                        }
                    } while (exit == false);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("0"));
    }

    public static void AssignmentsMenu() throws ParseException {

        String ask;
        do {
            System.out.println("\n" + "*********************************** Assignments Menu **************************************");
            System.out.println("\n" + "To see the list of the assignment models, type.................................'1'"
                    + "\n" + "To input an assignment model, type......................................................'2'"
                    + "\n" + "To input an assignment to a student, type...............................................'3'"
                    + "\n" + "To change subDateTime of an assignment model, type......................................'4'"
                    + "\n" + "To delete an assignment model, type.....................................................'5'"
                    + "\n" + "To delete all assignment models, type...................................................'6'"
                    + "\n" + "To delete all assignment models, type...................................................'7'"
                    + "\n" + "To return to Main Menu, type............................................................'8'"
                    + "\n" + "*******************************************************************************************");
            System.out.println("\n"
                    + "***By default,each course has four assignment models(Individual-part A and B,Group-part A and B)***" + "\n");

            ask = scanner.nextLine();

            switch (ask) {
                case "1":
                    printArrayList(selectAllAM());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "4":
                    editAssignmentsModelsSubDateTime();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    assignmentsModelsToBase(inputAssignment());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "3":
                    assignmentToBase();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    deleteAnAssignmentsModels(printAndPick(selectAllAM()).getAssignment_id());
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "6":
                    deleteAllAssignmentsModels();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "7":
                    deleteAllAssignmentsInStudents();
                    deleteAllAssignments();
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "8":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("8"));
    }
}
