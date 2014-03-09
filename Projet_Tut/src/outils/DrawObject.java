package outils;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import TUIO.TuioObject;
import application.Systeme;

public class DrawObject implements Drawable{

	static CircleShape fiducialMusique;
	RectangleShape fiducialImage;
	
	Texture textFiducialMusique;
	Texture textFiducialImage;
	
	boolean visible = false;
	
	public DrawObject(){
		
	}
	public DrawObject(TuioObject tObj){
		initialisation(tObj);
	}
	
	public void initialisation(TuioObject tuioObject){
		if (tuioObject.getSymbolID() < 4){
			
			textFiducialImage = new Texture();
			try {
				textFiducialImage.loadFromFile(Paths.get("images/bouton/photo.png"));
			} catch (IOException e1) {
				System.out.println("Erreur texture");
			}
			
			Vector2f ecran  = new Vector2f(Systeme.window.getSize().x,Systeme.window.getSize().y);
			Vector2f position = new Vector2f(tuioObject.getX(),tuioObject.getY());
			fiducialImage = new RectangleShape(new Vector2f(40, 40));
			fiducialImage.setOrigin(20/2,20/2);
			fiducialImage.move(Vector2f.componentwiseMul(position, ecran));
			fiducialImage.setRotation(tuioObject.getAngleDegrees());
			fiducialImage.setTexture(textFiducialImage);
			Systeme.window.draw(fiducialImage);
			Systeme.drawString(Integer.toString(tuioObject.getSymbolID()),fiducialImage.getPosition().x-20,fiducialImage.getPosition().y-20);
				
			setVisible(true);
		}else if(tuioObject.getSymbolID()>=4 && tuioObject.getSymbolID() < 8){
			textFiducialMusique = new Texture();
			try {
				textFiducialMusique.loadFromFile(Paths.get("images/bouton/musique.png"));
			} catch (IOException e1) {
				System.out.println("Erreur texture");
			}
			
			Vector2f ecran  = new Vector2f(Systeme.window.getSize().x,Systeme.window.getSize().y);
			Vector2f position = new Vector2f(tuioObject.getX(),tuioObject.getY());
			fiducialMusique = new CircleShape(20);
			fiducialMusique.setOrigin(20/2,20/2);
			fiducialMusique.move(Vector2f.componentwiseMul(position, ecran));
			fiducialMusique.setRotation(tuioObject.getAngleDegrees());
			fiducialMusique.setTexture(textFiducialMusique);
			Systeme.drawString(Integer.toString(tuioObject.getSymbolID()),fiducialMusique.getPosition().x-20,fiducialMusique.getPosition().y-20);
			Systeme.window.draw(fiducialMusique);
			setVisible(true);
		}	
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if(visible){
			
			
		}
		
	}
	
	public boolean isInsideFiducialImage(TuioCursor cursor){
		return fiducialImage.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
	
	public static boolean isInsideFiducialMusique(TuioCursor cursor){
		return fiducialMusique.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}

	public boolean isVisible(){
		return this.visible;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}
}
