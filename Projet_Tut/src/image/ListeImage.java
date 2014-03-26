
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

package image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;


// TODO: Auto-generated Javadoc
/**
 * The Class ListeImage.
 */
public class ListeImage implements Drawable {

	/** The list image. */
	public List<Image> listImage;


	/**
	 * Instantiates a new liste image.
	 */
	public ListeImage() {
		listImage=new ArrayList<Image>();
	}

	/**
	 * Ajouter.
	 * 
	 * @param path
	 *            the path
	 */
	public void ajouter(String path){
		listImage.add(new Image(path));
	}
	
	/**
     * Ajouter.
     * 
     * @param i
     *            the i
     */
	public void ajouter(Image i){
		listImage.add(i);
	}
	
	/**
     * Gets the image.
     * 
     * @param i
     *            the i
     * @return the image
     */
	public Image getImage(int i){
		return listImage.get(i);
	}
	
	/**
     * Size.
     * 
     * @return the int
     */
	public int size(){
		return listImage.size();
	}
	
	/**
     * Retirer.
     * 
     * @param i
     *            the i
     */
	public void retirer(Image i ){
		i.stopThread();
		listImage.remove(i);
	}
	
	/**
	 * Arreter.
	 */
	public void arreter (){
		for ( Image image : listImage)
			image.stopThread();
		
	}

	/**
	 * Permuter.
	 * 
	 * @param indice1
	 *            the indice1
	 * @param indice2
	 *            the indice2
	 */
	public void permuter ( int indice1, int indice2){
		Image tmp = listImage.get(indice1).clone();
		listImage.set(indice1, listImage.get(indice2));
		listImage.set(indice2, tmp);
	}

	/* (non-Javadoc)
	 * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget, org.jsfml.graphics.RenderStates)
	 */
	@Override
	public void draw(RenderTarget target, RenderStates states) {
		Collections.sort(listImage);
		for ( Image image : listImage)
			image.draw(target, states);

	}
}
