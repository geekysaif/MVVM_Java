package preview.tech.showmejava.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.List;

import preview.tech.showmejava.R;
import preview.tech.showmejava.model.Hero;
import preview.tech.showmejava.ui.MenuActivity;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Hero> heroList;

    public HeroesAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override

    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position)
    {
        Hero hero = heroList.get(position);

        Glide.with(mCtx)
                .load(hero.getImageurl())
                .circleCrop()
                .into(holder.imageView);

        holder.textView.setText(hero.getName());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mCtx, MenuActivity.class);
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public HeroViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}