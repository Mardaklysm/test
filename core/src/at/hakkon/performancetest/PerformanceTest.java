package at.hakkon.performancetest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class PerformanceTest extends Game {
	SpriteBatch batch;
	Texture img;
	
	public static BitmapFont FONT_SIZE_0;
	public static BitmapFont FONT_SIZE_2;
	public static BitmapFont FONT_SIZE_1;


	@Override
	public void create() {
		this.setScreen(new GameScreen());
		createFonts();
	}
	
	private void createFonts() {
	    FileHandle fontFile = Gdx.files.internal("fonts/Roboto-BoldCondensed.ttf");
	    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
	    FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	    

	   	parameter.size = Gdx.graphics.getHeight() / 48;//12;
	    FONT_SIZE_0 = generator.generateFont(parameter);
	    	    
	    parameter.size = Gdx.graphics.getHeight() / 24;//12;
	    FONT_SIZE_1 = generator.generateFont(parameter);
	    
	    parameter.size = Gdx.graphics.getHeight() / 16;// 24;
	    FONT_SIZE_2 = generator.generateFont(parameter);
	    generator.dispose();
	    
	}

}