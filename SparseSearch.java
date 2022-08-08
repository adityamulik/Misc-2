class SparseSearch {
    /*
     * Time Complexity: O(log n) Binary Search
     * Space Complexity: O(log n) for recursion stack space
     *
     */
    public static void main(String[] args) {
        String[] arr = {"for", "", "", "geeks", "", "", "ide",
                    "practice", "", "", "", "quiz"};
        String x = "geeks";
        int n = x.length();
        int index = sparseSearch(arr, x, n);
        if (index != -1) {
            System.out.println(x+ " found at index "+index);
        } else {
            System.out.println(x+" not found");
        }
    }
    
    public static int sparseSearch(String[] arr, String x, int n) {
        return binarySearch(arr, 0, n-1, x);
    }
    
    public static int binarySearch(String[] arr, int low, int high, String s) {
        // base case
        if (low > high) {
            return -1;
        }
        
        // logic
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == "") {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left >= low && arr[left] != "") {
                    mid = left;
                    break;
                }
                
                if (right <= high && arr[right] != "") {
                    mid = right;
                    break;
                }
                
                left--;
                right++;
            }
        }
        
        if (arr[mid] == s) {
            return mid;
        } else if (s.compareTo(arr[mid]) < 0) {
            return binarySearch(arr, low, mid - 1, s);
        } else {
            return binarySearch(arr, mid+1, high, s);
        }
    }
}
