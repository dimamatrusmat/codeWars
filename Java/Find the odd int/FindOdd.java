public class FindOdd {
	public static int findIt(int[] a) {
    int odd = 0;
    int lenf = a.length;
    
    for (int i = 0; i < lenf; i++) {
      int counter = 0;
      int a1 = a[i];
      
      for (int q: a){
        if (a1 == q) {
          counter++;
        }
      }
      
      if (counter % 2 != 0) {
        odd = a1;
      }
    }
    
  	return odd;
  }
}