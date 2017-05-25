package com.claug.energycodesmells;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.HashMap;


public class HMUFragment extends Fragment {

  private HashMap<Integer, String> map;

  public HMUFragment() {

  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View root = inflater.inflate(R.layout.fragment_generic, container, false);

    map = new HashMap<>();

    final Button bRunTest = (Button) root.findViewById(R.id.bRunTest);
    bRunTest.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        doExperiment(v.getContext());
      }
    });

    return root;
  }

  public void doExperiment(Context context) {
    final ProgressDialog dialog = ProgressDialog
        .show(context, "Running...", "HashMap Usage", true);

    Thread thread = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < ExperimentConstants.TEST_REPETITIONS; i++) {
          map.put(i, i + " ");
          String value = map.get(i);
        }
        dialog.dismiss();
      }
    };

    thread.start();
  }

}