package in.techrebounce.movielibrary;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import in.techrebounce.movielibrary.api.MovieDbClient;
import in.techrebounce.movielibrary.api.OKHttp_ServiceGenerator;
import in.techrebounce.movielibrary.api.ServiceGenerator;
import in.techrebounce.movielibrary.model.MoviesResponse;
import in.techrebounce.movielibrary.recyclerview.RecyclerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private MovieDbClient movieDbClient;

    private static final String API_KEY = "ec733b1a4e49d73aa9cd6b1d41dcc6f6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

    }

    public void initRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        movieDbClient = ServiceGenerator.getMovies().create(MovieDbClient.class);

        movieDbClient = OKHttp_ServiceGenerator.createService(MovieDbClient.class);

        movieSearch();
    }

    public void movieSearch() {

        //Make a request to get a response
        //Get json object from moviedb server to the POJO/model class

        Call<MoviesResponse> call = movieDbClient.getMovieList(API_KEY);

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {

                MoviesResponse movieModel = response.body();

                if (movieModel != null) {

                    Log.d("tag", "success ");

                    RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MainActivity.this, movieModel.getResults());
                    recyclerView.setAdapter(recyclerAdapter);


                } else {

                    Log.d("tag", "Not found ");
                    Toast.makeText(getApplicationContext(), "Url not found ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

                Log.d("tag", "Error Loading " + t.fillInStackTrace().toString());
            }
        });
    }
}