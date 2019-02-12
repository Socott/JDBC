package entity;

public class Category {
    private int catid;
    private int moduleid;
    private String catname;
    private int parentid;
    private String arrparentid;

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getModuleid() {
        return moduleid;
    }

    public void setModuleid(int moduleid) {
        this.moduleid = moduleid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getArrparentid() {
        return arrparentid;
    }

    public void setArrparentid(String arrparentid) {
        this.arrparentid = arrparentid;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catid=" + catid +
                ", moduleid=" + moduleid +
                ", catname='" + catname + '\'' +
                ", parentid=" + parentid +
                ", arrparentid='" + arrparentid + '\'' +
                '}';
    }
}
