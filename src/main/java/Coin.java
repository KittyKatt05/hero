import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Coin extends Element{

    public Coin(int x, int y) {
        super(new Position(x,y));
    }



    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#01FFFF"));
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "C");
    }
}
