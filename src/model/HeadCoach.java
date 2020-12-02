package model;
import java.util.*;

public class HeadCoach extends Coach{

	//Attribute

	private int numTeams;
	private ArrayList<String> nameChampions;

	public HeadCoach(String name, String id, double salary, int yearsExperience, int numTeams, ArrayList<String> nameChampions){

		super(name,id,salary,yearsExperience);
		this.numTeams = numTeams;
		this.nameChampions = nameChampions;
	}

	public int getNumTeams(){
		return numTeams;
	}

	public void setNumTeams(int numTeams){
		this.numTeams = numTeams;
	}

	public ArrayList<String> getNameChampions(){
		return nameChampions;
	}

	public void setNameChampions(ArrayList<String> nameChampions){
		this.nameChampions = nameChampions;
	}

	@Override 

	public String toString(){

		String message = "";
		String messageChampions = "";

		for(int i = 0; i<nameChampions.size(); i++){
			if (nameChampions.get(i) != null){
				messageChampions += nameChampions.get(i)+",";
			}
		}

		message = super.toString()+
				  "\n** Equipos a cargo: "+numTeams+
				  "\n** Campeonatos conseguidos: "+messageChampions+
				  "\n************************************************************************";

		return message;
	}
}