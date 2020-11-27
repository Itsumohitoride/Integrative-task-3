package model;
import java.util.*;

public class Main{

	//Attribute 

	private String name;
	private String nit;
	private String date;

	//Relation

	private ArrayList<Employee> employee;

	public Main(String name, String nit, String date, String teamA, String teamB){

		employee = new ArrayList<>();
		teamA = new Team(teamA);
		teamB = new Team(teamB);
		this.name = name;
		this.nit = nit;
		this.date = date;
	}

	public Employee findEmployee(String name, String id){

		boolean verific = false;
		Employee objEmployee = null;

		for(int i = 0; i<employee.size() && !verific; i++){
			if(employee.get(i) != null && employee.get(i).getName().equals(name) && employee.get(i).getId().equals(id){
				verific = true;
				objEmployee = employee.get(i);
			}
		}
		return objEmployee;
	}

	public boolean findNumTShirt(String numTShirt, int team){

		boolean verific = false;

		if(team == 1){
			verific = findNumTShirt(numTShirt);
		}else if(team == 2){
			verific = findNumTShirt(numTShirt);
		}
		return verific;
	}

	public String hireEmployee(String name,String id,double salary,int team,String numTShirt,int playerPosition){

		String message = "";

		Employee objEmployee = new Player(name,id,salary,numTShirt,playerPosition);

		if(team == 1){
			message = teamA.hireEmployee(objEmployee);
		}
		else if(team == 2){
			message = teamB.hireEmployee(objEmployee);
		}

		return message;
	}

	public String dismissingEmployee(String name, String id){

		String message = "";

		Employee objEmployee = findEmployee(name,id);

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
}