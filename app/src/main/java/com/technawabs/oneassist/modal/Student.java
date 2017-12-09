package com.technawabs.oneassist.modal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Student implements Parcelable,Comparable<Student> {

    private Long id;
    private String name;
    private String profilePicture;
    private String school;
    private String program;
    private String USRegion;
    private String numYearsInUS;
    private boolean isConsultant;
    private String education;

    public Student(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getUSRegion() {
        return USRegion;
    }

    public void setUSRegion(String USRegion) {
        this.USRegion = USRegion;
    }

    public String getNumYearsInUS() {
        return numYearsInUS;
    }

    public void setNumYearsInUS(String numYearsInUS) {
        this.numYearsInUS = numYearsInUS;
    }

    public boolean isConsultant() {
        return isConsultant;
    }

    public void setConsultant(boolean consultant) {
        isConsultant = consultant;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    protected Student(Parcel in) {
        id = in.readLong();
        name = in.readString();
        profilePicture = in.readString();
        school = in.readString();
        program = in.readString();
        USRegion = in.readString();
        numYearsInUS = in.readString();
        isConsultant = in.readByte() != 0;
        education = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(profilePicture);
        dest.writeString(school);
        dest.writeString(program);
        dest.writeString(USRegion);
        dest.writeString(numYearsInUS);
        dest.writeByte((byte) (isConsultant ? 1 : 0));
        dest.writeString(education);
    }

//    public static Comparator<Student> backersComparator=new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o1.get-o2.getNumberOfBackers();
//        }
//    };

    @Override
    public int compareTo(@NonNull Student o) {
        return this.id.compareTo(o.getId());
    }
}
