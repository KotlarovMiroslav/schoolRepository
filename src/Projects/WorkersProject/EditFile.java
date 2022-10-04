package Projects.WorkersProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EditFile implements Serializable {
    Scanner scan = new Scanner(System.in);
    private String fileName;
    private File info;
    ArrayList<Worker> workers;

    public EditFile(String fileName){
        this.fileName = fileName;
        this.info = new File(fileName + ".bin");
        this.workers = EditFile();
    }

    public ArrayList<Worker> EditFile(){
        try {
            if (this.info.createNewFile()) {
                return new ArrayList<Worker>();
            } else if (this.info.length() != 0) {
                try {
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(this.info.getName()));
                    ArrayList<Worker> students = (ArrayList<Worker>) is.readObject();
                    is.close();
                    return students;
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("The program will not work properly");
                    return new ArrayList<Worker>();
                }
            } else {
                return new ArrayList<Worker>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("The program will not work properly");
            return new ArrayList<Worker>();
        }
    }

    public void AddWorker(){
        System.out.print("How many workers do you want to add: ");
        int answer = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < answer; i++) {
            System.out.printf("\nStudent <%d>: \n", i + 1);
            System.out.print("Enter name: ");
            String name = scan.nextLine();
            System.out.println("Enter ID:");
            String id = scan.nextLine();
            System.out.print("Job: ");
            String job = scan.nextLine();
            while (true) {
                if (!checkValidId(id)) {
                    break;
                } else {
                    System.out.println("This worker already exists!");
                    System.out.print("Enter new worker Id: ");
                    id = scan.nextLine();
                }
            }
            Worker newWorker = new Worker(name, id, job);
            this.workers.add(newWorker);
        }

    }

    public boolean checkValidId(String workerId) {
        if (workers.isEmpty()) {
            return false;
        }
        for (Worker curWorker : workers) {
            if (workerId.equals(curWorker.getId())) {
                return true;
            }
        }
        return false;
    }

}
