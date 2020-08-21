package snehal.adhav.myretrofitbasicapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import snehal.adhav.myretrofitbasicapplication.R;
import snehal.adhav.myretrofitbasicapplication.services.MyInterface;


public class LoginFragment extends Fragment {
  Button loginBtn;
  EditText emailInput,passwordInput;
  MyInterface myInterface_login;
  TextView register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        emailInput=view.findViewById(R.id.emailInput);
        passwordInput=view.findViewById(R.id.passwordInput);
        loginBtn=view.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Toast.makeText(getActivity(), "Login", Toast.LENGTH_SHORT).show();
          }
        });
        //Register
      register=view.findViewById(R.id.registerTV);
      register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "Register", Toast.LENGTH_SHORT).show();
            myInterface_login.register();
        }
      });
        return view;
    }


    public LoginFragment() {
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity= (Activity) context;
        myInterface_login= (MyInterface) activity;
    }
}