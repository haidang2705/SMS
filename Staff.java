
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
public abstract class Staff implements PersonalInformation, Serializable{
    private String stName, stID, gender, title, position, number, email, location;
    
    public Staff(String na, String id, String g, String t, String p, String nu, String e, String l){
	title=t;
	stID=id;
	stName=na;
        gender=g;
	email=e;
	number=nu;
	location=l;
        position=p;
    }
	
    public Staff(){
	this("","","","","","","","");
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
     
    public String getTitle(){
	return title;
    }
	
    public void setTitle(String t){
	title=t;
    }
    
    
    public String getEmail(){
	return email;
    }
	
    public void setEmail(String e){
	email=e;
    }
	
    public String getNumber(){
	return number;
    }
	
    public void setNumber(String nu){
	number=nu;
    }
	
    public String getLocation(){
	return location;
    }
	
    public void setLocation(String l){
	location=l;
    }
	
    public String toString(){
	String s="";
	s+=getTitle()+" "+getName()+"\n";
	s+="Staff ID: "+getID()+"\n";
        s+="Gender: "+getGender()+"\n";
	s+="Phone: "+getNumber()+"\n";
        s+="Email: "+getEmail()+"\n";
	s+="Location: "+getLocation()+"\n";
		
	return s;
    }
}
