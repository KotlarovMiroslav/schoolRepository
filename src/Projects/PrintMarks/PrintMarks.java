package PrintMarks;

import java.util.ArrayList;

public class PrintMarks {
       ArrayList<Integer> currentMarks;

    public PrintMarks(ArrayList<Integer> currentMarks) {
        this.currentMarks = currentMarks;
    }

    public void printStudentMarks(){
        if (!currentMarks.isEmpty()) {
            for (int currentMark :
                    this.currentMarks) {
                System.out.print(currentMark + " ");
            }
            System.out.println();
        }else{
            System.out.println("The student doesn't have any marks!");
            System.out.println();
        }

    }

}
