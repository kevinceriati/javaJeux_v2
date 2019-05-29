package warriors.engine;

import warriors.contracts.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarriorDAO {
    private static Connection cnx;
    private String url = "jdbc:mysql://localhost:3306/java_jeux?useUnicode=true\n" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&\n" +
            "serverTimezone=UTC";
    private String user = "root";
    private String pwd = "";
    private ArrayList<Hero> myHeroes= new ArrayList<>();
    private String cnxLog = "";

    public WarriorDAO(){
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
            cnxLog = "Connection Ok";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeCnx(){
        try {
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Hero> getAll() {
        try {
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery("select * from hero");
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                String image = rs.getString("image");
                int attacklevel = rs.getInt("attacklevel");
                int life = rs.getInt("life");

                if (rs.getString("type").equals("Guerrier")){
                    myHeroes.add(new Guerrier(name, type, image, attacklevel, life));
                } else {
                    myHeroes.add(new Magicien(name, type, image, attacklevel, life));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myHeroes;
    }

    public void creatPerso(Personnage obj) {
        String sql = "INSERT INTO hero"
                + "(type, name, image, life, attacklevel) VALUES"
                + "(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, obj.getType());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getImage());
            preparedStatement.setInt(4, obj.getLife());
            preparedStatement.setInt(5, obj.getAttackLevel());
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

      //  if (perso.equalsIgnoreCase("Guerrier")) {
        //} else if (perso.equalsIgnoreCase("Magicien")) {
//            combattant = new Magicien();
//            combattant.setType("Magicien");
//            System.out.println("En tant que magicien, vous aurez un philtre pour vous défendre: le philtre snapchat du magicien perdu de l'ombre mortel noir.");
//            combattant.protection = "écusson en cuire de marmotte";
//        }
        //creatName();

        }
//        else if (combattant.getType() == "Magicien") {
//
//            while (health <= 3 || health >= 6) {
//                System.out.println("Choisissez votre niveau de vie entre 3 et 6");
//                health = scanner.nextInt();
//            }
//
//            while (power < 8 || power > 15) {
//                System.out.println("Choisissez votre niveau de force entre 8 et 15");
//                power = scanner.nextInt();
//            }
//        }
//        combattant.setHealth(health);
//        combattant.setPower(power);
//        degat(combattant.getType(), combattant.getHealth(), combattant.getPower());
//
//        System.out.println(combattant);
//        listeOfGuerrier.add(combattant);
//        combattant.setId(guerrierCourant);
//        guerrierCourant++;
    }

