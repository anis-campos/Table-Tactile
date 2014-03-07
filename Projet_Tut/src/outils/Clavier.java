package outils;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import application.Systeme;
import TUIO.TuioCursor;

public class Clavier implements Drawable {

	/** Attributs */

	float taille = 50;

	RectangleShape a;
	RectangleShape b;
	RectangleShape c;
	RectangleShape d;
	RectangleShape e;
	RectangleShape f;
	RectangleShape g;
	RectangleShape h;
	RectangleShape i;
	RectangleShape j;
	RectangleShape k;
	RectangleShape l;
	RectangleShape m;
	RectangleShape n;
	RectangleShape o;
	RectangleShape p;
	RectangleShape q;
	RectangleShape r;
	RectangleShape s;
	RectangleShape t;
	RectangleShape u;
	RectangleShape v;
	RectangleShape w;
	RectangleShape x;
	RectangleShape y;
	RectangleShape z;
	RectangleShape entrer;
	RectangleShape point;
	RectangleShape tire;
	RectangleShape trait;
	RectangleShape espace;
	RectangleShape fermer;
	RectangleShape suppr;
	RectangleShape barre;

	Texture texta;
	Texture textb;
	Texture textc;
	Texture textd;
	Texture texte;
	Texture textf;
	Texture textg;
	Texture texth;
	Texture texti;
	Texture textj;
	Texture textk;
	Texture textl;
	Texture textm;
	Texture textn;
	Texture texto;
	Texture textp;
	Texture textq;
	Texture textr;
	Texture texts;
	Texture textt;
	Texture textu;
	Texture textv;
	Texture textw;
	Texture textx;
	Texture texty;
	Texture textz;
	Texture textentrer;
	Texture textpoint;
	Texture texttire;
	Texture texttrait;
	Texture textespace;
	Texture textfermer;
	Texture textsuppr;
	Texture textbarre;

	Text 	textAfficher;
	
	boolean visible = false;

	/** Constructeur */

	public Clavier() {
		initialisation();
	}

	/** Methode */

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

		
		textespace = new Texture();
		try {
			textespace.loadFromFile(Paths.get("images/clavier/espace.png"));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		
		espace = new RectangleShape(new Vector2f(4 * taille, taille));
		espace.setOrigin((4 * taille) / 2, (taille / 2));
		espace.setTexture(textespace);

		
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
		
		barre = new RectangleShape(new Vector2f(9*taille, taille));
		barre.setOrigin((9*taille) / 2, taille / 2);
		barre.setTexture(textbarre);
		
		
		textAfficher = new Text(" Saisissez le nom du fichier ", Systeme.font);
		textAfficher.setCharacterSize(15);
		textAfficher.setColor(Color.RED);
		textAfficher.setStyle(Text.BOLD);
	}

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

		espace.setPosition(coorX + (5 * taille ), coorY - (taille/2));
		
		suppr.setPosition(coorX + (19 * taille / 2), coorY- (9 * taille / 2));
		
		barre.setPosition(coorX + (9 * taille / 2), coorY- (9 * taille / 2));
		
