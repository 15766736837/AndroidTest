package com.lai.www.recyclerviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Lai on 2018/9/10.
 * 自定义分割线
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    //分割线的资源
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private Drawable mDivider;  //分割线样式
    private int mOrientation;   //方向

    public DividerItemDecoration(Context context, int orientation) {
        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        mDivider = typedArray.getDrawable(0);
        setOrientation(orientation);
    }

    //设置分割线方向
    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("非法参数异常");
        }

        mOrientation = orientation;
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View childAt = parent.getChildAt(i);
            //RecyclerView 的 item布局参数
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            final int top = childAt.getBottom() + layoutParams.bottomMargin;    //item的底部位置
            final int bottom = top + mDivider.getIntrinsicHeight();             //线的底部位置
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
