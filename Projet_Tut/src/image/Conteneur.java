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

package image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class Conteneur.
 */
public class Conteneur extends RectangleShape implements  Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8908896394581817566L;

	/* Attributs */
	/** The conteneur. */

	/** The visible. */
	boolean visible = true;

	/** The position width. */
	float positionWidth = 10;

	/** The position height. */
	float positionHeight = Systeme.screen.y - Systeme.screen.y / 10 + 2;

	/** The nombre image. */
	int nombreImage = 0;

	/* Constructeur */
	/**
	 * Instantiates a new conteneur.
	 */
	public Conteneur() {
		super(new Vector2f(Systeme.screen.x - 10, Systeme.screen.y / 10));
		setOutlineColor(Color.WHITE);
		setOutlineThickness(3);
		setFillColor(new Color(255, 255, 255, 50));
		this.setPositionConteneur();
	}

	/* Getters & Setters */

	/* Methodes */

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget,
	 * org.jsfml.graphics.RenderStates)
	 */
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible) {
			super.draw(arg0, arg1);
		}

	}

	/**
	 * Sets the size conteneur.
	 */
	public void setSizeConteneur() {
		setSize(new Vector2f(Systeme.screen.x - 10, Systeme.screen.y / 10));
	}

	/**
	 * Sets the position conteneur.
	 */
	public void setPositionConteneur() {
		setPosition(5, Systeme.screen.y - (Systeme.screen.y / 10));
	}

	/**
	 * Adds the dossier.
	 * 
	 * @param l
	 *            the l
	 */
	public void addDossier(ListeImage l) {
	}

	/**
	 * Delete dossier.
	 */
	public void deleteDossier() {

	}

	/**
	 * Nombre image.
	 * 
	 * @return the int
	 */
	public int nombreImage() {
		return nombreImage;
	}

	/**
	 * Ajouter image.
	 * 
	 * @param i
	 *            the i
	 */
	public void ajouterImage(Image i) {
		if (!i.isInConteneur()) {
			i.setIsInConteneur(true);
			nombreImage = nombreImage + 1;
			i.setSize(60, getLocalBounds().height);
			i.setPosition(nombreImage * 50, Systeme.screen.y - 20);
			Systeme.pathImages.add(i.getPath());
		}
	}

	/**
	 * Enlever image.
	 * 
	 * @param i
	 *            the i
	 */
	public void enleverImage(Image i) {
		if (i.isInConteneur()) {
			i.setIsInConteneur(false);
			nombreImage = nombreImage - 1;
			i.setSize(200, 200);
			Systeme.pathImages.remove(i.getPath());
		}
	}

	/**
	 * Checks if is inside conteneur.
	 * 
	 * @param cursor
	 *            the cursor
	 * @return true, if is inside conteneur
	 */
	public boolean isInsideConteneur(TuioCursor cursor) {
		return getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	/**
	 * Sets the visible.
	 * 
	 * @param v
	 *            the new visible
	 */
	public void setVisible(boolean v) {
		this.visible = v;
	}

	/**
	 * Checks if is visible.
	 * 
	 * @return true, if is visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Sauvegarder.
	 * 
	 * @param nomFic
	 *            the nom fic
	 * @throws Exception
	 *             the exception
	 */
	public void sauvegarder(String nomFic) throws Exception {
	    
	    if(!new File(nomFic).exists())
	        {
	            // Créer le dossier avec tous ses parents
	            new File(nomFic).mkdirs();
	 
	        }
	    
		File f1 = new File(nomFic+".sauv"); // declaration du fichier
		FileOutputStream fs = new FileOutputStream(f1);
		ObjectOutputStream fsObj = new ObjectOutputStream(fs);
		fsObj.writeObject(Systeme.pathImages); // ecriture du conteneur
		fsObj.close(); // on ferme le flot
	}

	// suppression des warnings
	/**
	 * Charger.
	 * 
	 * @param nomFic
	 *            the nom fic
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unchecked")
	public void charger(String nomFic) throws Exception {
		File f1 = new File(nomFic);
		FileInputStream fe = new FileInputStream(f1);
		ObjectInputStream feObj = new ObjectInputStream(fe);
		Systeme.pathImages = (ArrayList<String>) feObj.readObject();
		feObj.close();
		if (!Systeme.pathImages.isEmpty()) {
			for (String url : Systeme.pathImages) {
				Systeme.listImage.ajouter(url);
			}
		}

	}

}
