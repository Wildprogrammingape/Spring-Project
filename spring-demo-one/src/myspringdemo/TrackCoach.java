package myspringdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
	
		return "Run a hard 5k";
	}

	@Override
	public String getFortune() {
		return "Just do it :" + fortuneService.getFortune();
	}
	// add an init method
	public void dostartup() {
		System.out.println("TrackCoach: inside method startup");
		
	}
	// add a destroy method
	public void docleanup() {
		System.out.println("TrackCoach: inside method cleanup");
	}
}
