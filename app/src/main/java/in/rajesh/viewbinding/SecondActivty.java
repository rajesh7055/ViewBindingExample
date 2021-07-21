package in.rajesh.viewbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import in.rajesh.viewbinding.databinding.ActivitySecondActivtyBinding;

public class SecondActivty extends AppCompatActivity {

    ActivitySecondActivtyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySecondActivtyBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        loadFragment();
    }

    private void loadFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linear_container, new HelloFragment());
        transaction.commit();
    }
}