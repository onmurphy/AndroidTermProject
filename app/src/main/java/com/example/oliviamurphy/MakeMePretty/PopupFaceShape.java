package com.example.oliviamurphy.MakeMePretty;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by oliviamurphy on 4/15/16.
 */
public class PopupFaceShape extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window_faceshape);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        Configuration c = getResources().getConfiguration();

        if (c.orientation == Configuration.ORIENTATION_PORTRAIT) {
            getWindow().setLayout((int) (width * .83), (int) (height * .3));
        }

        else {
            getWindow().setLayout((int) (width * .50), (int) (height * .60));
        }
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0.5f;
        getWindow().setAttributes(lp);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
}
