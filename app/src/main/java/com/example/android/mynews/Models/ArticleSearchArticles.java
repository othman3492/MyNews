
package com.example.android.mynews.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleSearchArticles {

    @SerializedName("response")
    private Response mResponse;

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        mResponse = response;
    }


    public static class Multimedium {

        @SerializedName("url")
        private String mUrl;

        String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }
    }

    public static class Response {

        @SerializedName("docs")
        private List<Doc> mDocs;

        public List<Doc> getDocs() {
            return mDocs;
        }

        public void setDocs(List<Doc> docs) {
            mDocs = docs;
        }

    }


    public static class Doc {

        @SerializedName("headline")
        private Headline mHeadline;
        @SerializedName("multimedia")
        private List<Multimedium> mMultimedia;
        @SerializedName("pub_date")
        private String mPubDate;
        @SerializedName("section_name")
        private String mSectionName;
        @SerializedName("web_url")
        private String mWebUrl;

        Headline getHeadline() {
            return mHeadline;
        }

        public void setHeadline(Headline headline) {
            mHeadline = headline;
        }

        List<Multimedium> getMultimedia() {
            return mMultimedia;
        }

        public void setMultimedia(List<Multimedium> multimedia) {
            mMultimedia = multimedia;
        }

        String getPubDate() {
            return mPubDate;
        }

        public void setPubDate(String pubDate) {
            mPubDate = pubDate;
        }

        String getSectionName() {
            return mSectionName;
        }

        public void setSectionName(String sectionName) {
            mSectionName = sectionName;
        }

        String getWebUrl() {
            return mWebUrl;
        }

        public void setWebUrl(String webUrl) {
            mWebUrl = webUrl;
        }

    }

    public static class Headline {

        @SerializedName("main")
        private String mMain;

        String getMain() {
            return mMain;
        }

        public void setMain(String main) {
            mMain = main;
        }

    }

}