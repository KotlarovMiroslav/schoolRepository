package TestDB.Commands;

import TestDB.JDBC;

import java.sql.SQLException;

public class ShowAssignedPeople {
    public static void showAssignedPeopleOnJobs() throws SQLException {
        JDBC showProjectsAndPeople = new JDBC("select * from projectj.assignedto","select * from projectj.assignedto");
        JDBC showProject = new JDBC("select * from projectj.projects","select * from projectj.projects");
        JDBC showWorker = new JDBC("select * from projectj.workers","select * from projectj.workers");
        int currentProjectID;
        int currentWorkerID;
        System.out.println("----------JOBS ASSIGNED TO WORKERS----------");
        while(showProjectsAndPeople.resultSet.next()){
            currentProjectID = showProjectsAndPeople.resultSet.getInt("projectid");
            currentWorkerID = showProjectsAndPeople.resultSet.getInt("employeeID");

            while(showProject.resultSet.next()){
                if(currentProjectID == showProject.resultSet.getInt("id")){
                    System.out.println();
                    System.out.print("[" + showProject.resultSet.getString("project_name") + "]");
                    System.out.print(" assigned to worker ");
                    while(showWorker.resultSet.next()){
                        if(currentWorkerID == showWorker.resultSet.getInt("id")){
                            System.out.print(showWorker.resultSet.getString("worker_name") + "\n");
                        }
                    }
                    System.out.println();
                }
            }
            showProject = new JDBC("select * from projectj.projects","select * from projectj.projects");
            showWorker = new JDBC("select * from projectj.workers","select * from projectj.workers");

        }
        System.out.println("--------------------------------------------");
    }
}
