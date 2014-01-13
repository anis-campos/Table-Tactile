package image;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import application.Systeme;

public class Image implements Cloneable, Drawable{
	public Sprite image;

	static Vector2f position = new Vector2f(100f,100f);
	static int compteur=0;
	final Vector2f ecart = new Vector2f(50f,50f);
	public Image (String path){
		
		Texture texture = new Texture();
		try {
			texture.loadFromFile(Paths.get(path));
		} catch (IOException e1) {
			System.out.println("Erreur texture");
		}
		Vector2i taille = texture.getSize();
		image = new Sprite(texture);
		image.setOrigin(new Vector2f(Vector2i.div(taille, 2)));
		image.setPosition(position);
		if (position.x < Systeme.screen.x && position.y<Systeme.screen.y)
				position=Vector2f.add(position, ecart);
		else{
			compteur++;
			position = new Vector2f(100+compteur*150,100);
		}
		image.scale((float)200/taille.x,(float)200/taille.y);
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
		
		return tmp;
	}

	@Override
	public void draw(RenderTarget target, RenderStates states) {
		image.draw(target, states);
	}
		
}
