package project.pkg1;

public abstract class Course {
    
    private String line[];
    private String name;
    private String CRN;
    private String courseN;
    private String sec;
    private String hourCredit;
    public TimeRange range;
    public Course(String[] line){
        
        name = line[0];
        CRN = line[1];
        courseN = line[2];
        sec = line[3];
        hourCredit = line[4];
        this.line = line;
        
    }
    
    public String getName(){
        return name;
    }

    public String getCRN(){
        return CRN;
    }
    
    public String getCourseN(){
        return courseN;
    }
    
    public String getSec(){
        return sec;
    }
    
    public String getHourCredit(){
        return hourCredit;
    }  

    @Override
    public String toString(){
        
        String s = "";
        for(int i = 0; i < line.length; i++){
            
            s += (line[i]+ " ");
        }
            
            
        return s;
    }
    public abstract boolean ConflictsWith(Course otherCourse);
}
