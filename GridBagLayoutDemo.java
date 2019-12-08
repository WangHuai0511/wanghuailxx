package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

class MyWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		Window window=(Window)e.getComponent();
		window.dispose();
		
	}
}
class MyActionListener implements ActionListener{
	
	private TextField textField;
	public MyActionListener(TextField textField) {
		super();
		this.textField = textField;
	}
	public void actionPerformed(ActionEvent e) {
			textField.setText("you course is noting");
	}
	
}
public class GridBagLayoutDemo implements ActionListener {
    public static void main(String args[]) {
    	GridBagLayoutDemo demo = new GridBagLayoutDemo();
    }
    public GridBagLayoutDemo() {
    	this.init();
    	
    }
    public void init() {
    	f = new Frame();
    	f.setTitle("Student choice course system");  	 
        f.setSize(600,600);
        f.setVisible(true);
    	
        j1 = new JButton("课程");
        j2 = new JButton("选课");
        j3 = new JButton("退课");
        j4 = new JPanel();
        String[] str = { "java", "C#", "HTML5" };
        j5 = new JComboBox(str);
        j6 = new JTextField();
        j7 = new JButton("Name");
        j8 = new JList(str);
        j9 = new TextField();
        j9.setBackground(Color.PINK);
//        myAListener =new MyActionListener(j9);
        j2.addActionListener(this);     
        j3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//扩展内部类
				// TODO Auto-generated method stub
				try {
					String nt=j6.getText();
					j9.setText(" 你已退课: ");				
					sb = new StringBuffer(4096);
					temp = null;
					br = new BufferedReader(new FileReader(f1)); 
					while((temp = br.readLine())!= null){ 
					       if ((temp.indexOf(nt))==-1) {
					    	   sb.append(temp).append("\r\n");
						}       
					} 
					br.close(); 
					bw = new BufferedWriter((new FileWriter(f1))); 
					bw.write(sb.toString()); 
					bw.close();
				} catch (IOException e1) {
				
				}
			}
		});
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(j5);
        f.add(j6);
        f.add(j7);
        f.add(j8);
        f.add(j9);
        GridBagConstraints s= new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridwidth=1;s.weightx = 0;s.weighty=0;
       
        layout.setConstraints(j1, s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j2, s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j3, s);
        s.gridwidth=0;s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j4, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j5, s);
        s.gridwidth=4;
        s.weightx = 1;
        s.weighty=0;
        layout.setConstraints(j6, s);
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j7, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j8, s);
        s.gridwidth=5;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j9, s);
        f.addWindowListener(new MyWindow());
    }
    MyActionListener myAListener;
    Teacher t;
    Course c;
    Student stu;
    Frame f ;
    JButton j1;
    JButton j2;
    JButton j3;
    JPanel j4;
    JComboBox j5;
    JTextField j6;
    JButton j7;
    JList j8;
    TextField j9;
    //扩展变量
    File f1= new File(".."+File.separator+"选课.txt"); 
	FileWriter out;
	BufferedReader br;
	BufferedWriter bw ;
	String temp; 
	StringBuffer sb ;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = j6.getText();
		String course =(String)j5.getSelectedItem();
		c=new Course(1, course, "school",3,3);
		t=new Teacher(1, "张老师", "男",c);
		stu=new Student(1,name, "男",c,t);	   
      	j9.setText(" "+stu);
      	 try {
   	    	out=new FileWriter(f1,true);
   	    	out.write("\\"+stu.getName()+"\\"+stu.getCourse()+"\\"+stu.getTeather()+"\n");
   	    	out.flush();
   	    	out.close();
			} catch (IOException e2) {
				System.out.println("文件传输错误");
			}
		
	}
    
}