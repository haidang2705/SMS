
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class CourseWorkStudent extends Student{
    private ArrayList<Subject> enrolledSubjects;
    
    public CourseWorkStudent(){
        this("","","",""); 
    }
    
    public CourseWorkStudent(String id, String n, String g, String c){
        super(id,n,g,c);
        enrolledSubjects=new ArrayList<Subject>(0);
    }
    
    public void enrolSubject(Subject s){
        if(!enrolledSubjects.contains(s))
            enrolledSubjects.add(s);
    }
    
    public void withdrawSubject(Subject s){
        if(enrolledSubjects.contains(s))
            enrolledSubjects.remove(s);
    }
    
    public String toString(){
        String s=super.toString();;
        
        s+="Enrolled Subjects: ";
        
        for(Subject sub:enrolledSubjects)
            s+=sub.getCode()+", ";
        
        return s;
    }
}
