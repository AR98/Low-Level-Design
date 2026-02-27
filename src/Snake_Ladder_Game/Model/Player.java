package Snake_Ladder_Game.Model;

public class Player {
    private final String name;
    private int position;

    public Player(String name){
        this.name = name;
        this.position  = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int  position){
        this.position = position;
    }
}
