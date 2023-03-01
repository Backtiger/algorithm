public class Sort {
    public static void main(String[] args) {
        class Sortlist
        {
            // idx1 = 작은 바꿀 배열 idx2 큰수의 바꿀 배열
            public void swap(int []arr , int idx1, int idx2){
                int tmp = arr[idx1];
                arr[idx1]=arr[idx1];
                arr[idx2]=tmp;
            }
            //버블정렬 앞에 두자리를 비교하여 작은값은 앞으로 큰값은 뒤로 보내는 알고리즘
            // On^2
            public void bubbleSort(int arr[]){
                for (int i=0; i<arr.length-1; i++){
                    for(int j=0; j<arr.length-i-1;j++){
                        if(arr[j]>arr[j+1])
                            swap(arr,j,j+1);
                    }
                }
            }
            // 선택정렬 맨앞의 인덱스부터 차례대로 원소를 선택하여 비교해 정렬하는 알고리즘
            //arr[j]= 바로 다음인덱스
            //arrarr[minIdx] = 현재 인덱스
            //  O^2
            public void SelectSort(int[] arr){
                for(int i =0; i<arr.length-1; i++){
                    int minIdx=i;
                    for(int j=i+1; j<arr.length; j++){
                        //다음인덱스가 현재 보다 작으면 변수에 스왑의 큰인덱스에 j(다음인덱스)를넣는다
                        if(arr[j]<arr[minIdx]){
                            minIdx=j;                        }
                    }
                    swap(arr,i,minIdx);
                }
            }
            //삽입정렬 인덱스 1의 원소부터 앞방향으로 들어갈 위치를 찾아 교환하는 알고리즘
            //tmp 비교할 값
            //O^2
            public void InsertSort(int arr[]){
                for(int i=1; i<arr.length;i++ ){
                    int tmp = arr[i];
                    int j=i-1;
                    while(j>=0 && tmp<arr[j]){
                        arr[j+1]=arr[j];
                        j--;
                    }
                    arr[j+1]=tmp;
                }
            }
            //셀정렬 *
            //삽입정렬의 장점을 살리고 단점을 보완
            //삽입정렬의 단점은 n-1번째 인덱스 원소의 들어갈 자리가 0번째 인덱스면 swap을 많이 해아함
            //간격을 정해 배열을 부분배열로 나눠 어느정도 정렬시키고 다시 간격을 줄여 정렬시키는것을 반복함
            // h 간격 1이 될때까지 반복문 진행
            //O^2
            public void ShellSort(int arr[]){
                for(int h = arr.length/2; h>0; h/=2){
                    for(int i=h; i<arr.length;i++){
                        int tmp = arr[i];
                        int j=i-h;
                        while (j>=0&&arr[j]>tmp){
                            arr[j+h]=arr[j];
                            j-=h;
                        }
                        arr[j+h]=tmp;
                    }
                }
            }

            public void SortByMergeSort(int[] arr){
                int[] tmpArr= new int [arr.length];
            }
            public void mergeSort(int[] arr,int[] tmpArr, int left, int right){
                if(left<right){
                    int m = left+(right -left)/2;
                    mergeSort(arr,tmpArr,left,m);
                    mergeSort(arr,tmpArr,m+1,right);

                }
            }
            public void merge(int[]arr,int[]tmpArr, int left,int mid, int right){
                for(int i =left; i<=right; i++){
                    tmpArr
                }
            }

        }
    }
}
