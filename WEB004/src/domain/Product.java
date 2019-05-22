package domain;

import java.util.Locale.Category;
import java.util.UUID;

/**
 *
 * 商品
 * @author Administrator
 * @date 2017/12/13
 */
public class Product {

    /**
     * 商品id
     */
    private String pid;
    /**
     * 商品名称
     */
    private String pname;
    /**
     *市场价格
     */
    private double market_price;
    /**
     *商店价格
     */
    private double shop_price;
    /**
     *商品图片地址
     */
    private String pimage;
    /**
     *上架时间
     */
    private String pdate;
    /**
     *是否热门
     */
    private int is_hot;
    /**
     *商品描述
     */
    private String pdesc;
    /**
     *是否下架的标记
     */
    private int pflag;
    /**
     *类别的对象
     */
    private String cid;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", pimage=" + pimage + ", pdate=" + pdate + ", is_hot=" + is_hot + ", pdesc=" + pdesc
				+ ", pflag=" + pflag + ", cid=" + cid + "]";
	}

    
}
