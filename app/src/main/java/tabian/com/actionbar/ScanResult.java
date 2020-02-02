package tabian.com.actionbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.List;

import sqliteStuff.BookEntry;
import sqliteStuff.BookViewModel;


public class ScanResult extends AppCompatActivity {
    public static final String EXTRA_TITLE = "com.example.ffffff";
    public static final String EXTRA_AUTHOR = "com.example.ffffff";
    public static final String EXTRA_COVER = "com.example.ffffff";
    public static final String EXTRA_PRIORITY = "com.example.ffffff";

    private BookViewModel bookViewModel;

    private TextView book_title;
    private TextView book_author;
    private String cover_art;
    private ImageView book_cover;
    private RequestQueue mQueue;
    private Button add_returned;
    private Button add_not_returned;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);
        book_title = findViewById(R.id.book_title);
        book_author = findViewById(R.id.author);
        book_cover = findViewById(R.id.book_Cover);
        add_returned = findViewById(R.id.returned_BUTTON);
        add_not_returned = findViewById(R.id.not_returned_BUTTON);

        mQueue = Volley.newRequestQueue(this);


        jsonParse();

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        bookViewModel.getAllBooks().observe(this, new Observer<List<BookEntry>>() {

            @Override
            public void onChanged(@Nullable List<BookEntry> notes) {
                //update RecyclerView
                Toast.makeText(ScanResult.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });


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

                Tab1Fragment.addBook(book_title.toString(), book_author.toString(), book_cover);

            }
        });
    }

    private void saveNote() {
        String bookTitle = book_title.getText().toString();
        String bookAuthor = book_author.getText().toString();
        Drawable bookCoverD = book_cover.getDrawable();
        Bitmap bookCoverBtmap = ((BitmapDrawable) bookCoverD).getBitmap();
        byte[] bookCoverByte = Helper.getBytes(bookCoverBtmap);

        int priority = 9;


        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, bookTitle);
        data.putExtra(EXTRA_AUTHOR, bookAuthor);
        data.putExtra(EXTRA_COVER, bookCoverByte);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();


    }
}




