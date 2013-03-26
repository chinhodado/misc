public class FallingDisk {
  
  public static int falling_disks(int[] A, int[] B){
		int result = 0;
		boolean[] wellTemp = new boolean[A.length];
		boolean wellCovered = false;
		
		for (int i = 0; i<B.length; i++){//for each disk
			if (!wellCovered) {
				boolean stuck = false;
				int currentPlaceInWell = -1;
				if (B[i]>A[0]) wellCovered = true;
				if (!wellCovered) {
					for (int j = 0; (j < A.length) && (!stuck); j++) {
						if (!getThrough(i, j, A, B, wellTemp)) {
							stuck = true;
						} else
							currentPlaceInWell = j;
					}
					if (currentPlaceInWell != -1)
						wellTemp[currentPlaceInWell] = true;//place disk in well
				}
			} else break;
		}
		
		//get result
		for (int i=0; i<wellTemp.length; i++){
			if (wellTemp[i]) result++; 
		}
		return result;
	}
	
	public static boolean getThrough(int i,int j, int[]well, int[] disk, boolean[] wellTemp){
		boolean flag = true;
		if (wellTemp[j]) flag = false;
		if (disk[i]>well[j]) flag=false;		
		return flag;
	}
}
