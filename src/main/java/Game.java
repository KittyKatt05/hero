import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    Hero hero;
    Arena arena = new Arena(78, 23);

    public Game() {
        try {
            hero = new Hero(10,10);
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);

            screen.startScreen();

            screen.doResizeIfNecessary();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        boolean flag = false;
        do {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            arena.moveMonsters();
            arena.monsterCollisions(screen);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
            }
            if (key.getKeyType() == KeyType.EOF) {
                flag = true;
            }
        } while(!flag);

    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);



    }




}
