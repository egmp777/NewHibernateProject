package com.cc.example.hibernate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.annotations.common.*;

import junit.framework.*;
import junit.runner.*;

public class MainClass {
  
private static ServiceRegistry serviceRegistry;
private static SessionFactory factory;

 
public static void main(String[] args) {
  try{
  
    
	  try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         
	      }
	   
	Employee emp1=new Employee();
    Employee emp2=new Employee();
    Employee emp3=new Employee();
    emp1.setId(215);
    emp1.setFirstName("marco");
    emp1.setLastName("bissi");
    emp1.setEmail("egmp@gmail.com");
    
    emp2.setId(216);
    emp2.setFirstName("andres");
    emp2.setLastName("par");
    emp2.setEmail("apar@gmail.com");
    
    emp3.setId(217);
    emp3.setFirstName("Jose");
    emp3.setLastName("canto");
    emp3.setEmail("pepe@gmail.com");
    
     MainClass handler=new MainClass();
    
    handler.insert_record(emp1);
    handler.insert_record(emp2);
    handler.insert_record(emp3);
    
 
    handler.getPageOfEmployees();
   
   handler.updateEmployee(2, "testUser_01@sourabhsoni.com");
    
   handler.getEmployee(2);
  }catch(Exception e){
    System.out.println(e.getMessage());
  }finally{
    
  }
}
 
public void insert_record(Employee emp)
{
  Session session=null;
  Transaction tx=null;
  try
  {
    session =factory.openSession();
    tx=session.getTransaction();
    tx.begin();
    session.save(emp);
    tx.commit();
    session.flush();
  }catch(HibernateException he){
    if(tx!=null)tx.rollback();
    System.out.println("Not able to open session");
    he.printStackTrace();
  }
  catch(Exception e){
    e.printStackTrace();
  }finally{
    if(session!=null)
    session.close();
  }
}
 
public void getPageOfEmployees(){
	Session sess = null;
    try{
      SessionFactory sf = new Configuration().
configure().buildSessionFactory();
      sess = sf.openSession();
      String hql = "FROM Employee Order by FirstName";
      Query query = sess.createQuery(hql);
      query.setFirstResult(1);
      query.setMaxResults(5);
      List<Employee> employees = query.list();
      for(Employee emp: employees){
        System.out.println(
            "Id: " + emp.getId()
            + ", FirstName: " + emp.getFirstName()
            + ", LastName: " + emp.getLastName() 
            + ",email: " + emp.getEmail()
          );
      }
      Transaction tr = sess.beginTransaction();
      tr.commit();
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
      if(sess != null){
        sess.close();
      }
    }
}

public List<Employee> getPageOfEmployees2(){
	Session sess = null;
	 List<Employee> employees = new ArrayList();
    try{
      SessionFactory sf = new Configuration().
configure().buildSessionFactory();
      sess = sf.openSession();
      String hql = "FROM Employee";
      Query query = sess.createQuery(hql);
      query.setFirstResult(1);
      query.setMaxResults(5);
     employees = query.list();
      for(Employee emp: employees){
        System.out.println(
            "Id: " + emp.getId()
            + ", FirstName: " + emp.getFirstName()
            + ", LastName: " + emp.getLastName() 
            + ",email: " + emp.getEmail()
          );
      }
      Transaction tr = sess.beginTransaction();
      tr.commit();
    }catch(Exception ex){
      ex.printStackTrace();
    }finally{
      if(sess != null){
        sess.close();
      }
    }
    return employees;
}

public void getEmployee(long id)
{
  Session session=null;
  Transaction tx=null;
  try
  {
    session=factory.openSession();
    tx=session.beginTransaction();
    Employee emp=(Employee)session.get(Employee.class, id);
    System.out.println("Name:"+emp.getFirstName()+" "+emp.getLastName());
    System.out.println("Email:"+emp.getEmail());
    tx.commit();
  }catch(HibernateException he){
    if(tx!=null)tx.rollback();
    he.printStackTrace();
  }finally{
    if(session!=null)
    session.close();
  }
}
public void getAllEmployees()
{
  Session session=null;
  Transaction tx=null;
  try
  {
    session=factory.openSession();
    tx=session.beginTransaction();
    String SQL_Query="FROM Employee";
    Query query=session.createQuery(SQL_Query);
    List employees=query.list();
    Iterator itr=employees.iterator();
    while(itr.hasNext())
    {
      Employee emp=(Employee)itr.next();
      System.out.println("Employee id:"+emp.getId());
      System.out.println("Name:"+emp.getFirstName()+" "+emp.getLastName());
      System.out.println("Email:"+emp.getEmail());
    }
    tx.commit();
  }catch(HibernateException he){
    if(tx!=null)tx.rollback();
    he.printStackTrace();
  }finally{
    if(session!=null)
    session.close();
  }
}
 
public void updateEmployee(long id,String email)
{
  Session session=null;
  Transaction tx=null;
  try
  {
    session=factory.openSession();
    tx=session.beginTransaction();
    Employee emp=(Employee)session.get(Employee.class, id);
    emp.setEmail(email);
    session.update(emp);
    tx.commit();
  }catch(HibernateException he){
    if(tx!=null)tx.rollback();
    he.printStackTrace();
  }finally{
    if(session!=null)
    session.close();
  }
}
 
}