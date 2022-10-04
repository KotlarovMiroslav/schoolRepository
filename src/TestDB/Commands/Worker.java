package TestDB.Commands;

import TestDB.JDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class Worker {
    static Scanner scan = new Scanner(System.in);

    public static void newWorker() throws SQLException {
        System.out.println("What is the name of the worker?(Name and family name)");
        String name = scan.nextLine();


        System.out.println("What will he be working as?");
        String worksAs = scan.nextLine();


        System.out.println("What is his salary going to be?");
        int salary = Integer.parseInt(scan.nextLine());


        System.out.println("How much is his internship?");
        int years = Integer.parseInt(scan.nextLine());



        JDBC jdbcAddNewEmp = new JDBC("select * from workers", "insert into workers(worker_name, works_as, salary, internship) VALUES (?,?,?,?)");
        jdbcAddNewEmp.writeData.setString(1, name);
        jdbcAddNewEmp.writeData.setString(2, worksAs);
        jdbcAddNewEmp.writeData.setInt(3, salary);
        jdbcAddNewEmp.writeData.setInt(4, years);
        jdbcAddNewEmp.writeData.executeUpdate();
    }

    public static void deleteWorker() throws SQLException {

        System.out.println("Enter id of the worker you would like to remove!");
        int id = Integer.parseInt(scan.nextLine());
        JDBC jdbcDeleteEmp = new JDBC("select * from workers", "DELETE from workers WHERE id = "+ id);
        jdbcDeleteEmp.writeData.executeUpdate();

    }


    public static void printWorkers() throws SQLException{

        //      ALTERNATIVE WAY!!!!
        JDBC jdbcPrintWorkers = new JDBC("select * from workers", "select * from projectj.workers");
        if(!jdbcPrintWorkers.resultSet.next()){
            System.out.println("There are no workers!");
            return;
        }
        jdbcPrintWorkers = new JDBC("select * from workers", "select * from projectj.workers");
        System.out.println("----------------------------------------------------");
        while (jdbcPrintWorkers.resultSet.next()) {
            System.out.println("\nName: " + jdbcPrintWorkers.resultSet.getString("worker_name"));
            System.out.print("[ID: " + jdbcPrintWorkers.resultSet.getString("id") + "]");
            System.out.print(", Working as: " + jdbcPrintWorkers.resultSet.getString("works_as"));
            System.out.print(", Salary: " + jdbcPrintWorkers.resultSet.getString("salary"));
            System.out.println(", Internship: " + jdbcPrintWorkers.resultSet.getString("internship") + "\n");
        }
        System.out.println("----------------------------------------------------");



        //OLD WAY:


//        final String jdbcURL = "jdbc:mysql://localhost:3306/projectj";
//        final String jdbcUser = "root";
//        final String jdbcPassword = "";
//        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
//        Statement readData = connection.createStatement();
//        ResultSet rs = readData.executeQuery("SELECT * FROM projectj.workers");
//        System.out.println("----------------------------------------------------");
//        while (rs.next()){
//
//            System.out.println("Name: " + rs.getString("worker_name"));
//            System.out.print("ID: " + rs.getString("id"));
//            System.out.print(", Working as: " + rs.getString("works_as"));
//            System.out.print(", Salary: " + rs.getInt("salary"));
//            System.out.println(", Internship: " + rs.getInt("internship") +"\n");
//
//        }
//        System.out.println("----------------------------------------------------");
    }
}
