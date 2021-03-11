
public class Altın extends Obje {
	
	private int sayi = 5;
	
	private int puan = 5;
	
    private int maksSure = 10;
	
	private int beklemeSure = 5;

	public Altın() {
		super();
	}
	

	public Altın(int sayi, int puan, int maksSure, int beklemeSure) {
		super();
		this.sayi = sayi;
		this.puan = puan;
		this.maksSure = maksSure;
		this.beklemeSure = beklemeSure;
	}


	public int getSayi() {
		return sayi;
	}

	public void setSayi(int sayi) {
		this.sayi = sayi;
	}

	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}

	public int getMaksSure() {
		return maksSure;
	}

	public void setMaksSure(int maksSure) {
		this.maksSure = maksSure;
	}

	public int getBeklemeSure() {
		return beklemeSure;
	}

	public void setBeklemeSure(int beklemeSure) {
		this.beklemeSure = beklemeSure;
	}

	
}
