package model;

public class Player extends Employee implements Level,Price{

	//Attribute 

	private String tshirtNumber;
	private double calification;
	private int goals;

	//Relation

	private Position position;

	/**
	*<b>name:</b> Player <br>
	* Create a object player. <br>
	* <b>post:</b> A object player has created. <br>
	* @param name is the name of an player. name != null y name != "".
	* @param id is the identification of an player. id != null y id != "".
	* @param salary is the salary of an player. salary greater than 0.
	* @param tshirtNumber is the number of a soccer player. tshirtNumber != null y tshirtNumber != "".
	* @param position is the position of the soccer player.
	*/

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

	/**
	* <b>name:</b> changeNumPlayer <br>
	* Change the number t-shirt of a player. <br>
	* <b>post:</b> Change the number t-shirt of a player. <br>
	* @param numPlayer is the number t-shirt of the soccer player. numPlayer != null y numPlayer != "".
	* @return <code>String</code> specifying message is the result of change the number of a player.
	*/

	public String changeNumPlayer(String numPlayer){

		String message = "Se cambio exitosamente el numero de camiseta";

		setTshirtNumber(numPlayer);

		return message;
	}

	/**
	* <b>name:</b> changeGoals <br>
	* Change the number of goals of a player. <br>
	* <b>post:</b> Change the number of goals of a player. <br>
	* @param goals is the number of goals of the soccer player. goals greater or equal 0.
	* @return <code>String</code> specifying message is the result of change the number of goals of a player.
	*/

	public String changeGoals(int goals){

		String message = "Se cambio exitosamente el numero de goles";

		setGoals(goals);

		return message;
	}

	/**
	* <b>name:</b> changeCalification <br>
	* Change the calification of a player. <br>
	* <b>post:</b> Change the calification of a player. <br>
	* @param calification is the new calification of the soccer player. calification greater than 0 y calification less or equal than 10.
	* @return <code>String</code> specifying message is the result of change the calification of a player.
	*/

	public String changeCalification(double calification){

		String message = "Se cambio exitosamente la calificacion";

		setCalification(calification);

		return message;
	}

	/**
	* <b>name:</b> getTshirtNumber <br>
	* Gets the t-shirt number of a soccer player.
	* <b>post:</b> gets t-shirt number of a soccer player.
	* @return <code>String</code> specifying tshirtNumber is the t-shirt number of a soccer player.
	*/

	public String getTshirtNumber(){
		return tshirtNumber;
	}

	/**
	* <b>name:</b> setTshirtNumber <br>
	* Alters the t-shirt number of a soccer player.
	* <b>post:</b> alters the t-shirt number of a soccer player.
	* @param tshirtNumber Is the new t-shirt number of a soccer player.
	*/

	public void setTshirtNumber(String tshirtNumber){
		this.tshirtNumber = tshirtNumber;
	}

	/**
	* <b>name:</b> getCalification <br>
	* Gets the calification of a soccer player.
	* <b>post:</b> gets the calification of a soccer player.
	* @return <code>double</code> specifying calification is calification of a soccer player.
	*/

	public double getCalification(){
		return calification;
	}

	/**
	* <b>name:</b> setCalification <br>
	* Alters the calification of a soccer player.
	* <b>post:</b> alters the calification of a soccer player.
	* @param calification Is the new calification of a soccer player.
	*/

	public void setCalification(double calification){
		this.calification = calification;
	}

	/**
	* <b>name:</b> getGoals <br>
	* Gets the number of goals of a soccer player.
	* <b>post:</b> gets the number of goals of a soccer player.
	* @return <code>int</code> specifying goals is number of goals of a soccer player.
	*/

	public int getGoals(){
		return goals;
	}

	/**
	* <b>name:</b> setGoals <br>
	* Alters the number of goals of a soccer player.
	* <b>post:</b> alters the number of goals of a soccer player.
	* @param goals Is the new number of goals of a soccer player.
	*/

	public void setGoals(int goals){
		this.goals = goals;
	}

	/**
	* <b>name:</b> getPosition <br>
	* Gets the position of a soccer player.
	* <b>post:</b> gets the position of a soccer player.
	* @return <code>Position</code> specifying position is the position of a soccer player.
	*/

	public Position getPosition(){
		return position;
	}

	/**
	* <b>name:</b> setPosition <br>
	* Alters the position of a soccer player.
	* <b>post:</b> alters the position of a soccer player.
	* @param position Is the new position of a soccer player.
	*/

	public void setPosition(Position position){
		this.position = position;
	}

	/**
	* <b>name:</b> calculateLevel <br>
	* Calculate the level of the soccer player. <br>
	* <b>post:</b> save the calculation of the level of soccer player.
	* @return <code>double</code> specifying level is the level of the soccer player.
	*/

	public double calculateLevel(){

		double level = 0;

		if(position == Position.GOALKEEPER){
			level = (calification*0.9);
		}
		else if(position == Position.DEFENDER){
			level = (calification*0.9)+(goals/100);
		}
		else if(position == Position.MIDFIELDER){
			level = (calification*0.9)+(goals/90);
		}
		else if(position == Position.FORWARD){
			level = (calification*0.9)+(goals/80);
		}

		return level;
	}

	/**
	* <b>name:</b> calculatePrice <br>
	* Calculate the market price of the soccer player. <br>
	* <b>post:</b> save the calculation of the market price of soccer player.
	* @return <code>double</code> specifying price is the market price of the soccer player.
	*/

	public double calculatePrice(){

		double price = 0;

		if(position == Position.GOALKEEPER){
			price = (getSalary()*12)+(calification*150);
		}
		else if(position == Position.DEFENDER){
			price = (getSalary()*13)+(calification*125)+(goals*100);
		}
		else if(position == Position.MIDFIELDER){
			price = (getSalary()*14)+(calification*135)+(goals*125);
		}
		else if(position == Position.FORWARD){
			price = (getSalary()*15)+(calification*145)+(goals*150);
		}

		return price;
	}

	/**
	* <b>name:</b> toString <br>
	* Show a message with the information of the player. <br>
	* <b>post:</b> Send a message with the information of the player. <br>
	* @return <code>String</code> specifying message is the information of the player.
	*/

	@Override

	public String toString(){

		String message = "";

		double level = calculateLevel();
		double price = calculatePrice();

		message = super.toString()+
				  "\n** Numero de camisa: "+tshirtNumber+
				  "\n** Posicion: "+position+
				  "\n** Goles: "+goals+
				  "\n** Calificacion: "+calification+
				  "\n** Precio en el mercado: "+price+
				  "\n** Nivel del jugador: "+level+
				  "\n************************************************************************";

		return message;
	}
}