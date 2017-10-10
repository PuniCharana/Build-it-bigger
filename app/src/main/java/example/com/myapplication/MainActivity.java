package example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.androidjokelib.DisplayJokeActivity;

public class MainActivity extends AppCompatActivity implements JokeCompleteListener {

    @BindView(R2.id.progressbar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment,new MainActivityFragment()).commit();
    }

    @SuppressWarnings("unchecked")
    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onComplete(String joke) {
        progressBar.setVisibility(View.GONE);

        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.KEY_JOKE, joke);
        startActivity(intent);
    }

    @Override
    public void onError(String error) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Failed to load joke. Please try again.", Toast.LENGTH_SHORT).show();
    }
}
