package model;

public class TechnicalAssistant extends Coach{

	//Attribute

	private boolean professionalPlayer;

	//Relation

	private Expertise[] expertise;

	/**
	*<b>name:</b> TechnicalAssistant <br>
	* Create a object  assistant coach. <br>
	* <b>post:</b> A object assistant coach has created. <br>
	* @param name is the name of an assistant coach. name != null y name != "".
	* @param id is the identification of an assistant coach. id != null y id != "".
	* @param salary is the salary of an assistant coach. salary greater than 0.
	* @param yearsExperience is the year of experience of an employee. yearsExperience greater than 0.
	* @param professionalPlayer is the confirmation if the assistant coach was a soccer player. professionalPlayer != null y professionalPlayer != "".
	* @param expertise are the expertises of the assistant coach.
	*/

	public TechnicalAssistant(String name, String id, double salary, int yearsExperience, boolean professionalPlayer, Expertise[] expertise){

		super(name,id,salary,yearsExperience);
		this.professionalPlayer = professionalPlayer;
		this.expertise = expertise;
	}

	/**
	* <b>name:</b> changeExpertise <br>
	* Add an expertise to the assistant coach. <br>
	* <b>post:</b> Save the new expertise to the assistant coach. <br>
	* @param changeExpertise is new expertise of the assistant coach. expertise greater than 0 and less than 9.
	* @return <code>String</code> specifying message is the result of add a new expertise to an assistant coach.
	*/

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

	/**
	* <b>name:</b> getProfessionalPlayer <br>
	* Gets the confirmation if the assistant coach was a soccer player.
	* <b>post:</b> gets the confirmation if the assistant coach was a soccer player.
	* @return <code>boolean</code> specifying professionalPlayer is the confirmation if the assistant coach was a soccer player.
	*/

	public boolean getProfessionalPlayer(){
		return professionalPlayer;
	}

	/**
	* <b>name:</b> setProfessionalPlayer <br>
	* Alters the confirmation if the assistant coach was a soccer player.
	* <b>post:</b> alters the confirmation if the assistant coach was a soccer player.
	* @param professionalPlayer Is the new confirmation if the assistant coach was a soccer player.
	*/

	public void setProfessionalPlayer(boolean professionalPlayer){
		this.professionalPlayer = professionalPlayer;
	}

	/**
	* <b>name:</b> getExpertise <br>
	* Gets the list of the expertises of the assistant coach.
	* <b>post:</b> gets the list of the expertises of the assistant coach.
	* @return <code>Expertise</code> specifying expertise is the list of the expertises of the assistant coach.
	*/

	public Expertise[] getExpertise(){
		return expertise;
	}

	/**
	* <b>name:</b> setExpertise <br>
	* Alters the list of the expertises of the assistant coach.
	* <b>post:</b> alters the list of the expertises of the assistant coach.
	* @param expertise Is the new list of the expertises of the assistant coach.
	*/

	public void setExpertise(Expertise[] expertise){
		this.expertise = expertise;
	}

	/**
	* <b>name:</b> toString <br>
	* Show a message with the information of the assistant player. <br>
	* <b>post:</b> Send a message with the information of the assistant player. <br>
	* @return <code>String</code> specifying message is the information of the assistant player.
	*/

	@Override

	public String toString(){

		String message = "";
		String messageProfessional = "";
		String messageExpertice = "";

		if(professionalPlayer){
			messageProfessional = "Si";
		}
		else if(!professionalPlayer){
			messageProfessional = "No";
		}

		for(int i = 0; i<expertise.length; i++){
			if (expertise[i] != null){
				messageExpertice += expertise[i]+",";
			}
		}

		message = super.toString()+
				  "\n** Jugador profesional: "+messageProfessional+
				  "\n** Experticias: "+messageExpertice+
				  "\n************************************************************************";

		return message;
	}
}