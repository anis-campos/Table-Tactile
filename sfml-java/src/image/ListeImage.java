package image;

import java.util.Vector;

public class ListeImage {
	
	Vector<Image> listImage;
	
	public ListeImage() {
		listImage=new Vector<Image>();
	}
	
	public void ajouter(String path){
		listImage.add(new Image(path));
	}
	
	public void supprimer ( int indice){
		listImage.remove(indice);
	}
	
	public void permuter ( int indice1, int indice2){
		Image tmp = listImage.get(indice1).clone();
		listImage.set(indice1, listImage.get(indice2));
		listImage.set(indice2, tmp);
	}
}
