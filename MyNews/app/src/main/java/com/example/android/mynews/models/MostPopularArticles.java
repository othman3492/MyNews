
package com.example.android.mynews.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class MostPopularArticles {

    @SerializedName("num_results")
    private Long mNumResults;
    @SerializedName("results")
    private List<Result> mResults;

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

    @SuppressWarnings("unused")
    public static class Result {

        @SerializedName("id")
        private Long mId;
        @SerializedName("media")
        private List<Medium> mMedia;
        @SerializedName("published_date")
        private String mPublishedDate;
        @SerializedName("section")
        private String mSection;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("url")
        private String mUrl;


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

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }

    }

    @SuppressWarnings("unused")
    public static class Medium {

        @SerializedName("media-metadata")
        private List<MediaMetadatum> mMediaMetadata;

        public List<MediaMetadatum> getMediaMetadata() {
            return mMediaMetadata;
        }

        public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
            mMediaMetadata = mediaMetadata;
        }

    }

    @SuppressWarnings("unused")
    public static class MediaMetadatum {

        @SerializedName("url")
        private String mUrl;

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }

    }
}
