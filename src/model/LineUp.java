package  model;

public class LineUp{

	//Attribute

	private String date;
	private int forward;
	private int midfielder;
	private int defender;
	private Way way;

	/**
	*<b>name:</b> LineUp <br>
	* Create a object LineUp. <br>
	* <b>post:</b> A object LineUp has created. <br>
	* @param way is the number who idenfies the tactics. way greater or equal than 1 y way less or equal than 4.
	* @param date is the date of utilization of line up. date != null y date != "".
	* @param forward is the number of forwards in the line up. forward greater than 0.
	* @param midfielder is the number of midfielders in the line up. midfielder greater than 0.
	* @param defender is the number of defenders in the line up. defender greater than 0.
	*/

	public LineUp(int way, String date, int forward, int midfielder, int defender){

		switch(way){
			case 1:
			this.way = Way.POSSESION;
			break;
			case 2:
			this.way = Way.COUNTERATTACK;
			break;
			case 3:
			this.way = Way.HIGH_PRESSURE;
			break;
			case 4:
			this.way = Way.DEFAULT;
			break;
		}

		this.date = date;
		this.forward = forward;
		this.midfielder = midfielder;
		this.defender = defender;
	}

	/**
	* <b>name:</b> getWay <br>
	* Gets the formation of the line up.
	* <b>post:</b> gets the formation of the line up.
	* @return <code>Way</code> specifying way is the formation of the line up.
	*/

	public Way getWay(){
		return way;
	}

	/**
	* <b>name:</b> setWay <br>
	* Alters the formation of the line up.
	* <b>post:</b> alters the formation of the line up.
	* @param way Is the new formation of the line up.
	*/

	public void setWay(Way way){
		this.way = way;
	}

	/**
	* <b>name:</b> getDate <br>
	* Gets the date of creation of line up.
	* <b>post:</b> gets the date of creation of line up..
	* @return <code>String</code> specifying way is the date of creation of line up..
	*/

	public String getDate(){
		return date;
	}

	/**
	* <b>name:</b> setDate <br>
	* Alters the date of creation of line up.
	* <b>post:</b> alters the date of creation of line up.
	* @param date Is the new date of creation of line up.
	*/

	public void setDate(String date){
		this.date = date;
	}

	/**
	* <b>name:</b> getForward <br>
	* Gets the number of forwards in the line up.
	* <b>post:</b> gets the number of forwards in the line up.
	* @return <code>int</code> specifying forward is the number of forwards in the line up.
	*/

	public int getForward(){
		return forward;
	}

	/**
	* <b>name:</b> setForward <br>
	* Alters the number of forwards in the line up.
	* <b>post:</b> alters the number of forwards in the line up.
	* @param forward Is the new number of forwards in the line up.
	*/

	public void setForward(int forward){
		this.forward = forward;
	}

	/**
	* <b>name:</b> getMidfielder <br>
	* Gets the number of midfielder in the line up.
	* <b>post:</b> gets the number of midfielder in the line up.
	* @return <code>int</code> specifying midfielder is the number of midfielder in the line up.
	*/

	public int getMidfielder(){
		return midfielder;
	}

	/**
	* <b>name:</b> setMidfielder <br>
	* Alters the number of midfielder in the line up.
	* <b>post:</b> alters the number of midfielder in the line up.
	* @param setMidfielder Is the new number of midfielder in the line up.
	*/

	public void setMidfielder(int setMidfielder){
		this.midfielder = midfielder;
	}

	/**
	* <b>name:</b> getDefender <br>
	* Gets the number of defender in the line up.
	* <b>post:</b> gets the number of defender in the line up.
	* @return <code>int</code> specifying defender is the number of defender in the line up.
	*/

	public int getDefender(){
		return defender;
	}

	/**
	* <b>name:</b> setDefender <br>
	* Alters the number of defender in the line up.
	* <b>post:</b> alters the number of defender in the line up.
	* @param defender Is the new number of defender in the line up.
	*/

	public void setDefender(int defender){
		this.defender = defender;
	}

	/**
	* <b>name:</b> toString <br>
	* Show a message with the information of the line up. <br>
	* <b>post:</b> Send a message with the information of the line up. <br>
	* @return <code>String</code> specifying message is the information of the line up.
	*/

	public String toString(){

		String message = "";

		message = "************************************************************************\n"+
				  "*                               Formacion                              *\n"+
				  "************************************************************************"+
				  "\n** Alineacion: "+defender+"-"+midfielder+"-"+forward+
				  "\n** Tactica: "+way+
				  "\n** Fecha: "+date+
				  "\n************************************************************************\n";

		return message;
	}
}