package image;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import application.Systeme;


public class Conteneur implements Drawable{

	/* Attributs */
	RectangleShape 	conteneur;
	
	boolean 		visible = true;
	
	float			width 	= Systeme.window.getSize().x; 
	float			positionWidth = 10;
	float 			height 	= Systeme.window.getSize().y;
	float			positionHeight = height - height/10 + 2;
	
	int				nombreImage=0;
	
	/* Constructeur */
	public Conteneur() {
		initialisationConteneur();
	}

	/* Getters & Setters */
	
	
	/* Methodes */

	
	public void initialisationConteneur(){
		conteneur = new RectangleShape(new Vector2f(width-10, height/10));
		conteneur.setOutlineColor(Color.WHITE);
		conteneur.setOutlineThickness(3);
		conteneur.setFillColor(new Color(255,255,255, 50));
		this.setPositionConteneur();
	}
	

	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible){
			conteneur.draw(arg0, arg1);
		}
		
	}
	
	public void setSizeConteneur(){
		conteneur.setSize(new Vector2f(Systeme.window.getSize().x-10, Systeme.window.getSize().y/10));
	}
	public void setPositionConteneur(){
		conteneur.setPosition(5, Systeme.window.getSize().y-(Systeme.window.getSize().y/10));
	}
	
	public void addDossier(ListeImage l) {
	}
	
	public void deleteDossier(){
		
	}
	
	public int nombreImage() {
		return nombreImage;
	}

	public void ajouterImage(Image i) {
		nombreImage = nombreImage + 1;
		i.sprite.setScale(0.1f, 0.1f);
		i.sprite.setPosition(nombreImage*10, Systeme.window.getSize().y-20);
		
	}

	public boolean isInsideConteneur(TuioCursor cursor){
		return conteneur.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}

	public void setVisible(boolean v){
		this.visible = v;
	}
	
	public boolean isVisible(){
		return visible;
	}

}
