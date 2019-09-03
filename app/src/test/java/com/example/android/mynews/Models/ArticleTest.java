package com.example.android.mynews.Models;

import com.example.android.mynews.Models.Article;
import com.example.android.mynews.Models.ArticleSearchArticles;
import com.example.android.mynews.Models.MostPopularArticles;
import com.example.android.mynews.Models.TopStoriesArticles;
import com.example.android.mynews.Utils.DateConverter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleTest {

    private String section;
    private String title;
    private String date;
    private String url;
    private String imageUrl;

    private Article article;

    @Before
    public void setUp() {
        section = "World";
        title = "Boris Johnson Will Suspend U.K. Parliament, Hindering Brexit Rebels";
        date = "2019-08-28";
        url = "https://www.nytimes.com/2019/08/28/world/europe/boris-johnson-brexit-parliament.html";
        imageUrl = "https://static01.nyt.com/images/2019/08/28/world/28brexit2/28brexit2-thumbStandard.jpg";

        article = new Article();
    }

    @Test
    public void setAndGetSectionWithSuccess() {
        article.setSection(section);

        assertEquals(section, article.getSection());
    }

    @Test
    public void setAndGetTitleWithSuccess() {
        article.setTitle(title);

        assertEquals(title, article.getTitle());
    }

    @Test
    public void setAndGetDateWithSuccess() {
        article.setDate(date);

        assertEquals(date, article.getDate());
    }

    @Test
    public void setAndGetUrlWithSuccess() {
        article.setUrl(url);

        assertEquals(url, article.getUrl());
    }

    @Test
    public void setAndGetImageUrlWithSuccess() {
        article.setImageUrl(imageUrl);

        assertEquals(imageUrl, article.getImageUrl());
    }

    @Test
    public void createArticleFromTopStoriesWithSuccess() {
        article.setSection(section);
        article.setTitle(title);
        article.setDate(date);
        article.setUrl(url);
        article.setImageUrl(imageUrl);

        TopStoriesArticles.Result articleTopStories = new TopStoriesArticles.Result();

        List<TopStoriesArticles.Multimedium> multimediumTopStories = new ArrayList<>();

        TopStoriesArticles.Multimedium multimediaTopStories;

        multimediaTopStories = new TopStoriesArticles.Multimedium();
        multimediaTopStories.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/28brexit2-thumbStandard.jpg");
        multimediumTopStories.add(multimediaTopStories);
        multimediaTopStories = new TopStoriesArticles.Multimedium();
        multimediaTopStories.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/28brexit2-thumbLarge.jpg");
        multimediumTopStories.add(multimediaTopStories);
        multimediaTopStories = new TopStoriesArticles.Multimedium();
        multimediaTopStories.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-articleInline.jpg");
        multimediumTopStories.add(multimediaTopStories);
        multimediaTopStories = new TopStoriesArticles.Multimedium();
        multimediaTopStories.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-mediumThreeByTwo210.jpg");
        multimediumTopStories.add(multimediaTopStories);
        multimediaTopStories = new TopStoriesArticles.Multimedium();
        multimediaTopStories.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-superJumbo.jpg");
        multimediumTopStories.add(multimediaTopStories);

        articleTopStories.setMultimedia(multimediumTopStories);
        articleTopStories.setPublishedDate("2019-08-28T05:25:37-04:00");
        articleTopStories.setSection("World");
        articleTopStories.setTitle("Boris Johnson Will Suspend U.K. Parliament, Hindering Brexit Rebels");
        articleTopStories.setUrl("https://www.nytimes.com/2019/08/28/world/europe/boris-johnson-brexit-parliament.html");


        Article articleFromTopStories = article.createArticleFromTopStories(articleTopStories);

        assertEquals(article.getSection(), articleFromTopStories.getSection());
        assertEquals(article.getTitle(), articleFromTopStories.getTitle());
        assertEquals(article.getDate(), articleFromTopStories.getDate());
        assertEquals(article.getUrl(), articleFromTopStories.getUrl());
        assertEquals(article.getImageUrl(), articleFromTopStories.getImageUrl());
    }

    @Test
    public void createArticleFromMostPopularWithSuccess() {
        article.setSection(section);
        article.setTitle(title);
        article.setDate(date);
        article.setUrl(url);
        article.setImageUrl(imageUrl);

        MostPopularArticles.Result mostPopularArticles = new MostPopularArticles.Result();

        List<MostPopularArticles.Medium> mediumList = new ArrayList<>();

        List<MostPopularArticles.MediaMetadatum> mediaMostPopularList = new ArrayList<>();

        MostPopularArticles.MediaMetadatum mediaMostPopular;

        mediaMostPopular = new MostPopularArticles.MediaMetadatum();
        mediaMostPopular.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/28brexit2-thumbStandard.jpg");
        mediaMostPopularList.add(mediaMostPopular);
        mediaMostPopular = new MostPopularArticles.MediaMetadatum();
        mediaMostPopular.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/28brexit2-thumbLarge.jpg");
        mediaMostPopularList.add(mediaMostPopular);
        mediaMostPopular = new MostPopularArticles.MediaMetadatum();
        mediaMostPopular.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-articleInline.jpg");
        mediaMostPopularList.add(mediaMostPopular);
        mediaMostPopular = new MostPopularArticles.MediaMetadatum();
        mediaMostPopular.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-mediumThreeByTwo210.jpg");
        mediaMostPopularList.add(mediaMostPopular);
        mediaMostPopular = new MostPopularArticles.MediaMetadatum();
        mediaMostPopular.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-superJumbo.jpg");
        mediaMostPopularList.add(mediaMostPopular);

        MostPopularArticles.Medium medium = new MostPopularArticles.Medium();
        medium.setMediaMetadata(mediaMostPopularList);
        mediumList.add(medium);

        mostPopularArticles.setMedia(mediumList);
        mostPopularArticles.setPublishedDate("2019-08-28T05:25:37-04:00");
        mostPopularArticles.setSection("World");
        mostPopularArticles.setTitle("Boris Johnson Will Suspend U.K. Parliament, Hindering Brexit Rebels");
        mostPopularArticles.setUrl("https://www.nytimes.com/2019/08/28/world/europe/boris-johnson-brexit-parliament.html");

        Article articleFromMostPopular = article.createArticleFromMostPopular(mostPopularArticles);

        assertEquals(DateConverter.convertDate(articleFromMostPopular.getDate()), article.getDate());
        assertEquals(articleFromMostPopular.getSection(), article.getSection());
        assertEquals(articleFromMostPopular.getTitle(), article.getTitle());
        assertEquals(articleFromMostPopular.getUrl(), article.getUrl());
        assertEquals(articleFromMostPopular.getImageUrl(), article.getImageUrl());
    }

    @Test
    public void createArticleFromArticleSearchWithSuccess() {
        article.setSection(section);
        article.setTitle(title);
        article.setDate(date);
        article.setUrl(url);
        article.setImageUrl(imageUrl);

        ArticleSearchArticles.Doc articleSearchArticle = new ArticleSearchArticles.Doc();

        List<ArticleSearchArticles.Multimedium> multimediumList = new ArrayList<>();

        ArticleSearchArticles.Multimedium articleSearchMultimedium;

        articleSearchMultimedium = new ArticleSearchArticles.Multimedium();
        articleSearchMultimedium.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/28brexit2-thumbStandard.jpg");
        multimediumList.add(articleSearchMultimedium);
        articleSearchMultimedium = new ArticleSearchArticles.Multimedium();
        articleSearchMultimedium.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/28brexit2-thumbLarge.jpg");
        multimediumList.add(articleSearchMultimedium);
        articleSearchMultimedium = new ArticleSearchArticles.Multimedium();
        articleSearchMultimedium.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-articleInline.jpg");
        multimediumList.add(articleSearchMultimedium);
        articleSearchMultimedium = new ArticleSearchArticles.Multimedium();
        articleSearchMultimedium.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-mediumThreeByTwo210.jpg");
        multimediumList.add(articleSearchMultimedium);
        articleSearchMultimedium = new ArticleSearchArticles.Multimedium();
        articleSearchMultimedium.setUrl("https://static01.nyt.com/images/2019/08/28/world/28brexit2/merlin_159824259_472cc429-fca5-46a8-b084-8e8f77f2b7d7-superJumbo.jpg");
        multimediumList.add(articleSearchMultimedium);

        ArticleSearchArticles.Headline headline = new ArticleSearchArticles.Headline();
        articleSearchArticle.setHeadline(headline);


        articleSearchArticle.setMultimedia(multimediumList);
        articleSearchArticle.setPubDate("2019-08-28T05:25:37-04:00");
        articleSearchArticle.setSectionName("World");
        headline.setMain("Boris Johnson Will Suspend U.K. Parliament, Hindering Brexit Rebels");
        articleSearchArticle.setWebUrl("https://www.nytimes.com/2019/08/28/world/europe/boris-johnson-brexit-parliament.html");

        Article articleFromArticleSearch = article.createArticleFromArticleSearch(articleSearchArticle);

        assertEquals(articleFromArticleSearch.getDate(), article.getDate());
        assertEquals(articleFromArticleSearch.getSection(), article.getSection());
        assertEquals(articleFromArticleSearch.getTitle(), article.getTitle());
        assertEquals(articleFromArticleSearch.getUrl(), article.getUrl());
        assertEquals(articleFromArticleSearch.getImageUrl(), article.getImageUrl());
    }

}