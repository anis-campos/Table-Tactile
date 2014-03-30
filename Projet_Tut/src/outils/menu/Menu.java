
/*
 * 		Projet Tutoré : Picture 4 Table 
 * 
 * Sujet : Application gestion image
 * 
 * Auteurs : DA SILVA CAMPOS Anis
 * 			 TEBOULE Linda
 * 			 DIALLO Amadou
 * 			 BENKIRANE Mohamed Ali
 * 
 * Date : 2013-2014
 *  
 */

package outils.menu;


import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;

import outils.GesteSysteme;
import outils.TuioMouse;
import application.Systeme;
import TUIO.TuioClient;
import TUIO.TuioCursor;
import TUIO.TuioPoint;

// TODO: Auto-generated Javadoc
/**
 * The Class Menu.
 */
public class Menu implements Drawable{

	/** Attributs. */
	
	float 			taille = 100;
	
	/** The ajouter. */
	RectangleShape 	ajouter;
	
	/** The text ajouter. */
	Texture			textAjouter;
	
	/** The ouvrir. */
	RectangleShape 	ouvrir;
	
	/** The text ouvrir. */
	Texture			textOuvrir;
	
	/** The enregistrer. */
	RectangleShape 	enregistrer;
	
	/** The text enregistrer. */
	Texture			textEnregistrer;
	
	/** The aide. */
	RectangleShape 	aide;
	
	/** The text aide. */
	Texture			textAide;
	
	/** The a propos. */
	RectangleShape 	aPropos;
	
	/** The text a propos. */
	Texture			textAPropos;
	
	/** The quitter. */
	RectangleShape 	quitter;
	
	/** The text quitter. */
	Texture			textQuitter;
	
	/** The fermer. */
	RectangleShape 	fermer;
	
	/** The text fermer. */
	Texture			textFermer;
	
	/** The visible. */
	boolean visible = false;
	
	
	/**
     * Constructeur.
     */
	public Menu() {
		initialisation();
	}
	
	/**
     * Methodes.
     */
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
	
	/* (non-Javadoc)
	 * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget, org.jsfml.graphics.RenderStates)
	 */
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

	
	/**
     * Sets the position.
     * 
     * @param cursor
     *            the new position
     */
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
	
	/**
     * Sets the position.
     * 
     * @param vect
     *            the new position
     */
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

	/**
     * Gets the enregistrer bounds.
     * 
     * @return the enregistrer bounds
     */
	public Vector2f getEnregistrerBounds(){
		return new Vector2f(enregistrer.getPosition().x, enregistrer.getPosition().y);
	}
	
	/**
     * Sets the visible.
     * 
     * @param visible
     *            the new visible
     */
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	/**
     * Checks if is visible.
     * 
     * @return true, if is visible
     */
	public boolean isVisible(){
		return this.visible;
	}
	
	/**
     * Checks if is inside ajouter.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside ajouter
     */
	public boolean isInsideAjouter(TuioCursor cursor){
		return ajouter.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	/**
     * Checks if is inside ouvrir.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside ouvrir
     */
	public boolean isInsideOuvrir(TuioCursor cursor){
		return ouvrir.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	/**
     * Checks if is inside enregistrer.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside enregistrer
     */
	public boolean isInsideEnregistrer(TuioCursor cursor){
		return enregistrer.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	/**
     * Checks if is inside aide.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside aide
     */
	public boolean isInsideAide(TuioCursor cursor){
		return aide.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	/**
     * Checks if is inside a propos.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside a propos
     */
	public boolean isInsideAPropos(TuioCursor cursor){
		return aPropos.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	/**
     * Checks if is inside quitter.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside quitter
     */
	public boolean isInsideQuitter(TuioCursor cursor){
		return quitter.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	/**
     * Checks if is inside fermer.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside fermer
     */
	public boolean isInsideFermer(TuioCursor cursor){
		return fermer.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}

	
	/**
     * Action menu.
     * 
     * @param c
     *            the c
     */
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
					//Systeme.conteneur.charger("testImg");
				    this.ouvrir();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (Systeme.menu.isInsideEnregistrer(c)) {
					Systeme.clavier.setPosition(c);
					if (Systeme.clavier.getSupprBounds().x < Systeme.screen.x && Systeme.clavier.getSupprBounds().y > 0){
						Systeme.clavier.setPosition(c);
					}else{
						Vector2f vect = new Vector2f(Systeme.screen.x/2,Systeme.screen.y/2);
						Systeme.clavier.setPosition(vect);
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
	
	public void ouvrir() {
		//Deconexion du clientTuio du systeme afin de connecter la souris
		Systeme.tuioClient.disconnect();
		
		//Connexion de la souris - on peut controler la souris. Pour cliquer il faut apuyer avec un deuxieme doigt
		TuioMouse mouse = new TuioMouse();
		TuioClient client = new TuioClient(3333);
		client.addTuioListener(mouse);
		client.connect();
		
		JFileChooser chooser = new JFileChooser("./images");
		//Filtrer les fichiers images
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Serialized images Files", "sauv");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		    try {
			Systeme.conteneur.charger(chooser.getSelectedFile().getAbsolutePath());
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		
		//deconnexion de la souris
		client.disconnect();
		//Reconnexion du Client Tuio du Systeme
		Systeme.tuioClient.connect();

	}
	
	}// end Menu
	

