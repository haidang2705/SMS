
import java.io.Serializable;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Subject implements Cloneable, Serializable{
    private String subCode, subName, session, campus;
    private AcademicStaff coordinator;
    private ArrayList<CourseWorkStudent> enrolledStudent;
    
    public Subject(String cd, String n, String s, String c, AcademicStaff co){
		subCode=cd;
		subName=n;
		session=s;
                campus=c;
		coordinator=co;
                enrolledStudent=new ArrayList<CourseWorkStudent>(0);
    }
    
    public Subject(String cd, String n, String s, String c){
        this(cd,n,s,c,null);
    }
    
    public Subject(){
       this("","","","",null);
    }
    
    public String getCode(){
        return subCode;
    }
	
    public String getName(){
        return subName;
    }
    
    public String getSession(){
        return session;
    }
    
    public String getCampus(){
        return campus;
    }
    
    public AcademicStaff getCoordinator(){
	return coordinator;
    }
	
    public void setCode(String co){
	subCode=co;
    }
	
    public void setName(String na){
        subName=na;
    }
    
    public void setSession(String s){
        session=s;
    }
    
    public void setCampus(String c){
        campus=c;
    }
	
    public void setCoordinator(AcademicStaff c){
	coordinator=c;
    }
        
    public String toString(){
        String s="";
        
        s+="Code: "+subCode+"\n";
	s+="Name: "+subName+"\n";
	s+="Session and Year: "+session+"\n";
        s+="Campus: "+campus+"\n";
	s+="Coordinator: "+coordinator.getName()+"\n";
        s+="Enrolled Students: ";
        
        for(Student st:enrolledStudent)
            s+=st.getName()+", ";
		
        return s;
       
    }
    
    public void enrolStudent(CourseWorkStudent cs){
        if(!enrolledStudent.contains(cs))
            enrolledStudent.add(cs);
    }
    
    /*
    public void enrolStudents(CourseWorkStudent[] css){
        for(CourseWorkStudent cs:css)
            enrolStudent(cs);
    }*/
    
    public void removeStudent(CourseWorkStudent cs){
        if(enrolledStudent.contains(cs))
            enrolledStudent.add(cs);
    }
    
    public Subject clone() throws CloneNotSupportedException{
        Subject clone = (Subject) super.clone();
        clone.enrolledStudent = new ArrayList<CourseWorkStudent>(0);
        
        return clone;
    }
}

