
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class SMSFrame extends JFrame{

    public static void main(String[] args) {
        SMSFrame smsFrame = new SMSFrame("School Management System");
    }
    
    public SMSFrame(String t){
        super(t);
        
        setLayout(new BorderLayout());
        
        add(new CPanel(), BorderLayout.CENTER);
        
        setLocation(500,0);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class CPanel extends JPanel{
    private final JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    private final JTextField tf1, tf2;
    private final JList<String> staffList, subList, stdList;
    private DefaultListModel<String> staffLM, subLM, stdLM;
    private final JTextArea staffArea, subArea, stdArea;
    private final JButton addProButton, addAcdButton, addSubButton, addCWStdButton, addHDRStdButton, printButton, existButton;
    private School CSSchool=null;
    
    public CPanel(){
        super();
  
        
        setLayout(new GridLayout(12,2));
        
        l1=new JLabel("Head of School:");
        add(l1);
        
        tf1=new JTextField(10);
        add(tf1);
        
        l2=new JLabel("School Manager:");
        add(l2);
        
        tf2=new JTextField(10);
        add(tf2);
        
        l3=new JLabel("Staff List");
        add(l3);
        
        l4=new JLabel("Staff Information");
        add(l4);
        
        staffLM=new DefaultListModel<String>();
        staffList=new JList(staffLM);
        staffList.setVisibleRowCount(10);
        staffList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        staffList.addListSelectionListener(new listHandler());
        add(new JScrollPane(staffList));
        
        staffArea=new JTextArea(10,10);
        add(new JScrollPane(staffArea));
        
        l5=new JLabel("Subject List");
        add(l5);
        
        l6=new JLabel("Subject Information");
        add(l6);
        
        subLM=new DefaultListModel<String>();
        subList=new JList(subLM);
        subList.setVisibleRowCount(10);
        subList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        subList.addListSelectionListener(new listHandler());
        add(new JScrollPane(subList));
        
        subArea=new JTextArea(10,10);
        add(new JScrollPane(subArea));
        
        l7=new JLabel("Student List");
        add(l7);
        
        l8=new JLabel("Student Information");
        add(l8);
        
        stdLM=new DefaultListModel<String>();
        stdList=new JList(stdLM);
        stdList.setVisibleRowCount(10);
        stdList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stdList.addListSelectionListener(new listHandler());
        add(new JScrollPane(stdList));
        
        stdArea=new JTextArea(10,10);
        add(new JScrollPane(stdArea));
        
        ButtonHandler bHanderl=new ButtonHandler(this);
        
        addProButton=new JButton("Add Professional Staff");
        addProButton.addActionListener(bHanderl);
        add(addProButton);
        
        addAcdButton=new JButton("Add Academic Staff");
        addAcdButton.addActionListener(bHanderl);
        add(addAcdButton);
        
        addSubButton=new JButton("Add Subject");
        addSubButton.addActionListener(bHanderl);
        add(addSubButton);
        
        addCWStdButton=new JButton("Add CourseWork Student");
        addCWStdButton.addActionListener(bHanderl);
        add(addCWStdButton);
        
        addHDRStdButton=new JButton("Add HDR Student");
        addHDRStdButton.addActionListener(bHanderl);
        add(addHDRStdButton);
        
        printButton=new JButton("Export to txt file");
        printButton.addActionListener(bHanderl);
        add(printButton);
        
        existButton=new JButton("Exist the system");
        existButton.addActionListener(bHanderl);
        add(existButton);
        
        initaliseSchool();
    }
    
    private class ButtonHandler implements ActionListener{
        
        private CPanel cp=null;
        
        public ButtonHandler(CPanel c){
            cp=c;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==addProButton){
                ProfessionalStaffFrame proFrame = new ProfessionalStaffFrame(cp);
                proFrame.setVisible(true);
                proFrame.pack();
            }
            
            if(e.getSource()==addAcdButton){
                AcademicStaffFrame acdFrame = new AcademicStaffFrame(cp);
                acdFrame.setVisible(true);
                acdFrame.pack();
            }
            
            
            if(e.getSource()==addSubButton){
                SubjectFrame subFrame = new SubjectFrame(cp);
                subFrame.setVisible(true);
                subFrame.pack();
            }
            
            if(e.getSource()==addCWStdButton){
                CourseWorkStudentFrame csStdFrame = new CourseWorkStudentFrame(cp);
                csStdFrame.setVisible(true);
                csStdFrame.pack();
            }
            
            if(e.getSource()==addHDRStdButton){
                HDRStudentFrame hdrStdFrame = new HDRStudentFrame(cp);
                hdrStdFrame.setVisible(true);
                hdrStdFrame.pack();
            }
            
            if(e.getSource()==printButton){
                try {
                     Formatter textOutput = new Formatter("CSSchool.txt");
            
                     textOutput.format(CSSchool.toString());
            
                     textOutput.close();
                     JOptionPane.showMessageDialog(null, "The CSSchool's information is saved.", "Save txt file", JOptionPane.INFORMATION_MESSAGE);
                    } catch (FileNotFoundException ie) {
                        JOptionPane.showMessageDialog(null, ie, "Save txt file", JOptionPane.ERROR_MESSAGE);
                    }
            }
            
            if(e.getSource()==existButton){
                System.exit(0);
            }
        } 
    }
    
    private class listHandler implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e){
            if(e.getSource()==staffList){
               staffArea.removeAll();
               staffArea.setText(CSSchool.getStaffList().get(staffList.getSelectedIndex()).toString()); 
            }
            
            if(e.getSource()==subList){
               subArea.removeAll();
               subArea.setText(CSSchool.getSubjectList().get(subList.getSelectedIndex()).toString()); 
            }
            
            if(e.getSource()==stdList){
               stdArea.removeAll();
               stdArea.setText(CSSchool.getStudentList().get(stdList.getSelectedIndex()).toString()); 
            }
        }
    }
    
    private void initaliseSchool(){
        
        try{
            ObjectInputStream objInput = new ObjectInputStream(Files.newInputStream(Paths.get("csschool.ser")));
            
            CSSchool = (School) objInput.readObject();
                
            tf1.setText(CSSchool.getHoS().getName());
            tf2.setText(CSSchool.getManager().getName());
                
            for(Staff s:CSSchool.getStaffList())
                staffLM.addElement(s.getName());
                
            for(Subject s:CSSchool.getSubjectList())
                subLM.addElement(s.getName());
                
            for(Student s:CSSchool.getStudentList())
                stdLM.addElement(s.getName());
                
                   
        }catch(IOException | ClassNotFoundException ie){
            System.err.println(ie);
            System.exit(1);
        }
    }
    
    public void addStaff(Staff s){
        CSSchool.addStaff(s);
        staffLM.addElement(s.getName());
    }
    
    public void addSubject(Subject s){
        CSSchool.addSubject(s);
        subLM.addElement(s.getName());
    }
    
    public void addStudent(Student s){
        CSSchool.addStudent(s);
        stdLM.addElement(s.getName());
    }
    
    public Subject[] getSubjects(){
        
        Subject[] sub=new Subject[CSSchool.getSubjectList().size()];
        
        for(int i=0;i<sub.length;i++)
            sub[i]=CSSchool.getSubjectList().get(i);
        
        return sub;
    }
    
    public HDRStudent[] getHDRs(){
        ArrayList<HDRStudent> ar=new ArrayList<HDRStudent>(0);
        
        for(Student s:CSSchool.getStudentList()){
            if(s instanceof HDRStudent){
                ar.add((HDRStudent)s);
            }
        }
        
        HDRStudent[] hdr=new HDRStudent[ar.size()];
        
        for(int i=0;i<hdr.length;i++)
            hdr[i]=ar.get(i);
        
        return hdr;
    }
    
    public AcademicStaff[] getAcademicStaff(){
        ArrayList<AcademicStaff> ar=new ArrayList<AcademicStaff>(0);
        
        for(Staff s:CSSchool.getStaffList()){
            if(s instanceof AcademicStaff){
                ar.add((AcademicStaff)s);
            }
        }
        
        AcademicStaff[] acd=new AcademicStaff[ar.size()];
        
        for(int i=0;i<acd.length;i++)
            acd[i]=ar.get(i);
        
        return acd;
    }
    
    public CourseWorkStudent[] getCourseWorkStudents(){
        ArrayList<CourseWorkStudent> ar=new ArrayList<CourseWorkStudent>(0);
        
        for(Student s:CSSchool.getStudentList()){
            if(s instanceof CourseWorkStudent){
                ar.add((CourseWorkStudent)s);
            }
        }
        
        CourseWorkStudent[] st=new CourseWorkStudent[ar.size()];
        
        for(int i=0;i<st.length;i++)
            st[i]=ar.get(i);
        
        return st;
    }
}

