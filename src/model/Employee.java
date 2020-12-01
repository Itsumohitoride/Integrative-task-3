package model;

public class Employee{

	//Attribute

	private String name;
	private String id;
	private int salary;
	private State state;

	public Employee(String name, String id, double salary){

		this.name = name;
		this.id = id;
		this.salary = salary;
		this.state = State.ACTIVE;
	}

	public void changeState(){
		setState(State.INACTIVE);
	}

	public String changeInformationEmployee(){

		String message = "";

		if(objEmployee != null && objEmployee instanceof HeadCoach && option == 1){
			if(option2 == 1){

			}
			else if(option2 == 2){

			}
			else if(option2 == 3){

			}
			else if(option2 == 4){

			}
		}
		else if(objEmployee != null && objEmployee instanceof TechnicalAssistant && option == 2){

		}
		else if(objEmployee != null && objEmployee instanceof Player && option == 3){

		}

		return message;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public double getSalary(){
		return salary;
	}

	public void setSalary(double salary){
		this.salary = salary;
	}

	public State getState(){
		return state;
	}

	public void setState(State state){
		this.state = state;
	}
}