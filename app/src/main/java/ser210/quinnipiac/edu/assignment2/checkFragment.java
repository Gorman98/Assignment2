package ser210.quinnipiac.edu.assignment2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kyle on 4/6/2018.
 */

public class checkFragment extends Fragment {
    private View view;
    private TextView validCheck;
    private ImageView imageView;
    private ConstraintLayout checkLayout;

    public checkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check, container, false);
        validCheck = (TextView) view.findViewById(R.id.textView);
        imageView = (ImageView) view.findViewById(R.id.imageView);

        checkLayout = (ConstraintLayout)view.findViewById(R.id.checkLayout);
        checkLayout.setBackgroundColor(getResources().getColor(MainActivity.color));

        setFont(MainActivity.fontVal);

        Boolean valid = getActivity().getIntent().getBooleanExtra("valid", true);
        String email = getActivity().getIntent().getStringExtra("email");

        if(valid){
            validCheck.setText(email + " is a valid email!");
            imageView.setImageResource(R.drawable.check);

        } else {
            validCheck.setText(email + " is not a valid email!");
            imageView.setImageResource(R.drawable.no);
        }
        return view;
    }
    private void setFont(int fontVal) {
        if (fontVal == 0) {
            validCheck.setTypeface(Typeface.DEFAULT);
        } else if (fontVal == 1) {
            validCheck.setTypeface(null, Typeface.BOLD);
        } else if (fontVal == 2) {
            validCheck.setTypeface(null, Typeface.ITALIC);
        }
    }

}
