package com.example.darkshadow.learnquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayAdapter<String> listAdapter ;
    private int viewno,chapterOnGoing;
    private ListView listView;
    ScrollView tutorialview;
    ListView chapterlistview;
    ImageView backword,forward,backwordBottom,forwardBottom;
    TextView tutorial;
    TextView chaptername,quizOnThisChapter;
    Button gridOne;
    Button gridTwo;
    LinearLayout menuGridView;
    strings strings=new strings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(MainActivity.this, homescreen.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById( R.id.chapterlistview );
        tutorialview=(ScrollView) findViewById(R.id.tutorialview);
        chapterlistview=(ListView) findViewById(R.id.chapterlistview);
        backword=(ImageView) findViewById(R.id.bacward);
        forward=(ImageView) findViewById(R.id.forward);
        backwordBottom=(ImageView) findViewById(R.id.bacwardBottom);
        forwardBottom=(ImageView) findViewById(R.id.forwardBottom);
        tutorial=(TextView) findViewById(R.id.tutorial);
        chaptername=(TextView) findViewById(R.id.chaptername);
        quizOnThisChapter=(TextView) findViewById(R.id.quizOnThisChapter);
        gridOne=(Button) findViewById(R.id.gridOne);
        gridTwo=(Button) findViewById(R.id.gridTwo);
        menuGridView=(LinearLayout) findViewById(R.id.menu);
        viewno=0;

        String[] chapters = new String[] { "Chapter one", "Chapter two", "Chapter three", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        final ArrayList<String> chapterlist = new ArrayList<String>();
        chapterlist.addAll(Arrays.asList(chapters));
        listAdapter = new ArrayAdapter<String>(this, R.layout.listview, chapterlist);
        listView.setAdapter(listAdapter);



        //
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //switchView();
                menuGridView.setVisibility(View.GONE);
                chapterlistview.setVisibility(View.GONE);
                tutorialview.setVisibility(View.VISIBLE);
                viewno=2;
                chaptername.setText(strings.chapter[position][0]);
                tutorial.setText(strings.chapter[position][1]);
                tutorialview.setScrollY(0);
                chapterOnGoing=position;
                quizOnThisChapter.setText("Quiz on "+ strings.chapter[chapterOnGoing][0]);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        backword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chapterOnGoing>0){
                    chapterOnGoing=chapterOnGoing-1;
                    backwordForwardController(0);
                    quizOnThisChapter.setText("Quiz on "+ strings.chapter[chapterOnGoing][0]);
                }
                else {
                    Toast.makeText(MainActivity.this,"Nothing Before",Toast.LENGTH_SHORT).show();
                }
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chapterOnGoing<4){
                    chapterOnGoing=chapterOnGoing+1;
                    backwordForwardController(1);
                    quizOnThisChapter.setText("Quiz on "+ strings.chapter[chapterOnGoing][0]);
                }
                else {
                    Toast.makeText(MainActivity.this,"Nothing Next",Toast.LENGTH_SHORT).show();
                }
            }
        });

        backwordBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chapterOnGoing>0){
                    chapterOnGoing=chapterOnGoing-1;
                    backwordForwardController(0);
                    quizOnThisChapter.setText("Quiz on "+ strings.chapter[chapterOnGoing][0]);
                }
                else {
                    Toast.makeText(MainActivity.this,"Nothing Before",Toast.LENGTH_SHORT).show();
                }
            }
        });
        forwardBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chapterOnGoing<4){
                    chapterOnGoing=chapterOnGoing+1;
                    backwordForwardController(1);
                    quizOnThisChapter.setText("Quiz on "+ strings.chapter[chapterOnGoing][0]);
                }
                else {
                    Toast.makeText(MainActivity.this,"Nothing Next",Toast.LENGTH_SHORT).show();
                }
            }
        });
        quizOnThisChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("chapterNumber", String.valueOf(chapterOnGoing));
                startActivity(intent);
            }
        });

        gridOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuGridView.setVisibility(View.GONE);
                chapterlistview.setVisibility(View.VISIBLE);
                tutorialview.setVisibility(View.GONE);
                viewno=1;
            }
        });
        gridTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("chapterNumber", String.valueOf(0));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (viewno==2){
            chapterlistview.setVisibility(View.VISIBLE);
            tutorialview.setVisibility(View.GONE);
            menuGridView.setVisibility(View.GONE);
            viewno=1;
        }
        else if (viewno==1){
            chapterlistview.setVisibility(View.GONE);
            tutorialview.setVisibility(View.GONE);
            menuGridView.setVisibility(View.VISIBLE);
            viewno=0;
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void switchView(){
        if(tutorialview.getVisibility()==View.GONE && chapterlistview.getVisibility()==View.GONE){
            tutorialview.setVisibility(View.GONE);
            chapterlistview.setVisibility(View.VISIBLE);
            menuGridView.setVisibility(View.GONE);
            viewno=0;
        }
        else if (menuGridView.getVisibility()==View.GONE && tutorialview.getVisibility()==View.GONE){
            tutorialview.setVisibility(View.GONE);
            chapterlistview.setVisibility(View.VISIBLE);
            menuGridView.setVisibility(View.GONE);
            viewno=1;
        }
        else {
            menuGridView.setVisibility(View.GONE);
            chapterlistview.setVisibility(View.GONE);
            tutorialview.setVisibility(View.VISIBLE);
            viewno=2;
        }
        //return viewNo; done
    }

    public void backwordForwardController(int no){
        chaptername.setText(strings.chapter[chapterOnGoing][0]);
        tutorial.setText(strings.chapter[chapterOnGoing][1]);
        tutorialview.setScrollY(0);
    }
}
