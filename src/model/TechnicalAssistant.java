package model;

public class TechnicalAssistant extends Coach{

	//Attribute

	private boolean professionalPlayer;
	private Expertise[] expertise;

	//Constructor

	public TechnicalAssistant(String name, String id, double salary, int yearsExperience, boolean professionalPlayer, Expertise[] expertise){

		super(name,id,salary,yearsExperience);
		this.professionalPlayer = professionalPlayer;
		this.expertise = expertise;
	}

	public boolean getProfessionalPlayer(){
		return professionalPlayer;
	}

	public void setProfessionalPlayer(boolean professionalPlayer){
		this.professionalPlayer = professionalPlayer;
	}

	@Override

	public String toString(){

		String message = "";
		String messageProfessional = "";

		if(professionalPlayer){
			messageProfessional = "Si";
		}
		else if(!professionalPlayer){
			messageProfessional = "No";
		}

		message = super.toString()+
				  "\n** Jugador profesional: "+messageProfessional+
				  "************************************************************************";

		return message;
	}
}