package in.rajesh.viewbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import in.rajesh.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    AdaptorDataList adaptorDataList;
    ArrayList<ModelItem> modelItems;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=activityMainBinding.getRoot();
        setContentView(view);

        layoutManager=new LinearLayoutManager(this);
        activityMainBinding.recyclerDataList.setLayoutManager(layoutManager);

        activityMainBinding.btnClicck.setOnClickListener(v -> {
            String name=activityMainBinding.etName.getText().toString().trim();
            if (name.isEmpty()){
                activityMainBinding.etName.setError("Enter Name");
                activityMainBinding.etName.requestFocus();
                return;
            }else {
                Intent intent=new Intent(getApplicationContext(),SecondActivty.class);
                startActivity(intent);
                activityMainBinding.txtData.setText(name);
            }
        });

        getDataList();

    }

    private void getDataList() {
        modelItems=new ArrayList<>();
        modelItems.add(new ModelItem(R.drawable.ic_baseline_person_24,"Kamal Singh"));
        modelItems.add(new ModelItem(R.drawable.ic_baseline_person_24,"Vimal Singh"));
        modelItems.add(new ModelItem(R.drawable.ic_baseline_person_24,"Gomal Singh"));

        adaptorDataList=new AdaptorDataList(getApplicationContext(),modelItems);
        activityMainBinding.recyclerDataList.setAdapter(adaptorDataList);
    }
}