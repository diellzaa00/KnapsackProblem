package ai;

public  class CalculateTotalValueAndSize {
		public int[] calculateTotalValueAndSize(int[] packing, int[] values, int[] sizes, int max_size) {
	        double totalValue = 0.0;
	        double totalSize = 0.0;

	        for (int i = 0; i < packing.length; i++) {
	            if (packing[i] == 1) {
	                totalValue += values[i];
	                totalSize += sizes[i];
	            }
	        }
	        
	        if (totalSize > max_size) {
	            totalValue = 0.0;
	        }
	        

	        return new int[]{(int) totalValue, (int) totalSize};
	    }
}
