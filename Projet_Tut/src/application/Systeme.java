package application;

import image.ListeImage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Vector;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;

import TUIO.TuioClient;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;
public class Systeme implements TuioListener {
	final static int LARGEUR = 900;
	final static int HAUTEUR = 600;
	boolean verbose,fullscreen,running;
	RenderWindow window;
	static public Vector2i screen;
	static public  TuioClient tuioClient;
	Font font;

	ListeImage listImage;
	

	Systeme() 
	{
		screen = new Vector2i(LARGEUR,HAUTEUR);
		window= new RenderWindow(new VideoMode(LARGEUR,HAUTEUR),"Tuio",WindowStyle.DEFAULT-WindowStyle.RESIZE);
		window.setVerticalSyncEnabled(true);
		

		verbose = false;
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
		
		listImage=new ListeImage();
		for (int i=0;i<5;i++){
			listImage.ajouter("images/Pikachu.png");
			listImage.listImage.get(i).image.setColor(new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
		}

		font = new Font();
		try {
			font.loadFromFile(Paths.get("rcs/sansation.ttf"));
		} catch (IOException e) {
			System.out.println("Impossible d'ouvrir le fichier font !");
			return;
		}

	}

	public void run()
	{
		
		running=true;
		while (running)
		{

			window.draw(listImage);
			drawCursors();
			drawObjects();
			
			window.display();
			processEvents();
			window.clear();
		}
		listImage.arreter();
		tuioClient.disconnect();
		window.close();
	}


	void drawCursors()
	{
		// Liste des curseurs
		Vector<TuioCursor> cursorList = tuioClient.getTuioCursors();
		TuioCursor cursor;
		//boucle qui traite chun des curseurs ( un apres l'autre)
		for (Iterator<TuioCursor> iter = cursorList.iterator();iter.hasNext();){
			
			cursor = iter.next();
			CircleShape cur= new CircleShape(4);
			cur.setOrigin(2,2);
			cur.setFillColor(Color.GREEN);
			cur.move(cursor.getPosition().getX()*window.getSize().x,cursor.getPosition().getY()*window.getSize().y);
			drawString(Integer.toString(cursor.getCursorID()),cur.getPosition().x-5,cur.getPosition().y-20);
			window.draw(cur);
		}
		
	}

	void drawObjects()
	{
		//Liste des Objets
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

	void drawButtons()
	{
		Text txt = new Text("bouton",font);
		txt.setCharacterSize(20);
		Vector2f curseur = new Vector2f(Mouse.getPosition(window));
		if (txt.getGlobalBounds().contains(curseur))
			txt.setColor(Color.RED);
		else
			txt.setColor(Color.WHITE);
		window.draw(txt);
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
				
			case RESIZED:
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
			window.create(new VideoMode(LARGEUR,HAUTEUR ),"Tuio",WindowStyle.DEFAULT-WindowStyle.RESIZE);
		screen=window.getSize();
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
		// TODO Stub de la m�thode g�n�r� automatiquement

	}
	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Stub de la m�thode g�n�r� automatiquement

	}


}
