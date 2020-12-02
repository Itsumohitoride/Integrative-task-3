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

	public String changeExpertise(int changeExpertise){

		String message = "";
		boolean verific = false;
		boolean verificExpertise = false;

		Expertise[] listExpertise = new Expertise[Club.SIX];
		Expertise objExpertise = null;

		switch(changeExpertise){
			case 1:
			objExpertise = Expertise.OFFENSIVE;
			break;
			case 2:
			objExpertise = Expertise.DEFENSIVE;
			break;
			case 3:
			objExpertise = Expertise.POSSESION;
			break;
			case 4:
			objExpertise = Expertise.LABORATORYPLAYS;
			break;
			case 5:
			objExpertise = Expertise.PHYSICAL_TRAINER;
			break;
			case 6:
			objExpertise = Expertise.MEDICAL_ASSISTANT;
			break;
		}

		for(int i = 0; i<Club.SIX; i++){
			if(expertise[i] != null){
				listExpertise[i] = expertise[i];
			}
		}

		for (int k = 0;k<Club.SIX && !verific; k++) {
			if(objExpertise == listExpertise[k]){
				verific = true;
				message = "No se agrego la experticie porque ya la tiene el entrenador asistente";
			}
			else{
				for(int p = 0;p<Club.SIX && !verificExpertise; p++){
					if(listExpertise[p] == null){
						verificExpertise = true;
						listExpertise[p] = objExpertise;
						message = "Se agrego correctamente la experticie";
						setExpertise(listExpertise);
					}
				}
			}
		}

		return message;
	}

	public boolean getProfessionalPlayer(){
		return professionalPlayer;
	}

	public void setProfessionalPlayer(boolean professionalPlayer){
		this.professionalPlayer = professionalPlayer;
	}

	public Expertise[] getExpertise(){
		return expertise;
	}

	public void setExpertise(Expertise[] expertise){
		this.expertise = expertise;
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