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

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jsfml.system.Vector2f;

import TUIO.TuioCursor;
import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class Geste.
 *
 * @author TheKing973
 */
public class GesteImage implements Runnable {	

	/** The monimage. */
	private Image monimage;

	/** The running. */
	private boolean running=true;

	/** The scale. */
	private Vector2f scale ;
	
	/** The rotation. */
	private float rotation;

	/** The curseur attribue. */
	public static List<Integer> curseurAttribue = new ArrayList<Integer>();
	 
	
	public void stop (){
		 this.running=false;
	 }
	
	/**
	 * Zoom.
	 *
	 * @param cursor1 the cursor1
	 * @param cursor2 the cursor2
	 */
	void zoom (TuioCursor cursor1, TuioCursor cursor2){

		double distance=0;
		boolean enzoom = false;
		while (cursor1.getTuioState()!=4 && cursor2.getTuioState()!=4)
		{ 
			Vector2f point1 = cursorToPoint(cursor1);
			Vector2f point2 = cursorToPoint(cursor2);

			double tmp = Point.distance(point1.x, point1.y, point2.x, point2.y);

			if (inImage(point1) && inImage(point2) && !enzoom )
			{	
				enzoom=true;
				distance = tmp;
			}
			else if (enzoom )
			{

				if ( tmp - distance >3 )
				{
					scale=Vector2f.add(scale, new Vector2f(0.1f,0.1f));
					monimage.sprite.setScale(scale);
				}
				if (distance - tmp >3 && scale.x>0.2)
				{
					scale=Vector2f.sub(scale, new Vector2f(0.1f,0.1f));
					monimage.sprite.setScale(scale);
				}
				enzoom=false;

			}
			pause(20);
		}
	}

	/**
	 * Move.
	 *
	 * @param curseur the curseur
	 */
	void move(TuioCursor curseur)
	{

		while (curseur.getTuioState()!=4)
		{

			Vector2f posCurseur_av = cursorToPoint(curseur);

			pause(50);

			Vector2f posCurseur_ap = cursorToPoint(curseur);
			Vector2f deplacement =Vector2f.sub(posCurseur_ap,posCurseur_av);
			Vector2f posImage = Vector2f.add(deplacement,monimage.sprite.getPosition());

			if ( posImage.x>0 && posImage.y>0 && posImage.x<Systeme.screen.x && posImage.y<Systeme.screen.y)
				monimage.sprite.setPosition(posImage);
		}
	}

	/**
	 * Pivoter.
	 *
	 * @param cursor1 the cursor1
	 * @param cursor2 the cursor2
	 * @param cursor3 the cursor3
	 */
	void pivoter(TuioCursor cursor1, TuioCursor cursor2, TuioCursor cursor3){
		double angle=0;
		Vector2f droite1;
		Vector2f droite2;
		while (cursor1.getTuioState()!=4 || cursor2.getTuioState()!=4 || cursor3.getTuioState()!=4)
		{ 


			droite1 = equationDroite(cursorToPoint(cursor1), cursorToPoint(cursor2));
			pause(30);
			droite2 = equationDroite(cursorToPoint(cursor1), cursorToPoint(cursor2));

			angle = angle2Droite(droite1, droite2);

			rotation=(float) (rotation + angle*50);
			rotation=(rotation>360)?rotation-360:rotation;
			rotation=(rotation<-360)?rotation+360:rotation;
			monimage.sprite.setRotation(rotation);



		}
	}

	/**
	 * Pause.
	 *
	 * @param milliseconde the milliseconde
	 */
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

	/**
	 * In image.
	 *
	 * @param point the point
	 * @return true, if successful
	 */
	boolean inImage(Vector2f point)
	{
		return monimage.sprite.getGlobalBounds().contains(point);	
	}

	/**
	 * In image.
	 *
	 * @param cursor the cursor
	 * @return true, if successful
	 */
	boolean inImage(TuioCursor cursor)
	{

		Vector2f point = cursorToPoint(cursor);
		return inImage(point);

	}

	/**
	 * Cursor to point.
	 *
	 * @param cursor the cursor
	 * @return the vector2f
	 */
	Vector2f cursorToPoint(TuioCursor cursor)
	{
		return new Vector2f(cursor.getPosition().getScreenX(Systeme.screen.x),cursor.getPosition().getScreenY(Systeme.screen.y));
	}

	/**
	 * Instantiates a new geste.
	 *
	 * @param image the image
	 */
	public GesteImage (Image image)
	{

		monimage = image; 
		this.scale=monimage.sprite.getScale();
		this.rotation=monimage.sprite.getRotation();
	}

	/**
	 * Event.
	 */
	void event(){

		Vector<TuioCursor> cursorList = Systeme.tuioClient.getTuioCursors();

		TuioCursor cursor;
		Vector<TuioCursor> cursorInImage = new Vector<TuioCursor>();
		synchronized (GesteImage.class) {
			
			for (Iterator<TuioCursor> iter = cursorList.iterator();iter.hasNext();){
				cursor = iter.next();

				if ( curseurAttribue.contains(new Integer(cursor.getCursorID())))
					continue;




				if (inImage(cursor))
				{
					cursorInImage.add(cursor);

					curseurAttribue.add(new Integer(cursor.getCursorID()));

				}
				

			}
		} 
		switch (cursorInImage.size()){
		case 1:
			monimage.dernierAcces=System.currentTimeMillis();
			move(cursorInImage.get(0));
			break;

		case 2:
			monimage.dernierAcces=System.currentTimeMillis();
			zoom(cursorInImage.get(0), cursorInImage.get(1));
			break;

		case 3:
			monimage.dernierAcces=System.currentTimeMillis();
			pivoter(cursorInImage.get(0), cursorInImage.get(1),cursorInImage.get(2));
			break;

		default :
			break;
		}

		synchronized (GesteImage.class) {
			for (TuioCursor c : cursorInImage)
				curseurAttribue.remove(new Integer(c.getCursorID()));	

		} 



	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (running)
		{
			event();
			pause(10);
		}

	}

	/**
	 * Equation droite.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 * @return the vector2f
	 */
	Vector2f equationDroite(Vector2f p1, Vector2f p2) {
		if (p1.x == p2.x) return null;
		float a = (p2.y-p1.y) / (p2.x-p1.x);
		float b = p1.y - a * p1.x;
		return new Vector2f(a,b);
	}


	/**
	 * Angle2 droite.
	 *
	 * @param d1 the d1
	 * @param d2 the d2
	 * @return the float
	 */
	float angle2Droite( Vector2f d1, Vector2f d2){
		float angle;
		if ( d1 == null || d2 == null)
			angle = 0;
		else 
			angle = (float) Math.atan((d2.x -d1.x)/(1+d2.x*d1.x));
		return angle;
	}



}
