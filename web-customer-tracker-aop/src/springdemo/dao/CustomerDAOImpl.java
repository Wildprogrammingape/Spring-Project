package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springdemo.entity.Customer;

@Repository    // means elements of DAO
public class CustomerDAOImpl implements CustomerDAO {
	
	
	// need to inject the session factory (needed to use below)
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@Override
	//@Transactional   // don't need the transaction.begin() and transaction.close() again
	public List<Customer> getCustomer() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query, and sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", 
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();   //get the List from database
		
		// return the results
		return customers;
	}




	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer  
		currentSession.saveOrUpdate(theCustomer);
	}




	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from database from the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}




	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}











