package com.claug.energycodesmells;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.navigation_hmu:
          getSupportFragmentManager().beginTransaction().replace(R.id.content, new HMUFragment()).commit();
          return true;
        case R.id.navigation_igsu:
          getSupportFragmentManager().beginTransaction().replace(R.id.content, new IGSFragment()).commit();
          return true;
        case R.id.navigation_mim:
          getSupportFragmentManager().beginTransaction().replace(R.id.content, new MIMFragment()).commit();
          return true;
      }
      return false;
    }

  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    navigation.setSelectedItemId(R.id.navigation_hmu);
  }

}
