package in.techrebounce.movielibrary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {


    private String title;
    private String release_date;
    private String original_language;
    private String popularity;


    @SerializedName("overview")
    @Expose
    private String description;

    @SerializedName("poster_path")
    @Expose
    private String moviePoster;


    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getDescription() {
        return description;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

}

/*

private TextView textViewTitle, textViewDate, textViewLanguage, textViewPopularity, textViewDescription;
    private ImageView imageViewposter;

"popularity":13.779,
         "vote_count":867,
         "video":false,
         "poster_path":"\/pci1ArYW7oJ2eyTo2NMYEKHHiCP.jpg",
         "id":724089,
         "adult":false,
         "backdrop_path":"\/jtAI6OJIWLWiRItNSZoWjrsUtmi.jpg",
         "original_language":"en",
         "original_title":"Gabriel's Inferno Part II",
         "genre_ids":[
            10749
         ],
         "title":"Gabriel's Inferno Part II",
         "vote_average":9,
         "overview":"Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?",
         "release_date":"2020-07-31"

**/
