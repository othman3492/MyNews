
package com.example.android.mynews.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TopStoriesArticles {
    @SerializedName("num_results")
    private Long mNumResults;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("section")
    private String mSection;

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

    @SuppressWarnings("unused")
    public static class Result {

        @SerializedName("multimedia")
        private List<Multimedium> mMultimedia;
        @SerializedName("published_date")
        private String mPublishedDate;
        @SerializedName("section")
        private String mSection;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("url")
        private String mUrl;

        public List<Multimedium> getMultimedia() {
            return mMultimedia;
        }

        public void setMultimedia(List<Multimedium> multimedia) {
            mMultimedia = multimedia;
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
    public static class Multimedium {

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
