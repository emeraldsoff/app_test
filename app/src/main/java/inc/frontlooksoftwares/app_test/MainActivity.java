package inc.frontlooksoftwares.app_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends Activity {

    String app_userid;
    FirebaseAuth.AuthStateListener mAuthlistener;
    FirebaseAuth mAuth;
    RecyclerView recycleview;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String collection=app_userid+"/DATAKEEPER";
    private CollectionReference colref = db.collection(collection+"/client_basic_data");
    private Noteadapter adapter;
    //    com.google.firebase.database.Query querypic = databaseList()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecycleview();
    }
    private void setUpRecycleview() {
        mAuth = FirebaseAuth.getInstance();
        mAuthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    String userid = mAuth.getUid();
                    adapter.startListening();
                    Toast.makeText(MainActivity.this, "Welcome "+userid, Toast.LENGTH_LONG).show();
                } else {
                    startActivity(new Intent(MainActivity.this, loginactivity.class));
                }
            }
        };
        //add listener
        mAuth.addAuthStateListener(mAuthlistener);
        app_userid=mAuth.getUid();
        String collection=app_userid+"/DATAKEEPER";
        CollectionReference colref = db.collection(collection+"/client_basic_data");
        try{
            Query query = colref.orderBy("id",Query.Direction.ASCENDING);

            FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                    .setQuery(query, Note.class)
                    .build();
            adapter = new Noteadapter(options);
            recycleview=findViewById(R.id.recycle_view);
            recycleview.setHasFixedSize(true);
            recycleview.setLayoutManager(new LinearLayoutManager(this));
            recycleview.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        mAuth = FirebaseAuth.getInstance();
//        int SPLASH_DISPLAY_LENGTH = 0;
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                Logger.d("Start splash screen");
//
//            }
//        }, SPLASH_DISPLAY_LENGTH);
//    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}
