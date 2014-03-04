package gesture;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import application.Systeme;
import TUIO.TuioCursor;

public class Menu implements Drawable{
	
	RectangleShape 	carre;
	float 			taille = 40;
	CircleShape 	cercle;
	CircleShape 	triangleHaut;
	CircleShape 	triangleDroit;
	CircleShape 	triangleBas;
	CircleShape 	triangleGauche;
	
	Texture textHaut;
	
	Texture textBas;
	Texture textGauche;
	
	
	boolean visible = false;
	Text text;
	
	public Menu() {
		initialisation();
	}
	
	public void initialisation(){
		cercle = new CircleShape(4*taille);
		cercle.setOrigin(4*taille, 4*taille);
		cercle.setFillColor(new Color(255,255,255, 100));
		cercle.setOutlineThickness(3);
		cercle.setOutlineColor(Color.WHITE);
		
		carre = new RectangleShape(new Vector2f(2*taille, 2*taille));
		carre.setOrigin(taille, taille);
		carre.setOutlineColor(Color.BLUE);
		carre.setOutlineThickness(taille/10);
		carre.setFillColor(Color.TRANSPARENT);
		
		
		textHaut = new Texture();
		try {
			textHaut.loadFromFile(Paths.get("images/iconeAdd.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		triangleHaut = new CircleShape(taille, 3);
		triangleHaut.setOrigin(taille, taille);
		triangleHaut.setOutlineColor(Color.BLACK);
		triangleHaut.setOutlineThickness(2);
		triangleHaut.setTexture(textHaut);
		
		
		
		triangleDroit = new CircleShape(taille, 3);
		triangleDroit.setOrigin(taille, taille);
		triangleDroit.setFillColor(Color.CYAN);
		triangleDroit.setRotation(90);
		
		
		textBas = new Texture();
		try {
			textBas.loadFromFile(Paths.get("images/iconeHelp.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		triangleBas = new CircleShape(taille, 3);
		triangleBas.setOrigin(taille, taille);
		triangleBas.setOutlineColor(Color.BLACK);
		triangleBas.setOutlineThickness(2);
		triangleBas.setTexture(textBas);
		triangleBas.setRotation(180);
		
		
		textGauche = new Texture();
		try {
			textGauche.loadFromFile(Paths.get("images/iconeApropos.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		triangleGauche = new CircleShape(taille, 3);
		triangleGauche.setOrigin(taille, taille);
		triangleGauche.setOutlineColor(Color.BLACK);
		triangleGauche.setOutlineThickness(2);
		triangleGauche.setRotation(-90);
		triangleGauche.setTexture(textGauche);
		
		
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
