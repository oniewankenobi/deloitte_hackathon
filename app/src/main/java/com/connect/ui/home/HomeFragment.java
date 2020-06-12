package com.connect.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.connect.R;
import com.connect.ui.booking.BookingActivity;
import com.connect.ui.chat.MessageActivity;
import com.connect.ui.prescription.PrescriptionActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    private LinearLayout bookingButton;
    private CardView messageButton;
    private LinearLayout prescriptionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.upcoming_app);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // vertical date scroll in home
        ArrayList<DateObject> data = new ArrayList<>();
        data.add(new DateObject("TODAY 10AM", "Scheduled checkup with Dr. Selina"));
        data.add(new DateObject("WED 8AM", "Scheduled checkup with Dr. Chris"));
        data.add(new DateObject("MON 10AM", "Scheduled checkup with Dr. Selina"));
        data.add(new DateObject("WED 8AM", "Scheduled checkup with Dr. Chris"));
        data.add(new DateObject("MON 10AM", "Scheduled checkup with Dr. Selina"));


        FragmentActivity fragmentActivity = getActivity();
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragmentActivity, LinearLayoutManager.HORIZONTAL, false);
        CustomAdapter adapter = new CustomAdapter(data);

        recyclerView = (RecyclerView) root.findViewById(R.id.rvList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        // BOOKING.
        bookingButton = (LinearLayout) root.findViewById(R.id.book_btn);
        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookingActivity();
            }
        });

        // PRESCRIPTION.
        prescriptionButton = (LinearLayout) root.findViewById(R.id.presc_btn);
        prescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPrescriptionActivity();
            }
        });

        return root;
    }

    public void openPrescriptionActivity() {
        Intent intent = new Intent(getActivity(), PrescriptionActivity.class);
        startActivity(intent);
    }

    public void openBookingActivity() {
        Intent intent = new Intent(getActivity(), BookingActivity.class);
        startActivity(intent);
    }

    public void openMessageActivity() {
        Intent intent = new Intent(getActivity(), MessageActivity.class);
        startActivity(intent);
    }

    // public void onCreate() {}
}