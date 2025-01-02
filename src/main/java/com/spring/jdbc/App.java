package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);        
        Student student = new Student();
        
//		INSERT OPERATION
//        student.setId(1005);
//        student.setName("SRH");
//        student.setCity("Pune");
//        
//        int result = studentDao.insert(student);        
//        System.out.println(result + " record(s) inserted...");

//      UPDATE OPERATION
//        student.setId(1003);
//        student.setName("KTY");
//        student.setCity("A.BAD");
//        
//        int result = studentDao.update(student);
//        System.out.println(result + " row(s) affected...");
        
//      DELETE OPERATION
//        int result = studentDao.delete(1003);
//        System.out.println(result + " row(s) affected...");
        
//      SELECT single object
          student = studentDao.getStudent(1001);
          System.out.println(student);
          System.out.println("------------------------------------------------------------------");
        
//      SELECT multiple objects
          List<Student> students = studentDao.getAllStudents();
          for(Student s : students) {
        	  System.out.println(s);
          }                  
    }
}
