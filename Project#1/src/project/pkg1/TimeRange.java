package project.pkg1;


public class TimeRange {
    
    public int startHour; 
    public int startMinute;
    public int endHour;
    public int endMinute;
    public String Days;
       
    public TimeRange(String start, String end, String Days){
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        this.Days = Days;
        startHour = Integer.parseInt(startTime[0]);
        startMinute = Integer.parseInt(startTime[1]);
        endHour = Integer.parseInt(endTime[0]);
        endMinute = Integer.parseInt(endTime[1]);
        
    }

    public String getDays() {
        return Days;
    }
  
}
