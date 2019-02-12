package entity;

public class Company {
	private String username;
	private String company;
	private String keyword;
	private String address;
	private String telephone;
    private String fax;
    private String catid;
    private String catids;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getCatids() {
        return catids;
    }

    public void setCatids(String catids) {
        this.catids = catids;
    }

    @Override
    public String toString() {
        return "Company{" +
                "username='" + username + '\'' +
                ", company='" + company + '\'' +
                ", keyword='" + keyword + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", catid='" + catid + '\'' +
                ", catids='" + catids + '\'' +
                '}';
    }

}
