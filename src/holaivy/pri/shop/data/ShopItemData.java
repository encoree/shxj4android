package holaivy.pri.shop.data;

import java.io.Serializable;

public class ShopItemData implements Serializable {
	private static final long serialVersionUID = 7844058966551977067L;
	private String l; // 标题
	private String p; // 价格
	private String punit;// 价格单位

	private String c; // 描述
	private int i; // 图片资源
	private String f;// 图片文件
	private String id;
	private boolean y;// 是否含邮费

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isY() {
		return y;
	}

	public void setY(boolean y) {
		this.y = y;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getF() {
		return f;
	}

	public void setF(String f) {
		this.f = f;
	}

	public String getPunit() {
		return punit;
	}

	public void setPunit(String punit) {
		this.punit = punit;
	}
}
