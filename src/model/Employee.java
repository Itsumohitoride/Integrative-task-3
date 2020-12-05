package model;

public abstract class Employee{

	//Attribute

	private String name;
	private String id;
	private double salary;

	//Relation

	private State state;

	/**
	*<b>name:</b> Employee <br>
	* Create a object employee. <br>
	* <b>post:</b> A object employee has created. <br>
	* @param name is the name of an employee. name != null y name != "".
	* @param id is the identification of an employee. id != null y id != "".
	* @param salary is the salary of an employee. salary greater than 0.
	*/

	public Employee(String name, String id, double salary){

		this.name = name;
		this.id = id;
		this.salary = salary;
		this.state = State.ACTIVE;
	}

	/**
	* <b>name:</b> changeState <br>
	* Change the state of an employee. <br>
	* <b>post:</b> Change the state of an employee. <br>
	*/

	public void changeState(){
		setState(State.INACTIVE);
	}

	/**
	* <b>name:</b> changeSalary <br>
	* Change the salary of an employee. <br>
	* <b>post:</b> Change the salary of an employee. <br>
	* @param salary is the salary of an employee. salary greater than 0.
	* @return <code>String</code> specifying message is the result of the change the salary.
	*/

	public String changeSalary(double salary){

		String message = "Se cambio exitosamente el salario";

		setSalary(salary);

		return message;
	}

	/**
	* <b>name:</b> getName <br>
	* Gets the employee name.
	* <b>post:</b> gets the employee name.
	* @return <code>String</code> specifying name is the name of an employee.
	*/

	public String getName(){
		return name;
	}

	/**
	* <b>name:</b> setName <br>
	* Alters the employee name.
	* <b>post:</b> alters the employee name.
	* @param name Is the new name of the employee.
	*/

	public void setName(String name){
		this.name = name;
	}

	/**
	* <b>name:</b> getId <br>
	* Gets the employee identifier.
	* <b>post:</b> gets the employee identifier.
	* @return <code>String</code> specifying id the identifier of an employee.
	*/

	public String getId(){
		return id;
	}

	/**
	* <b>name:</b> setId <br>
	* Alters the employee identifier.
	* <b>post:</b> alters the employee identifier.
	* @param id Is the new identifier of the employee.
	*/


	public void setId(String id){
		this.id = id;
	}

	/**
	* <b>name:</b> getSalary <br>
	* Gets the employee salary.
	* <b>post:</b> gets the employee salary.
	* @return <code>double</code> specifying salary is the salary of an employee.
	*/

	public double getSalary(){
		return salary;
	}

	/**
	* <b>name:</b> setSalary <br>
	* Alters the employee salary.
	* <b>post:</b> alters the employee salary.
	* @param salary Is the new salary of the employee.
	*/

	public void setSalary(double salary){
		this.salary = salary;
	}

	/**
	* <b>name:</b> getState <br>
	* Gets the employee state.
	* <b>post:</b> gets the employee state.
	* @return <code>State</code> specifying state is the state of an employee.
	*/

	public State getState(){
		return state;
	}

	/**
	* <b>name:</b> setState <br>
	* Alters the employee state.
	* <b>post:</b> alters the employee state.
	* @param state Is the new state of the employee.
	*/

	public void setState(State state){
		this.state = state;
	}

	/**
	* <b>name:</b> toString <br>
	* Show a message with the information of the employee. <br>
	* <b>post:</b> Send a message with the information of the employee. <br>
	* @return <code>String</code> specifying message is the information of the employee.
	*/

	public String toString(){

		String message = "";

		message = "\n************************************************************************\n"+
				  "*                              Informacion                             *\n"+
				  "************************************************************************\n"+
				  "** Nombre: "+name+
				  "\n** Identificador: "+id+
				  "\n** Salario: "+(int)salary+
				  "\n** Estado: "+state;
		return message;
	}
}