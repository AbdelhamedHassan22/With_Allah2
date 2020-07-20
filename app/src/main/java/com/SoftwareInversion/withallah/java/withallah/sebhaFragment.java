package com.SoftwareInversion.withallah.java.withallah;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.SoftwareInversion.withallah.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class sebhaFragment extends Fragment  {
     ImageView plus;
     TextView textView;
     private int anInt=0;
     FloatingActionButton reset;
     FloatingActionButton add;
     String[] listitems;
     TextView mtextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_sebha, container, false);
    }//end On Create view

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        reset=view.findViewById(R.id.reset);
        plus=view.findViewById(R.id.plus);
         add=view.findViewById(R.id.addSelectedChoice);
        textView=view.findViewById(R.id.counter);
       mtextView=view.findViewById(R.id.text1);




        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anInt++;
                textView.setText(Integer.toString(anInt));
            }//end onclickplus
        });

      reset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        anInt=0;
        textView.setText(Integer.toString(anInt));


           }
      });
      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              listitems=new String[]{
                      "الحمدلله"
                      ,"الْلَّهُ أَكْبَرُ"
                      ,"سُبْحَانَ اللَّهِ"
                      ,"استغفر الله"
                      ,"سُبْحَانَ اللَّهِ وَالْحَمْدُ لِلَّهِ"
                      ,"سُبْحَانَ الْمَلِكِ الْقُدُّوسِ"
                      ,"سُبْحَانَ اللَّهِ الْعَظِيمِ وَبِحَمْدِهِ"
                      ,"اللهم صلي وسلم علي سيدنا محمد"
                      ,"اللهم انك عفو تحب العفو فاعفو عنا"
                      ,"سُبْحَانَ ذِي الْجَبَرُوتِ وَالْمَلَكُوتِ وَالْكِبْرِيَاءِ وَالْعَظَمَةِ"
                      ,"اللهم لا إله لا انت سبحانك اني كنت من الظالمين"

              };
              AlertDialog.Builder mBuilder =new AlertDialog.Builder(getActivity());
              mBuilder.setTitle("اختار");
              mBuilder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      mtextView.setText(listitems[i]);
                      dialogInterface.dismiss();
                  }
              });
              mBuilder.setNeutralButton("الغاء", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {

                  }
              });
              AlertDialog mdialog =mBuilder.create();
              mdialog.show();

          }
      });

      if(textView.getText()=="33"){
         Toast.makeText(getContext(),"اللهم تقبل",Toast.LENGTH_LONG).show();


      }

        if(anInt==100){
            Toast.makeText(getContext(),"اللهم تقبل",Toast.LENGTH_LONG).show();


        }
    }
}//end class
