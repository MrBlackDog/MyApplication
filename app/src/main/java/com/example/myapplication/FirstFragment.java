package com.example.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.net.DatagramSocket;

import okhttp3.WebSocket;

public class FirstFragment extends Fragment implements WebSocketGolos.Callback {



    public static long ReciviedTime;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView textView = view.findViewById(R.id.textView2);
        final EditText editText = view.findViewById(R.id.editTextTextMultiLine2);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long xd = SystemClock.elapsedRealtimeNanos();
              MainActivity._ws.send("Ping:" + xd);

              // textView.setText();
            }
        });
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                        FirstFragmentDirections.
                                actionFirstFragmentToSecondFragment("From FirstFragment");
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(action);
            }
        });

    }
    @Override
    public void callingBack(String s) {

        System.out.println("Вызов метода обратного вызова");

    }
    public static void SetEditText(View view, String text)
    {
        final EditText editText = view.findViewById(R.id.editTextTextMultiLine2);
        long xd = SystemClock.elapsedRealtimeNanos();
        editText.setText(editText.getText() + "\n" + String.valueOf(xd));
    }


}
