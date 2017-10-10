package com.day15_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashMapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
		HashMap<String,HashMap<String,String>>  czbk =new HashMap<String,HashMap<String,String>>();
		
		HashMap<String,String>  yuyeban =new HashMap<String,String>();
		HashMap<String,String>  jiuyeban=new HashMap<String,String>();
		
		czbk.put("yuye",yuyeban);
		czbk.put("jiuye",jiuyeban);
		
		yuyeban.put("01", "zhangsan1");
		yuyeban.put("02", "zhangsan2");
		
		jiuyeban.put("01", "lisi1");
		jiuyeban.put("02", "lisi2");
		
		
//		getStudentInfo(yuyeban);
//		getStudentInfo(jiuyeban);
		
		Iterator<String> it2 = czbk.keySet().iterator();
		while(it2.hasNext())
		{
			String roomName =it2.next();
			System.out.println(roomName);
			HashMap<String,String>  roomMap =czbk.get(roomName);
			getStudentInfo(roomMap);
			
		}
		*/

        demo();
    }

    public static void getStudentInfo(HashMap<String, String> roomMap) {
        Iterator<String> it = roomMap.keySet().iterator();
        while (it.hasNext()) {
            String id = it.next();
            String name = roomMap.get(id);
            System.out.println(id + "--" + name);
        }
    }


    public static void demo() {
        HashMap<String, List<Student>> czbk = new HashMap<String, List<Student>>();
        List<Student> yuye = new ArrayList<Student>();
        List<Student> jiuye = new ArrayList<Student>();
        czbk.put("yuyeban", yuye);
        czbk.put("jiuyeban", jiuye);

        yuye.add(new Student("zhangsan1", 13));
        yuye.add(new Student("zhangsan2", 14));

        jiuye.add(new Student("lisi1", 22));
        jiuye.add(new Student("lisi2", 23));

        Iterator<String> it = czbk.keySet().iterator();

        while (it.hasNext()) {
            String roomName = it.next();
            List<Student> room = czbk.get(roomName);
            System.out.println(room);
            getInfo(room);

        }


    }

    public static void getInfo(List<Student> stu) {
        Iterator<Student> it = stu.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s);
        }
    }

}
