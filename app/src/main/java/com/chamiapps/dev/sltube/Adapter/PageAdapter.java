package com.chamiapps.dev.sltube.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chamiapps.dev.sltube.Fragmnets.ChannelFragment;
import com.chamiapps.dev.sltube.Fragmnets.LiveFragment;
import com.chamiapps.dev.sltube.Fragmnets.PlayListFragment;

/**
 * Created by fidenz on 3/27/18.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    int mnoOftabs;

    public PageAdapter(FragmentManager fm, int noOftabs) {

        super(fm);
        this.mnoOftabs = noOftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                ChannelFragment tab1 = new ChannelFragment();
                return tab1;
            case 1:

                PlayListFragment tab2 = new PlayListFragment();
                return tab2;
            case 2:
                LiveFragment tab3 = new LiveFragment();
                return tab3;
            case 3:
            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return mnoOftabs;
    }
}
