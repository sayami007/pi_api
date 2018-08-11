
package com.planetinnovative.api_integration.Moview;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;


@SuppressWarnings("unused")
public class Genre extends RealmObject {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
