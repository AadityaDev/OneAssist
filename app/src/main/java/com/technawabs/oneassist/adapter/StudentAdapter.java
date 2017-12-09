package com.technawabs.oneassist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.technawabs.oneassist.R;
import com.technawabs.oneassist.modal.Student;
import com.technawabs.oneassist.utils.StringUtils;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ConnectionViewHolder>{

    private Context context;
    private List<Student> connections;

    public StudentAdapter(@NonNull Context context, @NonNull List<Student> connections){
        this.context=context;
        this.connections=connections;
    }

    @Override
    public ConnectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);
        return new ConnectionViewHolder(context,view);
    }

    @Override
    public void onBindViewHolder(final ConnectionViewHolder holder, int position) {
        Student connection=connections.get(position);
        if(connection!=null){
            if(StringUtils.isNotEmptyOrNull(connection.getName())){
                holder.contactName.setText(connection.getName());
            }
            if(StringUtils.isNotEmptyOrNull(connection.getProfilePicture())|| URLUtil.isValidUrl(connection.getProfilePicture())){
                Picasso.with(context).load(connection.getProfilePicture()).into(holder.contactImage);
            }else {
                holder.contactImageText.setText(connection.getName());
            }
            if(StringUtils.isNotEmptyOrNull(connection.getUSRegion())){
                holder.contactNumber.setText(connection.getUSRegion());
            }
            holder.bookAppointment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date=new Date(holder.calendarView.getDate());
                    Time time=new Time(holder.timePicker.getDrawingTime());
                    Toast.makeText(context,"Booking saved for: "+date.toString()+" at "
                            +time, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return connections.size();
    }

    public static class ConnectionViewHolder extends RecyclerView.ViewHolder{

        private TextView contactName;
        private ImageView contactImage;
        private TextView contactImageText;
        private TextView contactNumber;
        private CalendarView calendarView;
        private TimePicker timePicker;
        private TextView bookAppointment;

        public ConnectionViewHolder(@NonNull Context context, @NonNull View itemView) {
            super(itemView);
            contactName=(TextView)itemView.findViewById(R.id.contact_name);
            contactImage=(ImageView)itemView.findViewById(R.id.contact_pic);
            contactImageText=(TextView)itemView.findViewById(R.id.contact_text_pic);
            contactNumber=(TextView)itemView.findViewById(R.id.contact_number);
            calendarView=(CalendarView)itemView.findViewById(R.id.calendar);
            Date date=new Date();
            calendarView.setMinDate(date.getTime());
            timePicker=(TimePicker)itemView.findViewById(R.id.time_picker);
            bookAppointment=(TextView)itemView.findViewById(R.id.book_time);
        }
    }

}
