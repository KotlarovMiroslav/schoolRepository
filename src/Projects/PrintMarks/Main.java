package PrintMarks;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String text = "[6,6,6]";

        System.out.println(text.substring(1,text.length() - 1));

    }

        public static void printMarks(ArrayList<Integer> studentMarks) {
        if (!studentMarks.isEmpty()) {
        for (int currentMark : studentMarks) {
            System.out.print(currentMark + " ");

        }
    }else{
        System.out.println("The student doesn't have any marks!");
    }
    }
}
