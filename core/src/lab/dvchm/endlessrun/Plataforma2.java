package lab.dvchm.endlessrun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Plataforma2 extends Image
{
	
	Plataforma1 plat = new Plataforma1();
	
	int velocidad = 250;
	public Plataforma2()
	{
		super(new Texture("tierra.png"));
		this.setX(800);
		this.setY(-200);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)||Gdx.input.isKeyPressed(Keys.P) ||Gdx.input.isKeyPressed(Keys.R)){
			this.setVisible(false);	
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_1) || Gdx.input.isKeyPressed(Keys.NUM_2) || Gdx.input.isKeyPressed(Keys.NUM_3)||Gdx.input.isKeyPressed(Keys.Q)){
			this.setVisible(true);
		} 
		
		if(Gdx.input.isKeyPressed(Keys.NUM_1) ||Gdx.input.isKeyPressed(Keys.NUM_2))
			this.velocidad = 250;
		else
		if(Gdx.input.isKeyPressed(Keys.NUM_3))
			this.velocidad = 425;
		
		this.setX(this.getX()-delta*velocidad);
		this.setWidth(750);
		
		if(this.getX()<-750)
			this.setX(850);
	
		
	}
}