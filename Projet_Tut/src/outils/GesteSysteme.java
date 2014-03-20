
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

package outils;

import image.GesteImage;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jsfml.system.Clock;

import TUIO.TuioClient;
import TUIO.TuioCursor;
import TUIO.TuioPoint;
import application.Systeme;

public class GesteSysteme implements Runnable {

	private boolean running;

	public GesteSysteme() {
		running = true;
	}

	public void stop() {
		this.running = false;
	}

	@Override
	public void run() {
		while (running) {
			try {
				event();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pause(10);
		}

	}

	void pause(int milliseconde) {
		try {
			Thread.sleep(milliseconde);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void event() throws Exception {
		Vector<TuioCursor> cursorList = Systeme.tuioClient.getTuioCursors();

		TuioCursor cursor;
		Vector<TuioCursor> Listcursor = new Vector<TuioCursor>();
		for (Iterator<TuioCursor> iter = cursorList.iterator(); iter.hasNext(); ) {
			cursor = iter.next();

			if (GesteImage.curseurAttribue.contains(new Integer(cursor
					.getCursorID()))){
				continue;	
			}
			
			// GesteImage.curseurAttribue.add(cursor.getCursorID());
			Listcursor.add(cursor);
		}
		
		switch (Listcursor.size()) {
		case 1:
			TuioCursor c = Listcursor.get(0);
			if (Systeme.about.isVisible()) {
				Systeme.about.actionAbout(c);
			} else if (Systeme.clavier.isVisible()){
				clavier(c);
			}else if(Systeme.help.isVisible()){
				Systeme.help.actionHelp(c);
			}/*else if (DrawObject.isInsideFiducialMusique(c) || Systeme.musiqueMenu.isInsidePlay(c) || Systeme.musiqueMenu.isInsidePause(c) || Systeme.musiqueMenu.isInsideStop(c) || Systeme.musiqueMenu.isInsideFermer(c)){
				Systeme.musiqueMenu.isVisible();
				Systeme.musiqueMenu.musiqueMenu(c);
			}*/
		else{
				Systeme.menu.actionMenu(c);
			}

			break;
	
		}
		// for (TuioCursor c : Listcursor)
		// GesteImage.curseurAttribue.remove(new Integer(c.getCursorID()));
	}

	static void clavier(TuioCursor c1) {
		if (!Systeme.clavier.isVisible()) {
			Systeme.clavier.setPosition(c1);
			Systeme.clavier.setVisible(true);
			Systeme.menu.setVisible(false);
		} else {
			Clock temps = new Clock();
			TuioPoint position = c1.getPosition();
			while (c1.getTuioState() != 4) {
				if (position.getDistance(c1.getPosition()) > 0.01)
					break;
				if (temps.getElapsedTime().asMilliseconds() > 500)
					break;
			}
			if (temps.getElapsedTime().asMilliseconds() < 500)
				return;
			if (Systeme.clavier.isInsideFermer(c1)) {
					Systeme.clavier.setVisible(false);
			}else{
				if(Systeme.clavier.isValide()){
					validation();
				}else{
					Systeme.clavier.saisie(c1);
				}
					
			}
		}
	}
	
	public static void validation(){
		if(Systeme.clavier.isValide()){
			try {
				Systeme.conteneur.sauvegarder(Systeme.clavier.getUrl());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		Systeme.clavier.setVisible(false);
	}

	public static void ouvrir() {
		//Deconexion du clientTuio du systeme afin de connecter la souris
		Systeme.tuioClient.disconnect();
		
		//Connexion de la souris - on peut controler la souris. Pour cliquer il faut apuyer avec un deuxieme doigt
		TuioMouse mouse = new TuioMouse();
		TuioClient client = new TuioClient(3333);
		client.addTuioListener(mouse);
		client.connect();
		
		JFileChooser chooser = new JFileChooser();
		//Filtrer les fichiers images
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Images Files", "jpg", "gif","png","jpeg","bmp");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			Systeme.listImage.ajouter(chooser.getSelectedFile().getAbsolutePath());
		
		//deconnexion de la souris
		client.disconnect();
		//Reconnexion du Client Tuio du Systeme
		Systeme.tuioClient.connect();

	}

}