class ProfessionalStaffFrame extends JFrame{
    private final JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    private final JTextField txName,txID,txTitle,txPosition,txNumber,txEmail,txOffice,txWorking;
    private final JComboBox<String> cbGender;
    private final String[] genders={"Male","Female"};
    private final JPanel panel;
    private final JButton addButton, cancelButton;
    private CPanel parentFrame=null;
    
    public ProfessionalStaffFrame(CPanel pf){
        super("Create a new professional staff");
        
        panel=new JPanel();     
        panel.setLayout(new GridLayout(10,2,10,0));
        
        l1=new JLabel("Professional Staff Name:");
        panel.add(l1);
        
        txName=new JTextField(5);
        panel.add(txName);
        
        l2=new JLabel("Professional Staff ID:");
        panel.add(l2);
        
        txID=new JTextField(5);
        panel.add(txID);
        
        l3=new JLabel("Professional Staff Gender:");
        panel.add(l3);
        
        cbGender=new JComboBox<String>(genders);
        cbGender.setMaximumRowCount(1);
        panel.add(cbGender);
        
        l4=new JLabel("Professional Staff Title:");
        panel.add(l4);
        
        txTitle=new JTextField(5);
        panel.add(txTitle);
        
        l5=new JLabel("Professional Staff Position:");
        panel.add(l5);
        
        txPosition=new JTextField(5);
        panel.add(txPosition);
        
        l6=new JLabel("Professional Staff Number:");
        panel.add(l6);
        
        txNumber=new JTextField(5);
        panel.add(txNumber);
        
        l7=new JLabel("Professional Staff Email:");
        panel.add(l7);
        
        txEmail=new JTextField(5);
        panel.add(txEmail);
        
        l8=new JLabel("Professional Staff Office:");
        panel.add(l8);
        
        txOffice=new JTextField(5);
        panel.add(txOffice);
        
        l9=new JLabel("Working hours:");
        panel.add(l9);
        
        txWorking=new JTextField(5);
        panel.add(txWorking);
        
        addButton=new JButton("Add");
        addButton.addActionListener(new ButtonHandler(this));
        panel.add(addButton);
        
        cancelButton=new JButton("Cancle");
        cancelButton.addActionListener(new ButtonHandler(this));
        panel.add(cancelButton);
        
        add(panel,BorderLayout.CENTER);
        
        parentFrame=pf;
    }
    
