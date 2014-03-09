package gesture;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import TUIO.TuioPoint;
import application.Systeme;

public class Help implements Drawable{

	RectangleShape carre;
	Texture texture;
	float taille = 100;
	boolean visible=false;
	
	public Help(){
		initialisation();
	}
	
	public void initialisation(){
		texture = new Texture();
		try {
			texture.loadFromFile(Paths.get("images/help.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		carre = new RectangleShape(new Vector2f(5*taille, 7*taille));
		carre.setOrigin((5*taille)/2, (7*taille)/2);
		carre.setOutlineColor(Color.RED);
		carre.setOutlineThickness(taille/10);
		carre.setTexture(texture);
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if(visible){
			carre.draw(arg0, arg1);
		}
	}
	
	public void setPosition(TuioCursor cursor){
		carre.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public void setPosition(){
		carre.setPosition(Systeme.window.getSize().x/2, Systeme.window.getSize().y/2);
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

	public void actionHelp(TuioCursor c1){
		if (Systeme.help.isVisible()) {
			Clock temps = new Clock();
			TuioPoint position = c1.getPosition();
			while (c1.getTuioState() != 4) {
				if (position.getDistance(c1.getPosition()) > 0.01)
					break;
				if (temps.getElapsedTime().asMilliseconds() > 1000)
					break;
			}
			if (temps.getElapsedTime().asMilliseconds() < 1000)
				return;
			if (Systeme.help.isInsideCarre(c1)) {
				Systeme.help.setVisible(false);
			}
		}
	}
	
}
