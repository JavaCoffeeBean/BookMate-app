package tabian.com.actionbar;

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

    public RecyclerViewAdapter2(Context mContext, List<Book2> mData) {
        this.mContext = mContext;
        this.mData2 = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.returned_listitem, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.book_name.setText(mData2.get(position).getBookname());
        holder.book_author.setText(mData2.get(position).getBookauthor());
        holder.book_cover.setImageResource(mData2.get(position).getBookcover());
        holder.delete_button.setImageResource(mData2.get(position).getDelete());
       /* holder.add_to_returned_button.setImageResource(mData2.get(position).getAddnotreturned());*/
        holder.add_to_not_returned.setImageResource(mData2.get(position).getAddnotreturned());


       

    }

    @Override
    public int getItemCount() {
        return mData2.size();
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

            book_name = itemView.findViewById(R.id.bookname_listview2);
            book_author = itemView.findViewById(R.id.bookauthor_listview2);
            book_cover = itemView.findViewById(R.id.bookcover_listview2);
            delete_button = itemView.findViewById(R.id.delete_button2);
            /*add_to_not_returned = itemView.findViewById(R.id.);*/
            add_to_not_returned = itemView.findViewById(R.id.add_to_notreturned_button2);
        }
    }


}
