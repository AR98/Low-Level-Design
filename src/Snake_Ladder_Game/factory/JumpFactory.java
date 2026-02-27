package Snake_Ladder_Game.factory;

import Snake_Ladder_Game.Model.Jump;
import Snake_Ladder_Game.Model.Ladder;
import Snake_Ladder_Game.Model.Snake;

public class JumpFactory{

    public static Jump createJump(String type, int start, int end){
        if("SNAKE".equalsIgnoreCase(type)){
            return new Snake(start, end);
        }else if("LADDER".equalsIgnoreCase(type)){
            return new Ladder(start, end);
        }else{
            return null;
        }
    }
}
