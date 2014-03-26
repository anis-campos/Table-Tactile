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
package outils;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.audio.Music;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;

import TUIO.TuioCursor;
import TUIO.TuioObject;
import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class MusiqueFiducial.
 */
public class MusiqueFiducial implements Drawable{

	/** The url. */
	static String 	url;
	
	/** The music. */
	static Music 	music = new Music();
	
	/** The en jeu. */
	static int		enJeu;
	
	/** The is play. */
	static boolean 	isPlay = false;
	
	/** The visible. */
	boolean	visible= false;
	
	/** The fiducial is visible. */
	static boolean fiducialIsVisible = false;
	
	/** The fermer. */
	static CircleShape play, pause, stop, fermer;
	
	/** The text fermer. */
	static Texture		textPlay, textPause, textStop, textFermer;
	
	/** The taille. */
	static float taille = 20;
	
	/**
     * Instantiates a new musique fiducial.
     */
	public MusiqueFiducial(){
		initialisation();
	}
	
	/**
     * Action fiducial ajout.
     * 
     * @param tobj
     *            the tobj
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
	public static void actionFiducialAjout(TuioObject tobj) throws IOException {
		switch ((int) tobj.getSymbolID()) {
		case 4:
			url="musique/4.ogg";
			if(!isPlay){
				music.openFromFile(Paths.get(url));
				music.play();
				isPlay = true;
				enJeu = 4;
				fiducialIsVisible = true;
			}
			break;

		case 5:
			url="musique/5.ogg";
			if(!isPlay){
				music.openFromFile(Paths.get(url));
				music.play();
				isPlay = true;
				enJeu = 5;
				fiducialIsVisible = true;
			}
			break;

		case 6:
			url="musique/6.ogg";
			if(!isPlay){
				music.openFromFile(Paths.get(url));
				music.play();
				isPlay = true;
				enJeu = 6;
				fiducialIsVisible = true;
			}
			break;

		case 7:
			url="musique/7.ogg";
			if(!isPlay){
				music.openFromFile(Paths.get(url));
				music.play();
				isPlay = true;
				enJeu = 7;
				fiducialIsVisible = true;
			}
			break;
		default:
			break;
		}

	}
	
	/**
     * Action fiducial retrait.
     * 
     * @param tobj
     *            the tobj
     */
	public static void actionFiducialRetrait(TuioObject tobj){
		switch ((int) tobj.getSymbolID()){
			case 4:
				if(isPlay && enJeu == 4){
					music.stop();
					isPlay = false;
					enJeu=0;
				}
				break;
				
			case 5:
				if(isPlay && enJeu == 5){
					music.stop();
					isPlay = false;
					enJeu=0;
				}
				break;
				
			case 6:
				if(isPlay && enJeu == 6){
					music.stop();
					isPlay = false;
					enJeu=0;
				}
				break;
			
			case 7:
				if(isPlay && enJeu == 7){
					music.stop();
					isPlay = false;
					enJeu=0;
				}
				break;
				
			default:
				break;
		}
	}
	
	/**
     * Initialisation.
     */
	public static void initialisation(){
		
		textPlay = new Texture();
		try {
			textPlay.loadFromFile(Paths.get("images/bouton/play.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		play 	= new CircleShape(taille);
		play.setOrigin(taille/2, taille/2);
		play.setTexture(textPlay);
		
		
		textPause = new Texture();
		try {
			textPause.loadFromFile(Paths.get("images/bouton/pause.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		pause	= new CircleShape(taille);
		pause.setOrigin(taille/2, taille/2);
		pause.setTexture(textPause);
		
		
		textStop = new Texture();
		try {
			textStop.loadFromFile(Paths.get("images/bouton/stop.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		stop	= new CircleShape(taille);
		stop.setOrigin(taille/2, taille/2);
		stop.setTexture(textStop);
		
		textFermer = new Texture();
		try {
			textFermer.loadFromFile(Paths.get("images/bouton/fermer.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		fermer	= new CircleShape(taille);
		fermer.setOrigin(taille/2, taille/2);
		fermer.setTexture(textFermer);
		
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
		
		play.setPosition(x-30,y-60);
		pause.setPosition(x-90, y-60);
		stop.setPosition(x+30, y-60);
		fermer.setPosition(x+90, y-60);
	}
	
	/* (non-Javadoc)
	 * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget, org.jsfml.graphics.RenderStates)
	 */
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if(visible){
			play.draw(arg0, arg1);
			pause.draw(arg0, arg1);
			stop.draw(arg0, arg1);
			fermer.draw(arg0, arg1);
		}
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
     * Gets the en jeu.
     * 
     * @return the en jeu
     */
	public int getEnJeu(){
		return MusiqueFiducial.enJeu;
	}
	
	/**
     * Checks if is play.
     * 
     * @return true, if is play
     */
	@SuppressWarnings("static-access")
	public boolean isPlay(){
		return this.isPlay;
	}
	
	/**
     * Play.
     */
	public void play(){
		music.play();
	}
	
	/**
     * Pause.
     */
	public void pause(){
		music.pause();
		isPlay=false;
	}
	
	/**
     * Stop.
     */
	public void stop(){
		music.stop();
		isPlay=false;
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
     * Fiducial is visible.
     * 
     * @return true, if successful
     */
	public boolean fiducialIsVisible(){
		return MusiqueFiducial.fiducialIsVisible;
	}

	/**
     * Sets the fiducial is visible.
     * 
     * @param visible
     *            the new fiducial is visible
     */
	public void setFiducialIsVisible(boolean visible){
		MusiqueFiducial.fiducialIsVisible = visible;
	}
	
	/**
     * Checks if is inside play.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside play
     */
	public boolean isInsidePlay(TuioCursor cursor){
		return play.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);

	}
	
	/**
     * Checks if is inside pause.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside pause
     */
	public boolean isInsidePause(TuioCursor cursor){
		return pause.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);

	}
	
	/**
     * Checks if is inside stop.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside stop
     */
	public boolean isInsideStop(TuioCursor cursor){
		return stop.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
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
     * Musique menu.
     * 
     * @param c1
     *            the c1
     */
	/*public void musiqueMenu(TuioCursor c1){
		if(!Systeme.musiqueMenu.isVisible()){
			if(DrawObject.isInsideFiducialMusique(c1)){
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
				
				Systeme.musiqueMenu.setVisible(true);
				Systeme.musiqueMenu.setPosition(c1);	
			}
			
		}else{
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
			if (Systeme.musiqueMenu.isInsidePlay(c1)) {
				Systeme.musiqueMenu.play();
			}else if (Systeme.musiqueMenu.isInsidePause(c1)){
				Systeme.musiqueMenu.pause();
			}else if(Systeme.musiqueMenu.isInsideStop(c1)){
				Systeme.musiqueMenu.stop();
			}else if(Systeme.musiqueMenu.isInsideFermer(c1)){
				Systeme.musiqueMenu.setVisible(false);
			}
		}
	}*/
	
}