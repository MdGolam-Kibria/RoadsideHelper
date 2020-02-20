package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.SendDataToMysqlUsingRestAPI.Model;
import com.example.myapplication.SendDataToMysqlUsingRestAPI.OurRetroft;
import com.example.myapplication.serviceProviderCheck.ServicePojo;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SignupBottomSHeetFragment extends BottomSheetDialogFragment {
    EditText name, email, phone, password, location;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button signup;
    LinearLayout main;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.signup_buttom_sheet, container, false);
        main = view.findViewById(R.id.main);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        password = view.findViewById(R.id.password);
        location = view.findViewById(R.id.location);
        radioGroup = view.findViewById(R.id.radioGroupID);
        signup = view.findViewById(R.id.signupBtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userEmail = email.getText().toString();
                String userPhone = phone.getText().toString();
                String userPassword = password.getText().toString();
                String userLocation = location.getText().toString();
                int select = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) view.findViewById(select);
                String userType = radioButton.getText().toString();
                //registration user input check
                if (userName.isEmpty()) {
                    name.setError("Name is empty");
                    name.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    email.setError("your email address is not correct please enter new email address");
                    email.requestFocus();
                    return;
                }
                if (userEmail.isEmpty()) {
                    email.setError("Email is empty");
                    email.requestFocus();
                    return;
                }
                if (userPhone.isEmpty()) {
                    phone.setError("Phone number is empty");
                    phone.requestFocus();
                    return;
                }
                if (userPassword.isEmpty()) {
                    password.setError("Password is empty");
                    password.requestFocus();
                    return;
                }
                if (userPassword.length() < 8) {
                    password.setError("password must 8+");
                    password.requestFocus();
                    return;
                }
                if (userLocation.isEmpty()) {
                    location.setError("Location is empty");
                    location.requestFocus();
                    return;
                }
                if (radioButton.getText().toString().isEmpty()) {
                    radioButton.setError("Please select your type");
                    radioButton.requestFocus();
                    return;
                }

                if (userType.equals("User")){
                    //registration user input check
                    try {
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BaseUrl.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create()).build();

                        OurRetroft ourRetroft = retrofit.create(OurRetroft.class);

                        Model model = new Model(userName, userEmail, userPhone, userPassword, userType, userLocation);
                        Call<Model> modelCall = ourRetroft.postData(model);
                        modelCall.enqueue(new Callback<Model>() {
                            @Override
                            public void onResponse(Call<Model> call, Response<Model> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(getContext(), "wow responced", Toast.LENGTH_LONG).show();

                                    try {
                                        Toast.makeText(getContext(), "" + response.body().getForResponceAnotherModel().userName, Toast.LENGTH_LONG).show();
                                    } catch (Exception e) {
                                        Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_LONG).show();
                                        Log.d("KK", e.getMessage());
                                    }

                                    main.setVisibility(View.GONE);

                                } else {
                                    Toast.makeText(getContext(), "no responce", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Model> call, Throwable t) {
                                Toast.makeText(getContext(), "connection faield" + t.getMessage(), Toast.LENGTH_LONG).show();
                                main.setVisibility(View.GONE);
                            }
                        });
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }if (userType.equals("Service provider")){

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BaseUrl.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    OurRetroft ourRetroft = retrofit.create(OurRetroft.class);
                    ServicePojo servicePojo = new ServicePojo(userName, userEmail, userPhone, userPassword, userType, userLocation);

                    Call<ServicePojo> servicePojoCall =  ourRetroft.postServiceProviderData(servicePojo );
                    servicePojoCall.enqueue(new Callback<ServicePojo>() {
                        @Override
                        public void onResponse(Call<ServicePojo> call, Response<ServicePojo> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(getContext(), "wow responced service Providers", Toast.LENGTH_LONG).show();

                                try {
                                    //Toast.makeText(getContext(), "" + response.body().getForResponceAnotherModel().userName, Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_LONG).show();
                                    Log.d("KK", e.getMessage());
                                }

                                main.setVisibility(View.GONE);

                            } else {
                                Toast.makeText(getContext(), "no responce", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ServicePojo> call, Throwable t) {

                        }
                    });

                }

            }
        });

        return view;
    }


}
