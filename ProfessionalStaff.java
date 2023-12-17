/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class ProfessionalStaff extends Staff{
    private String workingHours;
    
    
    public ProfessionalStaff(String na, String id, String g, String t, String p, String nu, String e, String l, String wh){
        super(na,id,g,t,p,nu,e,l);
        workingHours=wh;
    }
    
    public ProfessionalStaff(){
        this("","","","","","","","","");
    }
    
    public String getWorkingHours(){
        return workingHours;
    }
    
    public void setWorkingHours(String wh){
        workingHours=wh;
    }
    
    public String toString(){
        
	String s=super.toString();

	s+="Working Hours: "+getWorkingHours()+"\n";
		
	return s;
    }
}
