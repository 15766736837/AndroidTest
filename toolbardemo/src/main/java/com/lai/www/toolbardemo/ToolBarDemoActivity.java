package com.lai.www.toolbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class ToolBarDemoActivity extends AppCompatActivity {

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_demo);

        initViews();
        Toast.makeText(this, "修改了toast", Toast.LENGTH_SHORT).show();

        Log.e("添加了log", "添加了log");
    }

    private void initViews() {
        mToolBar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
