package ser210.quinnipiac.edu.assignment2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

/**
 * Created by Kyle on 4/6/2018.
 */

public class MainFragment extends Fragment {
    private ConstraintLayout mainFragmentLayout;
    private TextView textView;
    static String URL = "";
    String email = "";
    static String key = "1rigEcIEwemshBYgFlIMZTvWFlDUp1KzbaJjsnBTvsNTq3E5uT";
    private String newEnt;
    private dbHelper db;
    public MainFragment() {
        //empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        mainFragmentLayout = view.findViewById(R.id.mainFragmentLayout);
        mainFragmentLayout.setBackgroundColor(getResources().getColor(MainActivity.color));

        textView = view.findViewById(R.id.titleDescription);
        this.setFont(MainActivity.fontVal);

        db = new dbHelper(getActivity());

        Button bttn = (Button) view.findViewById(R.id.checkButton);
        bttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                v = view;
                EditText emailText = (EditText) v.findViewById(R.id.input);
                email = emailText.getText().toString().trim();
                URL = "https://pozzad-email-validator.p.mashape.com/emailvalidator/validateEmail/" + email + "?mashape-key=1rigEcIEwemshBYgFlIMZTvWFlDUp1KzbaJjsnBTvsNTq3E5uT";
                v.setEnabled(false);
                try {
                    check();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

    public void check() throws JSONException {
        new emailCheck(this).execute(URL);

    }
    public void result(Boolean valid) {
        Intent intent = new Intent(getActivity(), checkActivity.class);
        intent.putExtra("valid", valid);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    private void setFont(int fontVal){
        if(fontVal == 0){
            textView.setTypeface(Typeface.DEFAULT);
        } else if(fontVal == 1){
            textView.setTypeface(null,Typeface.BOLD);
        } else if(fontVal == 2){
            textView.setTypeface(null, Typeface.ITALIC);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option:
                return true;
            case R.id.setting:
                Intent intent = new Intent(getActivity(), settingsActivity.class);
                intent.putExtra("colorVal", MainActivity.color);
                startActivity(intent);
                return true;
            case R.id.favorite:
                EditText editText = (EditText) getView().findViewById(R.id.input);
                newEnt = editText.getText().toString().trim();
                addEntry(newEnt);
                return true;
            case R.id.display:
                Intent favIntent = new Intent(getActivity(), FavoriteActivity.class);
                startActivity(favIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addEntry(String string) {
        boolean insert = db.addEntry(string);

        if(insert)
            Toast.makeText(getActivity(), "Added to Favorites", Toast.LENGTH_LONG).show();
    }
    public void onStart() {
        super.onStart();
        mainFragmentLayout.setBackgroundColor(getResources().getColor(MainActivity.color));
        this.setFont(MainActivity.fontVal);
    }

}
