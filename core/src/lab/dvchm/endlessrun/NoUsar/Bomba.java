package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bomba extends Actor {
	ArrayList<Image>images;
	int dibujo_actual = 0;
	float tiempo_act = 0;
	
	public Bomba(){
		super();
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("bomba01.png")));
		images.add(new Image(new Texture("bomba02.png")));
		images.add(new Image(new Texture("bomba03.png")));
	}

	@Override
	public void act(float delta) {
		System.out.println(delta);
		super.act(delta);
		tiempo_act+= delta;
		if(tiempo_act>0.1f){
		dibujo_actual++;
		tiempo_act = 0;
		}
		
		if(dibujo_actual >= images.size()){
			dibujo_actual = 0;
		}
		
		setX(800);
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		images.get(dibujo_actual).setWidth(150);
		images.get(dibujo_actual).setHeight(150);
		images.get(dibujo_actual).setX(350);
		images.get(dibujo_actual).setY(220);
		setX(this.getX()-20);
		images.get(dibujo_actual).setY(this.getY()-1);
		if(this.getY()<-90)
			this.setY(200);
		images.get(dibujo_actual).draw(batch, parentAlpha);
		
	}

}
