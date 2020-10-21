package in.techrebounce.movielibrary.api;

import in.techrebounce.movielibrary.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDbClient {

    @GET("movie/top_rated")
    Call<MoviesResponse> getMovieList(@Query("api_key") String api_key);

}

