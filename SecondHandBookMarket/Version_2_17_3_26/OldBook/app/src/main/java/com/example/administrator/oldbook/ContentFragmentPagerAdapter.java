package com.example.administrator.oldbook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ContentFragmentPagerAdapter extends FragmentPagerAdapter
{
    private ArrayList<Fragment> fragmentsList;

    public ContentFragmentPagerAdapter(FragmentManager fragmentManager,ArrayList<Fragment> fragmentsList)
    {
        super(fragmentManager);
        this.fragmentsList = fragmentsList;
    }

    @Override
    public Fragment getItem(int position)
    {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount()
    {
        return fragmentsList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        super.destroyItem(container,position,object);
    }
}
