package Projects.WorkersProject;

import java.util.ArrayList;

public class PrintWorkers {
    public PrintWorkers(ArrayList<Worker> list){
        for (Worker curWorker:
             list) {
            System.out.println("==================");
            System.out.println(curWorker.getName());
            System.out.println(curWorker.getWork());
            System.out.println("==================");
        }
    }
}
