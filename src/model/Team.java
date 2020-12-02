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

	public boolean findEmployee(String name, String id){

		boolean verific = false;

		for (int k = 0;k<ONE && !verific; k++) {
			if(headCoach[k] != null && headCoach[k].getName().equalsIgnoreCase(name) && headCoach[k].getId().equalsIgnoreCase(id)){
				verific = true;
			}
		}

		for(int i = 0; i<THREE && !verific; i++){
			if(technicalAssistant[i] != null && technicalAssistant[i].getName().equalsIgnoreCase(name) && technicalAssistant[i].getId().equalsIgnoreCase(id)){
				verific = true;
			}
		}

		for(int p = 0; p<TWENTYFIVE && !verific; p++){
			if(players[p] != null && players[p].getName().equalsIgnoreCase(name) && players[p].getId().equalsIgnoreCase(id)){
				verific = true;
			}
		}

		return verific;
	}

	public String hireEmployee(Player objEmployee){
		
		String message = "";
		boolean verific = false;

		if(objEmployee != null){
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

		if(objEmployee != null){
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

		if(objEmployee != null){
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

	public boolean dismissingEmployee(String name, String id){

		boolean verific = false;
			
		for (int k = 0;k<ONE && !verific; k++) {
			if(headCoach[k] != null && headCoach[k].getName().equalsIgnoreCase(name) && headCoach[k].getId().equalsIgnoreCase(id)){
				verific = true;
				headCoach[k].changeState();
				headCoach[k] = null;
			}
		}

		for(int i = 0; i<THREE && !verific; i++){
			if(technicalAssistant[i] != null && technicalAssistant[i].getName().equalsIgnoreCase(name) && technicalAssistant[i].getId().equalsIgnoreCase(id)){
				verific = true;
				technicalAssistant[i].changeState();
				technicalAssistant[i] = null;
			}
		}

		for(int p = 0; p<TWENTYFIVE && !verific; p++){
			if(players[p] != null && players[p].getName().equalsIgnoreCase(name) && players[p].getId().equalsIgnoreCase(id)){
				verific = true;
				players[p].changeState();
				players[p] = null;
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