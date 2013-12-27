package image;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class Image implements Cloneable{
	Sprite image;
	String nom;
	
	Image (String path){
		Path chemin =  Paths.get(path);
		nom = chemin.getName(chemin.getNameCount()).toString();
		Texture texture = new Texture();
		try {
			texture.loadFromFile(Paths.get(path));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		Vector2i taille = texture.getSize();
		image = new Sprite(texture);
		image.setOrigin(new Vector2f(Vector2i.div(taille, 2)));
		image.scale(20/taille.x,20/taille.y);
	}
	
	public Image clone () {
		Image tmp = null;
		try {
			tmp = (Image) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Erreur clonage");
			return null;
		}
		tmp.image=this.image;
		tmp.nom=this.nom;
		return tmp;
	}
		
}
