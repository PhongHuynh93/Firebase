package dhbk.android.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private EditText editText;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.testFBTextView);
        editText = (EditText) findViewById(R.id.testFBEditText);
        buttonSave = (Button) findViewById(R.id.button);

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

        // case 1
        // tao child branch + value
        myFirebaseRef.child("message").setValue("you'll love firebases");

        // case 2, tao object de luu
        KhoaHoc alan = new KhoaHoc("Khoa Pham", 1988);
        myFirebaseRef.child("case 2").setValue(alan);

        // case 3, tao hashmap de luu -> tiện hơn
        Map<String, Integer> alanisawesomeMap = new HashMap<String, Integer>();
        alanisawesomeMap.put("Phong", 1993);
        alanisawesomeMap.put("Dao", 1996);
        myFirebaseRef.child("case 3").setValue(alanisawesomeMap);

    }
}
