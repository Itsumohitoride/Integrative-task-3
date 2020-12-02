package model;

public abstract class Employee{

	//Attribute

	private String name;
	private String id;
	private double salary;
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

	public String changeSalary(double salary){

		String message = "Se cambio exitosamente el salario";

		setSalary(salary);

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

	public String toString(){

		String message = "";

		message = "************************************************************************\n"+
				  "*                              Informacion                             *\n"+
				  "************************************************************************\n"+
				  "** Nombre: "+name+
				  "\n** Identificador: "+id+
				  "\n** Salario: "+(int)salary+
				  "\n** Estado: "+state;
		return message;
	}
}