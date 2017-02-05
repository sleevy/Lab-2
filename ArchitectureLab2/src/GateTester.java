
public class GateTester
{

	public static void main(String[] args)
	{
		System.out.println("Testing And Gate");
		testAndGate();
		System.out.println("\nTesting Or Gate");
		testOrGate();
		System.out.println("\nTesting Not Gate");
		testNotGate();
		System.out.println("\nTesting XOr Gate");
		testXOrGate();
		System.out.println("\nTesting Half Adder");
		testHalfAdder();
		System.out.println("\nTesting Full Adder");
		testFullAdder();
		System.out.println("\nTesting ALU");
		int A = 4;
		int B = 7;
		testALU(4,A,B);
//		System.out.println();
//		testALU(4,B,A);
	}

	public static void testALU(int bits, int A, int B) {
		ALU alu = new ALU(bits);
		
		alu.setInputs(intToBools(A), intToBools(B), false);
		alu.execute();
//		System.out.println(boolsToInt(alu.getSums()) + ":" + alu.getOverflow());
//		for(boolean b: intToBools(B)) {
//			System.out.print(b);
//		}
//		System.out.println();
		//expected: (1)0011
		System.out.println(Integer.toBinaryString(A)+ (alu.getOp() ? " - ":" + ") + Integer.toBinaryString(B) + " = " /*+ alu.getSign()*/ + (alu.getOverflow() ? "(1)":"(0)") + boolsToBinString(alu.getSums()));
		
//		System.out.println();
		
		alu.setInputs(intToBools(A), intToBools(B), true);
		alu.execute();
//		System.out.println(boolsToInt(alu.getSums()) + ":" + alu.getOverflow());
		//expected: (0)1011 or (1)1011 depending on if A is 15
		System.out.println(Integer.toBinaryString(A)+ (alu.getOp() ? " - ":" + ") + Integer.toBinaryString(B) + " = " /*+ alu.getSign()*/ + (alu.getOverflow() ? "(1)":"(0)") + boolsToBinString(alu.getSums()));
		
	}
	
	public static boolean[] intToBools(int in) {
		String bString = Integer.toBinaryString(in);
		boolean[] out = new boolean[bString.length()];
		for(int i = 0; i < bString.length(); i++) {
			out[bString.length()-1-i] = (bString.charAt(i) == '1');
		}
		
		return out;
	}
	
	public static String boolsToBinString(boolean[] bools) {
		String out = "";
		for(int i = 0; i < bools.length; i++) {
			out = (bools[i] ? "1":"0") + out;
		}
		return out;
	}
	
	public static int boolsToInt(boolean[] bools) {
		int out = 0;
		
		for(int i = 0; i < bools.length; i++) {
			if(bools[i]) {
				out += Math.pow(2, i);
			}
		}
		
		return out;
	}
	
	public static void testFullAdder() {
		FullAdder fa = new FullAdder();
		for(int i = 0; i < 8; i++) {
			fa.setInputs(((i & 4) == 4), ((i & 2) == 2), ((i & 1) == 1));
//			System.out.println((fa.getA() ? 1:0) + "," + (fa.getB() ? 1:0) + "," + (fa.getC() ? 1:0));
			fa.execute();
			fa.print();
		}
	}
	
	public static void testHalfAdder() {
		HalfAdder half = new HalfAdder();
		half.test();
	}
	
	public static void testXOrGate() {
		XOrGate bob = new XOrGate();
		boolean t = true;
		
		bob.setInputs( t, t);
		bob.execute();
		bob.print();
		
		bob.setInputs( t,!t);
		bob.execute();
		bob.print();
		
		bob.setInputs(!t, t);
		bob.execute();
		bob.print();
		
		bob.setInputs(!t,!t);
		bob.execute();
		bob.print();
	}
	
	public static void testNotGate() {
		NotGate notty = new NotGate();
		
		notty.setInput(true);
		notty.execute();
		notty.print();
		
		notty.setInput(false);
		notty.execute();
		notty.print();
	}
	
	public static void testOrGate() {
		OrGate orry = new OrGate();
		boolean t = true;
		
		orry.setInputs( t, t);
		orry.execute();
		orry.print();
		
		orry.setInputs( t,!t);
		orry.execute();
		orry.print();
		
		orry.setInputs(!t, t);
		orry.execute();
		orry.print();
		
		orry.setInputs(!t,!t);
		orry.execute();
		orry.print();
	}
	
	public static void testAndGate() {
		AndGate andy = new AndGate();
		andy.setInputs(true, true);
		andy.execute();
		andy.print();
		
		andy.setInputs(true, false);
		andy.execute();
		andy.print();
		
		andy.setInputs(false, true);
		andy.execute();
		andy.print();
		
		andy.setInputs(false, false);
		andy.execute();
		andy.print();
	}
}
