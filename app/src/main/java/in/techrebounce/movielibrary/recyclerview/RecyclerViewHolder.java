package in.techrebounce.movielibrary.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.techrebounce.movielibrary.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewTitle, textViewDate, textViewLanguage, textViewPopularity, textViewDescription;
    public ImageView imageViewposter;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
        textViewTitle = (TextView) itemView.findViewById(R.id.textViewMovieTitle);
        textViewLanguage = (TextView) itemView.findViewById(R.id.textViewLanguage);
        textViewPopularity = (TextView) itemView.findViewById(R.id.textViewPopularity);
        textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);

        imageViewposter = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
