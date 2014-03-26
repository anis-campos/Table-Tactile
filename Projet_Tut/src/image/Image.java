
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

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class Image.
 */
public class Image extends Sprite implements Comparable<Image>, Serializable{
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3268929958255928707L;


	/** The path of the image. */
	private String path;
	
	/** The gesture. */
	private GesteImage  gesture;
	
	/** The thread. */
	private Thread thread ;
	
	/** The dernier acces. */
	public long dernierAcces = 0;

	/** The position. */
	static private Vector2f position = new Vector2f(100f,100f);
	
	/** The compteur. */
	private static int compteur=0;
	
	/** Id image. */
	private static int dernierID=0;
	
	/** The id. */
	private String id;
	
	/** The ecart. */
	private final Vector2f ecart = new Vector2f(50f,50f);
	
	/** Is in Conteneur. */
	private boolean isInConteneur = false;
	
	/**
     * Sets the size.
     * 
     * @param width
     *            the width
     * @param height
     *            the height
     */
	public void setSize(float width, float height){
		this.setScale(width/getLocalBounds().width, height/getLocalBounds().height);
		
	}
	
	/**
	 * Instantiates a new image.
	 *
	 * @param path the path
	 */
	public Image (String path){
		super();		
		this.path = path;
		this.id = "i"+String.valueOf(dernierID + 1);
		Texture texture = new Texture();
		try {
			texture.loadFromFile(Paths.get(path));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		Vector2i taille = texture.getSize();
		this.setTexture(texture);
		setOrigin(new Vector2f(Vector2i.div(taille, 2)));
		setPosition(position);
		if (position.x < Systeme.screen.x && position.y<Systeme.screen.y)
				position=Vector2f.add(position, ecart);
		else{
			compteur++;
			position = new Vector2f(100+compteur*150,100);
		}
		scale((float)200/taille.x,(float)200/taille.y);
		

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
		return this.path;
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
