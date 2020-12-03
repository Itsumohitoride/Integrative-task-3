package model;
import java.util.*;

public class Club{

	//Attribute 

	private String name;
	private String nit;
	private String date;
	private Team team1;
	private Team team2;
	public final static int SIX = 6;
	public final static int SEVEN = 7;

	//Relation

	private ArrayList<Employee> employee;
	private Coach[][] office;

	public Club(String name, String nit, String date, String teamA, String teamB){

		employee = new ArrayList<>();
		office = new Coach[SIX][SIX];
		team1 = new Team(teamA);
		team2 = new Team(teamB);
		this.name = name;
		this.nit = nit;
		this.date = date;
	}

	public boolean findEmployee(String name, String id){

		boolean verific = false;

		verific = team1.findEmployee(name,id);

		if(!verific){

			verific = team2.dismissingEmployee(name,id);
		}

		return verific;
	}

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

	public boolean findNumTShirt(String numTShirt, int team){

		boolean verific = false;

		if(team == 1){
			verific = team1.findNumTShirt(numTShirt);
		}else if(team == 2){
			verific = team2.findNumTShirt(numTShirt);
		}
		return verific;
	}

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

	public String changeTeams(String name, String id, int  numTemas){

		String message = "";

		Employee objEmployee = objFindEmployee(name,id);

		if(objEmployee != null && objEmployee instanceof HeadCoach){

			message = ((HeadCoach)objEmployee).changeTeams(numTemas);
		}
		else{
			message = "El empleado tiene que ser un entrenador principal para cambiar este campo";
		}

		return message;
	}

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

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getNit(){
		return nit;
	}

	public void setNit(String nit){
		this.nit = nit;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date = date;
	}

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

		message += "Equipo: "+team1.getName()+"\n";

		message += team1.showDressing(SEVEN,SEVEN)+"\n";

		message += "Equipo: "+team2.getName()+"\n";

		message += team1.showDressing(SIX,SEVEN);

		return message;
	}
}