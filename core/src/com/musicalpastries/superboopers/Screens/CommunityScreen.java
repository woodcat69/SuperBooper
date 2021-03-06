package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 12/27/2017.
 */

public class CommunityScreen extends SuperScreen {

    public CommunityScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);

        r= .7f;
        g= .0f;
        b= .3f;
    }

    @Override
    public void show() {
        super.show();

        //buttons
        Label title = new Label("Community", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        title.setFontScale(2.25f);

        table.add(title).expandX().fillX();

        table.row();
        //listeners

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(lastScreen, SuperBoopers.eScreen.COMMUNITY);}
        });
    }

    @Override
    void renderBatch() {}

    @Override
    public void update() {}
}

