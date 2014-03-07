
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


import java.io.*;
import java.util.ArrayList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import application.Systeme;

public class Conteneur implements Drawable, Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 8908896394581817566L;

	/* Attributs */
	RectangleShape conteneur;

	boolean visible = true;

	float width = Systeme.window.getSize().x;
	float positionWidth = 10;
	float height = Systeme.window.getSize().y;
	float positionHeight = height - height / 10 + 2;

	
	int nombreImage = 0;

	/* Constructeur */
	public Conteneur() {
		initialisationConteneur();
	}

	/* Getters & Setters */

	/* Methodes */

	public void initialisationConteneur() {
		conteneur = new RectangleShape(new Vector2f(width - 10, height / 10));
		conteneur.setOutlineColor(Color.WHITE);
		conteneur.setOutlineThickness(3);
		conteneur.setFillColor(new Color(255, 255, 255, 50));
		this.setPositionConteneur();
	}

	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible) {
			conteneur.draw(arg0, arg1);
		}

	}

	public void setSizeConteneur() {
		conteneur.setSize(new Vector2f(Systeme.window.getSize().x - 10,
				Systeme.window.getSize().y / 10));
	}

	public void setPositionConteneur() {
		conteneur.setPosition(5,
				Systeme.window.getSize().y - (Systeme.window.getSize().y / 10));
	}

	public void addDossier(ListeImage l) {
	}

	public void deleteDossier() {

	}

	public int nombreImage() {
		return nombreImage;
	}

	public void ajouterImage(Image i) {
		if (!i.isInConteneur()) {
			i.setIsInConteneur(true);
			nombreImage = nombreImage + 1;
			i.setSize(20, 20);
			i.sprite.setPosition(nombreImage * 50, Systeme.window.getSize().y - 20);
			Systeme.leConteneur.add(i.getPath());
			System.out.println(Systeme.leConteneur.size());
		}
	}

	public void enleverImage(Image i) {
		if (i.isInConteneur()) {
			i.setIsInConteneur(false);
			nombreImage = nombreImage - 1;
			i.setSize(20, 20);
			Systeme.leConteneur.remove(i.getPath());
			System.out.println(Systeme.leConteneur.size());
		}
	}

	public boolean isInsideConteneur(TuioCursor cursor) {
		return conteneur.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public void setVisible(boolean v) {
		this.visible = v;
	}

	public boolean isVisible() {
		return visible;
	}

	public void sauvegarder(String nomFic)throws Exception{
        File f1=new File(nomFic); // declaration du fichier
        System.out.println("Ouverture du fichier");
        FileOutputStream fs= new FileOutputStream(f1);
        System.out.println("New ObjectOutputStream");
        ObjectOutputStream fsObj = new ObjectOutputStream(fs);
        System.out.println("Ecriture du conteneur");
        fsObj.writeObject(Systeme.leConteneur);  // ecriture du conteneur
        System.out.println("Close ecriture");
        fsObj.close(); //on ferme le flot
    }
	
	//suppression des warnings
    @SuppressWarnings("unchecked")
    public void charger(String nomFic) throws Exception{
        File f1=new File(nomFic);
        System.out.println("Ouverture du fichier");
        FileInputStream fe = new FileInputStream(f1);
        System.out.println("New ObjectInputStream");
        ObjectInputStream feObj = new ObjectInputStream(fe);
        System.out.println("feObj.readObject");
        Systeme.leConteneur=(ArrayList<String>) feObj.readObject();
        System.out.println("close");
        feObj.close(); 
        if(!Systeme.leConteneur.isEmpty()) 
        {
            for(String url : Systeme.leConteneur){
           	Systeme.listImage.ajouter(url);
            }
        }
        
    }
	
}
