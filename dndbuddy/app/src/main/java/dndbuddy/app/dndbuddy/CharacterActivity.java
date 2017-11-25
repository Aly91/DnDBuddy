package dndbuddy.app.dndbuddy;

import android.appwidget.AppWidgetProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CharacterActivity extends AppCompatActivity {

    AppDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        db = new AppDB(this);

        db.open();
    }
}
