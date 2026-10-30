package com.example.cis183_homework01_10_20_2026;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.colorlistviewcell, null);
        }

        //GUI elements
        TextView rValue = view.findViewById(R.id.tv_v_cell_rvalue);
        TextView gValue = view.findViewById(R.id.tv_v_cell_gvalue);
        TextView bValue = view.findViewById(R.id.tv_v_cell_bvalue);
        TextView hexValue = view.findViewById(R.id.tv_v_cell_hexvalue);

        ColorInfo colors = listOfColors.get(i);

        rValue.setText("Red: " + Integer.toString(colors.getrValue()));
        gValue.setText("Green: " + Integer.toString(colors.getgValue()));
        bValue.setText("Blue: " + Integer.toString(colors.getbValue()));
        hexValue.setText("Hex Value: " + Integer.toHexString(colors.getrValue()) + Integer.toHexString(colors.getgValue()) + Integer.toHexString(colors.getbValue()));
        view.setBackgroundColor(Color.rgb(colors.getrValue(),colors.getgValue(),colors.getbValue()));
        if (colors.getrValue() == 0 && colors.getgValue() <= 125 && colors.getbValue() <= 255)
        {
            rValue.setTextColor(Color.rgb(255,255,255));
            gValue.setTextColor(Color.rgb(255,255,255));
            bValue.setTextColor(Color.rgb(255,255,255));
            hexValue.setTextColor(Color.rgb(255,255,255));
        }
        return view;
    }
}
