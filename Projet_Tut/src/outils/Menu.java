
/*
 * 		Projet Tutore : Table tactile
 * 
 * Sujet : Application gestion image
 * 
 * Auteurs : BENKIRANE Mohamed Ali
 * 			 DA SILVA CAMPOS Anis
 * 			 DIALLO Amadou
 * 			 TEBOULE Linda	 
 * 
 * Date : 2013-2014
 *  
 */

package outils;


import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;

import application.Systeme;
import TUIO.TuioCursor;
import TUIO.TuioPoint;

public class Menu implements Drawable{

	/**  Attributs  */
	
	float 			taille = 100;
	
	RectangleShape 	ajouter;
	Texture			textAjouter;
	
	RectangleShape 	ouvrir;
	Texture			textOuvrir;
	
	RectangleShape 	enregistrer;
	Texture			textEnregistrer;
	
	RectangleShape 	aide;
	Texture			textAide;
	
	RectangleShape 	aPropos;
	Texture			textAPropos;
	
	RectangleShape 	quitter;
	Texture			textQuitter;
	
	RectangleShape 	fermer;
	Texture			textFermer;
	
	boolean visible = false;
	
	
	/**  Constructeur  */
	public Menu() {
		initialisation();
	}
	
	/**  Methodes  */
	public void initialisation(){
		
		textAjouter = new Texture();
		try {
			textAjouter.loadFromFile(Paths.get("images/bouton/ajouter.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		ajouter 	= new RectangleShape(new Vector2f(taille, taille));
		ajouter.setOrigin(taille/2, taille/2);
		ajouter.setTexture(textAjouter);
		
		
		textOuvrir = new Texture();
		try {
			textOuvrir.loadFromFile(Paths.get("images/bouton/ouvrir.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		ouvrir		= new RectangleShape(new Vector2f(taille, taille));
		ouvrir.setOrigin(taille/2, taille/2);
		ouvrir.setTexture(textOuvrir);
		
		
		textEnregistrer = new Texture();
		try {
			textEnregistrer.loadFromFile(Paths.get("images/bouton/enregistrer.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		enregistrer	= new RectangleShape(new Vector2f(taille, taille));
		enregistrer.setOrigin(taille/2, taille/2);
		enregistrer.setTexture(textEnregistrer);
		
		
		textAide = new Texture();
		try {
			textAide.loadFromFile(Paths.get("images/bouton/aide.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		aide		= new RectangleShape(new Vector2f(taille, taille));
		aide.setOrigin(taille/2, taille/2);
		aide.setTexture(textAide);
		
		textAPropos = new Texture();
		try {
			textAPropos.loadFromFile(Paths.get("images/bouton/about.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		aPropos		= new RectangleShape(new Vector2f(taille, taille));
		aPropos.setOrigin(taille/2, taille/2);
		aPropos.setTexture(textAPropos);
		
		textQuitter = new Texture();
		try {
			textQuitter.loadFromFile(Paths.get("images/bouton/quitter.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		quitter		= new RectangleShape(new Vector2f(taille, taille));
		quitter.setOrigin(taille/2, taille/2);
		quitter.setTexture(textQuitter);	
		
		textFermer = new Texture();
		try {
			textFermer.loadFromFile(Paths.get("images/bouton/fermer.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		fermer 	= new RectangleShape(new Vector2f((0.4f*taille), (0.4f*taille)));
		fermer.setOrigin((0.4f*taille)/2, (0.4f*taille)/2);
		fermer.setTexture(textFermer);
		
		
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible){
			ouvrir.draw(arg0, arg1);
			ajouter.draw(arg0, arg1);
			enregistrer.draw(arg0, arg1);
			aide.draw(arg0, arg1);
			aPropos.draw(arg0, arg1);
			quitter.draw(arg0, arg1);
			fermer.draw(arg0, arg1);
		}	
	}

	
	public void setPosition(TuioCursor cursor){
		float x = cursor.getX()*Systeme.screen.x;
		float y = cursor.getY()*Systeme.screen.y;
		
		ajouter.setPosition(x+taille/2,y-(3*taille)/2);
		ouvrir.setPosition(x+(3*taille)/2, y-(3*taille)/2);
		enregistrer.setPosition(x+(5*taille)/2, y-(3*taille)/2);
		
		aide.setPosition(x+taille/2, y-taille/2);
		aPropos.setPosition(x+(3*taille)/2, y-taille/2);
		quitter.setPosition(x+(5*taille)/2, y-taille/2);
		
		fermer.setPosition(x-(0.4f*taille)/2, y+(0.4f*taille)/2);
	}
	
	public void setPosition(Vector2f vect){
		float x = vect.x;
		float y = vect.y;
		
		ajouter.setPosition(x+taille/2,y-(3*taille)/2);
		ouvrir.setPosition(x+(3*taille)/2, y-(3*taille)/2);
		enregistrer.setPosition(x+(5*taille)/2, y-(3*taille)/2);
		
		aide.setPosition(x+taille/2, y-taille/2);
		aPropos.setPosition(x+(3*taille)/2, y-taille/2);
		quitter.setPosition(x+(5*taille)/2, y-taille/2);
		
		fermer.setPosition(x-(0.4f*taille)/2, y+(0.4f*taille)/2);
	}

	public Vector2f getEnregistrerBounds(){
		return new Vector2f(enregistrer.getPosition().x, enregistrer.getPosition().y);
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return this.visible;
	}
	
	public boolean isInsideAjouter(TuioCursor cursor){
		return ajouter.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public boolean isInsideOuvrir(TuioCursor cursor){
		return ouvrir.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public boolean isInsideEnregistrer(TuioCursor cursor){
		return enregistrer.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public boolean isInsideAide(TuioCursor cursor){
		return aide.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public boolean isInsideAPropos(TuioCursor cursor){
		return aPropos.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public boolean isInsideQuitter(TuioCursor cursor){
		return quitter.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public boolean isInsideFermer(TuioCursor cursor){
		return fermer.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}

	
	public void actionMenu(TuioCursor c){
		
		Clock temps = new Clock();
		TuioPoint position = c.getPosition();
		while (c.getTuioState() != 4) {
			if (position.getDistance(c.getPosition()) > 0.01)
				break;
			if (temps.getElapsedTime().asMilliseconds() > 1500)
				break;
		}
		if (temps.getElapsedTime().asMilliseconds() < 1500)
			return;

		if (!Systeme.menu.isVisible()) {
			Systeme.menu.setPosition(c);
			Systeme.menu.setVisible(true);
		} else {
			if (Systeme.menu.isInsideAjouter(c)) {
				GesteSysteme.ouvrir();
			} else if (Systeme.menu.isInsideOuvrir(c)) {
				try {
					Systeme.conteneur.charger("testImg");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (Systeme.menu.isInsideEnregistrer(c)) {
					Systeme.clavier.setPosition(c);
					if (Systeme.clavier.getSupprBounds().x < Systeme.screen.x && Systeme.clavier.getSupprBounds().y < Systeme.screen.y){
						Systeme.clavier.setPosition(c);
						System.out.println("tototototo");
					}else{
						Vector2f vect = new Vector2f(Systeme.screen.x/2,Systeme.screen.y/2);
						Systeme.clavier.setPosition(vect);
						System.out.println("titiii");
					}
					Systeme.clavier.setVisible(true);
					Systeme.menu.setVisible(false);
					
				}else if (Systeme.menu.isInsideAide(c)) {
					Systeme.help.setVisible(true);
					Systeme.help.setPosition(c);
					Systeme.menu.setVisible(false);
			}else if (Systeme.menu.isInsideAPropos(c)) {
				Systeme.about.actionAbout(c);
			}else if (Systeme.menu.isInsideQuitter(c)){
				Systeme.quitter.setVisible(true);
				try {
					Systeme.quitter.affiche();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}else if (Systeme.menu.isInsideFermer(c)) {
				Systeme.menu.setVisible(false);
			}
		}
	}
	
	}// end Menu
	

