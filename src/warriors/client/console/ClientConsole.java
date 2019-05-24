package warriors.client.console;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Cases;
import warriors.engine.Plateau;
import warriors.engine.Serializer;
import warriors.engine.Warriors;

public class ClientConsole {
	
	private static String MENU_COMMENCER_PARTIE = "1";
	private static String MENU_QUITTER = "2";
	private static String MENU_PARTIE_TEST = "3";
	private static boolean isTest = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WarriorsAPI warriors = new Warriors();
		Scanner sc = new Scanner(System.in);
		String menuChoice = "";
		do {
			menuChoice = displayMenu(sc);
			if(menuChoice.equals(MENU_COMMENCER_PARTIE)) {
				isTest = false;
				if (!isTest){
					startGame(warriors, sc, isTest);
				}
			} else if (menuChoice.equals(MENU_PARTIE_TEST)){
				isTest = true;
				startGame(warriors, sc, isTest);
			}
		}while(!menuChoice.equals(MENU_QUITTER));
		sc.close();
		System.out.println("A bientôt jeune guerrier fougueux");

	}

	/**
	 * @param warriors
	 * @param sc
	 * @param isTest
	 *
	 * Name choice
	 * Hero choice
	 * Map choice
	 *Ongoing game
	 *
	 */

	private static void startGame(WarriorsAPI warriors, Scanner sc, boolean isTest) {
		System.out.println();
		System.out.println("Entrez votre nom:");
		String playerName = sc.nextLine();
		
		System.out.println("Choisissez votre héro:");
		for(int i = 0; i < warriors.getHeroes().size(); i++) {
			Hero heroe = warriors.getHeroes().get(i);
			System.out.println(i+1 + " - " + heroe.getName());
			System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
			System.out.println("    Niveau de vie : " + heroe.getLife());
		}
		Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);
		
		System.out.println("Choisissez votre map:");
		for(int i = 0; i < warriors.getMaps().size(); i++) {
			Map map = warriors.getMaps().get(i);
			System.out.println(i+1 + " - " + map.getName());
		}
		Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

		GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
		String gameId = gameState.getGameId();
		while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
			System.out.println(gameState.getLastLog());
			if (isTest){
				gameState = ((Warriors) warriors).nextTurnTest(gameId);
			}else {
				System.out.println("\nAppuyer sur une touche pour lancer le dé");
				if(sc.hasNext()) {
					sc.nextLine();
					gameState = ((Warriors) warriors).rollDice(gameId);
				}
			}
		}
		System.out.println(gameState.getLastLog());
	}

	/**
	 * @param sc
	 * @return
	 */
	private static String displayMenu(Scanner sc) {
		System.out.println();
		System.out.println("================== Java Warriors ==================");
		System.out.println("1 - Commencer une partie");
		System.out.println("2 - Quitter");
		System.out.println("3 - Debug mode");
		if(sc.hasNext()) {
			String choice = sc.nextLine();
			return choice;
		}
		return "";
	}
}

