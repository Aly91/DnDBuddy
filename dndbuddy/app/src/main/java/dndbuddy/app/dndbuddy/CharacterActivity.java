package dndbuddy.app.dndbuddy;

import android.appwidget.AppWidgetProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CharacterActivity extends AppCompatActivity {

    AppDB db;

    private TextView characterName;
    private TextView characterRace;
    private TextView cClass;
    private TextView hitPoints;
    private TextView strength;
    private TextView dexterity;
    private TextView constitution;
    private TextView intelligence;
    private TextView wisdom;
    private TextView charisma;
    private Spinner viewCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        characterName = (TextView) findViewById(R.id.displayName);
        characterRace = (TextView) findViewById(R.id.displayRace);
        cClass = (TextView) findViewById(R.id.displayclass);
        hitPoints = (TextView) findViewById(R.id.displayHitPoints);
        strength = (TextView) findViewById(R.id.displayStrength);
        dexterity = (TextView) findViewById(R.id.displayDexterity);
        constitution = (TextView) findViewById(R.id.displayConstitution);
        intelligence = (TextView) findViewById(R.id.displayIntelligence);
        wisdom = (TextView) findViewById(R.id.displayWisdom);
        charisma = (TextView) findViewById(R.id.displayCharisma);
        viewCharacter = (Spinner) findViewById(R.id.viewCharacter);

        db = new AppDB(this);

        db.open();



    }
}
