package net.aeontest.vikadgenie;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TextView forgottxt;
    EditText nameedtxt, pwdedtxt;
    String name ,pwd;
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.txt);
        forgottxt = (TextView) findViewById(R.id.forgotpasstxt);
        nameedtxt = (EditText) findViewById(R.id.input_name);
        pwdedtxt = (EditText) findViewById(R.id.passtxt);

      name = nameedtxt.getText().toString();
        pwd = pwdedtxt.getText().toString();
//        if (name.matches("")) {
//            //MobileEditTxt.setHint("please enter mobile no.");
//            nameedtxt.setError("Please enter email.");
//            flag=false;
//        }
//        if (pwd.matches("")) {
//            //  pwdedtxt.setHint("please enter password");
//            pwdedtxt.setError("Please enter password");
//            flag = false;
//        }

        forgottxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ForgotpassActivity.class);
                startActivity(i);
                overridePendingTransition(0, 0);

            }
        });

        pwdedtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });
        nameedtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
     }

            @Override
            public void afterTextChanged(Editable editable) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!name.matches(emailPattern)) {
                    //emailtxt.setHint("please enter valid  email id");
                    nameedtxt.setError("Your email address must be in the format of \nname@domain.com");
                    flag = false;
                }

                }

            });

    }
}
