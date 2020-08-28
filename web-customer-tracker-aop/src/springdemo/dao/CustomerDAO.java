package springdemo.dao;

import java.util.List;

import springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomer();   // define one method

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
