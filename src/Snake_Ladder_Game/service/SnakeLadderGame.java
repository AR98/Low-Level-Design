package Snake_Ladder_Game.service;

import Snake_Ladder_Game.Model.Jump;
import Snake_Ladder_Game.Model.Player;
import Snake_Ladder_Game.Model.Snake;
import Snake_Ladder_Game.Strategy.DiceStrategy;
import Snake_Ladder_Game.factory.JumpFactory;
import jdk.dynalink.StandardNamespace;

import java.util.*;

public class SnakeLadderGame {
    private final int boardSize;
    private final Map<Integer, Jump> jumps = new HashMap<>();
    private Deque<Player> players = new LinkedList<>();
    private final DiceStrategy diceStrategy;


    public  SnakeLadderGame(int boardSize, List<Player> palyers, DiceStrategy strategy){
        this.boardSize = boardSize;
        this.players.addAll(palyers);
        this.diceStrategy = strategy;
    }

    public void addJump(String type, int start, int end){
        Jump jump = JumpFactory.createJump(type, start, end);
        if(jump!=null){
            jumps.put(start, jump);
        }
    }

    public void start(){
        System.out.println("--- Game Started! ---");
        boolean isGameOver = false;

        while(!isGameOver){
            Player p = players.poll();
            int roll = diceStrategy.roll();
            int nextPos = roll +p.getPosition();
            System.out.println(p.getName() + " rolled a " + roll + ". Moving " + p.getPosition() + " -> " + Math.min(nextPos, boardSize));
            if(nextPos<=boardSize){
                if(jumps.containsKey(nextPos)){
                    Jump j = jumps.get(nextPos);
                    nextPos = j.getPosition();
                    String type = (j instanceof Snake) ? "[SNAKE!]" : "[LADDER!]";
                    System.out.println(" " + type + " New position: " + nextPos);
                }
                p.setPosition(nextPos);
            }

            if(p.getPosition() == boardSize){
                System.out.println("\n***************************");
                System.out.println("WINNER: " + p.getName());
                System.out.println("***************************");
                isGameOver = true;
            }else{
                players.add(p);
            }
        }
    }


}
