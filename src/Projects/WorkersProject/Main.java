package Projects.WorkersProject;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //DATABASE
        Scanner scan = new Scanner(System.in);
        EditFile currentFile = new EditFile("Workers");
        System.out.println("Welcome to the director's mode!");
        while (true) {
            System.out.println("Choose option:");
            System.out.println("[1] Add worker");
            System.out.println("[2] Show workers");
            System.out.println("[3] Add new Project");
            System.out.println("[4] Finish Project");
            System.out.println("[5] Exit Program");
            int answer = Integer.parseInt(scan.nextLine());
            switch (answer) {
                case 1:


                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
                case 5:
                    System.out.println("Thank you for using our application!");
                    return;
            }
        }
    }
}
