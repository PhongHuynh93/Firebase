package dhbk.android.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton;
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        // kết nối đến con (key)
//        final Firebase myFirebaseRef = new Firebase("https://test-fb-phong093.firebaseio.com/khoapham");
        final Firebase myFirebaseRef = new Firebase("https://test-fb-phong093.firebaseio.com");

        // dò xem (value) trong key trên có thay đổi ko
//        myFirebaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                txt.setText(dataSnapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // push to database
//                myFirebaseRef.setValue(editText.getText().toString());
//            }
//        });

        // sua branch
        // case 1
        // dò child branch + value
//        myFirebaseRef.child("message").setValue("you'll love firebases");
//
//        // case 2, tao object de luu
//        KhoaHoc alan = new KhoaHoc("Khoa Pham", 1988);
//        myFirebaseRef.child("case 2").setValue(alan);
//
//        // case 3, tao hashmap de luu -> tiện hơn
//        Map<String, Integer> alanisawesomeMap = new HashMap<String, Integer>();
//        alanisawesomeMap.put("Phong", 1993);
//        alanisawesomeMap.put("Dao", 1996);
//        myFirebaseRef.child("case 3").setValue(alanisawesomeMap);
//
//        // tao branch
//        // case 4, tạo branch + push value
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Firebase postRef = myFirebaseRef.child("case 4");
//                // event save vao database khi nao`?
//                postRef.push().setValue(new KhoaHoc("Khoa Pham", 1988), new Firebase.CompletionListener() {
//                    @Override
//                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
//                        if (firebaseError != null) {
//                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "Successs", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                postRef.push().setValue(new KhoaHoc("Khoa Pham 2", 1989));
//                postRef.push().setValue(new KhoaHoc("Khoa Pham 3", 1920));
//            }
//        });
        anhXa();
        // khi click button, save to database
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String job = mEditText.getText().toString();
                myFirebaseRef.push().setValue(job);
                mEditText.setText(""); // nhap xong thi xoa

            }
        });

        // cau hinh listview
        final ArrayList<String> mang = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mang);
        mListView.setAdapter(adapter);

        // bat su kien khi root add child
        myFirebaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mang.add(dataSnapshot.getValue().toString());
                // cap nhat cho listview
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void anhXa() {
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mListView = (ListView) findViewById(R.id.listView);
    }
}
