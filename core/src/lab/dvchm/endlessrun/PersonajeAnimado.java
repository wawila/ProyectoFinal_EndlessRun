package lab.dvchm.endlessrun;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PersonajeAnimado extends Actor
{
	ArrayList<Image> img;
	int dib_act;
	float vel_x, vel_y;
	float ace_x, ace_y;
	float vel_ani;
	int piso;
	float frame;


	public PersonajeAnimado(ArrayList<Image> im) 
	{
		super();
		this.img = im;
		dib_act=0;
		vel_x=0;
		vel_y=0;
		ace_x=0;
		ace_y=0;
		frame=0;
		vel_ani=0.1f;
		piso=70;
		setWidth(img.get(0).getWidth());
		setHeight(img.get(0).getHeight());
	}		

	@Override
	public void act(float delta) {
		super.act(delta);
		
		frame += delta;
		
		if(frame >= vel_ani)
		{
			dib_act++;
			
			if(dib_act >= img.size())
				dib_act = 0;
				
			frame = 0;
		}
		
		vel_x += ace_x;
		vel_y += ace_y;
		moveBy(vel_x*delta, vel_y*delta);
		
		if(getY() <= piso){
			setY(piso);
		}
	}

	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		if(this.isVisible())
		{
			img.get(dib_act).setPosition(getX(), getY());
			img.get(dib_act).draw(batch, parentAlpha);
		}
	}
	
	boolean colision(PersonajeAnimado otro_personaje)
	{
		Rectangle r1 = new Rectangle(getX()+getWidth()/4,
							getY()+getHeight()/4, 
							getWidth()/2,
							getHeight()/2);
		Rectangle r2 = new Rectangle(otro_personaje.getX()+otro_personaje.getWidth()/4, 
						otro_personaje.getY()+otro_personaje.getHeight()/4,
						otro_personaje.getWidth()/2,
						otro_personaje.getHeight()/2);
		return r1.overlaps(r2);
	}
	
}

