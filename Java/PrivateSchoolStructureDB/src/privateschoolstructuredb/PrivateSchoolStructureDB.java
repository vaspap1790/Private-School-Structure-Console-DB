package privateschoolstructuredb;

import java.text.ParseException;
import java.util.Scanner;
import privateschoolstructuredb.Data.Datasource;
import static privateschoolstructuredb.MenuMethods.mainMenu;

public class PrivateSchoolStructureDB {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        Datasource datasource = new Datasource();

        if (!datasource.open()) {
            System.out.println("Can't open datasource");
        }

        System.out.println("\n" + "*******************************************************************************************");
        System.out.println("\n" + ">                                       Welcome to                                        <");
        System.out.println("\n" + ">                               -Fantastic Private School-                                <");
        System.out.println("\n" + ">                                        console!                                         <");
        System.out.println("\n" + "*******************************************************************************************" + "\n");

        mainMenu();

        datasource.close();
    }
}
