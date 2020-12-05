package model;

public abstract class Coach extends Employee{

	//Attribute

	private int yearsExperience;

	/**
	*<b>name:</b> Coach <br>
	* Create a object Coach. <br>
	* <b>post:</b> A object Coach has created. <br>
	* @param name is the name of an Coach. name != null y name != "".
	* @param id is the identification of an Coach. id != null y id != "".
	* @param salary is the salary of an Coach. salary greater than 0.
	* @param yearsExperience is the year of experience of an employee. yearsExperience greater than 0.
	*/

	public Coach(String name, String id, double salary, int yearsExperience){

		super(name,id,salary);
		this.yearsExperience = yearsExperience;
	}

	/**
	* <b>name:</b> changeYearsExperience <br>
	* Change the years experience of a coach. <br>
	* <b>post:</b> Change the years experience of a coach. <br>
	* @param yearsExperience is the new years of experience of an employee. yearsExperience greater than 0.
	* @return <code>String</code> specifying message is the result of the change the years experience.
	*/

	public String changeYearsExperience(int yearsExperience){

		String message = "Se cambiaron exitosmente los años de experiencia";

		setYearsExperience(yearsExperience);

		return message;
	}

	/**
	* <b>name:</b> getYearsExperience <br>
	* Gets the years of experience of the coach.
	* <b>post:</b> gets the years of experience of the coach.
	* @return <code>int</code> specifying yearsExperience is the the years of experience of the coach.
	*/

	public int getYearsExperience(){
		return yearsExperience;
	}

	/**
	* <b>name:</b> setYearsExperience <br>
	* Alters the years of experience of the coach.
	* <b>post:</b> alters the years of experience of the coach.
	* @param yearsExperience Is the new years of experience of the coach.
	*/

	public void setYearsExperience(int yearsExperience){
		this.yearsExperience = yearsExperience;
	}

	/**
	* <b>name:</b> toString <br>
	* Show a message with the information of the coach. <br>
	* <b>post:</b> Send a message with the information of the coach. <br>
	* @return <code>String</code> specifying message is the information of the coach.
	*/

	@Override

	public String toString(){

		String message = "";

		message = super.toString()+
				  "\n** Anios de experiencia: "+yearsExperience;

		return message;
	}
}