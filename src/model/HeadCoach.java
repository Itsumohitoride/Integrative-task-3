package model;
import java.util.*;

public class HeadCoach extends Coach implements Level,Price{

	//Attribute

	private int numTeams;
	private ArrayList<String> nameChampions;

	/**
	*<b>name:</b> HeadCoach <br>
	* Create a object  head coach. <br>
	* <b>post:</b> A object head coach has created. <br>
	* @param name is the name of an head coach. name != null y name != "".
	* @param id is the identification of an head coach. id != null y id != "".
	* @param salary is the salary of an head coach. salary greater than 0.
	* @param yearsExperience is the year of experience of an employee. yearsExperience greater than 0.
	* @param numTeams is the number of teams in charge of head coach. teams greater or equal 0.
	* @param nameChampions are the names of the champions achieved by the head coach.
	*/

	public HeadCoach(String name, String id, double salary, int yearsExperience, int numTeams, ArrayList<String> nameChampions){

		super(name,id,salary,yearsExperience);
		this.numTeams = numTeams;
		this.nameChampions = nameChampions;
	}

	/**
	* <b>name:</b> changeTeams <br>
	* Change the number of  teams of a head coach. <br>
	* <b>post:</b> Change the number of  teams of a head coach. <br>
	* @param numTeams is the new number of teams in charge of head coach. numTeams greater or equal 0.
	* @return <code>String</code> specifying message is the result of the change the number of teams in charge of head coach.
	*/

	public String changeTeams(int numTeams){

		String message = "Se agrego correctamente el numero de equipos a cargo del entrenador";

		setNumTeams(numTeams);

		return message;
	}

	/**
	* <b>name:</b> changeChampions <br>
	* Change the new name of the champions achieved by the head coach. <br>
	* <b>post:</b> Change the new name of the champions achieved by the head coach. <br>
	* @param champions is the new name of the champions achieved by the head coach. champions != null y champions != "".
	* @return <code>String</code> specifying message is the result of the change the number of teams in charge of head coach.
	*/

	public String changeChampions(String champions){

		String message = "Se agrego correctamente el campeonato logrado por el entrenador";

		nameChampions.add(champions);

		return message;
	}

	/**
	* <b>name:</b> getNumTeams <br>
	* Gets the number of  teams of a head coach.
	* <b>post:</b> gets the number of  teams of a head coach.
	* @return <code>int</code> specifying numTeams is the number of  teams of a head coach.
	*/

	public int getNumTeams(){
		return numTeams;
	}

	/**
	* <b>name:</b> setNumTeams <br>
	* Alters the number of  teams of a head coach.
	* <b>post:</b> alters the number of  teams of a head coach.
	* @param numTeams Is the new number of  teams of a head coach.
	*/

	public void setNumTeams(int numTeams){
		this.numTeams = numTeams;
	}

	/**
	* <b>name:</b> getNameChampions <br>
	* Gets the name of the champions achieved by the head coach.
	* <b>post:</b> gets the name of the champions achieved by the head coach.
	* @return <code>String</code> specifying nameChampions is the list of names of the champions achieved by the head coach.
	*/

	public ArrayList<String> getNameChampions(){
		return nameChampions;
	}

	/**
	* <b>name:</b> setNameChampions <br>
	* Alters the name of the champions achieved by the head coach.
	* <b>post:</b> alters the name of the champions achieved by the head coach.
	* @param nameChampions Is the new name of the champions achieved by the head coach.
	*/

	public void setNameChampions(ArrayList<String> nameChampions){
		this.nameChampions = nameChampions;
	}

	/**
	* <b>name:</b> calculateLevel <br>
	* Calculate the level of the head coach. <br>
	* <b>post:</b> save the calculation of the level of head coach.
	* @return <code>double</code> specifying level is the level of the head coach.
	*/

	public double calculateLevel(){

		double level = 0;

		level = 5+(nameChampions.size()/10);

		return level; 
	}

	/**
	* <b>name:</b> calculatePrice <br>
	* Calculate the market price of the head coach. <br>
	* <b>post:</b> save the calculation of the market price of head coach.
	* @return <code>double</code> specifying price is the market price of the head coach.
	*/

	public double calculatePrice(){

		double price = 0;

		price = (getSalary()*10)+(getYearsExperience()*100)+(nameChampions.size()*50);

		return price;
	}

	/**
	* <b>name:</b> toString <br>
	* Show a message with the information of the head coach. <br>
	* <b>post:</b> Send a message with the information of the head coach. <br>
	* @return <code>String</code> specifying message is the information of the head coach.
	*/

	@Override 

	public String toString(){

		String message = "";
		String messageChampions = "";

		double level = calculateLevel();
		double price = calculatePrice();

		for(int i = 0; i<nameChampions.size(); i++){
			if (nameChampions.get(i) != null){
				messageChampions += nameChampions.get(i)+",";
			}
		}

		message = super.toString()+
				  "\n** Equipos a cargo: "+numTeams+
				  "\n** Campeonatos conseguidos: "+messageChampions+
				  "\n** Precio en el mercado: "+price+
				  "\n** Nivel del entrenador: "+level+
				  "\n************************************************************************";

		return message;
	}
}