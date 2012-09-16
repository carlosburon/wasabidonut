package com.me.testo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Testo implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	Texture dropImage;
	Texture bucketImage;
    Sound dropSound;
    Music rainMusic;

	@Override
	   public void create() {
	      // load the images for the droplet and the bucket, 48x48 pixels each
	      dropImage = new Texture(Gdx.files.internal("water.png"));
	      bucketImage = new Texture(Gdx.files.internal("bucket.png"));
	      
	      // load the drop sound effect and the rain background "music"
	      dropSound = Gdx.audio.newSound(Gdx.files.internal("waterdrop.wav"));
	      rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
	      
	      // start the playback of the background music immediately
	      rainMusic.setLooping(true);
	      rainMusic.play();
			
			camera = new OrthographicCamera();
			camera.setToOrtho(false, 800, 480);
			batch = new SpriteBatch();
			
//			texture = new Texture(Gdx.files.internal("data/libgdx.png")); todo esto sobra, es parte del logo
//			texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//			
//			TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
//			
//			sprite = new Sprite(region);
//			sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
//			sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
//			sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 1, 0, 1); // modificado a color verde, estaba en blanco (1, 1, 1) el ultimo valor es el canal alfa
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//sprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
