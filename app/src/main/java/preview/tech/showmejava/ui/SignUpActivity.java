package preview.tech.showmejava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import preview.tech.showmejava.R;
import preview.tech.showmejava.adapter.HeroesAdapter;
import preview.tech.showmejava.adapter.MenuesAdapter;
import preview.tech.showmejava.model.SignUp;
import preview.tech.showmejava.viewmodel.MainViewModel;
import preview.tech.showmejava.viewmodel.MenuesViewModel;
import preview.tech.showmejava.viewmodel.SignUpViewModel;

public class SignUpActivity extends AppCompatActivity {

    private EditText edt_email, edt_pass, edt_c_pass;
    private SignUp signUp;
    private SignUpViewModel signUpViewModel;
    private String em, pas, c_pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setup_ui();
        setup_viewmodel();

        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(i);
        });

        findViewById(R.id.button3).setOnClickListener(v -> {

            em = edt_email.getText().toString();
            pas = edt_pass.getText().toString();
            c_pas = edt_c_pass.getText().toString();


            signUp.setEmail(em);
            signUp.setPassword(pas);
            signUp.setC_password(c_pas);

            signUpViewModel.loadMenues(signUp.getEmail(),signUp.getPassword(),signUp.getC_password());
        });
    }


    private void setup_ui() {
        signUp= new SignUp("","","");
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_pass);
        edt_c_pass = findViewById(R.id.edt_c_pass);

    }

    private void setup_viewmodel() {
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);


        /*Intent i= new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(i);*/
    }


}
