package com.example.appcadastro.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.appcadastro.DAO.UserDao;
import com.example.appcadastro.Model.User;


import com.example.appcadastro.R;

public class Cadastro extends AppCompatActivity {

    Button btncadastro;
    EditText editnome, editemail, editsenha, confsenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btncadastro= findViewById(R.id.btncadastro);
        editnome=findViewById(R.id.username);
        editemail=findViewById(R.id.email);
        editsenha= findViewById(R.id.password);
        confsenha = findViewById(R.id.password_confirm);

        btncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user, email, senha, senhaconfirme;
                user = editnome.getText().toString();
                email= editemail.getText().toString();
                senha = editsenha.getText().toString();
                senhaconfirme = confsenha.getText().toString();

                //Testando erros

                //campos vazios
                if (user.equals("") || email.equals("") || senha.equals("") || senhaconfirme.equals("")){
                    Toast.makeText(Cadastro.this, "Por favor. Preencha todos os campos!", Toast.LENGTH_SHORT).show();

                } else if(!senha.equals(senhaconfirme)){
                    //Verifico as senhas
                    Toast.makeText(Cadastro.this, "Senhas diferentes!", Toast.LENGTH_SHORT).show();
                } else{
                    //Salvo os dados
                    UserDao userdao = new UserDao(getApplicationContext(), new User(user, email, senha));
                    if(userdao.signUpVality()==true){
                        //Verificação do email
                        Toast.makeText(Cadastro.this, "Email já cadastrado!", Toast.LENGTH_SHORT).show();
                    } else{
                        //Se não houver eu salvo
                        userdao.signUp();
                        Toast.makeText(Cadastro.this, "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                    //limpando os campos
                    editnome.setText("");
                    editemail.setText("");
                    editsenha.setText("");
                    confsenha.setText("");
                }
            }
        });
    }

            }
