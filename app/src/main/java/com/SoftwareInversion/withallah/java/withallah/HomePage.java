package com.SoftwareInversion.withallah.java.withallah;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.SoftwareInversion.withallah.R;
import com.SoftwareInversion.withallah.java.withallah.kebla.CompassActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.NotActiveException;
import java.net.URL;


public class HomePage extends AppCompatActivity

{
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
Intent ratemyapp;



    @Override

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_2);
        ratemyapp=new Intent(Intent.ACTION_VIEW);

      Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav=findViewById(R.id.navmenu);
        drawerLayout=findViewById(R.id.drawer);


         toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
         toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
         drawerLayout.addDrawerListener(toggle);
         toggle.syncState();
         nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item)
             {
                 switch (item.getItemId()){
                     case R.id.asmaa:
                         Intent q=new Intent(HomePage.this, AsmaaActivity.class);
                         startActivity(q);
                         drawerLayout.closeDrawer(GravityCompat.START);
                         break;

                     case R.id.keblaa:
                         startActivity(new Intent(HomePage.this, CompassActivity.class));
                         drawerLayout.closeDrawer(GravityCompat.START);
                         break;


                     case R.id.settings:

                         Intent l=new Intent(HomePage.this, Settings.class);
                         startActivity(l);
                         drawerLayout.closeDrawer(GravityCompat.START);
                         break;

                     case R.id.share:
                   Intent share=new Intent();
                   share.setAction(Intent.ACTION_SEND);
                   share.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/developer?id=Software+Inversion");
                   share.setType("text/type");
                   startActivity(Intent.createChooser(share,"share using"));
                         drawerLayout.closeDrawer(GravityCompat.START);
                         break;

                     case R.id.review:
                         startActivity(
                                 new Intent(Intent.ACTION_VIEW,
                                         Uri.parse("mailto:"+"softwareinversion0@gmail.com"+"?subject="+"message from With Allah"))
                         );
                         Toast.makeText(HomePage.this,"Thanks for your review ♥",Toast.LENGTH_LONG).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         break;
                     case R.id.about:
                         openDialog();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         break;
                     case R.id.rate:
                      try {
                          startActivity(new Intent(Intent.ACTION_VIEW,
                                  Uri.parse("market://details?id="+"com.SoftwareInversion.WithAllah")));
                      }catch (ActivityNotFoundException  e){
                          startActivity(new Intent(Intent.ACTION_VIEW,
                                  Uri.parse("https://play.google.cpm/store/apps/details?id="+"com.SoftwareInversion.WithAllah")));

                      }

                         break;

                     case R.id.apps:
                         ratemyapp.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Software+Inversion"));
                         startActivity(ratemyapp);
                         break;
                 }

                 return true;

             }
         });

        BottomNavigationView bottomNav =findViewById(R.id.botoom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DoaaFragment()).commit();



    }//end onCreate

    private void openDialog() {
        dialog exampledialog=new dialog();
        exampledialog.show(getSupportFragmentManager(),"example dialog");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedfragment = null;
                    switch (menuItem.getItemId()){

                        case R.id.nav_home:

                            selectedfragment =new DoaaFragment();

                            break;

                        case R.id.nav_favourite:

                            selectedfragment =new AzkarFragment();

                            break;

                        case R.id.nav_search:
                            selectedfragment =new QuranFragment();

                            break;
                        case R.id.nav_sebha:

                            selectedfragment =new sebhaFragment();

                            break;

                     //    case R.id.Kaaba_nav:

                      //    startActivity(new Intent(HomePage.this, CompassActivity.class));

                       //     break;

                    }//en switch

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedfragment).commit();

                    return  true;

                }// onNavigationItemSelected

            };


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){

           return true;
        }






       return onOptionsItemSelected(item);
    }//onOptionItemSelected
}//class

