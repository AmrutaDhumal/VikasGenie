package net.aeontest.vikadgenie;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ForgotpassActivity extends AppCompatActivity {
    TextView nexttxt,sendtxt,input_mail,emailtxt1,trytxt;
    RelativeLayout rl1,rl2,rl3;
    String emailStr;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        nexttxt=(TextView)findViewById(R.id.nexttxt);
        sendtxt=(TextView)findViewById(R.id.sendtxt);
        input_mail=(TextView)findViewById(R.id.input_mail);
        trytxt=(TextView)findViewById(R.id.trytxt);
        emailtxt1=(TextView)findViewById(R.id.emailtxt1);
        rl1=(RelativeLayout)findViewById(R.id.rl);
        rl2=(RelativeLayout)findViewById(R.id.r2);
        rl3=(RelativeLayout)findViewById(R.id.r3);


        input_mail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 emailStr=input_mail.getText().toString();
                Log.d("Email",emailStr);
//                if (!emailStr.matches(emailPattern)) {
//                    //emailtxt.setHint("please enter valid  email id");
//                    emailtxt1.setError("Your email address must be in the format of \nname@domain.com");
//
//                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            });


        nexttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl2.setVisibility(View.VISIBLE);
                rl1.setVisibility(View.GONE);
                rl3.setVisibility(View.GONE);
                sendtxt.setVisibility(View.VISIBLE);
                trytxt.setVisibility(View.INVISIBLE);
                nexttxt.setVisibility(View.VISIBLE);
                emailtxt1.setText(emailStr);
            }
        });


        sendtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl3.setVisibility(View.VISIBLE);
                rl1.setVisibility(View.GONE);
                rl2.setVisibility(View.GONE);
                trytxt.setVisibility(View.VISIBLE);
                sendtxt.setVisibility(View.INVISIBLE);
                nexttxt.setVisibility(View.INVISIBLE);

            }
        });

        trytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl2.setVisibility(View.VISIBLE);
                rl1.setVisibility(View.GONE);
                sendtxt.setVisibility(View.VISIBLE);

            }
        });
    }

}
