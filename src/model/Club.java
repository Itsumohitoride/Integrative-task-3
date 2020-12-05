package model;
import java.util.*;

public class Club{

	//Attribute 

	private String name;
	private String nit;
	private String date;
	public final static int SIX = 6;
	public final static int SEVEN = 7;
	public final static int TEN = 10;

	//Relation

	private ArrayList<Employee> employee;
	private Coach[][] office;
	private Team team1;
	private Team team2;

	/**
	* <b>name:</b> Club <br>
	* Create a object club. <br>
	* <b>post:</b> A object club has created. <br>
	* @param name is the name of the club. name != null y name != "".
	* @param nit is the nit of the club. nit != null y nit != "".
	* @param date is the date of the creation of the club. date != null y date != "".
	* @param teamA is the name of the firts team. teamA != null y teamA != "".
	* @param teamB is the name of the second team. teamB != null y teamB != "".
	*/

	public Club(String name, String nit, String date, String teamA, String teamB){

		employee = new ArrayList<>();
		office = new Coach[SIX][SIX];
		team1 = new Team(teamA);
		team2 = new Team(teamB);
		this.name = name;
		this.nit = nit;
		this.date = date;
	}

	/**
	* <b>name:</b> findEmployee <br>
	* Find an employee into the teams. <br>
	* <b>post:</b> Find an employee into the teams <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @return <code>boolean</code> specifying verific is the result of the search an employee.
	*/

	public boolean findEmployee(String name, String id){

		boolean verific = false;

		verific = team1.findEmployee(name,id);

		if(!verific){

			verific = team2.dismissingEmployee(name,id);
		}

		return verific;
	}

	/**
	* <b>name:</b> objFindEmployee <br>
	* Find an employee into the teams. <br>
	* <b>post:</b> Find an employee into the teams. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @return <code>Employee</code> specifying objEmployee is the result of the search an employee.
	*/

	public Employee objFindEmployee(String name, String id){

		Employee objEmployee = null;
		boolean verific = false;

		for(int i = 0; i<employee.size() && !verific; i++){
			if(employee.get(i) != null && employee.get(i).getName().equalsIgnoreCase(name) && employee.get(i).getId().equalsIgnoreCase(id)){
				verific = true;
				objEmployee = employee.get(i);
			}
		}
		return objEmployee;
	}

	/**
	* <b>name:</b> findNumTShirt <br>
	* Find the number t-shirt of an employee. <br>
	* <b>post:</b> Find the number t-shirt of an employee. <br>
	* @param numTShirt is the number t-shirt of an employee. numTShirt != null y numTShirt greater than 0 y numTShirt less than 99.
	* @param team is the team of an employee. team != null y team != "".
	* @return <code>boolean</code> specifying verific is the result of the search the number t-shirt of an employee.
	*/

	public boolean findNumTShirt(String numTShirt, int team){

		boolean verific = false;

		if(team == 1){
			verific = team1.findNumTShirt(numTShirt);
		}else if(team == 2){
			verific = team2.findNumTShirt(numTShirt);
		}
		return verific;
	}

	/**
	* <b>name:</b> findTeam <br>
	* Search the team of an employee. <br>
	* <b>post:</b> Find the team of an employee. <br>
	* @param name is the name of an employee.
	* @param id is the identification of an employee.
	* @return <code>int</code> specifying "i" is the number of a team.
	*/

	public int findTeam(String name, String id){

		int i = 0;

		boolean verific = team1.findEmployee(name,id);
		boolean verific2 = team2.findEmployee(name,id);

		if(verific){
			i = 1;
		}
		else if(verific2){
			i = 2;
		}

		return i;
	}

	/**
	* <b>name:</b> hireEmployee <br>
	* Hire a head coach. <br>
	* <b>post:</b> Hire a heah coach. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param salary is the salary of an employee. salary greater than 0.
	* @param yearsExperience is the year of experience of an employee. yearsExperience greater than 0.
	* @param team is the number of a team. team == 1 or team == 2.
	* @param teams is the number of teams in charge of head coach. teams greater or equal 0.
	* @param nameChampions are the names of the champions achieved by the head coach.
	* @return <code>String</code> specifying message is the result of the hire.
	*/

