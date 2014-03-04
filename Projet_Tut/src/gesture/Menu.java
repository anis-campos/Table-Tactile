package gesture;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

import application.Systeme;
import TUIO.TuioCursor;

public class Menu implements Drawable{
	
	RectangleShape 	carre;
	CircleShape 	cercle;
	CircleShape 	triangle1;
	CircleShape 	triangle2;
	CircleShape 	triangle3;
	CircleShape 	triangle4;
	boolean visible = false;
	Text text;
	
	public Menu() {
		cercle = new CircleShape(150);
		cercle.setOrigin(150, 150);
		cercle.setFillColor(new Color(255,255,255, 100));
		cercle.setOutlineThickness(4);
		cercle.setOutlineColor(Color.WHITE);
		
		carre = new RectangleShape(new Vector2f(100, 100));
		carre.setOrigin(50, 50);
		
		triangle1 = new CircleShape(50, 3);
		triangle1.setOrigin(50, 50);
		triangle1.setFillColor(Color.CYAN);
		
		triangle2 = new CircleShape(50, 3);
		triangle2.setOrigin(50, 50);
		triangle2.setFillColor(Color.CYAN);
		triangle2.setRotation(90);
		
		triangle3 = new CircleShape(50, 3);
		triangle3.setOrigin(50, 50);
		triangle3.setFillColor(Color.CYAN);
		triangle3.setRotation(180);
		
		triangle4 = new CircleShape(50, 3);
		triangle4.setOrigin(50, 50);
		triangle4.setFillColor(Color.CYAN);
		triangle4.setRotation(-90);
		
		carre.setOutlineColor(Color.BLUE);
		carre.setOutlineThickness(10);
		carre.setFillColor(Color.TRANSPARENT);
		text = new Text("MENU",Systeme.font);
		text.setCharacterSize(20);
		text.setColor(Color.GREEN);
		text.setStyle(Text.BOLD);
		
	}
	
	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		if (visible){
			
			cercle.draw(arg0, arg1);
			carre.draw(arg0, arg1);
			
			triangle1.draw(arg0, arg1);
			triangle2.draw(arg0, arg1);
			triangle3.draw(arg0, arg1);
			triangle4.draw(arg0, arg1);
			
			text.draw(arg0, arg1);
		}	
	}

	
	public void setPosition(TuioCursor cursor){
		carre.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
		cercle.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
		triangle1.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y-100);
		triangle2.setPosition(cursor.getX()*Systeme.screen.x+100, cursor.getY()*Systeme.screen.y);
		triangle3.setPosition(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y+100);
		triangle4.setPosition(cursor.getX()*Systeme.screen.x-100, cursor.getY()*Systeme.screen.y);
		
		text.setPosition(cursor.getX()*Systeme.screen.x-30, cursor.getY()*Systeme.screen.y-10);
		
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return this.visible;
	}
	
	public boolean isInside(TuioCursor cursor){
		return carre.getGlobalBounds().contains(cursor.getX()*Systeme.screen.x, cursor.getY()*Systeme.screen.y);
	}
}
