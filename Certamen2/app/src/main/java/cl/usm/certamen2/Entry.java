package cl.usm.certamen2;

/**
 * Created by Andreas on 30.09.2016.
 */

public class Entry {

    private int iD;
    private String title;
    private String description;
    private String update_date;
    private String urladdress;
    private String notfound;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getUrladdress() {
        return urladdress;
    }

    public void setUrladdress(String urladdress) {
        this.urladdress = urladdress;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNotfound() {
        return notfound;
    }

    public void setNotfound(String notfound) {
        this.notfound = notfound;
    }
}
