package ser210.quinnipiac.edu.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
    static String URL = "";
    String email = "";
    static String key = "1rigEcIEwemshBYgFlIMZTvWFlDUp1KzbaJjsnBTvsNTq3E5uT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void startClick(View view) throws JSONException {
        EditText emailText = (EditText) findViewById(R.id.input);
        email = emailText.getText().toString().trim();
        URL = "https://pozzad-email-validator.p.mashape.com/emailvalidator/validateEmail/"+ email +"?mashape-key=1rigEcIEwemshBYgFlIMZTvWFlDUp1KzbaJjsnBTvsNTq3E5uT";

        new emailCheck(this).execute(URL);
    }

    public void result (Boolean valid) {
        Intent intent = new Intent(this, checkActivity.class);
        intent.putExtra("valid", valid);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}
