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

public class IGSFragment extends Fragment {

  /**/
  private int igsuSubject;

  public IGSFragment() {

  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View root = inflater.inflate(R.layout.fragment_generic, container, false);

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
        .show(context, "Running...", "Internal Getter/Setter", true);

    Thread thread = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < ExperimentConstants.IGS_TEST_REPETITIONS; i++) {
          runSmell(i);
        }
        dialog.dismiss();
      }
    };

    thread.start();
  }

  private void runSmell(int i) {
    this.igsuSubject = i;
    int value = igsuSubject;
  }

  public int getIgsuSubject() {
    return igsuSubject;
  }

  public void setIgsuSubject(int igsuSubject) {
    this.igsuSubject = igsuSubject;
  }

}
