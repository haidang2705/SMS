
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class SchoolManagementSystem {
    public static void main(String[] args) throws CloneNotSupportedException{
        
        System.out.println("Welcome to the School of Computer Science.\n");
        
        
        School CSSchool=null;
        /*
        //1 hos and 1 manager
        AcademicStaff david = new AcademicStaff("David", "100001", "Male", "Professor", "Head of School", "4221-1111", 
                "david@university.edu.au", "3.001");
        ProfessionalStaff cindy = new ProfessionalStaff("Cindy", "100002", "Female", "Miss", "4221-1112", "cindy@university.edu.au", 
                "3.002", "Monday ~ Thursday", "School Manager");*/
        
        
        
        //System.out.println(CSSchool);
        
        boolean loop = true;
        
        while(loop){
            System.out.println("\nPlease make a select from the following items");
            
            System.out.println("1: initialise the school");
            System.out.println("2: add a staff");
            System.out.println("3: add a subject");
            System.out.println("4: add a student");
            System.out.println("5: display the school staff");
            System.out.println("6: display the school subjects");
            System.out.println("7: display the school students");
            System.out.println("8: export the school information");
            System.out.println("9: exist the system");
            
            Scanner input = new Scanner(System.in);
        
            int item = input.nextInt();
            
            input.nextLine();
            
            switch(item){
                case 1:
                    
                    //initalise the school with the csschool.ser

                    try{
                        ObjectInputStream objInput = new ObjectInputStream(Files.newInputStream(Paths.get("csschool.ser")));
            
                        CSSchool = (School) objInput.readObject();
                   
                    }catch(IOException | ClassNotFoundException ie){
                        System.err.println(ie);
                        System.exit(1);
                    }
                    
                    /*
                    //add 6 academic staff
                    AcademicStaff liam = new AcademicStaff("Liam", "100003", "Male", "Dr.", "Lecturer", "4221-1113", 
                "liam@university.edu.au", "3.003");
                    AcademicStaff noah = new AcademicStaff("Noah", "100004", "Male", "Dr.", "Lecturer", "4221-1114", 
                "noah@university.edu.au", "3.004");
                    AcademicStaff william = new AcademicStaff("William", "100005", "Male", "Dr.", "Lecturer", "4221-1115", 
                "william@university.edu.au", "3.005");
                    AcademicStaff emma = new AcademicStaff("Emma", "100006", "Female", "Dr.", "Lecturer", "4221-1116", 
                "emma@university.edu.au", "3.006");
                    AcademicStaff ava = new AcademicStaff("Ava", "100007", "Female", "Dr.", "Lecturer", "4221-1117", 
                "ava@university.edu.au", "3.007");
                    AcademicStaff mia = new AcademicStaff("Mia", "100008", "Female", "Dr.", "Lecturer", "4221-1118", 
                "mia@university.edu.au", "3.008");
                   
                    CSSchool.addStaff(liam);
                    CSSchool.addStaff(noah);
                    CSSchool.addStaff(william);
                    CSSchool.addStaff(emma);
                    CSSchool.addStaff(ava);
                    CSSchool.addStaff(mia);
                    
                    
                    //add 13 subjects
                    Subject CSIT111 = new Subject("CSIT111", "Programming Fundamentals", "Autumn 2021", "Wollongong", liam);
                    Subject CSIT111SWS = CSIT111.clone();
                    CSIT111SWS.setCampus("SWS");
                    CSIT111SWS.setCode("CSIT111SWS");
                    liam.addTeachingSubject(CSIT111);
                    liam.addTeachingSubject(CSIT111SWS);
                    
                    Subject CSIT113 = new Subject("CSIT113", "Problem Solving", "Autumn 2021", "Wollongong", noah);
                    Subject CSIT113SWS = CSIT113.clone();
                    CSIT113SWS.setCampus("SWS");
                    CSIT113SWS.setCode("CSIT113SWS");
                    noah.addTeachingSubject(CSIT113);
                    noah.addTeachingSubject(CSIT113SWS);
                    
                    Subject CSIT114 = new Subject("CSIT114", "System Analysis", "Autumn 2021", "Wollongong", william);
                    Subject CSIT114SWS = CSIT114.clone();
                    CSIT114SWS.setCampus("SWS");
                    CSIT114SWS.setCode("CSIT114SWS");
                    william.addTeachingSubject(CSIT114);
                    william.addTeachingSubject(CSIT114SWS);
                    
                    Subject CSIT115 = new Subject("CSIT115", "Data Management and Security", "Autumn 2021", "Wollongong", emma);
                    emma.addTeachingSubject(CSIT115);
                    
                    Subject CSIT121 = new Subject("CSIT121", "Object Oriented Design and Programming", "Autumn 2021", "Wollongong", ava);
                    ava.addTeachingSubject(CSIT121);
                    
                    Subject CSIT127 = new Subject("CSIT127", "Networks and Communications", "Autumn 2021", "Wollongong", mia);
                    mia.addTeachingSubject(CSIT127);
                    
                    Subject CSIT128 = new Subject("CSIT128", "Introduction to Web Technology", "Autumn 2021", "Wollongong", mia);
                    mia.addTeachingSubject(CSIT128);
                    
                    Subject CSCI235 = new Subject("CSCI235", "Database Systems", "Autumn 2021", "Wollongong", emma);
                    emma.addTeachingSubject(CSCI235);
                    
                    Subject CSCI251 = new Subject("CSCI251", "Advanced Programming", "Autumn 2021", "Wollongong", ava);
                    ava.addTeachingSubject(CSCI251);
                    
                    Subject CSIT214 = new Subject("CSIT214", "IT Project Management", "Autumn 2021", "Wollongong", david);
                    
                    CSSchool.addSubject(CSIT111);
                    CSSchool.addSubject(CSIT113);
                    CSSchool.addSubject(CSIT114);
                    CSSchool.addSubject(CSIT111SWS);
                    CSSchool.addSubject(CSIT113SWS);
                    CSSchool.addSubject(CSIT114SWS);
                    CSSchool.addSubject(CSIT115);
                    CSSchool.addSubject(CSIT121);
                    CSSchool.addSubject(CSIT127);
                    CSSchool.addSubject(CSIT128);
                    CSSchool.addSubject(CSIT214);
                    CSSchool.addSubject(CSCI235);
                    CSSchool.addSubject(CSCI251);

                    //add 13 coursework students
                    CourseWorkStudent st1=new CourseWorkStudent("1234501", "Isabella", "Female", "BCS");
                    st1.enrolSubject(CSIT111);
                    CSIT111.enrolStudent(st1);
                    
                    CourseWorkStudent st2=new CourseWorkStudent("1234502", "James", "Male", "BCS");
                    st2.enrolSubject(CSIT111SWS);
                    CSIT111SWS.enrolStudent(st2);
                    
                    CourseWorkStudent st3=new CourseWorkStudent("1234503", "Sophia", "Female", "BCS");
                    st3.enrolSubject(CSIT113);
                    CSIT113.enrolStudent(st3);
                    
                    CourseWorkStudent st4=new CourseWorkStudent("1234504", "Logan", "Male", "BCS");
                    st4.enrolSubject(CSIT113SWS);
                    CSIT113SWS.enrolStudent(st4);
                    
                    CourseWorkStudent st5=new CourseWorkStudent("1234505", "Charlotte", "Female", "BCS");
                    st5.enrolSubject(CSIT114);
                    CSIT114.enrolStudent(st5);
                    
                    CourseWorkStudent st6=new CourseWorkStudent("1234506", "Benjamin", "Male", "BCS");
                    st6.enrolSubject(CSIT114SWS);
                    CSIT114SWS.enrolStudent(st6);
                    
                    CourseWorkStudent st7=new CourseWorkStudent("1234507", "Amelia", "Female", "BCS");
                    st7.enrolSubject(CSIT115);
                    CSIT115.enrolStudent(st7);
                    
                    CourseWorkStudent st8=new CourseWorkStudent("1234508", "Mason", "Male", "BCS");
                    st8.enrolSubject(CSIT121);
                    CSIT121.enrolStudent(st8);
                    
                    CourseWorkStudent st9=new CourseWorkStudent("1234509", "Evelyn", "Female", "BCS");
                    st9.enrolSubject(CSIT127);
                    CSIT127.enrolStudent(st9);
                    
                    CourseWorkStudent st10=new CourseWorkStudent("1234510", "Elijah", "Male", "BCS");
                    st10.enrolSubject(CSIT128);
                    CSIT128.enrolStudent(st10);
                    
                    CourseWorkStudent st11=new CourseWorkStudent("1234511", "Emily", "Female", "BIT");
                    st11.enrolSubject(CSIT214);
                    CSIT214.enrolStudent(st11);
                    
                    CourseWorkStudent st12=new CourseWorkStudent("1234512", "Aiden", "Male", "BIT");
                    st12.enrolSubject(CSCI235);
                    CSCI235.enrolStudent(st12);
                    
                    CourseWorkStudent st13=new CourseWorkStudent("1234513", "Selena", "Female", "BIT");
                    st13.enrolSubject(CSCI251);
                    CSCI251.enrolStudent(st13);
                    
                    CSSchool.addStudent(st1);
                    CSSchool.addStudent(st2);
                    CSSchool.addStudent(st3);
                    CSSchool.addStudent(st4);
                    CSSchool.addStudent(st5);
                    CSSchool.addStudent(st6);
                    CSSchool.addStudent(st7);
                    CSSchool.addStudent(st8);
                    CSSchool.addStudent(st9);
                    CSSchool.addStudent(st10);
                    CSSchool.addStudent(st11);
                    CSSchool.addStudent(st12);
                    CSSchool.addStudent(st13);
                    
                    //add 7 HDR students
                    HDRStudent st14=new HDRStudent("1234514", "Sofia", "Female", "PhD", david);
                    david.addSupervisingStudent(st14);
                    
                    HDRStudent st15=new HDRStudent("1234515", "Lucas", "Male", "PhD", liam);
                    liam.addSupervisingStudent(st15);
                    
                    HDRStudent st16=new HDRStudent("1234516", "Ella", "Female", "PhD", noah);
                    noah.addSupervisingStudent(st16);
                    
                    HDRStudent st17=new HDRStudent("1234517", "Ethan", "Male", "PhD", william);
                    william.addSupervisingStudent(st17);
                    
                    HDRStudent st18=new HDRStudent("1234518", "Victoria", "Female", "PhD", emma);
                    emma.addSupervisingStudent(st18);
                    
                    HDRStudent st19=new HDRStudent("1234519", "Daniel", "Male", "PhD", ava);
                    ava.addSupervisingStudent(st19);
                    
                    HDRStudent st20=new HDRStudent("1234520", "Grace", "Female", "PhD", mia);
                    mia.addSupervisingStudent(st20);
                    
                    CSSchool.addStudent(st14);
                    CSSchool.addStudent(st15);
                    CSSchool.addStudent(st16);
                    CSSchool.addStudent(st17);
                    CSSchool.addStudent(st18);
                    CSSchool.addStudent(st19);
                    CSSchool.addStudent(st20);*/
                    
                    break;
                case 2:
                    
                    System.out.println("Please input the staff name: ");
        
                    String psn = input.nextLine();
        
                    System.out.println("Please input the staff ID: ");
        
                    String psid = input.next();
        
                    System.out.println("Please input the staff title: ");
        
                    String psti = input.next();
                    
                    System.out.println("Please input the staff gender: ");
        
                    String pstg = input.next();
                    
                    System.out.println("Please input the staff position: ");
        
                    String pspo = input.next();
                    
                    System.out.println("Please input the staff phone number: ");
        
                    String psp = input.next();
        
                    System.out.println("Please input the staff email address: ");
        
                    String pse = input.next();
        
                    System.out.println("Please input the staff office location: ");
        
                    String psl = input.next();
                    
                    System.out.println("Is this (1) a professional staff or (2) an academic staff");
                    
                    int stype=input.nextInt();
                    
                    if(stype==1){
                        System.out.println("Please input the staff working days: ");
                    
                        input.nextLine();
        
                        String psd = input.nextLine();
                        
                        ProfessionalStaff newPStaff = new ProfessionalStaff(psn, psid, pstg, psti, pspo, psp, pse, psl, psd);
                        
                        CSSchool.addStaff(newPStaff);
                    }else{
                        AcademicStaff newAStaff = new AcademicStaff(psn, psid, pstg, psti, pspo, psp, pse, psl);
                        
                        CSSchool.addStaff(newAStaff);
                    }

                    break;
                
                case 3:
                    System.out.println("Please input the subject code: ");
        
                    String sc = input.next();
                    
                    System.out.println("Please input the subject name: ");
                    
                    input.nextLine();
                    
                    String sn = input.nextLine();
        
                    System.out.println("Please input the subject session and year (such as Autumn 2021): ");
        
                    String ss = input.nextLine();
                    
                    System.out.println("Please input the campus (Wollongong or SWS): ");
                    
                    String camp = input.nextLine();
                    
                    System.out.println("Please nominate a subject coordinator from the following staff:\n");
                    
                    for(int i=0;i<CSSchool.getStaffList().size();i++){
                        if(CSSchool.getStaffList().get(i) instanceof AcademicStaff)
                            System.out.println(i+": "+CSSchool.getStaffList().get(i).getName());
                    }
        
                    System.out.print("Please input the index for the subject coordinator: ");
                    
                    int sci = input.nextInt();
                    
                    AcademicStaff co=(AcademicStaff)CSSchool.getStaffList().get(sci);
                    
                    Subject newSubject = new Subject(sc, sn, ss, camp, co);
                    
                    co.addTeachingSubject(newSubject);
                    
                    CSSchool.addSubject(newSubject);
                    
                    break;
                    
                case 4:
                    System.out.println("Please input the student name: ");
        
                    String stn = input.nextLine();
                    
                    System.out.println("Please input the student ID: ");
                    
                    String stid = input.next();
                    
                    System.out.println("Please input the student gender: ");
                    
                    String stg = input.next();
        
                    System.out.println("Please input the student course (BCS, BIT, MCS, MIT or PhD): ");
        
                    String stc = input.next();
                    
                    if(stc.equals("PhD")){
                        System.out.println("Please nominate a supervisor from the following staff:\n");
                    
                        for(int i=0;i<CSSchool.getStaffList().size();i++){
                            if(CSSchool.getStaffList().get(i) instanceof AcademicStaff)
                                System.out.println(i+": "+CSSchool.getStaffList().get(i).getName());
                        }
        
                        System.out.println("Please input the index for the supervisor: ");
                    
                        int sts = input.nextInt();
                    
                        AcademicStaff su=(AcademicStaff)CSSchool.getStaffList().get(sts);
                    
                        HDRStudent newStudent = new HDRStudent(stid, stn, stg, stc, su);
                    
                        su.addSupervisingStudent(newStudent);
                    
                        CSSchool.addStudent(newStudent);
                    }else{
                        
                        CourseWorkStudent newStudent = new CourseWorkStudent(stid, stn, stg, stc);
                        CSSchool.addStudent(newStudent);
                        
                        input.nextLine();
                        
                        System.out.println("Please enrol at least one subject offered by the school:\n");
                    
                        for(int i=0;i<CSSchool.getSubjectList().size();i++){
                            System.out.println(i+": "+CSSchool.getSubjectList().get(i).getCode()+" ("+
                                    CSSchool.getSubjectList().get(i).getName()+")");
                        }
                        
                        
                        System.out.print("\nPlease input the index for the subjects (separate by comma): \n");
                    
                        String[] ssub = input.nextLine().split(",");
                        
                        for(int i=0;i<ssub.length;i++){
                            int index=Integer.parseInt(ssub[i]);
                            Subject sub = CSSchool.getSubjectList().get(index);
                            newStudent.enrolSubject(sub);
                            sub.enrolStudent(newStudent);
                        }
                    }
                    
                    break;
                case 5:
                    System.out.println(CSSchool.showSchoolStaff());
                    break;
                case 6:
                    System.out.println(CSSchool.showSchoolSubject());
                    break;
                case 7:
                    System.out.println(CSSchool.showSchoolStudent());
                    break;
                case 8:
                    try {
                        Formatter textOutput = new Formatter("csschool.txt");                            
                        textOutput.format(CSSchool.toString());
                        textOutput.close();
                    } catch (FileNotFoundException ex) {
                        System.err.println(ex);
                    }  
                    break;
                case 9:
                    loop=false;
                    System.out.println("Thanks for using the SMS, see you next time.");
                    break; 
            }
        }
     
    }
}
