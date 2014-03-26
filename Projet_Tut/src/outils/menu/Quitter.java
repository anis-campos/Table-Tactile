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

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;

import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class Quitter.
 */
public class Quitter implements Drawable {

    /** The t. */
    Text t;

    /** The visible. */
    boolean visible = false;

    /**
     * Instantiates a new quitter.
     * 
     * @param t
     *            the t
     */
    public Quitter(Text t) {
	this.t = t;
    }

    /**
     * Instantiates a new quitter.
     */
    public Quitter() {
	initialisation();
    }

    /**
     * Initialisation.
     */
    public void initialisation() {
	t = new Text("", Systeme.font);
	t.setOrigin(t.getGlobalBounds().width / 2,
		t.getGlobalBounds().height / 2);
	t.setCharacterSize(60);
	t.setStyle(Text.BOLD);
	t.setColor(Color.RED);
	t.setPosition(Systeme.screen.x / 2, Systeme.screen.y / 2);
    }

    /**
     * Affiche.
     * 
     * @throws InterruptedException
     *             the interrupted exception
     */
    public void affiche() throws InterruptedException {
	Systeme.quitter.t.setString("L'application quitte dans 3 sec");
	Thread.sleep(1000);
	Systeme.quitter.t.setString("L'application quitte dans 2 sec");
	Thread.sleep(1000);
	Systeme.quitter.t.setString("L'application quitte dans 1 sec");
	Thread.sleep(1000);
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
	    t.draw(arg0, arg1);
	}
    }

    /**
     * Sets the visible.
     * 
     * @param v
     *            the new visible
     */
    public void setVisible(boolean v) {
	this.visible = v;
    }

}
