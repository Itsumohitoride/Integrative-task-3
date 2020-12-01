package model;
import java.util.*;

public class Club{

	//Attribute 

	private String name;
	private String nit;
	private String date;
	private Team team1;
	private Team team2;

	//Relation

	private ArrayList<Employee> employee;

	public Club(String name, String nit, String date, String teamA, String teamB){

		employee = new ArrayList<>();
		team1 = new Team(teamA);
		team2 = new Team(teamB);
		this.name = name;
		this.nit = nit;
		this.date = date;
	}

	public boolean findEmployee(String name, String id){

		boolean verific = false;

		verific = findEmployee(name,id);

		return verific;
	}

	public Employee objFindEmployee(String name, String id){

		Employee objEmployee = null;

		for(int i = 0; i<employee.size() && !verific; i++){
			if(employee.get(i) != null && employee.get(i).getName().equalsIgnoreCase(name) && employee.get(i).getId(i).equalsIgnoreCase(id)){
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

	public String hireEmployee(String name,String id,double salary,int yearsExperience,int team,int teams, ArrayList<String> nameChampions){

		String message = "";

		HeadCoach objEmployee = new HeadCoach(name,id,salary,yearsExperience,teams,nameChampions);

		if(team == 1){
			message = team1.hireEmployee(objEmployee);
		}
		else if(team == 2){
			message = team2.hireEmployee(objEmployee);
		}

		return message;
	}

	public String hireEmployee(String name,String id,double salary, int yearsExperience, int team, boolean professionalPlayer, ArrayList<String> expertise){

		String message = "";

		TechnicalAssistant objEmployee = new TechnicalAssistant(name,id,salary,yearsExperience,professionalPlayer);

		if(team == 1){
			message = team1.hireEmployee(objEmployee);
		}
		else if(team == 2){
			message = team2.hireEmployee(objEmployee);
		}

		return message;
	}

	public String hireEmployee(String name,String id,double salary,int team,String numTShirt,int playerPosition){

		String message = "";

		Player objEmployee = new Player(name,id,salary,numTShirt,playerPosition);

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
	public String changeInformationEmployee(String name, String id, int option, int option2){

		String message = "";

		Employee objEmployee = findEmployee(name,id);

		objEmployee.changeInformationEmployee(option,option2);

		return message;
	}
	*/

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
				  "*****************************\n";

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

}