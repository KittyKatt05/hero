import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element{

    public Monster(int x, int y) {
        super(new Position(x,y));
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "M");
    }
}
