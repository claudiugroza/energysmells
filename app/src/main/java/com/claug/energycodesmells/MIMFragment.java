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
import java.util.Calendar;

public class MIMFragment extends Fragment {

  public MIMFragment() {
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
        doExperiment(root.getContext());
      }
    });

    return root;
  }

  public void doExperiment(Context context) {
    final ProgressDialog dialog = ProgressDialog
        .show(context, "Running...", "Member Ignoring Method", true);

    Thread thread = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 100000000; i++) {
          Calendar calendar = getYesterday();
        }
        dialog.dismiss();
      }
    };

    thread.start();
  }

  public Calendar getYesterday() {
    final Calendar yesterdayToBe = Calendar.getInstance();
    yesterdayToBe.add(Calendar.DATE, -1);

    return yesterdayToBe;
  }

}
