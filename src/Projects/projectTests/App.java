package projectTests;

import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose option:");
        System.out.println("(1)Change class");
        System.out.println("(2)Exit program");
        String option = scan.nextLine();
        if(option.equals("1")) {
            System.out.println("Choose class(181,182): ");
            String classNumber = scan.nextLine();
            while (!classNumber.equals("stop")) {

                FileExampleClass classInfo = new FileExampleClass("C://Users//Miro//IdeaProjects//testProject//src//projectTests//" + classNumber + ".txt");

                System.out.println("Choose class(181,182): ");
                classNumber = scan.nextLine();

            }

            System.out.println("Have a nice day! And thank you for using our platform!");
        }else if(option.equals("2")){
            return;
        }else{
            System.out.println("Wrong input!");
        }

    }
}
