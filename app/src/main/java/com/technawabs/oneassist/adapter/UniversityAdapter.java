package com.technawabs.oneassist.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.technawabs.oneassist.R;
import com.technawabs.oneassist.activities.OfferMapsActivity;
import com.technawabs.oneassist.constants.AppConstants;
import com.technawabs.oneassist.modal.Hotel;
import com.technawabs.oneassist.modal.Student;
import com.technawabs.oneassist.utils.StringUtils;

import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ConnectionViewHolder>{

    private Context context;
    private List<Hotel> connections;

    public UniversityAdapter(@NonNull Context context, @NonNull List<Hotel> connections){
        this.context=context;
        this.connections=connections;
    }

    @Override
    public ConnectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_card, parent, false);
        return new ConnectionViewHolder(context,view);
    }

    @Override
    public void onBindViewHolder(ConnectionViewHolder holder, int position) {
        final Hotel university=connections.get(position);
        if(university!=null){
            if(StringUtils.isNotEmptyOrNull(university.getName())){
                holder.collegeName.setText(university.getName());
            }
            if(StringUtils.isNotEmptyOrNull(university.getPictureUrl())&& URLUtil.isValidUrl(university.getPictureUrl())){
                Picasso.with(context).load(university.getPictureUrl()).into(holder.collegeImage);
            }
//            if(StringUtils.isNotEmptyOrNull(university.getCourseName())){
//                holder.courseName.setText(university.getCourseName());
//            }
            if(StringUtils.isNotEmptyOrNull(university.getDuration())){
                holder.courseDuration.setText("Friends Visited");
            }
            holder.collegeFees.setText(university.getCourseFee()+"");
            if(StringUtils.isNotEmptyOrNull(university.getLocation())){
                holder.collegeLocation.setText(university.getLocation());
            }
            if((university.getConsultants()!=null)&&(!university.getConsultants().isEmpty())){
                if((university.getConsultants().get(0)!=null)){
                    Student consultant=university.getConsultants().get(0);
                    if(URLUtil.isValidUrl(consultant.getProfilePicture())) {
                        Picasso.with(context).load(consultant.getProfilePicture()).into(holder.firstConsultantImage);
                    }else {
                        holder.firstConsultantImageText.setText(consultant.getName());
                    }
                }
                if((university.getConsultants().size()>=2)&&(university.getConsultants().get(1)!=null)){
                    Student consultant=university.getConsultants().get(1);
                    if(URLUtil.isValidUrl(consultant.getProfilePicture())) {
                        Picasso.with(context).load(consultant.getProfilePicture()).into(holder.secondConsultantImage);
                    }else {
                        holder.secondConsultantImageText.setText(consultant.getName());
                    }
                }
                if((university.getConsultants().size()>=3)&&(university.getConsultants().get(2)!=null)){
                    Student consultant=university.getConsultants().get(2);
                    if(URLUtil.isValidUrl(consultant.getProfilePicture())) {
                        Picasso.with(context).load(consultant.getProfilePicture()).into(holder.thirdConsultantImage);
                    }else {
                        holder.thirdConsultantImageText.setText(consultant.getName());
                    }
                }
                holder.bookAppointment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle=new Bundle();
                        bundle.putParcelable(AppConstants.UNIVERSITY,university);
                        Intent intent=new Intent(context,OfferMapsActivity.class);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return connections.size();
    }


    public static class ConnectionViewHolder extends RecyclerView.ViewHolder{

        private TextView collegeName;
        private ImageView collegeImage;
        private TextView collegeFees;
        private TextView collegeLocation;
        private TextView courseName;
        private TextView courseDuration;
        private ImageView firstConsultantImage;
        private TextView firstConsultantImageText;
        private ImageView secondConsultantImage;
        private TextView secondConsultantImageText;
        private ImageView thirdConsultantImage;
        private TextView thirdConsultantImageText;
        private TextView bookAppointment;

        public ConnectionViewHolder(@NonNull Context context, @NonNull View itemView) {
            super(itemView);
            collegeName=(TextView)itemView.findViewById(R.id.college_name);
            collegeImage=(ImageView)itemView.findViewById(R.id.college_image);
            collegeFees=(TextView)itemView.findViewById(R.id.college_fee);
            collegeLocation=(TextView)itemView.findViewById(R.id.college_location);
            courseName=(TextView)itemView.findViewById(R.id.course_name);
            courseDuration=(TextView)itemView.findViewById(R.id.course_duration);
            firstConsultantImage=(ImageView)itemView.findViewById(R.id.suggestion_1);
            firstConsultantImageText=(TextView) itemView.findViewById(R.id.suggestion_1_text);
            secondConsultantImage=(ImageView)itemView.findViewById(R.id.suggestion_2);
            secondConsultantImageText=(TextView) itemView.findViewById(R.id.suggestion_2_text);
            thirdConsultantImage=(ImageView)itemView.findViewById(R.id.suggestion_3);
            thirdConsultantImageText=(TextView) itemView.findViewById(R.id.suggestion_3_text);
            bookAppointment=(TextView)itemView.findViewById(R.id.booking_card);
        }
    }

}
