package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addSillyMember() {
		
		System.out.println(getClass() + ": Doing stuff: Adding a membership account");
	}
	
	public void goToSleep() {

		System.out.println(getClass() + ": go to sleep");
	}
}
