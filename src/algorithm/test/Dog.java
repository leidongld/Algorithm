package algorithm.test;

/**
 * author: lllddd
 * created on: 2021/10/6 17:05
 * description:
 */
public class Dog {
    private int age;

    public Dog(int age) {
        this.age = age;
    }

    // 静态内怒雷不持有对外部类中成员变量的引用，因此能够较好地避免内存泄漏
    static class StaticBone {
        String color;

        public void showDetail() {
            System.out.println(color);
        }
    }

    // 内部类中持有了对外部类中成员变量的引用，因此易造成内存邪路
    class Bone {
        String color;

        public void showDetail() {
            System.out.println(color);
        }
    }
}
