package ser210.quinnipiac.edu.assignment2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.support.constraint.ConstraintLayout;

/**
 * Created by Kyle on 4/6/2018.
 */

public class FavoriteActivity extends Activity {

    private dbHelper db;
    private FragmentTransaction favFragmentTrans;
    private FragmentManager favFragmentMan;
    private ConstraintLayout favLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        db = new dbHelper(this);

        favFragmentMan = getFragmentManager();
        favFragmentTrans = favFragmentMan.beginTransaction();
        favFragmentTrans.add(R.id.favLayout, new FavoriteFragment());
        favFragmentTrans.commit();

        favLayout = (ConstraintLayout) findViewById(R.id.favLayout);
        favLayout.setBackgroundColor(MainActivity.color);
    }

}
