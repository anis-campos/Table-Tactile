package gesture;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import application.Systeme;

public class About implements Drawable{

	RectangleShape carre;
	Texture texture;
	float taille = 50;
	boolean visible=false;
	
	public About(){
		initialisation();
	}
	
	public void initialisation(){
		texture = new Texture();
		try {
			texture.loadFromFile(Paths.get("images/apropos.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		carre = new RectangleShape(new Vector2f(4*taille, 6*taille));
		carre.setOrigin(2*taille, 3*taille);
		carre.setOutlineColor(Color.RED);
		carre.setOutlineThickness(taille/10);
		carre.setTexture(texture);
		
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible){
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
}
