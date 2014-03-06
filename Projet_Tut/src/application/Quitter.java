package application;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;

public class Quitter implements Drawable{

	
	Text 		t;
	boolean		visible = false;
	
	public Quitter(Text t){
		this.t = t;
	}
	
	public Quitter(){
		initialisation();
	}
	
	public void initialisation(){
		t = new Text("",Systeme.font);
		t.setOrigin(t.getGlobalBounds().width/2, t.getGlobalBounds().height/2);
		t.setCharacterSize(60);
		t.setStyle(Text.BOLD);
		t.setColor(Color.RED);
		t.setPosition(Systeme.window.getSize().x/2, Systeme.window.getSize().y/2);
	}
	
	public void affiche() throws InterruptedException{
		Systeme.quitter.t.setString("L'application quitte dans 3 sec");
		Thread.sleep(1000);
		Systeme.quitter.t.setString("L'application quitte dans 2 sec");
		Thread.sleep(1000);
		Systeme.quitter.t.setString("L'application quitte dans 1 sec");
		Thread.sleep(1000);
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if(visible){
			t.draw(arg0, arg1);
		}
	}
	
	public void setVisible(boolean v){
		this.visible = v;
	}

}
