package dndbuddy.app.dndbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddCharacter extends AppCompatActivity {

    AppDB db;
    private EditText enterName;
    private EditText enterClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);
    }
}
