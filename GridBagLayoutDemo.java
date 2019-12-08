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

public class GridBagLayoutDemo implements ActionListener {
    public static void main(String args[]) {
    	GridBagLayoutDemo demo = new GridBagLayoutDemo();
    }
    public GridBagLayoutDemo() {
    	this.init();
    	
    }
    public void init() {
    	f = new Frame();
    	f.setTitle("学生选课系统");  	 
        f.setSize(600,600);
        f.setVisible(true);
    	
        j1 = new JButton(" ");
        j2 = new JButton("选课");
        j3 = new JButton("退课");
        j4 = new JPanel();
        String[] str = { "java", "C#", "HTML5" };
        j5 = new JComboBox(str);
        j6 = new JTextField();
        j7 = new JButton(" ");
        j8 = new JList(str);
        j9 = new TextField();
        j9.setBackground(Color.PINK);

        j2.addActionListener(this);     
       j3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String namet=j6.getText();
			    String courset=j5.getToolTipText();
				j9.setText(namet+" 已退课: " +courset);				
				cc = new StringBuffer(4096);
				adad = null;
				br = new BufferedReader(new FileReader(bb)); 
				while((adad = br.readLine())!= null){ 
				       if ((adad.indexOf(namet))==-1) {
				    	   cc.append(adad).append("\r\n");
					}       
				} 
				br.close(); 
				bw = new BufferedWriter((new FileWriter(bb))); 
				bw.write(cc.toString()); 
				bw.close();
			} catch (IOException e1) {
				System.out.println("出错");
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
    String adad; 
	StringBuffer cc;
    File bb= new File("C:\\Users\\86188\\Desktop"+File.separator+"选课.txt"); 
	FileWriter out;
	BufferedReader br;
	BufferedWriter bw ;
	

	public void actionPerformed(ActionEvent e) {
		String stuname = j6.getText();
		String course =(String)j5.getSelectedItem();
		c=new Course(1, course, "综合楼",3,3);
		t=new Teacher(1, "张世博", "男",c);
		stu=new Student(1,stuname, "男",c,t);	   
      	j9.setText(" "+stu);	
        try {
  	    	out=new FileWriter(bb,true);
  	    	out.write("  "+stu.getName()+"  "+stu.getCourse()+"  "+stu.getTeather()+"\n");
  	    	out.flush();
  	    	out.close();
		} catch (IOException e1) {
			System.out.println("出错");
		}
		
	}
    
}