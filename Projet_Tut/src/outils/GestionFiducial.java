package outils;

import image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import application.Systeme;
import TUIO.TuioObject;

public class GestionFiducial {

	TuioObject fiducial;
	int id;
	static String url;
	boolean charger = false;

	public GestionFiducial(TuioObject tobj) {
		System.out.println("instanciation d'un fiducial");
		this.fiducial = tobj;
		this.id = tobj.getSymbolID();
		this.charger = true;

	}

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
	@SuppressWarnings("unchecked")
	public static void retirerFiducial(String nomFic) throws Exception {
		File f1 = new File(nomFic);
		FileInputStream fe = new FileInputStream(f1);
		ObjectInputStream feObj = new ObjectInputStream(fe);
		Systeme.leConteneur = (ArrayList<String>) feObj.readObject();
		feObj.close();
		if (!Systeme.leConteneur.isEmpty()) {
			for (String url : Systeme.leConteneur) {
				for (int i = 0; i < Systeme.listImage.size(); i++) {
					Image img = Systeme.listImage.getImage(i);
					String path = img.url;
					if (url.equals(path)) {
						System.out.println("URL = " + url);
						Systeme.listImage.retirer(img);
					}
				}

			}

		}
	}
}
