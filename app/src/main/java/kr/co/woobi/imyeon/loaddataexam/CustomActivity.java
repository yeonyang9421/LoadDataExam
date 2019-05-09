package kr.co.woobi.imyeon.loaddataexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        myView = findViewById(R.id.myview);

    }

    public void onClearClick(View view) {
        myView.clear();
    }
}
