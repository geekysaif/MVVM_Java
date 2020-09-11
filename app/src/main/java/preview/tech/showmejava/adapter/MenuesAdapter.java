package preview.tech.showmejava.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import preview.tech.showmejava.R;
import preview.tech.showmejava.model.Hero;
import preview.tech.showmejava.model.Menues;
import preview.tech.showmejava.ui.MenuActivity;

public class MenuesAdapter extends RecyclerView.Adapter<MenuesAdapter.MenuViewHolder> {

    Context mCtx;
    List<Menues> menuesList;

    public MenuesAdapter(Context mCtx, List<Menues> menuesList) {
        this.mCtx = mCtx;
        this.menuesList = menuesList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menues hero = menuesList.get(position);

        Glide.with(mCtx)
                .load(hero.getImageurl())
                .circleCrop()
                .into(holder.imageView);

        holder.textView.setText(hero.getName());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mCtx, ""+hero.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuesList.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MenuViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}