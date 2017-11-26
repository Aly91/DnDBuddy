package dndbuddy.app.dndbuddy;

import android.appwidget.AppWidgetProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CharacterActivity extends AppCompatActivity {

    AppDB db;

   private TextView name;
   private TextView race;
    private TextView cClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        name = (TextView) findViewById(R.id.displayName);
        race = (TextView) findViewById(R.id.displayRace);
        cClass = (TextView) findViewById(R.id.displayclass);

        db = new AppDB(this);

        db.open();
    }
}
