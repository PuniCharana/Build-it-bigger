package example.com.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.familypc.myapplication.backend.jokeApi.JokeApi;
import com.example.familypc.myapplication.backend.jokeApi.model.JokeBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by FamilyPC on 10/9/2017.
 */

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private JokeApi jokeApiService = null;
    private final JokeCompleteListener mJokeCompleteListener;

    public EndpointsAsyncTask(JokeCompleteListener jokeCompleteListener) {
        mJokeCompleteListener = jokeCompleteListener;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (jokeApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            jokeApiService = builder.build();
        }

        try {
            return jokeApiService.putJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mJokeCompleteListener.onComplete(result);
    }
}