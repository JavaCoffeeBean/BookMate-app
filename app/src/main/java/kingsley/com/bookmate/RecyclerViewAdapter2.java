package kingsley.com.bookmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder> {

    Context mContext;
    List<Book2> mData2;
    private OnItemClickListener mListener;

    public RecyclerViewAdapter2(Context mContext, List<Book2> mData) {
        this.mContext = mContext;
        this.mData2 = mData;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(RecyclerViewAdapter2.OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.returned_listitem, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v, mListener);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Book2 currentBook2 = mData2.get(position);

        holder.book_name.setText(currentBook2.getBookname());
        holder.book_author.setText(currentBook2.getBookauthor());
        holder.book_cover.setImageBitmap(Helper.getImage(currentBook2.getBookcover()));
        holder.delete_button.setImageResource(currentBook2.getDelete());
       /* holder.add_to_returned_button.setImageResource(mData2.get(position).getAddnotreturned());*/
        holder.add_to_not_returned.setImageResource(currentBook2.getAddnotreturned());


       

    }

    @Override
    public int getItemCount() {
        return mData2.size();
    }

    public void setBookEntries2(List<Book2> mData) {
        this.mData2 = mData;
        notifyDataSetChanged();
    }

    public Book2 getBookAt(int position){
        return mData2.get(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView book_name;
        private TextView book_author;
        private ImageView book_cover;
        private ImageView delete_button;
        private ImageView add_to_returned_button;
        private ImageView add_to_not_returned;


        public MyViewHolder(@NonNull View itemView, final RecyclerViewAdapter2.OnItemClickListener listener) {
            super(itemView);

            book_name = itemView.findViewById(R.id.bookname_listview2);
            book_author = itemView.findViewById(R.id.bookauthor_listview2);
            book_cover = itemView.findViewById(R.id.bookcover_listview2);
            delete_button = itemView.findViewById(R.id.delete_button2);
            /*add_to_not_returned = itemView.findViewById(R.id.);*/
            add_to_not_returned = itemView.findViewById(R.id.add_to_notreturned_button2);


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

            delete_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);

                        }
                    }



                }
            });
        }
    }


}
