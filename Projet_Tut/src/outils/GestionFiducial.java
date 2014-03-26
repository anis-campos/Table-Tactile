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

import image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import application.Systeme;
import TUIO.TuioObject;

// TODO: Auto-generated Javadoc
/**
 * The Class GestionFiducial.
 */
public class GestionFiducial {

    /** The url. */
    static String url;

    /**
     * Instantiates a new gestion fiducial.
     * 
     * @param tobj
     *            the tobj
     */
    public GestionFiducial(TuioObject tobj) {

    }

    /**
     * Action fiducial ajout.
     * 
     * @param tobj
     *            the tobj
     * @throws Exception
     *             the exception
     */
    public static void actionFiducialAjout(TuioObject tobj) throws Exception {
	switch ((int) tobj.getSymbolID()) {
	case 1:
	    url = "images/animaux/animaux.sauv";
	    Systeme.conteneur.charger(url);
	    break;
	case 2:
	    url = "images/voiture/voiture.sauv";
	    Systeme.conteneur.charger(url);
	    break;
	case 3:
	    url = "images/nature/nature.sauv";
	    Systeme.conteneur.charger(url);
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
     * @throws Exception
     *             the exception
     */
    public static void actionFiducialRetrait(TuioObject tobj) throws Exception {
	switch ((int) tobj.getSymbolID()) {
	case 1:
	    System.out.println("actionFiducialRetrait: " + tobj.getSymbolID());
	    url = "images/animaux/animaux.sauv";
	    retirerFiducial(url);
	    break;
	case 2:
	    System.out.println("actionFiducialRetrait: " + tobj.getSymbolID());
	    url = "images/voiture/voiture.sauv";
	    retirerFiducial(url);
	    break;
	case 3:
	    System.out.println("actionFiducialRetrait: " + tobj.getSymbolID());
	    url = "images/nature/nature.sauv";
	    retirerFiducial(url);
	    break;
	default:
	    break;
	}
    }

    // suppression des warnings
    /**
     * Retirer fiducial.
     * 
     * @param nomFic
     *            the nom fic
     * @throws Exception
     *             the exception
     */
    @SuppressWarnings("unchecked")
    public static void retirerFiducial(String nomFic) throws Exception {
	File f1 = new File(nomFic);
	FileInputStream fe = new FileInputStream(f1);
	ObjectInputStream feObj = new ObjectInputStream(fe);
	Systeme.pathImages = (ArrayList<String>) feObj.readObject();
	feObj.close();
	if (!Systeme.pathImages.isEmpty()) {
	    for (String url : Systeme.pathImages) {
		for (int i = 0; i < Systeme.listImage.size(); i++) {
		    Image img = Systeme.listImage.getImage(i);
		    String path = img.getPath();
		    if (url.equals(path)) {
			System.out.println("URL = " + url);
			Systeme.listImage.retirer(img);
		    }
		}

	    }

	}
    }
}
