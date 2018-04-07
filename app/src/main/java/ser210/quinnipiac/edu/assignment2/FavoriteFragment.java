package ser210.quinnipiac.edu.assignment2;

import android.app.Fragment;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kyle on 4/6/2018.
 */

public class FavoriteFragment extends ListFragment {

    private View view;
    private dbHelper db;
    private ArrayAdapter listAdapter;

    public FavoriteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }

    public void onActivityCreated(Bundle sid){
        super.onActivityCreated(sid);
        db = new dbHelper(getActivity());
        ListView listView = (ListView) view.findViewById(android.R.id.list);

        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = db.getList();

        if(cursor.getCount() == 0) {
            Toast.makeText(getActivity(), "Empty", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()){
                list.add(cursor.getString(1));
                listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,list);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
