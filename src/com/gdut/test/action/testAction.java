package com.gdut.test.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wyk.main.MD5;

import com.gdut.test.entity.Person;
import com.gdut.test.service.TestService;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 测试增删改查 OK！
 * @author wyk
 * @date 2016年6月1日 16:24:27
 */
public class testAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private ClassPathXmlApplicationContext cpa;
	
	@Resource
	private TestService testService;
	
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	//实现struts与sping整合
	public String wykTest(){
		//testService.say();
		System.out.println("-----");
		return "login";
	}
	
	@Before
	public void loadCpa(){
		//读取配置文件applicationContext.xml
		cpa = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testSpring() {
		//获取spring容器中的testService
		TestService testService = (TestService) cpa.getBean("testService");
		//testService.say();
	}
	
	/**
	 *	实现spring和hibernate整合并实现Service与dao分层
	 *	保存数据
	 */
	/**
	 * @param argType
	 * @return 
	 * @time 2016年6月1日
	 */
	@Test
	public void testHibernate(){
		/*SessionFactory sf = (SessionFactory) cpa.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.save(new Person("w","nan",27));
		beginTransaction.commit();
		session.close();
		*/
		String password = "admin";
		password = MD5.MD5(password);
		TestService testService = (TestService) cpa.getBean("testService");
		testService.save(new Person("wyk3",password,28));
		
	}
	
	/**	测试通过Id查找数据
	 * @param 
	 * @return null
	 * @time 2016-6-1 16:10:50
	 */
/*	@Test
	public void findPersonById(){
		
		TestService testService = (TestService) cpa.getBean("testService");
		//Person p = testService.find(new Person(),"40287d8155062de90155062deb660000");
		User p = testService.findObjectById("40287d8155062de90155062deb660000");
		System.out.println(p.getName());
	}*/
	
	/**测试删除
	 * @param argType
	 * @return 
	 * @time 2016年6月1日
	 */
	/*@Test
	public void deleteById(){
		TestService testService = (TestService) cpa.getBean("testService");
		String id = "40287d81550ae14101550ae142ed0000";
		testService.delete(id);
	}*/
	/**测试更新
	 * @param argType
	 * @return 
	 * @time 2016年6月1日
	 */
	/*@Test
	public void update(){
		TestService testService = (TestService) cpa.getBean("testService");
		String id = "40287d8155096b150155096b17090000";
		User p =testService.findObjectById(id);
		p.setName("wangyankai");
		testService.update(p);
	}*/
	/**测试查询列表
	 * @param argType
	 * @return 
	 * @time 2016年6月1日
	 */
	/*@Test
	public void findObjects(){
		TestService testService = (TestService) cpa.getBean("testService");
	
		List<User> list = testService.findObjects();
		System.out.println(list.size());
		for (User person : list) {
			System.out.println(person);
		}
	}*/
}
