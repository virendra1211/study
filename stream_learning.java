final Map<String,List<String>> naturalIdVSFieldNameMap = inputRequest.getwork().stream().
        collect(Collectors.groupingBy(WorkReqTO::getNaturalId,
            Collectors.mapping(WorkReqTO::getFieldName,Collectors.toList())));
In the above: if you want to isolate list of object in key value pair then you can use groupBy

CollectionUtils.isNotEmpty(WorkExport.getAgencies())
        ? WorkExport.getAgencies().parallelStream().filter(Objects::nonNull).map(AgencyResponseTO::getName)
            .collect(Collectors.joining(delimiter))
			

========================================================
Below method is used to call maptoOrderTargets as a method like mapToOrderTargets(SalesTargetTO to) // input is stream itself as a parameter
list.getTargets().stream().map(this::mapToOrderTargets).collect(Collectors.toList();
// list.getTargets().stream() returning SalesTargetRequestTO
private SalesTargetRequestTO mapToOrderTargets(SalesTargetInputTO inputSalesTarget) {
    SalesTargetRequestTO salesTargetRequestTO = new SalesTargetRequestTO();
}
========================================================

Collect object value from collection
.stream().map(PSFieldModificationPermission::getId).collect(Collectors.toList()));

========================================================
    List<String> psFieldsThatAreNotFetchedS = psFieldsThatAreNotFetched.stream().map(Objects::toString).collect(Collectors.toList());

========================================================
inputPSFields.stream().anyMatch(psField -> Objects.isNull(psField.getId()) 
========================================================
 final Map<String, List<String>> naturalIdVSFieldNameMap = list.stream().collect(Collectors.groupingBy(WorkReqTO::getNaturalId, Collectors.mapping(WorkReqTO::getFieldName, Collectors.toList())));
========================================================
List<Employee> listOfEmployee = new ArrayList<Employee>();
		listOfEmployee.add(new Employee(1,"virendra",100));
		listOfEmployee.add(new Employee(5,"virendra3",1003));
		listOfEmployee.add(new Employee(4,"virendra2",1002));
		listOfEmployee.add(new Employee(7,"virendra1",1001));
		listOfEmployee.add(new Employee(8,"virendra8",1008));
		listOfEmployee.add(new Employee(9,"virendra9",1009));
		listOfEmployee.add(new Employee(3,"virendra91",10091));

		Map<Integer, Employee> orderIdVsOrderMap = listOfEmployee.stream()
				.collect(Collectors.toMap(Employee::getId, Function.identity()));
		orderIdVsOrderMap.forEach((p,q) ->{System.out.println(p+ " - "+q.getId()+" "+q.getName());});
OUTPUT:
1 - 1 virendra
3 - 3 virendra91
4 - 4 virendra2
5 - 5 virendra3
7 - 7 virendra1
8 - 8 virendra8
9 - 9 virendra9	
========================================================
	List<Integer> psFieldIdsToFetch;
    List<String> psFieldIdsToFetchStr = psFieldIdsToFetch.stream().map(Objects::toString).collect(Collectors.toList());

========================================================
List<LineItem> existingI;
    Set<String> naturalIds = existingI.stream().map(LineItem::getNaturalId).collect(Collectors.toSet());

========================================================
	List<Long> list1 = new ArrayList<>();
	list1.add((long) 34);
	list1.add((long) 3);
	list1.add((long) 6);
	String joinStringWithComma = list1.stream().map(String::valueOf).collect(Collectors.joining(","));
	System.out.println(joinStringWithComma);
	OUTPUT: 34,3,6
	
	Other way around: list1.parallelStream().collect(Collectors.joining(Constants.COMMA))
========================================================
Map<String, Order> myMap;
myMap.putAll(orders.stream().collect(Collectors.toMap(Order::getId, Function.identity())));

========================================================
List<Order> orders
      List<Work> Works = orders.stream().flatMap(order -> order.getWorks().stream())
          .collect(Collectors.toList());
========================================================
  List<Order> existingOrders ;
      Map<String, Work> existingWork = existingOrders.stream().map(Order::getWorks)
          .flatMap(Collection::stream).collect(Collectors.toMap(Work::getId, Function.identity()));
========================================================
isNotBlank - is a function
paramsList.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(Constants.UNDERSCORE))
 public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }
========================================================
// revert integer array without sorting 
	int temp[] = {3,2,1,6,9};
	Stream<Integer> s = IntStream.range(0, temp.length).mapToObj(i -> temp[temp.length - i - 1]);
	s.forEach(System.out::println);
========================================================
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("b", 200);		map.put("a", 500);map.put("e", 220);map.put("c", 540);map.put("h", 300);map.put("g", 350);

		List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

		/** I way **/
		Map<String, Integer> sortedMapWithValue = map.entrySet().stream()
				.sorted((p1, p2) -> p1.getValue().compareTo(p2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o,n) ->o,LinkedHashMap::new));
		System.out.println("sortedMapWithValue " + sortedMapWithValue);
		
		/** II way **/
		Collections.sort(sortedList,(p1,p2) -> p1.getValue().compareTo(p2.getValue()));
		
		sortedList.forEach(System.out::println);
		System.out.println(map);
		System.out.println(" ========================== ");

		/** III way **/
		Map<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldvalue, newvalue) -> oldvalue, LinkedHashMap::new));
		 	
		  
		  map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, 
		  Map.Entry::getValue, (o,n) ->  o,LinkedHashMap::new));
		  //System.out.println(sortedMap);
========================================================

========================================================

========================================================
