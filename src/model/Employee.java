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

	public String changeYearsExperience(int yearsExperience){

		String message = "Se cambiaron exitosmente los años de experiencia";

		setYearsExperience(yearsExperience);

		return message;
	}

	public String changeExpertise(int expertise){

		String message = "";
		boolean verific = false;
		boolean verificExpertise = false;

		Expertise[] listExpertise = new Expertise[SIX];
		Expertise objExpertise;

		switch(expertise){
			case 1:
			objExpertise = Expertise.OFFENSIVE;
			break;
			case 2:
			objExpertise = Expertise.DEFENSIVE;
			break;
			case 3:
			objExpertise = Expertise.POSSESION;
			break;
			case 4:
			objExpertise = Expertise.LABORATORYPLAYS;
			break;
			case 5:
			objExpertise = Expertise.PHYSICAL_TRAINER;
			break;
			case 6:
			objExpertise = Expertise.MEDICAL_ASSISTANT;
			break;
		}

		for(int i = o; i<SIX; i++){
			if(getExpertise()[i] != null){
				listExpertise[i] = getExpertise()[i];
			}
		}

		for (int k = 0;k<SIX && !verific; k++) {
			if(objExpertise == listExpertise[i]){
				verific = true;
				message = "No se agrego la experticie porque ya la tiene el entrenador asistente";
			}
			else{
				for(int p = 0;p<SIX && !verificExpertise; p++){
					if(listExpertise[i] == null){
						verificExpertise = true;
						listExpertise[i] = objExpertise;
						message = "Se agrego correctamente la experticie";
					}
				}
			}
		}

		return message;
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

		setCalification(calificacion);

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