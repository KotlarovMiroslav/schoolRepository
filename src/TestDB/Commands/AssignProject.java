package TestDB.Commands;

import TestDB.JDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class AssignProject {

    public static void assignProject() throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("AVAILABLE WORKERS(NAME AND ID): ");
        JDBC jdbcPrintWorkers = new JDBC("select * from workers", "select * from projectj.workers");
        if(!jdbcPrintWorkers.resultSet.next()){
            System.out.println("There are no workers!");
            return;
        }
        jdbcPrintWorkers = new JDBC("select * from workers", "select * from projectj.workers");
        System.out.println("----------------------------------------------------");
        while (jdbcPrintWorkers.resultSet.next()) {
            System.out.println("\nName: " + jdbcPrintWorkers.resultSet.getString("worker_name"));
            System.out.print("[ID: " + jdbcPrintWorkers.resultSet.getString("id") + "]" + "\n");
        }
        System.out.println("----------------------------------------------------");

        System.out.println("AVAILABLE PROJECTS(PROJECT NAME AND ID): ");

        JDBC jdbcPrintProjects = new JDBC("select * from projects", "select * from projectj.projects");
        if (!jdbcPrintProjects.resultSet.next()) {
            System.out.println("There are no projects!");
            return;
        }

        jdbcPrintProjects = new JDBC("select * from projects", "select * from projectj.projects");
        System.out.println("----------------------------------------------------");
        while (jdbcPrintProjects.resultSet.next()) {
            System.out.println("\nProject name: " + jdbcPrintProjects.resultSet.getString("project_name"));
            System.out.print("[ID: " + jdbcPrintProjects.resultSet.getInt("id") + "]" + "\n");
        }
        System.out.println("----------------------------------------------------");

        System.out.print("Enter ID of worker:");
        int workerID = Integer.parseInt(scan.nextLine());
        while(!checkIfWorkerExists(workerID)){
            System.out.print("Enter ID of worker:");
            workerID = Integer.parseInt(scan.nextLine());
        }
        System.out.print("Enter ID of project:");
        int projectID = Integer.parseInt(scan.nextLine());
        while(!checkIfProjectExists(projectID)){
            System.out.print("Enter ID of project:");
            projectID = Integer.parseInt(scan.nextLine());
        }
        if(checkIfAlreadyAtWork(workerID , projectID)) {
            JDBC jdbcAssignProject = new JDBC("select * from projectj.assignedTo", "insert into assignedTo(projectid, employeeID) VALUES (?,?)");
            jdbcAssignProject.writeData.setInt(2, workerID);
            jdbcAssignProject.writeData.setInt(1, projectID);
            jdbcAssignProject.writeData.executeUpdate();
        }

    }

    public static boolean checkIfAlreadyAtWork(int workerID, int projectID) throws SQLException {
        JDBC jdbcAssignedWorkers = new JDBC("select * from projectj.assignedTo", "select * from projectj.assignedTo");
        int currentWorkerId;
        int currentProjectId;
        while (jdbcAssignedWorkers.resultSet.next()) {
            currentWorkerId = jdbcAssignedWorkers.resultSet.getInt("employeeID");
            currentProjectId = jdbcAssignedWorkers.resultSet.getInt("projectid");
            if (workerID == currentWorkerId && projectID == currentProjectId) {
                System.out.println("The job is already assigned to that worker!");
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfWorkerExists(int workerID) throws SQLException {
        JDBC jdbcCheckWorker = new JDBC("select * from projectj.workers", "select w.id from projectj.workers w");
        int currentWorkerId;

        while (jdbcCheckWorker.resultSet.next()) {
            currentWorkerId = jdbcCheckWorker.resultSet.getInt("id");
            if(currentWorkerId == workerID) {
                return true;
            }
        }
        System.out.println("The worker does not exist!");
        return false;
    }

    public static boolean checkIfProjectExists(int projectID) throws SQLException {
        JDBC jdbcCheckProject = new JDBC("select * from projectj.projects", "select p.id from projectj.projects p");
        int currentProjectId;

        while (jdbcCheckProject.resultSet.next()) {
            currentProjectId = jdbcCheckProject.resultSet.getInt("id");
            if(currentProjectId == projectID) {
                return true;
            }
        }
        System.out.println("The project does not exist!");
        return false;
    }
}
