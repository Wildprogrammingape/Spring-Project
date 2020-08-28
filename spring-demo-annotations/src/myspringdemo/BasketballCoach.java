package myspringdemo;

public class BasketballCoach implements NewCoach{
	
	// create a field for dependency injection to use
	private SumUp mySumUp;
	
	// * must add the constructor
	// since I will use the constructor to define bean!
	public BasketballCoach(SumUp thesumup) {
		mySumUp = thesumup;
	}
	
	@Override
	public String getNewDailyWorkout() {
		return "Practice to shoot for 30 minutes";
	}

	@Override
	public String getFinalSumUp() {
		
		return mySumUp.getSumUp();
	}
	
	// after finished the dependency injection, we need to create beans by java configuration.
}
