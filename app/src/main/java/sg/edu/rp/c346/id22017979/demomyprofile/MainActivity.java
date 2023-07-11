package sg.edu.rp.c346.id22017979.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGPA = findViewById(R.id.editTextGPA);
        etName = findViewById(R.id.editTextName);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Name", strName);
        prefEdit.commit();

        Float floatGPA = Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefsGpa = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEditGpa = prefsGpa.edit();
        prefEdit.putFloat("GPA", floatGPA);
        prefEdit.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String msg = prefs.getString("Name","John");
        etName.setText(msg);

        SharedPreferences prefsGpa = getPreferences(MODE_PRIVATE);
        Float gpa = prefsGpa.getFloat("GPA", 0.00f);
        etGPA.setText(String.valueOf(gpa));;


    }
}