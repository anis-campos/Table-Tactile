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

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;

// TODO: Auto-generated Javadoc
/**
 * The Class ListeImage.
 */
public class ListeImage implements Drawable {

	/** The list image. */
	public ArrayList<Image> listImage;

	/**
	 * Instantiates a new liste image.
	 */
	public ListeImage() {
		listImage = new ArrayList<Image>();
	}

	/**
	 * Ajouter.
	 * 
	 * @param path
	 *            the path
	 */
	public void ajouter(String path) {
		listImage.add(new Image(path));
	}

	/**
	 * Ajouter.
	 * 
	 * @param i
	 *            the i
	 */
	public void ajouter(Image i) {
		listImage.add(i);
	}

	/**
	 * Gets the image.
	 * 
	 * @param i
	 *            the i
	 * @return the image
	 */
	public Image getImage(int i) {
		return listImage.get(i);
	}

	/**
	 * Size.
	 * 
	 * @return the int
	 */
	public int size() {
		return listImage.size();
	}

	/**
	 * Retirer.
	 * 
	 * @param i
	 *            the i
	 */
	public void retirer(Image i) {
		i.stopThread();
		listImage.remove(i);
	}

	/**
	 * Arreter.
	 */
	public void arreter() {
		for (Image image : listImage)
			image.stopThread();
		this.listImage.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jsfml.graphics.Drawable#draw(org.jsfml.graphics.RenderTarget,
	 * org.jsfml.graphics.RenderStates)
	 */
	@Override
	public void draw(RenderTarget target, RenderStates states) {
		
		Collections.sort(listImage);
		
		removedImage();
		
		for (Image image : listImage){
			
			image.draw(target, states);
		}

	}

	private void removedImage() {
		ArrayList<Image> removed = new ArrayList<>();
		for (Image image : listImage){
			if(image.isRemoved())
				removed.add(image);
						
		}
		
		for (Image i : removed){
			retirer(i);
		}
			
		
	}
}
