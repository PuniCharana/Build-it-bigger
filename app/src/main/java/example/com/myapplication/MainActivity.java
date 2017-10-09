package example.com.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment,new MainActivityFragment()).commit();
    }

    @SuppressWarnings("unchecked")
    public void tellJoke(View view) {
        Toast.makeText(this, "lol", Toast.LENGTH_SHORT).show();

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }
}
