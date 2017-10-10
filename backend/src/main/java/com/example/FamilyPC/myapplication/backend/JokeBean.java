package com.example.FamilyPC.myapplication.backend;

import com.example.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean {

    private final Joke mJoke;

    public JokeBean() {
        mJoke = new Joke();
    }

    public String getJoke() {
        return mJoke.getJoke();
    }
}