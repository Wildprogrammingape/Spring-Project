package myspringdemo;

public class BaseballCoach implements Coach {
	// BaseballCoach is compliant by implementing the Coach interface
	

	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practise";
	}

	@Override
	public String getFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
