package com.uwechue.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    Context ctx;
    List<Book> bookList;

    public BooksAdapter(Context ctx, List<Book> bookList) {
        this.ctx = ctx;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.recyclerview_layout, parent, false);
        return(new BookViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);

        Glide.with(ctx)
                .load(book.getImageURL())
                .into(holder.imageView);

        holder.textTitle.setText(book.getTitle());
        String auth = book.getAuthor();
        if(auth!=null && !auth.isEmpty())
            holder.textAuthor.setText(ctx.getString(R.string.author_name, auth));
    }

    @Override
    public int getItemCount() {
        return (bookList.size());
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textTitle, textAuthor;

        public BookViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.thumbnail);
            textTitle = itemView.findViewById(R.id.textTitle);
            textAuthor = itemView.findViewById(R.id.textAuthor);
        }
    }
}
