package outils;

import application.Systeme;
import TUIO.TuioObject;

public class GestionFiducial{

	
	TuioObject		fiducial;
	int				id;
	static String	url;
	boolean			charger=false;
	
	public GestionFiducial(TuioObject tobj){
			System.out.println("instanciation d'un fiducial");
			this.fiducial = tobj;
			this.id = tobj.getSymbolID();
			this.charger = true;

	}

	public static void actionFiducial(TuioObject tobj) throws Exception {
		switch((int) tobj.getSymbolID()){
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
}
