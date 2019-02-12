package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Mall_trads implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String company;
	private String areaname;
	private String province;
	private String catname;
	private String business;
	private String title;
	private String type;
	private String size;
	private String regist;
	private Integer num;
	private Integer amount;
	private Integer need;
	private Integer provide;
	private Integer supply;
	private Integer services;
	private Integer ask;
	private Integer down;
	private Integer express;
	private Integer finance;
	private Integer push;
	private String vip;
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getRegist() {
		return regist;
	}
	public void setRegist(String regist) {
		this.regist = regist;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getNeed() {
		return need;
	}
	public void setNeed(Integer need) {
		this.need = need;
	}
	public Integer getProvide() {
		return provide;
	}
	public void setProvide(Integer i) {
		this.provide = i;
	}
	public Integer getSupply() {
		return supply;
	}
	public void setSupply(Integer supply) {
		this.supply = supply;
	}
	public Integer getServices() {
		return services;
	}
	public void setServices(Integer services) {
		this.services = services;
	}
	public Integer getAsk() {
		return ask;
	}
	public void setAsk(Integer ask) {
		this.ask = ask;
	}
	public Integer getDown() {
		return down;
	}
	public void setDown(Integer down) {
		this.down = down;
	}
	public Integer getExpress() {
		return express;
	}
	public void setExpress(Integer express) {
		this.express = express;
	}
	public Integer getFinance() {
		return finance;
	}
	public void setFinance(Integer finance) {
		this.finance = finance;
	}
	public Integer getPush() {
		return push;
	}
	public void setPush(Integer push) {
		this.push = push;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public long  randomDate(String begin,String end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long s_time = 0;
		try {
			long b_time = sdf.parse(begin).getTime()/1000;
			long e_time = sdf.parse(end).getTime()/1000;
			int res = (int) (e_time-b_time);
			Random rand = new Random();
			s_time = (long)rand.nextInt(res)+b_time;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s_time;
	}
	
	
	public long  getStartTime(int amount) {
		long start_date = 0;
		if(amount>=1000000){
			if(amount>500000){
				start_date = randomDate("2015-5-1","2015-6-1");//开始交易时间
			}else{
				start_date = randomDate("2015-5-1","2015-12-31");
			}
		}else if(amount>=100000 && amount<1000000){
			if(amount > 850000){
                start_date = randomDate("2016-1-1","2016-1-31");
            }else{
                start_date = randomDate("2016-1-1","2016-12-31");
            }
		}else if (amount>=25000 && amount<100000) {
		  if(amount > 85000){
		        start_date = randomDate("2017-1-1","2017-1-31");
		    }else{
		        start_date = randomDate("2017-1-1","2017-12-31");
		    }
		}else {
            if(amount > 10000){
                start_date = randomDate("2018-1-1","2018-1-31");
            }else if(amount == 0){
                start_date = randomDate("2018-1-1","2018-11-16");
            }else{
                start_date = randomDate("2018-1-1","2018-11-16");
            }
		}

	    return start_date;
		
	}
	@Override
	public String toString() {
		return "Mall_trads [id=" + id + ", company=" + company + ", areaname=" + areaname + ", province=" + province
				+ ", catname=" + catname + ", business=" + business + ", title=" + title + ", type=" + type + ", size="
				+ size + ", regist=" + regist + ", num=" + num + ", amount=" + amount + ", need=" + need + ", provide="
				+ provide + ", supply=" + supply + ", services=" + services + ", ask=" + ask + ", down=" + down
				+ ", express=" + express + ", finance=" + finance + ", push=" + push + ", vip=" + vip + ", status="
				+ status + "]";
	}
}
