package com.viks.android.myapplication.myuniversitas;

import android.os.Parcel;
import android.os.Parcelable;

public class Universitas implements Parcelable {
    private String nama, daerah, logo, official, singkatan, didirikan, alamat, sinopsis, taman;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOfficial() { return official; }

    public void setOfficial(String official) { this.official = official; }

    public String getSingkatan() { return singkatan; }

    public void setSingkatan(String singkatan) { this.singkatan = singkatan; }

    public String getDidirikan() { return didirikan; }

    public void setDidirikan(String didirikan) { this.didirikan = didirikan; }

    public String getAlamat() { return alamat; }

    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getSinopsis() { return sinopsis; }

    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public String getTaman() { return taman; }

    public void setTaman(String taman) { this.taman = taman; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.daerah);
        dest.writeString(this.logo);
        dest.writeString(this.official);
        dest.writeString(this.singkatan);
        dest.writeString(this.didirikan);
        dest.writeString(this.alamat);
        dest.writeString(this.sinopsis);
        dest.writeString(this.taman);
    }

    public Universitas() {
    }

    public Universitas(Parcel in) {
        this.nama = in.readString();
        this.daerah = in.readString();
        this.logo = in.readString();
        this.official = in.readString();
        this.singkatan = in.readString();
        this.didirikan = in.readString();
        this.alamat = in.readString();
        this.sinopsis = in.readString();
        this.taman = in.readString();
    }

    public static final Parcelable.Creator<Universitas> CREATOR = new Parcelable.Creator<Universitas>() {
        @Override
        public Universitas createFromParcel(Parcel in) {
            return new Universitas(in);
        }

        @Override
        public Universitas[] newArray(int size) {
            return new Universitas[size];
        }
    };
}
