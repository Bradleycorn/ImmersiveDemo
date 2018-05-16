package net.bradball.android.immersivedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button mUIToggle;

    private boolean mIsImmersiveEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUIToggle = findViewById(R.id.ui_toggle);
        mUIToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImmersiveMode();
            }
        });
    }

    private void toggleImmersiveMode() {
        View decorView = getWindow().getDecorView();

        if (mIsImmersiveEnabled) {
            toolbar.setVisibility(View.VISIBLE);
            decorView.setSystemUiVisibility(View.VISIBLE);
        } else {
            // Immersive Mode is off, turn it on.
            toolbar.setVisibility(View.GONE);
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                    // Set the content to appear under the system bars so that the
                    // content doesn't resize when the system bars hide and show.
                  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                  | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                  | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // Hide the nav bar and status bar
                  | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                  | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }

        mIsImmersiveEnabled = !mIsImmersiveEnabled;

    }

}
