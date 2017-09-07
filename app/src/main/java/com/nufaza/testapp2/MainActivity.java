package com.nufaza.testapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.textHasil);
        final EditText ed = (EditText) findViewById(R.id.textEditor);
        Button btn = (Button) findViewById(R.id.btnGanti);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(ed.getText());
            }
        });

        final MaterialDialog md = new MaterialDialog.Builder(MainActivity.this)
                .title("Info")
                .content("Anda menulis " + ed.getText() + ". Bener? ")
                .negativeText("Nggak Ah")
                .positiveText("Iyah")
                .show();

        md.getActionButton(DialogAction.NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Oh nggak yah?", Toast.LENGTH_LONG).show();
                md.dismiss();
            }
        });

        md.getActionButton(DialogAction.POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tuuuh bener kan?", Toast.LENGTH_LONG).show();
                md.dismiss();
            }
        });

    }
}
