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
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;

import application.Systeme;

// TODO: Auto-generated Javadoc
/**
 * The Class Quitter.
 */
public class Quitter extends Text {



    /** The visible. */
    boolean visible = false;


    /**
     * Instantiates a new quitter.
     */
    public Quitter() {
    	super("", Systeme.font);
    	setOrigin(getGlobalBounds().width / 2,
    		getGlobalBounds().height / 2);
    	setCharacterSize(36);
    	setStyle(Text.BOLD);
    	setColor(Color.RED);
    	setPosition(Systeme.screen.x / 2, Systeme.screen.y / 2);
    }


    /**
     * Affiche.
     * 
     * @throws InterruptedException
     *             the interrupted exception
     */
    public void affiche() throws InterruptedException {
	setString("L'application quitte dans 3 sec");
	Thread.sleep(1000);
	setString("L'application quitte dans 2 sec");
	Thread.sleep(1000);
	setString("L'application quitte dans 1 sec");
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
	    super.draw(arg0, arg1);
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
