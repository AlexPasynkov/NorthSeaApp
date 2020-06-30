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
 * Use the {@link SoupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SoupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SoupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SoupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SoupFragment newInstance(String param1, String param2) {
        SoupFragment fragment = new SoupFragment();
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
        RecyclerView soupRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_roll, container, false);

        String [] soupNames = new String [Soup.soups.length];
        for(int i = 0; i <soupNames.length; i++){
            soupNames[i] = Soup.soups[i].getSoupNameId();
    }

        int[] soupImages = new int [Soup.soups.length];
        for(int i = 0; i < soupImages.length; i++){
            soupImages[i] =Soup.soups[i].getSoupResourceImageId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(soupNames, soupImages);
        soupRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        soupRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), SoupDetailActivity.class);
                intent.putExtra(SoupDetailActivity.EXTRA_SOUP_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return soupRecycler;
    }
}