package cn.k.adapterhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Kaizen on 2015/8/21.
 */
public abstract class BaseAdapterHelper<T> extends BaseAdapter {

    private Context mContext;

    private List<T> mList;

    private int mLayout;

    public BaseAdapterHelper(Context context, List<T> list, int layoutResId){
        this.mContext = context;
        this.mList = list;
        this.mLayout = layoutResId;
    }


    @Override
    public int getCount() {
        if (null == mList){
            return 0;
        }else {
            return mList.size() > 0 ? mList.size(): 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (null == mList){
            return null;
        }else {
            return mList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        if (null == mList){
            return -1;
        }else {
            return position;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            viewHolder = new ViewHolderHelper(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolderHelper) convertView.getTag();
        }
        convert(viewHolder, mList.get(position));
        return convertView;
    }

    protected abstract void convert(ViewHolderHelper helper, T data);
}
