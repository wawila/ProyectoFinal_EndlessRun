package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Enemigo extends PersonajeAnimado{
	
	
	Personaje jugador;
	Enemigo(Personaje jugador)
	{
		super(loadImages());

		setX(800);
		vel_x =-250;
		this.jugador=jugador;

	}
	
	static ArrayList<Image> loadImages()
	{
		ArrayList<Image> images;
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("bomba01.png")));
		images.add(new Image(new Texture("bomba02.png")));
		images.add(new Image(new Texture("bomba03.png")));
		images.add(new Image(new Texture("game over.png")));
		return images;
		
	}
	
	int cont = 0;
	@Override
	boolean colision(PersonajeAnimado otro_personaje)
	{
		
		Rectangle r1 = new Rectangle(this.getX()+this.getWidth()/4,
							this.getY()+this.getHeight()/4, 
							this.getWidth()/2,
							this.getHeight()/2);
		Rectangle r2 = new Rectangle(otro_personaje.getX()+otro_personaje.getWidth()/4, 
						otro_personaje.getY()+otro_personaje.getHeight()/4,
						otro_personaje.getWidth()/2,
						otro_personaje.getHeight()/2);
		return r1.overlaps(r2);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	
		if(dib_act == 2)
			dib_act = 0;
		else
		if(cont >= 5){
			dib_act = 3;
			this.setX(150);
			this.setY(-90);
		}
		
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)||Gdx.input.isKeyPressed(Keys.P) ||Gdx.input.isKeyPressed(Keys.R)){
			cont = 0;
			this.setX(800);
			dib_act = 0;
			this.setVisible(false);	
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_1) || Gdx.input.isKeyPressed(Keys.NUM_2) || Gdx.input.isKeyPressed(Keys.NUM_3)||Gdx.input.isKeyPressed(Keys.Q)){
			this.setVisible(true);
		} 
		
		if(Gdx.input.isKeyPressed(Keys.NUM_1) ||Gdx.input.isKeyPressed(Keys.NUM_2))
			this.vel_x = -250;
		else
		if(Gdx.input.isKeyPressed(Keys.NUM_3))
			this.vel_x = -425;
		
		
		if(colision(jugador) == true)
		{
			cont += 1;
			if(cont > 5)
				cont = 5;
			System.out.println("Colision!");
			this.setX(800);
		}

			
		if(this.getX()<-120)
			this.setX(800);
	}
	
}
