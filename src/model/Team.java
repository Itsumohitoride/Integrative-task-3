package model;
import  java.util.*;

public class Team{

	//Attribute

	private String name;
	private LineUp objLineUp;
	public final static int TWENTYFIVE = 25;
	public final static int THREE = 3;
	public final static int ONE = 1;

	//Relatios

	private HeadCoach[] headCoach;
	private TechnicalAssistant[] technicalAssistant;
	private Player[] players;
	private Player[][] dressing;
	private ArrayList<LineUp> lineUp;

	/**
	*<b>name:</b> Team <br>
	* Create a object Team. <br>
	* <b>post:</b> A object Team has created. <br>
	* @param name is the name of the team. name != null y name != "".
	*/

	public Team(String name){

		this.name = name;
		lineUp = new ArrayList<>();
		headCoach = new HeadCoach[ONE];
		technicalAssistant = new TechnicalAssistant[THREE];
		players = new Player[TWENTYFIVE];
	}

	/**
	* <b>name:</b> findEmployee <br>
	* Find an employee. <br>
	* <b>post:</b> send the result of the search.
	* @param name is the name of any employee. name != null y name != "".
	* @param id is the identifier of any employee. id != null y != "".
	* @return <code>boolean</code> specifying verific is the result of the search.
	*/

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

	/**
	* <b>name:</b> hireEmployee <br>
	* Hire a soccer player. <br>
	* <b>post:</b> Hire a soccer player. <br>
	* @param objEmployee is the object of any player. objEmployee != null y objEmployee != "".
	* @return <code>String</code> specifying message is the result of the hire.
	*/

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

	/**
	* <b>name:</b> hireEmployee <br>
	* Hire a head coach. <br>
	* <b>post:</b> Hire a heah coach. <br>
	* @param objEmployee is the object of any head coach. objEmployee != null y objEmployee != "".
	* @return <code>String</code> specifying message is the result of the hire.
	*/

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

	/**
	* <b>name:</b> hireEmployee <br>
	* Hire an Assistant coach. <br>
	* <b>post:</b> Hire an Assistant coach. <br>
	* @param objEmployee is the object of any assistant coach. objEmployee != null y objEmployee != "".
	* @return <code>String</code> specifying message is the result of the hire.
	*/

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

	/**
	* <b>name:</b> findNumTShirt <br>
	* Find the number t-shirt of a soccer player.
	* <b>post:</b> send the result of the search.
	* @param numTShirt is the number of the t-shirt of any soccer player. numTShirt != null y numTShirt != "".
	* @return <code>boolean</code> specifying verific is the result of the search.
	*/

	public boolean findNumTShirt(String numTShirt){

		boolean verific = false;

		for(int i = 0;i<TWENTYFIVE && !verific; i++){
			if(players[i] != null && players[i].getTshirtNumber().equals(numTShirt)){
				verific = true;
			}
		}
		return verific;
	}

	/**
	* <b>name:</b> dismissingEmployee <br>
	* Dismissing an employee. <br>
	* <b>post:</b> Dismissing an employee. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @return <code>boolean</code> specifying verific is the result of the dismissing.
	*/

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

	/**
	* <b>name:</b> showEdifice <br>
	* Do a message with the information of the dressing rooms. <br>
	* <b>post:</b> Send a message with the information of the dressing rooms.
	* @param one is the row size. one greater than 0.
	* @param two is the size of columns. two greater than 0.
	* @return <code>String</code> specifying message is the information of  the dressing rooms.
	*/

