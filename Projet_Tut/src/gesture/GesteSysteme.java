package gesture;

import image.GesteImage;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import mouse.TuioMouse;

import org.jsfml.system.Clock;

import TUIO.TuioClient;
import TUIO.TuioCursor;
import TUIO.TuioPoint;
import application.Systeme;

public class GesteSysteme implements Runnable {

	private boolean running;

	public GesteSysteme() {
		running=true;
	}
	
	public void stop (){
		 this.running=false;
	 }
	
	@Override
	public void run() {
		while (running)
		{
			event();
			pause(10);
		}

	}

	void pause(int milliseconde){
		try 
		{
			Thread.sleep(milliseconde);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}


	void event() {
		Vector<TuioCursor> cursorList = Systeme.tuioClient.getTuioCursors();

		TuioCursor cursor;
		Vector<TuioCursor> Listcursor = new Vector<TuioCursor>();
		for (Iterator<TuioCursor> iter = cursorList.iterator();iter.hasNext();){
			cursor = iter.next();

			if ( GesteImage.curseurAttribue.contains(new Integer(cursor.getCursorID())) )
				continue;

			//GesteImage.curseurAttribue.add(cursor.getCursorID());
			Listcursor.add(cursor);

		}
		switch (Listcursor.size())
		{
		case 1:
			TuioCursor c = Listcursor.get(0);
			if(Systeme.menu.isVisible()){
				if(Systeme.menu.isInsideToucheHaut(c)){
					ouvrir();
				}else if(Systeme.menu.isInsideToucheDroit(c)){
					System.out.println("ToucheDroite");
				}else if(Systeme.menu.isInsideToucheBas(c)){
					System.out.println("ToucheBas");
				}else if(Systeme.menu.isInsideToucheGauche(c)){
					about(c);
				}
			}
			if(Systeme.about.isVisible()){
				about(Listcursor.get(0));
			}else{
				menu(Listcursor.get(0));
			}
			
			break;

		}
//		for (TuioCursor c : Listcursor)
//			GesteImage.curseurAttribue.remove(new Integer(c.getCursorID()));

	}

	void menu(TuioCursor c1){
		
			Clock temps = new Clock();
			TuioPoint position = c1.getPosition();
			while(c1.getTuioState()!=4){
				if (position.getDistance(c1.getPosition())>0.01)
					break;
				if (temps.getElapsedTime().asMilliseconds()>1500)
					 break;
			 }
			if (temps.getElapsedTime().asMilliseconds()<1500)
				return;
			
			if(!Systeme.menu.isVisible()){
				Systeme.menu.setPosition(c1);
				Systeme.menu.setVisible(true);
			}else{
				if(Systeme.menu.isInsideCarre(c1)){
					Systeme.menu.setVisible(false);
				}
			}

	}
	
	void about(TuioCursor c1){
		Clock temps = new Clock();
		TuioPoint position = c1.getPosition();
		while(c1.getTuioState()!=4){
			if (position.getDistance(c1.getPosition())>0.01)
				break;
			if (temps.getElapsedTime().asMilliseconds()>1000)
				 break;
		 }
		if (temps.getElapsedTime().asMilliseconds()<1000)
			return;
		
		if(!Systeme.about.isVisible()){
			Systeme.about.setPosition(c1);
			Systeme.about.setVisible(true);
			Systeme.menu.setVisible(false);
		}else{
			if(Systeme.about.isInsideCarre(c1)){
				Systeme.about.setVisible(false);
			}
		}
	}
	
void ouvrir (){
		
		Systeme.tuioClient.disconnect();
		
 		TuioMouse mouse = new TuioMouse();
		TuioClient client = new TuioClient(3333);

		client.addTuioListener(mouse);
		client.connect();
		
		JFileChooser chooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) 
			Systeme.listImage.ajouter(chooser.getSelectedFile().getAbsolutePath());
			
		client.disconnect();
		Systeme.tuioClient.connect();
		
	}

}
