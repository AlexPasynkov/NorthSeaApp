package com.alexlearn.northseasushi;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RollFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RollFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RollFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RollFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RollFragment newInstance(String param1, String param2) {
        RollFragment fragment = new RollFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView rollRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_roll, container, false);

        String [] rollsNames = new String [Rolls.japanRolls.length];
        for(int i = 0; i <rollsNames.length; i++){
            rollsNames[i] = Rolls.japanRolls[i].getRollNameId();
        }

        int[] rollsImages = new int [Rolls.japanRolls.length];
        for(int i = 0; i < rollsImages.length; i++){
            rollsImages[i] = Rolls.japanRolls[i].getResourceImageId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(rollsNames, rollsImages);
        rollRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        rollRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), RollDetailActivity.class);
                intent.putExtra(RollDetailActivity.EXTRA_ROLL_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return rollRecycler;
    }
}