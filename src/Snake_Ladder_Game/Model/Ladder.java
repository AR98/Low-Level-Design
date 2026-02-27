package Snake_Ladder_Game.Model;

public class Ladder extends  Jump{

    public Ladder(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int getPosition() {
        return end;
    }
}
