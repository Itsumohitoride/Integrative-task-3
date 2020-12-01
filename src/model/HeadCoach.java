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

	public int getNameChampions(){
		return nameChampions;
	}

	public void setNameChampions(ArrayList nameChampions){
		this.nameChampions = nameChampions;
	}
}