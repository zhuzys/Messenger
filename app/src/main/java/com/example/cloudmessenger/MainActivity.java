package com.example.cloudmessenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.cloudmessenger.Model.Users;
import com.example.cloudmessenger.adapter.UsersAdapter;

import com.example.cloudmessenger.adapter.FragmentAdapter;

import com.example.cloudmessenger.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users("R.drawable.avatar", "Zhuzy", "zh.amankeldi@aues.kz", "1234567", "azhuzy", "Hello", "Online"));
        list.add(new Users("R.drawable.avatar", "Zhaniya", "zhaniya@aues.kz", "12345678", "azhoni", "Bye", "Online"));

        UsersAdapter usersAdapter = new UsersAdapter(list, this);
        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));








        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello");

        auth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, "" +value, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())   {
            case R.id.settings:
                Intent intent3 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent3);
                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();

                break;
            case  R.id.logout:
                //auth.signOut();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                break;

            case R.id.groupChat:
                Intent intent2 = new Intent(MainActivity.this, GroupChatActivity.class);
                startActivity(intent2);

                break;
            default:
                break;
        }
        return  true;

    }
}