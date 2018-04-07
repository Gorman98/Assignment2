package ser210.quinnipiac.edu.assignment2;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kyle on 4/6/2018.
 */

public class settingsActivity extends Activity {

    private ConstraintLayout settingsLayout;
    private Button gBtn, wBtn, bBtn;
    private Button fDBtn, fBBtn, fIBtn;
    private TextView textView;
    private int _color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        gBtn = (Button) findViewById(R.id.greenButton);
        wBtn = (Button) findViewById(R.id.whiteButton);
        bBtn = (Button) findViewById(R.id.blueButton);

        fDBtn = (Button) findViewById(R.id.fontDefButton);
        fBBtn = (Button) findViewById(R.id.fontBoldButton);
        fIBtn = (Button) findViewById(R.id.fontItalicButton);

        textView = (TextView)findViewById(R.id.settingsDescription);

        settingsLayout = (ConstraintLayout) findViewById(R.id.settingsLayout);
        _color = getIntent().getIntExtra("colorVal", 0);
        setBackground(_color);

    }

    public void onClick(View view) {
        if(view == gBtn){
            this.setBackground(R.color.green);
        } else if (view == wBtn) {
            this.setBackground(R.color.white);
        } else if (view == bBtn) {
            this.setBackground(R.color.blue);

        } else if (view == fDBtn){
            setFont(0);
        } else if (view == fBBtn) {
            setFont(1);
        } else if (view == fIBtn) {
            setFont(2);
        }
    }

    private void setBackground(int color){
        settingsLayout.setBackgroundColor(getResources().getColor(color));
        if(color == R.color.white) {
            MainActivity.setBackgroundColor(0);
        } else if(color == R.color.green) {
            MainActivity.setBackgroundColor(1);
        } else if(color == R.color.blue) {
            MainActivity.setBackgroundColor(2);
        }
    }

    private void setFont(int font){
        MainActivity.setFontVal(font);
        if(font == 0){
            textView.setTypeface(Typeface.DEFAULT);
        } else if(font == 1){
            textView.setTypeface(null,Typeface.BOLD);
        } else if(font == 2){
            textView.setTypeface(null, Typeface.ITALIC);
        }
    }

}
