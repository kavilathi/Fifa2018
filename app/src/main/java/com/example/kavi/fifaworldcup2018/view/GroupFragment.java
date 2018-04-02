package com.example.kavi.fifaworldcup2018.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kavi.fifaworldcup2018.R;
import com.example.kavi.fifaworldcup2018.model.Group;
import com.example.kavi.fifaworldcup2018.model.Team;
import com.example.kavi.fifaworldcup2018.utils.TeamList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kavi on 3/21/2018.
 */

public class GroupFragment extends Fragment {

    private Fragment groupFragment;
    private View rootView;
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   {
       rootView = inflater.inflate(R.layout.fragment_group, container, false);

       ArrayList<Group> groupList = TeamList.getGroupList();



       final CustomGroupAdapter adapter = new CustomGroupAdapter(getActivity(),groupList);

       ListView listView = rootView.findViewById(R.id.group_list_view);

       listView.setAdapter(adapter);

       return rootView;
   }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Group");
    }

}
