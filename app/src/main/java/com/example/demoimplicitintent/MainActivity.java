package com.example.demoimplicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText etMessage;
    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMessage = findViewById(R.id.editTextMessage);
        btnEmail = findViewById(R.id.buttonEmail);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"17010304@myrp.edu.sg"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Test Email from Android Programming II");
                intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client: "));
            }
        });

    }
}
