package java01;

public class Test25 {
  public static void main(String[] args) {

    int[] scores = new int[]{100,90,80};
    //배열에서 값은 순차적으로 꺼낸다.
    for(int i : scores){
      System.out.println(i);
    }
    System.out.println("----------------------------");
    java.util.ArrayList list= new java.util.ArrayList();
    list.add("홍길동");
    list.add(100);
    list.add(90);
    list.add(80);
    //collection 객체에 저장된 값을 순차적으로 하나씩 꺼낸다.
    for(Object value: list){
      System.out.println(value);
    }
    
  }

}
