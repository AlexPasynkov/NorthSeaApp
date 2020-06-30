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
 * Use the {@link DesertsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesertsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DesertsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DesertsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DesertsFragment newInstance(String param1, String param2) {
        DesertsFragment fragment = new DesertsFragment();
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
        RecyclerView desertsRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_roll, container, false);

        String [] desertsNames = new String [Desert.deserts.length];
        for(int i = 0; i <desertsNames.length; i++){
            desertsNames[i] = Desert.deserts[i].getDesertNameId();
        }

        int[] desertImages = new int [Desert.deserts.length];
        for(int i = 0; i < desertImages.length; i++){
            desertImages[i] = Desert.deserts[i].getDesertResourceImageId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(desertsNames, desertImages);
        desertsRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        desertsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DesertDetailActivity.class);
                intent.putExtra(DesertDetailActivity.EXTRA_DESERT_ID, position);
                getActivity().startActivity(intent);

            }
        });
        return desertsRecycler;
    }
}