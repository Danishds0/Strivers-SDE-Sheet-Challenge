
Convert 2D List to 2D Array
int[][] resultArray = list.stream().map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

Convert 2D Array to 2D List
List<List<Integer>> list = Arrays.stream(resultArray).map(row -> Arrays.asList(row)).collect(Collectors.toList());

To Soert 2D array in a increasing form
Arrays.sort(resultArray, (a, b) -> a[0] - b[0]);

To Soert 2D array in a increasing form
Arrays.sort(resultArray, (a, b) -> b[0] - a[0]);

Sum of all element in arrayList
int sum = arr.stream().reduce(0, Integer::sum);

Sum of all element in Array
int sum = arr.stream().sum();

Max in the integer in Array
int max = arr.stream().max().getAsInt();


lower Bound in a sorted array is nothing but smallest index such that arr[i] >= target (Binary search).

Upper Bound in a sorted array is nothing but arr[i] > target (Binary search).
 
