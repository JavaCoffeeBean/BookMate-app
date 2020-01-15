package tabian.com.actionbar;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    View v;
    private RecyclerView myreturned_recyclerview;
    private List<Book> lstBook;

    public Tab1Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        myreturned_recyclerview = view.findViewById(R.id.returned_recyclerview2);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstBook);
        myreturned_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreturned_recyclerview.setAdapter(recyclerViewAdapter);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("Their Eyes Were Watching God","Zora Hurston",R.drawable.tewwg,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("Goosebumps","R.L. Stine",R.drawable.g,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("Z For Zachariah","Robert",R.drawable.zfz,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("When Things Fall Apart","Chinua Achebe",R.drawable.wtfa,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("nef","George Orwell",R.drawable.nef,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("Julius Cesar","Shakespear",R.drawable.jc,R.drawable.trash,R.drawable.add_circle_red));

        lstBook.add(new Book("Their Eyes Were Watching God","Zora Hurston",R.drawable.tewwg,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("Goosebumps","R.L. Stine",R.drawable.g,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("Z For Zachariah","Robert",R.drawable.zfz,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("When Things Fall Apart","Chinua Achebe",R.drawable.wtfa,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("nef","George Orwell",R.drawable.nef,R.drawable.trash,R.drawable.add_circle_red));
        lstBook.add(new Book("Julius Cesar","Shakespear",R.drawable.jc,R.drawable.trash,R.drawable.add_circle_red));

    }

    public List<Book> getLstBook() {
        return lstBook;
    }
}