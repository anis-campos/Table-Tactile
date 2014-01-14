package image;

import java.util.Vector;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;

public class ListeImage implements Drawable {

	public Vector<Image> listImage;


	public ListeImage() {
		listImage=new Vector<Image>();
	}

	public void ajouter(String path){
		listImage.add(new Image(path));
	}

	public void arreter (){
		for ( Image image : listImage)
			image.gesture.running=false;
		for ( Image image : listImage){
			try {
				image.thread.join();
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
		}
	}

	public void permuter ( int indice1, int indice2){
		Image tmp = listImage.get(indice1).clone();
		listImage.set(indice1, listImage.get(indice2));
		listImage.set(indice2, tmp);
	}

	@Override
	public void draw(RenderTarget target, RenderStates states) {
		for ( Image image : listImage)
			image.draw(target, states);

	}
}
