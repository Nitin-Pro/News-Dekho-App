package com.example.newsdekho;

public class News {
    public String title, publishedAt;
    public String author;
    public String url;
    public String urlToImage;
    public News() {

    }

    public News(String title, String author, String url, String urlToImage, String publishedAt) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String geturlToImage() {
        return urlToImage;
    }

    public void setImageUrl(String imageUrl) {
        this.urlToImage= imageUrl;
    }
}
