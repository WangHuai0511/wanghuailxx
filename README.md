# 计G191 2019322051 王槐
# 实验目的
        1.分析学生选课系统
        2.使用GUI窗体及其组件设计窗体界面
        3.完成学生选课过程业务逻辑编程
        4.基于文件保存并读取数据
        5.处理异常

# 实验内容与要求
## 内容：
    利用已学的GUI窗体，使用GUI窗体及其组件设计窗体界面，创建选课，退课程序代码，写出功能函数，并运行。达到如下功能：
## 要求：
       1.设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
       2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
       3、针对操作过程中可能会出现的各种异常，做异常处理
       4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
# 实验过程
## 学生选课系统简单实现
    1、设计Personnel类（人员类）
    声明编号、姓名、性别变量；
    2、设计Teacher类（教师类）和设计Student类（学生类）
    继承Personnel类，获得编号、姓名、性别变量，调用Course类，进行选课、退课操作，使用toString() 方法将“"学生编号："/“老师”+id+",学生："+name+",所选课程："+subject;”转为字符串返回结果。
```java
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
    3、设计Course类（课程类）
    声明编号、课程名称、上课地点、时间和学分变量，调用Teacher类，使用toString() 方法将“"课程编号："+id+",课程名："+name+",地点："+place+",时    间："+time+",学分："+mark+",老师信息："+teacher;”转为字符串返回结果。
    4、测试类
    通过给Teacher、Student、course实例化，然后输出课表信息，退课后打印课程信息。
```java
package classalter;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Course course=new Course(2019322051, "java", "实验室",3,3);
		 Teacther teather=new Teacther(2, "张老师", "男",course);
		 Student student=new Student(1, "王槐", "男",course,teather);
		 System.out.println(student.toString());
		 student.delete();
		student.put();
		 
	}
```
## 学生选课系统GUI实现
    1.制作并分析图形用户界面
    2.把课程、老师、学生这三个类放入到图形用户界面。
    3.注册监听器，实现监听器和按钮的链接，从而实现图形用户界面与各个类的链接。
    4．最后运行程序，看是否能实现学生选课界面。
```java
public void actionPerformed(ActionEvent e) {
		String name = j6.getText();
		String course =(String)j5.getSelectedItem();
		c=new Course(1, course, "school",3,3);
		t=new Teacher(1, "zhangshibo", "men",c);
		stu=new Student(1,name, "men",c,t);	   
      	j9.setText(" "+stu);	
```
```java
public void init() {
    	f = new Frame();//设置框架属性
    	f = new Frame();
    	f.setTitle("Student choice course system");  	 
        f.setSize(600,600);
        f.setVisible(true);

        j1 = new JButton("course");
        j2 = new JButton("choice");
        j3 = new JButton("set back");
        j4 = new JPanel();
        String[] str = { "java", "C#", "HTML5" };
        j5 = new JComboBox(str);
        j6 = new JTextField();
        j7 = new JButton(" ");
        j8 = new JList(str);
        j9 = new TextField();
        j9.setBackground(Color.PINK);
        myAListener =new MyActionListener(j9);
        j2.addActionListener(this); //监听方法     
        j3.addActionListener(myAListener);
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
    f.add(j1); //添加控件
}
//设置变量
MyActionListener myAListener;
```
## 学生选课系统文件输入输出
    1：创建选课文件。
    2：将选课后的信息存于选课文件中。
    3：点击退课，将要删除的的课程删除。
```java
//扩展内部类
public void actionPerformed(ActionEvent e) {
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
```
# 流程图
![](https://github.com/WangHuai0511/wanghuailxx/blob/master/流程图.png)
# 实验结果
![](https://github.com/WangHuai0511/wanghuailxx/blob/master/1.png)
![](https://github.com/WangHuai0511/wanghuailxx/blob/master/2.png)
![](https://github.com/WangHuai0511/wanghuailxx/blob/master/3.png)
![](https://github.com/WangHuai0511/wanghuailxx/blob/master/4.png)
# 实验感想
通过本次Java编程实验课，让我掌握了一些Java基本语法，虽然以前没咋学过Java，但有一些c语言基础，所以通过努力实验，进一步培养我们利用Java语言进行编程和调试程序的能力，掌握字符串String及其方法的使用和异常处理结构。但在整个实验过程中还是出现了一些错误，通过老师和同学的帮助让我逐渐完善了程序，将课本的理论知识与生活中的实践知识相结合，不断提高自己文化知识和实践能力。

