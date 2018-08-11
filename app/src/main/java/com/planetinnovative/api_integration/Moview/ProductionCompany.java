
package com.planetinnovative.api_integration.Moview;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;


@SuppressWarnings("unused")
public class ProductionCompany extends RealmObject {

    @SerializedName("id")
    private Long mId;
    @SerializedName("logo_path")
    private String mLogoPath;
    @SerializedName("name")
    private String mName;
    @SerializedName("origin_country")
    private String mOriginCountry;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLogoPath() {
        return mLogoPath;
    }

    public void setLogoPath(String logoPath) {
        mLogoPath = logoPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOriginCountry() {
        return mOriginCountry;
    }

    public void setOriginCountry(String originCountry) {
        mOriginCountry = originCountry;
    }

}
