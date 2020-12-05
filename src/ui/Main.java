package ui;
import java.util.*;
import model.*;

public class Main{

	//Attribute

	private Club club;
	public final static String YES = "si";
	public final static int SIX = 6;

	//Global variable

	public Scanner lector;

	/**
	*<b>name:</b> Main <br>
	* Initializes the sccaner and the object mcs <br>
	* <b>post:</b> create an object mcs. <br>
	*/

	public Main(){

		lector = new Scanner(System.in);
		createClub();
	}

	public static void main(String[] args){

		Main objMain = new Main();
		int option = 0;

		do{
			option = objMain.menu();
		}while(option != 0);
	}

	/**
	*<b>name:</b> menu <br>
	* Select and option to do an action. <br>
	* <b>post:</b> send the option. <br>
	* @return <code>int</code> specifying option is the selecction of the user to do an action.
	*/

	public int menu(){

		int option;

		System.out.println("*********************************************");
		System.out.println("*                  MENU                     *");
		System.out.println("*********************************************");
		System.out.println("* Que desea hacer?:                         *");
		System.out.println("* (1) Contratar un empleado                 *");
		System.out.println("* (2) Despedir un empleado                  *");
		System.out.println("* (3) Actualizar informacion de un empleado *");
		System.out.println("* (4) Buscar un empleado                    *");
		System.out.println("* (5) Mostrar los edificios                 *");
		System.out.println("* (6) Agregar una formacion                 *");
		System.out.println("* (7) Mostrar un equipo                     *");
		System.out.println("* (8) Mostrar los equipos                   *");
		System.out.println("* (9) Cambiar informacion de equipo         *");
		System.out.println("* (10) Mostrar informacion del club         *");
		System.out.println("* (0) Salir                                 *");
		System.out.println("*********************************************");
		option = lector.nextInt();lector.nextLine();

		switch(option){
			case 0:
			System.out.println("***********************************************************************");
			System.out.println("*                Gracias por utilizar nuestro software                *");
			System.out.println("***********************************************************************");
			break;
			case 1:
			hireEmployee();
			break;
			case 2:
			dismissingEmployee();
			break;
			case 3:
			changeInformationEmployee();
			break;
			case 4:
			showEmployee();
			break;
			case 5:
			showEdifice();
			break;
			case 6:
			addFormation();
			break;
			case 7:
			showTeam();
			break;
			case 8:
			showTeams();
			break;
			case 9:
			changeTeam();
			break;
			case 10:
			showClub();
			break;
			default:
			System.out.println("**********************************************************************");
			System.out.println("*                  Opcion invalida, digite de nuevo                  *");
			System.out.println("**********************************************************************");
			break;
		}
		return option;
	}

	/**
	*<b>name:</b> createClub <br>
	* inicializate the name, date of creation and the names of the teams, and crate an object club. <br>
	* <b>post:</b> the object club is create, with two teams. <br>
	*/

	public void createClub(){

		String name, nit, date, team1, team2;

		System.out.println("**********************************************************************");
		System.out.println("*                           CLUB DEPORTIVO                           *");
		System.out.println("**********************************************************************");

		System.out.println("Ingrese el nombre del club");
		name = lector.nextLine();

		System.out.println("Ingrese el NIT del club");
		nit = lector.nextLine();

		System.out.println("Ingrese la fecha de fundacion del club (DD/MM/ANIO)");
		date = lector.nextLine();

		System.out.println("Ingrese el nombre del primer equipo");
		team1 = lector.nextLine();

		System.out.println("Ingrese el nombre del segundo equipo");
		team2 = lector.nextLine();

		club = new Club(name,nit,date,team1,team2);
	}

	/**
	* <b>name:</b> hireEmployee <br>
	* Hire an employee and put then in a team. <br>
	* <b>post:</b> save the employee in the team. <br>
	*/

