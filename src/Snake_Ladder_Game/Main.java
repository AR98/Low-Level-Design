package Snake_Ladder_Game;


import Snake_Ladder_Game.Model.Player;
import Snake_Ladder_Game.Strategy.DiceStrategy;
import Snake_Ladder_Game.Strategy.StandardDice;
import Snake_Ladder_Game.service.SnakeLadderGame;

import java.util.Arrays;
import java.util.List;

public class Main {

    public  static  void main(String[] args){
        // Setup Strategy
        DiceStrategy strategy = new StandardDice();
        // Setup Players
        List<Player>  players = Arrays.asList(new Player("Bob"), new Player("Nick"));
        // Initialize Game
        SnakeLadderGame  game = new SnakeLadderGame(100, players, strategy);
        // Add Snakes and Ladders via Factory
        game.addJump("LADDER", 4, 25);
        game.addJump("LADDER", 13, 46);
        game.addJump("SNAKE", 27, 5);
        game.addJump("SNAKE", 99, 41);
        // Play the game
        game.start();
    }

}