    private class ButtonHandler implements ActionListener{
        private ProfessionalStaffFrame pf=null;
        
        public ButtonHandler(ProfessionalStaffFrame p){
            pf=p;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==addButton&&validateCheck()){
                parentFrame.addStaff(
                    new ProfessionalStaff(txName.getText(),txID.getText(),cbGender.getSelectedItem().toString(),
                    txTitle.getText(),txPosition.getText(),txNumber.getText(),txEmail.getText(),txOffice.getText(),txWorking.getText()));
                pf.dispose();
            }
            
            if(e.getSource()==cancelButton){
                pf.dispose();
            }
        } 
        
        private boolean validateCheck() {
            try{
                if(txName.getText().equals("")){
                    throw new InputMismatchException("Please input the name.");
                }
                
                if(txID.getText().equals("")){
                    throw new InputMismatchException("Please input the ID.");
                }
                
                if(txTitle.getText().equals("")){
                    throw new InputMismatchException("Please input the title.");
                }
                
                if(txPosition.getText().equals("")){
                    throw new InputMismatchException("Please input the position.");
                }
                
                if(txNumber.getText().equals("")){
                    throw new InputMismatchException("Please input the number.");
                }
                
                if(txEmail.getText().equals("")){
                    throw new InputMismatchException("Please input the Email.");
                }
                
                if(txOffice.getText().equals("")){
                    throw new InputMismatchException("Please input the location.");
                }
                
                if(txWorking.getText().equals("")){
                    throw new InputMismatchException("Please input the working hours.");
                }

                return true;
            }catch(InputMismatchException ie){
                JOptionPane.showMessageDialog(null, ie, "Validation Checking", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }
    }
}

class AcademicStaffFrame extends JFrame{
    private final JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private final JTextField txName,txID,txTitle,txPosition,txNumber,txEmail,txOffice;
    private final JComboBox<String> cbGender, subCBox, hdrCBox;
    private final String[] genders={"Male","Female"};
    private final JPanel panel;
    private final JButton addButton, cancelButton;
    private CPanel parentFrame=null;
    private Subject[] subjects=null;
    private HDRStudent[] hdr=null;
    
