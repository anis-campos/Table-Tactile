
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.PrimitiveType;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Vertex;
import org.jsfml.graphics.VertexArray;
import org.jsfml.system.Vector2f;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;

import TUIO.TuioClient;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioPoint;
import TUIO.TuioTime;
public class App implements TuioListener {
	final static int LARGEUR = 900;
	final static int HAUTEUR = 600;

	boolean verbose,fullscreen,running;
	RenderWindow window;
	TuioClient tuioClient;
	Font font;




	App() throws IOException
	{
		window= new RenderWindow();
		window.create(new VideoMode(LARGEUR,HAUTEUR),"Tuio");
		window.setVerticalSyncEnabled(true);
				
		verbose = true;
		fullscreen = false;
		running = false;

		tuioClient = new TuioClient();
		tuioClient.addTuioListener(this);
		tuioClient.connect();

		if (!tuioClient.isConnected())
		{
			window.close();
			return;
		}
		font = new Font();
		font.loadFromFile(Paths.get("rcs/sansation.ttf"));
		
	}

	public void run() throws InterruptedException
	{
		
		running=true;
		while (running)
		{
			
			drawObjects();
			window.display();
			processEvents();
			Thread.sleep(40);
			window.clear();

		}
		tuioClient.disconnect();
		window.close();
	}
	void drawObjects()
	{
		//-------------------
		// 	Trajectoire
		//-------------------

		// Liste des curseurs
		Vector<TuioCursor> cursorList = tuioClient.getTuioCursors();
		//le Curseur courant
		TuioCursor cursor;
		//la position du cuseur
		Vector2f DerP = null;
		//boucle qui traite chun des curseurs ( un apres l'autre)
		for (Iterator<TuioCursor> iter = cursorList.iterator();iter.hasNext();){

			cursor = iter.next();
			//si curseur est null , on arrete
			if (cursor==null)
				break;
			//trajectoire du curseur
			Vector<TuioPoint> path = cursor.getPath();

			//liste de lignes chainées : la liggne suivante va se coller au bout de la précedente
			VertexArray list_p = new VertexArray(PrimitiveType.LINE_STRIP);
			if (path.size()>0)
			{
				//copie de la trajectoire ( pour eviter l'exeption ConcurrentModificationException )
				List<TuioPoint> c_path = new ArrayList<TuioPoint>();
				c_path.addAll(path);


				for (TuioPoint point : c_path)
				{
					//les point tuio ont des coordonnées en % ( entre 0 et 1)
					DerP=new Vector2f(point.getX()*window.getSize().x,point.getY()*window.getSize().y);
					list_p.add(new Vertex(DerP));

					//la taille maximun de vertex array est 1024
					if(list_p.size()>1023)
						list_p.clear();
				}
				window.draw(list_p);
				list_p.clear();


			}


			//-------------------
			// curseur
			//-------------------
			CircleShape cur= new CircleShape(4);
			cur.setOrigin(2,2);
			cur.setFillColor(Color.GREEN);
			cur.move(DerP);
			drawString(Integer.toString(cursor.getCursorID()),cur.getPosition().x-5,cur.getPosition().y-20);
			window.draw(cur);

		}
		
		//draw the objects
		Vector<TuioObject> objectList = tuioClient.getTuioObjects();

		for (Iterator<TuioObject> iter2 = objectList.iterator(); iter2.hasNext();)
		{
			TuioObject tuioObject = iter2.next();
			Vector2f ecran  = new Vector2f(window.getSize().x,window.getSize().y);
			Vector2f taille = Vector2f.div(ecran, 20.0f);
			Vector2f position = new Vector2f(tuioObject.getX(),tuioObject.getY());
			RectangleShape object = new RectangleShape(taille);
			object.setOrigin(taille.x/2,taille.y/2);
			object.move(Vector2f.componentwiseMul(position, ecran));
			object.setRotation(tuioObject.getAngleDegrees());
			drawString(Integer.toString(tuioObject.getSymbolID()),object.getPosition().x-15,object.getPosition().y-60);
			window.draw(object);
		}
				



			
		

		
	}

	void drawString(String str,float x,float y)
	{
		Text txt = new Text(str,font);
		txt.setCharacterSize(15);
		txt.setPosition(x,y);
		txt.setColor(Color.GREEN);
		window.draw(txt);
	}

	void processEvents()
	{
		for(Event event : window.pollEvents())
		{

			switch( event.type )
			{
			case KEY_PRESSED:
				switch (event.asKeyEvent().key)
				{
				case ESCAPE:
					window.close();
					running=false;
					break;
				case F:
					this.toggleFullscreen();
					break;
				
				default :
					break;
				}
				break;

			case CLOSED:
				window.close();
				running=false;
				break;

			default :
				break;
			}
		}

	}

	void toggleFullscreen()
	{

		if( !fullscreen )
			window.create(VideoMode.getDesktopMode(), "Tuio",WindowStyle.FULLSCREEN);

		else
			window.create(new VideoMode(LARGEUR,HAUTEUR ),"Tuio",WindowStyle.DEFAULT);

		window.setVerticalSyncEnabled(true);
		fullscreen = !fullscreen;
	}

	@Override
	public void addTuioObject(TuioObject tobj)
	{
		if (verbose)
			System.out.println("add obj "+tobj.getSymbolID()+" ("+tobj.getSessionID()+") "+tobj.getX()+" "+tobj.getY()+" "+tobj.getAngle());

	}
	@Override
	public void removeTuioObject(TuioObject tobj)
	{

		if (verbose)
			System.out.println("del obj "+tobj.getSymbolID()+" ("+tobj.getSessionID()+")");
	}
	@Override
	public void addTuioCursor(TuioCursor tcur)
	{

		if (verbose)
			System.out.println("add cur "+tcur.getCursorID()+" ("+ tcur.getSessionID()+") "+tcur.getX()+" "+tcur.getY());

	}
	@Override
	public void updateTuioCursor(TuioCursor tcur)
	{

		if (verbose )
			System.out.println("set cur "+tcur.getCursorID()+" ("+ tcur.getSessionID()+") "+tcur.getX()+" "+tcur.getY()
					+ " "+tcur.getMotionSpeed()+" "+tcur.getMotionAccel()+" ");
	}
	@Override
	public void removeTuioCursor(TuioCursor tcur)
	{

		if (verbose)
			System.out.println("del cur "+tcur.getCursorID()+" ("+ tcur.getSessionID()+")");
	}
	@Override
	public void refresh(TuioTime arg0) {
		// TODO Stub de la méthode généré automatiquement

	}
	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Stub de la méthode généré automatiquement

	}


}

