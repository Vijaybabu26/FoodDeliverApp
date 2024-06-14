package com.babu.fooddelivery.dao;


import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;




public class UserDAO {
	
	@Autowired
	SessionFactoryProvider session;
	Transaction transaction = null;
//	public List<User> GetUserByPhno(String Phno) {
//		
//		Session session = SessionFactoryProvider.getSessionFactory();
//		transaction = session.beginTransaction();	
//		
//		String query = "select * from user_details where phone_no = '"+Phno+"'";
//		
//		List<User> user = session.createNativeQuery(query,User.class).getResultList();
//		session.close();
//		return user;
//		
//	}
	
//	public User getEmployeeById(String phoneNo) {
//        try{
//        	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//    		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
//    		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//    		Session session = factory.openSession(); 
//            User u = session.get(User.class, phoneNo);
//            return u;
//        } catch (Exception e) {
//            // Handle exceptions (e.g., log or rethrow)
//            return null;
//        }
//    }
	
//	public List<Object[]> getEmployeesByName(String name){
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//	    
//	    SessionFactory sf = meta.getSessionFactoryBuilder().build();
//		Session s = sf.openSession();
//		String sqlQuery = "select * from emp1 where lastName= ? OR firstName= ?"; 
//		SQLQuery query = s.createSQLQuery(sqlQuery);
//		query.setParameter(1, name);
//		query.setParameter(2, name);
//		List<Object[]> expensesList = query.list();
//		
////		List<Employee> expensesList = query.getResultList();
//		s.close();
//		sf.close();
//		return expensesList;
//	}
}
