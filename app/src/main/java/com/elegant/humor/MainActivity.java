package com.elegant.humor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.elegant.humor.view.StartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new StartFragment()).commit();
    }
}
