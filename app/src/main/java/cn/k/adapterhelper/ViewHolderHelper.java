package cn.k.adapterhelper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kaizen on 2015/8/21.
 */
public class ViewHolderHelper {


    private View mView;

    public ViewHolderHelper(View view){
        this.mView = view;
    }

    public TextView getTextView(int resId) {
        return (TextView)mView.findViewById(resId);
    }

    public ImageView getImageView(int resId) {
        return (ImageView)mView.findViewById(resId);
    }
}
