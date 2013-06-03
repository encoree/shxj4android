package holaivy.pri.act.pcd;

import ivy.core.tool.Str;

import java.io.Serializable;

public class RegionData implements Serializable {
	private static final long serialVersionUID = -9158163464710869787L;
	private String province;
	private String city;
	private String addr;
	private String pcode;
	private String ccode;
	private String acode;

	private String zipcode;

	public boolean fine() {
		return Str.isNotEmpty(province) && Str.isNotEmpty(pcode)
				&& Str.isNotEmpty(acode) && Str.isNotEmpty(addr)
				&& Str.isNotEmpty(city) && Str.isNotEmpty(ccode);
	}

	public void putProvince(String code, String name) {
		ccode = city = null;
		addr = acode = null;
		pcode = code;
		province = name;
	}

	public void putCity(String code, String name) {
		addr = acode = null;
		ccode = code;
		city = name;
	}

	public void putAddr(String code, String name) {
		acode = code;
		addr = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getAcode() {
		return acode;
	}

	public void setAcode(String acode) {
		this.acode = acode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String warp2String() {
		StringBuilder buf = new StringBuilder();
		buf.append(province).append(city).append(addr);
		return buf.toString();
	}

}
