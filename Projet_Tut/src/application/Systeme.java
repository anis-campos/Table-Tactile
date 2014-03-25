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

package application;

import image.Conteneur;
import image.ListeImage;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Shape;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;

import outils.GesteSysteme;
import outils.GestionFiducial;
import outils.MusiqueFiducial;
import outils.menu.About;
import outils.menu.Clavier;
import outils.menu.Help;
import outils.menu.Menu;
import outils.menu.Quitter;
import TUIO.TuioClient;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;

// TODO: Auto-generated Javadoc

/**
 * The Class Systeme.
 */
public class Systeme implements TuioListener, Serializable {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	Systeme app = new Systeme();
	app.run();
	
	return;
	}
	
    private static final long serialVersionUID = 2937976085789883674L;

    /** The Constant LARGEUR. */
    final int LARGEUR = 900;

    /** The Constant HAUTEUR. */
    final int HAUTEUR = 600;

    /** The running. */
    boolean verbose, fullscreen, running;

    /** The window. */
    public RenderWindow window;

    /** The screen. */
    static public Vector2i screen;

    /** The tuio client. */
    static public TuioClient tuioClient;

    /** The font. */
    static public Font font;

    /** The list image. */
    static public ListeImage listImage;

    /** Menu */
    static public Menu menu;
    static public MusiqueFiducial musiqueMenu;

    /** A propos */
    static public About about;

    /** HELP */
    static public Help help;

    /** Conteneur des dossiers */
    static public Conteneur conteneur;
    static public ArrayList<String> leConteneur;

    /** CLAVIER */
    static public Clavier clavier;

    /** BOOLEAN IS IN OBJECT */
    // static public boolean isInObject=false;

    /** Texte afficher pour quitter */
    static public Quitter quitter;

    GesteSysteme gestesys;
    Thread thread;

    Texture textureFidMusique;
    Texture TextureFidPhoto;

    /**
     * Instantiates a new systeme.
     */
    Systeme() {
	screen = new Vector2i(LARGEUR, HAUTEUR);
	window = new RenderWindow(new VideoMode(LARGEUR, HAUTEUR),
		"Picture 4 Table", WindowStyle.DEFAULT - WindowStyle.RESIZE);
	window.setVerticalSyncEnabled(true);

	verbose = false;
	fullscreen = false;
	running = false;

	tuioClient = new TuioClient();
	tuioClient.addTuioListener(this);
	tuioClient.connect();
	if (!tuioClient.isConnected()) {
	    window.close();
	    System.exit(0);
	}

	textureFidMusique = new Texture();
	try {
	    textureFidMusique.loadFromFile(Paths
		    .get("images/bouton/musique.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	TextureFidPhoto = new Texture();
	try {
	    TextureFidPhoto.loadFromFile(Paths.get("images/bouton/photo.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	listImage = new ListeImage();
	// listImage.ajouter("images/ptut.png");
	// listImage.ajouter("images/Pikachu.png");
	// listImage.ajouter("images/ptut.png");
	// listImage.ajouter("images/boeing.jpg");
	// listImage.ajouter("images/iut.jpg");
	/*
	 * for (int i=0;i<1;i++){ listImage.ajouter("images/Pikachu.png");
	 * listImage.ajouter("images/ptut.png");
	 * listImage.listImage.get(i).sprite.setColor(new Color((int)
	 * (Math.random()*255), (int) (Math.random()*255), (int)
	 * (Math.random()*255))); }
	 */

	gestesys = new GesteSysteme();
	thread = new Thread(gestesys);
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
	quitter = new Quitter();
	leConteneur = new ArrayList<>();
	clavier = Clavier.getInstance();
	musiqueMenu = new MusiqueFiducial();
	help = new Help();
    }

    /**
     * Run.
     */
    public void run() {

	running = true;
	while (running) {
	    window.draw(listImage);
	    window.draw(menu);
	    window.draw(about);
	    window.draw(help);
	    window.draw(conteneur);
	    window.draw(quitter);
	    window.draw(clavier);
	    window.draw(musiqueMenu);

	    drawCursors();

	    // Elle sert a rien cette ligne !
	    drawObjects();

	    window.display();
	    processEvents();
	    window.clear();
	}
	gestesys.stop();
	try {
	    thread.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	listImage.arreter();
	tuioClient.disconnect();
	window.close();
    }

    /**
     * Draw cursors.
     */
    void drawCursors() {
	// Liste des curseurs
	Vector<TuioCursor> cursorList = tuioClient.getTuioCursors();
	TuioCursor cursor;
	// boucle qui traite chacun des curseurs ( un apres l'autre)
	for (Iterator<TuioCursor> iter = cursorList.iterator(); iter.hasNext();) {

	    cursor = iter.next();
	    CircleShape cur = new CircleShape(4);
	    cur.setOrigin(2, 2);
	    cur.setFillColor(Color.GREEN);
	    cur.move(cursor.getPosition().getX() * window.getSize().x, cursor
		    .getPosition().getY() * window.getSize().y);
	    drawString(Integer.toString(cursor.getCursorID()),
		    cur.getPosition().x - 5, cur.getPosition().y - 20);
	    window.draw(cur);
	}

    }

    /**
     * Draw objects.
     */
    void drawObjects() {
	// Liste des Objets
	Vector<TuioObject> objectList = tuioClient.getTuioObjects();
	TuioObject tuioObject;
	for (Iterator<TuioObject> iter2 = objectList.iterator(); iter2
		.hasNext();) {

	    tuioObject = iter2.next();

	    // objet sans une forme specifique
	    Shape object = null;

	    // objet rectangulaire
	    if (tuioObject.getSymbolID() < 4) {
		object = new RectangleShape(new Vector2f(40, 40));
		object.setTexture(TextureFidPhoto);

	    }
	    // objet circulaire
	    else if (tuioObject.getSymbolID() < 8) {
		object = new CircleShape(20);
		object.setTexture(textureFidMusique);
	    }
	    // objet hexagonale....
	    else {
		object = new CircleShape(20, 6);
		object.setFillColor(Color.MAGENTA);
	    }
	    object.setOrigin(20 , 20 );
	    object.setPosition(screen.x * tuioObject.getX(), screen.y
		    * tuioObject.getY());
	    object.setRotation(tuioObject.getAngleDegrees());
	    float x =  object.getPosition().x - 35 ;
	    float y = object.getPosition().y - 35;
	    drawString(Integer.toString(tuioObject.getSymbolID()),x, y );

	    window.draw(object);
	}
    }

    /**
     * Draw buttons.
     */
    void drawButtons() {
	Text txt = new Text("bouton", font);
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
     * @param str
     *            the str
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void drawString(String str, float x, float y) {
	Text txt = new Text(str, font);
	txt.setCharacterSize(15);
	txt.setPosition(x, y);
	txt.setColor(Color.GREEN);
	window.draw(txt);
    }

    /**
     * Process events.
     */
    void processEvents() {
	for (Event event : window.pollEvents()) {

	    switch (event.type) {
	    case KEY_PRESSED:
		switch (event.asKeyEvent().key) {
		case ESCAPE:
		    window.close();
		    running = false;
		    break;
		case F:
		    this.toggleFullscreen();
		    Systeme.conteneur.setSizeConteneur();
		    Systeme.conteneur.setPositionConteneur();

		    break;

		case A:
		    if (about.isVisible()) {
			about.setVisible(false);
		    } else {
			about.setVisible(true);
			about.setPosition();
		    }
		    break;
		default:
		    break;
		}
		break;

	    case CLOSED:
		window.close();
		running = false;
		break;

	    case RESIZED:
		break;
	    default:
		break;
	    }
	}

    }

    /**
     * Toggle fullscreen.
     */
    void toggleFullscreen() {

	if (!fullscreen)
	    window.create(VideoMode.getDesktopMode(), "Tuio",
		    WindowStyle.FULLSCREEN);

	else
	    window.create(new VideoMode(LARGEUR, HAUTEUR), "Tuio",
		    WindowStyle.DEFAULT - WindowStyle.RESIZE);
	screen = window.getSize();
	window.setVerticalSyncEnabled(true);
	fullscreen = !fullscreen;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TUIO.TuioListener#addTuioObject(TUIO.TuioObject)
     */
    @Override
    public void addTuioObject(TuioObject tobj) {
	if (verbose) {
	    System.out.println("add obj " + tobj.getSymbolID() + " ("
		    + tobj.getSessionID() + ") " + tobj.getX() + " "
		    + tobj.getY() + " " + tobj.getAngle());
	}
	if (tobj.getSymbolID() < 4) {
	    try {
		GestionFiducial.actionFiducialAjout(tobj);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	} else if (tobj.getSymbolID() < 8) {
	    try {
		MusiqueFiducial.actionFiducialAjout(tobj);
	    } catch (IOException e) {
		System.out.println(e.getMessage());
	    }
	} else {

	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see TUIO.TuioListener#removeTuioObject(TUIO.TuioObject)
     */
    @Override
    public void removeTuioObject(TuioObject tobj) {
	if (verbose) {
	    System.out.println("del obj " + tobj.getSymbolID() + " ("
		    + tobj.getSessionID() + ")");
	}

	if (tobj.getSymbolID() < 4) {
	    try {
		GestionFiducial.actionFiducialRetrait(tobj);
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else if (tobj.getSymbolID() < 8) {
	    MusiqueFiducial.actionFiducialRetrait(tobj);
	    
	} 

    }

    /*
     * (non-Javadoc)
     * 
     * @see TUIO.TuioListener#addTuioCursor(TUIO.TuioCursor)
     */
    @Override
    public void addTuioCursor(TuioCursor tcur) {

	if (verbose)
	    System.out.println("add cur " + tcur.getCursorID() + " ("
		    + tcur.getSessionID() + ") " + tcur.getX() + " "
		    + tcur.getY());

    }

    /*
     * (non-Javadoc)
     * 
     * @see TUIO.TuioListener#updateTuioCursor(TUIO.TuioCursor)
     */
    @Override
    public void updateTuioCursor(TuioCursor tcur) {

	if (verbose)
	    System.out.println("set cur " + tcur.getCursorID() + " ("
		    + tcur.getSessionID() + ") " + tcur.getX() + " "
		    + tcur.getY() + " " + tcur.getMotionSpeed() + " "
		    + tcur.getMotionAccel() + " ");
    }

    /*
     * (non-Javadoc)
     * 
     * @see TUIO.TuioListener#removeTuioCursor(TUIO.TuioCursor)
     */
    @Override
    public void removeTuioCursor(TuioCursor tcur) {

	if (verbose)
	    System.out.println("del cur " + tcur.getCursorID() + " ("
		    + tcur.getSessionID() + ")");
    }

    /*
     * (non-Javadoc)
     * 
     * @see TUIO.TuioListener#refresh(TUIO.TuioTime)
     */
    @Override
    public void refresh(TuioTime arg0) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see TUIO.TuioListener#updateTuioObject(TUIO.TuioObject)
     */
    @Override
    public void updateTuioObject(TuioObject arg0) {
	// TODO Stub de la m�thode g�n�r� automatiquement

    }

}
