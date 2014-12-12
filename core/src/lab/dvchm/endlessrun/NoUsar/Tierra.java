package lab.dvchm.endlessrun;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tierra extends Image{
	
	public Tierra() {
		super(new Texture("tierra.png"));
		this.setX(0);
		this.setY(-200);

	
	}


	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setX(this.getX()-delta*1000);
		this.setWidth(1000);
		
		if(this.getX()<-990)
			this.setX(200);
}	
	
}