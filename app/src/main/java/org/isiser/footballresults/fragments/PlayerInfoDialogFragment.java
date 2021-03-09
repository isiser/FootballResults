package org.isiser.footballresults.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.isiser.footballresults.R;
import org.isiser.footballresults.models.Player;

public class PlayerInfoDialogFragment extends DialogFragment {
    private static final String TAG = "PlayerInfoDialogFragmen";

    private TextView txtPlayerInfoName, txtPlayerInfoNumber, txtPlayerInfoCountry, txtPlayerInfoType, txtPlayerInfoAge, txtPlayerInfoMatPlayed, txtPlayerInfoGolas, txtPlayerInfoYellow, txtPlayerInfoRed;
    private Button btnDismiss;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_player_info, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        txtPlayerInfoName = (TextView) view.findViewById(R.id.dialogName);
        txtPlayerInfoNumber = (TextView) view.findViewById(R.id.dialogNumber);
        txtPlayerInfoCountry = (TextView) view.findViewById(R.id.dialogCountry);
        txtPlayerInfoType = (TextView) view.findViewById(R.id.dialogType);
        txtPlayerInfoAge = (TextView) view.findViewById(R.id.dialogAge);
        txtPlayerInfoMatPlayed = (TextView) view.findViewById(R.id.dialogMatchPlayed);
        txtPlayerInfoGolas = (TextView) view.findViewById(R.id.dialogGoals);
        txtPlayerInfoYellow = (TextView) view.findViewById(R.id.dialogYellow);
        txtPlayerInfoRed = (TextView) view.findViewById(R.id.dialogRed);
        btnDismiss = (Button) view.findViewById(R.id.btnDialogPlayer);

        builder.setTitle("Player's information");
        builder.setView(view);
        
        Bundle bundle = getArguments();
        if(null != bundle){
            Player playerInfo = bundle.getParcelable("playerInfo");

            txtPlayerInfoName.setText(playerInfo.getPlayer_name());
            txtPlayerInfoNumber.setText(Integer.toString(playerInfo.getPlayer_number()));
            txtPlayerInfoCountry.setText(playerInfo.getPlayer_country());
            txtPlayerInfoType.setText(playerInfo.getPlayer_type());
            txtPlayerInfoAge.setText(Integer.toString(playerInfo.getPlayer_age()));
            txtPlayerInfoMatPlayed.setText(Integer.toString(playerInfo.getPlayer_match_played()));
            txtPlayerInfoGolas.setText(Integer.toString(playerInfo.getPlayer_goals()));
            txtPlayerInfoYellow.setText(Integer.toString(playerInfo.getPlayer_yellow_cards()));
            txtPlayerInfoRed.setText(Integer.toString(playerInfo.getPlayer_red_cards()));

            btnDismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: dismissing ...");
                    dismiss();
                }
            });

        } else {
            Log.d(TAG, "onCreateDialog: bundle is null");
        }

        setCancelable(false);
        return builder.create();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        Log.d(TAG, "onDismiss: micem..");
        super.onDismiss(dialog);
    }
}
