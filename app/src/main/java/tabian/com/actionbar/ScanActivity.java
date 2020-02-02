package tabian.com.actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import sqliteStuff.BookEntry;


public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    private TextView txtResult;
    public static final int ADD_NOTE_REQUEST =1;
    public static final String SCAN_TEXT = "tabian.com.actionbar";
    private static final String TAG = "MainActivity";

    private TextView book_title;
    private TextView book_author;
    private ImageView book_cover;

    ScanResult scanResult = new ScanResult();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        //init
        scannerView = (ZXingScannerView) findViewById(R.id.zxscan);
        txtResult = (TextView) findViewById(R.id.txt_result);

        scannerView.setResultHandler(ScanActivity.this);
        scannerView.startCamera();
    }

    @Override
    protected void onDestroy() {
        scannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
        //Here we can receive raw result
        String scann = rawResult.toString();

        txtResult.setText(rawResult.getText());



        Intent intent = new Intent(this, ScanResult.class );
        intent.putExtra(SCAN_TEXT, scann);
        startActivityForResult(intent, ADD_NOTE_REQUEST );


        /*scannerView.startCamera();*/



    }

    @Override
    protected void onResume() {
        super.onResume();

        scannerView = (ZXingScannerView) findViewById(R.id.zxscan);
        txtResult = (TextView) findViewById(R.id.txt_result);

        scannerView.setResultHandler(ScanActivity.this);
        scannerView.startCamera();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(ScanResult.EXTRA_TITLE);
            String author = data.getStringExtra(ScanResult.EXTRA_AUTHOR);
            String cover = data.getStringExtra(ScanResult.EXTRA_COVER;)
            int priority = data.getIntExtra(ScanResult.EXTRA_PRIORITY, 1);

            BookEntry bookEntry = new BookEntry(title, author, ,priority);
            noteViewModel.insert(note);

            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show();
        }
    }
}