	public void hireEmployee(){

		String name, id, playerProfessional, message, champions, numTShirt, optionToContinue, election;
		int typeEmployee = 0;
		double salary = 0;
		int yearsExperience = 0;
		int team = 0;
		int teams = 0;
		int option = 0;
		int playerPosition = 0;
		int typeExpertise = 0;
		int calification = 0;
		int i = 0;
		boolean player = false;
		boolean findEmployee = false;
		boolean findNumTShirt = false;
		boolean verific = false;
		ArrayList<String> nameChampions = new ArrayList<>();
		int[] expertise = new int[SIX];

		System.out.println("***********************************************************************");
		System.out.println("*                        CONTRATAR UN EMPLEADO                        *");
		System.out.println("***********************************************************************");

		System.out.println("****************************");
		System.out.println("* Que tipo de empleado es? *");
		System.out.println("****************************");
		System.out.println("* (1) Entrenador principal *");
		System.out.println("* (2) Entrenador asistente *");
		System.out.println("* (3) Jugador              *");
		System.out.println("****************************");

		do{
			
			typeEmployee = lector.nextInt();lector.nextLine();

			if(typeEmployee != 1 && typeEmployee != 2 && typeEmployee != 3){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(typeEmployee != 1 && typeEmployee != 2 && typeEmployee != 3);

		do{
			System.out.println("Ingrese el nombre completo del empleado");
			name = lector.nextLine();

			System.out.println("Ingrese el numero identificador del empleado");
			id = lector.nextLine();

			findEmployee = club.findEmployee(name,id);

			if(findEmployee){
				System.out.println("Ya se encuentra registrado un empleado con ese nombre e identificador, registre otro");
			}
		}while(findEmployee);

		System.out.println("Ingrese el salario del empleado");
		salary = lector.nextDouble();lector.nextLine();

		if(typeEmployee == 1 || typeEmployee == 2){

			System.out.println("Cuantos anios de experiencia tiene el entrenador?");
			yearsExperience = lector.nextInt();
		}

		message = club.showNames();
		System.out.println(message);

		do{
			team = lector.nextInt();lector.nextLine();

			if(team != 1 && team != 2){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(team != 1 && team != 2);

		switch(typeEmployee){
			case 1:

			System.out.println("Cuantos equipos tiene acargo el entrenador?");
			teams = lector.nextInt();lector.nextLine();

			System.out.println("El entrenador tiene campeonatos conseguidos? (si/no)");
			election = lector.nextLine();

			if(election.equalsIgnoreCase(YES)){
				do{

					System.out.println("Ingrese el nombre del campeonato #"+(i+1)+" conseguido por el entrenador");
					champions = lector.nextLine();

					nameChampions.add(champions);

					System.out.println("Desea ingresas otro campeonato conseguido? (Si/No)");
					optionToContinue = lector.nextLine();

					if(optionToContinue.equalsIgnoreCase(YES)){
						i++;
					}
				}while(optionToContinue.equalsIgnoreCase(YES));
			}

			message = club.hireEmployee(name,id,salary,yearsExperience,team,teams,nameChampions);

			System.out.println(message);
			break;
			case 2:

			System.out.println("********************************************************");
			System.out.println("* El asistente tecnico ha sido un jugador profesional? *");
			System.out.println("********************************************************");
			System.out.println("* (1) Si                                               *");
			System.out.println("* (2) No                                               *");
			System.out.println("********************************************************");

			do{
				option = lector.nextInt();lector.nextLine();

				if(option != 1 && option != 2){

					System.out.println("Opcion invalida, digitela de nuevo");
				}
			}while(option != 1 && option != 2);

			if(option == 1){
				player = true;
			}

			do{

				System.out.println("Ingrese el numero de experticies (entre 1 y 6)");
				calification = lector.nextInt();

				if(calification<0 || calification>=6){
					System.out.println("Ingrese una opcion correcta");
				}

			}while(calification<0 || calification>=6);

			

			for(int p = 0; p<calification; p++){

				do{	
					do{

						System.out.println("****************************");
						System.out.println("* Que experticie tiene?    *");
						System.out.println("****************************");
						System.out.println("* (1) Ofensivo             *");
						System.out.println("* (2) Defensivo            *");
						System.out.println("* (3) Posesion             *");
						System.out.println("* (4) Jugadas de lab.      *");
						System.out.println("* (5) Fisico               *");
						System.out.println("* (6) Asistente medico     *");
						System.out.println("****************************");
						
						typeExpertise = lector.nextInt();

						for(int k = 0;k<calification && !verific; k++){
							if(typeExpertise == expertise[k]){
								verific = true;
							}
						}

						if(verific){
							System.out.println("Ingrese una experticie diferente de las ya registradas");
						}
						else if(!verific){
							expertise[p] = typeExpertise;
						}

					}while(verific);
				}while(typeExpertise != 1 && typeExpertise != 2 && typeExpertise != 3 && typeExpertise != 4 && typeExpertise != 5 && typeExpertise != 6);
			}

			message = club.hireEmployee(name,id,salary,yearsExperience,team,player,expertise);

			System.out.println(message);
			break;
			case 3:

			do{
				System.out.println("Cual es el numero de camiseta del jugador?");
				numTShirt = lector.nextLine();

				findNumTShirt = club.findNumTShirt(numTShirt,team);

				if(findNumTShirt){
					System.out.println("Un jugador del equipo ya posee ese mismo numero, por favor elija otro");
				}
			}while(findNumTShirt);

			System.out.println("****************************************************************");
			System.out.println("* Cual es la posicion dentro del terreno de juego del jugador? *");
			System.out.println("****************************************************************");
			System.out.println("* (1) Portero                                                  *");
			System.out.println("* (2) Defensor                                                 *");
			System.out.println("* (3) Volante                                                  *");
			System.out.println("* (4) Delantero                                                *");
			System.out.println("****************************************************************");

			do{
				playerPosition = lector.nextInt();lector.nextLine();

				if(playerPosition != 1 && playerPosition != 2 && playerPosition != 3 && playerPosition != 4){

					System.out.println("Opcion invalida, digitela de nuevo");
				}
			}while(playerPosition != 1 && playerPosition != 2 && playerPosition != 3 && playerPosition != 4);

			message = club.hireEmployee(name,id,salary,team,numTShirt,playerPosition);

			System.out.println(message);
			break;
		}
	}

	/**
	* <b>name:</b> dismissingEmployee <br>
	* Dismiss an employee and change the state of then to inactive, and remove from the team.
	* <b>post:</b> Remove the employee of the team and change her state.
	*/

	public void dismissingEmployee(){

		String name, id, message;
		boolean findEmployee = false;

		System.out.println("************************************************************************");
		System.out.println("*                         DESPEDIR UN EMPLEADO                         *");
		System.out.println("************************************************************************");

		do{
			System.out.println("Ingrese el nombre completo del empleado");
			name = lector.nextLine();

			System.out.println("Ingrese el identificador del empleado");
			id = lector.nextLine();

			findEmployee = club.findEmployee(name,id);

			if(!findEmployee){
				System.out.println("No se encuentra registrado ningun empleado con esas cualidades, ingrese otro");
			}
		}while(!findEmployee);

		message = club.dismissingEmployee(name,id);

		System.out.println(message);
	}

	/**
	* <b>name:</b> changeInformationEmployee <br>
	* Change the information of an employee <br>
	* <b>post:</b> Save the changes of the employee's information.
	*/

	public void changeInformationEmployee(){

		String message = "";
		String numTShirt, name, id, champions;
		int goals = 0;
		int option = 0;
		int team = 0;
		int teams = 0;
		int option2 = 0;
		int yearsExperience = 0;
		int typeExpertise = 0;
		double salary = 0;
		double calification = 0;
		boolean findEmployee = false;
		boolean findNumTShirt = false;

		do{
			System.out.println("Ingrese el nombre completo del empleado");
			name = lector.nextLine();

			System.out.println("Ingrese el identificador del empleado");
			id = lector.nextLine();

			findEmployee = club.findEmployee(name,id);

			if(!findEmployee){
				System.out.println("No se encuentra registrado ningun empleado con esas cualidades, ingrese otro");
			}
		}while(!findEmployee);

		System.out.println("******************************");
		System.out.println("* Que tipo de empleado es?   *");
		System.out.println("******************************");
		System.out.println("* (1) Enternador principal   *");
		System.out.println("* (2) Entrenador asistente   *");
		System.out.println("* (3) Jugador                *");
		System.out.println("******************************");

		do{
			option = lector.nextInt();lector.nextLine();

			if(option != 1 && option != 2 && option != 3){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(option != 1 && option != 2 && option != 3);

		switch(option){
			case 1:
			System.out.println("***************************");
			System.out.println("* Que desea cambiar?      *");
			System.out.println("***************************");
			System.out.println("* (1) Salario             *");
			System.out.println("* (2) Anios de experiencia*");
			System.out.println("* (3) Equipos a cargo     *");
			System.out.println("* (4) campeonatos logrados*");
			System.out.println("***************************");

			do{
				option2 = lector.nextInt();lector.nextLine();

				if(option2 != 1 && option2 != 2 && option2 != 3 && option2 != 4){

					System.out.println("Opcion invalida, digitela de nuevo");
				}
			}while(option2 != 1 && option2 != 2 && option2 != 3 && option2 != 4);

			switch(option2){
				case 1:
				System.out.println("Ingrese el nuevo salario del Entrenador");
				salary = lector.nextDouble();lector.nextLine();

				message = club.changeSalary(name,id,salary);
				System.out.println(message);
				break;
				case 2:
				System.out.println("Ingrese los años de experiencia del Entrenador");
				yearsExperience = lector.nextInt();lector.nextLine();

				message = club.changeYearsExperience(name,id,yearsExperience);
				System.out.println(message);
				break;
				case 3:
				System.out.println("Ingrese el numero de equipos a cargo del Entrenador");
				teams = lector.nextInt();lector.nextLine();

				message = club.changeTeams(name,id,teams);
				System.out.println(message);
				break;
				case 4:
				System.out.println("Ingrese el campeonato logrado que va a agregar del Entrenador");
				champions = lector.nextLine();

				message = club.changeChampions(name,id,champions);
				System.out.println(message);
				break;
			}
			
			break;
			case 2:
			System.out.println("***************************");
			System.out.println("* Que desea cambiar?      *");
			System.out.println("***************************");
			System.out.println("* (1) Salario             *");
			System.out.println("* (2) Anios de experiencia*");
			System.out.println("* (3) Experticias         *");
			System.out.println("***************************");

			do{
				option2 = lector.nextInt();lector.nextLine();

				if(option2 != 1 && option2 != 2 && option2 != 3){

					System.out.println("Opcion invalida, digitela de nuevo");
				}
			}while(option2 != 1 && option2 != 2 && option2 != 3);

			switch(option2){
				case 1:
				System.out.println("Ingrese el nuevo salario del jugador");
				salary = lector.nextDouble();lector.nextLine();

				message = club.changeSalary(name,id,salary);
				System.out.println(message);
				break;
				case 2:
				System.out.println("Ingrese los años de experiencia del Entrenador");
				yearsExperience = lector.nextInt();lector.nextLine();

				message = club.changeYearsExperience(name,id,yearsExperience);
				System.out.println(message);
				break;
				case 3:
				System.out.println("Recuerde que si el entrenador asistente ya posee la experticie no se agregara\n");
				System.out.println("*********************************");
				System.out.println("* Que experticie desea agregar? *");
				System.out.println("*********************************");
				System.out.println("* (1) Ofensivo                  *");
				System.out.println("* (2) Defensivo                 *");
				System.out.println("* (3) Posesion                  *");
				System.out.println("* (4) Jugadas de lab.           *");
				System.out.println("* (5) Fisico                    *");
				System.out.println("* (6) Asistente medico          *");
				System.out.println("*********************************");

				do{	
					typeExpertise = lector.nextInt();

					if(typeExpertise != 1 && typeExpertise != 2 && typeExpertise != 3 && typeExpertise != 4 && typeExpertise != 5 && typeExpertise != 6){
						System.out.println("Ingrese una opcion valida");
					}
				}while(typeExpertise != 1 && typeExpertise != 2 && typeExpertise != 3 && typeExpertise != 4 && typeExpertise != 5 && typeExpertise != 6);

				message = club.changeExpertise(name,id,typeExpertise);

				System.out.println(message);
				break;
			}
			break;
			case 3:
			System.out.println("***************************");
			System.out.println("* Que desea cambiar?      *");
			System.out.println("***************************");
			System.out.println("* (1) Salario             *");
			System.out.println("* (2) Numero de la camisa *");
			System.out.println("* (3) Goles               *");
			System.out.println("* (4) Calificacion        *");
			System.out.println("***************************");

			do{
				option2 = lector.nextInt();lector.nextLine();

				if(option2 != 1 && option2 != 2 && option2 != 3 && option2 != 4){

					System.out.println("Opcion invalida, digitela de nuevo");
				}
			}while(option2 != 1 && option2 != 2 && option2 != 3 && option2 != 4);

			switch(option2){
				case 1:
				System.out.println("Ingrese el nuevo salario del jugador");
				salary = lector.nextDouble();

				message = club.changeSalary(name,id,salary);
				System.out.println(message);
				break;
				case 2:
				do{
						System.out.println("Ingrese el nuevo numero de camiseta del jugador");
					numTShirt = lector.nextLine();

					team = club.findTeam(name,id);

					findNumTShirt = club.findNumTShirt(numTShirt,team);

					if(findNumTShirt){
						System.out.println("Un jugador del equipo ya posee ese mismo numero, por favor elija otro");
					}
				}while(findNumTShirt);

				message = club.changeNumPlayer(name,id,numTShirt);
				System.out.println(message);
				break;
				case 3:
				System.out.println("Ingrese los goles del jugador");
				goals = lector.nextInt();lector.nextLine();

				message = club.changeGoals(name,id,goals);
				System.out.println(message);
				break;
				case 4:
				do{

					System.out.println("Ingrese la calificacion (entre 1 y 10)");
					calification = lector.nextDouble();

					if(calification>=1 || calification<=10){
						System.out.println("Ingrese una opcion correcta");
					}

				}while(calification>=1 || calification<=10);

				message = club.changeCalification(name,id,calification);
				System.out.println(message);
				break;
			}
			break;
		}
	}

	/**
	* <b>name:</b> showEmployee <br>
	* Find and show the information of an employee <br>
	* <b>post:</b> Print the information of the employee. <br>
 	*/

	public void showEmployee(){

		String name, id, message;
		Employee objEmployee = null;

		System.out.println("************************************************************************");
		System.out.println("*                          BUSCAR UN EMPLEADO                          *");
		System.out.println("************************************************************************");

		do{
			System.out.println("Ingrese el nombre completo del empleado");
			name = lector.nextLine();

			System.out.println("Ingrese el identificador del empleado");
			id = lector.nextLine();

			objEmployee = club.objFindEmployee(name,id);
			if(objEmployee == null){
				System.out.println("No se encuentra registrado ningun empleado con esas cualidades, ingrese otro");
			}
		}while(objEmployee == null);

		message = club.showEmployee(name,id);

		System.out.println(message);
	}

	/**
	* <b>name:</b> showEdifice <br>
	* Show the information of the dressing rooms of the players and the office's coachs. <br>
	* <b>post:</b> Print the information of the dressing rooms of the players and the office's coachs. <br>
	*/

	public void showEdifice(){

		String message;

		System.out.println("************************************************************************");
		System.out.println("*                               EDIFICIOS                              *");
		System.out.println("************************************************************************");

		message = club.showEdifice();

		System.out.println(message);
	}

	/**
	* <b>name:</b> showTeam <br>
	* Find and show all the information of any team.
	* <b>pos:</b> Show the information of the team.
	*/

	public void showTeam(){

		String message;
		int team = 0;

		message = club.showNames();
		System.out.println(message);

		do{
			team = lector.nextInt();lector.nextLine();

			if(team != 1 && team != 2){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(team != 1 && team != 2);

		message = club.showTeam(team);

		System.out.println(message);
	}

	/**
	* <b>name:</b> showTeams <br>
	* Find and show all the information of the teams.
	* <b>post:</b> Print the information of the teams.
	*/

	public void showTeams(){

		String message;

		message = club.showTeams();

		System.out.println(message);
	}

	/**
	* <b>name:</b> addFormation <br>
	* Add a line up to a team.
	* <b>post:</b> Save the line up for a team.
 	*/

	public void addFormation(){

		String message, date;
		int forward = 0;
		int midfielder = 0;
		int defender = 0;
		int team = 0;
		int way = 0;

		System.out.println("************************************************************************");
		System.out.println("*                               FORMACION                              *");
		System.out.println("************************************************************************");

		message = club.showNames();
		System.out.println(message);

		do{
			team = lector.nextInt();lector.nextLine();

			if(team != 1 && team != 2){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(team != 1 && team != 2);

		System.out.println("***************************");
		System.out.println("* Que tipo de tactica es? *");
		System.out.println("***************************");
		System.out.println("* (1) Posesion            *");
		System.out.println("* (2) Contraataque        *");
		System.out.println("* (3) Presion alta        *");
		System.out.println("* (4) Por defecto         *");
		System.out.println("***************************");

		do{
			way = lector.nextInt();lector.nextLine();

			if(way != 1 && way != 2  && way != 3  && way != 4){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(way != 1 && way != 2  && way != 3  && way != 4);

		System.out.println("Ingrese la fecha de cuando se va a jugar con la alineacion");
		date = lector.nextLine();

		System.out.println("Ingrese cuantos delanteros tiene la formacion");

		do{
			forward = lector.nextInt();

			if(forward<1){
				System.out.println("Tiene que haber por lo menos un delantero");
			}
		}while(forward<1);

		System.out.println("Ingrese cuantos volantes tiene la formacion");

		do{
			midfielder = lector.nextInt();

			if(midfielder<1){
				System.out.println("Tiene que haber por lo menos un volante");
			}
		}while(midfielder<1);

		System.out.println("Ingrese cuantas defensas tiene la formacion");

		do{
			defender = lector.nextInt();

			if(defender<1){
				System.out.println("Tiene que haber por lo menos un defensa");
			}
		}while(defender<1);


		message = club.addFormation(team,way,date,forward,midfielder,defender);

		System.out.println(message);
	}

	/**
	* <b>name:</b> changeTeam <br>
	* Change the new name of any team. <br>
	* <b>post:</b> Save the new name of any team. <br>
	*/

	public void changeTeam(){

		String message, nameTeam;
		int team = 0;

		System.out.println("************************************************************************");
		System.out.println("*                      Cambio de nombre de equipo                      *");
		System.out.println("************************************************************************");	

		message = club.showNames();
		System.out.println(message);

		do{
			team = lector.nextInt();lector.nextLine();

			if(team != 1 && team != 2){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(team != 1 && team != 2);

		System.out.println("Ingrese el nuevo nombre para el equipo");

		nameTeam = lector.nextLine();

		message = club.changeNameTeam(nameTeam,team);

		System.out.println(message);
	}

	/**
	* <b>name:</b> showClub <br>
	* Show all the information of the club. <br>
	* <b>post:</b> Show all the information of the club. <br>
	*/

	public void showClub(){

		System.out.println("************************************************************************");
		System.out.println("*                         INFORMACION DEL CLUB                         *");
		System.out.println("************************************************************************");

		System.out.println("** Nombre: "+club.getName());
		System.out.println("** Nit: "+club.getNit());
		System.out.println("** Fecha de creacion: "+club.getDate()+"\n");
		System.out.println(club.showTeams());
		System.out.println(club.showEdifice());
	}
}
