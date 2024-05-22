package com.example.memo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_nav = findViewById(R.id.nav);
        Button btn_carte = findViewById(R.id.carte);
        Button btn_app = findViewById(R.id.new_app);
        Button txt_btn = findViewById(R.id.text_activity);
        TextView txtV = findViewById(R.id.txt_recup);

        btn_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_nav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/kadluc005"));
                startActivity(intent_nav);
            }
        });

        btn_carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_carte = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=London"));
                startActivity(intent_carte);
            }
        });

        btn_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_app = new Intent("monAction.COUCOU");
                startActivity(intent_app);
            }
        });
        txt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecupActivity.class));
            }
        });


        Intent intent_txt = getIntent();
        String text = intent_txt.getStringExtra("txt");
        if (text != null) {
            txtV.setText("Texte récupéré: " + text);
        } else {
            txtV.setText("Texte récupéré: ");
        }

    }
}