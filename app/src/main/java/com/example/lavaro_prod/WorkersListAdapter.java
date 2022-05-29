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

public class WorkersListAdapter extends RecyclerView.Adapter<WorkersListAdapter.WorkersViewHolder> {

    private final Context context;
    private List<Worker> workers;

    public WorkersListAdapter(Context context) {
        this.context = context;
    }

    public void setPersons(List<Worker> workers) {
        this.workers = workers;
    }

    @NonNull
    @Override
    public WorkersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("CREATE HOLDER", "create holder");
        View viewItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new WorkersViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkersViewHolder holder, int position) {
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

    class WorkersViewHolder extends RecyclerView.ViewHolder {

        public WorkersViewHolder(@NonNull View itemView) {
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
