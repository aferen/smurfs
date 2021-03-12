
public class Dusman extends Karakter {

	private int dusmanId;
	
	private String dusmanAdi;
	
	private DusmanTip dusmanTur;
	
	private DusmanDavranis dusmanDavranis;

	public Dusman() {}
	
	public Dusman(DusmanDavranis dusmanDavranis,int dusmanId, String dusmanAdi, DusmanTip dusmanTur,Lokasyon lokasyon) {
		super(dusmanId,dusmanAdi,KarakterTip.Dusman,lokasyon);
		this.dusmanDavranis = dusmanDavranis;
		this.dusmanId = dusmanId;
		this.dusmanAdi = dusmanAdi;
		this.dusmanTur = dusmanTur;
	}

	public int getDusmanId() {
		return dusmanId;
	}

	public void setDusmanId(int dusmanId) {
		this.dusmanId = dusmanId;
	}

	public String getDusmanAdi() {
		return dusmanAdi;
	}

	public void setDusmanAdi(String dusmanAdi) {
		this.dusmanAdi = dusmanAdi;
	}

	public DusmanTip getDusmanTur() {
		return dusmanTur;
	}

	public void setDusmanTur(DusmanTip dusmanTur) {
		this.dusmanTur = dusmanTur;
	}

	public DusmanDavranis getDusmanDavranis() {
		return dusmanDavranis;
	}

	public void setDusmanDavranis(DusmanDavranis dusmanDavranis) {
		this.dusmanDavranis = dusmanDavranis;
	}

	@Override
	public void enKisaYol() {
		
		
	}
	
}
