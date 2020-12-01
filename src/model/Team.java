package model;

public class Team{

	//Attribute

	private String name;
	public final static int TWENTYFIVE = 25;
	public final static int THREE = 3;
	public final static int ONE = 1;
	public final static int FOR = 29;

	//Relatios

	private HeadCoach[] headCoach;
	private TechnicalAssistant[] technicalAssistant;
	private Player[] players;

	public Team(String name){

		this.name = name;
		headCoach = new HeadCoach[ONE];
		technicalAssistant = new TechnicalAssistant[THREE];
		players = new Player[TWENTYFIVE];
	}

	public String hireEmployee(Player objEmployee){
		
		String message = "";
		boolean verific = false;

		if(objEmployee != null && objEmployee instanceof Player){
			for(int i = 0; i<TWENTYFIVE && !verific; i++){
				if(players[i] == null){
					verific = true;
					players[i] = objEmployee;
					message = "Se ingreso correctamente el jugador al equipo";
				}
				else{
					message = "Ya se encuentran ingresados los 25 jugadores de este equipo";
				}
			}
		}
		return message;
	}

	public String hireEmployee(HeadCoach objEmployee){

		String message = "";
		boolean verific = false;

		if(objEmployee != null && objEmployee instanceof HeadCoach){
			for (int i = 0;i<ONE && !verific; i++) {
				if(headCoach[i] == null){
					verific = true;
					headCoach[i] = objEmployee;
					message = "Se ingreso correctamente el entrenador principal al equipo";
				}
				else{
					message = "Ya se encuentra ingresado el entrenador principal de este equipo";
				}
			}
		}

		return message;
	}

	public String hireEmployee(TechnicalAssistant objEmployee){

		String message = "";
		boolean verific = false;

		if(objEmployee != null && objEmployee instanceof TechnicalAssistant){
			for(int i = 0; i<THREE && !verific; i++){
				if(technicalAssistant[i] == null){
					verific = true;
					technicalAssistant[i] = objEmployee;
					message = "Se ingreso correctamente el asistente tecnico al equipo";
				}
				else {
					message = "Ya se encuentran ingresados los 3 asistentes tecnicos de este equipo";
				}
			}
		}
		return message;
	}

	public boolean findNumTShirt(String numTShirt){

		boolean verific = false;

		for(int i = 0;i<TWENTYFIVE && !verific; i++){
			if(players[i] != null && players[i].getTshirtNumber().equals(numTShirt)){
				verific = true;
			}
		}
		return verific;
	}

	public boolean dismissingEmployee(HeadCoach objEmployee){

		boolean verific = false;
			
		if(objEmployee != null && objEmployee instanceof HeadCoach){
			for (int k = 0;k<ONE && !verific; k++) {
				if(headCoach[k] == objEmployee){
					verific = true;
					objEmployee.changeState();
					headCoach[k] = null;
				}
			}
		}
		return verific;
	}

	public boolean dismissingEmployee(TechnicalAssistant objEmployee){

		boolean verific = false;

		if(objEmployee != null && objEmployee instanceof TechnicalAssistant){
			for(int i = 0; i<THREE && !verific; i++){
				if(technicalAssistant[i] == objEmployee){
					verific = true;
					objEmployee.changeState();
					technicalAssistant[i] = null;
				}
			}
		}

		return verific;
	}

	public boolean dismissingEmployee(Player objEmployee){
		 
		boolean verific = false;

		if(objEmployee != null && objEmployee instanceof Player){
			for(int i = 0; i<TWENTYFIVE && !verific; i++){
				if(players[i] == objEmployee){
					verific = true;
					objEmployee.changeState();
					players[i] = null;
				}
			}
		}
		return verific;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public HeadCoach[] getHeadCoach(){
		return headCoach;
	}

	public void setHeadCoach(HeadCoach[] headCoach){
		this.headCoach = headCoach;
	}

	public TechnicalAssistant[] getTechnicalAssistant(){
		return technicalAssistant;
	}

	public void setTechnicalAssistant(TechnicalAssistant[] technicalAssistant){
		this.technicalAssistant = technicalAssistant;
	}

	public Player[] getPlayer(){
		return players;
	}

	public void setPlayer(Player[] players){
		this.players = players;
	}
}