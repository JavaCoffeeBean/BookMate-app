package tabian.com.actionbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sqliteStuff.BookViewModel;


public class ScanResult extends AppCompatActivity {
    public static final String EXTRA_TITLE = "tabian.com.actionbar.EXTRA_TITLE";
    public static final String EXTRA_AUTHOR = "tabian.com.actionbar.EXTRA_AUTHOR";
    public static final String EXTRA_COVER = "tabian.com.actionbar.EXTRA_COVER";
    public static final String EXTRA_PRIORITY = "tabian.com.actionbar.EXTRA_PRIORITY";


    private BookViewModel bookViewModel;
    private Tab1Fragment tab1Fragment;
    private Button add_returned;
    private Button add_not_returned;
    private TextView book_title;
    private TextView book_author;
    private String cover_art;
    private ImageView book_cover;
    private RequestQueue mQueue;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);
        book_title = findViewById(R.id.book_title);
        book_author = findViewById(R.id.author);
        book_cover = findViewById(R.id.book_Cover);
        add_returned = findViewById(R.id.addy);
        add_not_returned = findViewById(R.id.addNotReturned);


        mQueue = Volley.newRequestQueue(this);


        jsonParse();








    }



 /*   public void addBook() {
        int position;
        position = 0;
        Tab1Fragment tab1Fragment = new Tab1Fragment();

        tab1Fragment.lstBook.add(position, new Book("Richard III","Shakespear",R.drawable.test_cover,R.drawable.trash,R.drawable.add_circle_red));
        tab1Fragment.getRecyclerViewAdapter().notifyItemInserted(position);

    }*/

    public void jsonParse() {

        Intent intent = getIntent();
        String isbn_result = intent.getStringExtra(ScanActivity.SCAN_TEXT);

        String url = "https://www.googleapis.com/books/v1/volumes?q=" + isbn_result + "&key=AIzaSyDG6IF6-n0EDhvSfac4OYNqtU520xQUqzQ";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");





                            /*for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                textViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }*/

                            book_title.setText(jsonArray.getJSONObject(0).getJSONObject("volumeInfo").getString("title"));
                            book_author.setText(jsonArray.getJSONObject(0).getJSONObject("volumeInfo").getJSONArray("authors").getString(0));
                            cover_art = jsonArray.getJSONObject(0).getJSONObject("volumeInfo").getJSONObject("imageLinks").getString("thumbnail");

                            Glide.with(book_cover).load(cover_art).into(book_cover);

                            try {
                                book_title.setText(jsonArray.getJSONObject(0).getJSONObject("volumeInfo").getString("title"));
                            } catch (Exception e) {
                                book_title.setText("Error retrieving book name");
                            }


                            try {
                                Glide.with(book_cover).load(cover_art).into(book_cover);
                            } catch (Exception e) {
                                book_cover.setImageResource(R.drawable.noimage);
                            }

                            try {
                                book_author.setText(jsonArray.getJSONObject(0).getJSONObject("volumeInfo").getJSONArray("authors").getString(0));

                            } catch (Exception e) {
                                book_author.setText("Error retrieving author");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);

        add_returned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote(Tab1Fragment.bookViewModel);




/*
                Tab1Fragment.addBook(book_title.toString(), book_author.toString(), book_cover);
*/

            }
        });


        add_not_returned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote2(Tab2Fragment.bookViewModel2);

            }
        });
    }

    private void saveNote(BookViewModel bv) {
        tab1Fragment = new Tab1Fragment();
        String bookTitle = book_title.getText().toString();
        String bookAuthor = book_author.getText().toString();
        Drawable bookCoverD = book_cover.getDrawable();
        Bitmap bookCoverBtmap = ((BitmapDrawable) bookCoverD).getBitmap();
        byte[] bookCoverByte = Helper.getBytes(bookCoverBtmap);

        int priority = 1;



        Book book = new Book(bookTitle, bookAuthor, bookCoverByte, R.drawable.trash, R.drawable.add_circle_red, priority);
        bv.insert(book);

     /*   for (Book bookEntries : bookViewModel.getAllBooks().getValue()) {
            Log.d(TAG, "$$$$$$CASHINA$$$$$$$");

            tab1Fragment.lstBook.add(new Book(bookEntries.getBookname(), bookEntries.getBookauthor(), (bookEntries.getBookcover()), bookEntries.getDelete(), bookEntries.getAddnotreturned(), bookEntries.getPriority()));
        }

        Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();*/



    }

    private void saveNote2(BookViewModel bv) {
        tab1Fragment = new Tab1Fragment();
        String bookTitle = book_title.getText().toString();
        String bookAuthor = book_author.getText().toString();
        Drawable bookCoverD = book_cover.getDrawable();
        Bitmap bookCoverBtmap = ((BitmapDrawable) bookCoverD).getBitmap();
        byte[] bookCoverByte = Helper.getBytes(bookCoverBtmap);

        int priority = 1;



        Book2 book = new Book2(bookTitle, bookAuthor, bookCoverByte, R.drawable.trash, R.drawable.add_circle, priority);
        bv.insert2(book);

     /*   for (Book bookEntries : bookViewModel.getAllBooks().getValue()) {
            Log.d(TAG, "$$$$$$CASHINA$$$$$$$");

            tab1Fragment.lstBook.add(new Book(bookEntries.getBookname(), bookEntries.getBookauthor(), (bookEntries.getBookcover()), bookEntries.getDelete(), bookEntries.getAddnotreturned(), bookEntries.getPriority()));
        }

        Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();*/



    }

}


