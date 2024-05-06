package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.mars.actors.Bug;
import edu.monash.fit2099.demo.mars.behaviours.FollowBehaviour;
import edu.monash.fit2099.demo.mars.behaviours.SpitBehaviour;
import edu.monash.fit2099.demo.mars.items.MartianItem;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle());

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

        AlienBug alienBug = new AlienBug(player);
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
        gameMap.at(26, 13).setGround(new Crater());

        gameMap.at(2, 12).addItem(new MetalPipe());
        gameMap.at(25, 9).addItem(new MetalPipe());
        gameMap.at(13, 8).addItem(new MetalPipe());

        gameMap.at(4,1).addItem(new GoldPot());
        gameMap.at(24, 9).addItem(new GoldPot());
        gameMap.at(2, 13).addItem(new GoldPot());

        gameMap.at(14,8).addItem(new PickleJar());
        gameMap.at(19, 9).addItem(new PickleJar());
        gameMap.at(9, 13).addItem(new PickleJar());





       world.run();
    }
}
