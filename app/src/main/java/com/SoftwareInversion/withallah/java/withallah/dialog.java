package com.SoftwareInversion.withallah.java.withallah;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("المطورين").setMessage("developed by:\n"+"Seif Mohamed "+"and"+" Abdelhamed Ahmed\n"+"\n"
                +"designed by:\n"+"Mohamed Mostafa\n"+"\n"+"Follow Us:"+"page")
                .setPositiveButton("حسنا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
 return builder.create();
    }
}
