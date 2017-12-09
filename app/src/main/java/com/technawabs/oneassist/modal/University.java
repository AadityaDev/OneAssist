package com.technawabs.oneassist.modal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.List;

public class University implements Parcelable,Comparable<University> {

    private Long id;
    private String name;
    private String location;
    private String pictureUrl;
    private String city;
    private double courseFee;
    private String duration;
    private Long courseId;
    private String courseName;
    private List<Student> consultants;

    public University(){

    }

    protected University(Parcel in) {
        name = in.readString();
        location = in.readString();
        pictureUrl = in.readString();
        city = in.readString();
        courseFee = in.readDouble();
        duration = in.readString();
        courseName = in.readString();
        consultants = in.createTypedArrayList(Student.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(pictureUrl);
        dest.writeString(city);
        dest.writeDouble(courseFee);
        dest.writeString(duration);
        dest.writeString(courseName);
        dest.writeTypedList(consultants);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<University> CREATOR = new Creator<University>() {
        @Override
        public University createFromParcel(Parcel in) {
            return new University(in);
        }

        @Override
        public University[] newArray(int size) {
            return new University[size];
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getConsultants() {
        return consultants;
    }

    public void setConsultants(List<Student> consultants) {
        this.consultants = consultants;
    }

    @Override
    public int compareTo(@NonNull University o) {
        return this.name.compareToIgnoreCase(o.getName());
    }

    public static Comparator<University> NAMECOMPARATOR=new Comparator<University>() {
        @Override
        public int compare(University o1, University o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    };

    public static Comparator<University> FEECOMPARATOR=new Comparator<University>() {
        @Override
        public int compare(University o1, University o2) {
            return Double.compare(o1.getCourseFee(),o2.getCourseFee());
        }
    };

    public static Comparator<University> COURSECOMPARATOR=new Comparator<University>() {
        @Override
        public int compare(University o1, University o2) {
            return o1.getCourseName().compareToIgnoreCase(o2.getCourseName());
        }
    };

}
