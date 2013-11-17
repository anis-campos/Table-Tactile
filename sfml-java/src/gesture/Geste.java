package gesture;



import java.awt.Point;
import java.util.Vector;

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
	double distance=0;
	float scale = 1;
	
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
	
	void move(TuioCursor c)
	{
		Vector2f point1 = new Vector2f(c.getPosition().getScreenX(screen.x),
				                       c.getPosition().getScreenY(screen.y));
		if (image.getGlobalBounds().contains(point1)){
		while (c.getTuioState()!=4)
			{
				image.setPosition(c.getPosition().getScreenX(screen.x),c.getPosition().getScreenY(screen.y));
			}
		}
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
		
		if (cursorList.size()==1)
		{
			move(cursorList.get(0));
		}
		if(cursorList.size()==2){
			
			zoom(cursorList.get(0),cursorList.get(1));
		}
	}
	
	@Override
	public void run() {
		while (true)
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
