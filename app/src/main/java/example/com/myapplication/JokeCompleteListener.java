package example.com.myapplication;

/**
 * Created by FamilyPC on 10/10/2017.
 */

public interface JokeCompleteListener {
    void onComplete(String joke);
    void onError(String message);
}
