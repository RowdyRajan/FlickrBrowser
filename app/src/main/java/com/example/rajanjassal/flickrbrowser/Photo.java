package com.example.rajanjassal.flickrbrowser;

/**
 * Created by rajanjassal on 2015-01-14.
 */
public class Photo {
    private String mTitle;
    private String mAuthor;
    private String getmAuthorID;
    private String mLink;
    private String mTags;
    private String mImage;

    @Override
    public String toString() {
        return "Photo{" +
                "mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", getmAuthorID='" + getmAuthorID + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mTags='" + mTags + '\'' +
                ", mImage='" + mImage + '\'' +
                '}';
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getGetmAuthorID() {
        return getmAuthorID;
    }

    public String getmLink() {
        return mLink;
    }

    public String getmTags() {
        return mTags;
    }

    public String getmImage() {
        return mImage;
    }

    public Photo(String mTitle, String mAuthor, String getmAuthorID, String mLink, String mTags, String mImage) {

        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.getmAuthorID = getmAuthorID;
        this.mLink = mLink;
        this.mTags = mTags;
        this.mImage = mImage;
    }
}
