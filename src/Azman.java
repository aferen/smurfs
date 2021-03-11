
public class Azman extends Dusman {

	private DusmanDavranis dusmanDavranıs;

	public Azman(DusmanDavranis dusmanDavranis, int dusmanId, String dusmanAdi, Lokasyon lokasyon) {
		super(dusmanDavranis,dusmanId,dusmanAdi,DusmanTip.Dusman2,lokasyon);
		this.dusmanDavranıs = dusmanDavranis;
	}
}
