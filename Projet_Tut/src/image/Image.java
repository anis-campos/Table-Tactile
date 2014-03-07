
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
public class Image implements Cloneable, Drawable,Comparable<Image>, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3268929958255928707L;

	/** The sprite. */
	public Sprite sprite;
	
	/** The path of the image*/
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
	
	/** Id image*/
	static int dernierID=0;
	String id;
	
	/** The ecart. */
	final Vector2f ecart = new Vector2f(50f,50f);
	
	/** Is in Conteneur*/
	boolean isInConteneur = false;
	
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
	
	public boolean isInConteneur(){
		return isInConteneur;
	}
	
	public void setIsInConteneur(boolean isInC){
		isInConteneur = isInC;
	}

	public String getId(){
		return this.id;
	}
	
	public String getPath(){
		return this.url;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Image clone () {
		Image tmp = null;
		try {
			tmp = (Image) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Erreur clonage");
			return null;
		}
		tmp.sprite=this.sprite;
		
		return tmp;
	}

	/* (non-Javadoc)
	 * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget, org.jsfml.graphics.RenderStates)
	 */
	@Override
	public void draw(RenderTarget target, RenderStates states) {
		sprite.draw(target, states);
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
