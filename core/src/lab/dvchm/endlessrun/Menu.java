package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Menu extends PersonajeAnimado{
	
	int dib = 0;
	Stage stage;
	Personaje jugador;
	
	public Menu() {
		super(loadImages());
		loadImages();
		
	}

	static ArrayList<Image> loadImages(){
		ArrayList<Image> images;
		
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("menu.png")));
		images.add(new Image(new Texture("inst.png")));
		images.add(new Image(new Texture("pausa.png")));
		images.add(new Image(new Texture("dificultad.png")));
		
		return images;
	}
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setX(0);
		this.setY(-100);
		
		dib_act = dib;
		
		if(Gdx.input.isKeyPressed(Keys.Q)||Gdx.input.isKeyPressed(Keys.ESCAPE)||Gdx.input.isKeyPressed(Keys.P) ||Gdx.input.isKeyPressed(Keys.R)){
			this.setVisible(true);	
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_1) || Gdx.input.isKeyPressed(Keys.NUM_2) || Gdx.input.isKeyPressed(Keys.NUM_3)){
			this.setVisible(false);
		} 
		
		
		if(Gdx.input.isKeyPressed(Keys.Q))
		{
			System.out.println("Juego");
			this.setVisible(false);
		}
		else
		if(Gdx.input.isKeyPressed(Keys.W))
		{
			System.out.println("Instrucciones");
			dib = 1;
			this.setVisible(true);
		}
		else
		if(Gdx.input.isKeyPressed(Keys.E))
		{
			System.out.println("Dificultad");
			dib = 3;
			this.setVisible(true);
		}
		else
		if(Gdx.input.isKeyPressed(Keys.S))
		{
			System.out.println("Salir");
			System.exit(0);
			}
		else
			if(Gdx.input.isKeyPressed(Keys.ESCAPE))
			{
				System.out.println("Menu");
				dib = 0;
				this.setVisible(true);
				}
			

		
		if(Gdx.input.isKeyPressed(Keys.P)){
			dib = 2;
			System.out.println("Pausa");
			this.setVisible(true);
			}
			
	}
	
	boolean b = false;
	public boolean iniciarJuego()
	{
		
		if(Gdx.input.isKeyPressed(Keys.NUM_1))
			b = true;
		
		if(Gdx.input.isKeyPressed(Keys.P)){
			dib = 2;
			b = false;
		}
		
			if(b){
				this.setVisible(false);
				return true;
			}
			else 
				this.setVisible(true);
				return false;
			
	}
}
