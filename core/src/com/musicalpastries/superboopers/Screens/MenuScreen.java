package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.musicalpastries.superboopers.Actors.ImageAnimated;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 12/23/2017.
 */

public class MenuScreen extends SuperScreen {

    ImageAnimated logo;
    private SpriteBatch batch;

    public MenuScreen(SuperBoopers game){
        super(game, SuperBoopers.eScreen.MAIN, new OrthographicCamera());

        setupLogo();

        r= 0;
        g= .5f;
        b= .2f;
    }

    private void setupLogo() throws GdxRuntimeException {
        TextureRegion logoSpriteSheet;
        TextureRegion[] logoArray;
        Animation logoAnimation;
        int width = 450;
        int height = 96;
        try {
            logoSpriteSheet = new TextureRegion(new Texture(Gdx.files.internal("skin/SUPERboopers.png")));
        }catch (GdxRuntimeException e){
            logoSpriteSheet = new TextureRegion(new Texture(Gdx.files.external("AndroidStudioProjects/SuperBooper/android/assets/skin/SUPERboopers.png")));
        }
        logoArray = new TextureRegion[15];
        for (int i = 0; i < logoArray.length; i++) {
            logoArray[i] = new TextureRegion(logoSpriteSheet, width*i, 0, width, height);
        }
        logoAnimation = new Animation(1f/10,logoArray);
        logo = new ImageAnimated(logoAnimation);
        logo.setSize(width, height);
    }

    @Override
    public void show() {
        super.show();

        //table contents
        Table tableTop = new Table();
        tableTop.setDebug(false);

        TextButton inventory = new TextButton("Inventory", skin);
        TextButton goals = new TextButton("Goals", skin);
        TextButton store = new TextButton("Store", skin);

        Table tableCommunity = new Table();
        tableCommunity.setDebug(false);
        TextButton community = new TextButton("Community", skin);
        TextButton google = new TextButton("G", skin);

        TextButton settings = new TextButton("Settings", skin);
        TextButton donate = new TextButton("Donate", skin);
        TextButton credits = new TextButton("Credits", skin);
        Label copyright = new Label("(C) 2018", new Label.LabelStyle(skin.getFont("font"),
                com.badlogic.gdx.graphics.Color.WHITE));

        table.top();

        table.add(logo).colspan(2).expand().fill().center().padTop(20);

        table.row().padTop(15).padLeft(10).padRight(10);
        table.add(tableTop).colspan(2).fillX();
        tableTop.add(back);
        tableTop.add(inventory).expandX().fillX().padLeft(10);

        table.row().padTop(10).padLeft(10).padRight(10);
        table.add(goals).fillX().uniformX();
        table.add(store).fillX().uniformX().padLeft(10);

        table.row().padTop(10).padLeft(10).padRight(10);
        table.add(tableCommunity).colspan(2).fillX();
        tableCommunity.add(community).expandX().fillX();
        tableCommunity.add(google).padLeft(10).width(100);

        table.row().padTop(10).padLeft(10).padRight(10);
        table.add(settings).fillX().colspan(2);

        table.row().padTop(10).padLeft(10).padRight(10);
        table.add(donate).fillX().uniformX();
        table.add(credits).fillX().padLeft(10).uniformX();

        table.row().padTop(10).padBottom(30).padLeft(10).padRight(10);
        table.add(copyright).colspan(2).bottom();

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.MAIN, SuperBoopers.eScreen.MENU);
            }
        });
        inventory.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.INVENTORY, SuperBoopers.eScreen.MENU);
            }
        });
//
        goals.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.GOALS, SuperBoopers.eScreen.MENU);
            }
        });
        store.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.STORE, SuperBoopers.eScreen.MENU);
            }
        });
//
        community.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.COMMUNITY, SuperBoopers.eScreen.MENU);
            }
        });
        google.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.GOOGLE, SuperBoopers.eScreen.MENU);
            }
        });
//
        settings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.SETTINGS, SuperBoopers.eScreen.MENU);
            }
        });
//
        donate.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.DONATE, SuperBoopers.eScreen.MENU);
            }
        });
        credits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.CREDITS, SuperBoopers.eScreen.MENU);
            }
        });
    }

    @Override
    void renderBatch() {
        this.batch = getGame().getBatch();
        batch.begin();
        batch.setProjectionMatrix(getGameCam().combined);
        batch.setColor(Color.WHITE);
        batch.draw(logo.draw()
                        .getKeyFrame(dt, true)
                , logo.getX(), logo.getY());
        batch.end();
    }

    @Override
    public void update(){
        getGameCam().update();
        table.setFillParent(true);
    }
}