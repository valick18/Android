package Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.food.MainActivity;
import com.example.food.R;

public class ExitFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.titleBar.setText("Вихід");
      AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Вихід");
        alertDialog.setMessage("Ви впевненні, що хочете вийти?");
        alertDialog.setCancelable(true).setPositiveButton("Так", (dialogConfirm, index)-> System.exit(0));
        alertDialog.setNegativeButton("Ні", (cancelDialog,ind)-> cancelDialog.cancel()).create().show();
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onResume(){
        super.onResume();
        MainActivity.titleBar.setText("Вихід");
    }
}
