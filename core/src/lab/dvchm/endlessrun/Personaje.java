package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Personaje extends PersonajeAnimado {

	float grav;
	
	
	public Personaje() {
		super(loadImages());
		grav = 175f;
	}

	static ArrayList<Image> loadImages(){
		ArrayList<Image> images;
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("run01.png")));
		images.add(new Image(new Texture("run02.png")));
		images.add(new Image(new Texture("run03.png")));
		images.add(new Image(new Texture("run04.png")));
		images.add(new Image(new Texture("jump.png")));
		return images;
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
		
		ace_y -= grav * delta;
		if(getY() <= piso){
			vel_y = 0;
			ace_y = 0;
			setY(piso);	
		}
		
		if(getY() != piso)
			dib_act = 4;
		
		
	}
	
	boolean b = true;
	void saltar(){
		if(getY() == piso){
			ace_y = 50f;
			b = true;
		} else
		if(b){
			ace_y = 50f;
			b = false;
		}
	}
		
}
