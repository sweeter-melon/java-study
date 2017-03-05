package µÚ16½²;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             int a[]={1,24,26,12,3,5};
             Test test=new Test();
             test.sort(a, 0, a.length); 
              
	}
	public  void sort(int a[],int pos ,int end){
		int first=pos;
		int last=end;
		int key=a[pos];
		while(last>first){
			if(last>first && key<=a[last]){
				last--;
			}
			a[first]=a[last];
			if(last>first && key>=a[first]){
				first++;
				
			}
			a[last]=a[first];
		}
		a[first]=key;
		sort(a,pos,first-1);
		sort(a,first+1,end);
	}
}

 