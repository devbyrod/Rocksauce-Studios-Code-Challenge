package com.rocksaucestudios.rodrigoesquivel_androidcodechallenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.rocksaucestudios.rodrigoesquivel_androidcodechallenge.R;
import com.rocksaucestudios.rodrigoesquivel_androidcodechallenge.models.Post;

import java.util.List;

/**
 * Created by Mandrake on 9/12/16.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    public interface PostsAdapterListener{

        void onItemClick(Post post);
    }

    Context mContext;
    PostsAdapterListener mListener;
    List<Post> mPosts;

    public PostsAdapter(List<Post> posts, PostsAdapterListener listener) {

        mPosts = posts;
        mListener = listener;
    }

    public void clear() {

        mPosts.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Post> posts) {
        mPosts.addAll(posts);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_post_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(mPosts == null || mPosts.isEmpty())
            return;

        final Post post = mPosts.get( position );

        if(!"".equals(post.getThumbnail())) {

            Ion.with(holder.imgAuthor).load(post.getThumbnail());
        }

        holder.txtAuthor.setText(post.getAuthor());
        holder.txtTitle.setText(post.getTitle());
        holder.txtComments.setText(post.getNumberOfComments() + " Comments");
        holder.txtUps.setText(post.getUps() + " Ups");
        holder.txtDowns.setText(post.getDowns() + " Downs");
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mListener != null) {

                    mListener.onItemClick(post);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPosts == null ? 0 : mPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        final View view;
        final ImageView imgAuthor;
        final TextView txtAuthor;
        final TextView txtTitle;
        final TextView txtComments;
        final TextView txtUps;
        final TextView txtDowns;

        public ViewHolder(View itemView) {

            super(itemView);
            view = itemView;
            imgAuthor = (ImageView) itemView.findViewById(R.id.imgAuthor);
            txtAuthor = (TextView) itemView.findViewById(R.id.txtAuthor);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtComments = (TextView) itemView.findViewById(R.id.txtComments);
            txtDowns = (TextView) itemView.findViewById(R.id.txtDowns);
            txtUps = (TextView) itemView.findViewById(R.id.txtUps);
        }
    }
}
