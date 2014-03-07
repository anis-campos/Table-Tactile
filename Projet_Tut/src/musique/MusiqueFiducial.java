package musique;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.audio.Music;

import TUIO.TuioObject;

public class MusiqueFiducial {

	static String 	url;
	static Music 	music = new Music();
	static int		enJeu;
	static boolean 	play = false;
	
	public static void actionFiducialAjout(TuioObject tobj) throws IOException {
		switch ((int) tobj.getSymbolID()) {
		case 4:
			url="musique/4.ogg";
			if(!play){
				music.openFromFile(Paths.get(url));
				music.play();
				play = true;
				enJeu = 4;
			}
			break;

		case 5:
			url="musique/5.ogg";
			if(!play){
				music.openFromFile(Paths.get(url));
				music.play();
				play = true;
				enJeu = 5;
			}
			break;

		case 6:
			url="musique/6.ogg";
			if(!play){
				music.openFromFile(Paths.get(url));
				music.play();
				play = true;
				enJeu = 6;
			}
			break;

		case 7:
			url="musique/7.ogg";
			if(!play){
				music.openFromFile(Paths.get(url));
				music.play();
				play = true;
				enJeu = 7;
			}
			break;
		default:
			break;
		}

	}
	
	public static void actionFiducialRetrait(TuioObject tobj){
		switch ((int) tobj.getSymbolID()){
			case 4:
				if(play && enJeu == 4){
					music.stop();
					play = false;
					enJeu=0;
				}
				break;
				
			case 5:
				if(play && enJeu == 5){
					music.stop();
					play = false;
					enJeu=0;
				}
				break;
				
			case 6:
				if(play && enJeu == 6){
					music.stop();
					play = false;
					enJeu=0;
				}
				break;
			
			case 7:
				if(play && enJeu == 7){
					music.stop();
					play = false;
					enJeu=0;
				}
				break;
				
			default:
				break;
		}
	}
	
	
}