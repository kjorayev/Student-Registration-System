package project.pkg1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project1 {
    
    private static List<Course> courses = new ArrayList<Course>();
    
    private static List<Course> registeredCourses = new ArrayList<Course>();
    
    public static void main(String[] args) throws IOException {
        
        
        
       try {
           
           
            Scanner in = new Scanner(Paths.get("project1input.csv"), "UTF-8");
            
            Course c = null;
            
            while(in.hasNextLine()){
                
                String[] line = (in.nextLine()).split("\t");
               
                
                if(line.length == 11){
                    
                    TraditionalCourse t = new TraditionalCourse(line);
                    courses.add(t);
                }
                else{
                    OnlineCourse t = new OnlineCourse(line);
                    courses.add(t);
                }

               
            }
            
        }
       catch(IOException e){
           System.out.println(e.getMessage());
       }
       
       boolean finished = false;
       
       Scanner userIn = new Scanner(System.in);
       
       System.out.println("1) Search Courses\n"
                         +"2) Register for Course\n"
                         + "3) View Trial Schedule\n"
                         + "4) Quit");
       
       
       
       while(!finished){
           

           
           String youIn = userIn.nextLine();
           
           if(youIn.equals("4")){
               System.out.println("Thanks for using the Student Registration System!");
               finished = true;
               
           }
           if(youIn.equals("1")){
               
               List<Course> coursesFound = new ArrayList<>();
               
               System.out.println("Enter course number in the format SS NNN (for example, CS 201): CS 201");
               
               youIn = userIn.nextLine();
               boolean found = false;
               for(int i = 0; i < courses.size(); i++){
                   String courseN = courses.get(i).getCourseN();
                   
                   if(youIn.equalsIgnoreCase(courseN)){
                       found = true;
                       coursesFound.add(courses.get(i));
                       
                   }                   
               }                   
               if(!found){
                   System.out.println("Course is not found");
               }
               
               for(int i = 0; i < coursesFound.size(); i++) {   
                System.out.println(coursesFound.get(i));}  
           }
           
                if(youIn.equals("2")){
                
                System.out.println("Enter CRN number:");
                
                youIn = userIn.nextLine();
                boolean registerConflict = false;
                
                for(Course tempcourse:courses ){
                    if(tempcourse.getCRN().equals(youIn)){
                        for(Course registeredCourse:registeredCourses){
                            if(tempcourse.ConflictsWith(registeredCourse)){
                                registerConflict = true;
                                
                            }
                        }
                        if(registerConflict == false){
                            registeredCourses.add(tempcourse);
                                System.out.println("Registered Courses");
                                for(Course registeredCourse:registeredCourses){
                                    System.out.println(registeredCourse.toString());

                                }
                        }
                            
                        else
                        {
                            System.out.println("ERROR: Either the course was not found, or it conflicts with your current schedule!");
                        }
                    }
                }
                
            } 
                
            if(youIn.equals("3")){
                
                System.out.println("This is your Trial Schedule");
                
                for(int i = 0; i < registeredCourses.size(); i++){
                System.out.println(registeredCourses.get(i));}
                }
           

       }
    }
    
}
