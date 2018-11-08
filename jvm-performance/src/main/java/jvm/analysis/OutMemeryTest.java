package jvm.analysis;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xms64m -Xmx64m -XX:PermSize=8m -XX:MaxPermSize=8m -XX:-HeapDumpOnOutOfMemoryError
 */
public class OutMemeryTest {

    List<DataObject> list = new ArrayList<DataObject>();

    public void testOm(){
        for (int i = 0; i < 100000; i++) {
            DataObject data = new DataObject("id&"+i, "des:"+i);
            list.add(data);
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        OutMemeryTest omt = new OutMemeryTest();
        for (int i = 0; i < 2; i++) {
            omt.testOm();
        }
        System.out.println("DOne!");
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据对象
     * @author zas
     */
    class DataObject {
        //数据对象ID
        private String id;
        //数据对象内容
        private String des;

        public DataObject(String id, String des) {
            super();
            this.id = id;
            this.des = des;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        @Override
        public String toString() {
            return "DataObject [id=" + id + ", des=" + des + "]";
        }

    }

}
