package me.entere.myapp.swipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by entere on 17/6/20.
 */

public class SwipeBean {

    @SerializedName("meta")
    @Expose
    public Meta meta;
    @SerializedName("data")
    @Expose
    public Data data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Meta {

        @SerializedName("code")
        @Expose
        public long code;
        @SerializedName("message")
        @Expose
        public String message;

        public long getCode() {
            return code;
        }

        public void setCode(long code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }



    public class Data {

        @SerializedName("about")
        @Expose
        public About about;
        @SerializedName("items")
        @Expose
        public List<Item> items = null;

        public About getAbout() {
            return about;
        }

        public void setAbout(About about) {
            this.about = about;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

    }



    public class Item {

        @SerializedName("aid")
        @Expose
        public long aid;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("summary")
        @Expose
        public String summary;
        @SerializedName("from_url")
        @Expose
        public String fromUrl;
        @SerializedName("collection_num")
        @Expose
        public long collectionNum;
        @SerializedName("is_collection")
        @Expose
        public String isCollection;
        @SerializedName("add_time")
        @Expose
        public long addTime;
        @SerializedName("template_style")
        @Expose
        public long templateStyle;
        @SerializedName("article_img")
        @Expose
        public ArticleImg articleImg;

        public long getAid() {
            return aid;
        }

        public void setAid(long aid) {
            this.aid = aid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getFromUrl() {
            return fromUrl;
        }

        public void setFromUrl(String fromUrl) {
            this.fromUrl = fromUrl;
        }

        public long getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(long collectionNum) {
            this.collectionNum = collectionNum;
        }

        public String getIsCollection() {
            return isCollection;
        }

        public void setIsCollection(String isCollection) {
            this.isCollection = isCollection;
        }

        public long getAddTime() {
            return addTime;
        }

        public void setAddTime(long addTime) {
            this.addTime = addTime;
        }

        public long getTemplateStyle() {
            return templateStyle;
        }

        public void setTemplateStyle(long templateStyle) {
            this.templateStyle = templateStyle;
        }

        public ArticleImg getArticleImg() {
            return articleImg;
        }

        public void setArticleImg(ArticleImg articleImg) {
            this.articleImg = articleImg;
        }

    }




    public class ArticleImg {

        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("height")
        @Expose
        public long height;
        @SerializedName("width")
        @Expose
        public long width;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getHeight() {
            return height;
        }

        public void setHeight(long height) {
            this.height = height;
        }

        public long getWidth() {
            return width;
        }

        public void setWidth(long width) {
            this.width = width;
        }

    }




    public class About {

        @SerializedName("image")
        @Expose
        public String image;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("intro")
        @Expose
        public String intro;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

    }


}
