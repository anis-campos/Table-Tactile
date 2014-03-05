/*
  * 		Projet Tutore : Table tactile
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
package application;

import gesture.About;
import gesture.GesteSysteme;
import gesture.Menu;
import image.Conteneur;
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
// TODO: Auto-generated Javadoc

/**
 * The Class Systeme.
 */
public class Systeme implements TuioListener {
	
	/** The Constant LARGEUR. */
	final static int LARGEUR = 900;
	
	/** The Constant HAUTEUR. */
	final static int HAUTEUR = 600;
	
	/** The running. */
	boolean verbose,fullscreen,running;
	
	/** The window. */
	static public RenderWindow window;
	
	/** The screen. */
	static public Vector2i screen;
	
	/** The tuio client. */
	static public  TuioClient tuioClient;
	
	/** The font. */
	static public Font font;

	/** The list image. */
	static public ListeImage listImage;
	
	/** Menu */
	static public Menu menu;
	
	/** A propos */
	static public About about;
	
	/** Conteneur des dossiers*/
	static public Conteneur conteneur;
	
	GesteSysteme gestesys;
	Thread thread;

	/**
	 * Instantiates a new systeme.
	 */
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
		for (int i=0;i<4;i++){
			listImage.ajouter("images/Pikachu.png");
			listImage.ajouter("images/ptut.png");
			listImage.listImage.get(i).sprite.setColor(new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
		}
		
		gestesys = new GesteSysteme();
		thread = new Thread (gestesys);
		thread.start();
		
		font = new Font();
		try {
			font.loadFromFile(Paths.get("rcs/sansation.ttf"));
		} catch (IOException e) {
			System.out.println("Impossible d'ouvrir le fichier font !");
			return;
		}
		menu = new Menu();
		about = new About();
		conteneur = new Conteneur();
	}

	/**
	 * Run.
	 */
	public void run()
	{
		
		running=true;
		while (running)
		{

			window.draw(listImage);
			window.draw(menu);
			window.draw(about);
			window.draw(conteneur);
			
			drawCursors();
			drawObjects();
			
			window.display();
			processEvents();
			window.clear();
		}
		gestesys.stop();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Bloc catch g�n�r� automatiquement
			e.printStackTrace();
		}
		listImage.arreter();
		tuioClient.disconnect();
		window.close();
	}


	/**
	 * Draw cursors.
	 */
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

	/**
	 * Draw objects.
	 */
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

	/**
	 * Draw buttons.
	 */
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


	/**
	 * Draw string.
	 *
	 * @param str the str
	 * @param x the x
	 * @param y the y
	 */
	void drawString(String str,float x,float y)
	{
		Text txt = new Text(str,font);
		txt.setCharacterSize(15);
		txt.setPosition(x,y);
		txt.setColor(Color.GREEN);
		window.draw(txt);
	}

	/**
	 * Process events.
	 */
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
					Systeme.conteneur.setSizeConteneur();
					Systeme.conteneur.setPositionConteneur();
					
					break;
				
				case A:
					if (about.isVisible()){
						about.setVisible(false);
					}else{
						about.setVisible(true);
						about.setPosition();
					}
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

	

	/**
	 * Toggle fullscreen.
	 */
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

	/* (non-Javadoc)
	 * @see TUIO.TuioListener#addTuioObject(TUIO.TuioObject)
	 */
	@Override
	public void addTuioObject(TuioObject tobj)
	{
		if (verbose)
			System.out.println("add obj "+tobj.getSymbolID()+" ("+tobj.getSessionID()+") "+tobj.getX()+" "+tobj.getY()+" "+tobj.getAngle());

	}
	
	/* (non-Javadoc)
	 * @see TUIO.TuioListener#removeTuioObject(TUIO.TuioObject)
	 */
	@Override
	public void removeTuioObject(TuioObject tobj)
	{

		if (verbose)
			System.out.println("del obj "+tobj.getSymbolID()+" ("+tobj.getSessionID()+")");
	}
	
	/* (non-Javadoc)
	 * @see TUIO.TuioListener#addTuioCursor(TUIO.TuioCursor)
	 */
	@Override
	public void addTuioCursor(TuioCursor tcur)
	{

		if (verbose)
			System.out.println("add cur "+tcur.getCursorID()+" ("+ tcur.getSessionID()+") "+tcur.getX()+" "+tcur.getY());

	}
	
	/* (non-Javadoc)
	 * @see TUIO.TuioListener#updateTuioCursor(TUIO.TuioCursor)
	 */
	@Override
	public void updateTuioCursor(TuioCursor tcur)
	{

		if (verbose )
			System.out.println("set cur "+tcur.getCursorID()+" ("+ tcur.getSessionID()+") "+tcur.getX()+" "+tcur.getY()
					+ " "+tcur.getMotionSpeed()+" "+tcur.getMotionAccel()+" ");
	}
	
	/* (non-Javadoc)
	 * @see TUIO.TuioListener#removeTuioCursor(TUIO.TuioCursor)
	 */
	@Override
	public void removeTuioCursor(TuioCursor tcur)
	{

		if (verbose)
			System.out.println("del cur "+tcur.getCursorID()+" ("+ tcur.getSessionID()+")");
	}
	
	/* (non-Javadoc)
	 * @see TUIO.TuioListener#refresh(TUIO.TuioTime)
	 */
	@Override
	public void refresh(TuioTime arg0) {
		// TODO Stub de la m�thode g�n�r� automatiquement

	}
	
	/* (non-Javadoc)
	 * @see TUIO.TuioListener#updateTuioObject(TUIO.TuioObject)
	 */
	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Stub de la m�thode g�n�r� automatiquement

	}


}

