package model;

public class HeadCoach extends Coach{

	//Attribute

	private int numTeams;
	private int championshipsAchieved;

	public HeadCoach(String name, String id, double salary, int yearsExperience, int numTeams, int championshipsAchieved){

		super(name,id,salary,yearsExperience);
		this.numTeams = numTeams;
		this.championshipsAchieved = championshipsAchieved;
	}

	public int getNumTeams(){
		return numTeams;
	}

	public void setNumTeams(int numTeams){
		this.numTeams = numTeams;
	}

	public int getChampionshipsAchieved(){
		return championshipsAchieved;
	}

	public void setChampionshipsAchieved(int championshipsAchieved){
		this.championshipsAchieved = championshipsAchieved;
	}
}