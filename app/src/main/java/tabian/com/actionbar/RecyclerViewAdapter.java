package tabian.com.actionbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    private List<Book> mData = new ArrayList<>();
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RecyclerViewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.not_returned_listitem, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;*/

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.not_returned_listitem, parent, false);
        return new MyViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book currentBook = mData.get(position);

        holder.book_name.setText(currentBook.getBookname());
        holder.book_author.setText(currentBook.getBookauthor());
        holder.book_cover.setImageBitmap(Helper.getImage(currentBook.getBookcover()));
        holder.delete_button.setImageResource(currentBook.getDelete());
        holder.add_to_returned_button.setImageResource(currentBook.getAddreturned());
        /*holder.add_to_not_returned.setImageResource(mData.get(position).getAddnotreturned());*/

        Glide.with(mContext);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setBookEntries(List<Book> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView book_name;
        private TextView book_author;
        private ImageView book_cover;
        private ImageView delete_button;
        private ImageView add_to_returned_button;
        private ImageView add_to_not_returned;


        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            book_name = itemView.findViewById(R.id.bookname_listview);
            book_author = itemView.findViewById(R.id.bookauthor_listview);
            book_cover = itemView.findViewById(R.id.bookcover_listview);
            delete_button = itemView.findViewById(R.id.delete_button);
            /*add_to_not_returned = itemView.findViewById(R.id.);*/
            add_to_returned_button = itemView.findViewById(R.id.add_to_returned_button);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }

                }
            });
        }
    }


}