    public AcademicStaffFrame(CPanel pf){
        super("Create a new academic staff");
        
        parentFrame=pf;
        
        panel=new JPanel();     
        panel.setLayout(new GridLayout(11,2,10,0));
        
        l1=new JLabel("Academic Staff Name:");
        panel.add(l1);
        
        txName=new JTextField(5);
        panel.add(txName);
        
        l2=new JLabel("Academic Staff ID:");
        panel.add(l2);
        
        txID=new JTextField(5);
        panel.add(txID);
        
        l3=new JLabel("Academic Staff Gender:");
        panel.add(l3);
        
        cbGender=new JComboBox<String>(genders);
        cbGender.setMaximumRowCount(1);
        panel.add(cbGender);
        
        l4=new JLabel("Academic Staff Title:");
        panel.add(l4);
        
        txTitle=new JTextField(5);
        panel.add(txTitle);
        
        l5=new JLabel("Academic Staff Position:");
        panel.add(l5);
        
        txPosition=new JTextField(5);
        panel.add(txPosition);
        
        l6=new JLabel("Academic Staff Number:");
        panel.add(l6);
        
        txNumber=new JTextField(5);
        panel.add(txNumber);
        
        l7=new JLabel("Academic Staff Email:");
        panel.add(l7);
        
        txEmail=new JTextField(5);
        panel.add(txEmail);
        
        l8=new JLabel("Academic Staff Office:");
        panel.add(l8);
        
        txOffice=new JTextField(5);
        panel.add(txOffice);
        
        l9=new JLabel("Teaching subjects:");
        panel.add(l9);
        
        subjects=parentFrame.getSubjects();
        String[] subNames = new String[subjects.length];
        for(int i=0;i<subNames.length;i++)
            subNames[i]=subjects[i].getName();
        subCBox=new JComboBox<String>(subNames);
        subCBox.setMaximumRowCount(1);
        panel.add(subCBox);
        
        l10=new JLabel("Supervising:");
        panel.add(l10);
        
        hdr=parentFrame.getHDRs();
        String[] hdrNames = new String[hdr.length];
        for(int i=0;i<hdrNames.length;i++)
            hdrNames[i]=hdr[i].getName();
        hdrCBox=new JComboBox<String>(hdrNames);
        hdrCBox.setMaximumRowCount(1);
        panel.add(hdrCBox);
        
        addButton=new JButton("Add");
        addButton.addActionListener(new ButtonHandler(this));
        panel.add(addButton);
        
        cancelButton=new JButton("Cancle");
        cancelButton.addActionListener(new ButtonHandler(this));
        panel.add(cancelButton);
        
        add(panel,BorderLayout.CENTER);
   
    }
    
    private class ButtonHandler implements ActionListener{
        private AcademicStaffFrame pf=null;
        
