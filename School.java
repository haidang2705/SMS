
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
public class School implements Serializable{
	
    private String sName;
    private AcademicStaff hos;
    private ProfessionalStaff manager;
    private ArrayList<Staff> staffList;
    private ArrayList<Subject> subjectList;
    private ArrayList<Student> studentList;
	
	public School(String n, AcademicStaff h, ProfessionalStaff m){
		sName=n;
		hos=h;
		manager=m;
                staffList=new ArrayList<Staff>(0);
		staffList.add(hos);
		staffList.add(manager);
                subjectList=new ArrayList<Subject>(0);
                studentList=new ArrayList<Student>(0);
	}
	
	public School(){
		this("",null,null);
	}
	
	public String getName(){
		return sName;
	}
	
	public AcademicStaff getHoS(){
		return hos;
	}
	
	public ProfessionalStaff getManager(){
		return manager;
	}
	
	public void setName(String n){
		sName=n;
	}
	
	public void setHoS(AcademicStaff h){
		hos=h;
	}
	
	public void setManager(ProfessionalStaff m){
		manager=m;
	}
	
	public void addStaff(Staff s){
		if(!staffList.contains(s))
			staffList.add(s);
	}
	
	public void removeStaff(String id){	
            for(Staff s:staffList){
                if (s.getID().equals(id)){
                    staffList.remove(s);
		}
            }
	}
	
	public void addSubject(Subject s){
		if(!subjectList.contains(s))
			subjectList.add(s);
	}
	
	public void removeSubject(String c){
            for(Subject s:subjectList){
                if(s.getCode().equals(c)){
                    subjectList.remove(s);
                    break;
                }
            }
	}
        
        public void addStudent(Student s){
		if(!studentList.contains(s))
			studentList.add(s);
	}
	
	public void removeStudent(Student s){
            if(studentList.contains(s)){
                studentList.remove(s);
            }
            
	}
	
        public ArrayList<Staff> getStaffList(){
            return staffList;
        }
        
        public ArrayList<Subject> getSubjectList(){
            return subjectList;
        }
        
        public ArrayList<Student> getStudentList(){
            return studentList;
        }
        
        public String showSchoolStaff(){
            String s="";
            
            if(!staffList.isEmpty()){
                    s+="School Staff List: "+"\n";
		
                    for(Staff st: staffList)
			s+="\n"+st;
            }
                
            return s;
        }
        
        public String showSchoolSubject(){
            String s="";
            
            if(!subjectList.isEmpty()){
                    s+="\n"+ "School Subject List: "+"\n";
		
                    for (Subject su: subjectList){
			s+="\n"+su+"\n";
                    }
            }
                
            return s;
        }
        
        public String showSchoolStudent(){
            String s="";
            
            if(!studentList.isEmpty()){
                    s+="\n"+ "School Student List: "+"\n";
                
                    for (Student st: studentList){
			s+="\n"+st+"\n";
                    }
            }
                
            return s;
        }
        
	public String toString(){
		String s="";
		
		s+="School Name: "+sName+"\n";
		s+="Head of School: "+hos.getTitle()+" "+hos.getName()+"\n";
		s+="School Manager: "+manager.getTitle()+" "+manager.getName()+"\n";
                
                if(!staffList.isEmpty()){
                    s+="Staff List: "+"\n";
		
                    for(Staff st: staffList)
			s+="\n"+st;
                }
                
                if(!subjectList.isEmpty()){
                    s+="\n"+ "School Subject List: "+"\n";
		
                    for (Subject su: subjectList){
			s+="\n"+su+"\n";
                    }
                }
                
                if(!studentList.isEmpty()){
                    s+="\n"+ "School Student List: "+"\n";
                
                    for (Student st: studentList){
			s+="\n"+st+"\n";
                    }
                }
		
		return s;
	}
}
