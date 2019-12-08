# 计G191 2019322035 周新易
# 综合性实验  学生选课系统设计
# 实验目的
    分析学生选课系统
    使用GUI窗体及其组件设计窗体界面
    完成学生选课过程业务逻辑编程
    基于文件保存并读取数据
    处理异常
# 实验要求
    1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
    2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
    3、针对操作过程中可能会出现的各种异常，做异常处理
    4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
    5、基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。
# 实验流程
## 学生选课系统简单实现
    1、设计Personnel类（人员类）
    声明编号、姓名、性别变量；
    2、设计Teacher类（教师类）和设计Student类（学生类）
    继承Personnel类，获得编号、姓名、性别变量，调用Course类，进行选课、退课操作，使用toString() 方法将“"学生编号："/“老师”+id+",学生："+name+",所     选课程："+subject;”转为字符串返回结果。
    3、设计Course类（课程类）
    声明编号、课程名称、上课地点、时间和学分变量，调用Teacher类，使用toString() 方法将“"课程编号："+id+",课程名："+name+",地点："+place+",时         间："+time+",学分："+mark+",老师信息："+teacher;”转为字符串返回结果。
    4、测试类
    通过给Teacher、Student、course实例化，然后输出课表信息，退课后打印课程信息。
### 关键代码
```JAVA
	Public class Student extends Peronal{}
··Public class Teacher extends Peronal{}

Personal {
Subject subject;
public String toString(){
return "老师编号："+id+",老师："+name+",性别："+sex;
}
public Teacher(String id, String name, String sex) {
super(id, name, sex);
}
}

public void put course (){
if(course ==null){
System.out.println("您未选课！");
}else{
this.toString();
}
}
public String toString(){
return "学生编号："+id+",学生："+name+",所选课程："+course;
}
 
public Student(String id, String name, String sex,course course) {
super(id, name, sex);
this.course= course;
}
public course delete(){
return course = null;
}
	}

```
```JAVA
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Course course=new Course(2019322051, "java", "实验室",3,3);
		 Teacther teather=new Teacther(2, "张老师", "男",course);
		 Student student=new Student(1, "周新易", "男",course,teather);
		 System.out.println(student.toString());
		 student.delete();
		student.put();
		 
	}

}
```
## 学生选课系统GUI实现
    1.制作GUI图形界面
    2.把学生、老师、课程三个类放入到GUI界面中
    3.注册监听器，实现监听器和按钮的链接，从而实现GUI界面与类的链接。
    4.运行程序，实现选课界面。
### 关键代码
```JAVA
public void actionPerformed(ActionEvent e) {
		String stuname = j6.getText();
		String course =(String)j5.getSelectedItem();
		c=new Course(1, course, "综合楼",3,3);
		t=new Teacher(1, "张世博", "男",c);
		stu=new Student(1,stuname, "男",c,t);	   
      	j9.setText(" "+stu);	
		
	}
```
```JAVA
public void init() {
    	f = new Frame();//框架类实例化并设置相关属性
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
        myAListener =new MyActionListener(j9); //调用监听方法

        j2.addActionListener(this);     
        j3.addActionListener(myAListener);
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
    f.add(j1); //添加控件到框架列中
        f.add(j9);
}
//定义变量
MyActionListener myAListener;
TextField j9;
```
## 学生选课系统文件保存
    1.将选课输出数据存入文件
    2.利用WHILE和IF语句，将数据存放缓存，与姓名等与缓存数据比较，相同输入文件，不同跳到下一句。
### 关键代码
```JAVA
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
			}
```
```JAVA
try {
  	    	out=new FileWriter(bb,true);
  	    	out.write("  "+stu.getName()+"  "+stu.getCourse()+"  "+stu.getTeather()+"\n");
  	    	out.flush();
  	    	out.close();
		}
 ```   
# 流程图
![哎](https://github.com/Juejianglaozhou/-/blob/master/liuchentu.png)
# 实验结果
![哎](https://github.com/Juejianglaozhou/-/blob/master/运行1.png)
![哎](https://github.com/Juejianglaozhou/-/blob/master/运行2.png)
![哎](https://github.com/Juejianglaozhou/-/blob/master/运行3.png)
![哎](https://github.com/Juejianglaozhou/-/blob/master/运行4.png)
# 实验感想
    通过本次实验，学会了学生选课系统设计实现，通过这次实验，还发现自己对于JAVA语言的不足，在接下来学习JAVA语言的路上有了很大的帮助。感谢老师同学的指导！
