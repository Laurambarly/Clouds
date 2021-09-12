package weather;

import java.util.ArrayList;

public class Sky {
	private ArrayList<Cloud> clouds;

	public Sky() {
		clouds = new ArrayList<Cloud>(100);
	}

	public boolean add(Cloud c) {
		clouds.add(c);
		return true;

	}

	public float getMeanHeight() {
		float total = 0;
		for (int i = 0; i < clouds.size(); i++) {
			total += clouds.get(i).getHeight();
		}
		return total / clouds.size();
	}

	public static void main(String[] args) {
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");

		Sky sky = new Sky();
		sky.add(strat);

		float mean = sky.getMeanHeight();
		if (mean < 899 || mean > 901)
			System.out.println("Bad mean height: expected 900, saw " + mean);
		System.out.println("Everything (else) is ok");

		// CumulusCloud added
		CumulusCloud cumul = new CumulusCloud(500, 600);
		if (!cumul.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");

		// CirrusCloud added

		CirrusCloud cirrus = new CirrusCloud(400, 800);
		if (cirrus.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");

	}

}
