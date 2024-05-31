package game.system;

import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.World;
import game.actors.traders.HumanoidFigure;
import game.actors.Player;
import game.actors.enemies.AlienBug;
import game.actors.enemies.HuntsmanSpider;
import game.actors.enemies.SuspiciousAstronaut;
import game.grounds.*;
import game.grounds.trees.Inheritree;
import game.grounds.trees.SproutState;
import game.items.*;
import game.items.consumables.LargeFruit;
import game.items.printers.*;
import game.items.consumables.GoldPot;
import game.items.consumables.PickleJar;
import game.items.sellables.LargeBolt;
import game.items.sellables.MetalPipe;
import game.items.sellables.MetalSheet;
import game.items.sellables.ToiletPaper;

import java.util.*;

/**
 * The main class to start the game.
 * Created by: Adrian Kristanto
 * Modified by:
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle());

        // Create the main game map
        List<String> map = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~........................",
                "..............................",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        // Create the parking lot map
        List<String> parkingLot = Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                ".......");
        GameMap parkingLotMap = new GameMap(groundFactory, parkingLot);
        world.addGameMap(parkingLotMap);

        // Create the new moon map
        List<String> moon = Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..........................~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~..........#___#............",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~..............");
        GameMap moonMap = new GameMap(groundFactory, moon);
        world.addGameMap(moonMap);

        // Display the game title
        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // Add actors and items to the main game map
        gameMap.at(7, 9).addActor(new HuntsmanSpider());
        Player player = new Player("Intern", '@', 4);
        player.addBalance(10000);
        // test selling items.
//        player.addItemToInventory(new DragonSlayer()); // checked
//        player.addItemToInventory(new LargeBolt()); // checked
//        player.addItemToInventory(new MetalSheet()); // checked
//        player.addItemToInventory(new LargeFruit()); // checked
//        player.addItemToInventory(new PickleJar()); // checked
//        player.addItemToInventory(new MetalPipe()); // checked
//        player.addItemToInventory(new GoldPot()); // checked
//        player.addItemToInventory(new ToiletPaper()); // checked


        world.addPlayer(player, gameMap.at(15, 6));

        player.addBalance(1000);
        player.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 1000);

        AlienBug alienBug = new AlienBug();
        gameMap.at(3, 5).addActor(alienBug);

        gameMap.at(11, 9).addItem(new LargeBolt());
        gameMap.at(3, 10).addItem(new LargeBolt());
        gameMap.at(25, 4).addItem(new LargeBolt());

        gameMap.at(5, 7).addItem(new MetalSheet());
        gameMap.at(23, 7).addItem(new MetalSheet());
        gameMap.at(14, 2).addItem(new MetalSheet());

        gameMap.at(24, 1).setGround(new Inheritree(new SproutState()));
        gameMap.at(8, 5).setGround(new Inheritree(new SproutState()));
        gameMap.at(23, 11).setGround(new Inheritree(new SproutState()));

        gameMap.at(21, 3).setGround(new Crater());
        gameMap.at(3, 4).setGround(new Crater());
        Crater testingCrater = new Crater(new SuspiciousAstronaut());
        gameMap.at(26, 13).setGround(testingCrater);

        gameMap.at(2, 12).addItem(new MetalPipe());
        gameMap.at(25, 9).addItem(new MetalPipe());
        gameMap.at(13, 8).addItem(new MetalPipe());

        gameMap.at(4, 1).addItem(new GoldPot());
        gameMap.at(24, 9).addItem(new GoldPot());
        gameMap.at(2, 13).addItem(new GoldPot());

        gameMap.at(14, 8).addItem(new PickleJar());
        gameMap.at(19, 9).addItem(new PickleJar());
        gameMap.at(9, 13).addItem(new PickleJar());

        gameMap.at(14, 8).addItem(new Astley());

        // Set up item printers
        ArrayList<Printer> itemPrinters = new ArrayList<>();
        itemPrinters.add(new EnergyDrinkPrinter());
        itemPrinters.add(new DragonSlayerPrinter());
        itemPrinters.add(new ToiletPaperPrinter());
        itemPrinters.add(new AstleyPrinter());
        itemPrinters.add(new TheseusPrinter()); // Add TheseusPrinter to the list

        // *Tedd's version*
//        Map<GameMap, String> mapss = new HashMap<GameMap, String>();
//        mapss.put(gameMap, "Factory");
//        mapss.put(moonMap, "New Moon");
//        mapss.put(parkingLotMap, "Parking Lot");
//
//        ComputerTerminal terminal = new ComputerTerminal(itemPrinters, mapss);
//        gameMap.at(16, 6).setGround(terminal);
//        moonMap.at(16, 6).setGround(terminal);
//        parkingLotMap.at(3, 4).setGround(terminal);


        // Add computer terminal with travel actions to the main game map
        ComputerTerminal computerTerminalMainMap = new ComputerTerminal(itemPrinters, gameMap, moonMap);
        gameMap.at(14, 9).setGround(computerTerminalMainMap);

        // Add computer terminal with travel actions to the moon map
        ComputerTerminal computerTerminalMoonMap = new ComputerTerminal(itemPrinters, gameMap, moonMap);
        moonMap.at(5, 5).setGround(computerTerminalMoonMap); // Placing the terminal at (5, 5) on the moon map


        parkingLotMap.at(3, 8).addActor(new HumanoidFigure());
        // for testing
//        gameMap.at(15, 8).addActor(new HumanoidFigure()); // checked


        // Run the game
        world.run();

        System.out.println(FancyMessage.YOU_ARE_FIRED);
    }
}
