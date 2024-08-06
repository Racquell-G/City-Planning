
public class CityPlanning {

	int [] [] footTraffic; //integer value for each block in a city
	
	public CityPlanning(int width, int length) {
		this.footTraffic = new int [width] [length];
		
		for (int i = 0; i < footTraffic.length; i++) {
			for (int k = 0; k < footTraffic [i].length; k++) {
		
			double randDecimal = Math.random();
			int randInt = (int) (Math.random() * 101);
				
			if (randDecimal < 0.2) {
					this.footTraffic [i] [k] = 0;
			} else {
				this.footTraffic [i] [k] = randInt;
				}
			}
		}	
	}

	public static void main(String[] args) {
		CityPlanning block = new CityPlanning(4, 4);
		block.printMap();
		System.out.println(block.calculateValue(0, 4));
		System.out.println(block.findBestLocation());

	}
	
	public void printMap() {

		for (int i = 0; i < footTraffic.length; i++) {
			for (int k = 0; k < footTraffic [i].length; k++) {
				if (footTraffic [i] [k] < 10) {
					System.out.print("0" + footTraffic [i] [k] + " ");
				} else {
					System.out.print(footTraffic [i] [k] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public String findBestLocation() {
		double storeCoordinate = 0;
		String result = "";
		
		for (int i = 0; i < footTraffic.length; i++) {
			for (int k = 0; k < footTraffic[i].length; k++) {
				if (footTraffic [i] [k] == 0){
					storeCoordinate = calculateValue(i, k);
					result = "(" + i + "," + k + ")";
					}
				if (calculateValue (i, k) >= storeCoordinate){
					storeCoordinate = calculateValue (i, k);
					}
				}
			}
		
		return result;
		}
	
	public double calculateValue(int row, int column) {
		double counter = 0;
		double  sum = 0;
		
		for (int i = 0; i < footTraffic.length; i++) {
			for (int k = 0; k < footTraffic [i].length; k++) {
				if (i == 0) {
					if (k == 0) {
						sum = footTraffic [i] [k+1] + footTraffic [i+1] [k] + footTraffic [i+1] [k+1]; //Top Left
						counter = 3;
					} else if (k == footTraffic[i].length-1) {
						sum = footTraffic [i] [k-1] + footTraffic [i+1] [k] + footTraffic [i+1] [k-1]; //Top Right
						counter = 3;
					} else {
						sum = footTraffic [i] [k-1] + footTraffic [i+1] [k-1] + footTraffic [i+1] [k] + footTraffic [i+1] [k+1] + footTraffic [i] [k+1]; //Top middle
						counter = 5;	
					}
				} else if (i == footTraffic.length-1){
					if (k == 0) {
						sum = footTraffic [i-1] [k] + footTraffic [i-1] [k+1] + footTraffic [i] [k+1]; //Bottom Left
						counter = 3;
					} 
					else if (k == footTraffic[i].length-1) {
						sum = footTraffic[i][k-1] + footTraffic[i-1][k] + footTraffic [i-1] [k-1]; //Bottom right corner
	                    counter = 3;
	                }
	                else{
	                    sum = footTraffic[i][k-1] + footTraffic[i-1][k] + footTraffic[i][k+1] + footTraffic [i-1] [k-1] +footTraffic [i-1] [k+1] ; //Bottom middle area
	                    counter = 5;
	                }
	            }
	            else if(k == 0){
	                sum = footTraffic[i-1][k] + footTraffic[i+1][k] + footTraffic[i][k+1] + footTraffic [i-1] [k+1] + footTraffic [i+1] [k+1]; //Middle left section
	                counter = 5;
	            }
	            else if(k == footTraffic[i].length-1){
	                sum = footTraffic[i-1][k] + footTraffic[i+1][k] + footTraffic[i][k-1] + footTraffic [i-1] [k-1] + footTraffic [i+1] [k-1]; //Middle right area
	                counter = 5;
	            }
	            else{
	                sum = footTraffic[i][k-1] + footTraffic[i-1][k] + footTraffic[i+1][k] + footTraffic[i][k+1] + footTraffic [i-1] [k-1] + footTraffic [i+1] [k-1] + footTraffic [i-1] [k+1] + footTraffic [i+1] [k+1]; //Middle interior
	                counter = 8;
	            		}
					}
				}
		return (sum)/counter;
	}

}
