package encapsulation;

public class Contac600 {
	private SnivelCapsule sni;
	private SneezeCapsule snz;
	private SnuffleCapsule snf;
	
	public Contac600() {
//		sni = SnivelCapsule();
//		snz = SneezeCapsule();
//		snf = SnuffleCapsule(); 
	}
	
	
	public void take() {
		sni.take();
		snz.take();
		snz.take();
	}

}