        public ButtonHandler(AcademicStaffFrame p){
            pf=p;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==addButton && validateCheck()){
                
                AcademicStaff as=new AcademicStaff(txName.getText(),txID.getText(),cbGender.getSelectedItem().toString(),
                    txTitle.getText(),txPosition.getText(),txNumber.getText(),txEmail.getText(),txOffice.getText());
                as.addTeachingSubject(subjects[subCBox.getSelectedIndex()]);
                as.addSupervisingStudent(hdr[hdrCBox.getSelectedIndex()]);
                
                parentFrame.addStaff(as);
                
                pf.dispose();
            }
            
            if(e.getSource()==cancelButton){
                pf.dispose();
            }
        } 
        
        private boolean validateCheck() {
            try{
                if(txName.getText().equals("")){
                    throw new InputMismatchException("Please input the name.");
                }
                
                if(txID.getText().equals("")){
                    throw new InputMismatchException("Please input the ID.");
                }
                
                if(txTitle.getText().equals("")){
                    throw new InputMismatchException("Please input the title.");
                }
                
                if(txPosition.getText().equals("")){
                    throw new InputMismatchException("Please input the position.");
                }
                
                if(txNumber.getText().equals("")){
                    throw new InputMismatchException("Please input the number.");
                }
                
                if(txEmail.getText().equals("")){
                    throw new InputMismatchException("Please input the Email.");
                }
                
                if(txOffice.getText().equals("")){
                    throw new InputMismatchException("Please input the location.");
                }

                return true;
            }catch(InputMismatchException ie){
                JOptionPane.showMessageDialog(null, ie, "Validation Checking", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }
    }
}


class SubjectFrame extends JFrame{
    private final JLabel l1,l2,l3,l4,l5,l6;
    private final JTextField txCode,txName,txSession,txCampus;
    private final JComboBox<String> subCBox;
    private final JPanel panel;
    private final JButton addButton, cancelButton;
    private CPanel parentFrame=null;
    private AcademicStaff[] acdStaff=null;
    private CourseWorkStudent[] cStudent=null;
    private final JList stdList;
    private DefaultListModel<String> stdLM; 
    
    public SubjectFrame(CPanel pf){
        super("Create a new subject");
        
        parentFrame=pf;
        
        panel=new JPanel();     
        panel.setLayout(new GridLayout(7,2,10,0));
        
        l1=new JLabel("Subject Code:");
        panel.add(l1);
        
        txCode=new JTextField(5);
        panel.add(txCode);
        
        l2=new JLabel("Subject Name:");
        panel.add(l2);
        
        txName=new JTextField(5);
        panel.add(txName);
        
        l3=new JLabel("Session:");
        panel.add(l3);
        
        txSession=new JTextField(5);
        panel.add(txSession);
        
        l4=new JLabel("Campus");
        panel.add(l4);
        
        txCampus=new JTextField(5);
        panel.add(txCampus);
        
        l5=new JLabel("Coordinator");
        panel.add(l5);
        
        
        acdStaff=parentFrame.getAcademicStaff();
        String[] acdNames = new String[acdStaff.length];
        for(int i=0;i<acdNames.length;i++)
            acdNames[i]=acdStaff[i].getName();
        subCBox=new JComboBox<String>(acdNames);
        subCBox.setMaximumRowCount(1);
        panel.add(subCBox);
        
        l6=new JLabel("Enrolled Students");
        panel.add(l6);
        
        stdLM=new DefaultListModel<String>();
        cStudent=parentFrame.getCourseWorkStudents();
        for(CourseWorkStudent s:cStudent)
            stdLM.addElement(s.getName());
        stdList=new JList(stdLM);
        stdList.setVisibleRowCount(10);
        stdList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(stdList));
        
        addButton=new JButton("Add");
        addButton.addActionListener(new ButtonHandler(this));
        panel.add(addButton);
        
        cancelButton=new JButton("Cancle");
        cancelButton.addActionListener(new ButtonHandler(this));
        panel.add(cancelButton);
        
        add(panel,BorderLayout.CENTER);
    }
    