	public String hireEmployee(String name,String id,double salary,int yearsExperience,int team,int teams, ArrayList<String> nameChampions){

		String message = "";
		boolean verific = false;

		HeadCoach objEmployee = new HeadCoach(name,id,salary,yearsExperience,teams,nameChampions);
		employee.add(objEmployee);

		if(team == 1){
			message = team1.hireEmployee(objEmployee);
		}
		else if(team == 2){
			message = team2.hireEmployee(objEmployee);
		}

		for(int i=0;i<SIX && !verific;i++){

            if(i%2 == 0){
                for(int j=0;j<SIX && !verific;j+=2){
	                if(office[i][j] == null){   
	                    office[i][j] = objEmployee;
	                    verific = true;
	                }
                }
            }   
        }
		return message;
	}

	/**
	* <b>name:</b> hireEmployee <br>
	* Hire an Assistant coach. <br>
	* <b>post:</b> Hire an Assistant coach. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param salary is the salary of an employee. salary greater than 0.
	* @param yearsExperience is the year of experience of an employee. yearsExperience greater than 0.
	* @param team is the number of a team. team == 1 or team == 2.
	* @param professionalPlayer is the confirmation if the assistant coach was a soccer player. professionalPlayer != null y professionalPlayer != "".
	* @param expertise are the expertises of the assistant coach.
	* @return <code>String</code> specifying message is the result of the hire.
	*/

	public String hireEmployee(String name,String id,double salary, int yearsExperience, int team, boolean professionalPlayer, int[] expertise){

		String message = "";
		boolean verific = false;

		Expertise[] objExpertise = new Expertise[SIX];

		for(int k = 0; k<expertise.length; k++){
			if(expertise[k] == 1){
				objExpertise[k] = Expertise.OFFENSIVE;
			}
			else if(expertise[k] == 2){
				objExpertise[k] = Expertise.DEFENSIVE;
			}
			else if(expertise[k] == 3){
				objExpertise[k] = Expertise.POSSESION;
			}
			else if(expertise[k] == 4){
				objExpertise[k] = Expertise.LABORATORYPLAYS;
			}
			else if(expertise[k] == 5){
				objExpertise[k] = Expertise.PHYSICAL_TRAINER;
			}
			else if(expertise[k] == 6){
				objExpertise[k] = Expertise.MEDICAL_ASSISTANT;
			}
		}

		TechnicalAssistant objEmployee = new TechnicalAssistant(name,id,salary,yearsExperience,professionalPlayer,objExpertise);
		employee.add(objEmployee);

		if(team == 1){
			message = team1.hireEmployee(objEmployee);
		}
		else if(team == 2){
			message = team2.hireEmployee(objEmployee);
		}

		for(int i=0;i<SIX && !verific;i++){

            if(i%2 == 0){
                for(int j=0;j<SIX && !verific;j+=2){
                    if(office[i][j] == null){   
	                    office[i][j] = objEmployee;
	                    verific = true;
	                }
                }
            }   
        }

		return message;
	}

	/**
	* <b>name:</b> hireEmployee <br>
	* Hire a soccer player. <br>
	* <b>post:</b> Hire a soccer player. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param salary is the salary of an employee. salary greater than 0.
	* @param team is the number of a team. team == 1 or team == 2.
	* @param numTShirt is the number t-shirt if the soccer player. numTShirt != null y numTShirt != "".
	* @param playerPosition is the position of the soccer player.
	* @return <code>String</code> specifying message is the result of the hire.
	*/

	public String hireEmployee(String name,String id,double salary,int team,String numTShirt,int playerPosition){

		String message = "";

		Player objEmployee = new Player(name,id,salary,numTShirt,playerPosition);
		employee.add(objEmployee);

		if(team == 1){
			message = team1.hireEmployee(objEmployee);
		}
		else if(team == 2){
			message = team2.hireEmployee(objEmployee);
		}

		return message;
	}

	/**
	* <b>name:</b> dismissingEmployee <br>
	* Dismissing an employee. <br>
	* <b>post:</b> Dismissing an employee. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @return <code>String</code> specifying message is the result of the dismissing.
	*/

	public String dismissingEmployee(String name, String id){

		String message = "Se despidio correctamente al empleado";
		boolean verific = false;

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof HeadCoach){
			for(int i=0;i<SIX;i++){

            	if(i%2 == 0){
                	for(int j=0;j<SIX;j+=2){
                    	if(office[i][j] == ((HeadCoach)objEmployee)){
                    		office[i][j] = null;
                    	}
                	}
            	}
            } 
        }
        else if(objEmployee != null && objEmployee instanceof TechnicalAssistant){
			for(int i=0;i<SIX;i++){

            	if(i%2 == 0){
                	for(int j=0;j<SIX;j+=2){
                    	if(office[i][j] == ((TechnicalAssistant)objEmployee)){
                    		office[i][j] = null;
                   	 	}
                	}
            	} 
            }  
        }

