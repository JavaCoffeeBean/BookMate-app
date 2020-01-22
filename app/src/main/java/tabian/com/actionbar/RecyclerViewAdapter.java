package tabian.com.actionbar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Book> mData;

    public RecyclerViewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.not_returned_listitem, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.book_name.setText(mData.get(position).getBookname());
        holder.book_author.setText(mData.get(position).getBookauthor());
        holder.book_cover.setImageDrawable(mData.get(position).getBookcover().getDrawable());
        holder.delete_button.setImageResource(mData.get(position).getDelete());
        holder.add_to_returned_button.setImageResource(mData.get(position).getAddreturned());
        /*holder.add_to_not_returned.setImageResource(mData.get(position).getAddnotreturned());*/

        Glide.with(mContext)


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView book_name;
        private TextView book_author;
        private ImageView book_cover;
        private ImageView delete_button;
        private ImageView add_to_returned_button;
        private ImageView add_to_not_returned;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            book_name = itemView.findViewById(R.id.bookname_listview);
            book_author = itemView.findViewById(R.id.bookauthor_listview);
            book_cover = itemView.findViewById(R.id.bookcover_listview);
            delete_button = itemView.findViewById(R.id.delete_button);
            /*add_to_not_returned = itemView.findViewById(R.id.);*/
            add_to_returned_button = itemView.findViewById(R.id.add_to_returned_button);
        }
    }


}
