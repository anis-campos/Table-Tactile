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

package outils.menu;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;

import application.Systeme;
import TUIO.TuioCursor;
import TUIO.TuioPoint;

// TODO: Auto-generated Javadoc
/**
 * The Class Clavier.
 */
public class Clavier implements Drawable {

    /** Attributs. */

    float taille = 50;

    /** The a. */
    RectangleShape a;

    /** The b. */
    RectangleShape b;

    /** The c. */
    RectangleShape c;

    /** The d. */
    RectangleShape d;

    /** The e. */
    RectangleShape e;

    /** The f. */
    RectangleShape f;

    /** The g. */
    RectangleShape g;

    /** The h. */
    RectangleShape h;

    /** The i. */
    RectangleShape i;

    /** The j. */
    RectangleShape j;

    /** The k. */
    RectangleShape k;

    /** The l. */
    RectangleShape l;

    /** The m. */
    RectangleShape m;

    /** The n. */
    RectangleShape n;

    /** The o. */
    RectangleShape o;

    /** The p. */
    RectangleShape p;

    /** The q. */
    RectangleShape q;

    /** The r. */
    RectangleShape r;

    /** The s. */
    RectangleShape s;

    /** The t. */
    RectangleShape t;

    /** The u. */
    RectangleShape u;

    /** The v. */
    RectangleShape v;

    /** The w. */
    RectangleShape w;

    /** The x. */
    RectangleShape x;

    /** The y. */
    RectangleShape y;

    /** The z. */
    RectangleShape z;

    /** The entrer. */
    RectangleShape entrer;

    /** The point. */
    RectangleShape point;

    /** The tire. */
    RectangleShape tire;

    /** The trait. */
    RectangleShape trait;

    /** The fermer. */
    RectangleShape fermer;

    /** The suppr. */
    RectangleShape suppr;

    /** The barre. */
    RectangleShape barre;

    /** The texta. */
    Texture texta;

    /** The textb. */
    Texture textb;

    /** The textc. */
    Texture textc;

    /** The textd. */
    Texture textd;

    /** The texte. */
    Texture texte;

    /** The textf. */
    Texture textf;

    /** The textg. */
    Texture textg;

    /** The texth. */
    Texture texth;

    /** The texti. */
    Texture texti;

    /** The textj. */
    Texture textj;

    /** The textk. */
    Texture textk;

    /** The textl. */
    Texture textl;

    /** The textm. */
    Texture textm;

    /** The textn. */
    Texture textn;

    /** The texto. */
    Texture texto;

    /** The textp. */
    Texture textp;

    /** The textq. */
    Texture textq;

    /** The textr. */
    Texture textr;

    /** The texts. */
    Texture texts;

    /** The textt. */
    Texture textt;

    /** The textu. */
    Texture textu;

    /** The textv. */
    Texture textv;

    /** The textw. */
    Texture textw;

    /** The textx. */
    Texture textx;

    /** The texty. */
    Texture texty;

    /** The textz. */
    Texture textz;

    /** The textentrer. */
    Texture textentrer;

    /** The textpoint. */
    Texture textpoint;

    /** The texttire. */
    Texture texttire;

    /** The texttrait. */
    Texture texttrait;

    /** The textfermer. */
    Texture textfermer;

    /** The textsuppr. */
    Texture textsuppr;

    /** The textbarre. */
    Texture textbarre;

    /** The text afficher. */
    Text textAfficher;

    /** The url. */
    String url = "";

    /** The validation. */
    boolean validation = false;

    /** The visible. */
    boolean visible = false;

    /** The Constant clavier. */
    private final static Clavier clavier = new Clavier();

    /**
     * Constructeur.
     */

    private Clavier() {
	initialisation();
    }

    /**
     * Gets the single instance of Clavier.
     * 
     * @return single instance of Clavier
     */
    public static Clavier getInstance() {
	return clavier;
    }

    /**
     * Methode.
     */

