package in.techrebounce.movielibrary.api;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OKHttp_ServiceGenerator {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

//    https://api.themoviedb.org/3/movie/top_rated?api_key=ec733b1a4e49d73aa9cd6b1d41dcc6f6&language=en-US&page=1

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    private static Interceptor interceptor = httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(3000, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build();

    public static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(okHttpClient).build();
        return retrofit.create(serviceClass);
    }

}
