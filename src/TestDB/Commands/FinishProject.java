package TestDB.Commands;

import TestDB.JDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class FinishProject {
    static Scanner scan = new Scanner(System.in);

    public static void finishProject() throws SQLException {
        System.out.print("Enter ID of project that you think is finished: ");
        int input = Integer.parseInt(scan.nextLine());
        while (!checkIfProjectExists(input)) {
            System.out.print("Enter ID of project that you think is finished: ");
            input = Integer.parseInt(scan.nextLine());
        }
        addProjectToTheFinishedTable(input);
        deleteOldProject(input);

    }

    public static void addProjectToTheFinishedTable(int projectID) throws SQLException {
        JDBC jdbcFindProject = new JDBC("select * from projectj.projects", "select * from projectj.projects");

        int currentProjectID;
        String projectName;
        String projectDesc;
        String projectFin;

        while (jdbcFindProject.resultSet.next()) {
            currentProjectID = jdbcFindProject.resultSet.getInt("id");
            if (currentProjectID == projectID) {
                projectName = jdbcFindProject.resultSet.getString("project_name");
                projectDesc = jdbcFindProject.resultSet.getString("project_description");
                projectFin = jdbcFindProject.resultSet.getString("financed_by");
                addProjectInFinishedTable(projectName, projectDesc, projectFin);
                break;
            }
        }
    }

    public static boolean checkIfProjectExists(int projectID) throws SQLException {
        JDBC jdbcCheckProject = new JDBC("select * from projectj.projects", "select p.id from projectj.projects p");
        int currentProjectId;

        while (jdbcCheckProject.resultSet.next()) {
            currentProjectId = jdbcCheckProject.resultSet.getInt("id");
            if (currentProjectId == projectID) {
                return true;
            }
        }
        System.out.println("The project does not exist!");
        return false;
    }

    public static void addProjectInFinishedTable(String name, String desc, String financedBy) throws SQLException {
        JDBC jdbcAddProjectInFinished = new JDBC("select * from projectj.finishedprojects", "insert into projectj.finishedprojects(project_name, description, financed_by) VALUES (?,?,?)");
        jdbcAddProjectInFinished.writeData.setString(1, name);
        jdbcAddProjectInFinished.writeData.setString(2, desc);
        jdbcAddProjectInFinished.writeData.setString(3, financedBy);
        jdbcAddProjectInFinished.writeData.executeUpdate();
    }

    public static void deleteOldProject(int projectID) throws SQLException {
        JDBC jdbcReleaseWorkers = new JDBC("select * from projectj.assignedto", "DELETE from projectj.assignedto WHERE projectj.assignedto.projectid = " + projectID);
        jdbcReleaseWorkers.writeData.executeUpdate();


        JDBC jdbcDeleteOldProject = new JDBC("select * from projectj.projects", "DELETE from projectj.projects WHERE id = " + projectID);
        jdbcDeleteOldProject.writeData.executeUpdate();
    }


}
