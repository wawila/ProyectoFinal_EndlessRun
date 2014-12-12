package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Runner extends Actor {
	ArrayList<Image>images;
	int dibujo_actual = 0;
	float tiempo_act = 0;
	float velocidad_y = 0, aceleracion_y = 0;
	boolean up;
	public Runner(){
		super();
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("run01.png")));
		images.add(new Image(new Texture("run02.png")));
		images.add(new Image(new Texture("run03.png")));
		images.add(new Image(new Texture("run04.png")));
		images.add(new Image(new Texture("jump.png")));
	}

	@Override
	public void act(float delta) {
		
		super.act(delta);
		tiempo_act+= delta;
		if(tiempo_act>0.1f){
		dibujo_actual++;
		tiempo_act = 0;
		}
		if(dibujo_actual >= images.size()-1){
			dibujo_actual = 0;
		
		}
		

		velocidad_y += aceleracion_y;
		this.setY(this.getY()+velocidad_y);
		
		aceleracion_y -= 0.07;
		
		if (this.getY()<=60){
			velocidad_y = 0;
			aceleracion_y = 0;
			this.setY(60);
		
		/*
		 *  El KeyPressed los saque de :
		 *  http://stackoverflow.com/questions/5833065/how-to-move-a-sprite-with-the-keyboard-keys-using-libgdx
		 */
		
		
		if(Gdx.input.isKeyPressed(Keys.SPACE))
		 up = true;
		else
		up=false;
		

			
		
		
		}
		if(up)
		{
		if (this.getY()==60)
			{
		aceleracion_y = 1f;
			}
			
			else
			dibujo_actual = 4;
		}				
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		images.get(dibujo_actual).setX(this.getX());
		images.get(dibujo_actual).setY(this.getY());
		images.get(dibujo_actual).draw(batch, parentAlpha);
		
	}

}
