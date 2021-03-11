
public class Dusman extends Karakter {

	private int dusmanId;
	
	private String dusmanAdi;
	
	private DusmanTip dusmanTur;

	public Dusman() {}
	
	public Dusman(DusmanDavranis dusmanDavranis,int dusmanId, String dusmanAdi, DusmanTip dusmanTur,Lokasyon lokasyon) {
		super(dusmanId,dusmanAdi,KarakterTip.Dusman,lokasyon);
		super.setDusmanDavranis(dusmanDavranis);
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

	@Override
	public void enKisaYol() {
		
		
	}
	
}
