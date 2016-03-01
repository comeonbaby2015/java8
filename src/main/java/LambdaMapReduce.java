import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/1/6.
 * java8中最受人期待的就是lambda，引入了map和reduce。map和reduce可以构成几乎所有的函数式操作
 */
public class LambdaMapReduce {
    public static void main(String[] args) {
        //1 map 映射
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
//        List<Integer> numbers2 = numbers.stream()
//                .map(num->num*2)
//                .collect(Collectors.toList());
//        numbers2.forEach(num2-> System.out.println("num2:"+num2));

        //2 map:以搞成其他的类型，初始List是Integer，也可以变成String
//        List<String> numberIndex = numbers.stream()
//                .map(number -> "#" + number)
//                .collect(Collectors.toList());
//        numberIndex.forEach(ni -> System.out.println("ni:" + ni));

        //3 reduce 折叠 合并 简化
        //使用初始值的reduce，因为提供了初始值，所以返回值不再是Optional
        //reduce并不是一种新的操作，在SQL中我们用的一些聚集函数比如sum，avg，count等他们实际上也是reduce操作
//        Integer sum = numbers.stream()
//                .reduce(0, (a, b) -> a + b);
//        System.out.println("sum:" + sum);


    }
}
