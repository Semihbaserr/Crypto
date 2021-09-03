package com.semihbaser.crypto;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class SomeActivity extends AppCompatActivity {

   // private static final String TAG = "SomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some);


        TextView nameInfo =findViewById(R.id.nameInfo);
        TextView infoText =findViewById(R.id.infoText);
        TextView priceInfo =findViewById(R.id.priceInfo);
        TextView mailInfo=findViewById(R.id.mailInfo);
        ImageView imageInfo =findViewById(R.id.imageInfo);

        String username ="Username not set";

        Belongings belongings = (Belongings) getIntent().getSerializableExtra("name");
        if (belongings != null){
            nameInfo.setText(belongings.name);
            infoText.setText("Product Info :  "+belongings.info);
            priceInfo.setText(belongings.price);
            mailInfo.setText("Uploaded By: "+belongings.email);
            Picasso.get().load(belongings.downloadUrl).into(imageInfo);

        }


        

    }
}