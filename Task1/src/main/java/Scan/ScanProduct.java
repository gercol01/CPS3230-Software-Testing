package Scan;

import org.openqa.selenium.WebElement;

public class ScanProduct {

    int alertType;
    String title;
    String desc;
    String currentUrl;
    String imageUrl;
    String userName;
    int price;

    public int getAlertType() {
        return alertType;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public int getPrice() {
        return price;
    }

    public void setAlertType(int alertType) {
        this.alertType = alertType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
