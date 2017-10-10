package example.com.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by FamilyPC on 10/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncNonEmptyResultTest {

    @Mock
    JokeCompleteListener jokeCompleteListener;

    @Before
    public void initMocks() {
        //This will initialize the annotated mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  shouldNotBeNull() throws Exception {
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(jokeCompleteListener);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}

