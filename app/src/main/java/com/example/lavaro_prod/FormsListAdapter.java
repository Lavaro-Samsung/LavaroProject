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

public class FormsListAdapter extends RecyclerView.Adapter<FormsListAdapter.FormsViewHolder> {

    private final Context context;
    private List<Capitalist> capitalists;

    public FormsListAdapter(Context context) {
        this.context = context;
    }

    public void setPersons(List<Capitalist> capitalists ) {
        this.capitalists = capitalists;
    }

    @NonNull
    @Override
    public FormsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("CREATE HOLDER", "create holder");
        View viewItem = LayoutInflater.from(context).inflate(R.layout.form_item, parent, false);
        return new FormsViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FormsViewHolder holder, int position) {
        Log.i("BIND DATA", "bind date" + position);
        Capitalist capitalist = capitalists.get(position);
        holder.setData(capitalist);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO SOMETHING HERE
            }
        });

    }
    @Override
    public int getItemCount() {
        return capitalists.size();
    }

    class FormsViewHolder extends RecyclerView.ViewHolder {

        public FormsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(Capitalist capitalist) {
            TextView login = itemView.findViewById(R.id.loginViewInFormItem);
            login.setText(capitalist.getLogin());

            TextView wage = itemView.findViewById(R.id.wageViewInFormItem);
            wage.setText(capitalist.getWage());

            TextView info = itemView.findViewById(R.id.infoViewInFormItem);
            info.setText(capitalist.getInfo());
        }
    }
}
