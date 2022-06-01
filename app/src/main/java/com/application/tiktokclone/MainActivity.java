package com.application.tiktokclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.application.tiktokclone.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Model> arrayList=new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v5,R.drawable.man, "Rocky Boy"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v3,R.drawable.man, "Rocky Boy"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v1,R.drawable.man, "Rocky Boy"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v5,R.drawable.man, "Rocky Boy"));
        adapter=new Adapter(MainActivity.this, arrayList);
        binding.viewPager2.setAdapter(adapter);
    }
}