package com.example.chicolemevipclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "Login Activity";

    private Button nConta;
    TextView mTextViewNewUser, mTextViewForgotPassword;
    Button mButtonLogin;
    EditText mEditTextEmail, mEditTextPassword;
    ProgressBar mProgressBarLogin;
    String mStringUser, mStringPassword, mStringEmail;
    SharedPreferences mSharedPreferences;

    private boolean isRequiredPassword(){
        return TextUtils.isEmpty(mEditTextPassword.getText());
    }

    private boolean isValidEmail(String mStringEmail){
        if (mStringEmail == null || mStringEmail.isEmpty()){
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(mStringEmail).matches();
    }

    private void showPerfil(){
        Intent mIntent = new Intent(getApplicationContext() , ScreenUser.class);
        startActivity(mIntent);
        finish();
    }

    private void verifyLogged(){
        if (mSharedPreferences.getString("logged" , "false").equals("true")){
            showPerfil();
        }
    }

    private void postData(){
        mStringEmail = String.valueOf(mEditTextEmail.getText()).toLowerCase(Locale.ROOT);
        mStringPassword = String.valueOf(mEditTextPassword.getText());

        if(!isValidEmail(mStringEmail)){
            String mTextMessage = getString(R.string.text_email_invalid);
            Toast.makeText(getApplicationContext() , mTextMessage , Toast.LENGTH_SHORT).show();
            return;
        }

        if (isRequiredPassword()){
            String mTextMessage = getString(R.string.text_password_invalid);
            Toast.makeText(getApplicationContext() , mTextMessage , Toast.LENGTH_SHORT).show();
            return;
        }

        mProgressBarLogin.setVisibility(View.VISIBLE);

        User mUser = new User(mStringPassword , mStringEmail);

        String mResult = UserDAO.authenticateUser(mUser , getApplicationContext());

        mProgressBarLogin.setVisibility(View.GONE);

        if(mResult.isEmpty() || mResult.equals("") || mResult.equals("Exception")){
            String mTextMessage;
            mTextMessage = getString(R.string.text_passwordEemail_invalid);
            if (mResult.equals("Exception")){
                mTextMessage = getString(R.string.text_connection_error);
            }
            Toast.makeText(getApplicationContext(), mTextMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString("logged" , "true");
        mEditor.putString("email" , mStringEmail);
        mEditor.putString("fullname" , mResult);
        mEditor.apply();

        Intent mIntent = new Intent(getApplicationContext() , ScreenUser.class);
        mIntent.putExtra("EXTRA_FULL_NAME" , mResult);
        startActivity(mIntent);
        finish();

    }

    public class ClickMyButtonLogin implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            postData();
        }
    }

    private void showSignUp(){
        startActivity(new Intent(this,CadasterActivity.class));
        finish();
    }

    public class ClickMyNewUserSignUp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            showSignUp();
        }
    }

    private void showForgotPassword(){
        Intent mIntent = new Intent(getApplicationContext() , ResetPassword.class);
        startActivity(mIntent);
        finish();
    }

    public class ClickMyResetPassword implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            showForgotPassword();
        }
    }


    //voltar aq
    public class EditMyTextAction implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            int actionId = 0;
            if (actionId == EditorInfo.IME_ACTION_DONE){
                postData();
            }

            return false;
        }
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditTextEmail = findViewById(R.id.editText_email_log);

        mEditTextPassword = findViewById(R.id.editText_password_log);
        mEditTextPassword.setOnEditorActionListener(new EditMyTextAction());

        mButtonLogin = findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(new ClickMyButtonLogin());

        mTextViewNewUser = findViewById(R.id.textView_novaconta);
        mTextViewNewUser.setOnClickListener(new ClickMyNewUserSignUp());

        mTextViewForgotPassword = findViewById(R.id.textView_esquecisenha);
        mTextViewForgotPassword.setOnClickListener(new ClickMyResetPassword());

        nConta = findViewById(R.id.textView_novaconta);
        nConta.setOnClickListener(view ->showSignUp());
    }}

