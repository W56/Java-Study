class MyArray{
	public static int getMax(int a[]) {
		int maxn = -1;
		for(int i=0;i<a.length;i++) {
			if(maxn<a[i]) {
				maxn = a[i];
			}
		}
		return maxn;
	}
	
	public static void selectSort(int a[]) {
		for(int i=0;i<a.length-1;i++) {
			int t = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[t] > a[j]) {
					t = j;
				}
			}
			if(t!=i) {
				int temp = a[t];
				a[t] = a[i];
				a[i] = temp;
			}
		}
	}
}


public class Test3 {

	public static void main(String[] args) {
		
		int a[] = {1,54,21,4,75,5,6,98};
		System.out.println("max num in array a is "+ MyArray.getMax(a));
		MyArray.selectSort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}

}
