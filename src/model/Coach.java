package model;

public abstract class Coach extends Employee{

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

	@Override

	public String toString(){

		String message = "";

		message = super.toString()+
				  "\n** Anios de experiencia: "+yearsExperience;

		return message;
	}
}