package tabian.com.actionbar;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import sqliteStuff.BookViewModel;


public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private static final String TAG = "MainActivity";

    public static final int ADD_BOOK_REQUEST = 1;

    private BookViewModel bookViewModel;
    private ScanActivity scanActivity = new ScanActivity();



    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    private TabLayout tabLayout;
    private  ViewPager viewPager;
    private TabItem tab1, tab2;
    private FrameLayout homeContainer;
    public PageAdapter pagerAdapter;
    private Fragment newss;
    private ImageView addBook;
    private ZXingScannerView scannerView;
    private TextView txtResult;
    static Context mainContext;
    static Intent mainIntent;


//    private static final String TAG = "MainActivity";

    private ArrayList<String> mBookNames = new ArrayList<>();
    private ArrayList<String> mBookAuthors = new ArrayList<>();
    private ArrayList<String> mBookImages = new ArrayList<>();
    private ArrayList<ImageView> DeleteButtons = new ArrayList<>();
    private ArrayList<ImageView> AddToReturnedButtons = new ArrayList<>();

    private ArrayList<String> mBookNames2 = new ArrayList<>();
    private ArrayList<String> mBookAuthors2 = new ArrayList<>();
    private ArrayList<String> mBookImages2 = new ArrayList<>();
    private ArrayList<ImageView> DeleteButtons2 = new ArrayList<>();
    private ArrayList<ImageView> AddToReturnedButtons2 = new ArrayList<>();

    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        tabLayout.getTabAt(0).setText("Returned");
        tabLayout.getTabAt(1).setText("Not-Returned");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        tabsFunctionality();

                        break;

                    case R.id.ic_reminders:
                        Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_settings:
                        Intent intent2 = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                }


                return false;
            }
        });
        addBook = findViewById(R.id.add_Book);
        scannerView = (ZXingScannerView) findViewById(R.id.zxscan);
        txtResult = (TextView) findViewById(R.id.txt_result);



        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openCamera();
            }
        });



            }

    @AfterPermissionGranted(123)
    private void openCamera() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.INTERNET};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Toast.makeText(this, "Opening camera", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, ScanActivity.class );
            startActivity(intent);
        } else {
            EasyPermissions.requestPermissions(this, "We need permissions in order to access camera functionalities",
                    123, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {

        }


    }



            public void openScannerActivity(){


                Intent intent = new Intent(this, ScanActivity.class );
                startActivity(intent);
            }










    //you have left the onCreate method
    
    



    public void tabsFunctionality() {

        Log.d(TAG, "tabsFunctionality: engaged");

        final LayoutInflater inflater2 = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater2.inflate(R.layout.activity_main,  null);




        tabLayout =  view.findViewById(R.id.tabs);
        /*tab1 =  view.findViewById(R.id.returned_Tab);
        tab2 =  view.findViewById(R.id.not_returned_Tab);*/
        viewPager =  view.findViewById(R.id.container);






        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();



                    Log.d(TAG, "onTabSelected: iq10000000! wow!");
                    Log.e(TAG, "onTabSelected: uy7uhui");





                } else if (tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                    initImageBitmaps2();
//                    initRecyclerView2();

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
//        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");





//        mImageUrls.add(/*place image url here that you got from api*/);
//        mNames.add(/*place rerecipe name here*/);


//        Example

        mBookImages.add("https://images-na.ssl-images-amazon.com/images/I/51M%2BMu05lCL._SX343_BO1,204,203,200_.jpg");
        mBookNames.add("Their Eyes Were Watching God");
        mBookAuthors.add("Zora Hurston");

        mBookImages.add("https://images-na.ssl-images-amazon.com/images/I/51rqbjzojiL._SX356_BO1,204,203,200_.jpg");
        mBookNames.add("Z for Zachariah");
        mBookAuthors.add("Robert C. O'brien");

        mBookImages.add("https://img.buzzfeed.com/buzzfeed-static/static/2013-10/enhanced/webdr01/10/10/enhanced-buzz-24944-1381414376-1.jpg?downsize=700:*&output-format=auto&output-quality=auto");
        mBookNames.add("Goosebumbs");
        mBookAuthors.add("RL Stein");

        mBookImages.add("https://images-na.ssl-images-amazon.com/images/I/511FGQPR30L._SX302_BO1,204,203,200_.jpg");
        mBookNames.add("When Things Fall Apart");
        mBookAuthors.add("Chinua Achebe");

        mBookImages.add("http://cdn.shopify.com/s/files/1/2697/1746/products/1984-book-cover-art-book-cover-prints-2_1531c558-4ea7-4a8b-95f4-1fa3534f0ee9_1200x1200.jpg?v=1571739186");
        mBookNames.add("nef");
        mBookAuthors.add("George Orwell");

        mBookImages.add("https://prodimage.images-bn.com/pimages/9781610427678_p0_v1_s550x406.jpg");
        mBookNames.add("Julius Cesar");
        mBookAuthors.add("Shakespear");




    }

    private void initImageBitmaps2(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");





//        mImageUrls.add(/*place image url here that you got from api*/);
//        mNames.add(/*place rerecipe name here*/);


//        Example

        mBookImages2.add("https://images-na.ssl-images-amazon.com/images/I/51M%2BMu05lCL._SX343_BO1,204,203,200_.jpg");
        mBookNames2.add("Their Eyes Were Watching God");
        mBookAuthors2.add("Zora Hurston");

        mBookImages2.add("https://images-na.ssl-images-amazon.com/images/I/51rqbjzojiL._SX356_BO1,204,203,200_.jpg");
        mBookNames2.add("Z for Zachariah");
        mBookAuthors2.add("Robert C. O'brien");

        mBookImages2.add("https://img.buzzfeed.com/buzzfeed-static/static/2013-10/enhanced/webdr01/10/10/enhanced-buzz-24944-1381414376-1.jpg?downsize=700:*&output-format=auto&output-quality=auto");
        mBookNames2.add("Goosebumbs");
        mBookAuthors2.add("RL Stein");

        mBookImages2.add("https://images-na.ssl-images-amazon.com/images/I/511FGQPR30L._SX302_BO1,204,203,200_.jpg");
        mBookNames2.add("When Things Fall Apart");
        mBookAuthors2.add("Chinua Achebe");

        mBookImages2.add("http://cdn.shopify.com/s/files/1/2697/1746/products/1984-book-cover-art-book-cover-prints-2_1531c558-4ea7-4a8b-95f4-1fa3534f0ee9_1200x1200.jpg?v=1571739186");
        mBookNames2.add("nef");
        mBookAuthors2.add("George Orwell");

        mBookImages2.add("https://prodimage.images-bn.com/pimages/9781610427678_p0_v1_s550x406.jpg");
        mBookNames2.add("Julius Cesar");
        mBookAuthors2.add("Shakespear");

    }


    protected void onStart(){
        super.onStart();

        Log.d(TAG, "onStart: this method started");

        /*initRecyclerView2();*/
    }







    /*  @Override
    protected void onDestroy() {
        scannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
        //Here we can receive raw result
        txtResult.setText(rawResult.getText());
        scannerView.startCamera();
    }*/

    /*public void addBooks(View view) {

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                openScannerActivity();

            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Permissions not given", Toast.LENGTH_SHORT);

            }
        };

        TedPermission.with(MainActivity.this)
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.CAMERA)
                .check();

    }
*/

    /*public void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.fragment1_layout, null);



        RecyclerView recyclerView = view1.findViewById(R.id.notReturned_recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,  mBookNames, mBookImages, DeleteButtons, AddToReturnedButtons, mBookAuthors);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }*/

    /*public void initRecyclerView2(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view2 = inflater.inflate(R.layout.fragment_tab2, null);

        RecyclerView recyclerView2 = view2.findViewById(R.id.returned_recyclerview2);
        ReturnedAdapter adapter2 = new ReturnedAdapter(this,  mBookNames2, mBookImages2, DeleteButtons2, AddToReturnedButtons2, mBookAuthors2);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }*/

}
