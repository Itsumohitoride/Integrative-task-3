package model;
import  java.util.*;

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
	private Player[][] dressing;

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

	public String showDressing(int one, int two){

		String message = "";

		dressing =  new Player[one][two];

		List<Player> playerList = Arrays.asList(players);

		Collections.shuffle(playerList);

		playerList.toArray(players);

		for(int i = 0;i<one;i++){

            if(i%2 == 0){
                for(int j = 0;j<two;j+=2){
                    if(dressing[i][j] == null && j == 0){	
                    	dressing[i][j] = players[j];
                    }
                    else if(dressing[i][j] == null){
                    	dressing[i][j] = players[j-2];
                    }
                }
            }
            else{
				for(int j=two-1;j>=0;j-=2){
					if(dressing[i][j] == null && j == two-1){
						dressing[i][j] = players[j];
					}
					else if(dressing[i][j] == null){
                    	dressing[i][j] = players[j+2];
                    }
				}
			} 
        }

        for(int i = 0;i<one;i++){
			for(int j = 0;j<two;j++){
				
				if(dressing[i][j] == null){
					message += "[Vacio]";
				}
				else if(dressing[i][j] != null){
					message += "["+dressing[i][j].getName()+"]";	
				}
			}
			message += "\n";
		}

		return message;
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