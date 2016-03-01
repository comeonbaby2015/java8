/**
 * Created by Administrator on 2016/1/14.
 * 首先：system.gc()并不是你调用就马上执行的， 而是根据虚拟机的各种算法来来计算出执行垃圾回收的时间，另外，程序自动结束时不会执行垃圾回收的。
 其次：对象被回收时，要经过两次标记，第一次标记，如果finalize被重写，或者finalize被调用过，那么垃圾回收并不会去执行finalize，第二次标记，如果对象不能在finalize中成功拯救自己，那真的就要被回收了

 这里说得比较简单，要想深入理解，请参见《深入理解java虚拟机+jvm高级特性与最佳实践》中的垃圾收集器与内存分配策略
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC gc = null;

    public static void isAlive() {
        System.out.println("yes,i am alive!!!");
    }

    public static void isDead() {
        System.out.println("no, i am dead!!!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method is executed!!!");
        gc = this;
    }

    public static void main(String[] args) throws Throwable {
        gc = new FinalizeEscapeGC();
        gc = null;
        System.gc();
        Thread.sleep(500);
        if (gc != null)
            isAlive();
        else
            isDead();

        gc = null;
        System.gc();
        Thread.sleep(500);
        if (gc != null)
            isAlive();
        else
            isDead();
    }
}
