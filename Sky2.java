// I discussed some issues I was having with the method add with some of my classmates in discord
//(not sure about their real names) 

package weather;

import java.util.ArrayList;

public class Sky2 extends ArrayList<Cloud> {
	public Sky2() {
		super(100);
	}

	public float getMeanHeight() {
		float total = 0;

		for (int i = 0; i < size(); i++) {
			total += this.get(i).getHeight();
		}
		return total / this.size();
	}

	public boolean add(Cloud c) {
		super.add(c);
		return true;
	}

	public static void main(String[] args) {
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");

		Sky2 skyTwo = new Sky2();
		skyTwo.add(strat);

		float mean = skyTwo.getMeanHeight();
		if (mean < 899 || mean > 901)
			System.out.println("Bad mean height: expected 900, saw " + mean);
		System.out.println("Everything (else) is ok");

		// CumulusCloud added
		CumulusCloud cumul = new CumulusCloud(500, 600);
		if (!cumul.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");

		skyTwo.add(cumul);
		mean = skyTwo.getMeanHeight();//size 2 (900+100)/2
		if (mean < 499 || mean > 501)
			System.out.println("Bad mean height: expected 500, saw " + mean);
		System.out.println("Everything (else) is ok");

		// CirrusCloud added
		CirrusCloud cirrus = new CirrusCloud(400, 800);
		if (cirrus.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");

		skyTwo.add(cirrus);
		mean = skyTwo.getMeanHeight();
		if (mean < 465 || mean > 467)
			System.out.println("Bad mean height: expected 466, saw " + mean);
		System.out.println("Everything (else) is ok");
		
		Nimbus myNimb = new Nimbus(1000);

	}
}
