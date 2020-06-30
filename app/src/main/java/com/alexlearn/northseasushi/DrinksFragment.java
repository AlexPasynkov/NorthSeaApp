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
 * Use the {@link DrinksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DrinksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinksFragment newInstance(String param1, String param2) {
        DrinksFragment fragment = new DrinksFragment();
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
        RecyclerView drinkRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_roll, container, false);

        String[] drinkNames = new String [Drink.drinks.length];
        for(int i = 0; i <drinkNames.length; i++){
            drinkNames[i] = Drink.drinks[i].getDrinkNameId();
        }

        int[] drinkImages = new int [Drink.drinks.length];
        for(int i = 0; i < drinkImages.length; i++){
            drinkImages[i] = Drink.drinks[i].getDrinkResourceImageId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(drinkNames, drinkImages);
        drinkRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        drinkRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DrinkDetailActivity.class);
                intent.putExtra(DrinkDetailActivity.EXTRA_DRINK_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return drinkRecycler;
    }
}