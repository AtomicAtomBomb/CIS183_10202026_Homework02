package com.example.cis183_homework01_10_20_2026;

import android.graphics.Color;

public class ColorInfo
{
    private int rValue;
    private int gValue;
    private int bValue;
    private String hexValue;


    public ColorInfo()
    {

    }

    public ColorInfo(int r, int g, int b, String h)
    {
        rValue = r;
        gValue = g;
        bValue = b;
        hexValue = h;
    }

    public int getrValue()
    {
        return rValue;
    }

    public void setrValue(int rValue)
    {
        this.rValue = rValue;
    }

    public int getgValue()
    {
        return gValue;
    }

    public void setgValue(int gValue)
    {
        this.gValue = gValue;
    }

    public int getbValue()
    {
        return bValue;
    }

    public void setbValue(int bValue)
    {
        this.bValue = bValue;
    }

    public String getHexValue()
    {
        return hexValue;
    }

    public void setHexValue(String hexValue)
    {
        this.hexValue = hexValue;
    }
}
