package in.techrebounce.movielibrary.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.techrebounce.movielibrary.MainActivity;
import in.techrebounce.movielibrary.R;
import in.techrebounce.movielibrary.model.Result;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private MainActivity mainActivity;
    private LayoutInflater inflater;
    private List<Result> results;

    public RecyclerAdapter(MainActivity mainActivity, List<Result> results) {
        this.mainActivity = mainActivity;
        this.inflater = LayoutInflater.from(mainActivity);
        this.results = results;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Result movieDetails = results.get(position);

        holder.textViewTitle.setText(movieDetails.getTitle());
        holder.textViewDate.setText(mainActivity.getResources().getString(R.string.date) + " " + movieDetails.getRelease_date());
        holder.textViewLanguage.setText(mainActivity.getResources().getString(R.string.language) + " " + movieDetails.getOriginal_language());
        holder.textViewPopularity.setText(mainActivity.getResources().getString(R.string.popularity) + " " + movieDetails.getPopularity());
        holder.textViewDescription.setText(movieDetails.getDescription());

        String movieImageUrl = "https://image.tmdb.org/t/p/original" + movieDetails.getMoviePoster();

        Picasso.get().load(movieImageUrl).into(holder.imageViewposter);

    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
