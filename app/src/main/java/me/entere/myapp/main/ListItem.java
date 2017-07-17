package me.entere.myapp.main;

/**
 * Created by entere on 17/6/30.
 */

public class ListItem {
    public int viewType;
    public int itemId;
    public String title;
    public int imageRes;
    public String category;
    public String activityClassName;



    public ListItem(int viewType, int itemId, String title, int imageRes, Class<?> clazz) {
        this.viewType = viewType;
        this.itemId = itemId;
        this.title = title;
        this.imageRes = imageRes;
        this.activityClassName = clazz.getName();


    }

    public ListItem(int viewType, int itemId,String category) {
        this.viewType = viewType;
        this.itemId = itemId;
        this.category = category;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActivityClassName() {
        return activityClassName;
    }

    public void setActivityClassName(Class<?> clazz) {
        this.activityClassName = clazz.getName();
    }



    Class<?> getActivityClass() {
        try {
            return Class.forName(activityClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
