package com.example.lavaro_prod;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private int a = 1;
    private List<Worker> workers;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setPersons(List<Worker> workers) {
        this.workers = workers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("CREATE HOLDER", "create holder");
        View viewItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i("BIND DATA", "bind date" + position);
        Worker worker = workers.get(position);
        holder.setData(worker);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Yep! You clicked", Toast.LENGTH_LONG).show();
                Intent goToTheProfile = new Intent(context, ProfileActivity.class);
                goToTheProfile.putExtra("login", worker.getLogin());
                goToTheProfile.putExtra("info", worker.getInfo());

                context.startActivity(goToTheProfile);
            }
        });

    }

    @Override
    public int getItemCount() {
        return workers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(Worker worker) {
            TextView login = itemView.findViewById(R.id.loginView);
            login.setText(worker.getLogin());

            TextView info = itemView.findViewById(R.id.infoView);
            info.setText(worker.getInfo());
        }
    }
}
