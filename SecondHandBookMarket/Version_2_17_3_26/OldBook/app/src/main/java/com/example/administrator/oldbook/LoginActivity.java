package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    private Toast mToast = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ActivityCollector.addActivity(this);
        Button Sign_Button = (Button) findViewById(R.id.Login2Activity_SignIn_Button);
        Sign_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignMainActivity.class);
                startActivity(intent);
            }
        });
        Button Login_Button = (Button) findViewById(R.id.Login2Activity_Login_Button);
        Login_Button.setOnClickListener(this);
        TextView ForgetPassword_TextView = (TextView) findViewById(R.id.Login2Activity_Froget_Password);
        ForgetPassword_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        if(((EditText)findViewById(R.id.Login2Activity_ID_Text)).getText().toString()
                .equals("") ||
                ((EditText)findViewById(R.id.Login2Activity_Password_Text)).getText().toString()
                        .equals("") )
        {
            showToast("账号或密码不能为空");
            //Toast.makeText(getApplicationContext(), "账号或密码不能为空" , Toast.LENGTH_SHORT).show();
        }
        else if(((EditText)findViewById(R.id.Login2Activity_ID_Text)).getText().toString()
                .equals((getResources().getString(R.string.account)).toString()) &&
                ((EditText)findViewById(R.id.Login2Activity_Password_Text)).getText().toString()
                        .equals( (getResources().getString(R.string.password)).toString()))
        {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            showToast("账号或密码错误");
            //Toast.makeText(getApplicationContext(), "账号或密码错误" , Toast.LENGTH_SHORT).show();
        }
    }

    public void showToast(String info)
    {
        if(mToast != null)
        {
            mToast.setText(info);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        else
        {
            mToast = Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            showToast("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            ActivityCollector.finishAll();
        }
    }
}
