package preview.tech.showmejava.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.todkars.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.List;

import preview.tech.showmejava.R;
import preview.tech.showmejava.adapter.HeroesAdapter;
import preview.tech.showmejava.model.Hero;
import preview.tech.showmejava.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ShimmerRecyclerView recyclerView;
    private HeroesAdapter heroesAdapter;
    private List<Hero> heroList;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup_ui();
        setup_viewmodel();

    }

    private void setup_ui(){
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.showShimmer();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setup_viewmodel(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getHeroes().observe(this, heroList -> {
            heroesAdapter = new HeroesAdapter(MainActivity.this, heroList);
            recyclerView.setAdapter(heroesAdapter);
            recyclerView.hideShimmer();
        });
    }
}

