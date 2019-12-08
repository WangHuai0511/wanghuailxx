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
第一：制作GUI选课界面。
第二：创建选课文件。
第三：将选课后的信息存于选课文件中。
第四：点击退课，将要删除的的课程删除。
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
![](https://github.com/WangHuai0511/wanghuailxx/blob/master/5.png)
![](https://github.com/WangHuai0511/wanghuailxx/blob/master/6.png)
# 实验感想
通过本次Java编程实验课，让我掌握了一些Java基本语法，虽然以前没咋学过Java，但有一些c语言基础，所以通过努力实验，进一步培养我们利用Java语言进行编程和调试程序的能力，掌握字符串String及其方法的使用和异常处理结构。但在整个实验过程中还是出现了一些错误，通过老师和同学的帮助让我逐渐完善了程序，将课本的理论知识与生活中的实践知识相结合，不断提高自己文化知识和实践能力。

