package ser210.quinnipiac.edu.assignment2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kyle on 4/6/2018.
 */

public class checkActivity extends Activity {

    private FragmentTransaction checkFragmentTrans;
    private FragmentManager checkFragmentMan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        ActionBar acBar = getActionBar();
        acBar.setDisplayHomeAsUpEnabled(true);

        checkFragmentMan = getFragmentManager();
        checkFragmentTrans = checkFragmentMan.beginTransaction();
        checkFragmentTrans.add(R.id.checkLayout, new checkFragment());
        checkFragmentTrans.commit();


    }

}