    private class ButtonHandler implements ActionListener{
        private SubjectFrame pf=null;
        
        public ButtonHandler(SubjectFrame p){
            pf=p;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==addButton&&validateCheck()){
                
                Subject sub=new Subject(txCode.getText(),txName.getText(),txSession.getText(),
                    txCampus.getText(),acdStaff[subCBox.getSelectedIndex()]);

                for(int i=0;i<stdList.getSelectedIndices().length;i++)
                    sub.enrolStudent(cStudent[stdList.getSelectedIndices()[i]]);
                
                parentFrame.addSubject(sub);
                
                pf.dispose();
            }
            
            if(e.getSource()==cancelButton){
                pf.dispose();
            }
        } 
        
        private boolean validateCheck() {
            try{
                if(txCode.getText().equals("")){
                    throw new InputMismatchException("Please input the code.");
                }
                
                if(txName.getText().equals("")){
                    throw new InputMismatchException("Please input the Name.");
                }
                
                if(txSession.getText().equals("")){
                    throw new InputMismatchException("Please input the session.");
                }
                
                if(txCampus.getText().equals("")){
                    throw new InputMismatchException("Please input the campus.");
                }
                
                if(stdList.getSelectedIndex()==-1){
                    throw new InputMismatchException("Please enrol at least one student.");
                }

                return true;
            }catch(InputMismatchException ie){
                JOptionPane.showMessageDialog(null, ie, "Validation Checking", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }
    }
}

class CourseWorkStudentFrame extends JFrame{
    private final JLabel l1,l2,l3,l4,l5;
    private final JTextField txID,txName;
    private final JComboBox<String> genderCBox, courseCBox;
    private final JPanel panel;
    private final JButton addButton, cancelButton;
    private CPanel parentFrame=null;
    private Subject[] subjects=null;
    private final JList subList;
    private DefaultListModel<String> subLM; 
    private final String[] genders={"Male","Female"};
    private final String[] courses={"BCS","BIT"};
    
    public CourseWorkStudentFrame(CPanel pf){
        super("Add a new coursework student");
        
        parentFrame=pf;
        
        panel=new JPanel();     
        panel.setLayout(new GridLayout(6,2,10,0));
        
        l1=new JLabel("Student ID:");
        panel.add(l1);
        
        txID=new JTextField(5);
        panel.add(txID);
        
        l2=new JLabel("Student Name:");
        panel.add(l2);
        
        txName=new JTextField(5);
        panel.add(txName);
        
        l3=new JLabel("Student Gender:");
        panel.add(l3);
        
        genderCBox=new JComboBox<String>(genders);
        genderCBox.setMaximumRowCount(1);
        panel.add(genderCBox);
        
        l4=new JLabel("Course");
        panel.add(l4);
        
        courseCBox=new JComboBox<String>(courses);
        courseCBox.setMaximumRowCount(1);
        panel.add(courseCBox);
        
        l5=new JLabel("Enrolled Subjects");
        panel.add(l5);
        
        subLM=new DefaultListModel<String>();
        subjects=parentFrame.getSubjects();
        for(Subject s:subjects)
            subLM.addElement(s.getName());
        subList=new JList(subLM);
        subList.setVisibleRowCount(10);
        subList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(subList));
        
        addButton=new JButton("Add");
        addButton.addActionListener(new ButtonHandler(this));
        panel.add(addButton);
        
        cancelButton=new JButton("Cancle");
        cancelButton.addActionListener(new ButtonHandler(this));
        panel.add(cancelButton);
        
        add(panel,BorderLayout.CENTER);
    }
    
    private class ButtonHandler implements ActionListener{
        private CourseWorkStudentFrame pf=null;
        
        public ButtonHandler(CourseWorkStudentFrame p){
            pf=p;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==addButton&&validateCheck()){
                
                CourseWorkStudent std=new CourseWorkStudent(txID.getText(),txName.getText(),
                        genderCBox.getSelectedItem().toString(), courseCBox.getSelectedItem().toString());

                for(int i=0;i<subList.getSelectedIndices().length;i++)
                    std.enrolSubject(subjects[subList.getSelectedIndices()[i]]);
                
                parentFrame.addStudent(std);
                
                pf.dispose();
            }
            
