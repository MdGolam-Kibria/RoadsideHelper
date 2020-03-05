package com.example.myapplication.admin.adminAction;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.admin.adminAction.user.CustomUserAdapterForUsers;
import com.example.myapplication.admin.adminAction.user.UserAndServiceProviderPojo;
import com.example.myapplication.admin.adminAction.user.UserInterface;
import com.example.myapplication.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.myapplication.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class User extends Fragment {


    private RecyclerView recyclerView;

    public User() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewUser);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)  //using rest api my rest api name is  = forRoadside into my pc
                .addConverterFactory(GsonConverterFactory.create()).build();
        UserInterface userInterface = retrofit.create(UserInterface.class);
        Call<List<UserAndServiceProviderPojo>> listCall = userInterface.getAllUserInfoAll();
        listCall.enqueue(new Callback<List<UserAndServiceProviderPojo>>() {
            @Override
            public void onResponse(Call<List<UserAndServiceProviderPojo>> call, Response<List<UserAndServiceProviderPojo>> response) {
                try {
                    showIt(response.body());
                } catch (Exception e) {
                    Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserAndServiceProviderPojo>> call, Throwable t) {

            }
        });
        return view;
    }

    private void showIt(final List<UserAndServiceProviderPojo> body) {

        CustomUserAdapterForUsers customUserAdapter = new CustomUserAdapterForUsers(body, getContext());
        recyclerView.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        // above parameters for recycler view devider style class this copy from google link below
        //https://www.androidhive.info/2016/01/android-working-with-recycler-view/
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                UserAndServiceProviderPojo movie = body.get(position);
                Toast.makeText(getContext(), movie.getUserName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setAdapter(customUserAdapter);
    }

    //below for recycler view item click and long item click lis.. interface method;

}
