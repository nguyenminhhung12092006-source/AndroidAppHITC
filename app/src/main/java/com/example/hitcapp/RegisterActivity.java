package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText editTextName = findViewById(R.id.editTextRegName);
        EditText editTextPhone = findViewById(R.id.editTextRegPhone);
        EditText editTextPassword = findViewById(R.id.editTextRegPassword);
        Button buttonRegister = findViewById(R.id.buttonRegister);
        TextView textViewSignIn = findViewById(R.id.textViewSignIn);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (name.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (phone.length() < 10) {
                    Toast.makeText(RegisterActivity.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu phải từ 6 ký tự", Toast.LENGTH_SHORT).show();
                } else {
                    // Giả lập đăng ký thành công
                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    
                    // Quay lại màn hình Đăng nhập
                    finish();
                }
            }
        });

        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại trang Login
                finish();
            }
        });
    }
}
