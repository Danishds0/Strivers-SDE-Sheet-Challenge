
Convert 2D List to 2D Array
int[][] resultArray = list.stream().map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

Convert 2D Array to 2D List
List<List<Integer>> list = Arrays.stream(resultArray).map(row -> Arrays.asList(row)).collect(Collectors.toList());