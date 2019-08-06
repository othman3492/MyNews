
package com.example.android.mynews.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TopStoriesArticles {

    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("last_updated")
    private String mLastUpdated;
    @SerializedName("num_results")
    private Long mNumResults;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("section")
    private String mSection;
    @SerializedName("status")
    private String mStatus;

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public Long getNumResults() {
        return mNumResults;
    }

    public void setNumResults(Long numResults) {
        mNumResults = numResults;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    @SuppressWarnings("unused")
    public static class Result {

        @SerializedName("abstract")
        private String mAbstract;
        @SerializedName("byline")
        private String mByline;
        @SerializedName("created_date")
        private String mCreatedDate;
        @SerializedName("des_facet")
        private List<String> mDesFacet;
        @SerializedName("geo_facet")
        private List<Object> mGeoFacet;
        @SerializedName("item_type")
        private String mItemType;
        @SerializedName("kicker")
        private String mKicker;
        @SerializedName("material_type_facet")
        private String mMaterialTypeFacet;
        @SerializedName("multimedia")
        private List<Multimedium> mMultimedia;
        @SerializedName("org_facet")
        private List<Object> mOrgFacet;
        @SerializedName("per_facet")
        private List<Object> mPerFacet;
        @SerializedName("published_date")
        private String mPublishedDate;
        @SerializedName("section")
        private String mSection;
        @SerializedName("short_url")
        private String mShortUrl;
        @SerializedName("subsection")
        private String mSubsection;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("updated_date")
        private String mUpdatedDate;
        @SerializedName("url")
        private String mUrl;

        public String getAbstract() {
            return mAbstract;
        }

        public void setAbstract(String abstractx) {
            mAbstract = abstractx;
        }

        public String getByline() {
            return mByline;
        }

        public void setByline(String byline) {
            mByline = byline;
        }

        public String getCreatedDate() {
            return mCreatedDate;
        }

        public void setCreatedDate(String createdDate) {
            mCreatedDate = createdDate;
        }

        public List<String> getDesFacet() {
            return mDesFacet;
        }

        public void setDesFacet(List<String> desFacet) {
            mDesFacet = desFacet;
        }

        public List<Object> getGeoFacet() {
            return mGeoFacet;
        }

        public void setGeoFacet(List<Object> geoFacet) {
            mGeoFacet = geoFacet;
        }

        public String getItemType() {
            return mItemType;
        }

        public void setItemType(String itemType) {
            mItemType = itemType;
        }

        public String getKicker() {
            return mKicker;
        }

        public void setKicker(String kicker) {
            mKicker = kicker;
        }

        public String getMaterialTypeFacet() {
            return mMaterialTypeFacet;
        }

        public void setMaterialTypeFacet(String materialTypeFacet) {
            mMaterialTypeFacet = materialTypeFacet;
        }

        public List<Multimedium> getMultimedia() {
            return mMultimedia;
        }

        public void setMultimedia(List<Multimedium> multimedia) {
            mMultimedia = multimedia;
        }

        public List<Object> getOrgFacet() {
            return mOrgFacet;
        }

        public void setOrgFacet(List<Object> orgFacet) {
            mOrgFacet = orgFacet;
        }

        public List<Object> getPerFacet() {
            return mPerFacet;
        }

        public void setPerFacet(List<Object> perFacet) {
            mPerFacet = perFacet;
        }

        public String getPublishedDate() {
            return mPublishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            mPublishedDate = publishedDate;
        }

        public String getSection() {
            return mSection;
        }

        public void setSection(String section) {
            mSection = section;
        }

        public String getShortUrl() {
            return mShortUrl;
        }

        public void setShortUrl(String shortUrl) {
            mShortUrl = shortUrl;
        }

        public String getSubsection() {
            return mSubsection;
        }

        public void setSubsection(String subsection) {
            mSubsection = subsection;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public String getUpdatedDate() {
            return mUpdatedDate;
        }

        public void setUpdatedDate(String updatedDate) {
            mUpdatedDate = updatedDate;
        }

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }

    }

    @SuppressWarnings("unused")
    public static class Multimedium {

        @SerializedName("caption")
        private String mCaption;
        @SerializedName("copyright")
        private String mCopyright;
        @SerializedName("format")
        private String mFormat;
        @SerializedName("height")
        private Long mHeight;
        @SerializedName("subtype")
        private String mSubtype;
        @SerializedName("type")
        private String mType;
        @SerializedName("url")
        private String mUrl;
        @SerializedName("width")
        private Long mWidth;

        public String getCaption() {
            return mCaption;
        }

        public void setCaption(String caption) {
            mCaption = caption;
        }

        public String getCopyright() {
            return mCopyright;
        }

        public void setCopyright(String copyright) {
            mCopyright = copyright;
        }

        public String getFormat() {
            return mFormat;
        }

        public void setFormat(String format) {
            mFormat = format;
        }

        public Long getHeight() {
            return mHeight;
        }

        public void setHeight(Long height) {
            mHeight = height;
        }

        public String getSubtype() {
            return mSubtype;
        }

        public void setSubtype(String subtype) {
            mSubtype = subtype;
        }

        public String getType() {
            return mType;
        }

        public void setType(String type) {
            mType = type;
        }

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }

        public Long getWidth() {
            return mWidth;
        }

        public void setWidth(Long width) {
            mWidth = width;
        }

    }
}
