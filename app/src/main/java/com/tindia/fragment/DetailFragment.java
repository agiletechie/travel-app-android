package com.tindia.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tindia.R;
import com.tindia.activity.DetailActivity;
import com.tindia.adapter.DetailDescAdapter;
import com.tindia.model.Destination;
import com.tindia.model.DetailPlace;
import com.tindia.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private final String TAG = DetailActivity.class.getSimpleName();
    private List<DetailPlace> detailPlaceList;
    private Destination destination;
    private RecyclerView recyclerView;

    boolean isCollapsed = true;

    private static final String DETAIL_PLACES_LIST = "DETAIL_PLACES_LIST";

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetailFragment.
     */
    public static DetailFragment newInstance(List<DetailPlace> detailPlaceList, Destination destination) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(DETAIL_PLACES_LIST, (ArrayList<? extends Parcelable>) detailPlaceList);
        args.putParcelable(AppConstants.DEST_RESPONSE, destination);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            detailPlaceList = getArguments().getParcelableArrayList(DETAIL_PLACES_LIST);
            destination = getArguments().getParcelable(AppConstants.DEST_RESPONSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment\
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView_detail);
        DetailDescAdapter detailDescAdapter = new DetailDescAdapter(detailPlaceList, getActivity().getApplicationContext());
        recyclerView.setAdapter(detailDescAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}