package gesture;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.List;

import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import TUIO.TuioClient;
import TUIO.TuioCursor;

/**
 * @author TheKing973
 *
 */
public class Geste implements Runnable {

	TuioClient tuioClient;
	public Vector2i screen;
	Sprite image;
	boolean enzoom = false;
	public boolean running=true;
	double distance=0;
	float scale = 1;
	
	static List<Integer> curseurAttribué = new ArrayList<Integer>();

	void zoom (TuioCursor c1, TuioCursor c2){

		Vector2f point1 = new Vector2f(c1.getPosition().getScreenX(screen.x),
				c1.getPosition().getScreenY(screen.y));
		Vector2f point2 = new Vector2f(c2.getPosition().getScreenX(screen.x),
				c2.getPosition().getScreenY(screen.y));
		double tmp = Point.distance(point1.x, point1.y, point2.x, point2.y);
		if (image.getGlobalBounds().contains(point1) && image.getGlobalBounds().contains(point2) && !enzoom )
		{	enzoom=true;
		distance = tmp;
		}
		else if (enzoom  )
		{

			if ( tmp - distance >3 )
			{
				scale=scale+0.1f;
				image.setScale(scale,scale);
			}
			if (distance - tmp >3 && scale>0.1)
			{
				scale=scale-0.1f;
				image.setScale(scale, scale);
			}
			enzoom=false;

		}
	}

	void move(TuioCursor curseur)
	{

		while (curseur.getTuioState()!=4)
		{
			
			Vector2f posCurseur_av = new Vector2f(curseur.getPosition().getScreenX(screen.x),curseur.getPosition().getScreenY(screen.y));
            try {
                    Thread.sleep(50);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            Vector2f posCurseur_ap = new Vector2f(curseur.getPosition().getScreenX(screen.x),curseur.getPosition().getScreenY(screen.y));
            Vector2f deplacement =Vector2f.sub(posCurseur_ap,posCurseur_av);
            Vector2f posImage = Vector2f.add(deplacement,image.getPosition());
            if ( posImage.x>0 && posImage.y>0 &&
                     posImage.x<screen.x && posImage.y<screen.y)
            image.setPosition(posImage);
		}
	}

	boolean inImage(TuioCursor cursor)
	{
		
		Vector2f point1 = new Vector2f(cursor.getPosition().getScreenX(screen.x),
				cursor.getPosition().getScreenY(screen.y));
		return image.getGlobalBounds().contains(point1);

	}

	public Geste (Sprite sprite,Vector2i screen, TuioClient tuioClient)
	{
		image = sprite;
		this.screen=screen;
		this.tuioClient = tuioClient; 
		if (!tuioClient.isConnected())
			return;
	}

	void event(){
		Vector<TuioCursor> cursorList = tuioClient.getTuioCursors();
		TuioCursor cursor;
		Vector<TuioCursor> cursorInImage = new Vector<TuioCursor>();
		for (Iterator<TuioCursor> iter = cursorList.iterator();iter.hasNext();){
			cursor = iter.next();
			synchronized (Geste.class) {
				if ( curseurAttribué.contains(new Integer(cursor.getCursorID())))
					continue;
			}
			
			
			if (inImage(cursor))
			{
				cursorInImage.add(cursor);
				synchronized (Geste.class) {
					curseurAttribué.add(new Integer(cursor.getCursorID()));
				}
			}
		}
		switch (cursorInImage.size()){
		case 1:
			move(cursorInImage.get(0));
			synchronized (Geste.class) {
				curseurAttribué.remove(new Integer(cursorInImage.get(0).getCursorID()));		
			}
			break;
		case 2:
			zoom(cursorInImage.get(0), cursorInImage.get(1));
			synchronized (Geste.class) {
				curseurAttribué.remove(new Integer(cursorInImage.get(0).getCursorID()));
				curseurAttribué.remove(new Integer(cursorInImage.get(1).getCursorID()));
			}
			break;

		default :
			break;
		}
	}

	@Override
	public void run() {
		while (running)
		{
			event();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}




}
