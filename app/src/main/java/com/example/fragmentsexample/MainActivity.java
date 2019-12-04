package com.example.fragmentsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentsexample.fragments.FirstFragment;
import com.example.fragmentsexample.fragments.SecondFragment;
import com.example.fragmentsexample.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFragment;
    Boolean status = true

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        btnFragment = findViewById( R.id.btnFragment );
        btnFragment.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(status){
            ThirdFragment thirdFragment = new ThirdFragment();
            fragmentTransaction.replace( R.id.fragmentContainer, thirdFragment );
            fragmentTransaction.commit();
            btnFragment.setText( "Load Second Fragment" );
            status = false;
        }
        else{
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace( R.id.fragmentContainer, secondFragment );
            fragmentTransaction.commit();
            btnFragment.setText( "Load First Fragment" );
            status = true;
        }
    }
}
