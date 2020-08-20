package preview.tech.showmejava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.todkars.shimmer.ShimmerRecyclerView;
import java.util.List;
import preview.tech.showmejava.R;
import preview.tech.showmejava.adapter.MenuesAdapter;
import preview.tech.showmejava.model.Hero;
import preview.tech.showmejava.model.Menues;
import preview.tech.showmejava.viewmodel.MenuesViewModel;

public class MenuActivity extends AppCompatActivity {

    private ShimmerRecyclerView recyclerView;
    private MenuesAdapter menuesAdapter;
    private List<Menues> menuesList;
    private MenuesViewModel menuesViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setup_ui();
        setup_viewmodel();
    }

    private void setup_ui(){
        recyclerView = findViewById(R.id.recyclerview_menues);
        recyclerView.showShimmer();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setup_viewmodel(){
        menuesViewModel = ViewModelProviders.of(this).get(MenuesViewModel.class);

        menuesViewModel.getMenues().observe(this, menuesList -> {
            menuesAdapter = new MenuesAdapter(MenuActivity.this, menuesList);
            recyclerView.setAdapter(menuesAdapter);
            recyclerView.hideShimmer();
        });
    }
}
