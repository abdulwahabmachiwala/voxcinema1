package com.wahab.vox.cinema.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nishat Sayyed on 16-08-2018.
 */

public class Movie implements Parcelable {
    private String name;
    private String duration;
    private String trailerUrl;
    private String language;
    private String genre;
    private String releaseDate;
    private int thumbnail;
    private int poster;

    public Movie() {}

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailer_url) {
        this.trailerUrl = trailer_url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public Object createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Object[] newArray(int i) {
            return new Movie[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public Movie(Parcel in) {
        this.name = in.readString();
        this.duration = in.readString();
        this.language = in.readString();
        this.thumbnail = in.readInt();
        this.poster = in.readInt();
        this.genre = in.readString();
        this.releaseDate = in.readString();
        this.trailerUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.duration);
        parcel.writeString(this.language);
        parcel.writeInt(this.thumbnail);
        parcel.writeInt(this.poster);
        parcel.writeString(this.genre);
        parcel.writeString(this.releaseDate);
        parcel.writeString(this.trailerUrl);
    }

    @Override
    public String toString() {
        return name + " " + thumbnail;
    }
}
