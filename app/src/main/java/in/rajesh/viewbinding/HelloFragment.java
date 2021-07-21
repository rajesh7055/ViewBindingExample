package in.rajesh.viewbinding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.rajesh.viewbinding.databinding.FragmentHelloBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HelloFragment extends Fragment {

    private FragmentHelloBinding helloBinding;
    public HelloFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        helloBinding=FragmentHelloBinding.inflate(inflater,container,false);

        helloBinding.btnClick.setOnClickListener(v ->
                helloBinding.txtData.setText(helloBinding.etName.getText().toString().trim()));

        return helloBinding.getRoot();
    }
}