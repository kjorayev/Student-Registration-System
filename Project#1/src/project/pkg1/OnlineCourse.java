package project.pkg1;

public class OnlineCourse extends Course {
    
    public OnlineCourse(String[] line){
        
        super(line);
    
    }

    @Override
    public boolean ConflictsWith(Course otherCourse) {
        return false;
    }
    
}
