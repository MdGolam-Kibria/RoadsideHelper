package com.example.myapplication;


import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.admin.UserProbPojo.OurretrofitForUserPb;
import com.example.myapplication.admin.UserProbPojo.PbPojo;
import com.example.myapplication.probImageAndPbView.ShowPbImage;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserDescription extends Fragment {
    ImageButton imageButton;
    Bitmap photo;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button submit, show;
    EditText userPb;
    private Uri imageUri;
    static final int REQUEST_IMAGE_CAPTURE_gallery = 1;
    public UserDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_description, container, false);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null).commit();
        userPb = view.findViewById(R.id.userPb);
        imageButton = view.findViewById(R.id.camera);
        show = view.findViewById(R.id.show);
        submit = view.findViewById(R.id.submit);
        view.findViewById(R.id.gallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "wow", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE_gallery);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userProblems = userPb.getText().toString();
                if (userProblems.isEmpty()) {
                    userPb.setError("please submit about your problem");
                    userPb.requestFocus();
                    return;
                }

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
//                pbPojo.setProblemImage(byteArray);
//                pbPojo.setProblemDescription(userProblems);


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BaseUrl.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                OurretrofitForUserPb ourretrofitForUserPb = retrofit.create(OurretrofitForUserPb.class);
                PbPojo pbPojo = new PbPojo(byteArray, userProblems);
                Call<PbPojo> modelCall = ourretrofitForUserPb.postData(pbPojo);
                modelCall.enqueue(new Callback<PbPojo>() {
                    @Override
                    public void onResponse(Call<PbPojo> call, Response<PbPojo> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getContext(), "wow response", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "field to sed problems to your database", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PbPojo> call, Throwable t) {

                    }
                });


            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ShowPbImage.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        });
        return view;
    }

    public String getFileExtention(Uri imageUri) {
        ContentResolver contentResolver = getContext().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE_gallery) {

            imageUri = data.getData();
            Picasso.with(getContext()).load(imageUri).into(imageButton);
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            photo = (Bitmap) data.getExtras().get("data");

            imageButton.setImageBitmap(photo);
        }
    }


}
