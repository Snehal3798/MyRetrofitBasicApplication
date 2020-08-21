package snehal.adhav.myretrofitbasicapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import snehal.adhav.myretrofitbasicapplication.R;
import snehal.adhav.myretrofitbasicapplication.extras.AppPreference;
import snehal.adhav.myretrofitbasicapplication.fragment.LoginFragment;
import snehal.adhav.myretrofitbasicapplication.fragment.ProfileFragment;
import snehal.adhav.myretrofitbasicapplication.fragment.RegisterFragment;
import snehal.adhav.myretrofitbasicapplication.services.MyInterface;

public class MainActivity extends AppCompatActivity implements MyInterface {
FrameLayout container_fragment;
public static AppPreference appPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container_fragment=findViewById(R.id.fragment_container);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,new LoginFragment())
                .commit();
    }

    @Override
    public void register() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new RegisterFragment())

                .commit();
    }

    @Override
    public void login(String name, String email, String created_at) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new ProfileFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void logout() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new LoginFragment())
                .addToBackStack(null)
                .commit();

    }
}