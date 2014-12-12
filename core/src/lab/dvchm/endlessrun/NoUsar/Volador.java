package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Volador extends Actor{
	ArrayList<Image>images;
	int dibujo_actual = 0;
	float tiempo_act = 0;
	
	public Volador(){
		super();
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("volador01.png")));
		images.add(new Image(new Texture("volador02.png")));
		images.add(new Image(new Texture("volador03.png")));
	}

	@Override
	public void act(float delta) {
		
		super.act(delta);
		tiempo_act+= delta;
		if(tiempo_act>0.1f){
		dibujo_actual++;
		tiempo_act = 0;
		}
		if(dibujo_actual >= images.size()){
			dibujo_actual = 0;
		}
		/*
		this.setX(this.getX()-15);
		
		if(this.getX() < -150){
			this.setX(1000);
		}
		*/
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		images.get(dibujo_actual).setWidth(200);
		images.get(dibujo_actual).setHeight(200);
		
		setY(100);
		
		images.get(dibujo_actual).setX(this.getX()-100);
		if(this.getX()<-10)
			this.setX(500);
		
		images.get(dibujo_actual).draw(batch, parentAlpha);
	}
}