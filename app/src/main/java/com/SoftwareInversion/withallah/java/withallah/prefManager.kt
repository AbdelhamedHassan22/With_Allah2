package com.SoftwareInversion.withallah.java.withallah

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.SoftwareInversion.withallah.R

class prefManager {
    lateinit var con:Context
    lateinit var pref:SharedPreferences
    constructor(con:Context){
        this.con=con
        getsp()
    }

    private fun getsp() {
        pref=con.getSharedPreferences(con.getString(R.string.pref_name),Context.MODE_PRIVATE)
    }
    fun writesp(){
        var editor:SharedPreferences.Editor=pref.edit()
        editor.putString(con.getString(R.string.pref_key),"NEXT")
        editor.commit()
    }
    fun checkpref():Boolean{
        var status:Boolean=false
        if (pref.getString(con.getString(R.string.pref_key),"null").equals("null")){
            status=false
        }else{
            status=true
        }
        return status
    }
    fun clearpref(){
        pref.edit().clear().commit()
        con.startActivity(Intent(con,MainActivityIntro::class.java))
        (con as AppCompatActivity).finish()
    }

}