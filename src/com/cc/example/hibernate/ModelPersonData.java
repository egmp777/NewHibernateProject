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
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import java.util.Set;
import java.util.HashSet;
import junit.framework.*;
import junit.runner.*;

import java.util.Set;
import java.util.HashSet;

import junit.framework.*;
import junit.runner.*;
public class ModelPersonData {
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory factory;
	
	public List<Person> getPageOfPersons(){
		Session sess = null;
		 List<Person> persons = new ArrayList();
	    try{
	      SessionFactory sf = new Configuration().
	configure().buildSessionFactory();
	      sess = sf.openSession();
	      String hql = "FROM Person";
	      Query query = sess.createQuery(hql);
	      query.setFirstResult(1);
	      query.setMaxResults(5);
	      persons = query.list();
	      for(Person per: persons){
	        System.out.println(
	            "Id: " + per.getId()
	            + ", Firs tName: " + per.getFirstName()
	            + ", Last Name: " + per.getLastName() 
	            + ",Address " + per.getAddress().getName()
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
	    return persons;
	}
	
	public void fillPersons(){
		
		  Session session=null;
		  Transaction tx=null;
		  session =factory.openSession();
		  tx=session.getTransaction();
		  try {
			  tx.begin();
		      for(int i = 0; i < 30; i++){
		    	 Person person = new Person();
		    	 person.setFirstName("Jane_"+i);
		    	 person.setLastName("Doe_"+i);
		    	 Address address = new Address();
		    	 address.setId((int)(1 + (Math.random() * (5 - 1))));
		    	 person.setAddress(address);
		    	 session.save(person);
		      }
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

}
