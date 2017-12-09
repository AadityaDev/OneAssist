package com.technawabs.oneassist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.technawabs.oneassist.R;
import com.technawabs.oneassist.adapter.HotelAdapter;
import com.technawabs.oneassist.modal.Friends;
import com.technawabs.oneassist.modal.Hotel;
import com.technawabs.oneassist.modal.UserDetails;
import com.technawabs.oneassist.preferences.UserStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private List<Hotel> hotels;
    private List<Hotel> hotelList;
    private HotelAdapter connectionAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionMenu menuRed;
    private UserDetails userDetails = new UserDetails();
    private UserStore userStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent i = getIntent();
        if (i != null) {
            userDetails = i.getParcelableExtra("user");
            userStore = new UserStore(getApplicationContext());
            if (userDetails != null) {
                userStore.saveName(userDetails.getName());
                userStore.saveEmail(userDetails.getEmail());
            }
        }
        menuRed = (FloatingActionMenu) findViewById(R.id.menu_red);
//        final FloatingActionButton programFab1 = new FloatingActionButton(getApplicationContext());
//        programFab1.setButtonSize(FloatingActionButton.SIZE_MINI);
//        programFab1.setLabelText("Course");
//        programFab1.setImageResource(R.mipmap.ic_course);
//        menuRed.addMenuButton(programFab1);
//        programFab1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Collections.sort(hotelList,Hotel.COURSECOMPARATOR);
//                menuRed.close(true);
//            }
//        });
        final FloatingActionButton programFab2 = new FloatingActionButton(getApplicationContext());
        programFab2.setButtonSize(FloatingActionButton.SIZE_MINI);
        programFab2.setLabelText("Name");
        programFab2.setImageResource(R.mipmap.ic_sort_round);
        menuRed.addMenuButton(programFab2);
        programFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(hotelList, Hotel.NAMECOMPARATOR);
                menuRed.close(true);
            }
        });
        final FloatingActionButton programFab3 = new FloatingActionButton(getApplicationContext());
        programFab3.setButtonSize(FloatingActionButton.SIZE_MINI);
        programFab3.setLabelText("Discount");
        programFab3.setImageResource(R.mipmap.ic_launcher_round);
        menuRed.addMenuButton(programFab3);
        programFab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(hotelList, Hotel.FEECOMPARATOR);
                menuRed.close(true);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.universities_list);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        hotelList = new ArrayList<>();
        connectionAdapter = new HotelAdapter(getApplicationContext(), hotelList);
        //Read Data
        initialize();
        readContacts();
        recyclerView.setAdapter(connectionAdapter);
    }

    private void initialize() {
        hotels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Hotel university = new Hotel();
            university.setName("Pizza Hut " + i);
            university.setCity("Delhi " + i);
            university.setCourseFee(i*10 + 500);
            university.setCourseId(Long.valueOf(i));
            university.setDuration(i + " years");
            university.setLocation("Address " + i);
            university.setPictureUrl("");
            List<Friends> consultants = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Friends student = new Friends();
                student.setId(Long.valueOf(j));
                student.setName("Name" + j);
                student.setProfilePicture("");
                consultants.add(student);
            }
            university.setConsultants(consultants);
            hotels.add(university);
        }
    }

    private void readContacts() {
        hotelList.addAll(hotels);
        connectionAdapter.notifyDataSetChanged();
    }

}
