package in.rajesh.viewbinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.rajesh.viewbinding.databinding.ItemLayoutBinding;

public class AdaptorDataList extends RecyclerView.Adapter<AdaptorDataList.MyHolder> {

    Context context;
    ArrayList<ModelItem> modelItems;

    public AdaptorDataList(Context context, ArrayList<ModelItem> modelItems) {
        this.context = context;
        this.modelItems = modelItems;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.getRootView().getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.layoutBinding.person.setImageResource(modelItems.get(position).getImage());
        holder.layoutBinding.txtName.setText(modelItems.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return modelItems == null ? 0 :
                modelItems.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ItemLayoutBinding layoutBinding;
        public MyHolder(@NonNull ItemLayoutBinding layoutBinding) {
            super(layoutBinding.getRoot());
            this.layoutBinding=layoutBinding;
        }
    }
}
