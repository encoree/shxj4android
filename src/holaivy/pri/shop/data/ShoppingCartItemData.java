package holaivy.pri.shop.data;

/**
 * @author xubch@neusoft.com
 * 
 */
public class ShoppingCartItemData {
	private String id;
	private int num;
	private ShoppingPackType pack;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ShoppingPackType getPack() {
		return pack;
	}

	public void setPack(ShoppingPackType pack) {
		this.pack = pack;
	}

}
