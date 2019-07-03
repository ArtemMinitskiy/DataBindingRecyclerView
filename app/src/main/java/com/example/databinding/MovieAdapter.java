package com.example.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding.databinding.MovieItemBinding;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieItemViewHolder> {
    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MovieItemBinding binding = MovieItemBinding.inflate(inflater, parent, false);
        return new MovieItemViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder holder, int position) {
        Movie movie = Movie.ITEMS[position];
        holder.binding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return Movie.ITEMS.length;
    }

    public class MovieItemViewHolder extends RecyclerView.ViewHolder {
        MovieItemBinding binding;

        public MovieItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

}