		verific = team1.dismissingEmployee(name,id);

		if(!verific){

			verific = team2.dismissingEmployee(name,id);

			if(!verific){
				message = "No se pudo despedir correctamente al empleado";
			}
		}
		return message;
	}

	/**
	* <b>name:</b> changeSalary <br>
	* Change the salary of an employee. <br>
	* <b>post:</b> Change the salary of an employee. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param salary is the new salary of the employee. salary greater than 0.
	* @return <code>String</code> specifying message is the result of the change the salary.
	*/

	public String changeSalary(String name, String id, double salary){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof HeadCoach){

			message = ((HeadCoach)objEmployee).changeSalary(salary);
		}
		else if(objEmployee != null && objEmployee instanceof TechnicalAssistant){

			message = ((TechnicalAssistant)objEmployee).changeSalary(salary);
		}
		else if(objEmployee != null && objEmployee instanceof Player){

			message = ((Player)objEmployee).changeSalary(salary);
		}

		return message;
	}

	/**
	* <b>name:</b> changeYearsExperience <br>
	* Change the years experience of a coach. <br>
	* <b>post:</b> Change the years experience of a coach. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param yearsExperience is the new years of experience of an employee. yearsExperience greater than 0.
	* @return <code>String</code> specifying message is the result of the change the years experience.
	*/

	public String changeYearsExperience(String name, String id, int yearsExperience){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof HeadCoach){

			message = ((HeadCoach)objEmployee).changeYearsExperience(yearsExperience);
		}
		else if(objEmployee != null && objEmployee instanceof TechnicalAssistant){

			message = ((TechnicalAssistant)objEmployee).changeYearsExperience(yearsExperience);
		}
		else if(objEmployee != null && objEmployee instanceof Player){

			message = "El empleado tiene que ser un entrenado principal o asistente para cambiar este campo";
		}	

		return message;
	}

	/**
	* <b>name:</b> changeTeams <br>
	* Change the number of  teams of a head coach. <br>
	* <b>post:</b> Change the number of  teams of a head coach. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param numTeams is the new number of teams in charge of head coach. numTeams greater or equal 0.
	* @return <code>String</code> specifying message is the result of the change the number of teams in charge of head coach.
	*/

	public String changeTeams(String name, String id, int  numTeams){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof HeadCoach){

			message = ((HeadCoach)objEmployee).changeTeams(numTeams);
		}
		else{
			message = "El empleado tiene que ser un entrenador principal para cambiar este campo";
		}

		return message;
	}

	/**
	* <b>name:</b> changeChampions <br>
	* Change the new name of the champions achieved by the head coach. <br>
	* <b>post:</b> Change the new name of the champions achieved by the head coach. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param champions is the new name of the champions achieved by the head coach. champions != null y champions != "".
	* @return <code>String</code> specifying message is the result of the change the number of teams in charge of head coach.
	*/

	public String changeChampions(String name, String id, String champions){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof HeadCoach){

			message = ((HeadCoach)objEmployee).changeChampions(champions);
		}
		else{
			message = "El empleado tiene que ser entrenador principal para cambiar este campo";
		}

		return message;
	}

	/**
	* <b>name:</b> changeExpertise <br>
	* Add an expertise to the assistant coach. <br>
	* <b>post:</b> Save the new expertise to the assistant coach. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param expertise is new expertise of the assistant coach. expertise greater than 0 and less than 9.
	* @return <code>String</code> specifying message is the result of add a new expertise to an assistant coach.
	*/

	public String changeExpertise(String name, String id, int expertise){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof TechnicalAssistant){

			message = ((TechnicalAssistant)objEmployee).changeExpertise(expertise);
		}
		else{
			message = "El empleado tiene que ser entrenador asistente para cambiar este campo";
		}

		return message;
	}

	/**
	* <b>name:</b> changeNumPlayer <br>
	* Change the number t-shirt of a player. <br>
	* <b>post:</b> Change the number t-shirt of a player. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param numPlayer is the number t-shirt of the soccer player. numPlayer != null y numPlayer != "".
	* @return <code>String</code> specifying message is the result of change the number of a player.
	*/

	public String changeNumPlayer(String name, String id, String numPlayer){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof Player){

			message = ((Player)objEmployee).changeNumPlayer(numPlayer);
		}
		else {
			message = "El empleado tiene que ser un jugador para cambiar este campo";
		}

		return message;
	}

	/**
	* <b>name:</b> changeGoals <br>
	* Change the number of goals of a player. <br>
	* <b>post:</b> Change the number of goals of a player. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param goals is the number of goals of the soccer player. goals greater or equal 0.
	* @return <code>String</code> specifying message is the result of change the number of goals of a player.
	*/

	public String changeGoals(String name, String id, int goals){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof Player){

			message = ((Player)objEmployee).changeGoals(goals);
		}
		else {
			message = "El empleado tienen que ser un jugador para cambiar este campo";
		}

		return message;
	}

	/**
	* <b>name:</b> changeCalification <br>
	* Change the calification of a player. <br>
	* <b>post:</b> Change the calification of a player. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param calification is the new calification of the soccer player. calification greater than 0 y calification less or equal than 10.
	* @return <code>String</code> specifying message is the result of change the calification of a player.
	*/

	public String changeCalification(String name, String id, double calification){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof Player){

			message = ((Player)objEmployee).changeCalification(calification);
		}
		else {
			message = "El empleado tiene que ser un jugador para cambiar este campo";
		}
		return message;
	}

	/**
	* <b>name:</b> changeNameTeam <br>
	* Change the name of any team. <br>
	* <b>post:</b> The name of the team has change. <br>
	* @param nameTeam is the new name of any team. nameTeam != null y nameTeam != "".
	* @param team is the number of a team. team == 1 o team == 2.
	* @return <code>String</code> specifying message is the result of change the team's name.
	*/

	public String changeNameTeam(String nameTeam, int team){

		String message = "";

		if(team == 1){
			message = team1.changeNameTeam(nameTeam);
		}
		else if(team == 2){
			message = team2.changeNameTeam(nameTeam);
		}

		return message;
	}

	/**
	* <b>name:</b> getName <br>
	* Gets the club name.
	* <b>post:</b> gets the club name.
	* @return <code>String</code> specifying name is the name of the club.
	*/

	public String getName(){
		return name;
	}

	/**
	* <b>name:</b> setName <br>
	* Alters the club name.
	* <b>post:</b> alters the club name.
	* @param name Is the new name of the club.
	*/

	public void setName(String name){
		this.name = name;
	}

	/**
	* <b>name:</b> getNit <br>
	* Gets the identificator of the club.
	* <b>post:</b> gets the identificator of the club.
	* @return <code>String</code> specifying nit is the identificator of the club.
	*/

	public String getNit(){
		return nit;
	}

	/**
	* <b>name:</b> setNit <br>
	* Alters the identificator of the club.
	* <b>post:</b> alters the identificator of the club.
	* @param nit Is the new identificator of the club.
	*/

	public void setNit(String nit){
		this.nit = nit;
	}

	/**
	* <b>name:</b> getDate <br>
	* Gets the date of creation of the club.
	* <b>post:</b> gets the date of creation of the club.
	* @return <code>String</code> specifying date is the date of cretion of the club.
	*/

	public String getDate(){
		return date;
	}

	/**
	* <b>name:</b> setDate <br>
	* Alters the date of creation of the club.
	* <b>post:</b> alters the date of creation of the club.
	* @param date Is the new date of creation of the club.
	*/

	public void setDate(String date){
		this.date = date;
	}

	/**
	* <b>name:</b> showNames <br>
	* Do a message with the names of the teams.
	* <b>post:</b> show a message with the names of the teams.
	* @return <code>String</code> specifying message is the names of the teams.
	*/

	public String showNames(){

		String message = "";

		message = "*****************************\n"+
				  "* A que equipo pertenece? \n*"+
				  "*****************************\n"+
				  "* (1) "+team1.getName()+"\n"+
				  "* (2) "+team2.getName()+"\n"+
				  "*****************************";

		return message;
	}

	/**
	* <b>name:</b> showEmployee <br>
	* Search a employee an do a message with her information. <br>
	* <b>post:</b> send a message with the information of the employee.
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @return <code>String</code> specifying message is the information of the employee.
	*/ 

	public String showEmployee(String name, String id){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof HeadCoach){

			message = ((HeadCoach)objEmployee).toString();
		}
		else if(objEmployee != null && objEmployee instanceof TechnicalAssistant){

			message = ((TechnicalAssistant)objEmployee).toString();
		}
		else if(objEmployee != null && objEmployee instanceof Player){

			message = ((Player)objEmployee).toString();
		}

		return message;
	}

	/**
	* <b>name:</b> showEdifice <br>
	* Do a message with the information of the office and the dressing rooms. <br>
	* <b>post:</b> Send a message with the information of the office and the dressing rooms.
	* @return <code>String</code> specifying message is the information of the office and the dressing rooms.
	*/

	public String showEdifice(){

		String message = "";

		message += "************************************************************************\n"+
				   "*                               OFICINAS                               *\n"+
				   "************************************************************************\n";

		for(int i=0;i<SIX;i++){
			for(int j=0;j<SIX;j++){
				if(office[i][j] == null){
					message += "[Vacio]";
				}
				else if(office[i][j] != null){
					message += "["+office[i][j].getName()+"]";	
				}
			}
			message +="\n";
		}

		message += "************************************************************************\n"+
				   "*                               CAMERINOS                              *\n"+
				   "************************************************************************\n";

		message += "\n************************************************************************\n"+
				   "** Equipo: "+team1.getName()+"\n"+
				   "\n************************************************************************\n";

		message += team1.showDressing(SEVEN,SEVEN)+"\n";

		message += "\n************************************************************************\n"+
				   "** Equipo: "+team2.getName()+"\n"+
				   "\n************************************************************************\n";

		message += team2.showDressing(SIX,SEVEN);

		return message;
	}

	/**
	* <b>name:</b> showTeam <br>
	* Do a message with the information of any team. <br>
	* <b>post:</b> Send a message with the information of any team.
	* @param team is the number who identifies the team. team == 1 o team == 2.
	* @return <code>String</code> specifying message is the information of a team.
	*/

	public String showTeam(int team){

		String message = "";

		if(team == 1){
			message = team1.toString();
		}
		else if(team == 2){
			message = team2.toString();
		}

		return message;
	}

	/**
	* <b>name:</b> showTeams <br>
	* Do a message with the information of the teams. <br>
	* <b>post:</b> Send a message with the information of the teams.
	* @return <code>String</code> specifying message is the information of the teams.
	*/

	public String showTeams(){

		String message = "";

		message += team1.toString();
		message += team2.toString();

		return message;
	}

	/**
	* <b>name:</b> addFormation <br>
	* Add a new line up for a team. <br>
	* <b>post:</b> save the new line up for a team.
	* @param team is the number who identifies the teams. team == 1 o team == 2.
	* @param way is the number who idenfies the tactics. way greater or equal than 1 y way less or equal than 4.
	* @param date is the date of utilization of line up. date != null y date != "".
	* @param forward is the number of forwards in the line up. forward greater than 0.
	* @param midfielder is the number of midfielders in the line up. midfielder greater than 0.
	* @param defender is the number of defenders in the line up. defender greater than 0.
	* @return <code>String</code> specifying message is the result for add a line up.
	*/

	public String addFormation(int team, int way, String date, int forward, int midfielder, int defender){

		String message = "";
		int x = 1;
		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;
		int forward2 = 0;
		int midfielder2 = 0;
		int defender2 = 0;

		int[][] lineUp = new int[TEN][SEVEN];

		for(int i = 0;i<TEN;i++){

            if(i == 1 || i == 2){
                for(int j = 0;j<SEVEN && cont1<forward;j++){
                    if(lineUp[i][j] == 0){	
                    	lineUp[i][j] = x;
                    	cont1++;
                    }
                }
            }
            else if(i == 4 || i == 5){
                for(int j = 0;j<SEVEN && cont2<midfielder;j++){
                    if(lineUp[i][j] == 0){	
                    	lineUp[i][j] = x;
                    	cont2++;
                    }
                }
            }
            else if(i == 7 || i == 8 || i == 9){
                for(int j = 0;j<SEVEN && cont3<defender;j++){
                    if(lineUp[i][j] == 0){	
                    	lineUp[i][j] = x;
                    	cont3++;
                    }
                }
            }    
		}	

		for(int i = 0;i<TEN;i++){

            if(i == 1 || i == 2 || i == 3){
                for(int j = 0;j<SEVEN;j++){
                    if(lineUp[i][j] == x && j<forward){	
                    	forward2++;
                    }
                }
            }
            else if(i == 4 || i == 5 || i == 6){
                for(int j = 0;j<SEVEN;j++){
                    if(lineUp[i][j] == x && j<midfielder){	
                    	midfielder2++;
                    }
                }
            }
            else if(i == 7 || i == 8 || i == 9){
                for(int j = 0;j<SEVEN;j++){
                    if(lineUp[i][j] == x && j<defender){	
                    	defender2++;
                    }
                }
            }    
		}	

		if(team == 1){
			message = team1.addFormation(way,date,forward2,midfielder2,defender2);
		}
		else if(team == 2){
			message = team2.addFormation(way,date,forward2,midfielder2,defender2);
		}

		return message;
	}
}