	public String showDressing(int one, int two){

		String message = "";
		boolean verific = false;

		dressing =  new Player[one][two];

		List<Player> playerList = Arrays.asList(players);

		Collections.shuffle(playerList);

		playerList.toArray(players);

		for(int p = 0; p<players.length; p++){

			verific = false;

			for(int i = 0;i<one && !verific;i++){

            	if(i%2 == 0){
                	for(int j = 0;j<two && !verific;j+=2){
                    	if(dressing[i][j] == null){	
                    		dressing[i][j] = players[p];
                    		verific = true;
                    	}
                	}
            	}
            	else{
					for(int j = two-1; j>=0 && !verific;j-=2){
						if(dressing[i][j] == null){
							dressing[i][j] = players[p];
							verific = true;
						}
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

		message += "\n************************************************************************"+
				   "\n*                          SE QUEDA POR FUERA                          *"+
				   "\n************************************************************************\n";

		for(int p = 0; p<players.length; p++){

			verific = false;

			for(int i = 0;i<one && !verific;i++){

            	if(i%2 == 0){
                	for(int j = 0;j<two && !verific;j+=2){
                    	if(dressing[i][j] != null && dressing[i][j] == players[p]){	
                    		verific = true;
                    	}
                	}
            	}
            	else{
					for(int j = two-1; j>=0 && !verific;j-=2){
						if(dressing[i][j] != null && dressing[i][j] == players[p]){
							verific = true;
						}
					}
				} 
			}
			if(!verific && players[p] != null){
				message += "El jugador: "+players[p].getName();
			}
		}

		return message;
	}

	/**
	* <b>name:</b> addFormation <br>
	* Add a new line up for a team. <br>
	* <b>post:</b> save the new line up for a team.
	* @param way is the number who idenfies the tactics. way greater or equal than 1 y way less or equal than 4.
	* @param date is the date of utilization of line up. date != null y date != "".
	* @param forward is the number of forwards in the line up. forward greater than 0.
	* @param midfielder is the number of midfielders in the line up. midfielder greater than 0.
	* @param defender is the number of defenders in the line up. defender greater than 0.
	* @return <code>String</code> specifying message is the result for add a line up.
	*/

	public String addFormation(int way, String date, int forward, int midfielder, int defender){

		String message = "";


		if((forward+midfielder+defender) != 10){
			message = "La alinacion solo puede tener 10 jugadores en la cancha";
		}
		else if((forward+midfielder+defender) == 10){
			objLineUp = new LineUp(way,date,forward,midfielder,defender);

			lineUp.add(objLineUp);

			message = "Se agrego correctamente la alinacion";
		}

		return message;
	}

	/**
	* <b>name:</b> changeNameTeam <br>
	* Change the name of any team. <br>
	* <b>post:</b> The name of the team has change. <br>
	* @param nameTeam is the new name of any team. nameTeam != null y nameTeam != "".
	* @return <code>String</code> specifying message is the result of change the team's name.
	*/

	public String changeNameTeam(String nameTeam){

		String message = "Se cambio el nombre del equipo correctamente";

		setName(nameTeam);

		return message;
	}

	/**
	* <b>name:</b> getName <br>
	* Gets the team name.
	* <b>post:</b> gets the team name.
	* @return <code>String</code> specifying name is the name of the team.
	*/

	public String getName(){
		return name;
	}

	/**
	* <b>name:</b> setName <br>
	* Alters the team name.
	* <b>post:</b> alters the team name.
	* @param name Is the new name of the team.
	*/

	public void setName(String name){
		this.name = name;
	}

	/**
	* <b>name:</b> getHeadCoach <br>
	* Gets the list of the head coachs.
	* <b>post:</b> gets the list of the head coachs.
	* @return <code>HeadCoach</code> specifying headCoach is a list of the objects head coach.
	*/

	public HeadCoach[] getHeadCoach(){
		return headCoach;
	}

	/**
	* <b>name:</b> setHeadCoach <br>
	* Alters the list of head coachs.
	* <b>post:</b> alters the list of head coachs.
	* @param headCoach Is the list of head coachs.
	*/

	public void setHeadCoach(HeadCoach[] headCoach){
		this.headCoach = headCoach;
	}

	/**
	* <b>name:</b> getTechnicalAssistant <br>
	* Gets the list of the assistant coachs.
	* <b>post:</b> gets the list of the assistant coachs.
	* @return <code>TechnicalAssistant</code> specifying technicalAssistant is a list of the objects assistant coach.
	*/

	public TechnicalAssistant[] getTechnicalAssistant(){
		return technicalAssistant;
	}

	/**
	* <b>name:</b> setTechnicalAssistant <br>
	* Alters the list of assistant coachs.
	* <b>post:</b> alters the list of assistant coachs.
	* @param technicalAssistant Is the list of assistant coachs.
	*/

	public void setTechnicalAssistant(TechnicalAssistant[] technicalAssistant){
		this.technicalAssistant = technicalAssistant;
	}

	/**
	* <b>name:</b> getPlayer <br>
	* Gets the list of the soccer players.
	* <b>post:</b> gets the list of the soccer players.
	* @return <code>Player</code> specifying players is a list of the objects soccer players.
	*/

	public Player[] getPlayer(){
		return players;
	}

	/**
	* <b>name:</b> setPlayer <br>
	* Alters the list of soccers players.
	* <b>post:</b> alters the list of soccers players.
	* @param players Is the list of soccers players.
	*/

	public void setPlayer(Player[] players){
		this.players = players;
	}

	/**
	* <b>name:</b> toString <br>
	* Show a message with the information of the team. <br>
	* <b>post:</b> Send a message with the information of the team. <br>
	* @return <code>String</code> specifying message is the information of the team.
	*/

	public String toString(){

		String message = "";
		String messageHeadCoach = "";
		String messageTechnicalAssistant = "";
		String messagePlayer = "";
		String messageLineUp = "";
		boolean verificHeadCoach = false;
		boolean verificTechnicalAssistant = false;
		boolean verificPlayer = false;
		boolean verificLineUp = false;

		for(int i = 0; i<headCoach.length && !verificHeadCoach; i++){
			if(headCoach[i] != null){
				messageHeadCoach += headCoach[i].toString();
			}
			else if(headCoach[0] == null){
				messageHeadCoach += "************************************************************************\n"+
				 				    "*                Ningun entrenador principal contratado                *\n"+
								    "************************************************************************\n";
				verificHeadCoach = true;
			}
		}
		for(int i = 0; i<technicalAssistant.length && !verificTechnicalAssistant; i++){
			if(technicalAssistant[i] != null){
				messageTechnicalAssistant += technicalAssistant[i].toString();
			}
			else if(technicalAssistant[0] == null){
				messageTechnicalAssistant += "************************************************************************\n"+
				 				    		 "*                Ningun entrenador asistente contratado                *\n"+
								   			 "************************************************************************\n";
				verificTechnicalAssistant = true;
			}
		}
		for(int i = 0; i<players.length && !verificPlayer; i++){
			if(players[i] != null){
				messagePlayer += players[i].toString();
			}
			else if(players[0] == null){
				messagePlayer += "************************************************************************\n"+
				 				 "*                Ningun entrenador asistente contratado                *\n"+
								 "************************************************************************\n";
				verificPlayer = true;
			}
		}

		for(int i = 0; i<lineUp.size() && !verificLineUp; i++){
			if(lineUp.get(i) != null){
				messageLineUp += lineUp.get(i).toString();
			}
		}

		message = "************************************************************************\n"+
				  "*                                 EQUIPO                               *\n"+
				  "************************************************************************\n"+
				  "** Nombre: "+name+"\n"+
				  messageHeadCoach+"\n"+
				  messageTechnicalAssistant+"\n"+
				  messagePlayer+"\n"+
				  messageLineUp;

		return message;
	}
}