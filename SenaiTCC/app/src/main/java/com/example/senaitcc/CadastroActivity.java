package com.example.senaitcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CadastroActivity extends AppCompatActivity {

    private Button btn_selected_photo;
    private CircleImageView img_photo;

    private EditText mEditUsername;
    private EditText mEditEmail;
    private EditText mEditPassword;
    private EditText mEditCPassword;
    private Button mBtnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        btn_selected_photo = findViewById(R.id.btn_selected_photo);
        img_photo = findViewById(R.id.img_photo);

        mEditUsername = findViewById(R.id.edit_username);
        mEditEmail = findViewById(R.id.edit_email);
        mEditPassword = findViewById(R.id.edit_password);
        mEditCPassword = findViewById(R.id.edit_Cpassword);
        mBtnEnter = findViewById(R.id.btn_enter);

        if(type.equals("usuario")){
            Log.i("teste", "usuario");
        }

        if(type.equals("estagiario")){
            Log.i("teste", "estagiario");
            btn_selected_photo.setVisibility(View.VISIBLE);
            img_photo.setVisibility(View.VISIBLE);
        }

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        ArrayList<String> universidades = new ArrayList<>();

    }

    private void createUser() {
        String nome = mEditUsername.getText().toString();
        String email = mEditEmail.getText().toString();
        String senha = mEditPassword.getText().toString();
        String csenha = mEditCPassword.getText().toString();

        if(nome == null || nome.isEmpty() || email == null || email.isEmpty() || senha == null || senha.isEmpty() || csenha == null || csenha.isEmpty()){
            Toast.makeText(this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("Teste", task.getResult().getUser().getUid());

                            /*saveUserInFireBase();*/
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Teste", e.getMessage());
                    }
                });

    }
}
