package warriors.client.console;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.*;

public class ClientConsole {

    private static Scanner sc = new Scanner(System.in);

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_QUITTER = "2";
    private static String MENU_PARTIE_TEST = "3";
    private static String MENU_CHOIX_PLAYER = "1";
    private static String MENU_CREATION_PLAYER = "2";
    private static boolean isTest = false;
    private static  ArrayList<Hero> myHeroes= new ArrayList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        WarriorsAPI warriors = new Warriors();
        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {
                isTest = false;
                System.out.println("1 - Choisir un player" + "\n" + "2 - Créer un player");
                menuChoice = sc.nextLine();
                if (menuChoice.equals(MENU_CHOIX_PLAYER)) {
                    startGame(warriors, sc, isTest);
                } else if ((menuChoice.equals(MENU_CREATION_PLAYER))){
                  creatPerso();
                }
                menuChoice= "18";
            } else if (menuChoice.equals(MENU_PARTIE_TEST)) {
                isTest = true;
                startGame(warriors, sc, isTest);
            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        WarriorDAO.closeCnx();
        System.out.println("A bientôt jeune guerrier fougueux");

    }

    /**
     * @param warriors
     * @param sc
     * @param isTest   Name choice
     *                 Hero choice
     *                 Map choice
     *                 Ongoing game
     */

    private static void startGame(WarriorsAPI warriors, Scanner sc, boolean isTest) {
        System.out.println();
        System.out.println("Entrez votre nom:");
        String playerName = sc.nextLine();

        System.out.println("Choisissez votre héro:");
        myHeroes = new WarriorDAO().getAll();
        for (int i =0; i < myHeroes.size(); i++) {
            Hero heroe = myHeroes.get(i);
            System.out.println(i + 1 + " - " + heroe.getName());
            System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
            System.out.println("    Niveau de vie : " + heroe.getLife());
        }
        Hero chosenHeroe = myHeroes.get(Integer.parseInt(sc.nextLine()) - 1);

        System.out.println("Choisissez votre map:");
        for (int i = 0; i < warriors.getMaps().size(); i++) {
            Map map = warriors.getMaps().get(i);
            System.out.println(i + 1 + " - " + map.getName());
        }
        Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

        GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
        String gameId = gameState.getGameId();
        while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
            System.out.println(gameState.getLastLog());
            if (isTest) {
                gameState = ((Warriors) warriors).nextTurnTest(gameId);
            } else {
                System.out.println("\nAppuyer sur une touche pour lancer le dé");
                if (sc.hasNext()) {
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
        if (sc.hasNext()) {
            String choice = sc.nextLine();
            return choice;
        }
        return "";
    }
    public static void creatPerso() {

        WarriorDAO newPerso = new WarriorDAO();
        Personnage newWarrior = new Guerrier();

        System.out.println("Créer votre personnage: Guerrier / Magicien");
        newWarrior.setType(sc.nextLine());
        System.out.println("Vous avez choisit un " + newWarrior.getType() + "\n");

        System.out.println("Choisissez votre nom, et plus vite que ça !");
        newWarrior.setName(sc.nextLine());
        System.out.println("Votre nom est " + newWarrior.getName());

        System.out.println("Choisissez une image de profil");
        newWarrior.setImage(sc.nextLine());
        System.out.println("Vous avez choisit une nouvelle image");
//        if(newWarrior instanceof Guerrier) {
        if (newWarrior.getType().equals("Guerrier")) {

            while (newWarrior.getLife() < 5 || newWarrior.getLife() > 10) {
//            while (checkInt(newWarrior.getLife(), 10, 5)) {
                System.out.println("Choisissez votre niveau de vie entre 5 et 10");
                newWarrior.setLife(sc.nextInt());
            }

            while (newWarrior.getAttackLevel() < 5 || newWarrior.getAttackLevel() > 10) {
                System.out.println("Choisissez votre niveau de force entre 5 et 10");
                newWarrior.setAttackLevel(sc.nextInt());
            }
//        }else if (newWarrior instanceof Magicien){
        } else if (newWarrior.getType().equals("Magicien")) {

            while (newWarrior.getLife() <= 3 || newWarrior.getLife() >= 6) {
                System.out.println("Choisissez votre niveau de vie entre 3 et 6");
                newWarrior.setLife(sc.nextInt());
            }

            while (newWarrior.getAttackLevel() < 8 || newWarrior.getAttackLevel() > 15) {
                System.out.println("Choisissez votre niveau de force entre 8 et 15");
                newWarrior.setAttackLevel(sc.nextInt());
            }
        }
        newPerso.creatPerso(newWarrior);
    }

//    public static boolean checkInt(int val, int max, int min){
//        //if(val <= max && val >= min ){
//        //      return true;
//        // } else {
//        //      return false;
//        // }
//        return (val <= max && val >= min) ? true : false;
//    }
}
