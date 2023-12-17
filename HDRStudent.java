/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class HDRStudent extends Student{
    private AcademicStaff supervisor;
    
    public HDRStudent(){
        this("","","","",null);
    }
    
    public HDRStudent(String id, String n, String g, String c, AcademicStaff s){
        super(id,n,g,c);
        supervisor=s;
    }
    
    public String toString(){
        String s=super.toString();
        
        s+="Supervisor: "+supervisor.getName()+"\n";
        
        return s;
    }
}
