package com.example.chicolemevipclient;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CadasterActivity extends AppCompatActivity {
    public static final String TAG = "Sign Up Activity";


    private Button jConta;
    private EditText mEditTextUserName, mEditTextEmail, mEditTextPassword, mEditTextCelular;
    private Button mButtonSignUp;
    private ProgressBar mProgressBarCadastro;
    private String mStringName, mStringEmail, mStringPassword, mStringCelular;

    private boolean isRequired(){
            if(TextUtils.isEmpty(mEditTextUserName.getText()) ||
               TextUtils.isEmpty(mEditTextCelular.getText()) ||
               TextUtils.isEmpty(mEditTextEmail.getText()) ||
               TextUtils.isEmpty(mEditTextPassword.getText()))
            {
                return true;
            } else{
                return false;
            }
        }

        private void performActivityLogin(){
        Intent mIntent = new Intent(getApplicationContext() , LoginActivity.class);
        startActivity(mIntent);
        finish();

    }

    private void postData(){
        if(isRequired()){
            String mTextMessage = getString(R.string.text_error_all_fields);
            Toast.makeText(getApplicationContext() , mTextMessage , Toast.LENGTH_SHORT).show();
            return;
        }

        mStringName = String.valueOf(mEditTextUserName.getText());
        mStringEmail = String.valueOf(mEditTextEmail.getText()).toLowerCase(Locale.ROOT);
        mStringPassword = String.valueOf(mEditTextPassword.getText()).toString().trim();
        mStringCelular = String.valueOf(mEditTextCelular.getText()).toString();

        mProgressBarCadastro.setVisibility(View.VISIBLE);

        User mUser = new User(mStringName, mStringPassword, mStringEmail, mStringCelular, "Cliente", 0);

        int vResult = UserDAO.insertUser(mUser , getApplicationContext());

        String mTextMessage;

        mProgressBarCadastro.setVisibility(View.GONE);

        if(vResult <= 0){
            mTextMessage = getString(R.string.text_insert_error);
        } else{
            mTextMessage = getString(R.string.text_insert_success);
        }

        Intent mIntent = new Intent(getApplicationContext() , LoginActivity.class);
        startActivity(mIntent);
        finish();

    }

    public class ClickMyButtonSignUp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            postData();
        }
    }

    public class ClickMyViewAlreadyLogin implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            performActivityLogin();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadaster);

        mEditTextUserName = findViewById(R.id.editText_nome_cad);
        mEditTextPassword = findViewById(R.id.editText_password_cad);
        mEditTextEmail = findViewById(R.id.editText_email_cad);
        mEditTextCelular = findViewById(R.id.editText_numero_cad);

        mButtonSignUp = findViewById(R.id.button_cad);
        mButtonSignUp.setOnClickListener(new ClickMyButtonSignUp());

        jConta = findViewById(R.id.textView_jaTemLogin_cad);
        jConta.setOnClickListener(view ->startActivity(new Intent(this,LoginActivity.class)));


    }
}
