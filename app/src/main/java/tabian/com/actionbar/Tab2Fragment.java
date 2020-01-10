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


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    View v2;
    private RecyclerView mynotreturned_recyclerview;
    private List<Book2> lstBook2;

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment1_layout,container,false);

        mynotreturned_recyclerview = view2.findViewById(R.id.notReturned_recyclerview);
        RecyclerViewAdapter2 recyclerViewAdapter2 = new RecyclerViewAdapter2(getContext(), lstBook2);
        mynotreturned_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mynotreturned_recyclerview.setAdapter(recyclerViewAdapter2);


        return view2;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstBook2 = new ArrayList<>();
        lstBook2.add(new Book2("Their Eyes Were Watching God","Zora Hurston",R.drawable.tewwg,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("Goosebumps","R.L. Stine",R.drawable.g,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("Z For Zachariah","Robert",R.drawable.zfz,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("When Things Fall Apart","Chinua Achebe",R.drawable.wtfa,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("nef","George Orwell",R.drawable.nef,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("Julius Cesar","Shakespear",R.drawable.jc,R.drawable.trash,R.drawable.add_circle));

        lstBook2.add(new Book2("Their Eyes Were Watching God","Zora Hurston",R.drawable.tewwg,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("Goosebumps","R.L. Stine",R.drawable.g,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("Z For Zachariah","Robert",R.drawable.zfz,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("When Things Fall Apart","Chinua Achebe",R.drawable.wtfa,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("nef","George Orwell",R.drawable.nef,R.drawable.trash,R.drawable.add_circle));
        lstBook2.add(new Book2("Julius Cesar","Shakespear",R.drawable.jc,R.drawable.trash,R.drawable.add_circle));

    }
}
