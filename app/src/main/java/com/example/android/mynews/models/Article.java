package com.example.android.mynews.models;


import com.example.android.mynews.utils.DateConverter;


// Object used to convert every article retrieved from the API to a usable object

public class Article {

    private String section;
    private String title;
    private String date;
    private String url;
    private String imageUrl;


    public Article() {

    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public Article createArticleFromTopStories(TopStoriesArticles.Result result) {

        Article article = new Article();

        article.title = result.getTitle();
        article.date = DateConverter.convertDate(result.getPublishedDate());
        article.section = result.getSection();
        article.url = result.getUrl();

        if (result.getMultimedia().size() != 0) {
            article.imageUrl = result.getMultimedia().get(0).getUrl();
        }

        return article;
    }


    public Article createArticleFromMostPopular(MostPopularArticles.Result result) {

        Article article = new Article();

        article.title = result.getTitle();
        article.date = result.getPublishedDate();
        article.section = result.getSection();
        article.url = result.getUrl();

        if (result.getMedia().size() != 0) {
            article.imageUrl = result.getMedia().get(0).getMediaMetadata().get(0).getUrl();
        }

        return article;
    }

    public Article createArticleFromArticleSearch(ArticleSearchArticles.Doc result) {

        Article article = new Article();

        article.title = result.getHeadline().getMain();
        article.date = DateConverter.convertDate(result.getPubDate());
        article.section = result.getSectionName();
        article.url = result.getWebUrl();

        // Add string since request doesn't return complete image URL
        if (result.getMultimedia().size() != 0) {
            article.imageUrl = "https://static01.nyt.com/" + result.getMultimedia().get(0).getUrl();
        }

        return article;
    }
}
