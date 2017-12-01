package project.pkg1;


public class TraditionalCourse extends Course {
    
    private TimeRange range;
    private String[] line;
           
    
    public TraditionalCourse(String[] line){
        
        super(line);
        
        
        this.line = line;
        range = new TimeRange(line[5],line[6], line[7]);
        
    }
   
    public String getType(){
        return "Traditional";
        
    }
    
    
    @Override
    public boolean ConflictsWith(Course otherCourse){
        
        
        
        if(otherCourse instanceof OnlineCourse || otherCourse == null){
            
            return false;
        }
        
        boolean Conflicts = false;
        TraditionalCourse other = (TraditionalCourse)otherCourse;       
        
        if(this.range.startHour >= other.range.startHour){
            if(this.range.startHour < other.range.endHour){
                if((this.range.Days.charAt(0)) ==(other.range.Days.charAt(0))){
                        Conflicts = false;
                
                }
                
            }
        }    
            if(this.range.startHour == other.range.endHour){
                if(this.range.startMinute <= other.range.endMinute){
                    if((this.range.Days.charAt(0)) ==(other.range.Days.charAt(0))){
                        Conflicts = true;
                }
                
            }
        }
        if(this.range.endHour >= other.range.startHour){
            if(this.range.startHour <= other.range.startHour){
                if(this.range.startMinute >= other.range.startMinute){
                    if((this.range.Days.charAt(0)) ==(other.range.Days.charAt(0))){
                           Conflicts = true;
                    }
                    
                }
            }
        }  
        
        if(this.range.startHour == other.range.startHour){
            if(this.range.endHour == other.range.endHour){
                if((this.range.Days.charAt(0)) ==(other.range.Days.charAt(0))){
        
                Conflicts = true;
                }
            }
        }    
        return Conflicts;
    }
    
}
    
