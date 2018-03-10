package ser210.quinnipiac.edu.assignment2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class checkActivity extends AppCompatActivity {

    TextView validCheck;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        Boolean valid = getIntent().getBooleanExtra("valid", true);
        String email = getIntent().getStringExtra("email");
        validCheck = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        if(valid){
            validCheck.setText(email + "is a valid email!");
            imageView.setImageResource(R.drawable.check);

        } else {
            validCheck.setText(email + "is not a valid email!");
            imageView.setImageResource(R.drawable.no);
        }
    }

}
