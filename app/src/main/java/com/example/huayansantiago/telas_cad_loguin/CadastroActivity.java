package com.example.huayansantiago.telas_cad_loguin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText email,senha,csenha;
    Button Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        db = new DatabaseHelper(this);
        email=(EditText)findViewById(R.id.email_id);
        senha=(EditText)findViewById(R.id.senha_id);
        csenha=(EditText)findViewById(R.id.csenha_id);
        Registrar=(Button)findViewById(R.id.registrar);
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = email.getText().toString();
                String f = senha.getText().toString();
                String h = csenha.getText().toString();
                if (i.equals("")|| f.equals("")|| h.equals(""){
                    Toast.makeText(getApplicationContext(),"Campo esta vazio",Toast.LENGTH_SHORT).show();
                }
                    else {
             if (senha.equals(csenha)){
                    Boolean checkemail =db.checkemail(email);
                    if (checkemail==true){
                        Boolean insert = db.insert(email,senha);
                        if (insert == true){
                            Toast.makeText(getApplicationContext(),"Registro Concluido",Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Email nao cadastrado",Toast.LENGTH_LONG).show();

                        }
                    }
                }
                }
            }

    }
}
