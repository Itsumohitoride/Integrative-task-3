package model;

public class Player extends Employee{

	//Attribute 

	private String tshirtNumber;
	private double calification;
	private int goals;
	private Position position;

	public Player(String name, String id, double salary, String tshirtNumber, int position){

		super(name,id,salary);
		this.tshirtNumber = tshirtNumber;
		switch(position){
			case 1:
			this.position = Position.GOALKEEPER;
			break;
			case 2:
			this.position = Position.DEFENDER;
			break;
			case 3:
			this.position = Position.MIDFIELDER;
			break;
			case 4:
			this.position = Position.FORWARD;
			break;
		}
		this.calification = 0;
		this.goals = 0;
	}

	public String hireEmployee(){

	}

	public String getTshirtNumber(){
		return tshirtNumber;
	}

	public void setTshirtNumber(String tshirtNumber){
		this.tshirtNumber = tshirtNumber;
	}

	public double getCalification(){
		return calification;
	}

	public void setCalification(double calification){
		this.calification = calification
	}

	public int getGoals(){
		return goals;
	}

	public void setGoals(int goals){
		this.goals = goals;
	}
}