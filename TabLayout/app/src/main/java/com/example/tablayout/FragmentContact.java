package com.example.tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {


    View v;
    private RecyclerView recyclerView;
    private List<Contact> lstContact;
    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.contact_fragment,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recyclerViewId);
        RecyclerViewAdapter recyclerViewAdapter= new RecyclerViewAdapter(getContext(),lstContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();
        lstContact.add(new Contact("Rishad","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Alif","+88017670000000",R.drawable.rishad));
        lstContact.add(new Contact("Sayem","+880176565656",R.drawable.rishad));
        lstContact.add(new Contact("Sobuj","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Shakib","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Saif","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Sharif","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Salam","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Monir","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Mokarram","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Moyen","+8801767292882",R.drawable.rishad));
        lstContact.add(new Contact("Mohib","+8801767292882",R.drawable.rishad));
    }
}
