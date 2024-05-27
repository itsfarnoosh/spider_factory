// File path: game/system/Application.java

package game.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.enemies.AlienBug;
import game.actors.enemies.HuntsmanSpider;
import game.actors.Player;
import game.actors.enemies.SuspiciousAstronaut;
import game.grounds.*;
import game.items.*;
import game.items.consumables.EnergyDrinkPrinter;
import game.items.consumables.GoldPot;
import game.items.consumables.PickleJar;

/**
 * The main class to start the game.
 * Created by:
 * Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle());

        // added new maps needed in Req 1
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

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        gameMap.at(7, 9).addActor(new HuntsmanSpider());

        Player player = new Player("Intern", '@', 4);
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

        gameMap.at(24, 1).setGround(new Sapling());
        gameMap.at(8, 5).setGround(new Sapling());
        gameMap.at(23, 11).setGround(new Mature());

        gameMap.at(21, 3).setGround(new Crater());
        gameMap.at(3, 4).setGround(new Crater());
        // specific type crater.
        Crater testingCrater =  new Crater(new SuspiciousAstronaut());
        gameMap.at(26, 13).setGround(testingCrater);

        gameMap.at(2, 12).addItem(new MetalPipe());
        gameMap.at(25, 9).addItem(new MetalPipe());
        gameMap.at(13, 8).addItem(new MetalPipe());

        gameMap.at(4,1).addItem(new GoldPot());
        gameMap.at(24, 9).addItem(new GoldPot());
        gameMap.at(2, 13).addItem(new GoldPot());

        gameMap.at(14,8).addItem(new PickleJar());
        gameMap.at(19, 9).addItem(new PickleJar());
        gameMap.at(9, 13).addItem(new PickleJar());

        ArrayList<Printer> itemPrinters = new ArrayList<>();
        itemPrinters.add(new EnergyDrinkPrinter());
        itemPrinters.add(new DragonSlayerPrinter());
        itemPrinters.add(new ToiletPaperPrinter());
        itemPrinters.add(new AstleyPrinter());
        itemPrinters.add(new TheseusPrinter()); // Add TheseusPrinter to the list

        gameMap.at(14, 9).setGround(new ComputerTerminal(itemPrinters));

        world.run();

        System.out.println(FancyMessage.YOU_ARE_FIRED);
    }
}
