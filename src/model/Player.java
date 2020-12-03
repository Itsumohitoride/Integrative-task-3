package model;

public class Player extends Employee implements Level,Price{

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

	public String changeNumPlayer(String numPlayer){

		String message = "Se cambio exitosamente el numero de camiseta";

		setTshirtNumber(numPlayer);

		return message;
	}

	public String changeGoals(int goals){

		String message = "Se cambio exitosamente el numero de goles";

		setGoals(goals);

		return message;
	}

	public String changeCalification(double califiction){

		String message = "Se cambio exitosamente la calificacion";

		setCalification(calification);

		return message;
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
		this.calification = calification;
	}

	public int getGoals(){
		return goals;
	}

	public void setGoals(int goals){
		this.goals = goals;
	}

	public Position getPosition(){
		return position;
	}

	public void setPosition(Position position){
		this.position = position;
	}

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

	public double calculatePrice(){

		double price = 0;

		if(position == Position.GOALKEEPER){
			price = (salary*12)+(calification*150);
		}
		else if(position == Position.DEFENDER){
			price = (salary*13)+(calification*125)+(goals*100);
		}
		else if(position == Position.MIDFIELDER){
			price = (salary*14)+(calification*135)+(goals*125);
		}
		else if(position == Position.FORWARD){
			price = (salary*15)+(calification*145)+(goals*150);
		}

		return price;
	}

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