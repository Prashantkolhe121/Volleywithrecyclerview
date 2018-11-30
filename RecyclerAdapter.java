package polyglotcoders.org.com.volleyapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
   ArrayList<Contact>arrayList = new ArrayList<>();

   RecyclerAdapter(ArrayList<Contact> arrayList)
   {
       this.arrayList = arrayList;
   }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
       MyViewHolder myViewHolder = new MyViewHolder(view);
       return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
       myViewHolder.name.setText(arrayList.get(position).getName());
       myViewHolder.price.setText(arrayList.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
       TextView name,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);


        }
    }
}
