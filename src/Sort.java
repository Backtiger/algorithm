public class Sort {


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
                            minIdx=j;
                        }
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

            //병합정렬
            //배열을 /2로 나뉜뒤 해당 배열끼리 서로 비교하여 정렬한 뒤 정렬이 끝나면 분할된 배열을 합병한다
            //tmpArr 임시저장 배열
            //arr 정렬할 배열
            //left 시작할 인덱스
            //right 마지막 인덱스
            // nlogn
            public static void sortByMergeSort(int[] arr) {
                int[] tmpArr = new int[arr.length];
                mergeSort(arr, tmpArr, 0, arr.length - 1);
            }
            public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
                if (left < right) {
                    int m = left + (right - left) / 2;
                    mergeSort(arr, tmpArr, left, m); // 분할한 첫번째 배열 정렬
                    mergeSort(arr, tmpArr, m + 1, right); // 분할한 두번째 배열 정렬
                    merge(arr, tmpArr, left, m, right); //분할한 양 배열을 합병
                }
            }
            public static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
                 for (int i = left; i <= right; i++) {
                    tmpArr[i] = arr[i]; // 임시 배열인 tmpArr에 배열 개수 할당
                }
                int part1 = left;
                int part2 = mid + 1;
                int index = left;
                while (part1 <= mid && part2 <= right) { // 각각의 분할한 배열의 끝까지 반복
                    if (tmpArr[part1] <= tmpArr[part2]) { //분할된 배열의 첫번째 자리들부터 서로비교 첫번째배열이 더 작으면
                        arr[index] = tmpArr[part1];      //더작은수를 진짜 배열에 순서대로할당
                        part1++;                         //인덱스 증가
                    } else {
                        arr[index] = tmpArr[part2];      //두번째 배열이 더 작으면 해당 값을 저장
                        part2++;                         //두번째배열 인덱스 증가
                    }
                    index++;                             //진짜 배열의 인덱스 증가
                }
                for (int i = 0; i <= mid - part1; i++) {  // 배열의 처음부터 끝까지 차례대로 할당 하는 로직
                    arr[index + i] = tmpArr[part1 + i];
                }
            }
            //힙정렬
            //오름차순 정렬일때 최대힙을 사용하는 정렬
            //
            public void SortByheap(int[] arr){
                for(int i=arr.length/2-1; i<arr.length;i++){
                    heapify(arr,i,arr.length-1);
                }
                for(int i = arr.length-1;i>=0;i--){
                    swap(arr,0,i);
                    heapify(arr,0,i-1);
                }
            }
            public void heapify(int[] arr, int parentIdx,int lastIdx){
                int leftChildIdx;
                int rightChildIdx;
                int largestIdx;

                while(parentIdx*2+1<=lastIdx){
                    leftChildIdx = (parentIdx*2)+1;
                    rightChildIdx=(parentIdx*2)+2;
                    largestIdx = parentIdx;

                    if(arr[leftChildIdx]>arr[largestIdx]){
                        largestIdx=leftChildIdx;
                    }

                    if(rightChildIdx<=lastIdx&&arr[rightChildIdx]>arr[largestIdx]){
                        largestIdx = rightChildIdx;
                    }

                    if(largestIdx!=parentIdx){
                        swap(arr,parentIdx,largestIdx);
                        parentIdx=largestIdx;
                    }else
                    {
                        break;
                    }
                }
            }

            public void sortByQuickSort(int[] arr){
                quickSort(arr,0,arr.length-1);
            }
            public void quickSort(int[]arr ,int start,int last)
            {
                int part = partition(arr,start,last);
                if(start <part-1){
                    quickSort(arr,start,part-1);
                }
                if(part<last){
                    quickSort(arr,part,last);
                }
            }

            public int partition(int[]arr,int start,int last){
                int pivot = arr[(start+last)/2]; //첫번째 인덱스와 마지막인덱스의 중간값
                while (start<=last)
                {
                    while(arr[start]<pivot) //start인덱스의 값이 피벗보다 작으면 조건성립이므로 인덱스를 추가해 포인터 이동
                    {
                        start++;
                    }
                    while (arr[last]>pivot) //last인덱스의 값이 피벗보다 크면 true므로 포인터 이동
                    {
                        last--;
                    }
                    if(start<=last){//포인터끼리 서로 곂치지 않는다면 스왑
                        start++;
                        last--;
                        swap(arr,start,last);
                    }
                }
                return start;
            }
        }
    }

