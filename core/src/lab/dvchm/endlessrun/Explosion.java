package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Explosion extends PersonajeAnimado {
	
	
	Explosion ()
	{
		super(loadImages());

	}
	
	static ArrayList<Image> loadImages()
	{
		ArrayList<Image> images;
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("perder01.png")));
		images.add(new Image(new Texture("perder02.png")));
		images.add(new Image(new Texture("perder03.png")));
		images.add(new Image(new Texture("perder04.png")));
		images.add(new Image(new Texture("perder05.png")));
		return images;
		
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		this.setX(-40);
		this.setY(50);
		
		if(Gdx.input.isKeyPressed(Keys.NUM_1))
		{
			this.setVisible(false);
		}
		// Opcion 1
		else
		if(Gdx.input.isKeyPressed(Keys.NUM_2))
		{
			this.setVisible(false);
		}
		else
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
		{
			this.setVisible(true);
		}
		
		if(Gdx.input.isKeyPressed(Keys.P)){
			this.setVisible(false);
			}
	}
	
}
