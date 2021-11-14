import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element {

    public Hero(int x, int y) {
        super(new Position(x,y));
    }

    public Position moveDown() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
    }

    public Position moveUp() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() - 1);
    }

    public Position moveLeft() {
        return new Position(super.getPosition().getX() - 1, super.getPosition().getY());
    }

    public Position moveRight() {
        return new Position(super.getPosition().getX()+1, super.getPosition().getY());
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "X");
//        graphics.enableModifiers(SGR.BOLD);
//        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
//        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }
}


