package TestDB;

import TestDB.Commands.*;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the admin panel");
        System.out.print("Choose option:\n[1]Add a new worker\n[2]Remove worker\n[3]Print workers\n[4]Exit\n");
        System.out.print("[5]Create Project\n[6]Print Project\n[7]Assign Project\n[8]Finish Project\n[9]Show which worker on what project is working\n");
        int input = Integer.parseInt(scan.nextLine());
        while(input != 4) {

            if (input == 1) {
                Worker.newWorker();
            } else if (input == 2) {
                Worker.deleteWorker();
            } else if (input == 3) {
                Worker.printWorkers();
            } else if (input == 5) {
                Project.addProject();
            }else if (input == 6) {
                Project.printProjects();
            }else if (input == 7) {
                AssignProject.assignProject();
            }else if (input == 8){
                FinishProject.finishProject();
            }else if (input == 9){
                ShowAssignedPeople.showAssignedPeopleOnJobs();
            }

            System.out.print("Choose option:\n[1]Add a new worker\n[2]Remove worker\n[3]Print workers\n[4]Exit\n");
            System.out.print("[5]Create Project\n[6]Print Project\n[7]Assign Project\n[8]Finish Project\n[9]Show which worker on what project is working\n");
            input = Integer.parseInt(scan.nextLine());
        }






    }
}
