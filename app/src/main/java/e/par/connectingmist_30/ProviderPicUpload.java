package e.par.connectingmist_30;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class ProviderPicUpload extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    private Button btchoose,btup;
    private static final int PICK_IMAGE_REQUEST=1234;

    private FirebaseAuth mAuth;

    private StorageReference storageReference;
    private DatabaseReference mDatabaseRef;



    private TextView showup,seeList;
    String test,id;


    private Uri filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_pic_upload);
      //  test=getIntent().getStringExtra("EXTRA_SESSION_ID");

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser usr =mAuth.getCurrentUser();

        storageReference = FirebaseStorage.getInstance().getReference("Profilepic");
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("Profilepic");

        imageView=findViewById(R.id.imageView);

        btchoose=findViewById(R.id.bt1);
        btup=findViewById(R.id.bt2);

        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String userid=user.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users");
        ref.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserInfo user = dataSnapshot.getValue(UserInfo.class);
                id =user.getRoll();

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btchoose.setOnClickListener(this);
        btup.setOnClickListener(this);

    }

    private void showfileChooser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data != null && data.getData()!=null){
            filePath= data.getData();
            Picasso.get().load(filePath).into(imageView);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR=getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadfile(){

        if(filePath!=null) {

            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            //StorageReference riversRef = storageReference.child(System.currentTimeMillis()
                   // + "."+getFileExtension(filePath));


            StorageReference riversRef = storageReference.child(id);

            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();

                            Toast.makeText(ProviderPicUpload.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                            Upload upload=new Upload(taskSnapshot.getDownloadUrl().toString());


                            mDatabaseRef.child(id).setValue(upload);

                            Intent i = new Intent(ProviderPicUpload.this,MyprofileActivity.class);
                            startActivity(i);

                            //   mDatabaseRef.child(mAuth.getCurrentUser().getUid())
                            //      .child("Pictures").setValue(upload);
                            // .setValue(upload);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            progressDialog.dismiss();
                            Toast.makeText(ProviderPicUpload.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress =(100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage((int) progress + "% Uploaded...");
                        }
                    });


        }
        else{
            Toast.makeText(this, "No file Selected", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View view) {
        if(view==btchoose){
            showfileChooser();
        }
        else if(view==btup){
            uploadfile();

        }

    }
}

