package musique;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.audio.Music;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Clock;

import application.Systeme;
import TUIO.TuioCursor;
import TUIO.TuioObject;
import TUIO.TuioPoint;

public class MusiqueFiducial implements Drawable{

	static String 	url;
	static Music 	music = new Music();
	static int		enJeu;
	static boolean 	isPlay = false;
	boolean	visible= false;
	static boolean fiducialIsVisible = false;
	static CircleShape play, pause, stop, fermer;
	static Texture		textPlay, textPause, textStop, textFermer;
	static float taille = 20;
	
	public MusiqueFiducial(){
		initialisation();
	}
	
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

	public void setPosition(TuioCursor cursor){
		
		float x = cursor.getX()*Systeme.screen.x;
		float y = cursor.getY()*Systeme.screen.y;
		
		play.setPosition(x-30,y-60);
		pause.setPosition(x-90, y-60);
		stop.setPosition(x+30, y-60);
		fermer.setPosition(x+90, y-60);
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if(visible){
			play.draw(arg0, arg1);
			pause.draw(arg0, arg1);
			stop.draw(arg0, arg1);
			fermer.draw(arg0, arg1);
		}
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public int getEnJeu(){
		return MusiqueFiducial.enJeu;
	}
	
	@SuppressWarnings("static-access")
	public boolean isPlay(){
		return this.isPlay;
	}
	
	public void play(){
		music.play();
	}
	
	public void pause(){
		music.pause();
		isPlay=false;
	}
	
	public void stop(){
		music.stop();
		isPlay=false;
	}
	
	public boolean isVisible(){
		return this.visible;
	}
	
	public boolean fiducialIsVisible(){
		return MusiqueFiducial.fiducialIsVisible;
	}

	public void setFiducialIsVisible(boolean visible){
		MusiqueFiducial.fiducialIsVisible = visible;
	}
	
	public boolean isInsidePlay(TuioCursor cursor){
		return play.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);

	}
	
	public boolean isInsidePause(TuioCursor cursor){
		return pause.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);

	}
	
	public boolean isInsideStop(TuioCursor cursor){
		return stop.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}

	public boolean isInsideFermer(TuioCursor cursor){
		return fermer.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);

	}
	
	public void musiqueMenu(TuioCursor c1){
		if(!Systeme.musiqueMenu.isVisible()){
			/*if(DrawObject.isInsideFiducialMusique(c1)){
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
			}*/
			
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
	}
	
}