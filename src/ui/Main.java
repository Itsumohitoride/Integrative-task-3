package ui;
import java.util.*;
import model.*;

public class Main{

	//Attribute

	private Club club;
	public final static String YES = "si";

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
			//changeInformationEmployee();
			break;
			case 4:
			
			break;
			case 5:
			
			break;
			case 6:
			
			break;
			case 7:
			
			break;
			case 8:

			break;
			default:
			System.out.println("**********************************************************************");
			System.out.println("*                  Opcion invalida, digite de nuevo                  *");
			System.out.println("**********************************************************************");
			break;
		}
		return option;
	}

	public void createClub(){

		String name, nit, date, team1, team2;

		System.out.println("Ingrese el nombre del club");
		name = lector.nextLine();

		System.out.println("Ingrese el NIT del club");
		nit = lector.nextLine();

		System.out.println("Ingrese la fecha de fundacion del club");
		date = lector.nextLine();

		System.out.println("Ingrese el nombre del primer equipo");
		team1 = lector.nextLine();

		System.out.println("Ingrese el nombre del segundo equipo");
		team2 = lector.nextLine();

		club = new Club(name,nit,date,team1,team2);
	}

	public void hireEmployee(){

		String name, id, playerProfessional, message, champions, verific, nomExpertise, numTShirt;
		int typeEmployee = 0;
		double salary = 0;
		int yearsExperience = 0;
		int i = 0;
		int team = 0;
		int teams = 0;
		int option = 0;
		int playerPosition = 0;
		boolean player = false;
		Employee findEmployee;
		boolean findNumTShirt = false;
		ArrayList<String> nameChampions = new ArrayList<>();
		ArrayList<String> expertise = new ArrayList<>();

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
			System.out.println("Ingrese el nombre del empleado");
			name = lector.nextLine();

			System.out.println("Ingrese el numero identificador del empleado");
			id = lector.nextLine();

			findEmployee = club.findEmployee(name,id);

			if(findEmployee != null){
				System.out.println("Ya se encuentra registrado un empleado con ese nombre e identificador, registre otro");
			}
		}while(findEmployee != null);

		System.out.println("Ingrese el salario del empleado");
		salary = lector.nextDouble();lector.nextLine();

		if(typeEmployee == 1 || typeEmployee == 2){

			System.out.println("Cuantos años de experiencia tiene el entrenador?");
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

			do{

				System.out.println("Ingrese el nombre del campeonato #"+(i+1)+" conseguido por el entrenador");
				champions = lector.nextLine();

				nameChampions.add(champions);

				System.out.println("Desea ingresas otro campeonato conseguido? (Si/No)");
				verific = lector.nextLine();

				if(verific.equalsIgnoreCase(YES)){
					i++;
				}
			}while(verific.equalsIgnoreCase(YES));

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

				System.out.println("Ingrese el experticio #"+(i+1)+" del asistente tecnico");
				nomExpertise = lector.nextLine();

				expertise.add(nomExpertise);

				System.out.println("Desea ingresas otra experticia? (Si/No)");
				verific = lector.nextLine();

				if(verific.equalsIgnoreCase(YES)){
					i++;
				}
			}while(verific.equalsIgnoreCase(YES));

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

	public void dismissingEmployee(){

		String name, id, message;
		Employee findEmployee;

		System.out.println("************************************************************************");
		System.out.println("*                         DESPEDIR UN EMPLEADO                         *");
		System.out.println("************************************************************************");


		
		do{
			System.out.println("Ingrese el nombre del empleado");
			name = lector.nextLine();

			System.out.println("Ingrese el identificador del empleado");
			id = lector.nextLine();

			findEmployee = club.findEmployee(name,id);

			if(findEmployee == null){
				System.out.println("No se encuentra registrado ningun empleado con esas cualidades, ingrese otro");
			}
		}while(findEmployee == null);

		message = club.dismissingEmployee(name,id);

		System.out.println(message);
	}

	/**
	public void changeInformationEmployee(){

		String message = "";
		String salary, numTShirt, name, id;
		int goals = 0;
		int option = 0;
		int team = 0;
		int option2 = 0;
		double calification = 0;
		Employee findEmployee;

		do{
			System.out.println("Ingrese el nombre del empleado");
			name = lector.nextLine();

			System.out.println("Ingrese el identificador del empleado");
			id = lector.nextLine();

			findEmployee = club.findEmployee(name,id);

			if(findEmployee == null){
				System.out.println("No se encuentra registrado ningun empleado con esas cualidades, ingrese otro");
			}
		}while(findEmployee == null);

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

		message = club.showNames();
		System.out.println(message);

		do{
			team = lector.nextInt();lector.nextLine();

			if(team != 1 && team != 2){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(team != 1 && team != 2);

		switch(option){
			case 1:
			System.out.println("***************************");
			System.out.println("* Que desea cambiar?      *");
			System.out.println("***************************");
			System.out.println("* (1) Salario             *");
			System.out.println("* (2) Años de experiencia *");
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
				salary = lector.nextLine();

				message = club.changeInformationEmployee(name,id,salary,team,option2);
				System.out.println(message);
				break;
				case 2:
				System.out.println("Ingrese los años de experiencia del Entrenador");
				yearsExperience = lector.nextLine();

				message = club.changeInformationEmployee(name,id,salary,team,option2);
				System.out.println(message);
				break;
				case 3:
				System.out.println("Ingrese los equipos a cargo del Entrenador");
				teams = lector.nextInt();

				message = club.changeInformationEmployee(name,id,salary,team,option2);
				System.out.println(message);
				break;
				case 4:
				System.out.println("Ingrese campeonatos logrados del Entrenador");
				champions = lector.nextInt();

				message = club.changeInformationEmployee(name,id,salary,team,option2);
				System.out.println(message);
				break;
			}
			
			break;
			case 2:

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
				salary = lector.nextLine();

				message = club.changeInformationEmployee(name,id,salary,team,option2);
				System.out.println(message);

				break;
				case 2:
				do{
					System.out.println("Ingrese el nuevo numero de camiseta del jugador?");
					numTShirt = lector.nextLine();

					findNumTShirt = club.findNumTShirt(numTShirt,team);

					if(findNumTShirt){
						System.out.println("Un jugador del equipo ya posee ese mismo numero, por favor elija otro");
					}
				}while(findNumTShirt);

				message = club.changeInformationEmployee(name,id,numTShirt,team,option2);
				System.out.println(message);
				break;
				case 3:
				System.out.println("Ingrese los goles del jugador");
				goals = lector.nextInt();lector.nextLine();

				message = club.changeInformationEmployee(name,id,goals,team,option2);
				System.out.println(message);
				break;
				case 4:
				do{

					System.out.println("Ingrese la calificacion");
					calification = lector.nextDouble();

					if(calification<0 || calification>10){
						System.out.println("Ingrese una opcion correcta");
					}

				}while(calification<0 || calification>10);

				message = club.changeInformationEmployee(name,id,calification,team,option2);
				System.out.println(message);
				break;
			}
			break;
		}
	}
	*/
}