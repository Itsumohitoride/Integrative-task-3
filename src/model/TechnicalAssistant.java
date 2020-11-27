package model;

public class TechnicalAssistant extends Coach{

	//Attribute

	private boolean professionalPlayer;

	//Constructor

	public TechnicalAssistant(String name, String id, double salary, int yearsExperience, boolean professionalPlayer){

		super(name,id,salary,yearsExperience);
		this.professionalPlayer = professionalPlayer;
	}

	public boolean getProfessionalPlayer(){
		return professionalPlayer;
	}

	public void setProfessionalPlayer(boolean professionalPlayer){
		this.professionalPlayer = professionalPlayer;
	}
}