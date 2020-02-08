package tabian.com.actionbar;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sqliteStuff.BookViewModel;


public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";
    public static final int ADD_BOOK_REQUEST = 1;
    BookViewModel bookViewModel;

    View v;
    private RecyclerView myreturned_recyclerview;
    static List<Book> lstBook;
    static RecyclerViewAdapter recyclerViewAdapter;

    public Tab1Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        myreturned_recyclerview = view.findViewById(R.id.returned_recyclerview2);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstBook);
        myreturned_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreturned_recyclerview.setAdapter(recyclerViewAdapter);


        myreturned_recyclerview.setAdapter(recyclerViewAdapter);

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        bookViewModel.getAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> bookEntries) {
                recyclerViewAdapter.setBookEntries(bookEntries);
            }
        });


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstBook = new ArrayList<>();
        /*lstBook.add(new Book("Their Eyes Were Watching God","Zora Hurston",R.drawable.tewwg,R.drawable.trash,R.drawable.add_circle_red));
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
*/
    }

     static void addBook(String bookname, String bookauthor, ImageView bookcover) {
        int position;
        position = 0;

        lstBook.add(position, new Book(bookname,bookauthor,bookcover,R.drawable.trash,R.drawable.add_circle_red));
        recyclerViewAdapter.notifyItemInserted(position);

    }



}