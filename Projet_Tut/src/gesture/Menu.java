package gesture;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import application.Systeme;
import TUIO.TuioCursor;

public class Menu implements Drawable{
	
	RectangleShape 	carre;
	float 			taille = 25;
	CircleShape 	cercle;
	CircleShape 	triangleHaut;
	CircleShape 	triangleDroit;
	CircleShape 	triangleBas;
	CircleShape 	triangleGauche;
	
	boolean visible = false;
	Text text;
	
	public Menu() {
		initialisation();
	}
	
	public void initialisation(){
		cercle = new CircleShape(3*taille);
		cercle.setOrigin(3*taille, 3*taille);
		cercle.setFillColor(new Color(255,255,255, 100));
		cercle.setOutlineThickness(3);
		cercle.setOutlineColor(Color.WHITE);
		
		carre = new RectangleShape(new Vector2f(2*taille, 2*taille));
		carre.setOrigin(taille, taille);
		carre.setOutlineColor(Color.BLUE);
		carre.setOutlineThickness(taille/10);
		carre.setFillColor(Color.TRANSPARENT);
		
		triangleHaut = new CircleShape(taille, 3);
		triangleHaut.setOrigin(taille, taille);
		triangleHaut.setFillColor(Color.CYAN);
		
		triangleDroit = new CircleShape(taille, 3);
		triangleDroit.setOrigin(taille, taille);
		triangleDroit.setFillColor(Color.CYAN);
		triangleDroit.setRotation(90);
		
		triangleBas = new CircleShape(taille, 3);
		triangleBas.setOrigin(taille, taille);
		triangleBas.setFillColor(Color.CYAN);
		triangleBas.setRotation(180);
		
		triangleGauche = new CircleShape(taille, 3);
		triangleGauche.setOrigin(taille, taille);
		triangleGauche.setFillColor(Color.CYAN);
		triangleGauche.setRotation(-90);
		
		
		text = new Text("MENU",Systeme.font);
		text.setCharacterSize((int)(taille*2)/5);
		text.setOrigin(text.getGlobalBounds().width/2,text.getGlobalBounds().height/2);
		text.setColor(Color.GREEN);
		text.setStyle(Text.BOLD);
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible){
			
			cercle.draw(arg0, arg1);
			carre.draw(arg0, arg1);
			
			triangleHaut.draw(arg0, arg1);
			triangleDroit.draw(arg0, arg1);
			triangleBas.draw(arg0, arg1);
			triangleGauche.draw(arg0, arg1);
			
			text.draw(arg0, arg1);
		}	
	}

	
	public void setPosition(TuioCursor cursor){
		carre.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
		cercle.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
		triangleHaut.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y-(2*taille));
		triangleDroit.setPosition(cursor.getX()*Systeme.screen.x+(2*taille), cursor.getY()*Systeme.screen.y);
		triangleBas.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y+(2*taille));
		triangleGauche.setPosition(cursor.getX()*Systeme.screen.x-(2*taille), cursor.getY()*Systeme.screen.y);
		
		//text.setPosition(cursor.getX()*Systeme.screen.x-((taille*15)/25), cursor.getY()*Systeme.screen.y-(taille/5));
		text.setPosition(carre.getPosition());
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return this.visible;
	}
	
	public boolean isInsideCarre(TuioCursor cursor){
		return carre.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public boolean isInsideToucheHaut(TuioCursor cursor){
		return triangleHaut.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	public boolean isInsideToucheDroit(TuioCursor cursor){
		return triangleDroit.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	public boolean isInsideToucheBas(TuioCursor cursor){
		return triangleBas.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	public boolean isInsideToucheGauche(TuioCursor cursor){
		return triangleGauche.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
}
