
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public abstract class Student implements PersonalInformation, Serializable{
    private String stID, stName, gender, course;
    
    public Student(){
        this("","","","");
    }
    
    public Student(String id, String n, String g, String c){
        stID=id;
        stName=n;
        gender=g;
        course=c;
    }

    @Override
    public String getName() {
        return stName;
    }

    @Override
    public String getID() {
        return stID;
    }

    @Override
    public String getGender() {
        return gender;
    }
    
    public String getCourse() {
        return course;
    }

    @Override
    public void setName(String name) {
        stName=name;
    }

    @Override
    public void setID(String id) {
        stID=id;
    }

    @Override
    public void setGender(String gender) {
        this.gender=gender;
    }
    
    public void setCourse(String course){
        this.course=course;
    }
    
    public String toString(){
	String s="";
	s+="Student Name "+getName()+"\n";
	s+="Student ID: "+getID()+"\n";
	s+="Course: "+getCourse()+"\n";
		
	return s;
    }
}
