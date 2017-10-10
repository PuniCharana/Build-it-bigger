package com.example;

import java.util.Random;

public class Joke {

    private final String[] jokes;
    private final Random random;

    public Joke() {
        jokes = new String[5];
        jokes[0] = "Mother: \"Did you enjoy your first day at school?\" \n" +
                "Girl: \"First day? Do you mean I have to go back tomorrow?";

        jokes[1] = "Patient: Doctor! You've got to help me! Nobody ever listens to me. No one ever pays any attention to what I have to say.\n" +
                "Doctor: Next please!";

        jokes[2] = "\"I was born in California.\" \n" +
                "\"Which part?\" \n" +
                "\"All of me.\"";

        jokes[3] = "Teacher: Do you have trouble making decisions? \n" +
                "Student: Well...yes and no.";

        jokes[4] = "Teacher: Did your father help your with your homework? \n" +
                "Student: No, he did it all by himself.";

        random = new Random();
    }

    public String getJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
