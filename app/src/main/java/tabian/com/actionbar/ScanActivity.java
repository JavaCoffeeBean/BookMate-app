package tabian.com.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


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


}
