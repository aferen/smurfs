
public class Gargamel extends Dusman {
	
	private DusmanDavranis dusmanDavranıs;

	public Gargamel(DusmanDavranis dusmanDavranis, int dusmanId, String dusmanAdi, Lokasyon lokasyon) {
		super(dusmanDavranis,dusmanId,dusmanAdi,DusmanTip.Dusman1,lokasyon);
		this.dusmanDavranıs = dusmanDavranis;
	}


}
