
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

import image.GesteImage;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jsfml.system.Vector2f;

import TUIO.TuioClient;
import TUIO.TuioCursor;
import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class GesteSysteme.
 */
public class GesteSysteme implements Runnable {

	/** The running. */
	private boolean running;

	/**
     * Instantiates a new geste systeme.
     */
	public GesteSysteme() {
		running = true;
	}

	/**
     * Stop.
     */
	public void stop() {
		this.running = false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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

	/**
     * Pause.
     * 
     * @param milliseconde
     *            the milliseconde
     */
	void pause(int milliseconde) {
		try {
			Thread.sleep(milliseconde);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
     * Event.
     * 
     * @throws Exception
     *             the exception
     */
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
				Systeme.clavier.ouvrirClavier(c);
			}else if(Systeme.help.isVisible()){
				Systeme.help.actionHelp(c);
			}/*else if (DrawObject.isInsideFiducialMusique(c) || Systeme.musiqueMenu.isInsidePlay(c) || Systeme.musiqueMenu.isInsidePause(c) || Systeme.musiqueMenu.isInsideStop(c) || Systeme.musiqueMenu.isInsideFermer(c)){
				Systeme.musiqueMenu.isVisible();
				Systeme.musiqueMenu.musiqueMenu(c);
			}*/
		else{
			if (Systeme.menu.getEnregistrerBounds().x < Systeme.screen.x && Systeme.menu.getEnregistrerBounds().y < Systeme.screen.y){
				Systeme.menu.actionMenu(c);
			}else{
				
				Vector2f vect = new Vector2f(Systeme.screen.x/2,Systeme.screen.y/2);
				Systeme.menu.setPosition(vect);
				Systeme.menu.actionMenu(c);	
			}
			}

			break;
	
		}
		// for (TuioCursor c : Listcursor)
		// GesteImage.curseurAttribue.remove(new Integer(c.getCursorID()));
	}

	
	

	/**
     * Ouvrir.
     */
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
