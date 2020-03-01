package tabian.com.actionbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private ScanActivity scanActivity;

    View v;
    private RecyclerView myreturned_recyclerview;
    static List<Book> lstBook;
    static BookViewModel bookViewModel;
    RecyclerViewAdapter.MyViewHolder myViewHolder;


    public Tab1Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        scanActivity = new ScanActivity();

        myreturned_recyclerview = view.findViewById(R.id.returned_recyclerview2);
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstBook);
        myreturned_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreturned_recyclerview.setAdapter(recyclerViewAdapter);



        bookViewModel = ViewModelProviders.of(getActivity()).get(BookViewModel.class);
        bookViewModel.getAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> bookEntries) {
                recyclerViewAdapter.setBookEntries(bookEntries);
            }
        });

        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent activity2Intent = new Intent(getActivity(), BookInformationActivity.class);
                startActivity(activity2Intent);
            }

            @Override
            public void onDeleteClick(int position) {
                bookViewModel.delete(recyclerViewAdapter.getBookAt(position));

            }
        });




        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





       /* bookViewModel = ViewModelProviders.of(this.getActivity()).get(BookViewModel.class);
        String p = "nop";
*/
       /* for (ListIterator<Book> iter = bookViewModel.getAllBooks().getValue().listIterator(); iter.hasNext(); ) {
            E element = iter.next();
            // 1 - can call methods of element
            // 2 - can use iter.remove() to remove the current element from the list
            // 3 - can use iter.add(...) to insert a new element into the list
            //     between element and iter->next()
            // 4 - can use iter.set(...) to replace the current element

            // ...
        }*/






        lstBook = new ArrayList<>();

        /*if (bookViewModel.getAllBooks().getValue() != null) {


            for (Book bookEntries : bookViewModel.getAllBooks().getValue()) {

                lstBook.add(new Book(bookEntries.getBookname(), bookEntries.getBookauthor(), bookEntries.getBookcover(), bookEntries.getDelete(), bookEntries.getAddnotreturned(), bookEntries.getPriority()));
            }
        } else {
            return;
        }*/

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



    public static BookViewModel getBookViewModel() {
        return bookViewModel;
    }

    /* static void addBook(String bookname, String bookauthor, ImageView bookcover) {
        int position;
        position = 0;

        lstBook.add(position, new Book(bookname,bookauthor,bookcover,R.drawable.trash,R.drawable.add_circle_red));
        recyclerViewAdapter.notifyItemInserted(position);

    }*/



}