package model;

public abstract class Coach{

	//Attribute

	private int yearsExperience;

	public Coach(String name, String id, double salary, int yearsExperience){

		super(name,id,salary);
		this.yearsExperience = yearsExperience;
	}

	public int getYearsExperience(){
		return yearsExperience;
	}

	public void setYearsExperience(int yearsExperience){
		this.yearsExperience = yearsExperience;
	}
}