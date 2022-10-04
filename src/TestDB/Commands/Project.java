package TestDB.Commands;

import TestDB.JDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class Project {

    public static void addProject() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a name for the project:");
        String projectName = scan.nextLine();
        System.out.print("What is your project going to be about:");
        String description = scan.nextLine();
        System.out.print("Who finances your project:");
        String financedBy = scan.nextLine();

        JDBC jdbcAddProject = new JDBC("select * from projects","insert into projects(project_name, project_description, financed_by) VALUES (?,?,?)");
        jdbcAddProject.writeData.setString(1, projectName);
        jdbcAddProject.writeData.setString(2, description);
        jdbcAddProject.writeData.setString(3, financedBy);
        jdbcAddProject.writeData.executeUpdate();


    }
    public static void printProjects() throws SQLException {
        JDBC jdbcPrintProjects = new JDBC("select * from projects", "select * from projectj.projects");
        if (!jdbcPrintProjects.resultSet.next()) {
            System.out.println("There are no projects!");
            return;
        }
        jdbcPrintProjects = new JDBC("select * from projects", "select * from projectj.projects");
        System.out.println("----------------------------------------------------");
        while (jdbcPrintProjects.resultSet.next()) {
            System.out.println("\nProject name: " + jdbcPrintProjects.resultSet.getString("project_name"));
            System.out.print("[ID: " + jdbcPrintProjects.resultSet.getInt("id") + "]");
            System.out.println(", Financed by: " + jdbcPrintProjects.resultSet.getString("financed_by"));
            System.out.print("Project description: " + jdbcPrintProjects.resultSet.getString("project_description") + "\n");
        }
        System.out.println("----------------------------------------------------");
    }
}
