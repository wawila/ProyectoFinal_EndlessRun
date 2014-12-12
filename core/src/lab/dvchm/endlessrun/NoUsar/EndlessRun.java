package lab.dvchm.endlessrun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class EndlessRun extends ApplicationAdapter{
	SpriteBatch batch;
	Texture img;
	Stage stage;
	int frame;
	Rectangle run, ene1, ene2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		stage = new Stage();
		//stage.addActor(new Bomba());
		stage.addActor(new Runner());
		//stage.addActor(new Croc());
		stage.addActor(new Volador());
		//stage.addActor(new Agua());
		stage.addActor(new Tierra());
	
		run = new Rectangle(0, 65, 245, 245);
		ene1 = new Rectangle(800, 70, 75,75);
		ene2 = new Rectangle(800, 70, 75,75);
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255, 255, 255, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.draw();
		stage.act();
	
	}

	
}
