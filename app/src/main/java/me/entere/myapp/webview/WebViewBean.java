package me.entere.myapp.webview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by entere on 17/6/23.
 */

public class WebViewBean {

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

    public class Covers {

        @SerializedName("url")
        @Expose
        public String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public class Covers_ {

        @SerializedName("url")
        @Expose
        public String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public class Data {

        @SerializedName("detail")
        @Expose
        public Detail detail;
        @SerializedName("item")
        @Expose
        public List<Item> item = null;

        public Detail getDetail() {
            return detail;
        }

        public void setDetail(Detail detail) {
            this.detail = detail;
        }

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }

    }


    public class Detail {

        @SerializedName("_id")
        @Expose
        public Id id;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("weblink")
        @Expose
        public String weblink;
        @SerializedName("summary")
        @Expose
        public String summary;
        @SerializedName("platform_id")
        @Expose
        public Integer platformId;
        @SerializedName("webauthor")
        @Expose
        public String webauthor;
        @SerializedName("template_style")
        @Expose
        public Integer templateStyle;
        @SerializedName("covers")
        @Expose
        public Covers covers;
        @SerializedName("content")
        @Expose
        public String content;
        @SerializedName("add_time")
        @Expose
        public String addTime;
        @SerializedName("p_image_big")
        @Expose
        public String pImageBig;
        @SerializedName("p_image_small")
        @Expose
        public String pImageSmall;
        @SerializedName("p_name")
        @Expose
        public String pName;
        @SerializedName("p_intro")
        @Expose
        public String pIntro;
        @SerializedName("collection_nums")
        @Expose
        public Integer collectionNums;
        @SerializedName("share_nums")
        @Expose
        public Integer shareNums;

        public Id getId() {
            return id;
        }

        public void setId(Id id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWeblink() {
            return weblink;
        }

        public void setWeblink(String weblink) {
            this.weblink = weblink;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Integer getPlatformId() {
            return platformId;
        }

        public void setPlatformId(Integer platformId) {
            this.platformId = platformId;
        }

        public String getWebauthor() {
            return webauthor;
        }

        public void setWebauthor(String webauthor) {
            this.webauthor = webauthor;
        }

        public Integer getTemplateStyle() {
            return templateStyle;
        }

        public void setTemplateStyle(Integer templateStyle) {
            this.templateStyle = templateStyle;
        }

        public Covers getCovers() {
            return covers;
        }

        public void setCovers(Covers covers) {
            this.covers = covers;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getPImageBig() {
            return pImageBig;
        }

        public void setPImageBig(String pImageBig) {
            this.pImageBig = pImageBig;
        }

        public String getPImageSmall() {
            return pImageSmall;
        }

        public void setPImageSmall(String pImageSmall) {
            this.pImageSmall = pImageSmall;
        }

        public String getPName() {
            return pName;
        }

        public void setPName(String pName) {
            this.pName = pName;
        }

        public String getPIntro() {
            return pIntro;
        }

        public void setPIntro(String pIntro) {
            this.pIntro = pIntro;
        }

        public Integer getCollectionNums() {
            return collectionNums;
        }

        public void setCollectionNums(Integer collectionNums) {
            this.collectionNums = collectionNums;
        }

        public Integer getShareNums() {
            return shareNums;
        }

        public void setShareNums(Integer shareNums) {
            this.shareNums = shareNums;
        }

    }


    public class Id {

        @SerializedName("$oid")
        @Expose
        public String $oid;

        public String get$oid() {
            return $oid;
        }

        public void set$oid(String $oid) {
            this.$oid = $oid;
        }

    }


    public class Id_ {

        @SerializedName("$oid")
        @Expose
        public String $oid;

        public String get$oid() {
            return $oid;
        }

        public void set$oid(String $oid) {
            this.$oid = $oid;
        }

    }

    public class Item {

        @SerializedName("_id")
        @Expose
        public Id_ id;
        @SerializedName("aid")
        @Expose
        public Long aid;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("template_style")
        @Expose
        public Integer templateStyle;
        @SerializedName("covers")
        @Expose
        public Covers_ covers;
        @SerializedName("p_name")
        @Expose
        public String pName;
        @SerializedName("p_image")
        @Expose
        public String pImage;

        public Id_ getId() {
            return id;
        }

        public void setId(Id_ id) {
            this.id = id;
        }

        public Long getAid() {
            return aid;
        }

        public void setAid(Long aid) {
            this.aid = aid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getTemplateStyle() {
            return templateStyle;
        }

        public void setTemplateStyle(Integer templateStyle) {
            this.templateStyle = templateStyle;
        }

        public Covers_ getCovers() {
            return covers;
        }

        public void setCovers(Covers_ covers) {
            this.covers = covers;
        }

        public String getPName() {
            return pName;
        }

        public void setPName(String pName) {
            this.pName = pName;
        }

        public String getPImage() {
            return pImage;
        }

        public void setPImage(String pImage) {
            this.pImage = pImage;
        }

    }

    public class Meta {

        @SerializedName("code")
        @Expose
        public Integer code;
        @SerializedName("message")
        @Expose
        public String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }




}
