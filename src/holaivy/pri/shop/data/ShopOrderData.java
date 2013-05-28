package holaivy.pri.shop.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ShopOrderData {

	public ShopOrderData() {
		super();
	}

	private String oid;
	private String sid;
	private String sl;
	private String sp;
	private int num;
	private ShoppingPackType type;
	private Date ti = new Date();

	public Date getTi() {
		return ti;
	}

	public void setTi(Date ti) {
		this.ti = ti;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ShoppingPackType getType() {
		return type;
	}

	public void setType(ShoppingPackType type) {
		this.type = type;
	}

}
