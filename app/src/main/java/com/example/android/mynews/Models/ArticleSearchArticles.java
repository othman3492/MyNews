
package com.example.android.mynews.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleSearchArticles {

    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("response")
    private Response mResponse;
    @SerializedName("status")
    private String mStatus;

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        mResponse = response;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }



    public static class Multimedium {

        @SerializedName("caption")
        private Object mCaption;
        @SerializedName("credit")
        private Object mCredit;
        @SerializedName("crop_name")
        private String mCropName;
        @SerializedName("height")
        private Long mHeight;
        @SerializedName("legacy")
        private Legacy mLegacy;
        @SerializedName("rank")
        private Long mRank;
        @SerializedName("subType")
        private String mSubType;
        @SerializedName("subtype")
        private String mSubtype;
        @SerializedName("type")
        private String mType;
        @SerializedName("url")
        private String mUrl;
        @SerializedName("width")
        private Long mWidth;

        public Object getCaption() {
            return mCaption;
        }

        public void setCaption(Object caption) {
            mCaption = caption;
        }

        public Object getCredit() {
            return mCredit;
        }

        public void setCredit(Object credit) {
            mCredit = credit;
        }

        public String getCropName() {
            return mCropName;
        }

        public void setCropName(String cropName) {
            mCropName = cropName;
        }

        public Long getHeight() {
            return mHeight;
        }

        public void setHeight(Long height) {
            mHeight = height;
        }

        public Legacy getLegacy() {
            return mLegacy;
        }

        public void setLegacy(Legacy legacy) {
            mLegacy = legacy;
        }

        public Long getRank() {
            return mRank;
        }

        public void setRank(Long rank) {
            mRank = rank;
        }

        public String getSubType() {
            return mSubType;
        }

        public void setSubType(String subType) {
            mSubType = subType;
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

    public static class Response {

        @SerializedName("docs")
        private List<Doc> mDocs;
        @SerializedName("meta")
        private Meta mMeta;

        public List<Doc> getDocs() {
            return mDocs;
        }

        public void setDocs(List<Doc> docs) {
            mDocs = docs;
        }

        public Meta getMeta() {
            return mMeta;
        }

        public void setMeta(Meta meta) {
            mMeta = meta;
        }

    }

    public static class Blog {


    }

    public static class Byline {

        @SerializedName("organization")
        private Object mOrganization;
        @SerializedName("original")
        private Object mOriginal;
        @SerializedName("person")
        private List<Object> mPerson;

        public Object getOrganization() {
            return mOrganization;
        }

        public void setOrganization(Object organization) {
            mOrganization = organization;
        }

        public Object getOriginal() {
            return mOriginal;
        }

        public void setOriginal(Object original) {
            mOriginal = original;
        }

        public List<Object> getPerson() {
            return mPerson;
        }

        public void setPerson(List<Object> person) {
            mPerson = person;
        }

    }

    public static class Doc {

        @SerializedName("abstract")
        private String mAbstract;
        @SerializedName("blog")
        private Blog mBlog;
        @SerializedName("byline")
        private Byline mByline;
        @SerializedName("document_type")
        private String mDocumentType;
        @SerializedName("headline")
        private Headline mHeadline;
        @SerializedName("keywords")
        private List<Keyword> mKeywords;
        @SerializedName("lead_paragraph")
        private String mLeadParagraph;
        @SerializedName("multimedia")
        private List<Multimedium> mMultimedia;
        @SerializedName("news_desk")
        private String mNewsDesk;
        @SerializedName("pub_date")
        private String mPubDate;
        @SerializedName("section_name")
        private String mSectionName;
        @SerializedName("snippet")
        private String mSnippet;
        @SerializedName("source")
        private String mSource;
        @SerializedName("type_of_material")
        private String mTypeOfMaterial;
        @SerializedName("uri")
        private String mUri;
        @SerializedName("web_url")
        private String mWebUrl;
        @SerializedName("word_count")
        private Long mWordCount;
        @SerializedName("_id")
        private String m_id;

        public String getAbstract() {
            return mAbstract;
        }

        public void setAbstract(String abstractx) {
            mAbstract = abstractx;
        }

        public Blog getBlog() {
            return mBlog;
        }

        public void setBlog(Blog blog) {
            mBlog = blog;
        }

        public Byline getByline() {
            return mByline;
        }

        public void setByline(Byline byline) {
            mByline = byline;
        }

        public String getDocumentType() {
            return mDocumentType;
        }

        public void setDocumentType(String documentType) {
            mDocumentType = documentType;
        }

        public Headline getHeadline() {
            return mHeadline;
        }

        public void setHeadline(Headline headline) {
            mHeadline = headline;
        }

        public List<Keyword> getKeywords() {
            return mKeywords;
        }

        public void setKeywords(List<Keyword> keywords) {
            mKeywords = keywords;
        }

        public String getLeadParagraph() {
            return mLeadParagraph;
        }

        public void setLeadParagraph(String leadParagraph) {
            mLeadParagraph = leadParagraph;
        }

        public List<Multimedium> getMultimedia() {
            return mMultimedia;
        }

        public void setMultimedia(List<Multimedium> multimedia) {
            mMultimedia = multimedia;
        }

        public String getNewsDesk() {
            return mNewsDesk;
        }

        public void setNewsDesk(String newsDesk) {
            mNewsDesk = newsDesk;
        }

        public String getPubDate() {
            return mPubDate;
        }

        public void setPubDate(String pubDate) {
            mPubDate = pubDate;
        }

        public String getSectionName() {
            return mSectionName;
        }

        public void setSectionName(String sectionName) {
            mSectionName = sectionName;
        }

        public String getSnippet() {
            return mSnippet;
        }

        public void setSnippet(String snippet) {
            mSnippet = snippet;
        }

        public String getSource() {
            return mSource;
        }

        public void setSource(String source) {
            mSource = source;
        }

        public String getTypeOfMaterial() {
            return mTypeOfMaterial;
        }

        public void setTypeOfMaterial(String typeOfMaterial) {
            mTypeOfMaterial = typeOfMaterial;
        }

        public String getUri() {
            return mUri;
        }

        public void setUri(String uri) {
            mUri = uri;
        }

        public String getWebUrl() {
            return mWebUrl;
        }

        public void setWebUrl(String webUrl) {
            mWebUrl = webUrl;
        }

        public Long getWordCount() {
            return mWordCount;
        }

        public void setWordCount(Long wordCount) {
            mWordCount = wordCount;
        }

        public String get_id() {
            return m_id;
        }

        public void set_id(String _id) {
            m_id = _id;
        }

    }

    public static class Headline {

        @SerializedName("content_kicker")
        private Object mContentKicker;
        @SerializedName("kicker")
        private Object mKicker;
        @SerializedName("main")
        private String mMain;
        @SerializedName("name")
        private Object mName;
        @SerializedName("print_headline")
        private Object mPrintHeadline;
        @SerializedName("seo")
        private Object mSeo;
        @SerializedName("sub")
        private Object mSub;

        public Object getContentKicker() {
            return mContentKicker;
        }

        public void setContentKicker(Object contentKicker) {
            mContentKicker = contentKicker;
        }

        public Object getKicker() {
            return mKicker;
        }

        public void setKicker(Object kicker) {
            mKicker = kicker;
        }

        public String getMain() {
            return mMain;
        }

        public void setMain(String main) {
            mMain = main;
        }

        public Object getName() {
            return mName;
        }

        public void setName(Object name) {
            mName = name;
        }

        public Object getPrintHeadline() {
            return mPrintHeadline;
        }

        public void setPrintHeadline(Object printHeadline) {
            mPrintHeadline = printHeadline;
        }

        public Object getSeo() {
            return mSeo;
        }

        public void setSeo(Object seo) {
            mSeo = seo;
        }

        public Object getSub() {
            return mSub;
        }

        public void setSub(Object sub) {
            mSub = sub;
        }

    }

    public static class Keyword {

        @SerializedName("major")
        private String mMajor;
        @SerializedName("name")
        private String mName;
        @SerializedName("rank")
        private Long mRank;
        @SerializedName("value")
        private String mValue;

        public String getMajor() {
            return mMajor;
        }

        public void setMajor(String major) {
            mMajor = major;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public Long getRank() {
            return mRank;
        }

        public void setRank(Long rank) {
            mRank = rank;
        }

        public String getValue() {
            return mValue;
        }

        public void setValue(String value) {
            mValue = value;
        }

    }

    public static class Legacy {

        @SerializedName("wide")
        private String mWide;
        @SerializedName("wideheight")
        private Long mWideheight;
        @SerializedName("widewidth")
        private Long mWidewidth;

        public String getWide() {
            return mWide;
        }

        public void setWide(String wide) {
            mWide = wide;
        }

        public Long getWideheight() {
            return mWideheight;
        }

        public void setWideheight(Long wideheight) {
            mWideheight = wideheight;
        }

        public Long getWidewidth() {
            return mWidewidth;
        }

        public void setWidewidth(Long widewidth) {
            mWidewidth = widewidth;
        }

    }

    public static class Meta {

        @SerializedName("hits")
        private Long mHits;
        @SerializedName("offset")
        private Long mOffset;
        @SerializedName("time")
        private Long mTime;

        public Long getHits() {
            return mHits;
        }

        public void setHits(Long hits) {
            mHits = hits;
        }

        public Long getOffset() {
            return mOffset;
        }

        public void setOffset(Long offset) {
            mOffset = offset;
        }

        public Long getTime() {
            return mTime;
        }

        public void setTime(Long time) {
            mTime = time;
        }

    }
}