		textAfficher.setPosition(coorX+ (taille / 2), coorY- ((19 * taille) / 4));
	}

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
			espace.draw(arg0, arg1);
			fermer.draw(arg0, arg1);
			suppr.draw(arg0, arg1);
			barre.draw(arg0, arg1);
			textAfficher.draw(arg0, arg1);
		}

	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isInsideA(TuioCursor cursor) {
		return a.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideB(TuioCursor cursor) {
		return b.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideC(TuioCursor cursor) {
		return c.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideD(TuioCursor cursor) {
		return d.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideE(TuioCursor cursor) {
		return e.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideF(TuioCursor cursor) {
		return f.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideG(TuioCursor cursor) {
		return g.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideH(TuioCursor cursor) {
		return h.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideI(TuioCursor cursor) {
		return i.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideJ(TuioCursor cursor) {
		return j.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideK(TuioCursor cursor) {
		return k.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideL(TuioCursor cursor) {
		return l.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideM(TuioCursor cursor) {
		return m.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideN(TuioCursor cursor) {
		return n.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideO(TuioCursor cursor) {
		return o.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideP(TuioCursor cursor) {
		return p.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideQ(TuioCursor cursor) {
		return q.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideR(TuioCursor cursor) {
		return r.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideS(TuioCursor cursor) {
		return s.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideT(TuioCursor cursor) {
		return t.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideU(TuioCursor cursor) {
		return u.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideV(TuioCursor cursor) {
		return v.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideW(TuioCursor cursor) {
		return w.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideX(TuioCursor cursor) {
		return x.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideY(TuioCursor cursor) {
		return y.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideZ(TuioCursor cursor) {
		return z.getGlobalBounds().contains(cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideEntrer(TuioCursor cursor) {
		return entrer.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsidePoint(TuioCursor cursor) {
		return point.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideTire(TuioCursor cursor) {
		return tire.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideTrait(TuioCursor cursor) {
		return trait.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideEspace(TuioCursor cursor) {
		return espace.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public boolean isInsideFermer(TuioCursor cursor) {
		return fermer.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}
	
	public boolean isInsideSuppr(TuioCursor cursor) {
		return suppr.getGlobalBounds().contains(
				cursor.getX() * Systeme.screen.x,
				cursor.getY() * Systeme.screen.y);
	}

	public char actionClavier(TuioCursor cursor) {
			char lettre = ' ';
		if (Systeme.clavier.isVisible()) {
			if (Systeme.clavier.isInsideA(cursor)) {
				lettre = 'a';
			} else if (Systeme.clavier.isInsideB(cursor)) {
				lettre = 'b';
			} else if (Systeme.clavier.isInsideC(cursor)) {
				lettre = 'c';
			} else if (Systeme.clavier.isInsideD(cursor)) {
				lettre = 'd';
			} else if (Systeme.clavier.isInsideE(cursor)) {
				lettre = 'e';
			} else if (Systeme.clavier.isInsideF(cursor)) {
				lettre = 'f';
			} else if (Systeme.clavier.isInsideG(cursor)) {
				lettre = 'g';
			} else if (Systeme.clavier.isInsideH(cursor)) {
				lettre = 'h';
			} else if (Systeme.clavier.isInsideI(cursor)) {
				lettre = 'i';
			} else if (Systeme.clavier.isInsideJ(cursor)) {
				lettre = 'j';
			} else if (Systeme.clavier.isInsideK(cursor)) {
				lettre = 'k';
			} else if (Systeme.clavier.isInsideL(cursor)) {
				lettre = 'l';
			} else if (Systeme.clavier.isInsideM(cursor)) {
				lettre = 'm';
			} else if (Systeme.clavier.isInsideN(cursor)) {
				lettre = 'n';
			} else if (Systeme.clavier.isInsideO(cursor)) {
				lettre = 'o';
			} else if (Systeme.clavier.isInsideP(cursor)) {
				lettre = 'p';
			} else if (Systeme.clavier.isInsideQ(cursor)) {
				lettre = 'q';
			} else if (Systeme.clavier.isInsideR(cursor)) {
				lettre = 'r';
			} else if (Systeme.clavier.isInsideS(cursor)) {
				lettre = 's';
			} else if (Systeme.clavier.isInsideT(cursor)) {
				lettre = 't';
			} else if (Systeme.clavier.isInsideU(cursor)) {
				lettre = 'u';
			} else if (Systeme.clavier.isInsideV(cursor)) {
				lettre = 'v';
			} else if (Systeme.clavier.isInsideW(cursor)) {
				lettre = 'w';
			} else if (Systeme.clavier.isInsideX(cursor)) {
				lettre = 'x';
			} else if (Systeme.clavier.isInsideY(cursor)) {
				lettre = 'y';
			} else if (Systeme.clavier.isInsideZ(cursor)) {
				lettre = 'z';
			} else if (Systeme.clavier.isInsidePoint(cursor)) {
				lettre = '.';
			} else if (Systeme.clavier.isInsideTire(cursor)) {
				lettre = '-';
			} else if (Systeme.clavier.isInsideTrait(cursor)) {
				lettre = '_';
			} else if (Systeme.clavier.isInsideEspace(cursor)) {
				lettre = ' ';
			}
		} 
		return lettre ;
	}
	
	
}//end Clavier