            if(e.getSource()==cancelButton){
                pf.dispose();
            }
            
        } 
        
        private boolean validateCheck() {
            try{
                if(txID.getText().equals("")){
                    throw new InputMismatchException("Please input the ID.");
                }
                
                if(txName.getText().equals("")){
                    throw new InputMismatchException("Please input the Name.");
                }
                
                if(subList.getSelectedIndex()==-1){
                    throw new InputMismatchException("Please enrol into at least one subject.");
                }

                return true;
            }catch(InputMismatchException ie){
                JOptionPane.showMessageDialog(null, ie, "Validation Checking", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }
    }
}

class HDRStudentFrame extends JFrame{
    private final JLabel l1,l2,l3,l4,l5;
    private final JTextField txID,txName;
    private final JComboBox<String> genderCBox, courseCBox;
    private final JPanel panel;
    private final JButton addButton, cancelButton;
    private CPanel parentFrame=null;
    private AcademicStaff[] acdStaff=null;
    private final JList acdList;
    private DefaultListModel<String> acdLM; 
    private final String[] genders={"Male","Female"};
    private final String[] courses={"PhD","MPhi"};
    
    public HDRStudentFrame(CPanel pf){
        super("Add a new HDR student");
        
        parentFrame=pf;
        
        panel=new JPanel();     
        panel.setLayout(new GridLayout(6,2,10,0));
        
        l1=new JLabel("Student ID:");
        panel.add(l1);
        
        txID=new JTextField(5);
        panel.add(txID);
        
        l2=new JLabel("Student Name:");
        panel.add(l2);
        
        txName=new JTextField(5);
        panel.add(txName);
        
        l3=new JLabel("Student Gender:");
        panel.add(l3);
        
        genderCBox=new JComboBox<String>(genders);
        genderCBox.setMaximumRowCount(1);
        panel.add(genderCBox);
        
        l4=new JLabel("Course");
        panel.add(l4);
        
        courseCBox=new JComboBox<String>(courses);
        courseCBox.setMaximumRowCount(1);
        panel.add(courseCBox);
        
        l5=new JLabel("HDR Supervisor");
        panel.add(l5);
        
        acdLM=new DefaultListModel<String>();
        acdStaff=parentFrame.getAcademicStaff();
        for(AcademicStaff s:acdStaff)
            acdLM.addElement(s.getName());
        acdList=new JList(acdLM);
        acdList.setVisibleRowCount(10);
        acdList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(acdList));
        
        addButton=new JButton("Add");
        addButton.addActionListener(new ButtonHandler(this));
        panel.add(addButton);
        
        cancelButton=new JButton("Cancle");
        cancelButton.addActionListener(new ButtonHandler(this));
        panel.add(cancelButton);
        
        add(panel,BorderLayout.CENTER);
    }
    
    private class ButtonHandler implements ActionListener{
        private HDRStudentFrame pf=null;
        
        public ButtonHandler(HDRStudentFrame p){
            pf=p;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==addButton&&validateCheck()){
                
                HDRStudent std=new HDRStudent(txID.getText(),txName.getText(),
                        genderCBox.getSelectedItem().toString(), courseCBox.getSelectedItem().toString(),
                acdStaff[acdList.getSelectedIndex()]);
                
                parentFrame.addStudent(std);
                
                pf.dispose();
            }
            
            if(e.getSource()==cancelButton){
                pf.dispose();
            }
        } 
        
        private boolean validateCheck() {
            try{
                if(txID.getText().equals("")){
                    throw new InputMismatchException("Please input the ID.");
                }
                
                if(txName.getText().equals("")){
                    throw new InputMismatchException("Please input the Name.");
                }
                
                if(acdList.getSelectedIndex()==-1){
                    throw new InputMismatchException("Please select a supervisor.");
                }

                return true;
            }catch(InputMismatchException ie){
                JOptionPane.showMessageDialog(null, ie, "Validation Checking", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }
    }
}