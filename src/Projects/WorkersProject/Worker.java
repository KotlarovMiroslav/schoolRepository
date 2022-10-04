package Projects.WorkersProject;

public class Worker {
    String name;
    String id;
    String workingAs;


    public Worker(String name,  String id, String workingAs) {
        this.name = name;
        this.id = id;
        this.workingAs = workingAs;

    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getWork(){
        return this.workingAs;
    }




}
