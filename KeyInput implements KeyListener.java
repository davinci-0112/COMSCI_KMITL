import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyInput implements KeyListener{

    private Player player;

    public KeyInput(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }
}