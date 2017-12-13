package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import Beans.Test;

public class Client 
{
	public static void main(String[] args) 
	{
		//find xml
		Resource r = new ClassPathResource("resources/Spring.xml");
		//load the xml into core container
		//this called as Lazy Container  
		BeanFactory factory = new XmlBeanFactory(r);
		// in case if we wanted to use j2ee i.e. advanced container
		// just use this ........called as Eager Container and its a better approch
		//ApplicationContext ap = new ClassPathXmlApplicationContext("resources/Spring.xml");
		
		//get the object of beans
		//whenever we call get bean method ..for every user request it will create one-one object
		//
		Object o1 = factory.getBean("t");
		Object o2 = factory.getBean("t");    
		Object o3 = factory.getBean("t");
		
		/*
		 *  in this above case IOC container will create only one object but
		 * if we change the scope in xml file to prototype than it will create
		 * object for every one one request..so here 3 object will be created ....by default scope="singleton">
		 */
		
		System.out.println(o1==o2);
		System.out.println(o2==o3);
		
		Test t = (Test)o1;
		t.hello();
		/*
		 * for using our beans method we have to do this casting 
		 */
		
	}
}
