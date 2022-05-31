package com.example.lavaro_prod;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FormsListAdapter extends RecyclerView.Adapter<FormsListAdapter.FormsViewHolder> {

    private final Context context;
    private List<Capitalist> capitalists;
    private String userName;

    public FormsListAdapter(Context context, String capName) {
        this.context = context;
        this.userName = capName;
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
               Intent goToForm = new Intent(context, FormActivity.class);
                goToForm.putExtra("isCapitalist", context.getClass().getName().equals("FormShowActivity"));
                goToForm.putExtra("login", capitalist.login);
                goToForm.putExtra("canRedact", false);
                goToForm.putExtra("userName", userName);
               context.startActivity(goToForm);
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
