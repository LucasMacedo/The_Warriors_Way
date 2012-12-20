package Principal;

import GameState.Fase1;
import GameState.MenuPrincipal;
import GameState.TelaHistoria;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main("The Warrior's Way"));
        app.setDisplayMode(800, 600, false);
        app.setTargetFrameRate(60);

        app.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new MenuPrincipal());
        this.addState(new TelaHistoria());
        this.addState(new Fase1());
    }

    public Main(String title) {
        super(title);
    }
}
