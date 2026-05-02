package projet.ensa.ma.convertisseurtempraturedistance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager2 viewPager1;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        tab = findViewById(R.id.tab);
        viewPager1 = findViewById(R.id.viewPager1);

        adapter = new ViewPagerAdapter(this);
        viewPager1.setAdapter(adapter);

        new TabLayoutMediator(tab, viewPager1,
                (tab, position) -> tab.setText(position == 0 ? "Température" : "Distance")
        ).attach();
    }

    // 1. On crée une méthode réutilisable pour la boîte de dialogue
    private void confirmerQuitter() {
        new AlertDialog.Builder(this)
                .setTitle("Quitter")
                .setMessage("Êtes-vous sûr de vouloir quitter l'application ?")
                .setPositiveButton("Oui", (dialog, which) -> finish())
                .setNegativeButton("Non", null)
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_quitter) {
            // 2. On appelle la confirmation ici au lieu de finish() directement
            confirmerQuitter();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        // 3. On appelle aussi la confirmation ici
        confirmerQuitter();
    }
}