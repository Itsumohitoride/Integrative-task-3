package ui;
import java.util.Scanner;
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

		System.out.println("******************************************");
		System.out.println("*                  MENU                  *");
		System.out.println("******************************************");
		System.out.println("* Que desea hacer?:                      *");
		System.out.println("* (1) Contratar un empleado              *");
		System.out.println("* (2) Despedir un empleado               *");
		System.out.println("* (3) Ingresar una cancion               *");
		System.out.println("* (4) Mostrar las canciones registradas  *");
		System.out.println("* (5) Crear una play list                *");
		System.out.println("* (6) Agregar canciones a una play list  *");
		System.out.println("* (7) Mostrar las play lists registradas *");
		System.out.println("* (8) Calificar una play list publica    *");
		System.out.println("* (0) Salir                              *");
		System.out.println("******************************************");
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

		String name, nit, date;

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

		String name, id, playerProfessional, message;
		int typeEmployee = 0;
		int salary = 0;
		int i = 0;
		int team = 0;
		boolean player = false;
		ArrayList<String> nameChampions = new ArrayList<>();
		ArrayList<String> expertise = new ArrayList<>();

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

		System.out.println("Ingrese el nombre del empleado");
		name = lector.nextLine();

		System.out.println("Ingrese el numero identificador del empleado");
		id = lector.nextLine();

		System.out.println("Ingrese el salario del empleado");
		salary = lector.nextInt();lector.nextLine();

		if(typeEmployee == 1 || typeEmployee == 2){

			System.out.println("Cuantos años de experiencia tiene el entrenador?");
			yearsExperience = lector.nextInt();
		}

		System.out.println("*****************************");
		System.out.println("* A que equipo va a entrar? *");
		System.out.println("*****************************");
		System.out.println("* (1) A                     *");
		System.out.println("* (2) B                     *");
		System.out.println("*****************************");

		do{
			team = lector.nextInt();lector.nextLine();

			if(team != 1 && team != 2){

				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(team != 1 && team != 2);

		switch(typeEmployee){
			case 1:

			System.out.println("Cuantos equipos tiene acargo el entrenador?");
			teams = lector.nextInt();lectoe.nextLine();

			do{

				System.out.println("Ingrese el nombre del campeonato #"+(i+1)+" conseguido por el entrenador");
				nameChampions[i] = lector.nextLine();

				System.out.println("Desea ingresas otro campeonato conseguido? (Si/No)");
				verific = lector.nextLine();

				if(verific.equalsIgnoreCase(YES)){
					i++;
				}
			}while(verific.equalsIgnoreCase(YES));

			message = hireEmployee(name,id,salary,yearsExperience,team,teams,nameChampions);

			System.out.println(message);
			break;
			case 2:

			System.out.println("El asistente tecnico ha sido un jugador profesional (Si/No)?");
			playerProfessional = lector.nextLine();

			if(verific.equalsIgnoreCase(YES)){
				player = true;
			}

			do{

				System.out.println("Ingrese el experticio #"+(i+1)+" del asistente tecnico");
				expertise[i] = lector.nextLine();

				System.out.println("Desea ingresas otra experticia? (Si/No)");
				verific = lector.nextLine();

				if(verific.equalsIgnoreCase(YES)){
					i++;
				}
			}while(verific.equalsIgnoreCase(YES));

			message = hireEmployee(name,id,salary,yearsExperience,team,player,expertise);

			System.out.println(message);
			break;
			case 3:

			do{
				System.out.println("Cual es el numero de camiseta del jugador?");
				numTShirt = lector.nextLine();

				findNumTShirt = club.findNumTShirt(numTShirt,team);

				if(findNumTShirt){
					System.out.println("Un jugador del equipo "+team+" ya posee ese mismo numero, por favor elija otro");
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

			message = hireEmployee(name,id,salary,team,numTShirt,playerPosition);

			System.out.println(message);
			break;
		}
	}