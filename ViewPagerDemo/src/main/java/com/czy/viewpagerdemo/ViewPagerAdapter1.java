package com.czy.viewpagerdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imczy.common_util.ResUtil;
import com.imczy.common_util.io.IOUtil;
import com.imczy.common_util.log.LogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzhiyong on 15/12/6.
 */
public class ViewPagerAdapter1 extends PagerAdapter {
    public static final String TAG = ViewPagerAdapter1.class.getSimpleName();

    private List<String> mDataList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public ViewPagerAdapter1(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mDataList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            mDataList.add("data" + i);
        }
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View item = mLayoutInflater.inflate(R.layout.item_1, container, false);
        ImageView imageView = (ImageView) item.findViewById(R.id.img);
        ImageBox imgBox = (ImageBox) item.findViewById(R.id.wrap_img_box);

        if (position == 0) {
            imgBox.setClean(true);
            item.bringToFront();
            item.setAlpha(0);
        }

        int resId = ResUtil.getInstance(mContext).drawableId("p" + (position + 1));
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), resId);
        imageView.setImageBitmap(bitmap);
        container.addView(item);
        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
