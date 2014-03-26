
/*
 * 		Projet Tutoré : Table tactile
 * 
 * Sujet : Application gestion image
 * 
 * Auteurs : DA SILVA CAMPOS Anis
 * 			 TEBOULE Linda
 * 			 DIALLO Amadou
 * 			 BENKIRAN Mohamed
 * 
 * Date : 2013-2014
 *  
 */

package image;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class Image.
 */
public class Image implements Drawable, Comparable<Image>, Serializable{
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3268929958255928707L;

	/** The sprite. */
	public Sprite sprite;
	
	/** The path of the image. */
	public String url;
	
	/** The gesture. */
	private GesteImage  gesture;
	
	/** The thread. */
	private Thread thread ;
	
	/** The dernier acces. */
	public long dernierAcces = 0;

	/** The position. */
	static Vector2f position = new Vector2f(100f,100f);
	
	/** The compteur. */
	static int compteur=0;
	
	/** Id image. */
	static int dernierID=0;
	
	/** The id. */
	String id;
	
	/** The ecart. */
	final Vector2f ecart = new Vector2f(50f,50f);
	
	/** Is in Conteneur. */
	boolean isInConteneur = false;
	
	/**
     * Sets the size.
     * 
     * @param width
     *            the width
     * @param height
     *            the height
     */
	public void setSize(float width, float height){
		sprite.setScale(width/sprite.getGlobalBounds().width, height/sprite.getGlobalBounds().height);
		
	}
	
	/**
	 * Instantiates a new image.
	 *
	 * @param path the path
	 */
	public Image (String path){
		this.url = path;
		this.id = "i"+String.valueOf(dernierID + 1);
		Texture texture = new Texture();
		try {
			texture.loadFromFile(Paths.get(path));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		Vector2i taille = texture.getSize();
		sprite = new Sprite(texture);
		sprite.setOrigin(new Vector2f(Vector2i.div(taille, 2)));
		sprite.setPosition(position);
		if (position.x < Systeme.screen.x && position.y<Systeme.screen.y)
				position=Vector2f.add(position, ecart);
		else{
			compteur++;
			position = new Vector2f(100+compteur*150,100);
		}
		sprite.scale((float)200/taille.x,(float)200/taille.y);
		

		gesture = new GesteImage(this);
		thread = new Thread( gesture );
		thread.start();
		dernierID = dernierID + 1;
	}
	
	
	public boolean isRemoved(){
		return !gesture.isRunning();
	}
	
	
	/**
     * Checks if is in conteneur.
     * 
     * @return true, if is in conteneur
     */
	public boolean isInConteneur(){
		return isInConteneur;
	}
	
	/**
     * Sets the checks if is in conteneur.
     * 
     * @param isInC
     *            the new checks if is in conteneur
     */
	public void setIsInConteneur(boolean isInC){
		isInConteneur = isInC;
	}

	/**
     * Gets the id.
     * 
     * @return the id
     */
	public String getId(){
		return this.id;
	}
	
	/**
     * Gets the path.
     * 
     * @return the path
     */
	public String getPath(){
		return this.url;
	}

	/* (non-Javadoc)
	 * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget, org.jsfml.graphics.RenderStates)
	 */
	@Override
	public void draw(RenderTarget target, RenderStates states) {
		if(gesture.isRunning()){ 
		sprite.draw(target, states);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Image o) {
		if (this.dernierAcces == o.dernierAcces)
			return 0;
		else if (this.dernierAcces < o.dernierAcces)
			return -1;
		else
			return 1;
	}
	
	/**
     * Stop thread.
     */
	public void stopThread (){
		this.gesture.stop();
		try {
			this.thread.join();
			
		} catch (InterruptedException e) {
			// TODO Bloc catch genere automatiquement
			e.printStackTrace();
		}
	}

}
