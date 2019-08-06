
package com.example.android.mynews.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class MostPopularArticles {

    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("num_results")
    private Long mNumResults;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("status")
    private String mStatus;

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
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
        @SerializedName("adx_keywords")
        private String mAdxKeywords;
        @SerializedName("asset_id")
        private Long mAssetId;
        @SerializedName("byline")
        private String mByline;
        @SerializedName("column")
        private Object mColumn;
        @SerializedName("des_facet")
        private List<String> mDesFacet;
        @SerializedName("geo_facet")
        private String mGeoFacet;
        @SerializedName("id")
        private Long mId;
        @SerializedName("media")
        private List<Medium> mMedia;
        @SerializedName("org_facet")
        private String mOrgFacet;
        @SerializedName("per_facet")
        private String mPerFacet;
        @SerializedName("published_date")
        private String mPublishedDate;
        @SerializedName("section")
        private String mSection;
        @SerializedName("source")
        private String mSource;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("type")
        private String mType;
        @SerializedName("uri")
        private String mUri;
        @SerializedName("url")
        private String mUrl;
        @SerializedName("views")
        private Long mViews;

        public String getAbstract() {
            return mAbstract;
        }

        public void setAbstract(String abstractx) {
            mAbstract = abstractx;
        }

        public String getAdxKeywords() {
            return mAdxKeywords;
        }

        public void setAdxKeywords(String adxKeywords) {
            mAdxKeywords = adxKeywords;
        }

        public Long getAssetId() {
            return mAssetId;
        }

        public void setAssetId(Long assetId) {
            mAssetId = assetId;
        }

        public String getByline() {
            return mByline;
        }

        public void setByline(String byline) {
            mByline = byline;
        }

        public Object getColumn() {
            return mColumn;
        }

        public void setColumn(Object column) {
            mColumn = column;
        }

        public List<String> getDesFacet() {
            return mDesFacet;
        }

        public void setDesFacet(List<String> desFacet) {
            mDesFacet = desFacet;
        }

        public String getGeoFacet() {
            return mGeoFacet;
        }

        public void setGeoFacet(String geoFacet) {
            mGeoFacet = geoFacet;
        }

        public Long getId() {
            return mId;
        }

        public void setId(Long id) {
            mId = id;
        }

        public List<Medium> getMedia() {
            return mMedia;
        }

        public void setMedia(List<Medium> media) {
            mMedia = media;
        }

        public String getOrgFacet() {
            return mOrgFacet;
        }

        public void setOrgFacet(String orgFacet) {
            mOrgFacet = orgFacet;
        }

        public String getPerFacet() {
            return mPerFacet;
        }

        public void setPerFacet(String perFacet) {
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

        public String getSource() {
            return mSource;
        }

        public void setSource(String source) {
            mSource = source;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public String getType() {
            return mType;
        }

        public void setType(String type) {
            mType = type;
        }

        public String getUri() {
            return mUri;
        }

        public void setUri(String uri) {
            mUri = uri;
        }

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }

        public Long getViews() {
            return mViews;
        }

        public void setViews(Long views) {
            mViews = views;
        }

    }

    @SuppressWarnings("unused")
    public static class Medium {

        @SerializedName("approved_for_syndication")
        private Long mApprovedForSyndication;
        @SerializedName("caption")
        private String mCaption;
        @SerializedName("copyright")
        private String mCopyright;
        @SerializedName("media-metadata")
        private List<MediaMetadatum> mMediaMetadata;
        @SerializedName("subtype")
        private String mSubtype;
        @SerializedName("type")
        private String mType;

        public Long getApprovedForSyndication() {
            return mApprovedForSyndication;
        }

        public void setApprovedForSyndication(Long approvedForSyndication) {
            mApprovedForSyndication = approvedForSyndication;
        }

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

        public List<MediaMetadatum> getMediaMetadata() {
            return mMediaMetadata;
        }

        public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
            mMediaMetadata = mediaMetadata;
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

    }

    @SuppressWarnings("unused")
    public static class MediaMetadatum {

        @SerializedName("format")
        private String mFormat;
        @SerializedName("height")
        private Long mHeight;
        @SerializedName("url")
        private String mUrl;
        @SerializedName("width")
        private Long mWidth;

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
