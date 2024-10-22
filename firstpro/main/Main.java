package firstpro.main;

import frame.FrameBase;
import frame.FrameHome;

public class Main {

	public static void main(String[] args) {
		FrameBase.getInstance(new FrameHome(null));

	}

}
