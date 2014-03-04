package gesture;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import application.Systeme;

public class About implements Drawable{

	RectangleShape carre;
	Text about;
	float taille = 50;
	boolean visible=false;
	
	public About(){
		initialisation();
	}
	
	public void initialisation(){
		carre = new RectangleShape(new Vector2f(5*taille, 5*taille));
		carre.setOrigin(2*taille, 2*taille);
		carre.setOutlineColor(Color.RED);
		carre.setOutlineThickness(taille/10);
		carre.setFillColor(Color.WHITE);
		
		about = new Text("A propos:\n\nP4T V0.1\n\nDeveloppeur:\n\nBENKIRANE\nDA SILVA\nDIALLO\nTEBOUL",Systeme.font);
		about.setCharacterSize(20);
		about.setOrigin(about.getGlobalBounds().width/2,about.getGlobalBounds().height/2);
		about.setColor(Color.BLACK);
		about.setStyle(Text.BOLD);
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible){
			carre.draw(arg0, arg1);
			about.draw(arg0, arg1);
		}	
	}
	
	public void setPosition(TuioCursor cursor){
		carre.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
		about.setPosition(Systeme.about.carre.getPosition());
	}

	public boolean isInsideCarre(TuioCursor cursor){
		return carre.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return this.visible;
	}
}
