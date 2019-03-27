package com.codepath.apps.restclienttemplate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.content.*;
import java.util.*;
import com.bumptech.glide.*;

import com.codepath.apps.restclienttemplate.models.Tweet;
public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {


    private Context context;
    private List<Tweet> tweets;

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.tvBody.setText(tweet.body);
        holder.tvScreenName.setText(tweet.user.screenName);
        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.ivProfileImage);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;

        public ViewHolder(View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileimage);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvBody = itemView.findViewById(R.id.tvBody);

        }
    }


}
