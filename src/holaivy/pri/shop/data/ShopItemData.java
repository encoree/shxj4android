package holaivy.pri.shop.data;

public class ShopItemData {
	private String l; // 标题
	private String p; // 价格
	private String c; // 描述
	private int i; // 图片资源
	private String f;// 图片文件
	private String id;
	private boolean y;// 是否含邮费

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

}
