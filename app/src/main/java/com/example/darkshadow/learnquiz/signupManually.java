package com.example.darkshadow.learnquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signupManually extends AppCompatActivity {
    Button signupButton = (Button) findViewById(R.id.signupbutton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_manually);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupManually.this,loginManually.class);
                startActivity(intent);
            }
        });
    }
}
