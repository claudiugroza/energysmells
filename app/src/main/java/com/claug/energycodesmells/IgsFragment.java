package com.claug.energycodesmells;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class IgsFragment extends Fragment {

  /**/
  private int igsuSubject;

  public IgsFragment() {

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
        root.postDelayed(new Runnable() {
          @Override
          public void run() {
            ProgressDialog dialog = ProgressDialog
                .show(root.getContext(), "Running...", "Internal Getter Setter", true);

            for (int i = 0; i < 10000000; i++) {
              setIgsuSubject(123);
              int value = getIgsuSubject();
            }

            dialog.dismiss();
          }
        }, 0);


      }
    });

    return root;
  }

  public int getIgsuSubject() {
    return igsuSubject;
  }

  public void setIgsuSubject(int igsuSubject) {
    this.igsuSubject = igsuSubject;
  }
}