    public void initialisation() {

	texta = new Texture();
	try {
	    texta.loadFromFile(Paths.get("images/clavier/a.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	a = new RectangleShape(new Vector2f(taille, taille));
	a.setOrigin(taille / 2, taille / 2);
	a.setTexture(texta);

	textb = new Texture();
	try {
	    textb.loadFromFile(Paths.get("images/clavier/b.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	b = new RectangleShape(new Vector2f(taille, taille));
	b.setOrigin(taille / 2, taille / 2);
	b.setTexture(textb);

	textc = new Texture();
	try {
	    textc.loadFromFile(Paths.get("images/clavier/c.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	c = new RectangleShape(new Vector2f(taille, taille));
	c.setOrigin(taille / 2, taille / 2);
	c.setTexture(textc);

	textd = new Texture();
	try {
	    textd.loadFromFile(Paths.get("images/clavier/d.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	d = new RectangleShape(new Vector2f(taille, taille));
	d.setOrigin(taille / 2, taille / 2);
	d.setTexture(textd);

	texte = new Texture();
	try {
	    texte.loadFromFile(Paths.get("images/clavier/e.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	e = new RectangleShape(new Vector2f(taille, taille));
	e.setOrigin(taille / 2, taille / 2);
	e.setTexture(texte);

	textf = new Texture();
	try {
	    textf.loadFromFile(Paths.get("images/clavier/f.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	f = new RectangleShape(new Vector2f(taille, taille));
	f.setOrigin(taille / 2, taille / 2);
	f.setTexture(textf);

	textg = new Texture();
	try {
	    textg.loadFromFile(Paths.get("images/clavier/g.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	g = new RectangleShape(new Vector2f(taille, taille));
	g.setOrigin(taille / 2, taille / 2);
	g.setTexture(textg);

	texth = new Texture();
	try {
	    texth.loadFromFile(Paths.get("images/clavier/h.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	h = new RectangleShape(new Vector2f(taille, taille));
	h.setOrigin(taille / 2, taille / 2);
	h.setTexture(texth);

	texti = new Texture();
	try {
	    texti.loadFromFile(Paths.get("images/clavier/i.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	i = new RectangleShape(new Vector2f(taille, taille));
	i.setOrigin(taille / 2, taille / 2);
	i.setTexture(texti);

	textj = new Texture();
	try {
	    textj.loadFromFile(Paths.get("images/clavier/j.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	j = new RectangleShape(new Vector2f(taille, taille));
	j.setOrigin(taille / 2, taille / 2);
	j.setTexture(textj);

	textk = new Texture();
	try {
	    textk.loadFromFile(Paths.get("images/clavier/k.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	k = new RectangleShape(new Vector2f(taille, taille));
	k.setOrigin(taille / 2, taille / 2);
	k.setTexture(textk);

	textl = new Texture();
	try {
	    textl.loadFromFile(Paths.get("images/clavier/l.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	l = new RectangleShape(new Vector2f(taille, taille));
	l.setOrigin(taille / 2, taille / 2);
	l.setTexture(textl);

	textm = new Texture();
	try {
	    textm.loadFromFile(Paths.get("images/clavier/m.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	m = new RectangleShape(new Vector2f(taille, taille));
	m.setOrigin(taille / 2, taille / 2);
	m.setTexture(textm);

	textn = new Texture();
	try {
	    textn.loadFromFile(Paths.get("images/clavier/n.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	n = new RectangleShape(new Vector2f(taille, taille));
	n.setOrigin(taille / 2, taille / 2);
	n.setTexture(textn);

	texto = new Texture();
	try {
	    texto.loadFromFile(Paths.get("images/clavier/o.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	o = new RectangleShape(new Vector2f(taille, taille));
	o.setOrigin(taille / 2, taille / 2);
	o.setTexture(texto);

	textp = new Texture();
	try {
	    textp.loadFromFile(Paths.get("images/clavier/p.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	p = new RectangleShape(new Vector2f(taille, taille));
	p.setOrigin(taille / 2, taille / 2);
	p.setTexture(textp);

	textq = new Texture();
	try {
	    textq.loadFromFile(Paths.get("images/clavier/q.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	q = new RectangleShape(new Vector2f(taille, taille));
	q.setOrigin(taille / 2, taille / 2);
	q.setTexture(textq);

	textr = new Texture();
	try {
	    textr.loadFromFile(Paths.get("images/clavier/r.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	r = new RectangleShape(new Vector2f(taille, taille));
	r.setOrigin(taille / 2, taille / 2);
	r.setTexture(textr);

	texts = new Texture();
	try {
	    texts.loadFromFile(Paths.get("images/clavier/s.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	s = new RectangleShape(new Vector2f(taille, taille));
	s.setOrigin(taille / 2, taille / 2);
	s.setTexture(texts);

	textt = new Texture();
	try {
	    textt.loadFromFile(Paths.get("images/clavier/t.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	t = new RectangleShape(new Vector2f(taille, taille));
	t.setOrigin(taille / 2, taille / 2);
	t.setTexture(textt);

	textu = new Texture();
	try {
	    textu.loadFromFile(Paths.get("images/clavier/u.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	u = new RectangleShape(new Vector2f(taille, taille));
	u.setOrigin(taille / 2, taille / 2);
	u.setTexture(textu);

	textv = new Texture();
	try {
	    textv.loadFromFile(Paths.get("images/clavier/v.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	v = new RectangleShape(new Vector2f(taille, taille));
	v.setOrigin(taille / 2, taille / 2);
	v.setTexture(textv);

	textw = new Texture();
	try {
	    textw.loadFromFile(Paths.get("images/clavier/w.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	w = new RectangleShape(new Vector2f(taille, taille));
	w.setOrigin(taille / 2, taille / 2);
	w.setTexture(textw);

	textx = new Texture();
	try {
	    textx.loadFromFile(Paths.get("images/clavier/x.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	x = new RectangleShape(new Vector2f(taille, taille));
	x.setOrigin(taille / 2, taille / 2);
	x.setTexture(textx);

	texty = new Texture();
	try {
	    texty.loadFromFile(Paths.get("images/clavier/y.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	y = new RectangleShape(new Vector2f(taille, taille));
	y.setOrigin(taille / 2, taille / 2);
	y.setTexture(texty);

	textz = new Texture();
	try {
	    textz.loadFromFile(Paths.get("images/clavier/z.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	z = new RectangleShape(new Vector2f(taille, taille));
	z.setOrigin(taille / 2, taille / 2);
	z.setTexture(textz);

	textentrer = new Texture();
	try {
	    textentrer.loadFromFile(Paths.get("images/clavier/entrer.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	entrer = new RectangleShape(new Vector2f(taille, taille));
	entrer.setOrigin(taille / 2, taille / 2);
	entrer.setTexture(textentrer);

	textpoint = new Texture();
	try {
	    textpoint.loadFromFile(Paths.get("images/clavier/point.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	point = new RectangleShape(new Vector2f(taille, taille));
	point.setOrigin(taille / 2, taille / 2);
	point.setTexture(textpoint);

	texttire = new Texture();
	try {
	    texttire.loadFromFile(Paths.get("images/clavier/tire.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	tire = new RectangleShape(new Vector2f(taille, taille));
	tire.setOrigin(taille / 2, taille / 2);
	tire.setTexture(texttire);

	texttrait = new Texture();
	try {
	    texttrait.loadFromFile(Paths.get("images/clavier/trait.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	trait = new RectangleShape(new Vector2f(taille, taille));
	trait.setOrigin(taille / 2, taille / 2);
	trait.setTexture(texttrait);

	textfermer = new Texture();
	try {
	    textfermer.loadFromFile(Paths.get("images/clavier/fermer.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	fermer = new RectangleShape(new Vector2f(taille, taille));
	fermer.setOrigin(taille / 2, taille / 2);
	fermer.setTexture(textfermer);

	textsuppr = new Texture();
	try {
	    textsuppr.loadFromFile(Paths.get("images/clavier/suppr.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	suppr = new RectangleShape(new Vector2f(taille, taille));
	suppr.setOrigin(taille / 2, taille / 2);
	suppr.setTexture(textsuppr);

	textbarre = new Texture();
	try {
	    textbarre.loadFromFile(Paths.get("images/clavier/barre.png"));
	} catch (IOException e1) {
	    System.out.println("Erreur texture");
	}

	barre = new RectangleShape(new Vector2f(9 * taille, taille));
	barre.setOrigin((9 * taille) / 2, taille / 2);
	barre.setTexture(textbarre);

	textAfficher = new Text(" Saisissez le nom du fichier ", Systeme.font);
	textAfficher.setCharacterSize(15);
	textAfficher.setColor(Color.RED);
	textAfficher.setStyle(Text.BOLD);
    }

    /**
     * Gets the suppr bounds.
     * 
     * @return the suppr bounds
     */
    public Vector2f getSupprBounds() {
	return suppr.getPosition();
    }

    /**
     * Sets the position.
     * 
     * @param cursor
     *            the new position
     */
    public void setPosition(TuioCursor cursor) {
	float coorX = cursor.getX() * Systeme.screen.x;
	float coorY = cursor.getY() * Systeme.screen.y;
	a.setPosition(coorX + (taille / 2), coorY - (7 * taille / 2));
	z.setPosition(coorX + (3 * taille / 2), coorY - (7 * taille / 2));
	e.setPosition(coorX + (5 * taille / 2), coorY - (7 * taille / 2));
	r.setPosition(coorX + (7 * taille / 2), coorY - (7 * taille / 2));
	t.setPosition(coorX + (9 * taille / 2), coorY - (7 * taille / 2));
	y.setPosition(coorX + (11 * taille / 2), coorY - (7 * taille / 2));
	u.setPosition(coorX + (13 * taille / 2), coorY - (7 * taille / 2));
	i.setPosition(coorX + (15 * taille / 2), coorY - (7 * taille / 2));
	o.setPosition(coorX + (17 * taille / 2), coorY - (7 * taille / 2));
	p.setPosition(coorX + (19 * taille / 2), coorY - (7 * taille / 2));

	q.setPosition(coorX + (taille / 2), coorY - (5 * taille / 2));
	s.setPosition(coorX + (3 * taille / 2), coorY - (5 * taille / 2));
	d.setPosition(coorX + (5 * taille / 2), coorY - (5 * taille / 2));
	f.setPosition(coorX + (7 * taille / 2), coorY - (5 * taille / 2));
	g.setPosition(coorX + (9 * taille / 2), coorY - (5 * taille / 2));
	h.setPosition(coorX + (11 * taille / 2), coorY - (5 * taille / 2));
	j.setPosition(coorX + (13 * taille / 2), coorY - (5 * taille / 2));
	k.setPosition(coorX + (15 * taille / 2), coorY - (5 * taille / 2));
	l.setPosition(coorX + (17 * taille / 2), coorY - (5 * taille / 2));
	m.setPosition(coorX + (19 * taille / 2), coorY - (5 * taille / 2));

	w.setPosition(coorX + (taille / 2), coorY - (3 * taille / 2));
	x.setPosition(coorX + (3 * taille / 2), coorY - (3 * taille / 2));
	c.setPosition(coorX + (5 * taille / 2), coorY - (3 * taille / 2));
	v.setPosition(coorX + (7 * taille / 2), coorY - (3 * taille / 2));
	b.setPosition(coorX + (9 * taille / 2), coorY - (3 * taille / 2));
	n.setPosition(coorX + (11 * taille / 2), coorY - (3 * taille / 2));
	point.setPosition(coorX + (13 * taille / 2), coorY - (3 * taille / 2));
	tire.setPosition(coorX + (15 * taille / 2), coorY - (3 * taille / 2));
	trait.setPosition(coorX + (17 * taille / 2), coorY - (3 * taille / 2));
	entrer.setPosition(coorX + (19 * taille / 2), coorY - (3 * taille / 2));

	fermer.setPosition(coorX + (taille / 2), coorY - (taille / 2));

	suppr.setPosition(coorX + (19 * taille / 2), coorY - (9 * taille / 2));

	barre.setPosition(coorX + (9 * taille / 2), coorY - (9 * taille / 2));

	textAfficher.setPosition(coorX + (taille / 2), coorY
		- ((19 * taille) / 4));
    }

    /**
     * Sets the position.
     * 
     * @param vect
     *            the new position
     */
    public void setPosition(Vector2f vect) {

	float coorX = vect.x;
	float coorY = vect.y;
	a.setPosition(coorX + (taille / 2), coorY - (7 * taille / 2));
	z.setPosition(coorX + (3 * taille / 2), coorY - (7 * taille / 2));
	e.setPosition(coorX + (5 * taille / 2), coorY - (7 * taille / 2));
	r.setPosition(coorX + (7 * taille / 2), coorY - (7 * taille / 2));
	t.setPosition(coorX + (9 * taille / 2), coorY - (7 * taille / 2));
	y.setPosition(coorX + (11 * taille / 2), coorY - (7 * taille / 2));
	u.setPosition(coorX + (13 * taille / 2), coorY - (7 * taille / 2));
	i.setPosition(coorX + (15 * taille / 2), coorY - (7 * taille / 2));
	o.setPosition(coorX + (17 * taille / 2), coorY - (7 * taille / 2));
	p.setPosition(coorX + (19 * taille / 2), coorY - (7 * taille / 2));

	q.setPosition(coorX + (taille / 2), coorY - (5 * taille / 2));
	s.setPosition(coorX + (3 * taille / 2), coorY - (5 * taille / 2));
	d.setPosition(coorX + (5 * taille / 2), coorY - (5 * taille / 2));
	f.setPosition(coorX + (7 * taille / 2), coorY - (5 * taille / 2));
	g.setPosition(coorX + (9 * taille / 2), coorY - (5 * taille / 2));
	h.setPosition(coorX + (11 * taille / 2), coorY - (5 * taille / 2));
	j.setPosition(coorX + (13 * taille / 2), coorY - (5 * taille / 2));
	k.setPosition(coorX + (15 * taille / 2), coorY - (5 * taille / 2));
	l.setPosition(coorX + (17 * taille / 2), coorY - (5 * taille / 2));
	m.setPosition(coorX + (19 * taille / 2), coorY - (5 * taille / 2));

	w.setPosition(coorX + (taille / 2), coorY - (3 * taille / 2));
	x.setPosition(coorX + (3 * taille / 2), coorY - (3 * taille / 2));
	c.setPosition(coorX + (5 * taille / 2), coorY - (3 * taille / 2));
	v.setPosition(coorX + (7 * taille / 2), coorY - (3 * taille / 2));
	b.setPosition(coorX + (9 * taille / 2), coorY - (3 * taille / 2));
	n.setPosition(coorX + (11 * taille / 2), coorY - (3 * taille / 2));
	point.setPosition(coorX + (13 * taille / 2), coorY - (3 * taille / 2));
	tire.setPosition(coorX + (15 * taille / 2), coorY - (3 * taille / 2));
	trait.setPosition(coorX + (17 * taille / 2), coorY - (3 * taille / 2));
	entrer.setPosition(coorX + (19 * taille / 2), coorY - (3 * taille / 2));

	fermer.setPosition(coorX + (taille / 2), coorY - (taille / 2));

	suppr.setPosition(coorX + (19 * taille / 2), coorY - (9 * taille / 2));

	barre.setPosition(coorX + (9 * taille / 2), coorY - (9 * taille / 2));

	textAfficher.setPosition(coorX + (taille / 2), coorY
		- ((19 * taille) / 4));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget,
     * org.jsfml.graphics.RenderStates)
     */
    @Override
    public void draw(RenderTarget arg0, RenderStates arg1) {
	if (visible) {
	    a.draw(arg0, arg1);
	    b.draw(arg0, arg1);
	    c.draw(arg0, arg1);
	    d.draw(arg0, arg1);
	    e.draw(arg0, arg1);
	    f.draw(arg0, arg1);
	    g.draw(arg0, arg1);
	    h.draw(arg0, arg1);
	    i.draw(arg0, arg1);
	    j.draw(arg0, arg1);
	    k.draw(arg0, arg1);
	    l.draw(arg0, arg1);
	    m.draw(arg0, arg1);
	    n.draw(arg0, arg1);
	    o.draw(arg0, arg1);
	    p.draw(arg0, arg1);
	    q.draw(arg0, arg1);
	    r.draw(arg0, arg1);
	    s.draw(arg0, arg1);
	    t.draw(arg0, arg1);
	    u.draw(arg0, arg1);
	    v.draw(arg0, arg1);
	    w.draw(arg0, arg1);
	    x.draw(arg0, arg1);
	    y.draw(arg0, arg1);
	    z.draw(arg0, arg1);
	    entrer.draw(arg0, arg1);
	    point.draw(arg0, arg1);
	    tire.draw(arg0, arg1);
	    trait.draw(arg0, arg1);
	    fermer.draw(arg0, arg1);
	    suppr.draw(arg0, arg1);
	    barre.draw(arg0, arg1);
	    textAfficher.draw(arg0, arg1);
	}

    }

    /**
     * Checks if is visible.
     * 
     * @return true, if is visible
     */
    public boolean isVisible() {
	return this.visible;
    }

    /**
     * Sets the visible.
     * 
     * @param visible
     *            the new visible
     */
    public void setVisible(boolean visible) {
	this.visible = visible;
    }

    /**
     * Ouvrir clavier.
     * 
     * @param c1
     *            the c1
     */
    public void ouvrirClavier(TuioCursor c1) {
	if (Systeme.clavier.isVisible()) {
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
	    } else {
		if (Systeme.clavier.isValide()) {
		    validationSaisie();
		} else {
		    Systeme.clavier.saisie(c1);
		}

	    }
	}
    }

    /**
     * Validation saisie.
     */
    public void validationSaisie() {
	if (Systeme.clavier.isValide()) {
	    try {
		Systeme.conteneur.sauvegarder(Systeme.clavier.getUrl());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	Systeme.clavier.setVisible(false);
    }

    /**
     * Action clavier.
     * 
     * @param cursor
     *            the cursor
     * @return the char
     */
    public char actionClavier(TuioCursor cursor) {
	char lettre = ' ';
	Vector2f coord = new Vector2f(cursor.getX() * Systeme.screen.x,
		cursor.getY() * Systeme.screen.y);
	if (isVisible()) {
	    if (a.getGlobalBounds().contains(coord)) {
		lettre = 'a';
	    } else if (b.getGlobalBounds().contains(coord)) {
		lettre = 'b';
	    } else if (c.getGlobalBounds().contains(coord)) {
		lettre = 'c';
	    } else if (d.getGlobalBounds().contains(coord)) {
		lettre = 'd';
	    } else if (e.getGlobalBounds().contains(coord)) {
		lettre = 'e';
	    } else if (f.getGlobalBounds().contains(coord)) {
		lettre = 'f';
	    } else if (g.getGlobalBounds().contains(coord)) {
		lettre = 'g';
	    } else if (h.getGlobalBounds().contains(coord)) {
		lettre = 'h';
	    } else if (i.getGlobalBounds().contains(coord)) {
		lettre = 'i';
	    } else if (j.getGlobalBounds().contains(coord)) {
		lettre = 'j';
	    } else if (k.getGlobalBounds().contains(coord)) {
		lettre = 'k';
	    } else if (l.getGlobalBounds().contains(coord)) {
		lettre = 'l';
	    } else if (m.getGlobalBounds().contains(coord)) {
		lettre = 'm';
	    } else if (n.getGlobalBounds().contains(coord)) {
		lettre = 'n';
	    } else if (o.getGlobalBounds().contains(coord)) {
		lettre = 'o';
	    } else if (p.getGlobalBounds().contains(coord)) {
		lettre = 'p';
	    } else if (q.getGlobalBounds().contains(coord)) {
		lettre = 'q';
	    } else if (r.getGlobalBounds().contains(coord)) {
		lettre = 'r';
	    } else if (s.getGlobalBounds().contains(coord)) {
		lettre = 's';
	    } else if (t.getGlobalBounds().contains(coord)) {
		lettre = 't';
	    } else if (u.getGlobalBounds().contains(coord)) {
		lettre = 'u';
	    } else if (v.getGlobalBounds().contains(coord)) {
		lettre = 'v';
	    } else if (w.getGlobalBounds().contains(coord)) {
		lettre = 'w';
	    } else if (x.getGlobalBounds().contains(coord)) {
		lettre = 'x';
	    } else if (y.getGlobalBounds().contains(coord)) {
		lettre = 'y';
	    } else if (z.getGlobalBounds().contains(coord)) {
		lettre = 'z';
	    } else if (point.getGlobalBounds().contains(coord)) {
		lettre = '.';
	    } else if (tire.getGlobalBounds().contains(coord)) {
		lettre = '-';
	    } else if (trait.getGlobalBounds().contains(coord)) {
		lettre = '_';
	    } else if (barre.getGlobalBounds().contains(coord)) {
		lettre = ' ';
	    } else if (entrer.getGlobalBounds().contains(coord)) {
		lettre = '=';
	    }
	}
	return lettre;
    }

    /**
     * Saisie.
     * 
     * @param cursor
     *            the cursor
     */
    public void saisie(TuioCursor cursor) {
	if (visible) {
	    char c = actionClavier(cursor);
	    if (c == ' ') {
		if (url.length() > 0) {
		    url = url.substring(0, url.length() - 1);
		}
	    } else if (c == '=') {
		validation = true;
	    } else {
		url = url + String.valueOf(c);
	    }
	    textAfficher.setString(url);
	}
    }

    /**
     * Checks if is valide.
     * 
     * @return true, if is valide
     */
    public boolean isValide() {
	return this.validation;
    }

    /**
     * Gets the url.
     * 
     * @return the url
     */
    public String getUrl() {
	return this.url;
    }

    /**
     * Checks if is inside fermer.
     * 
     * @param cursor
     *            the cursor
     * @return true, if is inside fermer
     */
    public boolean isInsideFermer(TuioCursor cursor) {

	return fermer.getGlobalBounds().contains(
		cursor.getX() * Systeme.screen.x,
		cursor.getY() * Systeme.screen.y);
    }
}// end Clavier
