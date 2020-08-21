package snehal.adhav.myretrofitbasicapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

import snehal.adhav.myretrofitbasicapplication.R;
import snehal.adhav.myretrofitbasicapplication.activities.MainActivity;


public class RegisterFragment extends Fragment {

EditText nameInput_reg,emailInput_reg,phoneInput_reg,passwordInput_reg;
Button button_reg;

    public RegisterFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        nameInput_reg=view.findViewById(R.id.nameInput);
        emailInput_reg=view.findViewById(R.id.emailInput);
        phoneInput_reg=view.findViewById(R.id.phoneInput);
        passwordInput_reg=view.findViewById(R.id.passwordInput);
        button_reg=view.findViewById(R.id.regBtn);
        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }

            private void registerUser() {
                String name=nameInput_reg.getText().toString().trim();
                String email=emailInput_reg.getText().toString().trim();
                String phone=phoneInput_reg.getText().toString().trim();
                String password=passwordInput_reg.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    MainActivity.appPreference.showToast("Name Required");
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    MainActivity.appPreference.showToast("Email Required");
                }
                else if(TextUtils.isEmpty(phone)){
                    MainActivity.appPreference.showToast("Phone Required ");
                }
                else if(TextUtils.isEmpty(password)){
                    MainActivity.appPreference.showToast("Password Required ");
                }
                else if(password.length()<6){
                    MainActivity.appPreference.showToast(" Password To short ");
                }
                else{
                    //Data on server
                }
            }
        });
        return view;
    }
}