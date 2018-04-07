package ser210.quinnipiac.edu.assignment2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

/**
 * Created by Kyle on 4/6/2018.
 */

public class MainActivity extends Activity {

    private ShareActionProvider shareActionProvider;
    private FragmentTransaction mainFragmentTrainscation;
    private FragmentManager mainFragmentManager;
    public static int color;
    public static int fontVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragmentManager = getFragmentManager();
        mainFragmentTrainscation = mainFragmentManager.beginTransaction();
        mainFragmentTrainscation.add(R.id.mainLayout, new MainFragment());
        mainFragmentTrainscation.commit();

        color = R.color.white;
        fontVal = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        setIntent("Download the app today!");
        return super.onCreateOptionsMenu(menu);
    }

    private void setIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    public static void setBackgroundColor(int i){
        if(i == 0){
            color = R.color.white;
        } else if (i == 1){
            color = R.color.green;
        } else if (i == 2) {
            color = R.color.blue;
        }
    }

    public static void setFontVal(int i){
        fontVal = i;
    }


}
