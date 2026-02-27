package Snake_Ladder_Game.Model;

public class Snake extends Jump{
    public Snake(int start, int end){
       this.start = start;
       this.end = end;
    }

    @Override
    public int getPosition() {
        return this.end;
    }
}
