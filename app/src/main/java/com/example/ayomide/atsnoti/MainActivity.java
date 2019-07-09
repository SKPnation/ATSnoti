package com.example.ayomide.atsnoti;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ayomide.atsnoti.Adapter.PupilGroupAdapter;
import com.example.ayomide.atsnoti.Interface.IFirebaseLoadListener;
import com.example.ayomide.atsnoti.Model.PupilData;
import com.example.ayomide.atsnoti.Model.PupilGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IFirebaseLoadListener {

    FirebaseDatabase db;
    DatabaseReference pupilCategory;

    RecyclerView recycler_view;

    IFirebaseLoadListener iFirebaseLoadListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        toolbar.setTitle( "Adorable Pupils" );
        setSupportActionBar( toolbar );

        //init Firebase
        db = FirebaseDatabase.getInstance();
        pupilCategory = db.getReference("Category");
        iFirebaseLoadListener = this;

        //load pupil Groups list
        getFirebaseData();

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        recycler_view = findViewById( R.id.recycler_view );
        recycler_view.setHasFixedSize( true );
        recycler_view.setLayoutManager( new LinearLayoutManager(this) );
    }

    private void getFirebaseData() {
        pupilCategory.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<PupilGroup> pupilGroups = new ArrayList<>();
                for(DataSnapshot groupSnapshot: dataSnapshot.getChildren())
                {
                    PupilGroup pupilGroup = new PupilGroup();
                    pupilGroup.setHeaderTitle( groupSnapshot.child( "headerTitle" ).getValue().toString() );
                    GenericTypeIndicator<ArrayList<PupilData>> genericTypeIndicator = new GenericTypeIndicator<ArrayList<PupilData>>(){};
                    pupilGroup.setListPupil( groupSnapshot.child( "listPupil" ).getValue(genericTypeIndicator) );
                    pupilGroups.add( pupilGroup );
                }
                iFirebaseLoadListener.onFirebaseLoadSuccess( pupilGroups );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iFirebaseLoadListener.onFirebaseLoadFailed( databaseError.getMessage() );
            }
        });
    }

    @Override
    public void onFirebaseLoadSuccess(List<PupilGroup> pupilGroupList) {
        PupilGroupAdapter pupilGroupAdapter = new PupilGroupAdapter(this, pupilGroupList);
        recycler_view.setAdapter( pupilGroupAdapter );
    }

    @Override
    public void onFirebaseLoadFailed(String message) {
        Toast.makeText( this, message, Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.pupils) {
            // Handle the camera action
        } else if (id == R.id.feedBacks) {

        } else if (id == R.id.status) {

        } else if (id == R.id.sign_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}