package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.admin.AdminModel;
import com.example.myapplication.admin.OurRetrofitForAdmin;
import com.example.myapplication.admin.adminAction.Action;
import com.example.myapplication.modelClass.loginModel.Retrofit.OurRetrifit;
import com.example.myapplication.modelClass.loginModel.UserPojo.UserPojo;
import com.example.myapplication.problemShowToServiceProviders.ShowUserAllProblems;
import com.example.myapplication.serviceProviderCheck.ProvidersCheckInterface;
import com.example.myapplication.serviceProviderCheck.ServicePojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Snd extends Fragment {
    Button login, admin, test;
    LinearLayout resister;
    EditText email, password;

    public Snd() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_snd, container, false);
        admin = view.findViewById(R.id.admin);
        login = view.findViewById(R.id.login);
        resister = view.findViewById(R.id.resister);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        test = view.findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TestActivity.class);
                startActivity(intent);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), RecycleForShowAllUser.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    email.setError("this email address already use");
                    email.requestFocus();
                    return;
                }
                if (userPassword.isEmpty()) {
                    password.setError("password is empty");
                    password.requestFocus();
                    return;
                }
                if (userEmail.equals("golamkibria.java@gmail.com") && userPassword.equals("413152413152")) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containear, new AfterLogin(), "afterLogin").addToBackStack(null).commit();
//////////////////
                }
                forAdmin();//first working with admin else other service check
                forServiceProvider();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BaseUrl.BASE_URL)       //using rest api my rest api name is  = "forRoadside" rest api into my pc
                        .addConverterFactory(GsonConverterFactory.create()).build();
                OurRetrifit ourRetrifit = retrofit.create(OurRetrifit.class);
                UserPojo newPojo = new UserPojo();
                newPojo.setUserEmail(userEmail);
                newPojo.setUserPassword(userPassword);
                Call<UserPojo> listCall = ourRetrifit.postData(newPojo);
                listCall.enqueue(new Callback<UserPojo>() {
                    @Override
                    public void onResponse(Call<UserPojo> call, Response<UserPojo> response) {
                        userLogin(response.body());
                    }

                    @Override
                    public void onFailure(Call<UserPojo> call, Throwable t) {

                    }
                });


            }
        });
        resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupBottomSHeetFragment signupBottomSHeetFragment = new SignupBottomSHeetFragment();
                signupBottomSHeetFragment.show(getFragmentManager(), "signup");
            }
        });
        return view;
    }

    private void forServiceProvider() {
        final String serviceProviderEmail = email.getText().toString();
        String serviceProviderPassword = password.getText().toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProvidersCheckInterface providersCheckInterface = retrofit.create(ProvidersCheckInterface.class);
        ServicePojo servicePojo = new ServicePojo();
        servicePojo.setServiceEmail(serviceProviderEmail);
        servicePojo.setServicePassword(serviceProviderPassword);

        Call<ServicePojo> call = providersCheckInterface.postServiceProvidersData(servicePojo);
        call.enqueue(new Callback<ServicePojo>() {
            @Override
            public void onResponse(Call<ServicePojo> call, Response<ServicePojo> response) {
                serviceProviderCheck(response.body());
            }

            @Override
            public void onFailure(Call<ServicePojo> call, Throwable t) {

            }
        });
    }

    private void forAdmin() {
        String adminEmail = email.getText().toString();
        String adminPassword = password.getText().toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofitForAdmin ourRetrofitForAdmin = retrofit.create(OurRetrofitForAdmin.class);
        AdminModel adminModel = new AdminModel();
        adminModel.setAdminEmail(adminEmail);
        adminModel.setAdminPassword(adminPassword);
        Call<AdminModel> call = ourRetrofitForAdmin.postAdminInfo(adminModel);
        call.enqueue(new Callback<AdminModel>() {
            @Override
            public void onResponse(Call<AdminModel> call, Response<AdminModel> response) {
                AdminLogin(response.body());
            }

            @Override
            public void onFailure(Call<AdminModel> call, Throwable t) {

            }
        });

    }

    private void AdminLogin(AdminModel body) {
        if (body.getAdminEmail() != null) {
            Toast.makeText(getContext(), "Welcome Admin", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getActivity(), Action.class));
        }
    }

    private void userLogin(UserPojo body) {
        if (body.getUserEmail() != null) {
            Toast.makeText(getContext(), "Welcome User", Toast.LENGTH_LONG).show();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containear, new AfterLogin(), "afterLogin").addToBackStack(null).commit();
        } else {
            Toast.makeText(getContext(), "No User found", Toast.LENGTH_LONG).show();
        }
    }

    private void serviceProviderCheck(ServicePojo body) {
        if (body.getServiceEmail() != null) {
            Toast.makeText(getContext(), "Welcome ServiceProviders", Toast.LENGTH_LONG).show();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containear,new ShowUserAllProblems(),"afterLogin").addToBackStack(null).commit();
        } else {
            Toast.makeText(getContext(), "No ServiceProviders found", Toast.LENGTH_LONG).show();
        }
    }


//    private void adminMethodCheck(List<AdminModel> body) {
//        String adminEmail = email.getText().toString();
//        String adminPassword = password.getText().toString();
//
//        try {
//            for (AdminModel get : body) {
////                if (get.getAdminEmail().equals(adminEmail) && get.getAdminPassword().equals(adminPassword)&& get.getAdminName().equals("Golam Kibria") ) {
////                    Toast.makeText(getContext(), "ohhh! you are admin go to next Step", Toast.LENGTH_LONG).show();
////                }
//                if (get.getAdminEmail().equals(adminEmail) && get.getAdminPassword().equals(adminPassword) && get.getAdminPhone().equals("01531921892")) {
//                    Toast.makeText(getContext(), get.getAdminEmail().toString() + "\n" + get.getAdminPhone().toString(), Toast.LENGTH_LONG).show();
//
//                    //for admin action agnaist user and service provider
//                    startActivity(new Intent(getActivity(), Action.class));
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
}
