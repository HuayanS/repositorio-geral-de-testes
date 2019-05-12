package com.example.huayansantiago.telas_cad_loguin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailEdit;
    private EditText senhaEdit;
    private Button loguinBnt;
    private TextView cadastarTxt;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(Context this);
        emailEdit = findViewById(R.id.email_id);
        senhaEdit = findViewById(R.id.senha_id);
        loguinBnt = findViewById(R.id.login);
        cadastarTxt = findViewById(R.id.cadastrar);

        loguinBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString();
                String senha = senhaEdit.getText().toString();
                Boolean checkEmailSenha = db.checkemail(email,senha);
                if (checkEmailSenha == true){
                    Toast.makeText(getApplicationContext(),"Loguin Sucesso!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Email ou Senha incorreto",Toast.LENGTH_LONG).show();

                }
            }
        });
        cadastarTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CadastroActivity.class);
                startActivity(intent);
            }
        });
    }
}
