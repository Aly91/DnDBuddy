package dndbuddy.app.dndbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button viewCharacter, addCharacter, notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewCharacter=(Button)findViewById(R.id.viewCharacter);
        addCharacter=(Button)findViewById(R.id.addCharacter);
        notes=(Button)findViewById(R.id.notes);

        viewCharacter.setOnClickListener(this);
        addCharacter.setOnClickListener(this);
        notes.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.viewCharacter:
                Intent openCharacterSheet = new Intent(MainActivity.this,CharacterActivity.class);
                startActivity(openCharacterSheet);

                break;

            case R.id.addCharacter:
               Intent addNewCharacter = new Intent(MainActivity.this, AddCharacter.class );
                startActivity(addNewCharacter);

                break;

           case R.id.notes:
               Intent openNotes = new Intent(MainActivity.this, CampaignActivity.class);
                startActivity(openNotes);

                break;
        }


    }
}
