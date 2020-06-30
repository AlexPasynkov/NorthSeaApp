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
 * Use the {@link SushiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SushiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SushiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SushiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SushiFragment newInstance(String param1, String param2) {
        SushiFragment fragment = new SushiFragment();
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView sushiRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_roll, container, false);

        String [] sushiNames = new String [Sushi.sushis.length];
        for(int i = 0; i <sushiNames.length; i++){
            sushiNames[i] = Sushi.sushis[i].getSushiNameId();
        }

        int[] sushiImages = new int [Sushi.sushis.length];
        for(int i = 0; i < sushiImages.length; i++){
            sushiImages[i] = Sushi.sushis[i].getSushiResourceImageId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(sushiNames, sushiImages);
        sushiRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        sushiRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), SushiDetailActivity.class);
                intent.putExtra(SushiDetailActivity.EXTRA_SUSHI_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return sushiRecycler;
    }
}